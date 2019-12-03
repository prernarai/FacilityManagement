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
);