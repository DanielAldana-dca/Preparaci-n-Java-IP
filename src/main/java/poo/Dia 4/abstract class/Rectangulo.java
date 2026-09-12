public class Rectangulo extends Figura {
    private double largo;
    private double ancho;

    public Rectangulo(double largo , double ancho, String color){
        this.largo = largo;
        this.ancho = ancho;
        super(color);
    }

    @Override
    public double Area(){
        return largo * ancho;
    }
}
