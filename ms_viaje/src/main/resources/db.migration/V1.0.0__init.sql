create table viaje (
    id bigint primary key viaje_increment,
    rut varchar(15) not null,
    marca varchar(50) not null,
    tipo varchar(30) not null
);

create table historial_viaje (
    id_historial bigint primary key viaje_increment,
    id_viaje bigint not null,
    fecha_cruce date not null,
    estado varchar(50) not null
);

alter table historial_viaje
    add constraint fk_historial_viaje
        foreign key (id_viaje) references viaje(id);

insert into viaje (rut, marca, tipo) values
    ('11111111-1', 'Toyota', 'Camioneta'),
    ('22222222-2', 'Ford', 'Sedan');