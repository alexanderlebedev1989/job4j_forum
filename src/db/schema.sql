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
    name VARCHAR(200),
    password VARCHAR(200)
);