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
    --
    primary key (ID)
);