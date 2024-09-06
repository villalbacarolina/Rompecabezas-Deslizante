package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Logica.Juego;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class juegoInterfaz {
	
	private Juego logicaJuego;
	private JButton[][] botones;
	private JFrame frameJuego;
	
	public juegoInterfaz(int numTablero) {
		initialize(numTablero);
	}

	public void visible(boolean b) {
		this.frameJuego.setVisible(b);
	}
 
	private void initialize(int numTablero) {
		this.logicaJuego = new Juego(numTablero);
		this.botones = new JButton[4][4];
		
		frameJuego = new JFrame();
		frameJuego.getContentPane().setBackground(new Color(128, 128, 128));
		frameJuego.setBounds(100, 100, 860, 800);
		frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJuego.getContentPane().setLayout(null);
		
		JButton Pieza0 = new JButton();
		Pieza0.setBounds(124, 64, 150, 150);
		frameJuego.getContentPane().add(Pieza0);
		this.botones[0][0] = Pieza0;
		
		JButton Pieza1 = new JButton();
		Pieza1.setBounds(273, 64, 150, 150);
		frameJuego.getContentPane().add(Pieza1);
		this.botones[0][1] = Pieza1;
		
		JButton Pieza2 = new JButton();
		Pieza2.setBounds(423, 64, 150, 150);
		frameJuego.getContentPane().add(Pieza2);
		this.botones[0][2] = Pieza2;
		
		JButton Pieza3 = new JButton();
		Pieza3.setBounds(573, 64, 150, 150);
		frameJuego.getContentPane().add(Pieza3);
		this.botones[0][3] = Pieza3;
		
		JButton Pieza4 = new JButton();
		Pieza4.setBounds(124, 214, 150, 150);
		frameJuego.getContentPane().add(Pieza4);
		this.botones[1][0] = Pieza4;
		
		JButton Pieza5 = new JButton();
		Pieza5.setBounds(273, 214, 150, 150);
		frameJuego.getContentPane().add(Pieza5);
		this.botones[1][1] = Pieza5;
		
		JButton Pieza6 = new JButton();
		Pieza6.setBounds(423, 214, 150, 150);
		frameJuego.getContentPane().add(Pieza6);
		this.botones[1][2] = Pieza6;
		
		JButton Pieza7 = new JButton();
		Pieza7.setBounds(573, 214, 150, 150);
		frameJuego.getContentPane().add(Pieza7);
		this.botones[1][3] = Pieza7;
		
		JButton Pieza8 = new JButton();
		Pieza8.setBounds(124, 364, 150, 150);
		frameJuego.getContentPane().add(Pieza8);
		this.botones[2][0] = Pieza8;
		
		JButton Pieza9 = new JButton();
		Pieza9.setBounds(273, 364, 150, 150);
		frameJuego.getContentPane().add(Pieza9);
		this.botones[2][1] = Pieza9;
		
		JButton Pieza10 = new JButton();
		Pieza10.setBounds(423, 364, 150, 150);
		frameJuego.getContentPane().add(Pieza10);
		this.botones[2][2] = Pieza10;
		
		JButton Pieza11 = new JButton();
		Pieza11.setBounds(573, 364, 150, 150);
		frameJuego.getContentPane().add(Pieza11);
		this.botones[2][3] = Pieza11;
		
		JButton Pieza12 = new JButton();
		Pieza12.setBounds(124, 513, 150, 150);
		frameJuego.getContentPane().add(Pieza12);
		this.botones[3][0] = Pieza12;
		
		JButton Pieza13 = new JButton();
		Pieza13.setBounds(273, 513, 150, 150);
		frameJuego.getContentPane().add(Pieza13);
		this.botones[3][1] = Pieza13;
		
		JButton Pieza14 = new JButton();
		Pieza14.setBounds(423, 513, 150, 150);
		frameJuego.getContentPane().add(Pieza14);
		this.botones[3][2] = Pieza14;
		
		JButton Pieza15 = new JButton();
		Pieza15.setBounds(573, 513, 150, 150);
		frameJuego.getContentPane().add(Pieza15);
		this.botones[3][3] = Pieza15;
		
		JButton Empezar = new JButton();
		Empezar.setBounds(330, 700, 200, 50);
		frameJuego.getContentPane().add(Empezar);
		Empezar.setText("Empezar");
		
		JButton btnMenu = new JButton();
		btnMenu.setText("Menu");
		btnMenu.setBounds(21, 700, 96, 50);
		frameJuego.getContentPane().add(btnMenu);
		
		Empezar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	logicaJuego.desordenarRompecabeza();
		    	setEventosBotonesPiezas();
				actualizarMatriz();
		    }
		});

		btnMenu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				try {
			    	MenuInterfaz menuPrincipal = new MenuInterfaz();
			    	menuPrincipal.visible(true);
			    	visible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    }
		});
		
	}
	
	public void actualizarMatriz() {
		for(int fila = 0 ; fila< this.botones.length;fila++) {
			for(int columna = 0; columna < this.botones[fila].length;columna++) {
				String numero = logicaJuego.obtenerNumeroPieza(fila, columna);
				ImageIcon img = logicaJuego.obtenerImagenPieza(Integer.parseInt(numero));
				if(numero.equals("0")) {
					this.botones[fila][columna].setText("");
					this.botones[fila][columna].setIcon(img);
					
				}else {
					this.botones[fila][columna].setText(numero);
					this.botones[fila][columna].setIcon(img);
				}
			}
		}
	}

	public boolean ganoJuego() {
        return logicaJuego.terminoJuego();
	}
	
	public void setEventosBotonesPiezas() {
		for(int fila = 0 ; fila< this.botones.length;fila++) {
			for(int columna = 0; columna < this.botones[fila].length;columna++) {
				JButton boton = this.botones[fila][columna];
				boton.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        logicaJuego.moverPieza(boton.getText());
						actualizarMatriz();
						if(ganoJuego()) {
							frameJuego.setVisible(false);
							try {
								MenuInterfaz MI = new MenuInterfaz();
								MI.visible(true);
						    	visible(false);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

						}
				    }
				});
			}
		}
	}

}
