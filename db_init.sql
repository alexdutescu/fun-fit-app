create database if not exists funfit;
use funfit;
create table batch(batch_id int primary key auto_increment, type_of_batch enum('morning', 'evening'), time varchar(10));

create table participants(participant_id int primary key auto_increment, first_name varchar(30), age int, phone_number varchar(10), batch_id int, foreign key(batch_id) references batch(batch_id) on delete set null);

insert into batch(type_of_batch, time) values ('morning', '8:00');

insert into batch(type_of_batch, time) values ('morning', '9:00');

insert into batch(type_of_batch, time) values ('evening', '18:00');

insert into batch(type_of_batch, time) values ('evening', '19:00');