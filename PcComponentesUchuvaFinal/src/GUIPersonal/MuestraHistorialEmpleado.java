package GUIPersonal;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import main.Mediator;

public class MuestraHistorialEmpleado extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panelMostrarHistorial;
	private JPanel panelDatos;

	private JTextArea textoBuscarHistorialEmpleado;

	private JTextArea textoDNI;
	private JTextField campoDNI;

	private JTable tabla;

	private JButton botonBuscar;
	private JButton botonCancelar;

	private Mediator controlador;

	public MuestraHistorialEmpleado(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponents();
	}

	private void initComponents() {
		// inicalizar objetos
		panel = new JPanel();
		panelMostrarHistorial = new JPanel();
		panelDatos = new JPanel();

		textoBuscarHistorialEmpleado = new JTextArea();
		textoDNI = new JTextArea();
		campoDNI = new JTextField();

		botonBuscar = new JButton();
		botonCancelar = new JButton();
		

		this.getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1500, 720));

		textoBuscarHistorialEmpleado.setEditable(false);
		textoBuscarHistorialEmpleado.setText("Mostrar Historial ControllerEmpleado");
		textoBuscarHistorialEmpleado.setBackground(Color.cyan);
		textoBuscarHistorialEmpleado.setForeground(Color.white);
		textoBuscarHistorialEmpleado.setFocusable(false);
		textoBuscarHistorialEmpleado.setFont(new Font("Consolas", 2, 90));

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrarHistorial.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(1, 2, 0, 100));

		textoDNI.setEditable(false);
		textoDNI.setText("DNI");
		textoDNI.setForeground(Color.cyan);
		textoDNI.setFocusable(false);
		textoDNI.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoDNI);
		campoDNI.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoDNI);

		botonBuscar.setText("Buscar");
		botonBuscar.setFont(new Font("Consolas", 4, 80));
		botonBuscar.setForeground(Color.cyan);
		botonBuscar.setContentAreaFilled(false);
		botonBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonMostrarActionPerformed(evt);
			}
		});
		panel.add(botonBuscar);

		botonCancelar.setText("Cancelar");
		botonCancelar.setFont(new Font("Consolas", 4, 80));
		botonCancelar.setForeground(Color.red);
		botonCancelar.setContentAreaFilled(false);
		botonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		panel.add(botonCancelar);

		panelMostrarHistorial.add(panelDatos, BorderLayout.NORTH);
		this.getContentPane().add(textoBuscarHistorialEmpleado, BorderLayout.NORTH);
		this.getContentPane().add(panelMostrarHistorial, BorderLayout.CENTER);
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void botonMostrarActionPerformed(ActionEvent evt) {
		String[] datos = { campoDNI.getText() };
		String inf = controlador.mostrarHistorial("ControllerEmpleado", datos);

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL MOSTRAR EL HISTORIAL DE VENTAS DEL EMPLEADO", JOptionPane.ERROR_MESSAGE);
		} else {
			tabla = new JTable(controlador.actualizarTabla());
			tabla.setFont(new java.awt.Font("Consolas", 4, 40));
			tabla.setRowHeight(50);
			tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
			JScrollPane paneScroll = new JScrollPane(tabla);
			panelMostrarHistorial.add(paneScroll, BorderLayout.CENTER);
			this.validate();
		}
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		String inf = controlador.cancelar();
		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL Modificar", JOptionPane.ERROR_MESSAGE);
		} else {
			new PantallaPrincipalEmpleado(controlador);
			this.dispose();
		}
	}
}