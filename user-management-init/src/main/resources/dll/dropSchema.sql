alter table addresses drop constraint FK34207BA2FBFE6130;
alter table addresses drop constraint FK34207BA27EE00646;
alter table blacklisted_contacts drop constraint FKA1253AB66926A1DE;
alter table blacklisted_contacts drop constraint FKA1253AB64E23EC72;
alter table federalstates drop constraint FK1A5486DFAE853FD9;
alter table recommendations drop constraint FK9357B7DAF969622F;
alter table recommendations drop constraint FK9357B7DAC50FA59F;
alter table relation_permissions drop constraint FK634032C15FEFE072;
alter table relation_permissions drop constraint FK634032C17D3F4E49;
alter table reset_passwords drop constraint FK35B79A48F969622F;
alter table robinsons drop constraint FKAAF79CBC06DC98;
alter table role_permissions drop constraint FKEAD9D23B54140A59;
alter table role_permissions drop constraint FKEAD9D23BB7538E27;
alter table rule_violations drop constraint FK99170D11EC5AFAB6;
alter table rule_violations drop constraint FK99170D113CE73016;
alter table user_addresses drop constraint FK9188602E4E23EC72;
alter table user_addresses drop constraint FK9188602EDEBFF13B;
alter table user_contactmethods drop constraint FKA59F56864E23EC72;
alter table user_contactmethods drop constraint FKA59F568644566562;
alter table user_contacts drop constraint FKE130BA475A197AAE;
alter table user_contacts drop constraint FKE130BA474E23EC72;
alter table user_credits drop constraint FK983F4C26F969622F;
alter table user_data drop constraint FK1435639E88266D3;
alter table user_data drop constraint FK1435639E8089EA06;
alter table user_relation_permissions drop constraint FKDBE83EB5B7538E27;
alter table user_relation_permissions drop constraint FKDBE83EB53304507C;
alter table user_resources drop constraint FKE734A2B1D0AAF549;
alter table user_resources drop constraint FKE734A2B14E23EC72;
alter table user_roles drop constraint FK7342994954140A59;
alter table user_roles drop constraint FK73429949F969622F;
alter table zipcodes drop constraint FKF88385A5AE853FD9;
drop table addresses;
drop table blacklisted_contacts;
drop table contactmethods;
drop table countries;
drop table federalstates;
drop table permissions;
drop table recommendations;
drop table relation_permissions;
drop table reset_passwords;
drop table resources;
drop table robinsons;
drop table role_permissions;
drop table roles;
drop table rule_violations;
drop table user_addresses;
drop table user_contactmethods;
drop table user_contacts;
drop table user_credits;
drop table user_data;
drop table user_relation_permissions;
drop table user_resources;
drop table user_roles;
drop table user_tokens;
drop table users;
drop table zipcodes;
drop sequence hibernate_sequence;
