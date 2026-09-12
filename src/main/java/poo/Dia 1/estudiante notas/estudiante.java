public class estudiante{
    private String nombre;
    private String sexo;
    private int edad;
    private double[] notas;
    private double promedio;

    public estudiante(String nombre ,String sexo , int edad , double[] notas){
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.notas = notas;
        this.promedio = 0.0;
    }

    public double getPromedio(){
        double suma = 0.0;
           for(int i = 0 ; i < notas.length ; i++){
              suma = suma + notas[i] ;
               }
       promedio =  suma / 25 ;
        return promedio ;
    }

    public boolean oro(){
        if (promedio >= 4.75) {
            return true;
        }else return false;
    }
     public boolean docencia(){
        if (promedio >= 4.0) {
            return true;
        }else return false;
    }
 
}