package Interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class MenuInterfaz {

	private JFrame frameMenu;

	public void visible(boolean b) {
		this.frameMenu.setVisible(b);
	}
	
	public MenuInterfaz() {
		initialize();
	}

	private void initialize() {
		frameMenu = new JFrame();
		frameMenu.setBounds(100, 100, 860, 800);
		frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenu.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(80, 244, 200, 200);
		ImageIcon imgTablero1 = new ImageIcon(getClass().getResource("img1Menu.png"));
		btnNewButton.setIcon(imgTablero1);
		frameMenu.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				try {
			    	juegoInterfaz juegoPrincipal = new juegoInterfaz(1);
			    	juegoPrincipal.visible(true);
			    	juegoPrincipal.actualizarMatriz();
			    	visible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(329, 244, 200, 200);
		ImageIcon imgTablero2 = new ImageIcon(getClass().getResource("img2Menu.png"));
		btnNewButton_1.setIcon(imgTablero2);
		frameMenu.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				try {
			    	juegoInterfaz juegoPrincipal = new juegoInterfaz(2);
			    	juegoPrincipal.visible(true);
			    	juegoPrincipal.actualizarMatriz();
			    	visible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setBounds(582, 244, 200, 200);
		ImageIcon imgTablero3 = new ImageIcon(getClass().getResource("img3Menu.png"));
		btnNewButton_1_1.setIcon(imgTablero3);
		frameMenu.getContentPane().add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				try {
			    	juegoInterfaz juegoPrincipal = new juegoInterfaz(3);
			    	juegoPrincipal.visible(true);
			    	juegoPrincipal.actualizarMatriz();
			    	visible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		JLabel lblNewLabel = new JLabel("TABLERO 1");
		lblNewLabel.setBounds(127, 455, 81, 14);
		frameMenu.getContentPane().add(lblNewLabel);
		
		JLabel lblTablero = new JLabel("TABLERO 2");
		lblTablero.setBounds(393, 455, 81, 14);
		frameMenu.getContentPane().add(lblTablero);
		
		JLabel lblNewLabel_1_1 = new JLabel("TABLERO 3");
		lblNewLabel_1_1.setBounds(653, 455, 81, 14);
		frameMenu.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione uno de los siguientes tableros para empezar a jugar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(213, 171, 521, 46);
		frameMenu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Devuelve el tablero a su forma inicial, solo puedes mover las piezas cercanas al vacio");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(162, 515, 572, 46);
		frameMenu.getContentPane().add(lblNewLabel_2);
		
		JButton Btnsalir = new JButton("Salir");
		Btnsalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			    	visible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		Btnsalir.setBounds(340, 589, 166, 65);
		frameMenu.getContentPane().add(Btnsalir);
		
		JLabel lblNewLabel_1_2 = new JLabel("MENU PRINCIPAL");
		lblNewLabel_1_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(369, 114, 180, 46);
		frameMenu.getContentPane().add(lblNewLabel_1_2);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInterfaz window = new MenuInterfaz();
					window.frameMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
