package modelo;

import java.io.Serializable;

public class Estadistica implements Serializable {
    private static final long serialVersionUID = 1L;
    private int partidasJugadas;
    private int aciertos;
    private double dineroGanado;

    public void registrarPartida(boolean acierto, double ganancia) {
        partidasJugadas++;
        if (acierto) {
            aciertos++;
            dineroGanado += ganancia;
        }
    }

    public int getPartidasJugadas() { return partidasJugadas; }
    public int getAciertos() { return aciertos; }
    public double getDineroGanado() { return dineroGanado; }
    public double getPorcentajeAciertos() {
        if (partidasJugadas == 0) return 0;
        return (aciertos * 100.0) / partidasJugadas;
    }
}
