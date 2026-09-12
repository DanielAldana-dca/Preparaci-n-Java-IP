public class Automovil{
    private String marca;
    private String modelo;
    private int velocidadactual;
    private boolean encendido;
//Constructores
public Automovil(String marca , String modelo){
    this.marca = marca ;
    this.modelo = modelo;
    this.velocidadactual= 0 ;
    this.encendido = false ;
  }
  //Metodos de Comportamiento
public void encender(){
    this.encendido =  true;
}
public void apagar(){
    this.encendido = false;
    this.velocidadactual = 0;
}
public void acelerar(){
    if(encendido){
        velocidadactual++;  }
   else System.out.println("auto apagado");
  
}
//Consultores
public int getVelocidadActual(){
    return  velocidadactual;
}
}

