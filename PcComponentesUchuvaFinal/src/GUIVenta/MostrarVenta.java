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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.ModeloTabla;
import Model.Observer;
import main.Mediator;

public class MostrarVenta extends JFrame implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panelMostrarVenta;
	private JPanel panelDatos;
	private JTable tabla;
	private JTextArea textoMostrarVenta;
	private JButton botonBuscar;
	private JButton botonCancelar;
	private JTextArea textoIdVenta;
	private JTextField textoCampoIdVenta;
	private Mediator mediator;
	private ModeloTabla model;

	public MostrarVenta(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.mediator = controlador;
		initComponentes();
	}

	private void initComponentes() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		panelMostrarVenta = new JPanel();
		panelDatos = new JPanel();
		textoMostrarVenta = new JTextArea();
		botonBuscar = new JButton();
		botonCancelar = new JButton();
		textoIdVenta = new JTextArea();
		textoCampoIdVenta = new JTextField();
		panel = new JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 720));

		this.getContentPane().setLayout(new BorderLayout());

		textoMostrarVenta.setEditable(false);
		textoMostrarVenta.setText("Mostrar ControllerVenta");
		textoMostrarVenta.setBackground(Color.green);
		textoMostrarVenta.setForeground(Color.white);
		textoMostrarVenta.setFocusable(false);
		textoMostrarVenta.setFont(new Font("Consolas", 2, 100));
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrarVenta.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(1, 2, 0, 100));

		textoIdVenta.setText("ID ControllerVenta");
		textoIdVenta.setFont(new Font("Consolas", 4, 80));
		textoIdVenta.setForeground(Color.green);
		textoIdVenta.setEditable(false);
		textoIdVenta.setFocusable(false);
		panelDatos.add(textoIdVenta);
		textoCampoIdVenta.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoCampoIdVenta);

		botonBuscar.setText("Buscar");
		botonBuscar.setFont(new Font("Consolas", 4, 80));
		botonBuscar.setForeground(Color.green);
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
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		panel.add(botonCancelar);

		panelMostrarVenta.add(panelDatos, BorderLayout.NORTH);
		this.getContentPane().add(textoMostrarVenta, BorderLayout.NORTH);
		this.getContentPane().add(panelMostrarVenta, BorderLayout.CENTER);
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void botonBuscarActionPerformed(ActionEvent evt) {
		String[] datos = { textoCampoIdVenta.getText() };
		mediator.buscar("ControllerVenta", datos);
		
			
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalVentas(mediator);
		this.dispose();
	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ID no encontrado", JOptionPane.ERROR_MESSAGE);
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
		panelMostrarVenta.add(paneScroll, BorderLayout.CENTER);
		this.validate();
	}

}
