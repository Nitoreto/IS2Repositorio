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

import Model.Observer;
import main.Mediator;

public class RegistrarVenta extends JFrame implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelDatos;
	private JPanel panelMostrar;
	private JPanel panel;

	private JTextArea textoVenta;
	private JButton botonGuardar;
	private JButton botonCancelar;

	private JTextArea textoDNICliente;
	private JTextField textoCampoDNICliente;

	private JTextArea textoIdEmpleado;
	private JTextField textoCampoIdEmpleado;

	private JTextArea textoPrecioTotal;
	private JTextField textoCampoPrecioTotal;

	private JTextArea textoListaProducos;
	private JTextField textoCampoListaProductos;
	private Mediator mediator;

	public RegistrarVenta(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.mediator = controlador;
		initComponentes();
	}

	private void initComponentes() {
		panelDatos = new JPanel();
		panelMostrar = new JPanel();
		panel = new JPanel();
		textoVenta = new JTextArea();
		botonGuardar = new JButton();
		botonCancelar = new JButton();
		textoDNICliente = new JTextArea();
		textoCampoDNICliente = new JTextField();
		textoListaProducos = new JTextArea();
		textoCampoListaProductos = new JTextField();
		textoCampoIdEmpleado = new JTextField();
		textoIdEmpleado = new JTextArea();
		textoPrecioTotal = new JTextArea();
		textoCampoPrecioTotal = new JTextField();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1750, 800));

		textoVenta.setEditable(false);
		textoVenta.setText("Registrar ControllerVenta");
		textoVenta.setBackground(Color.green);
		textoVenta.setForeground(Color.white);
		textoVenta.setFocusable(false);
		textoVenta.setFont(new Font("Consolas", 2, 100));
		this.getContentPane().add(textoVenta, BorderLayout.NORTH);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(4, 1, 0, 15));

		textoDNICliente.setText("DNI ControllerCliente");
		textoDNICliente.setFont(new Font("Consolas", 4, 80));
		textoDNICliente.setForeground(Color.green);
		textoDNICliente.setEditable(false);
		textoDNICliente.setFocusable(false);

		panelDatos.add(textoDNICliente);

		textoCampoDNICliente.setFont(new Font("Consolas", 4, 80));

		panelDatos.add(textoCampoDNICliente);

		textoIdEmpleado.setText("ID ControllerEmpleado");
		textoIdEmpleado.setFont(new Font("Consolas", 4, 80));
		textoIdEmpleado.setForeground(Color.green);
		textoIdEmpleado.setEditable(false);
		textoIdEmpleado.setFocusable(false);

		panelDatos.add(textoIdEmpleado);

		textoCampoIdEmpleado.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoCampoIdEmpleado);

		textoListaProducos.setText("Lista de Productos");
		textoListaProducos.setFont(new Font("Consolas", 4, 80));
		textoListaProducos.setForeground(Color.green);
		textoListaProducos.setEditable(false);
		textoListaProducos.setFocusable(false);

		panelDatos.add(textoListaProducos);

		textoCampoListaProductos.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoCampoListaProductos);

		textoPrecioTotal.setText("Precio total");
		textoPrecioTotal.setFont(new Font("Consolas", 4, 80));
		textoPrecioTotal.setForeground(Color.green);
		textoPrecioTotal.setEditable(false);
		textoPrecioTotal.setFocusable(false);

		panelDatos.add(textoPrecioTotal);

		textoCampoPrecioTotal.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoCampoPrecioTotal);

		botonGuardar.setText("Guardar");
		botonGuardar.setFont(new Font("Consolas", 4, 80));
		botonGuardar.setForeground(Color.green);
		botonGuardar.setContentAreaFilled(false);
		botonGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
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
			public void actionPerformed(java.awt.event.ActionEvent evt) {
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
		String[] datos = { "rand", textoCampoDNICliente.getText(), textoCampoIdEmpleado.getText(),
				textoCampoListaProductos.getText(), textoCampoPrecioTotal.getText() };
		mediator.alta("ControllerVenta", datos);
		new PantallaPrincipalVentas(mediator);
		this.dispose();
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalVentas(mediator);
		this.dispose();
	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Se ha podido añadir a la base de datos ", "Exito",
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ID no encontrado", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		
	}

}
