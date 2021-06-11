package GUISucursal;

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

import GUIVenta.ModificarVenta;
import GUIVenta.MostrarHistorialClientes;
import GUIVenta.MostrarVenta;
import GUIVenta.RegistrarVenta;
import main.Mediator;
import main.PantallaPrincipalPccomponentes;

public class PantallaPrincipalSucursal extends JFrame{
	
	private JPanel panel;
	private JTextArea textoSucursal;
	private JButton botonListarSucursales;
	private JButton botonAltaSucursal;
	private JButton botonListarEmpleadoSucursal;
	private JButton botonModificarSucursal;
	private JButton botonVolver;
	
	private Mediator mediator;
	public PantallaPrincipalSucursal(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.mediator = controlador;
		initComponentes();
	}
	private void initComponentes() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		panel = new JPanel();
		textoSucursal = new JTextArea();
		botonListarSucursales = new JButton();
		botonAltaSucursal = new JButton();
		botonListarEmpleadoSucursal = new JButton();
		botonModificarSucursal = new JButton();
		botonVolver = new JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(900, 720));
		panel.setFocusable(false);
		panel.setLayout(new GridLayout(6, 1));

		textoSucursal.setEditable(false);
		textoSucursal.setText("Sucursales");
		textoSucursal.setBackground(Color.green);
		textoSucursal.setForeground(Color.WHITE);
		textoSucursal.setFocusable(false);
		textoSucursal.setFont(new Font("Consolas", 2, 90));
		textoSucursal.setBounds(400, 200, 200, 400);
		panel.add(textoSucursal);

		botonListarSucursales.setText("Listar Sucursales");
		botonListarSucursales.setFont(new Font("Consolas", 4, 80));
		botonListarSucursales.setBackground(Color.white);
		botonListarSucursales.setForeground(Color.green);
		botonListarSucursales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonListarSucursalesActionPerformed(evt);
			}
		});
		panel.add(botonListarSucursales);
		
		botonModificarSucursal.setText("Modificar Sucursal");
		botonModificarSucursal.setFont(new Font("Consolas", 4, 80));
		botonModificarSucursal.setBackground(Color.white);
		botonModificarSucursal.setForeground(Color.green);
		botonModificarSucursal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonModificarSucursalActionPerformed(evt);
			}
		});
		panel.add(botonModificarSucursal);

		botonListarEmpleadoSucursal.setText("Listar empleados de la sucursal");
		botonListarEmpleadoSucursal.setFont(new Font("Consolas", 4, 80));
		botonListarEmpleadoSucursal.setBackground(Color.white);
		botonListarEmpleadoSucursal.setForeground(Color.green);
		botonListarEmpleadoSucursal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonListarActionPerformed(evt);
			}
		});
		panel.add(botonListarEmpleadoSucursal);

		botonAltaSucursal.setText("Registrar Sucursal");
		botonAltaSucursal.setFont(new Font("Consolas", 4, 80));
		botonAltaSucursal.setBackground(Color.white);
		botonAltaSucursal.setForeground(Color.green);
		botonAltaSucursal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonAltaActionPerformed(evt);
			}
		});
		panel.add(botonAltaSucursal);


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

	private void botonListarSucursalesActionPerformed(ActionEvent evt) {
		new ListarSucursales(mediator);
		this.dispose();
	}

	private void botonAltaActionPerformed(ActionEvent evt) {
		new AltaSucursalDec(mediator);
		this.dispose();
	}

	private void botonListarActionPerformed(ActionEvent evt) {
		new listarEmpleadoSucursal(mediator);
		this.dispose();
	}

	private void botonModificarSucursalActionPerformed(ActionEvent evt) {
		new ModificarSucursalDec(mediator);
		this.dispose();

	}


}
