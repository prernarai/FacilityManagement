create table FACILITYMANAGEMENT_REFERENCE_CODE (
    ID integer not null,
    UUID varchar(36),
    --
    CODE varchar(255) not null,
    DESCRIPTION varchar(255) not null,
    --
    primary key (ID)
);