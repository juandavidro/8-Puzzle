package search.qsearch;

public class Celular {
	private String model;
	private int capacity;
	
	public Celular(String _model, int _capacity) {
		this.model = _model;
		this.capacity = _capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public int hashCode() {
		
		return capacity;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this.getModel().equals(((Celular) obj).getModel()) && this.getCapacity() == ((Celular) obj).getCapacity()) {
			return true;
		}
		return false;
	}
}
