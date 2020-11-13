create table if not exists alunos(
    id serial not null,
    matricula smallint not null,
    nome_completo varchar(256) not null,
    refeicoesId smallint not null ,
    primary key (id)
);

alter table alunos add constraint refeicoes foreign key (refeicoesId) references refeicoes(id);