package GUIClientes;

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

import Model.ModeloTablaEditable;
import Model.Observer;
import main.Mediator;

public class BuscarCliente extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panelMostrar;
	private JPanel panelDatos;

	private JTextArea textoBuscarCliente;

	private JTable tabla;

	private JTextArea textoDNI;
	private JTextField campoDNI;

	private JButton botonBuscar;
	private JButton botonModificar;
	private JButton botonCancelar;

	private Mediator mediator;

	public BuscarCliente(Mediator mediator) {
		super("PCComponentes Uchuva");
		this.mediator = mediator;
		mediator.asignarObserver(this);
		initComponents();
	}

	private void initComponents() {
		// inicalizar objetos
		panel = new JPanel();
		panelMostrar = new JPanel();
		panelDatos = new JPanel();

		botonBuscar = new JButton();
		botonModificar = new JButton();
		botonCancelar = new JButton();

		textoDNI = new JTextArea();
		campoDNI = new JTextField();

		textoBuscarCliente = new JTextArea();

		this.getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1750, 720));

		textoBuscarCliente.setEditable(false);
		textoBuscarCliente.setText("Buscar ControllerCliente");
		textoBuscarCliente.setBackground(Color.lightGray);
		textoBuscarCliente.setForeground(Color.white);
		textoBuscarCliente.setFocusable(false);
		textoBuscarCliente.setFont(new Font("Consolas", 2, 100));
		this.getContentPane().add(textoBuscarCliente, BorderLayout.NORTH);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(1, 2, 0, 100));

		textoDNI.setEditable(false);
		textoDNI.setText("DNI");
		textoDNI.setForeground(Color.lightGray);
		textoDNI.setFocusable(false);
		textoDNI.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoDNI);
		campoDNI.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoDNI);

		botonBuscar.setText("Buscar");
		botonBuscar.setFont(new Font("Consolas", 4, 80));
		botonBuscar.setForeground(Color.lightGray);
		botonBuscar.setContentAreaFilled(false);
		botonBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
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
			public void actionPerformed(ActionEvent evt) {
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
		String[] datos = { campoDNI.getText() };
		mediator.buscar("ControllerCliente", datos);
		botonModificar.setText("Modificar");
		botonModificar.setFont(new Font("Consolas", 4, 80));
		botonModificar.setForeground(Color.lightGray);
		botonModificar.setContentAreaFilled(false);
		botonModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonModificarActionPerformed(evt);
			}
		});
	}

	private void botonModificarActionPerformed(ActionEvent evt) {
		String[] datos = { tabla.getValueAt(0, 0).toString(), tabla.getValueAt(0, 1).toString(),
				tabla.getValueAt(0, 2).toString(), tabla.getValueAt(0, 3).toString() };
		mediator.modificar("ControllerCliente", datos, campoDNI.getText());
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		this.dispose();
		new PantallaPrincipalClientes(mediator);
	}

	@Override
	public void onCorrectMessage(String msg) {
		JOptionPane.showMessageDialog(null, "Se ha podido modificar la base de datos ", "Exito",
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void onIncorrectMessage(String msg) {
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		panel.add(botonModificar);
		tabla = new JTable(new ModeloTablaEditable(generarTabla, generarTitulo));
		tabla.setFont(new java.awt.Font("Consolas", 4, 40));
		tabla.setRowHeight(50);
		tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
		JScrollPane paneScroll = new JScrollPane(tabla);
		panelMostrar.add(paneScroll, BorderLayout.CENTER);
		this.validate();
	}

}