package GUIVenta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import GUISucursal.BorderDecorator;
import GUISucursal.backGroundDecorator;
import main.Mediator;

public class ListarTablaDec extends JFrame{
	private JTextArea textoListarVentas;

	private JButton botonOk;
	private JTable tabla;
	private Mediator controlador;
	private String DNICliente;
	public ListarTablaDec(Mediator controlador, String DNICliente) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		this.DNICliente = DNICliente;
		this.getContentPane().setLayout(new BorderLayout());
		if (CrearTabla().equalsIgnoreCase("Exito"))
			initComponentes();
		
	}
	
	
	private void initComponentes() {
		backGroundDecorator backGround = new backGroundDecorator();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		backGround.setLayout(new BorderLayout());
		BorderDecorator mainPanel = new BorderDecorator();
		backGround.add(mainPanel, BorderLayout.CENTER);
		this.setContentPane(backGround);

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
		mainPanel.add(textoListarVentas, BorderLayout.NORTH);

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
		mainPanel.add(botonOk, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private String CrearTabla() {
		String[] datos = { "rand", DNICliente };
		String inf = controlador.mostrarHistorial("ControllerVenta", datos);

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
			return "Error";
		} else {
			tabla = new JTable(controlador.actualizarTabla());
			tabla.setFont(new java.awt.Font("Consolas", 4, 40));
			tabla.setRowHeight(50);
			tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
			JScrollPane paneScroll = new JScrollPane(tabla);
			this.getContentPane().add(paneScroll, BorderLayout.CENTER);
			this.validate();
			return "Exito";
		}
	}
	private void botonOkActionPerformed() {
		String inf = controlador.cancelar();
		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL Modificar", JOptionPane.ERROR_MESSAGE);
		} else {
			this.dispose();
			new PantallaPrincipalVentas(controlador);
		}
	}

}
