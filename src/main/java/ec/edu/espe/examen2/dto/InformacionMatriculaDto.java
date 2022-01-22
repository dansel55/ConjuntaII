package ec.edu.espe.examen2.dto;

import ec.edu.espe.examen2.model.Matricula;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InformacionMatriculaDto {
    private String nombreEstudiante;
    private Matricula matricula;
}
