alter table addresses add constraint FK34207BA2FBFE6130 foreign key (zipcode_id) references zipcodes;
alter table addresses add constraint FK34207BA27EE00646 foreign key (federalstate_id) references federalstates;
alter table blacklisted_contacts add constraint FKA1253AB66926A1DE foreign key (blacklisted_id) references users;
alter table blacklisted_contacts add constraint FKA1253AB64E23EC72 foreign key (user_data_id) references user_data;
alter table federalstates add constraint FK1A5486DFAE853FD9 foreign key (country_id) references countries;
alter table recommendations add constraint FK9357B7DAF969622F foreign key (user_id) references users;
alter table recommendations add constraint FK9357B7DAC50FA59F foreign key (recommended_id) references users;
alter table relation_permissions add constraint FK634032C15FEFE072 foreign key (subscriber_id) references users;
alter table relation_permissions add constraint FK634032C17D3F4E49 foreign key (provider_id) references users;
alter table reset_passwords add constraint FK35B79A48F969622F foreign key (user_id) references users;
alter table robinsons add constraint FKAAF79CBC06DC98 foreign key (robinson_user_id) references users;
alter table role_permissions add constraint FKEAD9D23B54140A59 foreign key (role_id) references roles;
alter table role_permissions add constraint FKEAD9D23BB7538E27 foreign key (permission_id) references permissions;
alter table rule_violations add constraint FK99170D11EC5AFAB6 foreign key (detector_user_id) references users;
alter table rule_violations add constraint FK99170D113CE73016 foreign key (violator_user_id) references users;
alter table user_addresses add constraint FK9188602E4E23EC72 foreign key (user_data_id) references user_data;
alter table user_addresses add constraint FK9188602EDEBFF13B foreign key (addresses_id) references addresses;
alter table user_contactmethods add constraint FKA59F56864E23EC72 foreign key (user_data_id) references user_data;
alter table user_contactmethods add constraint FKA59F568644566562 foreign key (contactmethods_id) references contactmethods;
alter table user_contacts add constraint FKE130BA475A197AAE foreign key (user_contact_id) references users;
alter table user_contacts add constraint FKE130BA474E23EC72 foreign key (user_data_id) references user_data;
alter table user_credits add constraint FK983F4C26F969622F foreign key (user_id) references users;
alter table user_data add constraint FK1435639E88266D3 foreign key (owner) references users;
alter table user_data add constraint FK1435639E8089EA06 foreign key (primary_address_id) references addresses;
alter table user_relation_permissions add constraint FKDBE83EB5B7538E27 foreign key (permission_id) references permissions;
alter table user_relation_permissions add constraint FKDBE83EB53304507C foreign key (user_relation_permission_id) references relation_permissions;
alter table user_resources add constraint FKE734A2B1D0AAF549 foreign key (resources_id) references resources;
alter table user_resources add constraint FKE734A2B14E23EC72 foreign key (user_data_id) references user_data;
alter table user_roles add constraint FK7342994954140A59 foreign key (role_id) references roles;
alter table user_roles add constraint FK73429949F969622F foreign key (user_id) references users;
alter table zipcodes add constraint FKF88385A5AE853FD9 foreign key (country_id) references countries;
create sequence hibernate_sequence;
