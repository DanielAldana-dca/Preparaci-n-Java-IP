public class gato extends Animal implements depredador, presa {
    public gato(String nombre, int energia) {
        super(nombre, energia);
    }

    @Override
    public void cazar(presa presa) {
        System.out.println(nombre + " caza a la presa.");
        energia += presa.darEnergia();
    }

    @Override
    public int darEnergia() {
        return energia / 2; // Aporta la mitad de su energía al ser comido
    }
}