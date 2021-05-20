package GUIProductos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import main.Controlador;

public class BajaProducto extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panelDatos;
	private JPanel panelMostrar;

	private JTextArea textoBajaProducto;

	private JTextArea textoID;
	private JTextField campoID;

	private JButton botonEliminar;
	private JButton botonCancelar;
	private Controlador controlador;

	public BajaProducto(Controlador controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponents();
	}

	private void initComponents() {
		panel = new JPanel();
		panelMostrar = new JPanel();
		panelDatos = new JPanel();

		textoBajaProducto = new JTextArea();

		textoID = new JTextArea();
		campoID = new JTextField();

		botonEliminar = new JButton();
		botonCancelar = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1000, 720));

		this.getContentPane().setLayout(new BorderLayout());
		

		textoBajaProducto.setEditable(false);
		textoBajaProducto.setText("Baja Producto");
		textoBajaProducto.setBackground(Color.pink);
		textoBajaProducto.setForeground(Color.white);
		textoBajaProducto.setFocusable(false);
		textoBajaProducto.setFont(new Font("Consolas", 2, 100));
		this.getContentPane().add(textoBajaProducto, BorderLayout.NORTH);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(1, 2, 0, 100));

		
		textoID.setEditable(false);
		textoID.setText("ID");
		textoID.setForeground(Color.pink);
		textoID.setFocusable(false);
		textoID.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoID);

		campoID.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoID);
		
		botonEliminar.setText("Eliminar");
		botonEliminar.setFont(new Font("Consolas", 4, 80));
		botonEliminar.setForeground(Color.pink);
		botonEliminar.setContentAreaFilled(false);
		botonEliminar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonEliminarActionPerformed(evt);
			}
		});
		panel.add(botonEliminar);

		botonCancelar.setText("Cancelar");
		botonCancelar.setFont(new Font("Consolas", 4, 80));
		botonCancelar.setForeground(Color.red);
		botonCancelar.setContentAreaFilled(false);
		botonCancelar.addActionListener(new java.awt.event.ActionListener() {
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

	private void botonEliminarActionPerformed(ActionEvent evt) {
		String[] opciones = { "Eliminar", "Desactivar" };
		String[] Datos = { campoID.getText() };
		String inf = "" ;

		int elecion = JOptionPane.showOptionDialog(null, "¿ Deseas borrarlo o desactivarlo ?", "Eliminar",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (elecion == 0) {
			inf = controlador.baja("Producto", Datos);
		} else if (elecion == 1) {
			inf = controlador.desactivar("Producto", Datos);
		}

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Se ha podido dar de baja de la base de datos ", "Exito",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalProducto(controlador);
		this.dispose();
	}

}