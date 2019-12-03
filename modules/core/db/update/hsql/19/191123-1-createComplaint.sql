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
    FACILITY_FILE_NUMBER varchar(255),
    TYPE_OF_FACILITY_ID integer,
    ADDRESS_LINE1 varchar(255),
    ADDRESS_LINE2 varchar(255),
    CITY varchar(255),
    ZIP varchar(255),
    STATE_ID integer,
    PHONE_NUMBER varchar(255),
    SOURCE_OF_COMPLAINT varchar(255),
    BUSINESS_KEY varchar(255),
    CONTROL_NUMBER varchar(255),
    --
    primary key (ID)
);