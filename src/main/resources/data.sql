--create table Enterprise(id bigint auto_increment, name varchar(255) not null, industry varchar(255) not null, PRIMARY KEY(id));
--create table Client(id bigint auto_increment, name varchar(255) not null, surname varchar(255) not null, address varchar (255) not null, ci bigint not null, PRIMARY KEY (id));
--create table Product(id bigint auto_increment, name varchar(255) not null, description varchar(255) not null, price_dollars int not null, stock int not null, PRIMARY KEY(id));

insert into Enterprise(name, industry) values('Pineapple', 'Consumer Electronics');
insert into Client(name, surname, address, ci) values('Gaston', 'Cerati', 'Av. Peru 6467', 482);
insert into Client(name, surname, address, ci) values('Pablo', 'Gonzalez', 'Av. Uruguay 2314', 513);
insert into Client(name, surname, address, ci) values('Franco', 'Ramirez', 'Av. Colombia 6533', 573);
insert into Client(name, surname, address, ci) values('Francesco', 'Virgolini', 'Av. Italia 0012', 427);
insert into Client(name, surname, address, ci) values('Ernesto', 'Bonavente', 'Av. Argentina 3982', 337);
insert into Product(name, description, price_dollars, stock) values('Teclado SK1', 'Teclado mecanico, inalambrico, color gris', 200, 56);
insert into Product(name, description, price_dollars, stock) values('Notebook GORR', 'Procesador AMD A12, 500GB, 16Ram, modelo 2020', 38000, 42);
insert into Product(name, description, price_dollars, stock) values('Monitor LOL213-4', 'Monitor 20:0, curvo, brazo mecanico incluido', 4000, 12);
insert into Product(name, description, price_dollars, stock) values('Mouse L12.2', 'Mouse inalambrico, adaptador de DPI, muchos botones mas', 210, 43);
insert into Product(name, description, price_dollars, stock) values('Notebook GR12', 'Ideal para oficinas, procesador Intel5-6, 8Ram, modelo 2022', 2000, 6);
insert into Product(name, description, price_dollars, stock) values('Auriculares PNPP2', 'Auriculares inalambricos, bateria 3400mha, microfono retractil', 120, 21);
insert into Product(name, description, price_dollars, stock) values('Smartphone XLC12', '64GB, nuevo procesador y sistema operativo Pineapple, color Celeste cielo, V1.0.3', 36000, 33);
insert into Product(name, description, price_dollars, stock) values('Notebook ROGG', 'Procesador Pineapple primera linea en implementarlos, 1T espacio, 32Ram, modelo 2022', 58000, 15);
insert into Product(name, description, price_dollars, stock) values('Smartphone XLC12S', '258GB, nuevo procesador y sistema operativo Pineapple, color Negro metalizado, V1.0.5', 43000, 50);
insert into Product(name, description, price_dollars, stock) values('Smartphone PLUS+', '32GB, nueva linea de Smartphones ideal para viajes, conexion mejorada, bateria mejorada, resistente al agua y caidas', 22000, 25);