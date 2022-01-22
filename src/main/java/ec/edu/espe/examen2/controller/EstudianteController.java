package ec.edu.espe.examen2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen2.dto.EstudianteDto;
import ec.edu.espe.examen2.dto.InformacionMatriculaDto;
import ec.edu.espe.examen2.dto.MatriculaDto;
import ec.edu.espe.examen2.exception.BussinesRuleException;
import ec.edu.espe.examen2.exception.EntityExistsException;
import ec.edu.espe.examen2.exception.EntityNotFoundException;
import ec.edu.espe.examen2.model.Estudiante;
import ec.edu.espe.examen2.service.EstudianteService;

@RestController
@RequestMapping("/api/v1/estudiante/")
public class EstudianteController {
    @Autowired
    private EstudianteService service;

    @PostMapping("inscribir")
    public ResponseEntity<Estudiante> inscribirEstudiante(@RequestBody EstudianteDto estudianteDto) {
        try {
            return ResponseEntity.ok().body(this.service.guardarEstudiante(estudianteDto));
        } catch (EntityExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("matricular")
    public ResponseEntity<InformacionMatriculaDto> matricularEstudiante(@RequestBody MatriculaDto matriculaDto) {
        try {
            return ResponseEntity.ok().body(this.service.matricularEstudiante(matriculaDto));
        } catch (BussinesRuleException e) {
            return ResponseEntity.badRequest().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
