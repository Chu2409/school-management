CREATE DATABASE plataforma_uta;
USE plataforma_uta;

CREATE TABLE usuarios (
id INT NOT NULL AUTO_INCREMENT,
usuario VARCHAR(60) NOT NULL,
clave VARCHAR(60) NOT NULL,
cedula VARCHAR(30) NOT NULL,
nombre VARCHAR(100) NOT NULL,
apellido VARCHAR(100) NOT NULL,
email VARCHAR(255) NOT NULL,
direccion VARCHAR(255) NULL,
fotografia VARCHAR(255) NULL,
estado INT NOT NULL DEFAULT 0,
PRIMARY KEY(id)
);

CREATE TABLE roles (
id INT NOT NULL AUTO_INCREMENT,
rol VARCHAR(30) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE usuario_rol (
id INT NOT NULL AUTO_INCREMENT,
usuario_id INT NOT NULL,
rol_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(usuario_id) REFERENCES usuarios(id),
FOREIGN KEY(rol_id) REFERENCES roles(id)
);

CREATE TABLE cursos (
id INT NOT NULL AUTO_INCREMENT,
curso VARCHAR(100) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE materias (
id INT NOT NULL AUTO_INCREMENT,
materia VARCHAR(200) NOT NULL,
curso_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(curso_id) REFERENCES cursos(id)
);

CREATE TABLE usuario_materia (
id INT NOT NULL AUTO_INCREMENT,
materia_id INT NOT NULL,
usuario_rol_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(materia_id) REFERENCES materias(id),
FOREIGN KEY(usuario_rol_id) REFERENCES usuario_rol(id)
);

CREATE TABLE tareas (
id INT NOT NULL AUTO_INCREMENT,
tarea VARCHAR(200) NOT NULL,
descripcion VARCHAR(255) NOT NULL,
ubicacion VARCHAR(255) NULL,
PRIMARY KEY(id)
);

CREATE TABLE usuario_materia_tarea (
id INT NOT NULL AUTO_INCREMENT,
tarea_id INT NULL,
nota DOUBLE NULL,
envio VARCHAR(255) NULL,
usuario_materia_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(tarea_id) REFERENCES tareas(id),
FOREIGN KEY(usuario_materia_id) REFERENCES usuario_materia(id)
);

INSERT INTO roles(rol) VALUES("Estudiante"), ("Profesor"), ("Administrador");

INSERT INTO usuarios(usuario, clave, cedula, nombre, apellido, email) VALUES("daniel12", "1234", "0707047643", "Erick Daniel", "Zhu Ordoñez", "ezhu7643@uta.edu.ec"),
("fernando", "1234", "0706164233", "Luis Fernando", "Zhu Ordoñez", "lzhu4233@uta.edu.ec"), ("mishel", "1234", "0751020942", "Maylin Mishel", "Davila Nuñez", "mdavila0942@uta.edu.ec"),
("doris28", "1234", "0703224345", "Doris Giovanna", "Ordoñez Marquez", "dordonez4345@uta.edu.ec"), ("danny", "1234", "0703224337", "Danny Mauricio", "Ordoñez Marquez", "dmauricio4337@uta.edu.ec"),
("jerovy", "1234", "0750286445", "Jerovy", "Yaguana", "jyaguana6445@uta.edu.ec"), ("pablito", "1234", "1850046317", "Pablo Martin", "Villacres Morales", "pvillacres6317@uta.edu.ec"),
("milton", "1234", "0706388295", "Milton Sebastian", "Monteros Mogrovejo", "mmonteros8295@uta.edu.ec"), ("stefano", "1234", "0706388741", "Stefano", "Aus Gomez", "saus8741@uta.edu.ec"),
("mogro", "1234", "0704879741", "Santiago", "Mogrovejo", "smogro9741@uta.edu.ec"), ("villota", "1234", "0753489871", "Franklin", "Villota", "villota9871@uta.edu.ec"),
("manuel", "1234", "1801877729", "Manuel", "Turizo", "mturizo7729@uta.edu.ec"), ("valentina", "1234", "0913734661", "Valentina", "Davila", "vdavila4661@uta.edu.ec");

INSERT INTO usuario_rol(usuario_id, rol_id) VALUES(1, 3), (2, 2), (3, 3), (4, 1), (5, 1), (6, 1), (7, 1), (8, 2), (9, 2), (10, 2), (11, 1), (12, 1), (13, 1);

INSERT INTO cursos(curso) VALUES("Primer Semestre"), ("Segundo Semestre");

INSERT INTO materias(materia, curso_id) VALUES("Programacion", 1), ("Calculo Diferencial", 1), ("Logica Matematica", 1), ("POO", 2), ("Calculo Integral", 2);

INSERT INTO usuario_materia(materia_id, usuario_rol_id) VALUES
(1, 2), (2, 8), (3, 9), (4, 10), (5, 2),
(1, 4), (1, 5), (1, 6), (1, 7), (1, 11), (1, 12), (1, 13), (2, 4), (2, 5), (2, 6), (2, 7), (2, 11), (2, 12), (2, 13), (3, 4), (3, 5), (3, 6),(3, 7), (3, 11), (3, 12), (3, 13), 
(4, 4), (4, 5), (4, 6), (4, 7), (4, 11), (4, 12), (4, 13), (5, 4), (5, 5), (5, 6), (5, 7), (5, 11), (5, 12), (5, 13);

INSERT INTO tareas(tarea, descripcion, ubicacion) VALUES("Tarea de Progra", "Realizar un algoritmo de validacion de cedula ecuatoriana", "C:/Users/Daniel/Documents/Tareas/TareaProgra.pdf"), 
("Tarea de Calculo", "Realizar los ejercicios propuestos", "C:/Users/Daniel/Documents/Tareas/TareaCalculo.pdf");

INSERT INTO usuario_materia_tarea(tarea_id, nota, envio, usuario_materia_id) VALUES(1, null, null, 1), (2, null, null, 2), (1, null, null, 6),
(1, null, null, 7), (1, null, null, 8), (1, null, null, 9), (1, null, null, 10), (1, null, null, 11), (2, null, null, 12), (2, null, null, 13), (2, null, null, 14), (2, null, null, 15), (2, null, null, 16), 
(2, null, null, 17), (2, null, null, 18), (2, null, null, 19);











