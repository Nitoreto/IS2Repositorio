package GUISucursal;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.ModeloTablaEditable;

public class listarEmpleadoSucursal extends JFrame{
	
	private ModeloTablaEditable model;
	private JTable _eventsTable;
	
	public listarEmpleadoSucursal(Object[][] objeto, String[] texto) {
		initComponentes(objeto, texto);
	}

	private void initComponentes(Object[][] objeto, String[] texto) {
		backGroundDecorator backGround = new backGroundDecorator();
		backGround.setLayout(new BorderLayout());
		BorderDecorator mainPanel = new BorderDecorator();
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backGround.add(mainPanel, BorderLayout.CENTER);
		this.setContentPane(backGround);
		model = new ModeloTablaEditable(objeto, texto);
		_eventsTable = new JTable(model);
		_eventsTable.setOpaque(false);
		mainPanel.add(new JScrollPane(_eventsTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		mainPanel.addTopLabel("Listar empleados por sucursal");
		mainPanel.addJtext("Id");
		mainPanel.addCp(new ButtonU("Buscar"));
		
		mainPanel.addCp(new ButtonU("Volver"));
		mainPanel.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.setAlignmentY(CENTER_ALIGNMENT);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		Object object[][] = new String[2][2] ;
		String str[] = new String[3];

		listarEmpleadoSucursal t1 = new listarEmpleadoSucursal(object, str);
		
	}

}
