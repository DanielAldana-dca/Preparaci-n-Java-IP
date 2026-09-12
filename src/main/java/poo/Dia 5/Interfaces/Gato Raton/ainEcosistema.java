public class ainEcosistema {
    public static void main(String[] args) {
        gato gato = new gato("Misi", 100);
        raton raton = new raton("Pinky", 50);

        gato.mostrarEstado(); // Misi - Energía: 100
        raton.mostrarEstado(); // Pinky - Energía: 50

        gato.cazar(raton); // Misi caza a la presa.

        gato.mostrarEstado(); // Misi - Energía: 125 (100 + 50/2)
    }
}
