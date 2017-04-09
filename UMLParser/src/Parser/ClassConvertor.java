package Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
/**
 * Convert classes into strings
 * @author Xiaoqian Ma
 *
 */
public class ClassConvertor {
	public ClassConvertor() {
		
	}
	
	/**
	 * read class file and turn it into string
	 * @param path
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public String readFile(String path) throws ParseException, IOException {
		File file = new File(path);
		CompilationUnit compilationUnit;
		String result = "";
		try {
			compilationUnit = JavaParser.parse(file);
			result = compilationUnit.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
	}
}
