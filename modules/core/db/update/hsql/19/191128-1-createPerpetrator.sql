create table FACILITYMANAGEMENT_PERPETRATOR (
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
    RELATIONSHIP_TO_VICTIM_ID integer,
    RELATIONSHIP_TO_FACILITY_ID integer,
    --
    primary key (ID)
);