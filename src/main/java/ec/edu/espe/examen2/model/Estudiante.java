package ec.edu.espe.examen2.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "estudiante")
public class Estudiante {
    @Id
    private String id;
    private String nombre;
    private String correo;
    private String pais;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private String estado;
    private List<Matricula> matricula;
}
