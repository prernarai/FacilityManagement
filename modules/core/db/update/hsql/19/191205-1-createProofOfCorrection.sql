create table FACILITYMANAGEMENT_PROOF_OF_CORRECTION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PROOF_TYPE_ID integer,
    PROVIDED_DATE date,
    DEFICIENCY_ID varchar(36),
    --
    primary key (ID)
);