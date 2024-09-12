package Logica;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Rompecabezas {

	private Pieza[][] piezas;
	private ArrayList<ImageIcon>imagenesPiezas;
	private int contadorMovimientos;
	
    Rompecabezas(int numeroTablero) {
    	this.contadorMovimientos=0;
        piezas = new Pieza[4][4];
        imagenesPiezas = new ArrayList<ImageIcon>();
        llenarArregloImg(numeroTablero);
        inicializarPiezas();
    }
    
    private void llenarArregloImg(int numeroTablero) {
    	
    	imagenesPiezas.add(0, null);
    	
		if(numeroTablero==1) {
	    	for (int i =0; i<16;i++) {
	    		imagenesPiezas.add(i,new ImageIcon(getClass().getResource("/srcimg1/"+i+".jpg")));
	    	}
		}	
		
		if(numeroTablero==2) {
	    	for (int i =0; i<16;i++) {
	    		imagenesPiezas.add(i,new ImageIcon(getClass().getResource("/srcimg2/"+i+".jpg")));
	    	}
		}
		
		if(numeroTablero==3) {
	    	for (int i =0; i<16;i++) {
	    		imagenesPiezas.add(i,new ImageIcon(getClass().getResource("/srcimg3/"+i+".jpg")));
	    	}
		}
    }
    
	public boolean juegoTerminado() {
		Rompecabezas rompecabezaOrdenado = new Rompecabezas(1);
		for (int fil = 0; fil < piezas.length; fil++)
			for (int col = 0; col < piezas[0].length; col++){
					if(this.piezas[fil][col].getNumero() != rompecabezaOrdenado.obtenerPiezas()[fil][col].getNumero()) {
						return false;
				}
			}
		return true;
	}
    
    private Pieza[][] obtenerPiezas() {
    	return this.piezas;
    }

	private void inicializarPiezas() {	
    	int numeroPieza = 0;
		for (int fil = 0; fil < piezas.length; fil++) {
			for (int col = 0; col < piezas[0].length; col++) {
				Pieza p = new Pieza(numeroPieza,imagenesPiezas.get(numeroPieza));
				piezas[fil][col] = p;
				numeroPieza++;
			}
		}

	}
	
	public void desordenarPiezas() {
		Pieza[][] piezasDesordenadas = ResolvedorRompecabezas.crearTableroResoluble(4);
		this.piezas = piezasDesordenadas;
		
		for(int f = 0; f<piezas.length;f++) {
			for(int c = 0; c<piezas[0].length;c++) {
				Pieza p = piezas[f][c];
				int numeroPieza = p.getNumero();
				p.setImagenPieza(imagenesPiezas.get(numeroPieza));
			}
		}
		
	}
	
	public void intercambiarConVacio(String numeroBuscar) {
		Integer numeroA_Integer;
		
		if (numeroBuscar!="") {
		numeroA_Integer = Integer.parseInt(numeroBuscar);

		boolean termino=false;
		
		for(int f = 0; f<this.piezas.length;f++) {
			for(int c = 0; c<this.piezas[f].length;c++) {
				
				Integer n = this.piezas[f][c].getNumero();
				if(n.compareTo(numeroA_Integer) == 0  && n != 0) {
					intercambiarNumeroConPiezaVacia(f,c);
					termino=true;
					break;
				}
				
			}
			
			if(termino) {
				break;
			}
		}
		}

	}
	
	public void intercambiarNumeroConPiezaVacia(int f, int c) {
		ArrayList<Pieza> piezasPosiblesVacias = new ArrayList<Pieza>();
		Pieza pIntercambiar = obtenerPieza(f,c);
		
		Pieza pArriba= obtenerPieza((f-1),c);
		piezasPosiblesVacias.add(pArriba);
		Pieza pAbajo = obtenerPieza((f+1),c);
		piezasPosiblesVacias.add(pAbajo);
		Pieza pIzquierda = obtenerPieza(f,(c-1));
		piezasPosiblesVacias.add(pIzquierda);
		Pieza pDerecha = obtenerPieza (f,(c+1));
		piezasPosiblesVacias.add(pDerecha);
		
		
		for(int i = 0; i<piezasPosiblesVacias.size();i++) {
			Pieza p = piezasPosiblesVacias.get(i);
			if(p!=null) {
				if(p.getNumero().compareTo(0)==0) {
					p.setNumero(pIntercambiar.getNumero());
					pIntercambiar.setNumero(0);
					this.contadorMovimientos+=1;
				}
			}
		}

 	}
	
	public Pieza obtenerPieza(int f, int c) {
		if(f>3 || f<0 || c>3 || c<0) {
			return null;
		}
		return this.piezas[f][c];
	}
	
	public ImageIcon obtenerImagen(int numero) {
		return imagenesPiezas.get(numero);
	}
	
	public int obtenerContadorMovimientos() {
		return this.contadorMovimientos;
	}
	
	public void setContadorMovimientos(int n) {
		this.contadorMovimientos=n;
	}
	
}
