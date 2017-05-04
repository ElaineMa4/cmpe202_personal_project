import java.util.*;

public class MyClass {
	
	private String extendsFrom;
	private List<String> implementFrom;
	private ArrayList<MyVariable> variables;
	
	public MyClass() {
		this.setExtendsFrom("");
		this.setImplementFrom(new ArrayList<>());
//		this.setVariables(new ArrayList<>());
	}

	public String getExtendsFrom() {
		return extendsFrom;
	}

	public void setExtendsFrom(String extendsFrom) {
		this.extendsFrom = extendsFrom;
	}

	public List<String> getImplementFrom() {
		return implementFrom;
	}

	public void setImplementFrom(List<String> implementFrom) {
		this.implementFrom = implementFrom;
	}

	public ArrayList<MyVariable> getVariables() {
		return variables;
	}

	public void setVariables(ArrayList<MyVariable> variables) {
		this.variables = variables;
	}
	
}