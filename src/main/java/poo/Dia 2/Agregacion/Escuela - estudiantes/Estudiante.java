public class Estudiante{
    private String name;
    private int edad;
    public Estudiante(String name , int edad){
        this.name = name;
        this.edad = edad;
    }
    public String getNombre(){return name;}

    public int getEdad(){return edad;}

    @Override
      public String toString(){
      return "Nombre : " + name +",Edad : " + edad + "años";
     }
}