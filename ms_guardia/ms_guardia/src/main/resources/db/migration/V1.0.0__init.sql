create table guardia (
      id bigint primary key auto_increment,
      rut varchar(15) not null,
      nombre varchar(100) not null,
      rango varchar(50) not null
);

create table turno_guardia (
     id_turno bigint primary key auto_increment,
     id_guardia bigint not null,
     fecha_turno date not null,
     sector_aduana varchar(100) not null
);

alter table turno_guardia
    add constraint fk_turno_guardia
        foreign key (id_guardia) references guardia(id);

insert into guardia (rut, nombre, rango) values
    ('12345678-9', 'Juan Perez', 'Inspector Jefe'),
    ('98765432-1', 'Maria Gonzalez', 'Agente de Frontera');