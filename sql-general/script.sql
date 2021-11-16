/*TIPO DE USUARIOS*/
INSERT INTO `bd-webservice`.`tipousuario` (`id`, `tipo`) VALUES ('1', 'vendedor');
INSERT INTO `bd-webservice`.`tipousuario`       (`tipo`) VALUES     ('comprador');
/*USUARIOS*/
/* vendedor */
INSERT INTO `bd-webservice`.`usuario` (`id`, `apellido`, `contrasenia`, `dni`, `nombre`, `telefono`, `usuario`, `fk_tipousuario`) VALUES ('1', 'gonzales', '123', '38500111', 'juan', '1165879562', 'vendedor', '1');
INSERT INTO `bd-webservice`.`usuario` (`apellido`, `contrasenia`, `dni`, `nombre`, `telefono`, `usuario`, `fk_tipousuario`) VALUES ('perez', '222', '38111333', 'marcos', '1156051133', 'quitos', '1');
INSERT INTO `bd-webservice`.`usuario` (`apellido`, `contrasenia`, `dni`, `nombre`, `telefono`, `usuario`, `fk_tipousuario`) VALUES ('ramirez', '333', '40333666', 'lucia', '1165106600', 'lucy', '1');
/* comprador */
INSERT INTO `bd-webservice`.`usuario` (`apellido`, `contrasenia`, `dni`, `nombre`, `telefono`, `usuario`, `fk_tipousuario`) VALUES ('lopez', '123', '40555110', 'lucas', '1158705500', 'comprador', '2');
INSERT INTO `bd-webservice`.`usuario` (`apellido`, `contrasenia`, `dni`, `nombre`, `telefono`, `usuario`, `fk_tipousuario`) VALUES ('garcia', '111', '30555900', 'manuel', '1151005802', 'manus', '2');
INSERT INTO `bd-webservice`.`usuario` (`apellido`, `contrasenia`, `dni`, `nombre`, `telefono`, `usuario`, `fk_tipousuario`) VALUES ('flores', '444', '37888000', 'marta', '1168906677', 'marta', '2');
INSERT INTO `bd-webservice`.`usuario` (`apellido`, `contrasenia`, `dni`, `nombre`, `telefono`, `usuario`, `fk_tipousuario`) VALUES ('jimenez', '555', '36125987', 'florencia', '1167087755', 'flor', '2');


/*DOMICILIOS*/
INSERT INTO `bd-webservice`.`domicilio` (`id`, `calle`, `departamento`, `localidad`, `numero`, `pais`, `piso`, `provincia`, `fk_usuario`) VALUES ('1', 'yerbal', 'A', 'temperley', '1502', 'argentina', '2', 'buenos aires', '1');
INSERT INTO `bd-webservice`.`domicilio` (`calle`, `departamento`, `localidad`, `numero`, `pais`, `piso`, `provincia`, `fk_usuario`) VALUES ('portela', 'D', 'lanus', '608', 'argentina', '6', 'buenos aires', '2');
INSERT INTO `bd-webservice`.`domicilio` (`calle`, `departamento`, `localidad`, `numero`, `pais`, `piso`, `provincia`, `fk_usuario`) VALUES ('independencia', 'B', 'monserrat', '1450', 'Arg', '12', 'buenos aires', '3');
INSERT INTO `bd-webservice`.`domicilio` (`calle`, `departamento`, `localidad`, `numero`, `pais`, `piso`, `provincia`, `fk_usuario`) VALUES ('zapiola', 'A', 'quilmes', '956', 'argentina', '8', 'buenos aires', '4');
INSERT INTO `bd-webservice`.`domicilio` (`calle`, `departamento`, `localidad`, `numero`, `pais`, `piso`, `provincia`, `fk_usuario`) VALUES ('albarellos', 'C', 'munro', '3128', 'argentina', '1', 'buenos aires', '5');
INSERT INTO `bd-webservice`.`domicilio` (`calle`, `departamento`, `localidad`, `numero`, `pais`, `piso`, `provincia`, `fk_usuario`) VALUES ('ponce', 'A', 'munro', '1080', 'argentina', '9', 'buenos aires', '5');
INSERT INTO `bd-webservice`.`domicilio` (`calle`, `departamento`, `localidad`, `numero`, `pais`, `piso`, `provincia`, `fk_usuario`) VALUES ('culpina', 'D', 'flores', '2326', 'argentina', '4', 'buenos aires', '6');
INSERT INTO `bd-webservice`.`domicilio` (`calle`, `departamento`, `localidad`, `numero`, `pais`, `piso`, `provincia`, `fk_usuario`) VALUES ('bulnes', 'B', 'almagro', '1292', 'argentina', '5', 'buenos aires', '7');
INSERT INTO `bd-webservice`.`domicilio` (`calle`, `departamento`, `localidad`, `numero`, `pais`, `piso`, `provincia`, `fk_usuario`) VALUES ('esmeralda', 'C', 'almagro', '860', 'argentina', '1', 'buenos aires', '7');

/*TARJETAS*/
INSERT INTO `bd-webservice`.`tarjeta` (`id`, `id_tarjeta`, `id_comprador`) VALUES ('1', '1', '2');
INSERT INTO `bd-webservice`.`tarjeta` (`id`, `id_tarjeta`, `id_comprador`) VALUES ('2', '2', '2');
INSERT INTO `bd-webservice`.`tarjeta` (`id`, `id_tarjeta`, `id_comprador`) VALUES ('3', '3', '3');
INSERT INTO `bd-webservice`.`tarjeta` (`id`, `id_tarjeta`, `id_comprador`) VALUES ('4', '4', '4');
INSERT INTO `bd-webservice`.`tarjeta` (`id`, `id_tarjeta`, `id_comprador`) VALUES ('5', '5', '5');
INSERT INTO `bd-webservice`.`tarjeta` (`id`, `id_tarjeta`, `id_comprador`) VALUES ('6', '6', '6');
INSERT INTO `bd-webservice`.`tarjeta` (`id`, `id_tarjeta`, `id_comprador`) VALUES ('7', '7', '7');
INSERT INTO `bd-webservice`.`tarjeta` (`id`, `id_tarjeta`, `id_comprador`) VALUES ('8', '8', '7');

/*CATEGORIAS DE PRODUCTO*/
INSERT INTO `bd-webservice`.`categoria_producto` (`id`, `nombre`) VALUES ('1', 'ropa');
INSERT INTO `bd-webservice`.`categoria_producto` (`id`, `nombre`) VALUES ('2', 'comida');
INSERT INTO `bd-webservice`.`categoria_producto` (`id`, `nombre`) VALUES ('3', 'electrodomesticos');


/*PRODUCTOS*/
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('1', b'1', b'1', b'1', 'color negro', 'jean.jpg', 'jean', '8500', '0', '30', '1', '1');
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('2', b'1', b'1', b'1', 'color azul', 'blusa.jpg', 'blusa', '6700', '5', '10', '1', '1');
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('3', b'1', b'0', b'1', 'color blanca', 'campera.jpg', 'campera', '15200', '15', '20', '1', '1');
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('4', b'1', b'1', b'1', 'extra grande', 'hamburguesa.jpg', 'hamburguesa', '650', '85', '100', '2', '1');
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('5', b'1', b'1', b'1', 'pequeña', 'pizza.jpg', 'pizza', '700', '50', '80', '2', '2');
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('6', b'1', b'1', b'1', 'medianas', 'empanadas.jpg', 'empanadas', '15', '100', '50', '2', '2');
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('7', b'1', b'1', b'0', 'caseras', 'medialunas.jpg', 'medialunas', '500', '22', '60', '2', '2');
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('8', b'1', b'1', b'1', 'super', 'pancho.jpg', 'pancho', '500', '30', '80', '3', '2');
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('9', b'1', b'1', b'1', 'electrica', 'licuadora.jpg', 'licuadora', '8000', '8', '10', '3', '3');
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('10', b'1', b'1', b'1', 'simple', 'batidora.jpg', 'batidora', '9500', '14', '15', '3', '3');
INSERT INTO `bd-webservice`.`producto` (`id`, `activo`, `credito`, `debito`, `descripcion`, `imagen`, `nombre`, `precio`, `stock_actual`, `stock_inicial`, `fk_categoriaproducto`, `fk_usuario`) VALUES ('11', b'1', b'1', b'1', 'todo en uno', 'mixer.jpg', 'mixer', '7500', '20', '20', '3', '3');


/*BD BANCA */ 

/*TARJETAS*/
INSERT INTO `bancadb`.`tarjeta` (`idTarjeta`, `idComprador`, `limiteMensual`, `saldo`, `numero`, `cvc`, `tipo`, `nombre`, `vencimiento`) VALUES ('1', '4', '5000', '300', '123', '123', 'DEBITO', 'comprador', '2022-09-22');
INSERT INTO `bancadb`.`tarjeta` (`idTarjeta`, `idComprador`, `limiteMensual`, `saldo`, `numero`, `cvc`, `tipo`, `nombre`, `vencimiento`) VALUES ('2', '5', '10000', '10000', '456', '456', 'CREDITO', 'comprador', '2022-08-24');

INSERT INTO `bancadb`.`tarjeta` (`idTarjeta`, `idComprador`, `limiteMensual`, `saldo`, `numero`, `cvc`, `tipo`, `nombre`, `vencimiento`) VALUES ('3', '5', '8000', '6000', '45654310', '310', 'DEBITO', 'comprador', '2022-09-15');
INSERT INTO `bancadb`.`tarjeta` (`idTarjeta`, `idComprador`, `limiteMensual`, `saldo`, `numero`, `cvc`, `tipo`, `nombre`, `vencimiento`) VALUES ('4', '6', '12000', '12000', '95523001', '001', 'CREDITO', 'comprador', '2022-10-12');
INSERT INTO `bancadb`.`tarjeta` (`idTarjeta`, `idComprador`, `limiteMensual`, `saldo`, `numero`, `cvc`, `tipo`, `nombre`, `vencimiento`) VALUES ('5', '6', '20000', '20000', '12005448', '448', 'DEBITO', 'comprador', '2022-12-29');
INSERT INTO `bancadb`.`tarjeta` (`idTarjeta`, `idComprador`, `limiteMensual`, `saldo`, `numero`, `cvc`, `tipo`, `nombre`, `vencimiento`) VALUES ('6', '7', '16000', '10000', '35800124', '124', 'CREDITO', 'comprador', '2023-01-19');
INSERT INTO `bancadb`.`tarjeta` (`idTarjeta`, `idComprador`, `limiteMensual`, `saldo`, `numero`, `cvc`, `tipo`, `nombre`, `vencimiento`) VALUES ('7', '7', '13000', '8000', '65481354', '354', 'CREDITO', 'comprador', '2023-03-21');
INSERT INTO `bancadb`.`tarjeta` (`idTarjeta`, `idComprador`, `limiteMensual`, `saldo`, `numero`, `cvc`, `tipo`, `nombre`, `vencimiento`) VALUES ('8', '7', '9000', '9000', '12300548', '548', 'DEBITO', 'comprador', '2023-04-14');

/*VENTAS */ 
insert into venta values(1, "Activa", '2022-08-24', "11111", 200, 1, 1, 1, 1);
insert into venta values(2, "Activa", '2022-08-24', "11111", 200, 1, 1, 1, 1);

/*CATEGORIA DENUNCIA */ 
insert into categoria_denuncia values (1, "Fraude");
insert into categoria_denuncia values (2, "Producto Ilegal");

/*DENUNCIAS */ 
INSERT INTO denuncia values (1, null, "Me llego otro producto", null, "A Resolver",'2022-08-24', 1, 1, 1, 1);
INSERT INTO denuncia values (2, null, "El vendedor esta anunciando productos ilegales", null, "A Resolver",'2022-08-24', 2, 1, 1, 1);

/*RECLAMOS */
INSERT INTO reclamo values(1, null, "Arrepentimiento de la compra", null, "A Resolver", '2022-08-24', 1, 1);
INSERT INTO reclamo values(2, null, "Problemas con la compra", null, "A Resolver", '2022-08-24', 1, 1);

insert into tipousuario values (3, "mesadeayuda");
insert into usuario values (5, "Azcurra", "pass", "22222222", "Diego", "11111111", "diegoazcurra", 3);
