package controlador;

import modelo.*;

public class RuletaControlador {
    private Ruleta ruleta;

    public RuletaControlador() {
        this.ruleta = new Ruleta();
    }

    public Resultado jugar(ApuestaBase apuesta) {
        return ruleta.jugar(apuesta);
    }

    public double calcularGanancia(ApuestaBase apuesta, boolean acierto) {
        if (!acierto) return 0;
        return apuesta.getMonto();
    }
}