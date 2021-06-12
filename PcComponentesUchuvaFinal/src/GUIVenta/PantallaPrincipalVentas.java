package GUIVenta;

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

import Model.Observer;
import main.Mediator;
import main.PantallaPrincipalPccomponentes;


public class PantallaPrincipalVentas extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextArea textoVenta;
	private JButton botonListarVentas;
	private JButton botonRegistrarVenta;
	private JButton botonMostrarVenta;
	private JButton botonModificarVenta;
	private JButton botonVolver;
	private Mediator mediator;

	public PantallaPrincipalVentas(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.mediator = controlador;
		initComponentes();
	}

	private void initComponentes() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		panel = new JPanel();
		textoVenta = new JTextArea();
		botonListarVentas = new JButton();
		botonRegistrarVenta = new JButton();
		botonMostrarVenta = new JButton();
		botonModificarVenta = new JButton();
		botonVolver = new JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(900, 720));
		panel.setFocusable(false);
		panel.setLayout(new GridLayout(6, 1));

		textoVenta.setEditable(false);
		textoVenta.setText("Ventas");
		textoVenta.setBackground(Color.green);
		textoVenta.setForeground(Color.WHITE);
		textoVenta.setFocusable(false);
		textoVenta.setFont(new Font("Consolas", 2, 90));
		textoVenta.setBounds(400, 200, 200, 400);
		panel.add(textoVenta);

		botonListarVentas.setText("Listar Ventas");
		botonListarVentas.setFont(new Font("Consolas", 4, 80));
		botonListarVentas.setBackground(Color.white);
		botonListarVentas.setForeground(Color.green);
		botonListarVentas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonListarVentasActionPerformed(evt);
			}
		});
		panel.add(botonListarVentas);
		
		botonModificarVenta.setText("Modificar Venta");
		botonModificarVenta.setFont(new Font("Consolas", 4, 80));
		botonModificarVenta.setBackground(Color.white);
		botonModificarVenta.setForeground(Color.green);
		botonModificarVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonModificarVentasActionPerformed(evt);
			}
		});
		panel.add(botonModificarVenta);

		botonMostrarVenta.setText("Mostrar Venta");
		botonMostrarVenta.setFont(new Font("Consolas", 4, 80));
		botonMostrarVenta.setBackground(Color.white);
		botonMostrarVenta.setForeground(Color.green);
		botonMostrarVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonMostrarVentasActionPerformed(evt);
			}
		});
		panel.add(botonMostrarVenta);

		botonRegistrarVenta.setText("Registrar Venta");
		botonRegistrarVenta.setFont(new Font("Consolas", 4, 80));
		botonRegistrarVenta.setBackground(Color.white);
		botonRegistrarVenta.setForeground(Color.green);
		botonRegistrarVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonRegistrarVentaActionPerformed(evt);
			}
		});
		panel.add(botonRegistrarVenta);


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

	private void botonVolverActionPerformed(ActionEvent evt) {
		new PantallaPrincipalPccomponentes(mediator);
		this.dispose();
		
	}

	private void botonListarVentasActionPerformed(ActionEvent evt) {
		new MostrarHistorialClientes(mediator);
		this.dispose();
	}

	private void botonRegistrarVentaActionPerformed(ActionEvent evt) {
		new RegistrarVenta(mediator);
		this.dispose();
	}

	private void botonMostrarVentasActionPerformed(ActionEvent evt) {
		new MostrarVenta(mediator);
		this.dispose();
	}

	private void botonModificarVentasActionPerformed(ActionEvent evt) {
		new ModificarVenta(mediator);
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
