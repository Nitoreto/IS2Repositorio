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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import main.Controlador;

public class ModificarVenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panelDatos;
	private JPanel panelMostrar;
	private JTextArea textoModificarVenta;
	private JButton botonModificar;
	private JButton botonCancelar;
	private JButton botonEliminar;
	private Controlador controlador;

	JTextArea textoIdVenta;
	JTextField textoCampoIdVenta;

	public ModificarVenta(Controlador controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponentes();
	}

	private void initComponentes() {
		panel = new JPanel();
		panelDatos = new JPanel();
		panelMostrar = new JPanel();
		textoModificarVenta = new JTextArea();
		botonModificar = new JButton();
		botonCancelar = new JButton();
		textoIdVenta = new JTextArea();
		textoCampoIdVenta = new JTextField();
		botonEliminar = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 720));

		this.getContentPane().setLayout(new BorderLayout());

		textoModificarVenta.setEditable(false);
		textoModificarVenta.setText("Modificar Ventas");
		textoModificarVenta.setBackground(Color.green);
		textoModificarVenta.setForeground(Color.white);
		textoModificarVenta.setFocusable(false);
		textoModificarVenta.setFont(new Font("Consolas", 2, 100));

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelDatos.setLayout(new GridLayout(1, 2, 0, 20));
		panelMostrar.setLayout(new BorderLayout());

		textoIdVenta.setEditable(false);
		textoIdVenta.setText("ID ControladorVenta a modificar");
		textoIdVenta.setForeground(Color.green);
		textoIdVenta.setFont(new Font("Consolas", 4, 80));
		textoIdVenta.setFocusable(false);
		panelDatos.add(textoIdVenta);
		textoCampoIdVenta.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoCampoIdVenta);

		botonModificar.setText("Modificar");
		botonModificar.setFont(new Font("Consolas", 4, 80));
		botonModificar.setForeground(Color.green);
		botonModificar.setContentAreaFilled(false);
		botonModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonBuscarActionPerformed(evt);
			}
		});
		panel.add(botonModificar);

		botonEliminar.setText("Baja");
		botonEliminar.setFont(new Font("Consolas", 4, 80));
		botonEliminar.setForeground(Color.green);
		botonEliminar.setContentAreaFilled(false);
		botonEliminar.addActionListener(new ActionListener() {
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
		botonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed();
			}
		});
		panel.add(botonCancelar);

		panelMostrar.add(panelDatos, BorderLayout.NORTH);
		this.getContentPane().add(textoModificarVenta, BorderLayout.NORTH);
		this.getContentPane().add(panelMostrar, BorderLayout.CENTER);
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void botonBuscarActionPerformed(ActionEvent evt) {
		String[] datos = { textoCampoIdVenta.getText() };
		String inf = controlador.buscar("ControladorVenta", datos);
		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "ID no encontrado", "Error: ", JOptionPane.ERROR_MESSAGE);
		} else {
			new ModificarBorrarVenta(textoCampoIdVenta.getText(), controlador);
			this.dispose();
		}
	}

	private void botonEliminarActionPerformed(ActionEvent evt) {
		String[] opciones = { "Eliminar", "Desactivar" };
		String[] datos = { textoCampoIdVenta.getText() };
		String inf = "" ;

		int elecion = JOptionPane.showOptionDialog(null, "¿ Deseas borrarlo o desactivarlo ?", "Eliminar",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (elecion == 0) {
			inf = controlador.baja("ControladorVenta", datos);
		} else if (elecion == 1) {
			inf = controlador.desactivar("ControladorVenta", datos);
		}

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Se ha podido dar de baja de la base de datos ", "Exito",
					JOptionPane.INFORMATION_MESSAGE);
		}
		//----------
	}

	private void botonCancelarActionPerformed() {
		String inf = controlador.cancelar();
		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: ", inf, JOptionPane.ERROR_MESSAGE);
		} else {
			new PantallaPrincipalVentas(controlador);
			this.dispose();
		}
	}

}
