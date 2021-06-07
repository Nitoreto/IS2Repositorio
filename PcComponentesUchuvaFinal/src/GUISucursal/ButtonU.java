package GUISucursal;

import java.awt.Dimension;

import javax.swing.JButton;

public class ButtonU extends JButton{
	public ButtonU(String s) {
		super(s);
		initGUI();
	}
	public void initGUI() {
		this.setPreferredSize(new Dimension(120,30));
		this.setSize(new Dimension(120,30));
//		this.setBounds(20, 60,115, 30);
	}

}
