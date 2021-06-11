package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

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
		initComponentes();
		this.m = m;
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
		mainPanel.addCp(new ButtonU("Dar De Alta"));
		mainPanel.addJtext("Telefono");
		mainPanel.addJtext("Ciudad");
		mainPanel.addJtext("ID");
		mainPanel.addCp(new ButtonU("Volver"));
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
	private void botonGuardarActionPerformed(ActionEvent evt) {
		String[] datos = mainPanel.getData();
		m.alta("ControllerVenta", datos);
		new PantallaPrincipalVentas(m);
		this.dispose();
	}
	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		int input = JOptionPane.showConfirmDialog(null, 
                "No se ha podido realizar la operacion correctamente", msg,JOptionPane.DEFAULT_OPTION);
		
	}
	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		
	}
}
