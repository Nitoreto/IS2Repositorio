package factoria;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {
	static final long serialVersionUID = 1L;
	Object[][] objeto;
	String[] texto;
	public ModeloTabla( Object[][] objeto, String[] texto) {
		this.texto = texto;
		this.objeto = objeto;
	}

	@Override
	public int getColumnCount() {
		return objeto[0].length;
	}

	@Override
	public int getRowCount() {
		return objeto.length;

	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return objeto[arg0][arg1];

	}

	@Override
	public String getColumnName(int c) {
		return texto[c];
	}
}
