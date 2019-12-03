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
);