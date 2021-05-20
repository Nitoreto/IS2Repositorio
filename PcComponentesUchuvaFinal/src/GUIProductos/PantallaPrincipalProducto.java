package GUIProductos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import main.Controlador;
import main.PantallaPrincipalPccomponentes;

public class PantallaPrincipalProducto extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JTextArea textoProducto;
	private JButton botonAlta;
	private JButton botonBaja;
	private JButton botonMostrarHistorial;
	private JButton botonMostrar;
	private JButton botonVolver;
	private Controlador controlador;

	public PantallaPrincipalProducto(Controlador controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponents();
	}

	private void initComponents() {
		panel = new JPanel();
		textoProducto = new JTextArea();
		botonAlta = new JButton();
		botonBaja = new JButton();
		botonMostrarHistorial = new JButton();
		botonMostrar = new JButton();
		botonVolver = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(900, 720));
		panel.setFocusable(false);
		panel.setOpaque(false);
		panel.setLayout(new GridLayout(6, 1));

		textoProducto.setEditable(false);
		textoProducto.setText("Productos");
		textoProducto.setBackground(Color.pink);
		textoProducto.setForeground(Color.WHITE);
		textoProducto.setFocusable(false);
		textoProducto.setFont(new Font("Consolas", 2, 90));
		textoProducto.setBounds(400, 200, 200, 400);

		panel.add(textoProducto);

		botonAlta.setText("Alta");
		botonAlta.setFont(new Font("Consolas", 4, 80));
		botonAlta.setBackground(Color.white);
		botonAlta.setForeground(Color.pink);
		botonAlta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonAltaActionPerformed(evt);
			}
		});
		panel.add(botonAlta);

		botonBaja.setText("Baja");
		botonBaja.setFont(new Font("Consolas", 4, 80));
		botonBaja.setBackground(Color.white);
		botonBaja.setForeground(Color.pink);
		botonBaja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonBajaActionPerformed(evt);
			}
		});
		panel.add(botonBaja);

		botonMostrarHistorial.setText("Listar");
		botonMostrarHistorial.setFont(new Font("Consolas", 4, 80));
		botonMostrarHistorial.setBackground(Color.white);
		botonMostrarHistorial.setForeground(Color.pink);
		botonMostrarHistorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonMostrarHistorialActionPerformed(evt);
			}
		});
		panel.add(botonMostrarHistorial);

		botonMostrar.setText("Mostrar");
		botonMostrar.setFont(new Font("Consolas", 4, 80));
		botonMostrar.setBackground(Color.white);
		botonMostrar.setForeground(Color.pink);
		botonMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonMostrarActionPerformed(evt);
			}
		});
		panel.add(botonMostrar);
		
		botonVolver.setText("Volver");
		botonVolver.setFont(new Font("Consolas", 4, 80));
		botonVolver.setBackground(Color.white);
		botonVolver.setForeground(Color.red);
		botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonVolverActionPerformed(evt);
			}
		});
		panel.add(botonVolver);


		this.getContentPane().add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	protected void botonVolverActionPerformed(ActionEvent evt) {
		new PantallaPrincipalPccomponentes(controlador);
		this.dispose();

	}

	
	private void botonAltaActionPerformed(ActionEvent evt) {
		new AltaProducto(controlador);
		this.dispose();
	}

	private void botonBajaActionPerformed(ActionEvent evt) {
		new BajaProducto(controlador);
		this.dispose();
	}

	private void botonMostrarHistorialActionPerformed(ActionEvent evt) {
		new MostrarHistorialProducto(controlador);
		this.dispose();
	}

	private void botonMostrarActionPerformed(ActionEvent evt) {
		new MostrarProducto(controlador);
		this.dispose();
	}

}