public class Perro extends Animal {
    private String raza;

    public Perro(String nombre, int edad,String raza){
    super(nombre, edad);
    this.raza = raza;
    }

    @Override
    public void hacerSonido(){
        System.out.println("El perro hace guau");
    }

    public void correr (){
        System.out.println(nombre +"esta corriendo");
    }
}

