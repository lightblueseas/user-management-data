alter table contactmethods drop column contactmethod;    
alter table contactmethods add contactmethod contactmethodType;

alter table user_data drop column gender;    
alter table user_data add gender genderType;

alter table rule_violations drop column reason;    
alter table rule_violations add reason ruleviolationreasontype;