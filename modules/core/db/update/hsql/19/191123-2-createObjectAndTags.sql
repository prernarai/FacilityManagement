alter table FACILITYMANAGEMENT_OBJECT_AND_TAGS add constraint FK_FACILITYMANAGEMENT_OBJECT_AND_TAGS_ON_TAG foreign key (TAG_ID) references FACILITYMANAGEMENT_OBJECT_AND_TAGS(ID);
create index IDX_FACILITYMANAGEMENT_OBJECT_AND_TAGS_ON_TAG on FACILITYMANAGEMENT_OBJECT_AND_TAGS (TAG_ID);
