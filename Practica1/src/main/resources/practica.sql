drop database if exists practica;
drop user if exists 'usuario_practica';

CREATE database practica
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;
  
  -- Creación de usuarios con contraseñas seguras (idealmente asignadas fuera del script)
  create user 'usuario_practica'@'%' identified by 'la_Clave.';
  
  -- Asignación de permisos
  grant select, insert, update, delete on practica.* to 'usuario_practica'@'%';
  flush privileges;
  
  use practica;
  
-- Tabla de suculentas
create table suculenta (
  id_suculenta int not null auto_increment,
  nombre_comun VARCHAR(60) NOT NULL,
  nombre_cientifico VARCHAR(100) NOT NULL,
  familia varchar(60),
  color_principal varchar(30),
  altura_cm int not null check (altura_cm > 0),
  precio_estimado decimal(10,2) not null check (precio_estimado > 0),
  nivel_riego varchar(20) not null,
  ruta_imagen varchar(1024),
  activo boolean not null default true,
  fecha_creacion timestamp default current_timestamp,
  fecha_modificacion timestamp default current_timestamp on update current_timestamp,
  primary key (id_suculenta),
  unique (nombre_cientifico))
  ENGINE = InnoDB;
  
 -- Inserción de suculentas
 insert into suculenta (nombre_comun, nombre_cientifico, familia, color_principal, altura_cm, precio_estimado, nivel_riego, ruta_imagen, activo) values 
 ('Planta de jade', 'Crassula ovata', 'Crassulaceae', 'Verde', 25, 3500, 'Bajo', 'https://macetitas.es/wp-content/uploads/2025/08/arbol-de-jade-en-maceta.webp', true),
 ('Rosa de alabastro', 'Echeveria elegans', 'Crassulaceae', 'Verde azulado', 12, 2500, 'Bajo', 'https://gardencentershop.com/media/imgs/almacen_articulo/d5d845ca-30ee-4e5b-a848-c1cf94fb24d5/18.jpg', true),
 ('Aloe vera', 'Aloe vera', 'Asphodelaceae', 'Verde', 30, 4000, 'Bajo', 'https://www.purenature.co.nz/cdn/shop/products/purenaturenz-aloe-25g-aloe-vera-powder-22701491781676.png?v=1781067146', true),
 ('Cola de burro', 'Sedum morganianum', 'Crassulaceae', 'Verde claro', 20, 3000, 'Bajo', 'https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1682588221-61LMwuapAEL.jpg?crop=1xw:1.00xh;center,top&resize=980:*', false),
 ('Planta panda', 'Kalanchoe tomentosa', 'Crassulaceae', 'Verde grisáce', 15, 2800, 'Bajo', 'https://jardindesuculentas.com/wp-content/uploads/2020/11/comprar-kalanchoe-tomentosa-online.jpg.webp', true),
 ('Corona de espinas', 'Euphorbia milii', 'Euphorbiaceae', 'Verde', 35, 4500, 'Medio', 'https://i.ebayimg.com/images/g/QbAAAeSwD2NprMI9/s-l1200.webp', false)