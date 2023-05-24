create table opticas(
    id_optica SERIAL NOT NULL,
    nombre_optica VARCHAR(25) NOT NULL,
    direccion_optica VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_optica)
)
ALTER TABLE opticas OWNER TO user_java;

create table pacientes(
    id_paciente SERIAL NOT NULL,
    identificacion_paciente VARCHAR(25) NOT NULL,
    nombres_paciente VARCHAR(50) NOT NULL,
    apellido_paciente VARCHAR(25) NOT NULL,
    fechanacimiento_paciente DATE NOT NULL,
    direccion_paciente VARCHAR(100) NOT NULL,
    correo_paciente VARCHAR(50) NOT NULL,
    id_ciudad INT4 NOT NULL,
    id_optica INT4 NOT NULL,
    PRIMARY KEY(id_paciente)
)
ALTER TABLE pacientes OWNER TO user_java;

create table ciudades(
    id_ciudad SERIAL NOT NULL,
    nombre_ciudad VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_ciudad)
)

ALTER TABLE ciudades OWNER TO user_java;

create table citas(
    id_cita SERIAL NOT NULL,
    fecha_cita DATE NOT NULL,
	precio_cita INT NOT NULL,
	eps_cita VARCHAR(20) NOT NULL,
	motivo_cita VARCHAR(50) NOT NULL,
    id_paciente INT4 NOT NULL,
	id_doctor INT4 NOT NULL,
    PRIMARY KEY(id_cita)
)

ALTER TABLE citas OWNER TO user_java;

create table usuarios(
    id_usuario SERIAL NOT NULL,
    nombre_usuario VARCHAR(50)  NOT NULL,
    contrasenia_usuario VARCHAR(25) NOT NULL,
    id_optica INT4 NOT NULL,
    PRIMARY KEY(id_usuario)
)

ALTER TABLE usuarios OWNER TO user_java;

create table proveedores_opticas(
	id_proveedores_opticas SERIAL NOT NULL,
    id_proveedor INT4 NOT NULL,
    id_optica INT4 NOT NULL,
    PRIMARY KEY(id_proveedores_opticas)
)
ALTER TABLE proveedores_opticas OWNER TO user_java;

create table proveedores(
    id_proveedor SERIAL NOT NULL,
    nombre_proveedor VARCHAR(50) NOT NULL,
    telefono_proveedor VARCHAR(10) NOT NULL,
    correo_proveedor VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_proveedor)
)

ALTER TABLE proveedores OWNER TO user_java;

create table productos(
    id_producto SERIAL NOT NULL,
    codigo_producto INT NOT NULL,
    nombre_producto VARCHAR(50) NOT NULL,
    descripcion_producto VARCHAR(100) NOT NULL,
    precio_producto INT NOT NULL,
    existencias_producto INT NOT NULL,
    id_proveedor INT4 NOT NULL,
    PRIMARY KEY(id_producto)
)

ALTER TABLE productos OWNER TO user_java;

create table doctores(
	id_doctor SERIAL NOT NULL,
	nombre_doctor VARCHAR(25) NOT NULL,
	apellido_doctor VARCHAR(25) NOT NULL,
	especialidad_doctor VARCHAR(30) NOT NULL,
	aniosexperiencia_doctor VARCHAR(10),
	PRIMARY KEY(id_doctor)
	
)

ALTER TABLE doctores OWNER TO user_java;

ALTER TABLE productos ADD CONSTRAINT productos_proveedores_FK
FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor) ON DELETE CASCADE;

ALTER TABLE proveedores_opticas ADD CONSTRAINT proveedores_opticas_proveedores_FK
FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor) ON DELETE CASCADE;

ALTER TABLE proveedores_opticas ADD CONSTRAINT proveedores_opticas_opticas_FK
FOREIGN KEY (id_optica) REFERENCES opticas(id_optica)ON DELETE CASCADE;

ALTER TABLE usuarios ADD CONSTRAINT usuarios_opticas_FK
FOREIGN KEY (id_optica) REFERENCES opticas(id_optica) ON DELETE CASCADE;

ALTER TABLE pacientes ADD CONSTRAINT pacientes_opticas_FK
FOREIGN KEY (id_optica) REFERENCES opticas(id_optica) ON DELETE CASCADE;

ALTER TABLE pacientes ADD CONSTRAINT pacientes_ciudades_FK
FOREIGN KEY (id_ciudad) REFERENCES ciudades(id_ciudad) ON DELETE CASCADE;

ALTER TABLE citas ADD CONSTRAINT citas_pacientes_FK
FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente) ON DELETE CASCADE;

ALTER TABLE citas ADD CONSTRAINT citas_doctores_FK
FOREIGN KEY (id_doctor) REFERENCES doctores(id_doctor) ON DELETE CASCADE;