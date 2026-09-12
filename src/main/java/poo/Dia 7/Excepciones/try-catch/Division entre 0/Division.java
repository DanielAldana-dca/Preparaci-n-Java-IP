public class Division {
    public static void main(String[] args) {
     int a = 10;
    int b = 0 ;
    try{
     int resultado = a/ b;
     System.out.println("Resultado :" + resultado );
    }
    catch(ArithmeticException e){
       System.out.println("Error : no se puede dividir por cero");
    }
    
    System.out.println("El programa continua funcionando");
    }
    
}

/*Sin excepcion 
public class SinExcepcion {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int resultado = a / b;  // 💥 ¡BOOM! División entre cero
        System.out.println("Resultado: " + resultado);
        System.out.println("Esta línea NUNCA se ejecuta");
    }
}


*/