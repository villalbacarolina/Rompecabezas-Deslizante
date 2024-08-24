package Logica;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Rompecabeza {

    Pieza[][] piezas;

    public Rompecabeza(int cantidadPiezas) {
        if (cantidadPiezas < 3 || cantidadPiezas > 10)
            throw new IllegalArgumentException("La cantidad de piezas '" + cantidadPiezas + "' es inválida. Debe estar entre 3 y 10.");
        piezas = new Pieza[cantidadPiezas][cantidadPiezas];
        desordenarPiezasAleatoriamente();
        eliminarUltimaPieza();
    }
    
    public boolean piezasOrdenadasYUltimaPiezaNull() {
        boolean ordenada = true;
        int numeroDeOrdenEsperado = 0;

        for (int fil = 0; fil < piezas.length; fil++)
            for (int col = 0; col < piezas[0].length; col++) {
                Pieza piezaActual = piezas[fil][col];
                int ultimaColumna = piezas[0].length-1;
                int ultimaFila = piezas.length-1;
                
                if (fil==ultimaFila && col==ultimaColumna)
                    if (piezaActual != null) 
                        ordenada = false;
                else
                    if (piezaActual==null || piezaActual.getNumeroDeOrden()!=numeroDeOrdenEsperado)
                        ordenada = false;

                numeroDeOrdenEsperado++;
            }
        return ordenada;
    }

	private void desordenarPiezasAleatoriamente() {
    	int filas = piezas.length;
    	int columnas= piezas[0].length;
        int cantidadPiezas = filas * columnas;
        int[] numerosAleatorios = generarNumerosAleatoriosSinRepetir(cantidadPiezas);
        int posicion = 0;

        for (int col = 0; col < piezas[0].length; col++)
            for (int fil = 0; fil < piezas.length; fil++)
                piezas[fil][col] = new Pieza(numerosAleatorios[posicion++]);
    }

    private static int[] generarNumerosAleatoriosSinRepetir(int hasta) {
        if (hasta <= 0) throw new IllegalArgumentException("Numero " + hasta + " invalido. El valor máximo del rango debe ser mayor que 0.");

        Random random = new Random();
        Set<Integer> numeros = new HashSet<>();
        while (numeros.size() < hasta) {
        	numeros.add(random.nextInt(hasta) + 1);
        }

        int[] resultado = new int[hasta];
        int posicion = 0;
        for (int numero : numeros) 
            resultado[posicion++] = numero;
        
        return resultado;
    }
    
    private void eliminarUltimaPieza() {
        int filas = piezas.length;
        int columnas = piezas[0].length;

        int ultimaFila = filas - 1;
        int ultimaColumna = columnas - 1;

        piezas[ultimaFila][ultimaColumna] = null;
    }
}
