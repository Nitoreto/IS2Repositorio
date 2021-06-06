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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import main.Controlador;

public class AltaMarca extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panelMostrar;
	private JPanel panelDatos;

	private JTextArea textoAltaMarca;
	private JTextArea textoCifMarca;
	private JTextField campoCifMarca;

	private JTextArea textoNombre;
	private JTextField campoNombre;

	private JTextArea textoPais;
	private JTextField campoPais;

	private JButton botonGuardar;
	private JButton botonCancelar;
	private Controlador controlador;

	public AltaMarca(Controlador controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponents();
	}

	private void initComponents() {
		// inicalizar objetos
		panel = new JPanel();
		panelMostrar = new JPanel();
		panelDatos = new JPanel();

		textoAltaMarca = new JTextArea();

		textoCifMarca = new JTextArea();
		campoCifMarca = new JTextField();

		textoNombre = new JTextArea();
		campoNombre = new JTextField();

		textoPais = new JTextArea();
		campoPais = new JTextField();

		botonGuardar = new JButton();
		botonCancelar = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1280, 720));
		
		textoAltaMarca.setEditable(false);
		textoAltaMarca.setText("Alta ControladorMarca");
		textoAltaMarca.setFocusable(false);
		textoAltaMarca.setBackground(Color.orange);
		textoAltaMarca.setForeground(Color.white);
		textoAltaMarca.setFont(new Font("Consolas", 4, 100));
		this.getContentPane().add(textoAltaMarca, BorderLayout.NORTH);
		
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(3, 2, 0, 10));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

		textoCifMarca.setEditable(false);
		textoCifMarca.setText("CIF ControladorMarca");
		textoCifMarca.setForeground(Color.orange);
		textoCifMarca.setFocusable(false);
		textoCifMarca.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoCifMarca);

		campoCifMarca.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoCifMarca);

		textoNombre.setEditable(false);
		textoNombre.setText("Nombre");
		textoNombre.setForeground(Color.orange);
		textoNombre.setFocusable(false);
		textoNombre.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoNombre);

		campoNombre.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoNombre);

		textoPais.setEditable(false);
		textoPais.setText("Pais");
		textoPais.setForeground(Color.orange);
		textoPais.setFocusable(false);
		textoPais.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoPais);

		campoPais.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoPais);

		botonGuardar.setText("Guardar");
		botonGuardar.setFont(new Font("Consolas", 4, 80));
		botonGuardar.setForeground(Color.orange);
		botonGuardar.setContentAreaFilled(false);
		botonGuardar.addActionListener(new ActionListener() {
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
		botonCancelar.addActionListener(new ActionListener() {
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
		String[] datos = { campoCifMarca.getText(), campoNombre.getText(), campoPais.getText() };
		String inf = controlador.alta("ControladorMarca", datos);
		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Se ha podido añadir a la base de datos ", "Exito",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalMarca(controlador);
		this.dispose();
	}

}
