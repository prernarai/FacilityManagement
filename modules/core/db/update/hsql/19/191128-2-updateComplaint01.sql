alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_REPORTING_PARTY foreign key (REPORTING_PARTY_ID) references FACILITYMANAGEMENT_COMPLAINANT(ID);
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_REPORTING_PARTY on FACILITYMANAGEMENT_COMPLAINT (REPORTING_PARTY_ID);
