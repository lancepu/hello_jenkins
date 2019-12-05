create schema if not exists jenkins_rsvp;
use jenkins_rsvp;

create table if not exists rsvp (
	rsvp_id int not null auto_increment primary key,
    guest_name varchar(50) not null,
    total_attending int not null
);

create schema if not exists jenkins_rsvp_test;
use jenkins_rsvp_test;

create table if not exists rsvp (
	rsvp_id int not null auto_increment primary key,
    guest_name varchar(50) not null,
    total_attending int not null
);