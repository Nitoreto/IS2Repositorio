package GUISucursal;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class BajaSucursalDec extends JFrame{
	public BajaSucursalDec() {
		initComponentes();
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
	 public static void main(String[] args) {

			BajaSucursalDec t1 = new BajaSucursalDec();
			
		}

}
