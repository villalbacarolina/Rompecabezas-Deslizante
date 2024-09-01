package Logica;

import java.util.ArrayList;
import java.util.Collections;

public class Rompecabezas {

	private Pieza[][] piezas;

    Rompecabezas() {
        piezas = new Pieza[4][4];
        inicializarPiezas();
    }
    
	public boolean juegoTerminado() {
		Rompecabezas rompecabezaOrdenado = new Rompecabezas();
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
				Pieza p = new Pieza(numeroPieza);
				piezas[fil][col] = p;
				numeroPieza++;
			}
		}

	}

	public void desordenarPiezas() {
		
		ArrayList<Integer> numerosDesordenados = new ArrayList<Integer>();

		for (int f = 0; f < this.piezas.length; f++) {
		    for (int c = 0; c < this.piezas[f].length; c++) {
		        numerosDesordenados.add(this.piezas[f][c].getNumero());
		    }
		}

		Collections.shuffle(numerosDesordenados);
		
		int indexNumerosDesordenados = 0;
		for (int f = 0; f < this.piezas.length; f++) {
		    for (int c = 0; c < this.piezas[f].length; c++) {
		        this.piezas[f][c].setNumero(numerosDesordenados.get(indexNumerosDesordenados));
		        indexNumerosDesordenados++;
		    }
		}
		
	}
	
	public void intercambiarConVacio(String numeroBuscar) {
		Integer numeroA_Integer;
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
	
	public void imprimirMatriz() {
	    for (int i = 0; i < piezas.length; i++) {
	        System.out.print("| ");  
	        for (int j = 0; j < piezas[i].length; j++) {
	           
	            if (piezas[i][j] == null) {
	                System.out.print("  ");  
	            } else {
	                System.out.print(piezas[i][j].getNumero() + " ");
	            }
	        }
	        System.out.println("|");
	    }
	}
	
}
