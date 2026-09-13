import java.io.*;

public class Escuela {
    private String nombre;
    private Estudiante[] estudiantes;
    private int cantReal;
    private static final int MAX = 100;

    public Escuela(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new Estudiante[MAX];
        this.cantReal = 0;
    }

    public void insertarEstudiante(Estudiante e) {
        if (cantReal < MAX) {
            estudiantes[cantReal++] = e;
            System.out.println("✅ Insertado: " + e.getNombre());
        } else {
            System.out.println("❌ Escuela llena");
        }
    }

    // Buscar por CI y mostrar grupo
    public String buscarGrupoPorCI(String CI) {
        for (int i = 0; i < cantReal; i++) {
            if (estudiantes[i].getCI().equals(CI)) {
                return estudiantes[i].getGrupo();
            }
        }
        return null;
    }

    // Promedio de un año dado el nombre
    public double promedioPorNombreYAño(String nombre, int año) {
        for (int i = 0; i < cantReal; i++) {
            if (estudiantes[i].getNombre().equals(nombre)) {
                return estudiantes[i].promedioPorAño(año);
            }
        }
        return 0.0;
    }

    // Verificar si es LicenciaEspecial o AlumnoAyudante
    public String tipoDeEstudiante(String CI) {
        for (int i = 0; i < cantReal; i++) {
            if (estudiantes[i].getCI().equals(CI)) {
                if (estudiantes[i] instanceof AlumnoAyudante) return "Alumno Ayudante";
                if (estudiantes[i] instanceof LicenciaEspecial) return "Licencia Especial";
                return "Estudiante Común";
            }
        }
        return "No encontrado";
    }

    // Listado de posibles diplomas de oro (promedio > 4.75)
    public void listarDiplomasOro() {
        System.out.println("🏆 Posibles Diplomas de Oro:");
        for (int i = 0; i < cantReal; i++) {
            double prom = estudiantes[i].promedioPorAño(estudiantes[i].getAñoCurso());
            if (prom > 4.75) {
                System.out.println("  - " + estudiantes[i] + " | Promedio: " + prom);
            }
        }
    }
    

public void generarDocumentoImpresion(String nombreArchivo) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
        for (int i = 0; i < cantReal; i++) {
            Estudiante e = estudiantes[i];
            
            bw.write("Nombre y Apellidos: " + e.getNombre() + " " + e.getApellidos());
            bw.newLine();
            
            bw.write("Grupo: " + e.getGrupo());
            bw.newLine();
            
            bw.write(String.format("Estipendio: %.2f", e.calcularEstipendio()));
            bw.newLine();
            
            bw.write("Las asignaturas: notas");
            bw.newLine();
            
            for (int j = 0; j < e.getCantAsignaturas(); j++) {
                Asignatura a = e.getAsignaturas()[j];
                bw.write("   - " + a.getNombre() + ": " + a.getNotaFinal());
                bw.newLine();
            }
            
            bw.write(String.format("Promedio: %.2f", e.promedioGeneral()));
            bw.newLine();
            bw.write("----------------------------------------");
            bw.newLine();
        }
        System.out.println("✅ Documento generado: " + nombreArchivo);
    } catch (IOException ex) {
        System.out.println("❌ Error: " + ex.getMessage());
    }
}
}