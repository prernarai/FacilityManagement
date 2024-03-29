-- begin FACILITYMANAGEMENT_COMPLAINANT
alter table FACILITYMANAGEMENT_COMPLAINANT add constraint FK_FACILITYMANAGEMENT_COMPLAINANT_ON_RELATIONSHIP_WITH_FACILITY foreign key (RELATIONSHIP_WITH_FACILITY_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_COMPLAINANT add constraint FK_FACILITYMANAGEMENT_COMPLAINANT_ON_DOES_COMPLAINTANT_WANTS_TO_BE_CONFIDENTIAL foreign key (DOES_COMPLAINTANT_WANTS_TO_BE_CONFIDENTIAL_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINANT_ON_RELATIONSHIP_WITH_FACILITY on FACILITYMANAGEMENT_COMPLAINANT (RELATIONSHIP_WITH_FACILITY_ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINANT_ON_DOES_COMPLAINTANT_WANTS_TO_BE_CONFIDENTIAL on FACILITYMANAGEMENT_COMPLAINANT (DOES_COMPLAINTANT_WANTS_TO_BE_CONFIDENTIAL_ID)^
-- end FACILITYMANAGEMENT_COMPLAINANT
-- begin FACILITYMANAGEMENT_REFERENCE_VALUE
alter table FACILITYMANAGEMENT_REFERENCE_VALUE add constraint FK_FACILITYMANAGEMENT_REFERENCE_VALUE_ON_REFERENCE_CODE foreign key (REFERENCE_CODE_ID) references FACILITYMANAGEMENT_REFERENCE_CODE(ID)^
create index IDX_FACILITYMANAGEMENT_REFERENCE_VALUE_ON_REFERENCE_CODE on FACILITYMANAGEMENT_REFERENCE_VALUE (REFERENCE_CODE_ID)^
-- end FACILITYMANAGEMENT_REFERENCE_VALUE
-- begin FACILITYMANAGEMENT_REFERENCE_CODE
create unique index IDX_FACILITYMANAGEMENT_REFERENCE_CODE_UNIQ_CODE on FACILITYMANAGEMENT_REFERENCE_CODE (CODE) ^
-- end FACILITYMANAGEMENT_REFERENCE_CODE
-- begin FACILITYMANAGEMENT_COMPLAINT
alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_IS_ABUSE_REPORT_REQUIRED foreign key (IS_ABUSE_REPORT_REQUIRED_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_IS_ABUSE_REPORT_FILED foreign key (IS_ABUSE_REPORT_FILED_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_SOURCE_OF_COMPLAINT foreign key (SOURCE_OF_COMPLAINT_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_DID_INCIDENT_TAKE_PLACE_IN_FACILITY foreign key (DID_INCIDENT_TAKE_PLACE_IN_FACILITY_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_FACILITY foreign key (FACILITY_ID) references FACILITYMANAGEMENT_FACILITY(ID)^
alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_REPORTING_PARTY foreign key (REPORTING_PARTY_ID) references FACILITYMANAGEMENT_COMPLAINANT(ID)^
alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_PRIORITY foreign key (PRIORITY_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_CURRENT_STATUS foreign key (CURRENT_STATUS_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_COMPLAINT add constraint FK_FACILITYMANAGEMENT_COMPLAINT_ON_ASSIGNED_TO foreign key (ASSIGNED_TO_ID) references SEC_USER(ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_IS_ABUSE_REPORT_REQUIRED on FACILITYMANAGEMENT_COMPLAINT (IS_ABUSE_REPORT_REQUIRED_ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_IS_ABUSE_REPORT_FILED on FACILITYMANAGEMENT_COMPLAINT (IS_ABUSE_REPORT_FILED_ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_SOURCE_OF_COMPLAINT on FACILITYMANAGEMENT_COMPLAINT (SOURCE_OF_COMPLAINT_ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_DID_INCIDENT_TAKE_PLACE_IN_FACILITY on FACILITYMANAGEMENT_COMPLAINT (DID_INCIDENT_TAKE_PLACE_IN_FACILITY_ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_FACILITY on FACILITYMANAGEMENT_COMPLAINT (FACILITY_ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_REPORTING_PARTY on FACILITYMANAGEMENT_COMPLAINT (REPORTING_PARTY_ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_PRIORITY on FACILITYMANAGEMENT_COMPLAINT (PRIORITY_ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_CURRENT_STATUS on FACILITYMANAGEMENT_COMPLAINT (CURRENT_STATUS_ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_ON_ASSIGNED_TO on FACILITYMANAGEMENT_COMPLAINT (ASSIGNED_TO_ID)^
-- end FACILITYMANAGEMENT_COMPLAINT
-- begin FACILITYMANAGEMENT_OBJECT_AND_TAGS
alter table FACILITYMANAGEMENT_OBJECT_AND_TAGS add constraint FK_FACILITYMANAGEMENT_OBJECT_AND_TAGS_ON_TAG foreign key (TAG_ID) references FACILITYMANAGEMENT_OBJECT_AND_TAGS(ID)^
create index IDX_FACILITYMANAGEMENT_OBJECT_AND_TAGS_ON_TAG on FACILITYMANAGEMENT_OBJECT_AND_TAGS (TAG_ID)^
-- end FACILITYMANAGEMENT_OBJECT_AND_TAGS
-- begin FACILITYMANAGEMENT_ALLEGATION
alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_TYPE foreign key (TYPE_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_COMPLAINT foreign key (COMPLAINT_ID) references FACILITYMANAGEMENT_COMPLAINT(ID)^
alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_BODILY_INJURY foreign key (BODILY_INJURY_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_QUALIFIER1 foreign key (QUALIFIER1_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_QUALIFIER2 foreign key (QUALIFIER2_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_RELATED_VICTIM foreign key (RELATED_VICTIM_ID) references FACILITYMANAGEMENT_VICTIM(ID)^
alter table FACILITYMANAGEMENT_ALLEGATION add constraint FK_FACILITYMANAGEMENT_ALLEGATION_ON_RELATED_PERP foreign key (RELATED_PERP_ID) references FACILITYMANAGEMENT_PERPETRATOR(ID)^
create unique index IDX_FACILITYMANAGEMENT_ALLEGATION_UNIQ_BUSINESS_KEY on FACILITYMANAGEMENT_ALLEGATION (BUSINESS_KEY) ^
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_TYPE on FACILITYMANAGEMENT_ALLEGATION (TYPE_ID)^
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_COMPLAINT on FACILITYMANAGEMENT_ALLEGATION (COMPLAINT_ID)^
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_BODILY_INJURY on FACILITYMANAGEMENT_ALLEGATION (BODILY_INJURY_ID)^
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_QUALIFIER1 on FACILITYMANAGEMENT_ALLEGATION (QUALIFIER1_ID)^
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_QUALIFIER2 on FACILITYMANAGEMENT_ALLEGATION (QUALIFIER2_ID)^
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_RELATED_VICTIM on FACILITYMANAGEMENT_ALLEGATION (RELATED_VICTIM_ID)^
create index IDX_FACILITYMANAGEMENT_ALLEGATION_ON_RELATED_PERP on FACILITYMANAGEMENT_ALLEGATION (RELATED_PERP_ID)^
-- end FACILITYMANAGEMENT_ALLEGATION
-- begin FACILITYMANAGEMENT_VICTIM
alter table FACILITYMANAGEMENT_VICTIM add constraint FK_FACILITYMANAGEMENT_VICTIM_ON_WERE_THEY_IN_FACILITY foreign key (WERE_THEY_IN_FACILITY_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_VICTIM add constraint FK_FACILITYMANAGEMENT_VICTIM_ON_CLIENT_NUMBER foreign key (CLIENT_NUMBER_ID) references FACILITYMANAGEMENT_CLIENT(ID)^
create index IDX_FACILITYMANAGEMENT_VICTIM_ON_WERE_THEY_IN_FACILITY on FACILITYMANAGEMENT_VICTIM (WERE_THEY_IN_FACILITY_ID)^
create index IDX_FACILITYMANAGEMENT_VICTIM_ON_CLIENT_NUMBER on FACILITYMANAGEMENT_VICTIM (CLIENT_NUMBER_ID)^
-- end FACILITYMANAGEMENT_VICTIM
-- begin FACILITYMANAGEMENT_COMPLAINT_STATUS
alter table FACILITYMANAGEMENT_COMPLAINT_STATUS add constraint FK_FACILITYMANAGEMENT_COMPLAINT_STATUS_ON_COMPLAINT foreign key (COMPLAINT_ID) references FACILITYMANAGEMENT_COMPLAINT(ID)^
alter table FACILITYMANAGEMENT_COMPLAINT_STATUS add constraint FK_FACILITYMANAGEMENT_COMPLAINT_STATUS_ON_STATUS foreign key (STATUS_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_STATUS_ON_COMPLAINT on FACILITYMANAGEMENT_COMPLAINT_STATUS (COMPLAINT_ID)^
create index IDX_FACILITYMANAGEMENT_COMPLAINT_STATUS_ON_STATUS on FACILITYMANAGEMENT_COMPLAINT_STATUS (STATUS_ID)^
-- end FACILITYMANAGEMENT_COMPLAINT_STATUS
-- begin FACILITYMANAGEMENT_EVENT_TIME_LINE
alter table FACILITYMANAGEMENT_EVENT_TIME_LINE add constraint FK_FACILITYMANAGEMENT_EVENT_TIME_LINE_ON_OBJECT_TYPE foreign key (OBJECT_TYPE_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_EVENT_TIME_LINE add constraint FK_FACILITYMANAGEMENT_EVENT_TIME_LINE_ON_EVENT_TYPE foreign key (EVENT_TYPE_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
create index IDX_FACILITYMANAGEMENT_EVENT_TIME_LINE_ON_OBJECT_TYPE on FACILITYMANAGEMENT_EVENT_TIME_LINE (OBJECT_TYPE_ID)^
create index IDX_FACILITYMANAGEMENT_EVENT_TIME_LINE_ON_EVENT_TYPE on FACILITYMANAGEMENT_EVENT_TIME_LINE (EVENT_TYPE_ID)^
-- end FACILITYMANAGEMENT_EVENT_TIME_LINE
-- begin FACILITYMANAGEMENT_CIENT_WITH_FACILITY
alter table FACILITYMANAGEMENT_CIENT_WITH_FACILITY add constraint FK_FACILITYMANAGEMENT_CIENT_WITH_FACILITY_ON_FACILITY foreign key (FACILITY_ID) references FACILITYMANAGEMENT_FACILITY(ID)^
alter table FACILITYMANAGEMENT_CIENT_WITH_FACILITY add constraint FK_FACILITYMANAGEMENT_CIENT_WITH_FACILITY_ON_CLIENT foreign key (CLIENT_ID) references FACILITYMANAGEMENT_CLIENT(ID)^
create index IDX_FACILITYMANAGEMENT_CIENT_WITH_FACILITY_ON_FACILITY on FACILITYMANAGEMENT_CIENT_WITH_FACILITY (FACILITY_ID)^
create index IDX_FACILITYMANAGEMENT_CIENT_WITH_FACILITY_ON_CLIENT on FACILITYMANAGEMENT_CIENT_WITH_FACILITY (CLIENT_ID)^
-- end FACILITYMANAGEMENT_CIENT_WITH_FACILITY
-- begin FACILITYMANAGEMENT_FACILITY
alter table FACILITYMANAGEMENT_FACILITY add constraint FK_FACILITYMANAGEMENT_FACILITY_ON_STATE foreign key (STATE_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_FACILITY add constraint FK_FACILITYMANAGEMENT_FACILITY_ON_LICENSE_STATUS foreign key (LICENSE_STATUS_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
create index IDX_FACILITYMANAGEMENT_FACILITY_ON_STATE on FACILITYMANAGEMENT_FACILITY (STATE_ID)^
create index IDX_FACILITYMANAGEMENT_FACILITY_ON_LICENSE_STATUS on FACILITYMANAGEMENT_FACILITY (LICENSE_STATUS_ID)^
-- end FACILITYMANAGEMENT_FACILITY
-- begin FACILITYMANAGEMENT_PERPETRATOR
alter table FACILITYMANAGEMENT_PERPETRATOR add constraint FK_FACILITYMANAGEMENT_PERPETRATOR_ON_RELATIONSHIP_TO_VICTIM foreign key (RELATIONSHIP_TO_VICTIM_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_PERPETRATOR add constraint FK_FACILITYMANAGEMENT_PERPETRATOR_ON_RELATIONSHIP_TO_FACILITY foreign key (RELATIONSHIP_TO_FACILITY_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
create index IDX_FACILITYMANAGEMENT_PERPETRATOR_ON_RELATIONSHIP_TO_VICTIM on FACILITYMANAGEMENT_PERPETRATOR (RELATIONSHIP_TO_VICTIM_ID)^
create index IDX_FACILITYMANAGEMENT_PERPETRATOR_ON_RELATIONSHIP_TO_FACILITY on FACILITYMANAGEMENT_PERPETRATOR (RELATIONSHIP_TO_FACILITY_ID)^
-- end FACILITYMANAGEMENT_PERPETRATOR
-- begin FACILITYMANAGEMENT_APPOINTMENT
alter table FACILITYMANAGEMENT_APPOINTMENT add constraint FK_FACILITYMANAGEMENT_APPOINTMENT_ON_WHO_IS_WORKER foreign key (WHO_IS_WORKER_ID) references SEC_USER(ID)^
alter table FACILITYMANAGEMENT_APPOINTMENT add constraint FK_FACILITYMANAGEMENT_APPOINTMENT_ON_VISITING_TO foreign key (VISITING_TO_ID) references FACILITYMANAGEMENT_FACILITY(ID)^
create index IDX_FACILITYMANAGEMENT_APPOINTMENT_ON_WHO_IS_WORKER on FACILITYMANAGEMENT_APPOINTMENT (WHO_IS_WORKER_ID)^
create index IDX_FACILITYMANAGEMENT_APPOINTMENT_ON_VISITING_TO on FACILITYMANAGEMENT_APPOINTMENT (VISITING_TO_ID)^
-- end FACILITYMANAGEMENT_APPOINTMENT
-- begin FACILITYMANAGEMENT_VISIT
alter table FACILITYMANAGEMENT_VISIT add constraint FK_FACILITYMANAGEMENT_VISIT_ON_TYPE_OF_VISIT foreign key (TYPE_OF_VISIT_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_VISIT add constraint FK_FACILITYMANAGEMENT_VISIT_ON_WAS_ANNOUNCED foreign key (WAS_ANNOUNCED_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_VISIT add constraint FK_FACILITYMANAGEMENT_VISIT_ON_FACILITY foreign key (FACILITY_ID) references FACILITYMANAGEMENT_FACILITY(ID)^
alter table FACILITYMANAGEMENT_VISIT add constraint FK_FACILITYMANAGEMENT_VISIT_ON_COMPLAINT foreign key (COMPLAINT_ID) references FACILITYMANAGEMENT_COMPLAINT(ID)^
alter table FACILITYMANAGEMENT_VISIT add constraint FK_FACILITYMANAGEMENT_VISIT_ON_STATUS foreign key (STATUS_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
create index IDX_FACILITYMANAGEMENT_VISIT_ON_TYPE_OF_VISIT on FACILITYMANAGEMENT_VISIT (TYPE_OF_VISIT_ID)^
create index IDX_FACILITYMANAGEMENT_VISIT_ON_WAS_ANNOUNCED on FACILITYMANAGEMENT_VISIT (WAS_ANNOUNCED_ID)^
create index IDX_FACILITYMANAGEMENT_VISIT_ON_FACILITY on FACILITYMANAGEMENT_VISIT (FACILITY_ID)^
create index IDX_FACILITYMANAGEMENT_VISIT_ON_COMPLAINT on FACILITYMANAGEMENT_VISIT (COMPLAINT_ID)^
create index IDX_FACILITYMANAGEMENT_VISIT_ON_STATUS on FACILITYMANAGEMENT_VISIT (STATUS_ID)^
-- end FACILITYMANAGEMENT_VISIT
-- begin FACILITYMANAGEMENT_TASK
alter table FACILITYMANAGEMENT_TASK add constraint FK_FACILITYMANAGEMENT_TASK_ON_ASSIGNE foreign key (ASSIGNE_ID) references SEC_USER(ID)^
alter table FACILITYMANAGEMENT_TASK add constraint FK_FACILITYMANAGEMENT_TASK_ON_FOR_FACILITY foreign key (FOR_FACILITY_ID) references FACILITYMANAGEMENT_FACILITY(ID)^
alter table FACILITYMANAGEMENT_TASK add constraint FK_FACILITYMANAGEMENT_TASK_ON_FOR_COMPLAINT foreign key (FOR_COMPLAINT_ID) references FACILITYMANAGEMENT_COMPLAINT(ID)^
alter table FACILITYMANAGEMENT_TASK add constraint FK_FACILITYMANAGEMENT_TASK_ON_STATUS foreign key (STATUS_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
create index IDX_FACILITYMANAGEMENT_TASK_ON_ASSIGNE on FACILITYMANAGEMENT_TASK (ASSIGNE_ID)^
create index IDX_FACILITYMANAGEMENT_TASK_ON_FOR_FACILITY on FACILITYMANAGEMENT_TASK (FOR_FACILITY_ID)^
create index IDX_FACILITYMANAGEMENT_TASK_ON_FOR_COMPLAINT on FACILITYMANAGEMENT_TASK (FOR_COMPLAINT_ID)^
create index IDX_FACILITYMANAGEMENT_TASK_ON_STATUS on FACILITYMANAGEMENT_TASK (STATUS_ID)^
-- end FACILITYMANAGEMENT_TASK
-- begin FACILITYMANAGEMENT_DEFICIENCY
alter table FACILITYMANAGEMENT_DEFICIENCY add constraint FK_FACILITYMANAGEMENT_DEFICIENCY_ON_SECTION_NUMBER foreign key (SECTION_NUMBER_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_DEFICIENCY add constraint FK_FACILITYMANAGEMENT_DEFICIENCY_ON_FOR_FACILITY foreign key (FOR_FACILITY_ID) references FACILITYMANAGEMENT_FACILITY(ID)^
alter table FACILITYMANAGEMENT_DEFICIENCY add constraint FK_FACILITYMANAGEMENT_DEFICIENCY_ON_VISIT_IDENTIFIED foreign key (VISIT_IDENTIFIED_ID) references FACILITYMANAGEMENT_VISIT(ID)^
alter table FACILITYMANAGEMENT_DEFICIENCY add constraint FK_FACILITYMANAGEMENT_DEFICIENCY_ON_DEFICIENCY_STATUS foreign key (DEFICIENCY_STATUS_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
create index IDX_FACILITYMANAGEMENT_DEFICIENCY_ON_SECTION_NUMBER on FACILITYMANAGEMENT_DEFICIENCY (SECTION_NUMBER_ID)^
create index IDX_FACILITYMANAGEMENT_DEFICIENCY_ON_FOR_FACILITY on FACILITYMANAGEMENT_DEFICIENCY (FOR_FACILITY_ID)^
create index IDX_FACILITYMANAGEMENT_DEFICIENCY_ON_VISIT_IDENTIFIED on FACILITYMANAGEMENT_DEFICIENCY (VISIT_IDENTIFIED_ID)^
create index IDX_FACILITYMANAGEMENT_DEFICIENCY_ON_DEFICIENCY_STATUS on FACILITYMANAGEMENT_DEFICIENCY (DEFICIENCY_STATUS_ID)^
-- end FACILITYMANAGEMENT_DEFICIENCY
-- begin FACILITYMANAGEMENT_PROOF_OF_CORRECTION
alter table FACILITYMANAGEMENT_PROOF_OF_CORRECTION add constraint FK_FACILITYMANAGEMENT_PROOF_OF_CORRECTION_ON_PROOF_TYPE foreign key (PROOF_TYPE_ID) references FACILITYMANAGEMENT_REFERENCE_VALUE(ID)^
alter table FACILITYMANAGEMENT_PROOF_OF_CORRECTION add constraint FK_FACILITYMANAGEMENT_PROOF_OF_CORRECTION_ON_DEFICIENCY foreign key (DEFICIENCY_ID) references FACILITYMANAGEMENT_DEFICIENCY(ID)^
create index IDX_FACILITYMANAGEMENT_PROOF_OF_CORRECTION_ON_PROOF_TYPE on FACILITYMANAGEMENT_PROOF_OF_CORRECTION (PROOF_TYPE_ID)^
create index IDX_FACILITYMANAGEMENT_PROOF_OF_CORRECTION_ON_DEFICIENCY on FACILITYMANAGEMENT_PROOF_OF_CORRECTION (DEFICIENCY_ID)^
-- end FACILITYMANAGEMENT_PROOF_OF_CORRECTION
