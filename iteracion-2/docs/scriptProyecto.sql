--- Sentencias SQL para la creaci�n del esquema de parranderos
--- Las tablas tienen prefijo A_ para facilitar su acceso desde SQL Developer
 
-- USO
-- Copie el contenido de este archivo en una pesta�a SQL de SQL Developer
-- Ejec�telo como un script - Utilice el bot�n correspondiente de la pesta�a utilizada
-- Creaci�n del secuenciador
 
create sequence hoteles_sequence;
 
 
-- Creaci�n de la tabla H_HOTELES y especificaci�n de sus restricciones
CREATE TABLE H_HOTELES
   (ID VARCHAR(255), 
    NOMBRE VARCHAR2(255 BYTE), 
    UBICACION VARCHAR2(255 BYTE),
    CATEGORIA VARCHAR2(255 BYTE),
    TELEFONO VARCHAR2(255 BYTE),
    CONSTRAINT H_HOTELES_PK PRIMARY KEY (ID));
 
ALTER TABLE H_HOTELES
    ADD CONSTRAINT UN_UBICACION
    UNIQUE (UBICACION);
 
-- CREACION DE LOS SERVICIOS
 
-- Creaci�n de la tabla SPAS y especificaci�n de sus restricciones
CREATE TABLE H_SPAS
   (ID NUMBER, 
    NOMBRE VARCHAR2(255 BYTE), 
    PRECIO NUMBER,
    PAGO_ADICIONAL NUMBER,
    CONSTRAINT H_SPAS PRIMARY KEY (ID));
     
ALTER TABLE H_SPAS
    ADD CONSTRAINT CK_PRECIO_SPA
    CHECK (PRECIO>0)
    ENABLE;
    
ALTER TABLE H_SPAS
    ADD CONSTRAINT CK_PRECIO_ADICIONAL_SPA
    CHECK (PRECIO_ADICIONAL>=0)
    
ENABLE;
    
 
-- Creaci�n de la tabla SUPERMERCADOS_TIENDAS y especificaci�n de sus restricciones
CREATE TABLE H_SUPERMERCADOS_TIENDAS
   (ID VARCHAR(255), 
    NOMBRE VARCHAR2(255 BYTE), 
    PRECIO NUMBER,
    PAGO_ADICIONAL NUMBER,
    CONSTRAINT H_SUPERMERCADOS_TIENDAS PRIMARY KEY (ID));
     
ALTER TABLE H_SUPERMERCADOS_TIENDAS
    ADD CONSTRAINT CK_PRECIO_TIENDA
    CHECK (PRECIO>0)
    ENABLE;
    
ALTER TABLE H_SUPERMERCADOS_TIENDAS
    ADD CONSTRAINT CK_PRECIO_ADICIONAL_TIENDA
    CHECK (PRECIO_ADICIONAL>=0)
    
ENABLE;
 
 
-- Creaci�n de la tabla H_RESTAURANTES_BAR y especificaci�n de sus restricciones
 
CREATE TABLE H_RESTAURANTES_BAR
   (ID VARCHAR(255), 
    NOMBRE VARCHAR2(255 BYTE), 
    PRECIO NUMBER,
    PRECIO_ADICIONAL NUMBER,
    CONSTRAINT H_RESTAURANTE_BAR PRIMARY KEY (ID));
     
ALTER TABLE H_RESTAURANTES_BAR
    ADD CONSTRAINT CK_PRECIO_BAR
    CHECK (PRECIO>0)
    ENABLE;
    
ALTER TABLE H_RESTAURANTES_BAR
    ADD CONSTRAINT CK_PRECIO_ADICIONAL_BAR
    CHECK (PRECIO_ADICIONAL>=0)
 
ENABLE;
 
 
 
-- Creaci�n de la tabla H_OFRECEN y especificaci�n de sus restricciones
 
CREATE TABLE H_OFRECEN
   (ID_RESTAURANTE_BAR VARCHAR(255), 
    NOMBRE_PRODUCTO VARCHAR2(255 BYTE), 
    CONSTRAINT H_OFRECEN PRIMARY KEY (ID));
 
    ALTER TABLE H_OFRECEN
    ADD CONSTRAINT fk_id_restaurante
    FOREIGN KEY (id_restaurante_Bar)
    REFERENCES H_RESTAURANTES_BAR(id);
ENABLE;
    
 
-- Creaci�n de la tabla H_PISCINAS y especificaci�n de sus restricciones
CREATE TABLE H_PISCINAS
   (ID VARCHAR(255), 
    NOMBRE VARCHAR2(255 BYTE), 
    PRECIO NUMBER,
    PAGO_ADICIONAL NUMBER,
    CAPACIDAD NUMBER,
    HORARIO_INICIAL VARCHAR(255),
    HORARIO_FINAL VARCHAR(255),
    CONSTRAINT H_PISCINAS PRIMARY KEY (ID));
     
ALTER TABLE H_PISCINAS
    ADD CONSTRAINT CK_PRECIO_PISCINA
    CHECK (PRECIO>0)
    ENABLE;
    
ALTER TABLE H_PISCINAS
    ADD CONSTRAINT CK_PRECIO_ADICIONAL_PISCINA
    CHECK (PRECIO_ADICIONAL>=0)
    ENABLE;
    
ALTER TABLE H_PISCINAS
    ADD CONSTRAINT CK_CAPACIDAD_PISCINAS
    CHECK (CAPACIDAD>0)
ENABLE;
 
     
-- Creaci�n de la tabla H_GIMNASIOS y especificaci�n de sus restricciones
 
CREATE TABLE H_GIMNASIOS
   (ID VARCHAR(255), 
    NOMBRE VARCHAR2(255 BYTE), 
    PRECIO NUMBER,
    PRECIO_ADICIONAL NUMBER,
    CONSTRAINT H_GIMNASIOS PRIMARY KEY (ID));
     
ALTER TABLE H_GIMNASIOS
    ADD CONSTRAINT CK_PRECIO_GIMNASIO
    CHECK (PRECIO>0)
    ENABLE;
    
ALTER TABLE H_GIMNASIOS
    ADD CONSTRAINT CK_PRECIO_ADICIONAL_GIMNASIO
    CHECK (PRECIO_ADICIONAL>=0)
 
ENABLE;

CREATE TABLE H_TIENEN_MAQUINAS 
 
   (ID_GIMNASIO VARCHAR(255),  
    NOMBRE_MAQUINA VARCHAR2(255 BYTE),  
    CONSTRAINT H_TIENEN_MAQUINAS PRIMARY KEY (ID_GIMNASIO)); 
    
    
    ALTER TABLE H_TIENEN_MAQUINAS
    ADD CONSTRAINT FK_TIENEN_MAQUINAS
    FOREIGN KEY (ID_GIMNASIO)
    REFERENCES H_GIMNASIOS(id)
    ENABLE;
 
-- Creaci�n de la tabla H_PRESTAMOS_SALONES y especificaci�n de sus restricciones
 
CREATE TABLE H_PRESTAMOS_SALONES
   (ID VARCHAR(255), 
    TIPO_SALON VARCHAR2(255 BYTE),
    NOMBRE VARCHAR2(255 BYTE), 
    CAPACIDAD NUMBER,
    RESERVADO BOOLEAN,
    COSTO_HORA NUMBER,
    HORARIO_INICIAL DATE,
    HORARIO_FINAL DATE ,
    CONSTRAINT H_PRESTAMOS_SALONES PRIMARY KEY (ID));
     
ALTER TABLE H_PRESTAMOS_SALONES  
 
    ADD CONSTRAINT CK_COSTO_PRESTAMO_SALONES 
 
    CHECK (COSTO_HORA>0) 
 
    ENABLE;
    
ALTER TABLE H_PRESTAMOS_SALONES
    ADD CONSTRAINT CK_PRECIO_ADICIONAL_SALONES
    CHECK (PRECIO_ADICIONAL>=0)
 
ENABLE;
 
-- Creaci�n de la tabla H_PRODUCTOS_INSTALACIONES y especificaci�n de sus restricciones
 
CREATE TABLE H_PRODUCTOS_INSTALACIONES
   (ID_SALON VARCHAR(255),
    NOMBRE_ITEM VARCHAR2(255 BYTE),
    PRECIO_ITEM NUMBER,
    CONSTRAINT ID_SALON PRIMARY KEY (ID_SALON));
 
ALTER TABLE H_PRODUCTOS_INSTALACIONES
    ADD CONSTRAINT fk_id_salon
    FOREIGN KEY (id_salon)
    REFERENCES H_PRESTAMOS_SALONES(id);
ENABLE;
    
    
  
CREATE TABLE H_LAV_PLAN_EMB 
 
   (ID VARCHAR(255), 
 
    TIPO VARCHAR2(255 BYTE), 
 
    CANT_ITEM NUMBER, 
 
    PRECIO NUMBER, 
 
    CONSTRAINT ID_LAV_PLAN_EMB_PK PRIMARY KEY (ID)); 
 
  
 
ALTER TABLE H_LAV_PLAN_EMB 
 
    ADD CONSTRAINT CK_CANT_ITEM 
 
    CHECK (CANT_ITEM>0) 
 
ENABLE; 
 
     
 
    ALTER TABLE H_LAV_PLAN_EMB 
 
    ADD CONSTRAINT CK_PRECIO_LAV_PLAN_EMB 
 
    CHECK (PRECIO>0) 
 
ENABLE;
 
    
    -- Creaci�n de la tabla H_PRESTAMOS_UTENSILIOS y especificaci�n de sus restricciones
 

CREATE TABLE H_PRESTAMOS_UTENSILIOS 
 
   (ID VARCHAR(255), 
 
    ID_UTENSILIO NUMBER, 
 
    NOMBRE  VARCHAR2(255 BYTE), 
 
    DEVUELTO_BUEN_ESTADO CHAR(1), 
 
    CARGO_ADICIONAL NUMBER, 
 
    CONSTRAINT ID_PRESTAMOS_UTENSILIOS_PK PRIMARY KEY (ID));
-- Creaci�n de la tabla H_TIPOS_HABITACIONES y especificaci�n de sus restricciones
 
CREATE TABLE H_TIPOS_HABITACIONES
   (ID VARCHAR(255),
    ITEM_ACOMODACION VARCHAR2(255 BYTE),
    NOMBRE_TIPO VARCHAR(20),
    CONSTRAINT ID PRIMARY KEY (ID));
    
    -- Creaci�n de la tabla H_HABITACIONES y especificaci�n de sus restricciones
 
CREATE TABLE H_HABITACIONES
   (ID VARCHAR(255),
    TIPO VARCHAR2(255 BYTE),
    ID_TIPO NUMBER,
    OCUPADA BOOLEAN,
    CONSTRAINT ID_HABITACION_PK PRIMARY KEY (ID));
 
ALTER TABLE H_HABITACIONES
    ADD CONSTRAINT fk_tipo_Habi
    FOREIGN KEY (id_tipo)
    REFERENCES H_TIPOS_HABITACIONES(id);
ENABLE;
    
-- Creaci�n de la tabla H_CLIENTES y especificaci�n de sus restricciones
CREATE TABLE H_CLIENTES
   (ID VARCHAR(255), 
    NOMBRE VARCHAR2(255 BYTE), 
    TELEFONO NUMBER,
    CORREO VARCHAR2(255 BYTE),
    ID_PLAN VARCHAR2(255 BYTE) ,
    ID_RESERVACION_HOTEL VARCHAR(255),
    ID_RESERVACION_SERVICIOS VARCHAR(255)
    ID_SERVICIOS_HOTEL VARCHAR(255),
    ID_CUENTA VARCHAR(255),
    CONSTRAINT H_CLIENTES_PK PRIMARY KEY (ID));
    
ALTER TABLE H_CLIENTES
    ADD CONSTRAINT fk_plan
    FOREIGN KEY (id_plan)
    REFERENCES H_PLANES(id);
ENABLE;
 
ALTER TABLE H_CLIENTES
    ADD CONSTRAINT fk_reservacion_hotel
    FOREIGN KEY (id_reservacion_hotel)
    REFERENCES H_RESERVACIONES_HOTEL(id);
ENABLE;
 
ALTER TABLE H_CLIENTES
    ADD CONSTRAINT fk_reservacion_servicios
    FOREIGN KEY (id_reservacion_servicios)
    REFERENCES H_RESERVACIONES_SERVICIOS(id_reservacion_servicios);
ENABLE;
 
ALTER TABLE H_CLIENTES
    ADD CONSTRAINT fk_servicios_hotel
    FOREIGN KEY (id_servicios_hotel)
    REFERENCES H_SERVICIOS_HOTEL(id_servicios_hotel);
ENABLE;
 
ALTER TABLE H_CLIENTES
    ADD CONSTRAINT fk_cuenta
    FOREIGN KEY (id_cuenta)
    REFERENCES CUENTAS(id_cuenta);
ENABLE;
 
-- Creaaci�n de la tabla H_SERVICIOS_HOTEL y especificaci�n de sus restricciones
CREATE TABLE H_SERVICIOS_HOTEL 
   (ID VARCHAR(255), 
    ID_SPA VARCHAR(255),
    ID_RESTAURANTE_BAR VARCHAR(255),
    ID_SUPERMERCADO_TIENDA VARCHAR(255),
    ID_PISCINA VARCHAR(255),
    ID_GIMNASIO VARCHAR(255),
    ID_PRESTAMO_SALON VARCHAR(255),
    ID_INTERNET  VARCHAR(255),
    ID_LAV_PLAN_EMB VARCHAR(255),
 
    CONSTRAINT H_SERVICIOS_HOTEL_PK PRIMARY KEY (ID));
    
ALTER TABLE H_SERVICIOS_HOTEL
    ADD CONSTRAINT fk_spa
    FOREIGN KEY (id_spa)
    REFERENCES H_SPAS(id_spa);
ENABLE;
 
ALTER TABLE H_SERVICIOS_HOTEL
    ADD CONSTRAINT fk_restauranteBar
    FOREIGN KEY (id_restaurante_Bar)
    REFERENCES H_RESTAURANTE_BAR(id_restaurante_Bar);
ENABLE;
 
ALTER TABLE H_SERVICIOS_HOTEL
    ADD CONSTRAINT fk_supermercado_Tienda
    FOREIGN KEY (id_supermercado_Tienda)
    REFERENCES H_SUPERMERCADOS_TIENDAS(id_supermercado_tienda);
ENABLE;
 
ALTER TABLE H_SERVICIOS_HOTEL
    ADD CONSTRAINT fk_piscina
    FOREIGN KEY (id_piscina)
    REFERENCES H_PISCINAS(id_piscina);
ENABLE;
 
 
ALTER TABLE H_SERVICIOS_HOTEL
    ADD CONSTRAINT fk_gimnasio
    FOREIGN KEY (id_gimnasio)
    REFERENCES H_GIMNASIOS(id_gimnasio);
ENABLE;
 
ALTER TABLE H_SERVICIOS_HOTEL
    ADD CONSTRAINT fk_prestamo_salon
    FOREIGN KEY (id_prestamo_salon)
    REFERENCES H_PRESTAMOS_SALONES(id_prestamo_salon);
ENABLE;
 
ALTER TABLE H_SERVICIOS_HOTEL
    ADD CONSTRAINT fk_internet
    FOREIGN KEY (id_internet)
    REFERENCES H_INTERNET(id_internet);
ENABLE;
 
ALTER TABLE H_SERVICIOS_HOTEL
    ADD CONSTRAINT fk_lav_plan_emb
    FOREIGN KEY (id_lav_plan_emb)
    REFERENCES H_LAV_PLAN_EMB(id_lav_plan_emb);
ENABLE;
 
 
 
-- Creaci�n de la tabla EMPLEADOS y especificaci�n de sus restricciones
CREATE TABLE H_EMPLEADOS
   (ID VARCHAR(255), 
    NOMBRE VARCHAR2(255 BYTE), 
    ROL VARCHAR2(255 BYTE), 
    CONSTRAINT H_EMPLEADOS_ID PRIMARY KEY (ID));
     
ALTER TABLE H_EMPLEADOS
    ADD CONSTRAINT CK_ROL
    CHECK (PRESUPUESTO IN ('Gerente', 'Admin_Datos', 'Empleado', 'Recepcionista'))
 
ENABLE;
 
-- Creaci�n de la tabla PLANES y especificaci�n de sus restricciones
CREATE TABLE H_PLANES
   (ID VARCHAR(255), 
    NOMBRE VARCHAR2(255 BYTE), 
    DESCUENTO NUMBER, 
    NUM_NOCHES NUMBER, 
    CONSTRAINT H_PLANES_PK PRIMARY KEY(ID));
 
ALTER TABLE H_PLANES
    ADD CONSTRAINT CK_NUM_NOCHES
    CHECK (NUM_NOCHES>0)
ENABLE;
 
-- Creaaci�n de la tabla RESERVAN_SERVICIOS y especificaci�n de sus restricciones
CREATE TABLE H_RESERVAN_SERVICIOS
(
  ID_SALON VARCHAR(255),
  NOMBRE_ITEM VARCHAR2(255 BYTE),
  PRECIO NUMBER,
  CONSTRAINT H_RESERVAN_SERVICIOS_PK PRIMARY KEY (ID));
 
ALTER TABLE H_RESERVAN_SERVICIOS
ADD CONSTRAINT fk_id_salon
    FOREIGN KEY (idbebedor)
    REFERENCES h_salones(id)
ENABLE;
    
      
    
ALTER TABLE H_OCUPAN
ADD CONSTRAINT fk_id_cliente
    FOREIGN KEY (id_cliente)
    REFERENCES H_CLIENTES(id_cliente)
ENABLE;
    
 
CREATE TABLE H_RESERVACIONES_HOTEL
(
ID VARCHAR(255),
FECHA_LLEGADA DATE,
FECHA_PARTIDA DATE,
NUM_PERSONAS NUMBER,
PLAN_PAGO NUMBER,
  CONSTRAINT H_RESERVACIONES_PK PRIMARY KEY (ID));
--Creacion de la tabla cuentas
CREATE TABLE H_CUENTAS (
    ID VARCHAR (255),
    CUENTA FLOAT,
    NUMERO_SERVICIOS INT,
    PRIMARY KEY(ID)
);
 --Creacion de la tabla habitaciones
CREATE TABLE H_HABITACIONES
(
ID  VARCHAR(255) NOT NULL,
ID_TIPO INT NOT NULL CHECK(ID_TIPO <= 5 AND ID_TYPE > 0),
OCUPADA INT,
 
PRIMARY KEY(ID), 
FOREIGN KEY (ID_TIPO) REFERENCES H_TIPOS_HABITACIONES(ID) 
 
);
 
 --Creacion de la relacion ocupan
CREATE TABLE H_OCUPAN(
ID_CLIENTE VARCHAR(255),
ID_HABITACION VARCHAR(255) NOT NULL,
 
PRIMARY KEY (ID_CLIENTE), 
FOREIGN KEY (ID_HABITACION) REFERENCES H_HABITACIONES(ID) 
);

  
--Crea la tabla que contiene los productos ofertados por restaurantes y bares
CREATE TABLE H_OFRECEN(
ID_SERVICIO VARCHAR(255),
ID_PRODUCTO VARCHAR(255) NOT NULL,

PRIMARY KEY (ID_SERVICIO),
FOREIGN KEY (ID_SERVICIO)  REFERENCES H_RESTAURANTES_BAR (ID) 
)
 
 -- Creaci�n de la tabla H_RESTAURANTES_BAR y especificaci�n de sus restricciones
 
CREATE TABLE H_ROLES
   (ID VARCHAR(255), 
    NOMBRE VARCHAR2(255 BYTE), 
	DESCRIPCION VARCHAR2(255 BYTE),
    CONSTRAINT H_RESTAURANTE_BAR PRIMARY KEY (ID));
     
ALTER TABLE H_EMPLEADOS
    ADD CONSTRAINT CK_NOMBRE_ROL
    CHECK (NOMBRE IN ('Gerente', 'Admin_Datos', 'Empleado', 'Recepcionista')) 
ENABLE;
 
 
 
COMMIT;
