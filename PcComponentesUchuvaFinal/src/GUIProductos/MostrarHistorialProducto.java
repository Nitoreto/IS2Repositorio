package GUIProductos;

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
import javax.swing.WindowConstants;

import main.Controlador;

public class MostrarHistorialProducto extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	private JTextArea textoMostrarHistorialProducto;

	private JTable tabla;

	private JButton botonCancelar;

	private Controlador controlador;

	public MostrarHistorialProducto(Controlador controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponents();
	}

	private void initComponents() {
		// inicializar objetos
		panel = new JPanel();

		textoMostrarHistorialProducto = new JTextArea();

		botonCancelar = new JButton();

		this.getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 1080));

		textoMostrarHistorialProducto.setEditable(false);
		textoMostrarHistorialProducto.setText("Mostrar Historial ControladorProducto");
		textoMostrarHistorialProducto.setFocusable(false);
		textoMostrarHistorialProducto.setFont(new Font("Consolas", 4, 80));
		textoMostrarHistorialProducto.setBackground(Color.pink);
		textoMostrarHistorialProducto.setForeground(Color.white);
		this.getContentPane().add(textoMostrarHistorialProducto, BorderLayout.NORTH);

		String inf = controlador.listar("ControladorProducto");

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		}
		tabla = new JTable(controlador.actualizarTabla());
		tabla.setFont(new java.awt.Font("Consolas", 4, 40));
		tabla.setRowHeight(50);
		tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
		JScrollPane paneScroll = new JScrollPane(tabla);
		this.getContentPane().add(paneScroll, BorderLayout.CENTER);

		this.validate();

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));

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

		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {

		String inf = controlador.cancelar();

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		} else {

			new PantallaPrincipalProducto(controlador);
			this.dispose();
		}

	}

}