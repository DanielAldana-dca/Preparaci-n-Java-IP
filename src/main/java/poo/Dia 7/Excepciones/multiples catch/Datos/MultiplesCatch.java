public class MultiplesCatch {
public static void main(String[] args) {
     String[] datos = {"10", "abc", null};

        for (String dato : datos) {
            try {
                int numero = Integer.parseInt(dato);
                System.out.println("Número: " + numero);
            } catch (NumberFormatException e) {
                System.out.println("❌ No es un número: " + dato);
            } catch (NullPointerException e) {
                System.out.println("❌ El valor es null");
            }
        }
}
    
}