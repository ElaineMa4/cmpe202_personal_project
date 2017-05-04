import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.type.Type;

public class MyVariable {
	private String modifier;
	private String type;
	private String name;
	
	public MyVariable(String mod, String type2, String simpleName ){
		this.setModifier(mod);
		this.setType(type2);
		this.setName(simpleName);

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

}
