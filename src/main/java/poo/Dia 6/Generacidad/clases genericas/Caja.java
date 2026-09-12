public class Caja<T> {   // T es el parámetro de tipo
    private T contenido;

    public void guardar(T obj) {
        this.contenido = obj;
    }

    public T obtener() {
        return contenido;
    }
}

// se puede utilizar el tipo q yo quiera
/*Caja<String> cajaTexto = new Caja<>();
cajaTexto.guardar("Hola");
String s = cajaTexto.obtener();  // ✅ No necesitas casting

Caja<Integer> cajaNumero = new Caja<>();
cajaNumero.guardar(42);
int n = cajaNumero.obtener();    // ✅ Seguro
*/

