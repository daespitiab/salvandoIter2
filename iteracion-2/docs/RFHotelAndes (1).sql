INSERT INTO H_HOTELES (ID, NOMBRE, UBICACION, CATEGORIA, TELEFONO) VALUES (1, 'Hotel Oasis', 'Calle falsa #123', 'Cuatro estrellas', 55555);

-- RF1

-- Cliente

INSERT INTO H_ROLES (ID, NOMBRE_ROL, DESCRIPCION) VALUES (1 ,'Cliente', 'Reserva los servicios de alojamiento y servicios que requieran reserva');

-- Recepcionista

INSERT INTO H_ROLES (ID, NOMBRE_ROL, DESCRIPCION) VALUES (2 ,'Recepcionista', 'Realiza las operaciones de check-in y check-out del cliente');

-- Empleado

INSERT INTO H_ROLES (ID, NOMBRE_ROL, DESCRIPCION) VALUES (3 ,'Empleado', 'Registra los consumos del cliente');

-- Administrador

INSERT INTO H_ROLES (ID, NOMBRE_ROL, DESCRIPCION) VALUES (4 ,'Administrador', 'Describe todas las caracter�sticas del hotel, sus habitaciones, servicios, planes, entre otros');

-- Gerente

INSERT INTO H_ROLES (ID, NOMBRE_ROL, DESCRIPCION) VALUES (5 ,'Gerente', 'Interesado en saber lo que ocurre y c�mo ocurre en el hotel');

-- RF2

-- Gerente

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('C�dula', 1020, 'Alejandra Bravo', 'a.bravo@uniandes.edu.co', 12345, 5);

-- Administrador

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('C�dula', 1021, 'Daniel Espitia', 'da.espitia@uniandes.edu.co', 67312, 4);

-- Recepcionista

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('C�dula', 1022, 'Carlos Bravo', 'elver@gmail.co', 43257, 2);

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('C�dula', 1023, 'Andres Pelos', 'joven@hotmail.com', 02836, 2);

-- Empleado

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('Pasaporte', 1024, 'Andres Gomez', 'queso@yahoo.co', 20371, 3);

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('C�dula', 1025, 'Juan Banana', 'ad.eje@uniandes.edu.co', 91702, 3);

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('C�dula', 1026, 'Alberto Juarez', 'agtmillos@hotmail.com', 74028, 3);

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('Pasaporte', 1027, 'Elver Gazo', 'engaledigo@yahoo.com', 16203, 3);

-- Cliente

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('C�dula', 1028, 'Ela Yuwoki', 'ayuwoki@hotmail.com', 12093, 1);

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('Pasaporte', 1029, 'Louis Krevrga', 'l.verga@uniandes.edu.co', 01835, 1);

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('Pasaporte', 1030, 'Ahorano Porfavor', 'nopls@gmail.com', 24789, 1);

INSERT INTO H_USUARIOS (TIPODOCUMENTO, NUMDOCUMENTO, NOMBRE, CORREO, TELEFONO, ROL) VALUES ('Pasaporte', 1031, 'Maria Elizde', 'm.eliza@hotmail.com', 10261, 1);

-- RF3

INSERT INTO H_TIPO_HABITACIONES (ID, NOMBRE, DESCRIPCION) VALUES (1, 'Sencilla', 'Cama sencilla, televisor, escritorio y ba�o privado');

INSERT INTO H_TIPO_HABITACIONES (ID, NOMBRE, DESCRIPCION) VALUES (2, 'Doble', 'Cama doble, televisor, escritorio, minibar, cl�set y ba�o privado');

INSERT INTO H_TIPO_HABITACIONES (ID, NOMBRE, DESCRIPCION) VALUES (3, 'Suite', 'Cama king, televisor 52'', sof�, escritorio, sala, jacuzzi, tina en ba�o privado, minibar, cocina y balc�n');

-- RF4

-- Sencilla

INSERT INTO H_HABITACIONES (ID, HAB_NUM, ID_HOTEL, ID_TIPO, RESERVADA, PRECIONOCHE) VALUES (1, 101, 1, 1, 0, 100000);

INSERT INTO H_HABITACIONES (ID, HAB_NUM, ID_HOTEL, ID_TIPO, RESERVADA, PRECIONOCHE) VALUES (2, 103, 1, 1, 0, 100000);

INSERT INTO H_HABITACIONES (ID, HAB_NUM, ID_HOTEL, ID_TIPO, RESERVADA, PRECIONOCHE) VALUES (3, 105, 1, 1, 1, 100000);

-- Doble 

INSERT INTO H_HABITACIONES (ID, HAB_NUM, ID_HOTEL, ID_TIPO, RESERVADA, PRECIONOCHE) VALUES (4, 202, 1, 2, 0, 200000);

INSERT INTO H_HABITACIONES (ID, HAB_NUM, ID_HOTEL, ID_TIPO, RESERVADA, PRECIONOCHE) VALUES (5, 204, 1, 2, 0, 220000);

INSERT INTO H_HABITACIONES (ID, HAB_NUM, ID_HOTEL, ID_TIPO, RESERVADA, PRECIONOCHE) VALUES (6, 206, 1, 2, 0, 190000);

-- Suite

INSERT INTO H_HABITACIONES (ID,  HAB_NUM, ID_HOTEL, ID_TIPO, RESERVADA, PRECIONOCHE) VALUES (7, 313, 1, 3, 0, 400000);

INSERT INTO H_HABITACIONES (ID, HAB_NUM, ID_HOTEL, ID_TIPO, RESERVADA, PRECIONOCHE) VALUES (8, 414, 1, 3, 0, 500000);

INSERT INTO H_HABITACIONES (ID,  HAB_NUM, ID_HOTEL, ID_TIPO, RESERVADA, PRECIONOCHE) VALUES (9, 515, 1, 3, 1, 550000);

-- RF5

-- Gimnasio

INSERT INTO H_GIMNASIOS (ID, NOMBRE, PRECIO, PRECIOADICIONAL) VALUES (1, 'Gimnasio principal', 0, 0);

INSERT INTO H_TIENENMAQUINAS(ID_GIMNASIO, NOMBRE_MAQUINA) VALUES (1, 'CAMINADORA');

INSERT INTO H_TIENENMAQUINAS(ID_GIMNASIO, NOMBRE_MAQUINA) VALUES (1, 'ELIPTICA');

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (1, 1, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL);

-- Piscina

INSERT INTO H_PISCINAS (ID, NOMBRE, PRECIO, PAGO_ADICIONAL, CAPACIDAD, HORARIO_INICIAL, HORARIO_FINAL) VALUES (1, 'Piscina lateral', 0, 0, 50, '09:00', '22:00');

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (2, 1, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL);

-- Restaurante

INSERT INTO H_RESTAURANTES_BAR (ID, NOMBRE, TIPO, CAPACIDAD, TEMATICA) VALUES (1, 'Al wok', 50, 'Restaurante oriental');

INSERT INTO H_PRODUCTOS_INSTALACIONES (ID_ITEM, NOMBRE, PRECIO) VALUES (1, 'Restaurante', 'Vegetales con carne al wok', 15000);

INSERT INTO H_PRODUCTOS_INSTALACIONES (ID_ITEM, NOMBRE, PRECIO) VALUES (2, 'Limonada de coco', 7000);

INSERT INTO H_PRODUCTOS_INSTALACIONES (ID_ITEM, NOMBRE, PRECIO) VALUES (3, 'Postre a base de mochi', 10000);

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (3, 1, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL);

INSERT INTO H_OFRECEN (ID_SERVICIO, ID_PRODUCTO) VALUES (3, 1);

INSERT INTO H_OFRECEN (ID_SERVICIO, ID_PRODUCTO) VALUES (3, 2);

INSERT INTO H_OFRECEN (ID_SERVICIO, ID_PRODUCTO) VALUES (3, 3);

-- Bar

INSERT INTO H_RESTAURANTES_BAR (ID, TIPO, NOMBRE, CAPACIDAD, TEMATICA) VALUES (2, 'Bar oculto', 100, 'Bar de jazz');

INSERT INTO H_PRODUCTOS_INSTALACIONES (ID_ITEM, NOMBRE, PRECIO) VALUES (4, 'Bar', 'Cerveza nacional', 5000);

INSERT INTO H_PRODUCTOS_INSTALACIONES (ID_ITEM, NOMBRE, PRECIO) VALUES (5, 'Cerveza internacional', 7000);

INSERT INTO H_PRODUCTOS_INSTALACIONES (ID_ITEM, NOMBRE, PRECIO) VALUES (6, 'Dry martini', 15000);

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (4, 1, NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL);

INSERT INTO H_OFRECEN (ID_SERVICIO, ID_PRODUCTO) VALUES (4, 4);

INSERT INTO H_OFRECEN (ID_SERVICIO, ID_PRODUCTO) VALUES (4, 5);

INSERT INTO H_OFRECEN (ID_SERVICIO, ID_PRODUCTO) VALUES (4, 6);

-- Internet

INSERT INTO H_INTERNET (ID, CAPACIDAD, PRECIO) VALUES (1, 500, 0);

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (5, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL);

-- Supermercado

INSERT INTO H_SUPERMERCADOS_TIENDAS (ID, NOMBRE) VALUES (1, 'Supermercado central');

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (6, 1, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- Tienda

INSERT INTO H_SUPERMERCADOS_TIENDAS (ID, NOMBRE) VALUES (2, 'Joyeria diva');

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (7, 1, NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- Spa

INSERT INTO H_SPAS (ID, NOMBRE, PRECIO, PAGO_ADICIONAL) VALUES (1, 'Spa relax', 25000, 0);

INSERT INTO H_PRODUCTOS_INSTALACIONES (ID_ITEM, NOMBRE, PRECIO) VALUES (7, 'Masaje 40 minutos', 50000);

INSERT INTO H_PRODUCTOS_INSTALACIONES (ID_ITEM, NOMBRE, PRECIO) VALUES (8, 'Chocolaterapia una hora', 60000);

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (8, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO H_OFRECEN (ID_SERVICIO, ID_PRODUCTO) VALUES (8, 7);

INSERT INTO H_OFRECEN (ID_SERVICIO, ID_PRODUCTO) VALUES (8, 8);

-- Prestamo utensilios

INSERT INTO H_PRODUCTOS_INSTALACIONES (ID_ITEM, NOMBRE, PRECIO) VALUES (9, 'Hacha', 15000);

INSERT INTO H_PRESTAMO (ID, ID_ITEM, TIEMPO, PRECIO) VALUES (1, 9, 60, 5000);

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (9, 1, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL);

-- Lavado/planchado/embolada

INSERT INTO H_LAVANDERIA (ID, TIPO, PRECIOPRENDA) VALUES (1, 'Lavado', 3000);

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (10, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);

INSERT INTO H_LAVANDERIA (ID, TIPO, PRECIOPRENDA) VALUES (2, 'Planchado', 2000);

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (11, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2);

INSERT INTO H_LAVANDERIA (ID, TIPO, PRECIOPRENDA) VALUES (3, 'Embolada', 4000);

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (12, 1, 0, 0, 0, 0, 0, 0, 0, 0, 3);

-- Salon reuniones

INSERT INTO H_SALONPRESTAMO (ID, TIPO, ID_HOTEL, CAPACIDAD, COSTO) VALUES (1, 'Salon reunion', 1, 12, 30000);

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (13, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);

-- Salon conferencias

INSERT INTO H_SALONPRESTAMO (ID, TIPO, ID_HOTEL, CAPACIDAD, COSTO) VALUES (2, 'Salon conferencia', 1, 100, 75000);

INSERT INTO H_SERVICIOS_HOTEL (ID, IDHOTEL, ID_SPA, ID_SUPERMERCADOTIENDA, ID_PISCINA, ID_RESTAURANTEBAR, ID_GIMNASIO, ID_PRESTAMO, ID_PRESTAMOSALON, ID_INTERNET, ID_LAV_PLAN_EMB) VALUES (14, 1, NULL, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL);







-------------------------------
-- RF12

--Revisar en un for cada hotel donde haya almenos el num pedido de habitaciones del tipo requerido, se lanza la lista de habitaciones, si no salen las habitaciones el boolean de que es apropiado para la convencion se convertiria en false y se pasaria a buscar en el siguiente hotel

SELECT ID FROM H_HABITACIONES 
FROM H_TIPO_HABITACIONES INNER JOIN H_TIPO_HABITACIONES 
ON ID_TIPO = ID 
WHERE NOMBRE = (parametro) AND (numparametro) <= 
(SELECT COUNT(*) AS NUMHABDISP
FROM H_HABITACIONES INNER JOIN H_TIPO_HABITACIONES 
ON ID_TIPO = ID 
WHERE NOMBRE = (parametro) AND ID_HOTEL = (contador));


-- Hacer unos IF por cada servicio que el cliente desee, ahi se consulta por hotel en el mismo for que lo tenga, y si no tiene alguno un boolean se haria false y se pasaria a investigar el otro hotel

-- RF13

-- Hacer un for en el cual se eliminaria la reserva de la tabla reservas una a una mientras se cambia el valor de reservada de las habitaciones a 0, y en los servicios se eliminaria la reserva, (tenr en cuenta una lista que maneje las reservas de las convenciones para saber cuales cancelar)

-- RF14

-- Modificar habitaciones para que maneje un estado que se pueda revisar, en dado caso que fuera malo se sumaria un costo a la cuenta, al ir verificando se iria colocando disponible cada habitacion.

-- RF15

-- Revisar disponibilidad de habitaciones, despues realizar un put en la cuenta con el nuevo id, agregar si es salones o servicios una reserva por mantenimiento

-- RF16

-- Simplemente pasar a disponibilidad de los seleccionados

-- RFC6 

-- En un for manejar el aumento de dia por mes para sacar en un arreglo el indice de reserva y asimismo consumo

-- RFC7 

-- En un for sobre el ultimo a�o se cuentan los dias de estadia hasta contar 15 y asimismo se va sumando el consumo hasta llegar a 15kk, lo primero que ocurra.
-- RFC8
-- Doble for externo contando cantidad de semanas para un a�o, el otro cuenta dias hasta 7 se busca la fecha de reserva indicando las veces que ha sido solicitado