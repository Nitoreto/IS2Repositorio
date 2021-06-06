package GUISucursal;

import java.awt.BorderLayout;

import javax.naming.InitialContext;
import javax.swing.JPanel;

public class BorderDecorator extends JPanel{
	public BorderDecorator() {
		initGUI();
	}
	public void initGUI() {
		this.setLayout(new BorderLayout());
		
		add(comp);
	}

}
