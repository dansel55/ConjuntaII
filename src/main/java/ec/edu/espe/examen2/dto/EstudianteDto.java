package ec.edu.espe.examen2.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstudianteDto {
    private String nombre;
    private String correo;
    private String pais;
    private Date fechaNacimiento;
}
