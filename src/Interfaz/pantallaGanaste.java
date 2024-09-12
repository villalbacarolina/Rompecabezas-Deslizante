package Interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class pantallaGanaste {

	private JFrame frameGanaste;
	private int movimientos;
	private int imgTablero;

	public void visible(boolean b) {
		this.frameGanaste.setVisible(b);
	}
	
	public void setMovimientos(int n) {
		this.movimientos=n;
	}
	
	public void setImgTablero(int n) {
		this.imgTablero=n;
	}

	/**
	 * Create the application.
	 */
	public pantallaGanaste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameGanaste = new JFrame();
		frameGanaste.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 15));
		frameGanaste.setBounds(100, 100, 860, 650);
		frameGanaste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGanaste.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ganaste!");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 28));
		lblNewLabel.setBounds(364, 91, 167, 52);
		frameGanaste.getContentPane().add(lblNewLabel);
		
		JLabel lblMovimientos = new JLabel("Movimientos realizados: " + this.movimientos);
		lblMovimientos.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblMovimientos.setBounds(290, 154, 386, 52);
		frameGanaste.getContentPane().add(lblMovimientos);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(322, 217, 200, 200);
		frameGanaste.getContentPane().add(btnNewButton);
		ImageIcon imgTablero = new ImageIcon(getClass().getResource("img"+this.imgTablero+"Menu.png"));
		btnNewButton.setIcon(imgTablero);
		
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
		Btnsalir.setBounds(446, 450, 166, 65);
		frameGanaste.getContentPane().add(Btnsalir);
		
		JButton btnMenu = new JButton();
		btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMenu.setText("Menu");
		btnMenu.setBounds(238, 450, 166, 65);
		frameGanaste.getContentPane().add(btnMenu);
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
}
