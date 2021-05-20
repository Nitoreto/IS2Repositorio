package factoria;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class ModeloTablaEditable extends DefaultTableModel {
	static final long serialVersionUID = 1L;
	private boolean modificado;
	public ModeloTablaEditable( Object[][] objeto, String[] texto) {
		super(objeto, texto);
		modificado = false;
		this.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent evento) {
				actualizaCelda(evento);
			}
		});
	}

	protected void actualizaCelda(TableModelEvent evento) {
		if (evento.getType() == TableModelEvent.UPDATE && !modificado) {
			int fila = evento.getFirstRow();
			int columna = evento.getColumn();
			modificado=true;
			this.setValueAt(this.getValueAt(fila, columna), fila, columna);
			//this.fireTableCellUpdated(fila, columna);
		}else {
			modificado=false;
			return;
		}
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return true;

	}
}
