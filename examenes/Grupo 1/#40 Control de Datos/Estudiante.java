public class Estudiante {
    protected String nombre;
    protected String apellidos;
    protected String CI;
    protected double estipendio;
    protected String grupo;
    protected int añoCurso;
    protected String proyecto;          // null si no está en proyecto
    protected Asignatura[] asignaturas; // Array o Lista<Asignatura>
    protected int cantAsignaturas;
    protected boolean ayudaFinanciera;

    public Estudiante(String nombre, String apellidos, String CI,
                      String grupo, int añoCurso, boolean ayudaFinanciera) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.CI = CI;
        this.grupo = grupo;
        this.añoCurso = añoCurso;
        this.ayudaFinanciera = ayudaFinanciera;
        this.asignaturas = new Asignatura[20];
        this.cantAsignaturas = 0;
        this.proyecto = null;
        this.estipendio = 0.0;
    }

    // Método para agregar asignaturas
    public void agregarAsignatura(Asignatura a) {
        if (cantAsignaturas < asignaturas.length) {
            asignaturas[cantAsignaturas++] = a;
        }
    }

    // Cálculo de estipendio (se sobrescribe en subclases)
    public double calcularEstipendio() {
        double EF = 50;
        double AF = ayudaFinanciera ? 50 : 0;
        return EF + AF;
    }

    // Promedio de un año específico
    public double promedioPorAño(int año) {
        double suma = 0;
        int cont = 0;
        for (int i = 0; i < cantAsignaturas; i++) {
            if (asignaturas[i].getAño() == año) {
                suma += asignaturas[i].getNotaFinal();
                cont++;
            }
        }
        return cont > 0 ? suma / cont : 0.0;
    }
 public double promedioGeneral() {
    double suma = 0;
    for (int i = 0; i < cantAsignaturas; i++) {
        suma += asignaturas[i].getNotaFinal();
    }
    return cantAsignaturas > 0 ? suma / cantAsignaturas : 0.0;
}
    // Getters
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getCI() { return CI; }
    public String getGrupo() { return grupo; }
    public int getAñoCurso() { return añoCurso; }
    public double getEstipendio() {  return calcularEstipendio(); }
    public Asignatura[] getAsignaturas() {
    return asignaturas;
}

public int getCantAsignaturas() {
    return cantAsignaturas;
}

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (" + CI + ")";
    }
}