package GUIProductos;

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

public class MostrarProducto extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panelMostrar;
	private JPanel panelDatos;

	private JTextArea textoMostrarProducto;

	private JTextArea textoID;
	private JTextField campoID;

	private JTable tabla;

	private JButton botonBuscar;
	private JButton botonModificar;
	private JButton botonCancelar;
	private ModeloTablaEditable model;

	private Mediator mediator;

	public MostrarProducto(Mediator mediator) {
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

		textoMostrarProducto = new JTextArea();
		textoID = new JTextArea();
		campoID = new JTextField();

		botonBuscar = new JButton();
		botonModificar = new JButton();
		botonCancelar = new JButton();

		this.getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 900));

		textoMostrarProducto.setEditable(false);
		textoMostrarProducto.setText("Mostrar ControllerProducto");
		textoMostrarProducto.setFocusable(false);
		textoMostrarProducto.setFont(new Font("Consolas", 4, 80));
		textoMostrarProducto.setBackground(Color.pink);
		textoMostrarProducto.setForeground(Color.white);
		this.getContentPane().add(textoMostrarProducto, BorderLayout.NORTH);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(1, 2, 0, 100));

		textoID.setEditable(false);
		textoID.setText("ID");
		textoID.setFocusable(false);
		textoID.setFont(new Font("Consolas", 4, 80));
		textoID.setForeground(Color.pink);
		panelDatos.add(textoID);

		campoID.setFont(new Font("Arial", 1, 50));
		panelDatos.add(campoID);

		botonBuscar.setText("Buscar");
		botonBuscar.setFont(new Font("Consolas", 4, 80));
		botonBuscar.setForeground(Color.pink);
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
		String[] Datos = { campoID.getText() };
		mediator.buscar("ControllerProducto", Datos);

	}

	private void botonModificarActionPerformed(ActionEvent evt) {
		String[] Datos = { tabla.getValueAt(0, 0).toString(), tabla.getValueAt(0, 1).toString(),
				tabla.getValueAt(0, 2).toString(), tabla.getValueAt(0, 3).toString(), tabla.getValueAt(0, 4).toString(),
				tabla.getValueAt(0, 5).toString() };
		mediator.modificar("ControllerProducto", Datos, campoID.getText());
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		this.dispose();
		new PantallaPrincipalProducto(mediator);
	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, msg, "Exito", JOptionPane.INFORMATION_MESSAGE);
		this.campoID.setText(tabla.getValueAt(0, 0).toString());
	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL MODIFCAR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		botonModificar.setText("Modificar");
		botonModificar.setFont(new Font("Arial", 1, 80));
		botonModificar.setContentAreaFilled(false);
		botonModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonModificarActionPerformed(evt);
			}
		});
		panel.add(botonModificar);
		model = new ModeloTablaEditable(generarTabla, generarTitulo);
		tabla = new JTable(model);
		tabla.setFont(new java.awt.Font("Consolas", 4, 40));
		tabla.setRowHeight(50);
		tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
		JScrollPane paneScroll = new JScrollPane(tabla);
		panelMostrar.add(paneScroll, BorderLayout.CENTER);

		this.validate();

	}

}
