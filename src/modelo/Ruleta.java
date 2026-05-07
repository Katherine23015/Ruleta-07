package modelo;

public class Ruleta {

    public Resultado jugar(ApuestaBase apuesta) {
        int numero = girar();
        String color = obtenerColor(numero);
        boolean acierta = apuesta.acierta(numero, color);
        return new Resultado(numero, color, acierta);
    }

    private int girar() {
        return (int)(Math.random() * 37); // 0 al 36
    }

    private String obtenerColor(int numero) {
        if (numero == 0) return "verde";
        int[] rojos = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
        for (int r : rojos) {
            if (r == numero) return "rojo";
        }
        return "negro";
    }
}
