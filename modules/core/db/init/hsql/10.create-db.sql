-- begin FACILITYMANAGEMENT_COMPLAINANT
create table FACILITYMANAGEMENT_COMPLAINANT (
    ID bigint not null,
    UUID varchar(36),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    ADDRESS_LINE1 varchar(255),
    ADDRESS_LINE2 varchar(255),
    CITY varchar(255),
    STATE varchar(255),
    ZIP_CODE varchar(255),
    PHONE_NUMBER varchar(255),
    EMAIL_ID varchar(255),
    RELATIONSHIP_WITH_FACILITY_ID integer,
    DOES_COMPLAINTANT_WANTS_TO_BE_CONFIDENTIAL_ID integer,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_COMPLAINANT
-- begin FACILITYMANAGEMENT_REFERENCE_VALUE
create table FACILITYMANAGEMENT_REFERENCE_VALUE (
    ID integer not null,
    UUID varchar(36),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LABEL varchar(255) not null,
    VALUE_ integer not null,
    REFERENCE_CODE_ID integer,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_REFERENCE_VALUE
-- begin FACILITYMANAGEMENT_REFERENCE_CODE
create table FACILITYMANAGEMENT_REFERENCE_CODE (
    ID integer not null,
    UUID varchar(36),
    --
    CODE varchar(255) not null,
    DESCRIPTION varchar(255) not null,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_REFERENCE_CODE
-- begin FACILITYMANAGEMENT_COMPLAINT
create table FACILITYMANAGEMENT_COMPLAINT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    IS_ABUSE_REPORT_REQUIRED_ID integer,
    IS_ABUSE_REPORT_FILED_ID integer,
    VISIT_DUE_DATE date,
    SOURCE_OF_COMPLAINT_ID integer,
    WHAT_HAPPENED longvarchar,
    DID_INCIDENT_TAKE_PLACE_IN_FACILITY_ID integer,
    OTHER_DETAILS_OF_LOCATION varchar(1000),
    BUSINESS_KEY varchar(255),
    FACILITY_ID varchar(36),
    REPORTING_PARTY_ID bigint,
    PRIORITY_ID integer,
    CURRENT_STATUS_ID integer,
    ASSIGNED_TO_ID varchar(36),
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_COMPLAINT
-- begin FACILITYMANAGEMENT_OBJECT_AND_TAGS
create table FACILITYMANAGEMENT_OBJECT_AND_TAGS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TAG_ID varchar(36) not null,
    RELATED_OBJECT_IF varchar(36) not null,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_OBJECT_AND_TAGS
-- begin FACILITYMANAGEMENT_ALLEGATION
create table FACILITYMANAGEMENT_ALLEGATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TYPE_ID integer,
    BUSINESS_KEY varchar(255),
    COMPLAINT_ID varchar(36),
    SHAPE_MARK_OF_INJURY varchar(255),
    OPEN_HAND_OR_CLOSED_FIST varchar(255),
    RECURRING_EVENT varchar(255),
    BODILY_INJURY_ID integer,
    QUALIFIER1_ID integer,
    QUALIFIER2_ID integer,
    RELATED_VICTIM_ID varchar(36),
    RELATED_PERP_ID varchar(36),
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_ALLEGATION
-- begin FACILITYMANAGEMENT_VICTIM
create table FACILITYMANAGEMENT_VICTIM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    DATE_OF_BIRTH date,
    WERE_THEY_IN_FACILITY_ID integer not null,
    CLIENT_NUMBER_ID varchar(36),
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_VICTIM
-- begin FACILITYMANAGEMENT_TAG
create table FACILITYMANAGEMENT_TAG (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LABEL varchar(255) not null,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_TAG
-- begin FACILITYMANAGEMENT_FACILITY
create table FACILITYMANAGEMENT_FACILITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CAPACITY varchar(255),
    ADDRESS_LINE1 varchar(255),
    ADDRESS_LINE2 varchar(255),
    CITY varchar(255),
    STATE_ID integer,
    ZIP varchar(255),
    BUSINESS_KEY varchar(255),
    LICENSE_DATE date,
    LICENSE_STATUS_ID integer,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_FACILITY
-- begin FACILITYMANAGEMENT_COMPLAINT_STATUS
create table FACILITYMANAGEMENT_COMPLAINT_STATUS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COMPLAINT_ID varchar(36),
    STATUS_ID integer,
    START_DATE date,
    END_DATE date,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_COMPLAINT_STATUS
-- begin FACILITYMANAGEMENT_CLIENT
create table FACILITYMANAGEMENT_CLIENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    DATE_OF_BIRTH date,
    BUSINESS_KEY varchar(255),
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_CLIENT
-- begin FACILITYMANAGEMENT_EVENT_TIME_LINE
create table FACILITYMANAGEMENT_EVENT_TIME_LINE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    OBJECT_KEY varchar(36) not null,
    OBJECT_TYPE_ID integer,
    EVENT_DATE date,
    EVENT_TYPE_ID integer,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_EVENT_TIME_LINE
-- begin FACILITYMANAGEMENT_CIENT_WITH_FACILITY
create table FACILITYMANAGEMENT_CIENT_WITH_FACILITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    START_DATE date,
    END_DATE date,
    FACILITY_ID varchar(36),
    CLIENT_ID varchar(36),
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_CIENT_WITH_FACILITY
-- begin FACILITYMANAGEMENT_PERPETRATOR
create table FACILITYMANAGEMENT_PERPETRATOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    RELATIONSHIP_TO_VICTIM_ID integer,
    RELATIONSHIP_TO_FACILITY_ID integer,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_PERPETRATOR
-- begin FACILITYMANAGEMENT_APPOINTMENT
create table FACILITYMANAGEMENT_APPOINTMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TOPIC varchar(255),
    WHO_IS_WORKER_ID varchar(36),
    VISITING_TO_ID varchar(36),
    START_DATE_TIME timestamp,
    END_TIME timestamp,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_APPOINTMENT
-- begin FACILITYMANAGEMENT_VISIT
create table FACILITYMANAGEMENT_VISIT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BUSINESS_KEY varchar(255),
    TYPE_OF_VISIT_ID integer,
    WAS_ANNOUNCED_ID integer,
    FACILITY_ID varchar(36),
    COMPLAINT_ID varchar(36),
    VISIT_DATE date,
    START_TIME time,
    END_TIME time,
    STATUS_ID integer,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_VISIT
-- begin FACILITYMANAGEMENT_TASK
create table FACILITYMANAGEMENT_TASK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    ASSIGNE_ID varchar(36),
    DESCRIPTION varchar(255),
    FOR_FACILITY_ID varchar(36),
    FOR_COMPLAINT_ID varchar(36),
    STATUS_ID integer,
    DUE_DATE date,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_TASK
-- begin FACILITYMANAGEMENT_DEFICIENCY
create table FACILITYMANAGEMENT_DEFICIENCY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SECTION_NUMBER_ID integer,
    COMMENTS varchar(255),
    POC varchar(255),
    DUE_DATE date,
    DATE_CORRECTED date,
    FOR_FACILITY_ID varchar(36),
    VISIT_IDENTIFIED_ID varchar(36),
    VISIT_CORRECTED date,
    DEFICIENCY_STATUS_ID integer,
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_DEFICIENCY
-- begin FACILITYMANAGEMENT_PROOF_OF_CORRECTION
create table FACILITYMANAGEMENT_PROOF_OF_CORRECTION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PROOF_TYPE_ID integer,
    PROVIDED_DATE date,
    DEFICIENCY_ID varchar(36),
    --
    primary key (ID)
)^
-- end FACILITYMANAGEMENT_PROOF_OF_CORRECTION
