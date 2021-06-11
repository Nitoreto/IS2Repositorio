package GUISucursal;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Observer;
import main.Mediator;

public class BajaSucursalDec extends JFrame implements Observer{
	public BajaSucursalDec(Mediator m) {
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