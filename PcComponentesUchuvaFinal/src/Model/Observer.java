package Model;

public interface Observer {
	public void onCorrectMessage(String msg);

	public void onIncorrectMessage(String msg);
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo);

}
