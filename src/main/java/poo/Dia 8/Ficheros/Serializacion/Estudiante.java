import java.io.Serializable;
//solo tienes q agregar este import
public class Estudiante implements Serializable {
    private String nombre;
    private int edad;
    
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}