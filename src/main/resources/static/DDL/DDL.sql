create table opticas(
    id_optica SERIAL NOT NULL,
    nombre_optica VARCHAR(25) NOT NULL,
    direccion_optica VARCHAR(50) NOT NULL,
    id_usuario INT NOT NULL,
    id_paciente INT NOT NULL,
    PRIMARY KEY(idOptica)
)

create table pacientes(
    id_paciente SERIAL NOT NULL,
    identificacion_paciente VARCHAR(25) NOT NULL,
    nombres_paciente VARCHAR(50) NOT NULL,
    apellido_paciente VARCHAR(25) NOT NULL,
    fechaNacimiento_paciente DATE NOT NULL,
    direccion_paciente VARCHAR(100) NOT NULL,
    correo_paciente VARCHAR(50) NOT NULL,
    id_ciudad INT NOT NULL,
    PRIMARY KEY(id_paciente)
)

create table ciudades(
    id_ciudad INT AUTO_INCREMENT NOT NULL,
    nombre_ciudad VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_ciudad)
)

create table citas(
    idCita INT AUTO_INCREMENT NOT NULL,
    fechaCita DATE NOT NULL,
    idPaciente INT NOT NULL,
    PRIMARY KEY(idCita)
)
create table usuarios(
    idUsuario INT AUTO_INCREMENT NOT NULL,
    nombreUsuario VARCHAR(50)  NOT NULL,
    contraseñaUsuario VARCHAR(25) NOT NULL,
    PRIMARY KEY(idUsuario)
)
create table proveedores_opticas(
    idProveedor INT NOT NULL,
    idOptica INT NOT NULL,
    PRIMARY KEY(idProveedor, idOptica)
)
create table proveedores(
    idProveedor INT AUTO_INCREMENT NOT NULL,
    nombreProveedor VARCHAR(50) NOT NULL,
    telefonoProveedor VARCHAR(10) NOT NULL,
    coreoProveedor VARCHAR(50) NOT NULL,
    PRIMARY KEY(idProveedor)
)

create table productos(
    idProducto INT AUTO_INCREMENT NOT NULL,
    codigoProducto INT NOT NULL,
    nombreProducto VARCHAR(50) NOT NULL,
    descripcionProducto VARCHAR(100) NOT NULL,
    precioProducto INT NOT NULL,
    existenciasProducto INT NOT NULL,
    idProveedor INT NOT NULL,
    PRIMARY KEY(idProducto)
)