create table inspeccion (
        id bigint primary key auto_increment,
        id_viaje bigint not null,
        resultado varchar(50) not null,
        detalle_hallazgo varchar(255)
);

create table registro_aduana (
       id_registro bigint primary key auto_increment,
       id_inspeccion bigint not null,
       fecha_registro datetime not null,
       monto_impuesto decimal(10,2) default 0.00
);

alter table registro_aduana
    add constraint fk_registro_inspeccion
        foreign key (id_inspeccion) references inspeccion(id);

insert into inspeccion (id_viaje, resultado, detalle_hallazgo) values
      (1, 'APROBADO', 'Sin mercadería ilícita'),
      (2, 'RECHAZADO', 'Exceso de franquicia permitida');