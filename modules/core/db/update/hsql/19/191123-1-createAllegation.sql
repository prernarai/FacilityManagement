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
    --
    primary key (ID)
);