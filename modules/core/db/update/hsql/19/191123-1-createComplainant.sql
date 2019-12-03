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
);