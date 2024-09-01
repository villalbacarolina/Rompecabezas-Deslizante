package Logica;

public class Pieza {
	
	Integer numeroDeOrden;

	public Pieza(Integer numeroDeOrden) {
		this.numeroDeOrden = numeroDeOrden;
	}
	
	public Integer getNumero() {
		return this.numeroDeOrden;
	}
	
	public void setNumero(Integer nuevoNumero) {
		this.numeroDeOrden = nuevoNumero;
	}

}
