package com.beyontec.mol.resource;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beyontec.mol.entity.UdsIdDefinition;
import com.beyontec.mol.entity.UdsProduct;
import com.beyontec.mol.modal.ConfigDTO;
import com.beyontec.mol.modal.GlobalDTO;
import com.beyontec.mol.service.ConfigService;
import com.beyontec.mol.util.AppConstants;

@RestController
@RequestMapping("/api/configs")
public class ConfigResource {
    @Autowired private ConfigService service;

    @Value("${date.format}") private String dateFormat;
    @Value("${env}") private String env;
    @Value("${show.logo}") private Boolean isShowLogo;

    @RequestMapping(method = RequestMethod.GET, path = "/udsProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UdsProduct> getAllUdsProducts() {
        List<UdsProduct> allUdsProducts = service.getAllUdsProducts();
        return allUdsProducts;
    }

    @GetMapping(value = "/global")
    public ResponseEntity<GlobalDTO> globalConfig() {

        GlobalDTO config = new GlobalDTO();
        config.setDateFormat(dateFormat.toUpperCase());
        config.setEnv(env);
        config.setShowLogo(isShowLogo);
        return ResponseEntity.ok(config);
    }

    @GetMapping(value = "/type/{type}")
    public ResponseEntity<List<ConfigDTO>> getConfigByType(@PathVariable("type") String type,
                                                                       @RequestParam(name = "limit", required = false) Integer limit,
                                                                       @RequestParam(name = "search", required = false) String searchStr,
                                                                       HttpServletRequest request) {

        boolean isEnglishLocale = (request.getLocale()
                                          .getLanguage()
                                          .equals(AppConstants.ENGLISH) ? Boolean.TRUE : Boolean.FALSE);

        List<UdsIdDefinition> configs = service.getConfigByType(type, limit, searchStr, isEnglishLocale);

        PropertyMap<UdsIdDefinition, ConfigDTO> propertyMap = null;
        if (isEnglishLocale) {
            propertyMap = new PropertyMap<UdsIdDefinition, ConfigDTO>() {
                @Override
                protected void configure() {
                    map().setId(source.getId().id);
                    map().setName(source.getUID_DESC());
                }
            };
        } else {
            propertyMap = new PropertyMap<UdsIdDefinition, ConfigDTO>() {
                @Override
                protected void configure() {
                    map().setId(source.getId().id);
                    map().setName(source.getUID_DESC_1());
                }
            };
        }

        ModelMapper modelMapper = new ModelMapper();
        Type targetListType = new TypeToken<List<ConfigDTO>>() {}.getType();
        modelMapper.addMappings(propertyMap);
        return ResponseEntity.ok(modelMapper.map(configs, targetListType));
    }

    @GetMapping(value = "workerType")
    public ResponseEntity<List<ConfigDTO>> getWorkerTypes(HttpServletRequest request) {

        boolean isEnglishLocale = (request.getLocale()
                                          .getLanguage()
                                          .equals(AppConstants.ENGLISH) ? Boolean.TRUE : Boolean.FALSE);

        List<UdsProduct> products = service.getWorkerTypes();

        PropertyMap<UdsProduct, ConfigDTO> propertyMap = null;
        if (isEnglishLocale) {
            propertyMap = new PropertyMap<UdsProduct, ConfigDTO>() {
                @Override
                protected void configure() {
                    map().setId(source.getId().UP_PROD_ID);
                    map().setName(source.getUP_PROD_NAME());
                }
            };
        } else {
            propertyMap = new PropertyMap<UdsProduct, ConfigDTO>() {
                @Override
                protected void configure() {
                    map().setId(source.getId().UP_PROD_ID);
                    map().setName(source.getUP_PROD_NAME_1());
                }
            };
        }

        ModelMapper modelMapper = new ModelMapper();
        Type targetListType = new TypeToken<List<ConfigDTO>>() {}.getType();
        modelMapper.addMappings(propertyMap);
        return ResponseEntity.ok(modelMapper.map(products, targetListType));
    }
}
