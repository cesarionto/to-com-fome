create table if not exists refeicoes(
    id serial not null,
    tipo_refeicao varchar(20) not null,
    data_refeicao date not null,
    campi varchar(20) not null
);
