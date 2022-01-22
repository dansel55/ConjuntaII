package ec.edu.espe.examen2.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.examen2.model.Estudiante;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
    Optional<Estudiante> findByCorreo(String correo);
}
