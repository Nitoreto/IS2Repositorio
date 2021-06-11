package GUIMarca;

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

public class BuscarMarca extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panelMostrar;
	private JPanel panelDatos;

	private JTextArea textoBuscarMarca;

	private JTextArea textoCIF;
	private JTextField campoCIF;

	private JTable tabla;

	private JButton botonBuscar;
	private JButton botonModifcar;
	private JButton botonCancelar;
	private ModeloTablaEditable model;
	private Mediator mediator;

	public BuscarMarca(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.mediator = controlador;
		initComponents();
	}

	private void initComponents() {
		// inicalizar objetos
		panel = new JPanel();
		panelMostrar = new JPanel();
		panelDatos = new JPanel();

		textoBuscarMarca = new JTextArea();
		textoCIF = new JTextArea();
		campoCIF = new JTextField();

		botonBuscar = new JButton();
		botonModifcar = new JButton();
		botonCancelar = new JButton();

		this.getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1750, 720));

		textoBuscarMarca.setEditable(false);
		textoBuscarMarca.setText("Buscar ControllerMarca");
		textoBuscarMarca.setBackground(Color.orange);
		textoBuscarMarca.setForeground(Color.white);
		textoBuscarMarca.setFocusable(false);
		textoBuscarMarca.setFont(new Font("Consolas", 2, 100));

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(1, 2, 0, 100));

		textoCIF.setEditable(false);
		textoCIF.setText("CIF");
		textoCIF.setForeground(Color.orange);
		textoCIF.setFocusable(false);
		textoCIF.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoCIF);
		campoCIF.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoCIF);

		botonBuscar.setText("Buscar");
		botonBuscar.setFont(new Font("Consolas", 4, 80));
		botonBuscar.setForeground(Color.orange);
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
		this.getContentPane().add(textoBuscarMarca, BorderLayout.NORTH);
		this.getContentPane().add(panelMostrar, BorderLayout.CENTER);
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void botonModificarActionPerformed(ActionEvent evt) {
		String[] datos = { tabla.getValueAt(0, 0).toString(), tabla.getValueAt(0, 1).toString(),
				tabla.getValueAt(0, 2).toString(), tabla.getValueAt(0, 3).toString() };
		mediator.modificar("ControllerMarca", datos, campoCIF.getText());

	}

	private void botonBuscarActionPerformed(ActionEvent evt) {
		String[] datos = { campoCIF.getText() };
		mediator.buscar("ControllerMarca", datos);


	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		mediator.cancelar();

	
			this.dispose();
			new PantallaPrincipalMarca(mediator);
		
	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Se ha podido modificar la base de datos ", "Exito",
				JOptionPane.INFORMATION_MESSAGE);
		this.campoCIF.setText((String) tabla.getValueAt(0, 0));
	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub

		botonModifcar.setText("Modificar");
		botonModifcar.setFont(new Font("Arial", 1, 80));
		botonModifcar.setContentAreaFilled(false);
		botonModifcar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonModificarActionPerformed(evt);
			}
		});
		panel.add(botonModifcar);
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
