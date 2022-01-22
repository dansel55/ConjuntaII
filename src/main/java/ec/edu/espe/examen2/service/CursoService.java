package ec.edu.espe.examen2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.examen2.dao.CursoRepository;
import ec.edu.espe.examen2.model.Curso;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> buscarPorArea(String area) {
        return this.cursoRepository.findByAreaAndFechaInicioGreaterThan(area, new Date());
    }

    public List<Curso> buscarPorNombre(String nombre) {
        return this.cursoRepository.findByNombreLikeAndFechaInicioGreaterThan(nombre, new Date());
    }
}
