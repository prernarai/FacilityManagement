alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_DID_INCIDENT_TAKE_PLACE_IN_FACILITY foreign key (DID_INCIDENT_TAKE_PLACE_IN_FACILITY_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID);
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_DID_INCIDENT_TAKE_PLACE_IN_FACILITY on FACILITYMANAGEMENT_COMPLAINT (DID_INCIDENT_TAKE_PLACE_IN_FACILITY_ID);
