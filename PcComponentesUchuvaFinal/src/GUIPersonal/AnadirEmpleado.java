package GUIPersonal;

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

import Model.Observer;
import main.Mediator;

public class AnadirEmpleado extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panelDatos;
	private JPanel panelMostrar;
	private JTextArea textoAltaEmpleado;
	private JTextArea textoDNIEmpleado;
	private JTextField campoDNIEmpleado;
	private JTextArea textoNombre;
	private JTextField campoNombre;
	private JTextArea textoApellido;
	private JTextField campoApellido;
	private JTextArea textoDireccion;
	private JTextField campoDireccion;
	private JTextArea textoTelefono;
	private JTextField campoTelefono;
	private JTextArea textoId_Empleado;
	private JTextField campoId_Empleado;
	private JButton botonGuardar;
	private JButton botonCancelar;
	private Mediator mediator;

	public AnadirEmpleado(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.mediator = controlador;
		initComponents();
	}

	private void initComponents() {
		panelDatos = new JPanel();
		panelMostrar = new JPanel();
		panel = new JPanel();

		textoAltaEmpleado = new JTextArea();

		textoDNIEmpleado = new JTextArea();
		campoDNIEmpleado = new JTextField();

		textoNombre = new JTextArea();
		campoNombre = new JTextField();

		textoApellido = new JTextArea();
		campoApellido = new JTextField();

		textoDireccion = new JTextArea();
		campoDireccion = new JTextField();

		textoTelefono = new JTextArea();
		campoTelefono = new JTextField();

		textoId_Empleado = new JTextArea();
		campoId_Empleado = new JTextField();

		botonGuardar = new JButton();
		botonCancelar = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1750, 650));

		textoAltaEmpleado.setEditable(false);
		textoAltaEmpleado.setText("Alta ControllerEmpleado");
		textoAltaEmpleado.setBackground(Color.cyan);
		textoAltaEmpleado.setForeground(Color.white);
		textoAltaEmpleado.setFocusable(false);
		textoAltaEmpleado.setFont(new Font("Consolas", 2, 100));
		this.getContentPane().add(textoAltaEmpleado, BorderLayout.NORTH);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(3, 2, 0, 15));

		textoId_Empleado.setEditable(false);
		textoId_Empleado.setText("ID");
		textoId_Empleado.setForeground(Color.cyan);
		textoId_Empleado.setFocusable(false);
		textoId_Empleado.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoId_Empleado);

		campoId_Empleado.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoId_Empleado);

		textoNombre.setEditable(false);
		textoNombre.setText("Nombre");
		textoNombre.setForeground(Color.cyan);
		textoNombre.setFocusable(false);
		textoNombre.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoNombre);

		campoNombre.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoNombre);

		textoApellido.setEditable(false);
		textoApellido.setText("Apellidos");
		textoApellido.setForeground(Color.cyan);
		textoApellido.setFocusable(false);
		textoApellido.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoApellido);

		campoApellido.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoApellido);

		textoDNIEmpleado.setEditable(false);
		textoDNIEmpleado.setText("DNI");
		textoDNIEmpleado.setForeground(Color.cyan);
		textoDNIEmpleado.setFocusable(false);
		textoDNIEmpleado.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoDNIEmpleado);

		campoDNIEmpleado.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoDNIEmpleado);

		textoDireccion.setEditable(false);
		textoDireccion.setText("Direccion");
		textoDireccion.setForeground(Color.cyan);
		textoDireccion.setFocusable(false);
		textoDireccion.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoDireccion);

		campoDireccion.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoDireccion);

		textoTelefono.setEditable(false);
		textoTelefono.setText("Telefono");
		textoTelefono.setForeground(Color.cyan);
		textoTelefono.setFocusable(false);
		textoTelefono.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoTelefono);

		campoTelefono.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoTelefono);

		botonGuardar.setText("Guardar");
		botonGuardar.setFont(new Font("Consolas", 4, 80));
		botonGuardar.setForeground(Color.cyan);
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
		String[] datos = { campoId_Empleado.getText(), campoNombre.getText(), campoApellido.getText(),
				campoDNIEmpleado.getText(), campoDireccion.getText(), campoTelefono.getText(), };
		mediator.alta("ControllerEmpleado", datos);

	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalEmpleado(mediator);
		this.dispose();
	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Se ha podido a�adir a la base de datos ", "Exito",
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		
	}

}
