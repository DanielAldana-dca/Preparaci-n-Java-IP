public class Animal {

    protected String nombre;
    protected int edad;

    public Animal(String nombre , int edad){
      this.nombre = nombre;
      this.edad = edad;
    }

    public void hacerSonido(){
        System.out.println("el animal hace sonido");
    }
}