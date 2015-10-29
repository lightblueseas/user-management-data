create type contactmethodType as enum (
	'EMAIL', 'MAIL', 'TELEFON', 'FAX', 'MOBILE', 'SMS', 'MESSENGER', 'INTERNET', 'NEWSGROUP'
);
create type genderType as enum (
	'MALE', 'FEMALE', 'INCORPORATION', 'UNDEFINED'
);

create TYPE ruleviolationreasontype as enum (
	'ABUSE', 'RACIST', 'ADVERTISING', 'OTHER'
);