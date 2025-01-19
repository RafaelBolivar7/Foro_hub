CREATE TABLE respuestas (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fechaCreacion DATETIME NOT NULL,
    solucion TEXT NOT NULL,
    autor BIGINT,
    topico BIGINT,
    activo TINYINT NOT NULL,
    FOREIGN KEY (autor) REFERENCES usuarios(id),
    FOREIGN KEY (topico) REFERENCES topicos(id)
);