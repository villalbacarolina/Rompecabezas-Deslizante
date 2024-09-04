package Logica;

import javax.swing.ImageIcon;

public class Juego {
	
	Rompecabezas rompecabeza;
	
	Juego() {
		this.rompecabeza = new Rompecabezas();
	}

	public void desordenarRompecabeza() {
		this.rompecabeza.desordenarPiezas();
	}
	
	public void moverPieza(String numero) {
		rompecabeza.intercambiarConVacio(numero);
	}
	
	public String obtenerNumeroPieza(int f, int c) {
		return rompecabeza.obtenerPieza(f, c).getNumero().toString();
	}
	
	public ImageIcon obtenerImagenPieza(int numero)
	{
		return rompecabeza.obtenerImagen(numero);
	}
	
	public boolean terminoJuego() {
		return rompecabeza.juegoTerminado();
	}

}
