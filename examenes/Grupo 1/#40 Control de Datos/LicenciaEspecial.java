public class LicenciaEspecial extends Estudiante {
    private String asignaturaRepetida;
    private int añoRepetido;

    public LicenciaEspecial(String nombre, String apellidos, String CI,
                            String grupo, int añoCurso, boolean ayudaFinanciera,
                            String asignaturaRepetida, int añoRepetido) {
        super(nombre, apellidos, CI, grupo, añoCurso, ayudaFinanciera);
        this.asignaturaRepetida = asignaturaRepetida;
        this.añoRepetido = añoRepetido;
    }

    @Override
    public double calcularEstipendio() {
        return super.calcularEstipendio(); // EF + AF (igual que común)
    }

    public String getAsignaturaRepetida() { return asignaturaRepetida; }
    public int getAñoRepetido() { return añoRepetido; }
}