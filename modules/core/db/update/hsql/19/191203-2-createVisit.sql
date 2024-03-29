alter table FACILITYMANAGEMENT_VISIT add constraint FK_FACILITYMANAGEMENT_VISIT_ON_TYPE_OF_VISIT foreign key (TYPE_OF_VISIT_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID);
alter table FACILITYMANAGEMENT_VISIT add constraint FK_FACILITYMANAGEMENT_VISIT_ON_WAS_ANNOUNCED foreign key (WAS_ANNOUNCED_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID);
alter table FACILITYMANAGEMENT_VISIT add constraint FK_FACILITYMANAGEMENT_VISIT_ON_FACILITY foreign key (FACILITY_ID) references FACILITYMANAGEMENT_FACILITY(ID);
create index IDX_FACILITYMANAGEMENT_VISIT_ON_TYPE_OF_VISIT on FACILITYMANAGEMENT_VISIT (TYPE_OF_VISIT_ID);
create index IDX_FACILITYMANAGEMENT_VISIT_ON_WAS_ANNOUNCED on FACILITYMANAGEMENT_VISIT (WAS_ANNOUNCED_ID);
create index IDX_FACILITYMANAGEMENT_VISIT_ON_FACILITY on FACILITYMANAGEMENT_VISIT (FACILITY_ID);
