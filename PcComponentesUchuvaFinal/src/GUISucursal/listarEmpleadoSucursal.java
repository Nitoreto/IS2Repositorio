package GUISucursal;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.ModeloTablaEditable;
import Model.Observer;
import main.Mediator;

public class listarEmpleadoSucursal extends JFrame implements Observer{
	
	private ModeloTablaEditable model;
	private JTable _eventsTable;
	BorderDecorator mainPanel;
	public listarEmpleadoSucursal(Mediator m) {
		backGroundDecorator backGround = new backGroundDecorator();
		backGround.setLayout(new BorderLayout());
		mainPanel = new BorderDecorator();
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backGround.add(mainPanel, BorderLayout.CENTER);
		this.setContentPane(backGround);
		
		m.asignarObserver(this);
	}

	private void initComponentes(Object[][] objeto, String[] texto) {
		
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
		initComponentes(generarTabla, generarTitulo);
		
	}

}
