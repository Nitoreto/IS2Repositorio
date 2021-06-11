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
import Model.ModeloTablaEditable;
import Model.Observer;
import main.Mediator;

public class ModificarBorrarVenta extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel panelMostrar;
	private JPanel panel;
	private JTextArea textoVenta;
	private JButton botonModificar;
	private JButton botonCancelar;
	private String idVenta;
	private Mediator mediator;
	private JTable tabla;
	private ModeloTablaEditable model;

	public ModificarBorrarVenta(String idVenta, Mediator controlador) {
		super("PCComponentes Uchuva");
		this.idVenta = idVenta;
		this.mediator = controlador;
		initComponentes();
	}

	private void initComponentes() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		panelMostrar = new JPanel();
		panel = new JPanel();
		textoVenta = new JTextArea();

		botonCancelar = new JButton();
		botonModificar = new JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 720));

		textoVenta.setEditable(false);
		textoVenta.setText("Modificar ControllerVenta" + idVenta);
		textoVenta.setBackground(Color.green);
		textoVenta.setForeground(Color.white);
		textoVenta.setFocusable(false);
		textoVenta.setFont(new Font("Consolas", 2, 100));
		this.getContentPane().add(textoVenta, BorderLayout.NORTH);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		CrearTabla();
		botonModificar.setText("Modificar");
		botonModificar.setFont(new Font("Consolas", 4, 80));
		botonModificar.setForeground(Color.green);
		botonModificar.setContentAreaFilled(false);
		botonModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonModificarActionPerformed(evt);
			}
		});
		panel.add(botonModificar);

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

		this.getContentPane().add(panelMostrar, BorderLayout.CENTER);
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void CrearTabla() {
		String[] datos = {this.idVenta};
		mediator.buscar("ControllerVenta", datos);


		
	}

	private void botonModificarActionPerformed(ActionEvent evt) {
		String[] datos = { tabla.getValueAt(0, 0).toString(), tabla.getValueAt(0, 1).toString(),
				tabla.getValueAt(0, 2).toString(), tabla.getValueAt(0, 3).toString(), tabla.getValueAt(0, 4).toString(),
				tabla.getValueAt(0, 5).toString() };
		String inf = mediator.modificar("ControllerVenta", datos, idVenta);

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ID no encontrado", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Se ha podido modificar la venta ", "Exito",
					JOptionPane.INFORMATION_MESSAGE);
		}
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
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
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
