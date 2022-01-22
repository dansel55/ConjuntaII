package ec.edu.espe.examen2.config;

public class Configuraciones {
    public enum ESTADOS_ESTUDIANTE {
        ACTIVO("ACT"),
        INACTIVO("INA");

        private String estado;

        private ESTADOS_ESTUDIANTE(String estado) {
            this.estado = estado;
        }

        public String getEstado() {
            return this.estado;
        }
    }
}
