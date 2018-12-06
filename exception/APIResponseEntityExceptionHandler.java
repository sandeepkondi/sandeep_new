package com.beyontec.mol.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.fileupload.FileUploadBase.SizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class APIResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(APIResponseEntityExceptionHandler.class);

	private final MessageSource messageSource;

	@Value("${spring.http.multipart.max-file-size}")
	private String fileSize;

	@Value("${spring.http.multipart.max-request-size}")
	private String totalFileSize;

	@Autowired
	public APIResponseEntityExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(ApplicationException.class)
    public final ResponseEntity<?> handleApplicationException(ApplicationException ex, WebRequest request) {
        if (! ex.hasError()) { return getLocalizedErrorMessage(ex, ex.getErrorCode(), request); }

        ex.getErrors().forEach(error -> {
            String errMsg = getErrorMessage(error.getCode(), error.getDataArr(), request.getLocale());
            error.setMessage(errMsg);
        });
        ex.printStackTrace(System.err);
        logger.error("", ex);
        HttpStatus responseStatusCode = getResponseStatus(ex.getResponseStatusCode());
        return new ResponseEntity<ErrorDetailResponse>(new ErrorDetailResponse(ex.getErrors()), responseStatusCode);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public final ResponseEntity<ErrorResponse> handleDBConstraintViolationException(DataIntegrityViolationException ex,
			WebRequest request) {
		return getLocalizedErrorMessage(ex, ErrorCode.DATABASE_CONSTRAINT_VIOLATION, request);
	}

	@ExceptionHandler(CannotCreateTransactionException.class)
	public final ResponseEntity<ErrorResponse> handleDBAccessException(CannotCreateTransactionException ex,
			WebRequest request) {
		return getLocalizedErrorMessage(ex, ErrorCode.DATABASE_ACCESS_ERROR, request);
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex, WebRequest request) {
		return getLocalizedErrorMessage(ex, ErrorCode.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler(MultipartException.class)
	public final ResponseEntity<ErrorResponse> handleMultipartException(MultipartException ex, WebRequest request) {

		if (ex.getCause().getCause() instanceof SizeLimitExceededException) {
			return getLocalizedErrorMessage(ex, ErrorCode.DOCUMENTS_BEYOND_LIMIT, new Object[] { totalFileSize },
					request);
		}
		return getLocalizedErrorMessage(ex, ErrorCode.DOCUMENT_BEYOND_LIMIT, new Object[] { fileSize }, request);
	}

	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<ErrorDetailResponse> handleValidationException(ValidationException ex,
			WebRequest request) {
        logger.error("", ex);

		List<ErrorDetail> errorDetails = new ArrayList<>();
		ErrorDetail errorDetail = null;

		for (Map.Entry<ErrorCode, Object[]> entry : ex.getErrorDetails().entrySet()) {

            errorDetail = new ErrorDetail(entry.getKey().getCode(),
                                          getErrorMessage(entry.getKey(),
                                                          entry.getValue(),
                                                          request.getLocale()));
			errorDetails.add(errorDetail);
		}

		return new ResponseEntity<ErrorDetailResponse>(new ErrorDetailResponse(errorDetails), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public final ResponseEntity<ErrorResponse> handleHttpClientErrorException(HttpClientErrorException ex,
			WebRequest request) {
		try {
			ErrorDetailResponse errorDetailResponse = new ObjectMapper().readValue(ex.getResponseBodyAsString(),
					ErrorDetailResponse.class);
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse(Arrays.asList(errorDetailResponse.getErrors().get(0).getMessage())),
					ex.getStatusCode());
		} catch (Exception e) {
			return getLocalizedErrorMessage(ex, ErrorCode.INVALID_REQUEST, request);
		}
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error("", ex);

		BindingResult result = ex.getBindingResult();
		List<String> errorMessages = result.getAllErrors().stream()
                                           .map(objectError -> getErrorMessage(objectError.toString(),
                                                                               request.getLocale()))
				.collect(Collectors.toList());
		return new ResponseEntity<Object>(new ErrorResponse(errorMessages), HttpStatus.BAD_REQUEST);
	}

	private ResponseEntity<ErrorResponse> getLocalizedErrorMessage(Exception ex, ErrorCode errorCode, Object[] arg,
			WebRequest request) {

        logger.error("", ex);
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(Arrays.asList(
                                                                                 getErrorMessage(errorCode,
                                                                                                 arg,
                                                                                                 request.getLocale()))),
				errorCode.getHttpStatus());
	}

	private ResponseEntity<ErrorResponse> getLocalizedErrorMessage(Exception ex, ErrorCode errorCode,
			WebRequest request) {
		return getLocalizedErrorMessage(ex, errorCode, null, request);
	}

    private static HttpStatus getResponseStatus(ResponseStatusCode statusCode) {

        // @formatter:off
        switch (statusCode) {

            case OK:                       return HttpStatus.OK;
            case CREATED:                  return HttpStatus.CREATED;
            case UPDATED:                  return HttpStatus.ACCEPTED;
            case DELETED:                  return HttpStatus.NO_CONTENT;
            case INVALID_REQUEST:          return HttpStatus.BAD_REQUEST;
            case NOT_AUTHENTICATED:        return HttpStatus.UNAUTHORIZED;
            case ACCESS_DENIED:            return HttpStatus.FORBIDDEN;
            case NOT_FOUND:                return HttpStatus.NOT_FOUND;
            case DUPLICATE:                return HttpStatus.CONFLICT;
            case UNSUPPORTED_FILE_FORMAT:  return HttpStatus.UNSUPPORTED_MEDIA_TYPE;
            default:                       return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        // @formatter:on
    }

    private String getErrorMessage(ErrorCode errorCode, Object[] args, Locale locale) {
        return getErrorMessage(errorCode.getCode(), args, locale);
    }

    private String getErrorMessage(String errorCode, Object[] args, Locale locale) {
        return messageSource.getMessage(errorCode, args, "", locale);
    }

    private String getErrorMessage(String errorCode, Locale locale) {
        return messageSource.getMessage(errorCode, null, locale);
    }
}
