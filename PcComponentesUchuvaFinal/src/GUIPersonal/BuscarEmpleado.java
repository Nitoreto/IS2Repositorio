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

import Model.ModeloTablaEditable;
import Model.Observer;
import main.Mediator;

public class BuscarEmpleado extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panelMostrar;
	private JPanel panelDatos;

	private JTextArea textoBuscarEmpleado;
	private ModeloTablaEditable model;
	private JTextArea textoID;
	private JTextField campoID;

	private JTable tabla;

	private JButton botonBuscar;
	private JButton botonModifcar;
	private JButton botonCancelar;

	private Mediator mediator;

	public BuscarEmpleado(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.mediator = controlador;
		mediator.asignarObserver(this);
		initComponents();
	}

	private void initComponents() {
		// inicalizar objetos
		panel = new JPanel();
		panelMostrar = new JPanel();
		panelDatos = new JPanel();

		textoBuscarEmpleado = new JTextArea();
		textoID = new JTextArea();
		campoID = new JTextField();

		botonBuscar = new JButton();
		botonModifcar = new JButton();
		botonCancelar = new JButton();

		this.getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1750, 720));

		textoBuscarEmpleado.setEditable(false);
		textoBuscarEmpleado.setText("Buscar ControllerEmpleado");
		textoBuscarEmpleado.setBackground(Color.cyan);
		textoBuscarEmpleado.setForeground(Color.white);
		textoBuscarEmpleado.setFocusable(false);
		textoBuscarEmpleado.setFont(new Font("Consolas", 2, 100));

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(1, 2, 0, 100));

		textoID.setEditable(false);
		textoID.setText("ID");
		textoID.setForeground(Color.cyan);
		textoID.setFocusable(false);
		textoID.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoID);
		campoID.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoID);

		botonBuscar.setText("Buscar");
		botonBuscar.setFont(new Font("Consolas", 4, 80));
		botonBuscar.setForeground(Color.cyan);
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
		this.getContentPane().add(textoBuscarEmpleado, BorderLayout.NORTH);
		this.getContentPane().add(panelMostrar, BorderLayout.CENTER);
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void botonModificarActionPerformed(ActionEvent evt) {
		String[] datos = { tabla.getValueAt(0, 0).toString(), tabla.getValueAt(0, 1).toString(),
				tabla.getValueAt(0, 2).toString(), tabla.getValueAt(0, 3).toString(), tabla.getValueAt(0, 4).toString(),
				tabla.getValueAt(0, 5).toString(), tabla.getValueAt(0, 6).toString(),  tabla.getValueAt(0, 7).toString() };
		mediator.modificar("ControllerEmpleado", datos, campoID.getText());

	}

	private void botonBuscarActionPerformed(ActionEvent evt) {
		String[] datos = { campoID.getText() };
		mediator.buscar("ControllerEmpleado", datos);
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		this.dispose();
		new PantallaPrincipalEmpleado(mediator);

	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Se ha podido modificar la base de datos ", "Exito",
				JOptionPane.INFORMATION_MESSAGE);
		this.campoID.setText(tabla.getValueAt(0, 0).toString());
	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		model = new ModeloTablaEditable(generarTabla, generarTitulo);

		botonModifcar.setText("Modificar");
		botonModifcar.setFont(new Font("Consolar", 8, 80));
		botonModifcar.setForeground(Color.cyan);
		botonModifcar.setContentAreaFilled(false);
		botonModifcar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonModificarActionPerformed(evt);
			}
		});
		panel.add(botonModifcar);

		tabla = new JTable(model);
		tabla.setFont(new java.awt.Font("Consolas", 4, 40));
		tabla.setRowHeight(50);
		tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
		JScrollPane paneScroll = new JScrollPane(tabla);
		panelMostrar.add(paneScroll, BorderLayout.CENTER);
		this.validate();

	}
}
