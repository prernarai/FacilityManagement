create table FACILITYMANAGEMENT_REFERENCE_VALUE (
    ID integer not null,
    UUID varchar(36),
    --
    LABEL varchar(255) not null,
    REFERENCE_CODE_ID integer,
    --
    primary key (ID)
);