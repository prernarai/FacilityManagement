alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_QUALIFIER2 foreign key (QUALIFIER2_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID);
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_QUALIFIER2 on FACILITYMANAGEMENT_ALLEGATION (QUALIFIER2_ID);