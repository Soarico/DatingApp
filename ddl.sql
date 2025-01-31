create table users (
    id bigserial primary key,
    firstname varchar(255) not null,
    lastname  varchar(255) not null,
    gender varchar(10) not null,
    age INT not null
    photoUrl varchar(255)
);

create table reactions (
    id bigserial primary key,
    reaction boolean,
    userFrom_id bigint,
    userTo_id bigint
);
