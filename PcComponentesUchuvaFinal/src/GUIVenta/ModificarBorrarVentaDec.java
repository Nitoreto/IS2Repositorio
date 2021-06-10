package GUIVenta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import GUISucursal.BorderDecorator;
import GUISucursal.backGroundDecorator;
import main.Mediator;

public class ModificarBorrarVentaDec extends JFrame{


	private static final long serialVersionUID = 1L;
	private JPanel panelMostrar;
	private JPanel panel;
	private JTextArea textoVenta;
	private JButton botonModificar;
	private JButton botonCancelar;
	private String idVenta;
	private Mediator controlador;
	private JTable tabla;

	public ModificarBorrarVentaDec(String idVenta, Mediator controlador) {
		super("PCComponentes Uchuva");
		this.idVenta = idVenta;
		this.controlador = controlador;
		initComponentes();
	}

	private void initComponentes() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		backGroundDecorator backGround = new backGroundDecorator();
		backGround.setLayout(new BorderLayout());
		BorderDecorator mainPanel = new BorderDecorator();
		this.setSize(800,600);
		backGround.add(mainPanel, BorderLayout.CENTER);
		this.setContentPane(backGround);
		
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
		mainPanel.add(textoVenta, BorderLayout.NORTH);
		
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

		mainPanel.add(panelMostrar, BorderLayout.CENTER);
		mainPanel.add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void CrearTabla() {
		String[] datos = {this.idVenta};
		String inf = controlador.buscar("ControllerVenta", datos);

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		}

		tabla = new JTable(controlador.actualizarTabla());
		tabla.setFont(new java.awt.Font("Consolas", 4, 40));
		tabla.setRowHeight(50);
		tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
		JScrollPane paneScroll = new JScrollPane(tabla);
		panelMostrar.add(paneScroll, BorderLayout.CENTER);

		this.validate();
	}

	private void botonModificarActionPerformed(ActionEvent evt) {
		String[] datos = { tabla.getValueAt(0, 0).toString(), tabla.getValueAt(0, 1).toString(),
				tabla.getValueAt(0, 2).toString(), tabla.getValueAt(0, 3).toString(), tabla.getValueAt(0, 4).toString(),
				tabla.getValueAt(0, 5).toString() };
		String inf = controlador.modificar("ControllerVenta", datos, idVenta);

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ID no encontrado", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Se ha podido modificar la venta ", "Exito",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalVentas(controlador);
		this.dispose();
	}

}
