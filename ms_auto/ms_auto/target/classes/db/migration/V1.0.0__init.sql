create table auto (
    id bigint primary key auto_increment,
    patente varchar(15) not null,
    marca varchar(50) not null,
    tipo varchar(30) not null
);

create table historial_auto (
    id_historial bigint primary key auto_increment,
    id_auto bigint not null,
    fecha_cruce date not null,
    estado varchar(50) not null
);

alter table historial_auto
    add constraint fk_historial_auto
    foreign key (id_auto) references auto(id);

insert into auto (patente, marca, tipo) values
    ('AB123CD', 'Toyota', 'Camioneta'),
    ('XX99ZZ', 'Ford', 'Sedan'),
    ('LL44OP', 'Chevrolet', 'Auto'),
    ('WW11QQ', 'Nissan', 'SUV');

insert into historial_auto (id_auto, fecha_cruce, estado) values
    (1, '2026-05-20', 'Aprobado'),
    (2, '2026-05-19', 'Rechazado'),
    (3, '2026-05-20', 'Aprobado'),
    (4, '2026-05-18', 'Aprobado');