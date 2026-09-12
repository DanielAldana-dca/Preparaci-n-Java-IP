public class Lista<T> {
    private Object[] elementos;   // Arreglo de Object
    private int cantReal;
    private int cantMax;

    public Lista(int cantMax) {
        this.cantMax = cantMax;
        this.elementos = new Object[cantMax];
        this.cantReal = 0;
    }

    public Lista() {
        this(100); // Por defecto, capacidad 100
    }

    public void adicionar(T elem) {
        if (cantReal >= cantMax) {
            throw new RuntimeException("Lista llena");
        }
        elementos[cantReal++] = elem;
    }

    @SuppressWarnings("unchecked")
    public T obtener(int pos) {
        if (pos < 0 || pos >= cantReal) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        return (T) elementos[pos];  // Cast explícito
    }

    public void eliminar(int pos) {
        if (pos < 0 || pos >= cantReal) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        for (int i = pos; i < cantReal - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[--cantReal] = null;
    }

    public int size() {
        return cantReal;
    }

    public boolean isEmpty() {
        return cantReal == 0;
    }
}

//ejemplo de uso 
/*Lista<String> nombres = new Lista<>();
nombres.adicionar("Ana");
nombres.adicionar("Luis");
String primero = nombres.obtener(0); // "Ana" sin casting

Lista<Integer> numeros = new Lista<>();
numeros.adicionar(10);
int x = numeros.obtener(0); // 10
// 
*/