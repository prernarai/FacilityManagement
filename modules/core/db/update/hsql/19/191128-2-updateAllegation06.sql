alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_RELATED_VICTIM foreign key (RELATED_VICTIM_ID) references FACILITYMANAGEMENT_VICTIM(ID);
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_RELATED_VICTIM on FACILITYMANAGEMENT_ALLEGATION (RELATED_VICTIM_ID);
