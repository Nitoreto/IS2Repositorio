package GUISucursal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Observer;
import main.Mediator;

public class BajaSucursalDec extends JFrame implements Observer{
	Mediator m;
	public BajaSucursalDec(Mediator m) {
		this.m = m;
		initComponentes();
		m.asignarObserver(this);
	}

	private void initComponentes() {
		backGroundDecorator backGround = new backGroundDecorator();
		backGround.setLayout(new BorderLayout());
		BorderDecorator mainPanel = new BorderDecorator();
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backGround.add(mainPanel, BorderLayout.CENTER);
		this.setContentPane(backGround);
		
		mainPanel.addTopLabel("Baja de sucursal");
		mainPanel.addCp(new ButtonU("Dar De Baja"));
		mainPanel.addJtext("ID");

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
		int input = JOptionPane.showConfirmDialog(null, 
                "No se ha podido realizar la operacion correctamente", msg,JOptionPane.DEFAULT_OPTION);
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		
	}
	public void botonCancelarActionPerformed() {
		new PantallaPrincipalSucursal(m);
		this.dispose();
	}

}
