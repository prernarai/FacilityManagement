alter table FACILITYMANAGEMENT_REFERENCE_VALUE alter column UUID rename to UUID__U22274 ^
alter table FACILITYMANAGEMENT_REFERENCE_VALUE add column DELETED_BY varchar(50) ;
alter table FACILITYMANAGEMENT_REFERENCE_VALUE add column UPDATE_TS timestamp ;
alter table FACILITYMANAGEMENT_REFERENCE_VALUE add column DELETE_TS timestamp ;
alter table FACILITYMANAGEMENT_REFERENCE_VALUE add column UPDATED_BY varchar(50) ;
alter table FACILITYMANAGEMENT_REFERENCE_VALUE add column CREATED_BY varchar(50) ;
-- alter table FACILITYMANAGEMENT_REFERENCE_VALUE add column VALUE_ integer ^
-- update FACILITYMANAGEMENT_REFERENCE_VALUE set VALUE_ = <default_value> ;
-- alter table FACILITYMANAGEMENT_REFERENCE_VALUE alter column VALUE_ set not null ;
alter table FACILITYMANAGEMENT_REFERENCE_VALUE add column VALUE_ integer ;
alter table FACILITYMANAGEMENT_REFERENCE_VALUE add column CREATE_TS timestamp ;
