package GUIVenta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.Mediator;

public class MostrarHistorialClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panelDatos;
	private JPanel panelMostrar;
	private JTextArea textoListarVentas;
	private JButton botonBuscar;
	private JButton botonCancelar;
	private JTextArea textoIdCliente;
	private JTextField textoCampoIdCliente;

	private Mediator controlador;

	public MostrarHistorialClientes(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponentes();
	}

	private void initComponentes() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		panel = new JPanel();
		panelDatos = new JPanel();
		panelMostrar = new JPanel();
		textoListarVentas = new JTextArea();
		botonBuscar = new JButton();
		botonCancelar = new JButton();
		textoIdCliente = new JTextArea();
		textoCampoIdCliente = new JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 920));

		textoListarVentas.setEditable(false);
		textoListarVentas.setText("Listar Ventas");
		textoListarVentas.setBackground(Color.green);
		textoListarVentas.setForeground(Color.white);
		textoListarVentas.setFocusable(false);
		textoListarVentas.setFont(new Font("Consolas", 2, 100));
		this.getContentPane().add(textoListarVentas, BorderLayout.NORTH);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(1, 2, 0, 15));

		textoIdCliente.setText("DNI ControllerCliente");
		textoIdCliente.setFont(new Font("Consolas", 4, 80));
		textoIdCliente.setForeground(Color.green);
		textoIdCliente.setEditable(false);
		textoIdCliente.setFocusable(false);
		panelDatos.add(textoIdCliente);

		textoCampoIdCliente.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoCampoIdCliente);

		botonBuscar.setText("Buscar");
		botonBuscar.setFont(new Font("Consolas", 4, 80));
		botonBuscar.setForeground(Color.green);
		botonBuscar.setContentAreaFilled(false);
		botonBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonBuscarActionPerformed(evt);
			}
		});
		panel.add(botonBuscar);

		botonCancelar.setText("Cancelar");
		botonCancelar.setFont(new Font("Consolas", 4, 80));
		botonCancelar.setForeground(Color.red);
		botonCancelar.setContentAreaFilled(false);
		botonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		panel.add(botonCancelar);

		panelMostrar.add(panelDatos, BorderLayout.NORTH);
		this.getContentPane().add(panelMostrar, BorderLayout.CENTER);
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void botonBuscarActionPerformed(ActionEvent evt) {
		new ListarTabla(controlador, textoCampoIdCliente.getText());
		this.dispose();
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {

		String inf = controlador.cancelar();
		if (inf != "Exito") {
			JOptionPane.showConfirmDialog(null, "Error: " + inf, "DNI no encontrado", JOptionPane.PLAIN_MESSAGE,
					JOptionPane.ERROR_MESSAGE);
		} else {
			new PantallaPrincipalVentas(controlador);
			this.dispose();
		}

		this.dispose();
	}

}
