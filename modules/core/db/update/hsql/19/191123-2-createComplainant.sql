alter table FACILITYMANAGEMENT_COMPLAINANT add constraint FK_FACILITYMANAGEMENT_COMPLAINANT_ON_RELATIONSHIP_WITH_FACILITY foreign key (RELATIONSHIP_WITH_FACILITY_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID);
alter table FACILITYMANAGEMENT_COMPLAINANT add constraint FK_FACILITYMANAGEMENT_COMPLAINANT_ON_DOES_COMPLAINTANT_WANTS_TO_BE_CONFIDENTIAL foreign key (DOES_COMPLAINTANT_WANTS_TO_BE_CONFIDENTIAL_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID);
create index IDX_FACILITYMANAGEMENT_COMPLAINANT_ON_RELATIONSHIP_WITH_FACILITY on FACILITYMANAGEMENT_COMPLAINANT (RELATIONSHIP_WITH_FACILITY_ID);
create index IDX_FACILITYMANAGEMENT_COMPLAINANT_ON_DOES_COMPLAINTANT_WANTS_TO_BE_CONFIDENTIAL on FACILITYMANAGEMENT_COMPLAINANT (DOES_COMPLAINTANT_WANTS_TO_BE_CONFIDENTIAL_ID);
