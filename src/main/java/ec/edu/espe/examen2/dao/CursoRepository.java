package ec.edu.espe.examen2.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.examen2.model.Curso;

public interface CursoRepository extends MongoRepository<Curso, String> {
    List<Curso> findByAreaAndFechaInicioGreaterThan(String area, Date fechaInicio);
    List<Curso> findByNombreLikeAndFechaInicioGreaterThan(String nombre, Date fechaInicio);
    Optional<Curso> findByCodigo(String codigo);
}
