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

public class AltaProducto extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panelDatos;
	private JPanel panelMostrar;

	private JTextArea textoAltaProducto;

	private JTextArea textoID;
	private JTextField campoID;

	private JTextArea textoPrecio;
	private JTextField campoPrecio;

	private JTextArea textoNombre;
	private JTextField campoNombre;
	
	private JTextArea textoNombreMarca;
	private JTextField campoNombreMarca;

	private JTextArea textoDescripcion;
	private JTextField campoDescripcion;

	private JButton botonGuardar;
	private JButton botonCancelar;
	private Controlador controlador;

	public AltaProducto(Controlador controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponents();
	}

	private void initComponents() {
		panelDatos = new JPanel();
		panelMostrar = new JPanel();
		panel = new JPanel();
		
		textoAltaProducto = new JTextArea();

		textoID = new JTextArea();
		campoID = new JTextField();

		textoPrecio = new JTextArea();
		campoPrecio = new JTextField();

		textoNombre = new JTextArea();
		campoNombre = new JTextField();
		
		textoNombreMarca = new JTextArea();
		campoNombreMarca = new JTextField();

		textoDescripcion = new JTextArea();
		campoDescripcion = new JTextField();

		botonGuardar = new JButton();
		botonCancelar = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1250, 850));

		textoAltaProducto.setEditable(false);
		textoAltaProducto.setText("Alta Producto");
		textoAltaProducto.setBackground(Color.pink);
		textoAltaProducto.setForeground(Color.white);
		textoAltaProducto.setFocusable(false);
		textoAltaProducto.setFont(new Font("Consolas", 4, 100));
		this.getContentPane().add(textoAltaProducto, BorderLayout.NORTH);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(6, 1, 0, 15));

		textoID.setEditable(false);
		textoID.setText("ID");
		textoID.setForeground(Color.pink);
		textoID.setFocusable(false);
		textoID.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoID);

		campoID.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoID);

		textoNombre.setEditable(false);
		textoNombre.setText("Nombre");
		textoNombre.setForeground(Color.pink);
		textoNombre.setFocusable(false);
		textoNombre.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoNombre);

		campoNombre.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoNombre);
		
		textoNombreMarca.setEditable(false);
		textoNombreMarca.setText("Marca");
		textoNombreMarca.setForeground(Color.pink);
		textoNombreMarca.setFocusable(false);
		textoNombreMarca.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoNombreMarca);

		campoNombreMarca.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoNombreMarca);

		textoDescripcion.setEditable(false);
		textoDescripcion.setText("Descripcion");
		textoDescripcion.setForeground(Color.pink);
		textoDescripcion.setFocusable(false);
		textoDescripcion.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoDescripcion);

		campoDescripcion.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoDescripcion);
		
		textoPrecio.setEditable(false);
		textoPrecio.setText("Precio");
		textoPrecio.setForeground(Color.pink);
		textoPrecio.setFocusable(false);
		textoPrecio.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoPrecio);

		campoPrecio.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoPrecio);

		botonGuardar.setText("Guardar");
		botonGuardar.setFont(new Font("Consolas", 4, 80));
		botonGuardar.setForeground(Color.pink);
		botonGuardar.setContentAreaFilled(false);
		botonGuardar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonGuardarActionPerformed(evt);
			}
		});
		panel.add(botonGuardar);

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

	private void botonGuardarActionPerformed(ActionEvent evt) {
		String[] Datos = { campoID.getText(), campoNombre.getText(), campoNombreMarca.getText(),
				campoDescripcion.getText(), campoPrecio.getText(), };
		String inf = controlador.alta("Producto", Datos);
		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Se ha podido añadir a la base de datos ", "Exito",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalProducto(controlador);
		this.dispose();
	}

}
