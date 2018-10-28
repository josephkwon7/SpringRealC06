create table if not exists team(
    team_id mediumint primary key auto_increment,
    name varchar(255) not null
);
delete from team;
insert into team(name) value('manchester fc');
insert into team(name) value('london fc');
insert into team(name) value('liverpool fc');
insert into team(name) value('blackburn fc');
insert into team(name) value('leeds fc');
insert into team(name) value('ipswich fc');
insert into team(name) value('bolton fc');
commit;
