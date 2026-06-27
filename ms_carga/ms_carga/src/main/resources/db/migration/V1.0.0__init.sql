create table carga (
                  id bigint primary key auto_increment,
                  patente_camion varchar(15) not null,
                  tipo_mercancia varchar(100) not null,
                  peso_toneladas decimal(8,2) not null
);

create table manifiesto_carga (
                  id_manifiesto bigint primary key auto_increment,
                  id_carga bigint not null,
                  origen varchar(100) not null,
                  destino varchar(100) not null
);

alter table manifiesto_carga
    add constraint fk_manifiesto_carga
        foreign key (id_carga) references carga(id);

insert into carga (patente_camion, tipo_mercancia, peso_toneladas) values
                 ('AB-CD-12', 'Cobre', 25.50),
                 ('FR-GT-99', 'Electrodomesticos', 12.00);