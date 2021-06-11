package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AltaSucursalDec extends JFrame{
	
	public AltaSucursalDec() {
		initComponentes();
	}
	public void initComponentes() {
		backGroundDecorator backGround = new backGroundDecorator();
		backGround.setLayout(new BorderLayout());
		BorderDecorator mainPanel = new BorderDecorator();
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backGround.add(mainPanel, BorderLayout.CENTER);
		this.setContentPane(backGround);
		mainPanel.addTopLabel("Alta de sucursal");
		mainPanel.addCp(new ButtonU("Dar De Alta"));
		mainPanel.addJtext("Nombre");
		mainPanel.addJtext("Ciudad");
		mainPanel.addJtext("ID");
		mainPanel.addCp(new ButtonU("Volver"));
		mainPanel.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.setAlignmentY(CENTER_ALIGNMENT);
		this.setVisible(true);
	}

	 public static void main(String[] args) {

			AltaSucursalDec t1 = new AltaSucursalDec();
			

		}
}
