package Logica;

import javax.swing.ImageIcon;

public class Pieza {
	
	Integer numeroDeOrden;
	ImageIcon imagen;

	public Pieza(Integer numeroDeOrden) {
		this.numeroDeOrden = numeroDeOrden;
	}
	
	
	
	public Pieza(Integer numeroDeOrden, ImageIcon imagenPieza) {
		super();
		this.numeroDeOrden = numeroDeOrden;
		this.imagen = imagenPieza;
	}



	public Integer getNumero() {
		return this.numeroDeOrden;
	}
	
	public void setNumero(Integer nuevoNumero) {
		this.numeroDeOrden = nuevoNumero;
	}

	public ImageIcon getImagenPieza() {
		return imagen;
	}

	public void setImagenPieza(ImageIcon imagenPieza) {
		this.imagen = imagenPieza;
	}
	
}
