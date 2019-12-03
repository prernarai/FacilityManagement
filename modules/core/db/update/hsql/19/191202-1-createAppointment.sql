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
    END_DATE_TIME varchar(255),
    --
    primary key (ID)
);