alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_TYPE foreign key (TYPE_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID);
alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_COMPLAINT foreign key (COMPLAINT_ID) references FACILITYMANAGEMENT_COMPLAINT(ID);
create unique index IDX_FACILITYMANAGEMENT_ALLEGATION_UNIQ_BUSINESS_KEY on FACILITYMANAGEMENT_ALLEGATION (BUSINESS_KEY) ;
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_TYPE on FACILITYMANAGEMENT_ALLEGATION (TYPE_ID);
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_COMPLAINT on FACILITYMANAGEMENT_ALLEGATION (COMPLAINT_ID);