package GUIPersonal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import main.Controlador;
import main.PantallaPrincipalPccomponentes;

public class PantallaPrincipalEmpleado extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textoEmpleado;
	private JButton botonListar;
	private JButton botonAlta;
	private JButton botonBuscar;
	private JPanel panel;
	private JButton botonVolver;
	private JButton botonMostrarHistorial;
	private Controlador controlador;

	public PantallaPrincipalEmpleado(Controlador controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponents();
	}

	private void initComponents() {
		panel = new JPanel();
		textoEmpleado = new JTextArea();
		botonListar = new JButton();
		botonAlta = new JButton();
		botonBuscar = new JButton();
		botonMostrarHistorial = new JButton();

		botonVolver = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(900, 720));
		panel.setLayout(new GridLayout(6, 1));

		textoEmpleado.setEditable(false);
		textoEmpleado.setText("Empleado");
		textoEmpleado.setBackground(Color.cyan);
		textoEmpleado.setForeground(Color.white);
		textoEmpleado.setFocusable(true);
		textoEmpleado.setFont(new Font("Consolas", 2, 90));
		textoEmpleado.setBounds(400, 200, 200, 400);
		panel.add(textoEmpleado);

		botonAlta.setText("Alta");
		botonAlta.setFont(new Font("Consolas", 4, 80));
		botonAlta.setBackground(Color.white);
		botonAlta.setForeground(Color.cyan);
		botonAlta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonAltaActionPerformed(evt);
			}
		});
		panel.add(botonAlta);

		botonBuscar.setText("Buscar");
		botonBuscar.setFont(new Font("Consolas", 4, 80));
		botonBuscar.setBackground(Color.white);
		botonBuscar.setForeground(Color.cyan);
		botonBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonBuscarActionPerformed(evt);
			}
		});
		panel.add(botonBuscar);

		botonListar.setText("Listar");
		botonListar.setFont(new Font("Consolas", 4, 80));
		botonListar.setBackground(Color.white);
		botonListar.setForeground(Color.cyan);
		botonListar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonListarActionPerformed(evt);
			}
		});
		panel.add(botonListar);

		botonMostrarHistorial.setText("Mostrar Historial");
		botonMostrarHistorial.setFont(new Font("Consolas", 4, 80));
		botonMostrarHistorial.setBackground(Color.white);
		botonMostrarHistorial.setForeground(Color.cyan);
		botonMostrarHistorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonMostrarHistorialActionPerformed(evt);
			}
		});
		panel.add(botonMostrarHistorial);

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

	private void botonListarActionPerformed(ActionEvent evt) {
		new ListaEmpleados(controlador);
		this.dispose();
	}

	private void botonAltaActionPerformed(ActionEvent evt) {
		new AñadirEmpleado(controlador);
		this.dispose();
	}

	private void botonBuscarActionPerformed(ActionEvent evt) {
		new BuscarEmpleado(controlador);
		this.dispose();
	}

	private void botonMostrarHistorialActionPerformed(ActionEvent evt) {
		new MuestraHistorialEmpleado(controlador);
		this.dispose();
	}
}