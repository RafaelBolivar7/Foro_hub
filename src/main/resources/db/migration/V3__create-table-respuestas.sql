
CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    status ENUM('ACTIVE', 'INACTIVE', 'RESOLVED') NOT NULL,
    idAutor BIGINT,
    curso VARCHAR(255) NOT NULL,
    activo TINYINT NOT NULL,
    FOREIGN KEY (idAutor) REFERENCES usuarios(id)
);
