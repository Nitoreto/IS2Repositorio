package GUIClientes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import main.Mediator;
import main.PantallaPrincipalPccomponentes;

public class PantallaPrincipalClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextArea textoClientes;
	private JButton botonCrear;
	private JButton botonEliminar;
	private JButton botonListarClientes;
	private JButton botonMostrar;
	private JButton botonVolver;
	private Mediator mediator;

	public PantallaPrincipalClientes(Mediator meditaor) {
		super("PCComponentes Uchuva");
		this.mediator = meditaor;
		initComponents();
	}

	private void initComponents() {
		panel = new JPanel();
		textoClientes = new JTextArea();
		botonCrear = new JButton();
		botonEliminar = new JButton();
		botonListarClientes = new JButton();
		botonMostrar = new JButton();
		botonVolver = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(900, 720));
		panel.setFocusable(false);
		panel.setOpaque(false);
		panel.setLayout(new GridLayout(6, 1));
		panel.add(textoClientes);
		
		textoClientes.setEditable(false);
		textoClientes.setText("Clientes");
		textoClientes.setBackground(Color.lightGray);
		textoClientes.setForeground(Color.WHITE);
		textoClientes.setFocusable(false);
		textoClientes.setFont(new Font("Consolas", 2, 90));
		textoClientes.setBounds(400, 200, 200, 400);
		panel.add(textoClientes);

		botonCrear.setText("Alta");
		botonCrear.setFont(new Font("Consolas", 4, 80));
		botonCrear.setBackground(Color.white);
		botonCrear.setForeground(Color.lightGray);
		botonCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonCrearActionPerformed(evt);
			}
		});
		panel.add(botonCrear);

		botonEliminar.setText("Baja");
		botonEliminar.setFont(new Font("Consolas", 4, 80));
		botonEliminar.setBackground(Color.white);
		botonEliminar.setForeground(Color.lightGray);
		botonEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonEliminarActionPerformed(evt);
			}
		});
		panel.add(botonEliminar);
		
		botonMostrar.setText("Buscar");
		botonMostrar.setFont(new Font("Consolas", 4, 80));
		botonMostrar.setBackground(Color.white);
		botonMostrar.setForeground(Color.lightGray);
		botonMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonMostrarActionPerformed(evt);
			}
		});
		panel.add(botonMostrar);

		botonListarClientes.setText("Listar");
		botonListarClientes.setFont(new Font("Consolas", 4, 80));
		botonListarClientes.setBackground(Color.white);
		botonListarClientes.setForeground(Color.lightGray);
		botonListarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonListarClientesActionPerformed(evt);
			}
		});
		panel.add(botonListarClientes);
		
		botonVolver.setText("Volver");
		botonVolver.setFont(new Font("Consolas", 4, 80));
		botonVolver.setBackground(Color.white);
		botonVolver.setForeground(Color.red);
		botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonVolverActionPerformed(evt);
			}
		});
		panel.add(botonVolver);

		this.getContentPane().add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
	protected void botonVolverActionPerformed(ActionEvent evt) {
		new PantallaPrincipalPccomponentes(mediator);
		this.dispose();

	}

	private void botonListarClientesActionPerformed(ActionEvent evt) {
		new ListarClientes(mediator);
		this.dispose();

	}

	private void botonCrearActionPerformed(ActionEvent evt) {
		new CrearCliente(mediator);
		this.dispose();
	}

	private void botonEliminarActionPerformed(ActionEvent evt) {
		new EliminarCliente(mediator);
		this.dispose();
	}

	private void botonMostrarActionPerformed(ActionEvent evt) {
		new BuscarCliente(mediator);
		this.dispose();
	}

}
