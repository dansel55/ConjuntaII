package ec.edu.espe.examen2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.examen2.config.Configuraciones;
import ec.edu.espe.examen2.dao.CursoRepository;
import ec.edu.espe.examen2.dao.EstudianteRepository;
import ec.edu.espe.examen2.dto.EstudianteDto;
import ec.edu.espe.examen2.dto.InformacionMatriculaDto;
import ec.edu.espe.examen2.dto.MatriculaDto;
import ec.edu.espe.examen2.exception.BussinesRuleException;
import ec.edu.espe.examen2.exception.EntityExistsException;
import ec.edu.espe.examen2.exception.EntityNotFoundException;
import ec.edu.espe.examen2.model.Curso;
import ec.edu.espe.examen2.model.Estudiante;
import ec.edu.espe.examen2.model.Matricula;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Estudiante guardarEstudiante(EstudianteDto estudianteDto) {
        Optional<Estudiante> estudianteOpt = this.estudianteRepository.findByCorreo(estudianteDto.getCorreo());
        if(estudianteOpt.isEmpty()) {
            throw new EntityExistsException("Ya existe un estudiante registrado con este correo");
        }
        Estudiante estudiante = Estudiante.builder()
            .correo(estudianteDto.getCorreo())
            .estado(Configuraciones.ESTADOS_ESTUDIANTE.ACTIVO.getEstado())
            .fechaCreacion(new Date())
            .fechaNacimiento(estudianteDto.getFechaNacimiento())
            .nombre(estudianteDto.getNombre())
            .pais(estudianteDto.getPais())
            .matricula(new ArrayList<>())
            .build();
        
        return this.estudianteRepository.save(estudiante);
    }

    public InformacionMatriculaDto matricularEstudiante(MatriculaDto matriculaDto) {
        Optional<Estudiante> estudianteOpt = this.estudianteRepository.findByCorreo(matriculaDto.getIdEstudiante());
        if(estudianteOpt.isEmpty()) {
            throw new EntityNotFoundException("No es encontro un estudiante con el id enviado");
        }

        Optional<Curso> cursoOpt = this.cursoRepository.findByCodigo(matriculaDto.getIdCurso());
        if(cursoOpt.isEmpty()) {
            throw new EntityNotFoundException("No es encontro un curso con el id enviado");
        }

        Estudiante estudiante = estudianteOpt.get();

        Curso curso = cursoOpt.get();

        if(estudiante.getMatricula().stream().filter(m -> m.getEstado()).collect(Collectors.toList()).size() > 0) {
            throw new BussinesRuleException("El estudiante ya tiene un curso activo");
        }

        Matricula matricula = Matricula.builder()
            .curso(curso)
            .estado(true)
            .fechaMatricula(new Date())
            .build();
        List<Matricula> matriculas = estudiante.getMatricula();
        matriculas.add(matricula);
        estudiante.setMatricula(matriculas);
        this.estudianteRepository.save(estudiante);
        return InformacionMatriculaDto.builder()
            .matricula(matricula)
            .nombreEstudiante(estudiante.getNombre())
            .build();
    }
}
