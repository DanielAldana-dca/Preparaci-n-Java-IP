public class AlumnoAyudante extends Estudiante {
    private int añosAyudantia;
    private String[] asignaturasImpartidas;
    private int cantImpartidas;

    public AlumnoAyudante(String nombre, String apellidos, String CI,
                          String grupo, int añoCurso, boolean ayudaFinanciera,
                          int añosAyudantia) {
        super(nombre, apellidos, CI, grupo, añoCurso, ayudaFinanciera);
        this.añosAyudantia = añosAyudantia;
        this.asignaturasImpartidas = new String[10];
        this.cantImpartidas = 0;
    }

    public void agregarAsignaturaImpartida(String asignatura) {
        if (cantImpartidas < asignaturasImpartidas.length) {
            asignaturasImpartidas[cantImpartidas++] = asignatura;
        }
    }

    @Override
    public double calcularEstipendio() {
        return super.calcularEstipendio() + 50; // EF + AF + AA
    }

    public int getAñosAyudantia() { return añosAyudantia; }
    public String[] getAsignaturasImpartidas() { return asignaturasImpartidas; }

}