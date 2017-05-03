

public class MyVariable {
	private String modifier;
	private String type;
	private String name;
	private boolean isStatic;
	
	public MyVariable(){
		this.setModifier("");
		this.setType("");
		this.setName("");
		this.setStatic(false);
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}
	

}
