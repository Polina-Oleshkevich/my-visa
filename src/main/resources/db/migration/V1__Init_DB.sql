create sequence hibernate_sequence start 1 inclement 1;

create table admin (
    id  int8 not null,
    email varchar(255) not null,
    first_name varchar(255),
    last_name varchar(255),
    status varchar(255),
    primary key (id)
);

create table center (
    id  int8 not null,
    address varchar(255),
    city varchar(255),
    email varchar(255),
    open_data date not null,
    phone int4,
    status varchar(255),
    admin_id int8,
    primary key (id)
);

create table client (
    id  int8 not null,
    date_birth date,
    email varchar(255) not null,
    first_name varchar(255),
    last_name varchar(255),
    status varchar(255),
    primary key (id)
);
create table manager (
    id  int8 not null,
    date_birth date,
    email varchar(255) not null,
    employment_date date,
    first_name varchar(255),
    last_name varchar(255),
    phone int4 not null,
    status varchar(255),
    manager_id int8,
    primary key (id)
);
create table request (
    id  int8 not null,
     status varchar(255),
     travel_date date,
     visit_date date not null,
     center_id int8,
     client_id int8,
     manager_id int8,
      primary key (id)
);
create table visa (
    id  int8 not null,
    country varchar(255) not null,
     price int4,
     purpose varchar(255),
     status varchar(255),
     visa_term int4,
     visa_type varchar(255),
     admin_id int8,
     center_id int8,
     primary key (id)
);
alter table if exists center
    add constraint FKsg1k739tegcn6s0pst6sig1xn
    foreign key (admin_id) references admin;
alter table if exists manager
    add constraint FKh94kf0mnbh7n9fo4rn1ohs2re
    foreign key (manager_id) references manager;
alter table if exists request
    add constraint FKmfjfvem3wchuu6kx8wshv8bwv
    foreign key (center_id) references center;
alter table if exists request
    add constraint FKdayt1j0e3kc0j52bn9b78dav
    foreign key (client_id) references client;
alter table if exists request
    add constraint FKb333houpq99p6nl4pq5c6ykda
    foreign key (manager_id) references manager;
alter table if exists visa
    add constraint FKd74qn8fdun69h8uoq1x6h3jcf
    foreign key (admin_id) references admin;
alter table if exists visa
    add constraint FKhdj2gmcjtdun3qrnqosmyhbry
    foreign key (center_id) references center;
