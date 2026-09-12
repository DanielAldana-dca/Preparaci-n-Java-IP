public class raton extends Animal implements presa {
    public raton(String nombre, int energia) {
        super(nombre, energia);
    }

    @Override
    public int darEnergia() {
        return energia; // Aporta toda su energía
    }
}
