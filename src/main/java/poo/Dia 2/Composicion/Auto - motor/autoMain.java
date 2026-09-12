public class autoMain {
    public static void main(String[] args) {
        auto auto = new auto("Toyota", 150);
        auto.arrancar();
        // Si el auto se destruye, el motor también (no hay referencia externa)
    }
}
