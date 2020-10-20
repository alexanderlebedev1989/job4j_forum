create table posts (
  id serial primary key,
  name varchar(2000),
  description text,
  created timestamp without time zone not null default now()
);

create table comments (
  id serial primary key,
  description text,
  created timestamp without time zone not null default now(),
  post_id INT REFERENCES posts(id)
);

create table users (
    id serial primary key,
    username VARCHAR(200),
    password VARCHAR(200),
    enabled boolean default true,
    authority_id int not null references authorities(id)
);

CREATE TABLE authorities (
  id serial primary key,
  authority VARCHAR(50) NOT NULL unique
);

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');
