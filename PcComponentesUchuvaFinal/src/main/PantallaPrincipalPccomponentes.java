package main;

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
import GUIClientes.PantallaPrincipalClientes;
import GUIMarca.PantallaPrincipalMarca;
import GUIPersonal.PantallaPrincipalEmpleado;
import GUIProductos.PantallaPrincipalProducto;
import GUIVenta.PantallaPrincipalVentas;
import main.Mediator;

public class PantallaPrincipalPccomponentes extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextArea textoPcComponentes;
	private JButton botonVentas;
	private JButton botonProductos;
	private JButton botonMarcas;
	private JButton botonClientes;
	private JButton botonPersonal;
	
	private Mediator controlador;
	
	public PantallaPrincipalPccomponentes(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponentes();
	}

	private void initComponentes() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		panel = new JPanel();
		botonPersonal = new JButton();
		textoPcComponentes = new JTextArea();
		botonVentas = new JButton();
		botonProductos = new JButton();
		botonMarcas = new JButton();
		botonClientes = new JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(900, 720));
		panel.setFocusable(false);
		panel.setLayout(new GridLayout(6, 1));

		textoPcComponentes.setEditable(false);
		textoPcComponentes.setText("PcComponentes");
		textoPcComponentes.setBackground(Color.black);
		textoPcComponentes.setForeground(Color.white);
		textoPcComponentes.setFocusable(false);
		textoPcComponentes.setFont(new Font("Consolas", 2, 100));
		textoPcComponentes.setBounds(400, 200, 200, 400);
		panel.add(textoPcComponentes);
		
		botonClientes.setText("Clientes");
		botonClientes.setBackground(Color.white);
		botonClientes.setForeground(Color.lightGray);
		botonClientes.setFont(new Font("Consolas", 4, 80));
		botonClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonClientesActionPerformed(evt);
			}
		});
		panel.add(botonClientes);
		
		botonPersonal.setText("Empleado");
		botonPersonal.setBackground(Color.white);
		botonPersonal.setForeground(Color.cyan);
		botonPersonal.setFont(new Font("Consolas", 4, 80));
		botonPersonal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonPersonalActionPerformed(evt);
			}
		});
		panel.add(botonPersonal);
		
		botonMarcas.setText("Marcas");
		botonMarcas.setBackground(Color.white);
		botonMarcas.setForeground(Color.orange);
		botonMarcas.setFont(new Font("Consolas", 4, 80));
		botonMarcas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonMarcasActionPerformed(evt);
			}
		});
		panel.add(botonMarcas);
		
		botonProductos.setText("Productos");
		botonProductos.setBackground(Color.white);
		botonProductos.setForeground(Color.pink);
		botonProductos.setFont(new Font("Consolas", 4, 80));
		botonProductos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonProductosActionPerformed(evt);
			}
		});
		panel.add(botonProductos);

		botonVentas.setText("Ventas");
		botonVentas.setBackground(Color.white);
		botonVentas.setForeground(Color.green);
		botonVentas.setFont(new Font("Consolas", 4, 80));
		botonVentas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonVentasActionPerformed(evt);
			}
		});
		panel.add(botonVentas);

		this.getContentPane().add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void botonVentasActionPerformed(ActionEvent evt) {
		// llamar a ventas
		new PantallaPrincipalVentas(controlador);
		this.dispose();
	}

	private void botonProductosActionPerformed(ActionEvent evt) {
		// llamar a marcas
		new PantallaPrincipalProducto(controlador);
		this.dispose();
	}

	private void botonMarcasActionPerformed(ActionEvent evt) {
		// llamar a marcas
		new PantallaPrincipalMarca(controlador);
		this.dispose();
	}

	private void botonClientesActionPerformed(ActionEvent evt) {
		// llamar a clientes
		new PantallaPrincipalClientes(controlador);
		this.dispose();

	}

	private void botonPersonalActionPerformed(ActionEvent evt) {
		// llamar a empleado
		new PantallaPrincipalEmpleado(controlador);
		this.dispose();

	}

}
