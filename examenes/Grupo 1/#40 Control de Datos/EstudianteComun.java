public class EstudianteComun extends Estudiante {
    public EstudianteComun(String nombre, String apellidos, String CI,
                           String grupo, int añoCurso, boolean ayudaFinanciera) {
        super(nombre, apellidos, CI, grupo, añoCurso, ayudaFinanciera);
    }

    @Override
    public double calcularEstipendio() {
        return super.calcularEstipendio(); // EF + AF
    }
}