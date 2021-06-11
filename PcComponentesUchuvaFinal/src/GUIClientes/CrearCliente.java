package GUIClientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Model.Observer;
import main.Mediator;

public class CrearCliente extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panelDatos;
	private JPanel panelMostrar;

	private JTextArea textoAltaCliente;
	private JTextArea textoNombre;
	private JTextField campoNombre;

	private JTextArea textoDNI;
	private JTextField campoDNI;

	private JTextArea textoTelefono;
	private JTextField campoTelefono;

	private JButton botonGuardar;
	private JButton botonCancelar;

	private Mediator mediator;

	public CrearCliente(Mediator mediator) {
		super("PCComponentes Uchuva");
		this.mediator = mediator;
		initComponents();
	}

	private void initComponents() {
		// inicializar objetos
		panel = new JPanel();
		panelDatos = new JPanel();
		panelMostrar = new JPanel();

		textoAltaCliente = new JTextArea();

		textoDNI = new JTextArea();
		campoDNI = new JTextField();

		textoNombre = new JTextArea();
		campoNombre = new JTextField();

		textoTelefono = new JTextArea();
		campoTelefono = new JTextField();

		botonGuardar = new JButton();
		botonCancelar = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1250, 720));

		textoAltaCliente.setEditable(false);
		textoAltaCliente.setText("Alta ControllerCliente");
		textoAltaCliente.setBackground(Color.lightGray);
		textoAltaCliente.setForeground(Color.white);
		textoAltaCliente.setFocusable(false);
		textoAltaCliente.setFont(new Font("Consolas", 2, 100));
		this.getContentPane().add(textoAltaCliente, BorderLayout.NORTH);

		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(3, 1, 0, 10));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

		textoDNI.setEditable(false);
		textoDNI.setText("DNI");
		textoDNI.setForeground(Color.lightGray);
		textoDNI.setFocusable(false);
		textoDNI.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoDNI);

		campoDNI.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoDNI);

		textoNombre.setEditable(false);
		textoNombre.setText("Nombre");
		textoNombre.setForeground(Color.lightGray);
		textoNombre.setFocusable(false);
		textoNombre.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoNombre);

		campoNombre.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoNombre);

		textoTelefono.setEditable(false);
		textoTelefono.setText("Telefono");
		textoTelefono.setForeground(Color.lightGray);
		textoTelefono.setFocusable(false);
		textoTelefono.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoTelefono);

		campoTelefono.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoTelefono);

		botonGuardar.setText("Guardar");
		botonGuardar.setFont(new Font("Consolas", 4, 80));
		botonGuardar.setForeground(Color.lightGray);
		botonGuardar.setContentAreaFilled(false);
		botonGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonCrearActionPerformed(evt);
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

	private void botonCrearActionPerformed(ActionEvent evt) {
		String[] datos = { campoDNI.getText(), campoNombre.getText(), campoTelefono.getText() };
		String inf = mediator.alta("ControllerCliente", datos);

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Se ha podido añadir a la base de datos ", "Exito",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalClientes(mediator);
		this.dispose();
	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		
	}

}
