alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_QUALIFIER1 foreign key (QUALIFIER1_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID);
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_QUALIFIER1 on FACILITYMANAGEMENT_ALLEGATION (QUALIFIER1_ID);
