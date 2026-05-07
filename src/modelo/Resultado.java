package modelo;

public class Resultado {
    private int numero;
    private String color;
    private boolean acierto;

    public Resultado(int numero, String color, boolean acierto) {
        this.numero = numero;
        this.color = color;
        this.acierto = acierto;
    }

    public int getNumero() { return numero; }
    public String getColor() { return color; }
    public boolean isAcierto() { return acierto; }

    @Override
    public String toString() {
        return "Número: " + numero + ", Color: " + color + ", Acierto: " + acierto;
    }
}
