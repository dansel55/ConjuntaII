package ec.edu.espe.examen2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatriculaDto {
    String idEstudiante;
    String idCurso;
}
