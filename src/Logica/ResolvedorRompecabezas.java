package Logica;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ResolvedorRompecabezas {

    public static Pieza[][] crearTableroResoluble(int tamaño) {
        Pieza[][] tablero;
        do {
            tablero = generarTableroAleatorio(tamaño);
        } while (!esResoluble(tablero));
        return tablero;
    }

    private static Pieza[][] generarTableroAleatorio(int tamaño) {
        List<Integer> numeros = new ArrayList<>();
        
        // Agregar los números del rompecabezas (incluido el 0 para el espacio vacío)
        for (int i = 0; i < tamaño * tamaño; i++) {
            numeros.add(i);
        }
        
        // Mezclar los números de manera aleatoria
        Collections.shuffle(numeros);
        
        // Crear el tablero con los números mezclados
        Pieza[][] tablero = new Pieza[tamaño][tamaño];
        int index = 0;
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                tablero[fila][columna] = new Pieza(numeros.get(index++));
            }
        }
        return tablero;
    }

    public static boolean esResoluble(Pieza[][] rompecabeza) {
        int[] rompecabezaArreglo = matrizAArreglo(rompecabeza);
        int inversiones = contarInversiones(rompecabezaArreglo);
        int filaConVacio = encontrarVacioEnFila(rompecabeza);
        
        // En un tablero de 4x4 (o cualquier tamaño par), se suma la paridad de la fila del espacio vacío
        // La fila se cuenta desde abajo hacia arriba (1 es la fila más cercana al borde inferior)
        int filaBordeInferior = rompecabeza.length - filaConVacio;
        
        // Para tableros de tamaño par, el tablero es resoluble si la suma de la paridad de inversiones y
        // la fila desde el fondo es par.
        return (inversiones + filaBordeInferior) % 2 == 0;
    }

    private static int[] matrizAArreglo(Pieza[][] rompecabeza) {
        int filas = rompecabeza.length;
        int columnas = rompecabeza[0].length;
        int[] matrizAArreglo = new int[filas * columnas];
        int index = 0;
        
        for (Pieza[] fila : rompecabeza) {
            for (Pieza num : fila) {
                if (num.getNumero() != 0) {
                    matrizAArreglo[index++] = num.getNumero();
                }
            }
        }
        
        return matrizAArreglo;
    }

    private static int contarInversiones(int[] arr) {
        int contadorInversiones = 0;
        int longitudArreglo = arr.length;
        
        for (int i = 0; i < longitudArreglo; i++) {
            for (int j = i + 1; j < longitudArreglo; j++) {
                if (arr[i] > arr[j]) {
                    contadorInversiones++;
                }
            }
        }
        
        return contadorInversiones;
    }

    private static int encontrarVacioEnFila(Pieza[][] rompecabeza) {
        // Encontrar la fila donde se encuentra el 0 (espacio vacío)
        for (int fila = 0; fila < rompecabeza.length; fila++) {
            for (int columna = 0; columna < rompecabeza[fila].length; columna++) {
                if (rompecabeza[fila][columna].getNumero() == 0) {
                    return fila;
                }
            }
        }
        throw new IllegalArgumentException("El tablero no contiene un espacio vacío.");
    }

}

