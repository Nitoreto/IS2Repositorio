package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GUIVenta.PantallaPrincipalVentas;
import Model.Observer;
import main.Mediator;

public class AltaSucursalDec extends JFrame implements Observer{
	BorderDecorator mainPanel;
	Mediator m;
	public AltaSucursalDec(Mediator m) {
		this.m = m;
		initComponentes();
		
		m.asignarObserver(this);
	}
	public void initComponentes() {
		backGroundDecorator backGround = new backGroundDecorator();
		backGround.setLayout(new BorderLayout());
		mainPanel = new BorderDecorator();
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backGround.add(mainPanel, BorderLayout.CENTER);
		this.setContentPane(backGround);
		mainPanel.addTopLabel("Alta de sucursal");
		
		mainPanel.addJtext("Telefono");
		mainPanel.addJtext("Ciudad");
		mainPanel.addJtext("ID");
		JButton altaButton = new JButton();
		altaButton.setText("alta");
		altaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonAltaActionPerformed();
			}
		});
		mainPanel.addCp(altaButton);
		JButton volverButton = new JButton();
		volverButton.setText("volver");
		volverButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed();
			}
		});
		mainPanel.addCp(volverButton);
		
		mainPanel.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.setAlignmentY(CENTER_ALIGNMENT);
		this.setVisible(true);
	}

	
	
	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
		int input = JOptionPane.showConfirmDialog(null, 
                "Se ha realizado la operacion correctamente", msg,JOptionPane.DEFAULT_OPTION);
	}
	
	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL INSERTAR", JOptionPane.ERROR_MESSAGE);
		
	}
	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		
	}
	public void botonCancelarActionPerformed() {
		new PantallaPrincipalSucursal(m);
		this.dispose();
	}
	public void botonAltaActionPerformed() {
		ArrayList<String> datos = mainPanel.getData();
		datos.add("1");
		String[] arr = new String[datos.size()];
	    arr = datos.toArray(arr);
		m.alta("ControllerSucursal", arr);
	}
}
