public  abstract class Animal{
    protected String nombre;
    protected int energia;

    public Animal(String nombre, int energia) {
        this.nombre = nombre;
        this.energia = energia;
    }

    public void mostrarEstado() {
        System.out.println(nombre + " - Energía: " + energia);
    }

}
