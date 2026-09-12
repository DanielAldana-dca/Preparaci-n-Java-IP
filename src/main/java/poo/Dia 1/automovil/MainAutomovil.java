public class MainAutomovil {
    public static void main(String[] args) {
           Automovil auto = new Automovil("Hyundai", "Atos");
        auto.encender();
        while (auto.getVelocidadActual() < 10) auto.acelerar();
        System.out.println("Velocidad final: " + auto.getVelocidadActual());
        auto.apagar();
    }
}
