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
);