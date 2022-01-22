package ec.edu.espe.examen2.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "curso")
public class Curso {
    @Id
    private String id;
    private String codigo;
    private String area;
    private String nombre;
    private String duracion;
    private Date fechaInicio;
    private BigDecimal costo;
}
