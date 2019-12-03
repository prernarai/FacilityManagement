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
);