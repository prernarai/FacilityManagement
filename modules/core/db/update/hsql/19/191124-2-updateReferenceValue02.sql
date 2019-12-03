alter table FACILITYMANAGEMENT_REFERENCE_VALUE add column UUID varchar(36) ;
-- update FACILITYMANAGEMENT_REFERENCE_VALUE set VALUE_ = <default_value> where VALUE_ is null ;
alter table FACILITYMANAGEMENT_REFERENCE_VALUE alter column VALUE_ set not null ;
