package GUIVenta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import GUIPersonal.PantallaPrincipalEmpleado;
import Model.ModeloTabla;
import Model.ModeloTablaEditable;
import Model.Observer;
import main.Mediator;

public class ListarTabla extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;

	private JTextArea textoListarVentas;
	private ModeloTabla model;
	private JButton botonOk;
	private JTable tabla;
	private Mediator mediator;
	private String DNICliente;

	public ListarTabla(Mediator mediator, String DNICliente) {

		super("PCComponentes Uchuva");
		this.mediator = mediator;
		this.DNICliente = DNICliente;
		this.getContentPane().setLayout(new BorderLayout());
		mediator.asignarObserver(this);
		CrearTabla();
		initComponentes();

	}

	private void initComponentes() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		textoListarVentas = new JTextArea();
		botonOk = new JButton();
		

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 1080));

		textoListarVentas.setEditable(false);
		textoListarVentas.setText("Lista de Ventas");
		textoListarVentas.setFocusable(false);
		textoListarVentas.setFont(new Font("Consolas", 2, 100));
		textoListarVentas.setBackground(Color.green);
		textoListarVentas.setForeground(Color.white);
		this.getContentPane().add(textoListarVentas, BorderLayout.NORTH);

		botonOk.setText("Cancelar");
		botonOk.setFont(new Font("Consolas", 4, 80));
		botonOk.setForeground(Color.red);
		botonOk.setContentAreaFilled(false);
		botonOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonOkActionPerformed();
			}
		});
		this.getContentPane().add(botonOk, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void CrearTabla() {
		String[] datos = {DNICliente };
		mediator.mostrarHistorial("ControllerVenta", datos);
	}

	private void botonOkActionPerformed() {
		
	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
	
		
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		model = new ModeloTabla(generarTabla, generarTitulo);
		tabla = new JTable(model);
		tabla.setFont(new java.awt.Font("Consolas", 4, 40));
		tabla.setRowHeight(50);
		tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
		JScrollPane paneScroll = new JScrollPane(tabla);
		this.getContentPane().add(paneScroll, BorderLayout.CENTER);
		this.validate();
		
	}

}
