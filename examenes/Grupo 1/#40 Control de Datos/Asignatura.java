public class Asignatura {
    private String nombre;
    private double notaFinal;
    private int año;
    private int semestre;

    public Asignatura(String nombre, double notaFinal, int año, int semestre) {
        this.nombre = nombre;
        this.notaFinal = notaFinal;
        this.año = año;
        this.semestre = semestre;
    }

    public String getNombre() { return nombre; }
    public double getNotaFinal() { return notaFinal; }
    public int getAño() { return año; }
    public int getSemestre() { return semestre; }
}