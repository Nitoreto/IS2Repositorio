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

import Model.Observer;
import main.Mediator;

public class AltaProducto extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panelDatos;
	private JPanel panelMostrar;

	private JTextArea textoAltaProducto;

	private JTextArea textoID;
	private JTextField campoID;
	
	private JTextArea textoIdSucursal;
	private JTextField campoIdSucursal;

	private JTextArea textoPrecio;
	private JTextField campoPrecio;

	private JTextArea textoNombre;
	private JTextField campoNombre;
	
	private JTextArea textoCifMarca;
	private JTextField campoCifMarca;

	private JTextArea textoDescripcion;
	private JTextField campoDescripcion;

	private JButton botonGuardar;
	private JButton botonCancelar;
	private Mediator mediator;

	public AltaProducto(Mediator mediator) {
		super("PCComponentes Uchuva");
		this.mediator = mediator;
		mediator.asignarObserver(this);
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
		
		textoCifMarca = new JTextArea();
		campoCifMarca = new JTextField();

		textoDescripcion = new JTextArea();
		campoDescripcion = new JTextField();
		
		textoIdSucursal = new JTextArea();
		campoIdSucursal = new JTextField();

		botonGuardar = new JButton();
		botonCancelar = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1250, 1000));

		textoAltaProducto.setEditable(false);
		textoAltaProducto.setText("Alta Producto");
		textoAltaProducto.setBackground(Color.pink);
		textoAltaProducto.setForeground(Color.white);
		textoAltaProducto.setFocusable(false);
		textoAltaProducto.setFont(new Font("Consolas", 4, 100));
		this.getContentPane().add(textoAltaProducto, BorderLayout.NORTH);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(7, 1, 0, 15));

		textoID.setEditable(false);
		textoID.setText("ID Producto");
		textoID.setForeground(Color.pink);
		textoID.setFocusable(false);
		textoID.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoID);

		campoID.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoID);

		textoNombre.setEditable(false);
		textoNombre.setText("Nombre Producto");
		textoNombre.setForeground(Color.pink);
		textoNombre.setFocusable(false);
		textoNombre.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoNombre);

		campoNombre.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoNombre);
		
		textoIdSucursal.setEditable(false);
		textoIdSucursal.setText("Id Sucursal");
		textoIdSucursal.setForeground(Color.pink);
		textoIdSucursal.setFocusable(false);
		textoIdSucursal.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoIdSucursal);

		campoIdSucursal.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoIdSucursal);
		
		textoCifMarca.setEditable(false);
		textoCifMarca.setText("Cif Marca");
		textoCifMarca.setForeground(Color.pink);
		textoCifMarca.setFocusable(false);
		textoCifMarca.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoCifMarca);

		campoCifMarca.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoCifMarca);

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
		String[] Datos = { campoID.getText(), campoNombre.getText(), campoCifMarca.getText(),
				campoDescripcion.getText(), campoPrecio.getText(), campoIdSucursal.getText(), "1"};
		mediator.alta("ControllerProducto", Datos);
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalProducto(mediator);
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
