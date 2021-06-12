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

import Model.Observer;
import main.Mediator;

public class AltaMarca extends JFrame implements Observer{
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
	private Mediator mediator;

	public AltaMarca(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.mediator = controlador;
		mediator.asignarObserver(this);
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
		textoAltaMarca.setText("Alta Marca");
		textoAltaMarca.setFocusable(false);
		textoAltaMarca.setBackground(Color.orange);
		textoAltaMarca.setForeground(Color.white);
		textoAltaMarca.setFont(new Font("Consolas", 4, 100));
		this.getContentPane().add(textoAltaMarca, BorderLayout.NORTH);
		
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(3, 2, 0, 10));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

		textoCifMarca.setEditable(false);
		textoCifMarca.setText("CIF Marca");
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
		String[] datos = { campoCifMarca.getText(), campoNombre.getText(), campoPais.getText(),"1" };
		mediator.alta("ControllerMarca", datos);

	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalMarca(mediator);
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
