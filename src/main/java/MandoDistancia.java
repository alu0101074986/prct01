package C:.Users.danie.Desktop.Universidad.Herramientas.Mando.src.main.java;

import java.util.logging.Logger;
import java.util.logging.Level;

public class MandoDistancia {
    private static final Logger logger = Logger.getLogger(MandoDistancia.class.getName());

    private static final int MAX_VOLUMEN = 30;
    private static final int MIN_VOLUMEN = 0;
    private static final int MAX_CANAL = 49;

    private int volumen;
    private int canal;
    private boolean encendido = false;

    public MandoDistancia() {
        this.volumen = 10;
        this.canal = 0;
        this.encendido = true;  // Asumimos que está encendido por defecto
    }

    public void mostrar() {
    if (!encendido) {
        logger.info("Mando Apagado");
    } else {
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("Programa: %d", canal));
            logger.info(String.format("Volumen: %d", volumen));
        }
    }
}

    public void apagar() {
        if (encendido) {
            encendido = false;
        }
    }

    public void subirVolumen(int incremento) {
        if (encendido) {
            if (volumen + incremento > MAX_VOLUMEN) {
                throw new IllegalArgumentException("El máximo volumen es " + MAX_VOLUMEN);
            }
            this.volumen += incremento;
        }
    }

    public void bajarVolumen(int decremento) {
        if (encendido) {
            if (volumen - decremento < MIN_VOLUMEN) {
                throw new IllegalArgumentException("El mínimo volumen es " + MIN_VOLUMEN);
            }
            this.volumen -= decremento;
        }
    }

    public void canalSig() {
        if (encendido) {
            canal++;
            if (canal > MAX_CANAL) {
                canal = 0;
            }
        }
    }

    public void canalAnt() {
        if (encendido) {
            canal--;
            if (canal < 0) {
                canal = MAX_CANAL;
            }
        }
    }

    // Métodos para seleccionar canal específico
    public void canal0() { if (encendido) canal = 0; }
    public void canal1() { if (encendido) canal = 1; }
    public void canal2() { if (encendido) canal = 2; }
    public void canal3() { if (encendido) canal = 3; }
    public void canal4() { if (encendido) canal = 4; }
    public void canal5() { if (encendido) canal = 5; }
    public void canal6() { if (encendido) canal = 6; }
    public void canal7() { if (encendido) canal = 7; }
    public void canal8() { if (encendido) canal = 8; }
    public void canal9() { if (encendido) canal = 9; }

    // Métodos getters necesarios para las pruebas
    public int getVolumen() {
        return volumen;
    }

    public int getCanal() {
        return canal;
    }

    public boolean isEncendido() {
        return encendido;
    }
}