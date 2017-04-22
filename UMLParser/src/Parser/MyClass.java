package Parser;
import java.util.*;



public class MyClass {
	
	private String extendsFrom;
	private List<String> implementFrom;
	
	public MyClass() {
		this.setExtendsFrom("");
		this.setImplementFrom(new ArrayList<>());
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
	
}
