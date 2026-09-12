public class Escuela {
    private String name;
    private Estudiante[] estudiantes;
    private int indiceActual;
    private int totalEstudiantes;
    public Escuela(String name ){
        this.name = name;
        this.totalEstudiantes = 100;
        this.estudiantes = new Estudiante[totalEstudiantes];
        this.indiceActual = 0;
        
    }
    public void agregarEstudiantes(Estudiante a)
{
    if (indiceActual< totalEstudiantes) {
        estudiantes[indiceActual]= a;
indiceActual++;
System.out.println( a.getNombre() + " añadido a " + name);
    }
else{
    System.out.println("matricula completa no se puede agregar ams estudiantes");
}
}

 public int contarEstudiantes() {
        return indiceActual;
    }


    public void listaEstudiantes(){
        for (int i = 0; i < indiceActual; i++) {
            System.out.println("el estudiante : " + estudiantes[i].getNombre());
        }
    }
}
