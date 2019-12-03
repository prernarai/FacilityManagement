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
    --
    primary key (ID)
);