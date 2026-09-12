public class auto {
    private String marca;
    private motor motor ;

    public auto(String marca , int caballosmotor){
        this.marca = marca ;
        this.motor = new motor(caballosmotor) ;
    }

    public void arrancar(){
        System.out.println("encender " + marca );
        motor.encender();
    }
    
}