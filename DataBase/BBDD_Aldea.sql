
USE b3matpuuqlbuahg03lto;

CREATE TABLE ninja (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    rango DECIMAL(10, 2),
    aldea VARCHAR(100) 
);

CREATE TABLE mision (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    rango DECIMAL(10, 2),
    recompensa VARCHAR(100) 
);

CREATE TABLE mision_ninja (
    ID_ninja INT NOT NULL,
    ID_mision INT NOT NULL,
    fechaInicio DATE,
    fechaFin DATE,
    PRIMARY KEY (ID_ninja, ID_mision),
    FOREIGN KEY (ID_ninja) REFERENCES ninja(ID),
    FOREIGN KEY (ID_mision) REFERENCES mision(ID)
);

CREATE TABLE habilidad (
	ID_ninja INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    PRIMARY KEY (ID_ninja),
    FOREIGN KEY (ID_ninja) REFERENCES ninja(ID)
);