package com.beyontec.mol.util;

public final class DMSConstants {

	// param variables
	public static final String ENTITY_REF_ID = "entityRefId";
	public static final String ENTITY_REF_TYPE = "entityRefType";
    public static final String REF_TYPE_CERTIFICATE = "Certificate";
	public static final String REF_TYPE_CLAIM = "Claim";
	public static final String GRID_FS_ID = "gridFSId";
	public static final String DOCUMENTS = "documents";
	public static final String METADATA = "metadata";
    public static final String DATA = "data";
    public static final String TEMPLATE = "template";
	public static final String PARTY_TYPE = "partyType";
	public static final String DOCUMENT_TYPE = "documentType";
	public static final String DESCRIPTION = "description";
	public static final String HTTP_HEADER = "httpHeader";
	public static final String DOCUMENT = "document";

	// uri
	public static final String UPLOAD_DOCUMENTS_URI = "/api/upload-multiple";
	public static final String GET_DOCUMENT_LIST = "/api/metadata?entityRefId={0}&entityRefType={1}";
	public static final String GET_DOCUMENT_CONTENT = "/api/document/{0}";
	public static final String DELETE_DOCUMENT_CONTENT = "/api/document/{0}";
    public static final String GENERATE_DOCUMENT = "/api/generate-document";
    public static final String GENERATE_DOWNLOAD_DOCUMENT = "/api/generate-download-document";

    //open office template
    public static final String TEMPLATE_CERTIFICATE = "certificate";
    public static final String TEMPLATE_REINSURER_OVERALL_UWS = "reinsurer_overall_uws";
    public static final String TEMPLATE_REINSURER_PARTICIPANT_UWS = "reinsurer_participant_uws";
    public static final String TEMPLATE_REINSURER_OVERALL_CLAIMS = "reinsurer_overall_claims";
    public static final String TEMPLATE_REINSURER_PARTICIPANT_CLAIMS = "reinsurer_participant_claims";
    public static final String TEMPLATE_POOLINSURER_OVERALL_CERTS = "poolinsurer_overall_certificates";
    public static final String TEMPLATE_POOLINSURER_INSURANCE_CERTS = "poolinsurer_insurance_certificates";
    public static final String TEMPLATE_POOLINSURER_OVERALL_CLAIMS = "poolinsurer_overall_claims";
    public static final String TEMPLATE_POOLINSURER_INSURANCE_CLAIMS = "poolinsurer_insurance_claims";
}
