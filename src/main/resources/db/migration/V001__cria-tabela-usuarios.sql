create table if not exists usuarios(
    id serial not null,
    nome_completo varchar(256) not null,
    username varchar(256) not null,
    password varchar(256) not null,
    primary key (id)
);