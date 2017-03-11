package Parser;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import uml_parser_test1.A;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;



public class Test1 {
    public static void main(String[] args) throws Exception {

        File[] fileList = getFileList("C:\\Users\\Ma\\workspace\\UMLParser\\src\\uml_parser_test1");
        //A a = new A();
        for(File file : fileList) {
            System.out.println(file.getName());
            //System.out.println(getFile(file.getName()));
            CompilationUnit compilationUnit = JavaParser.parse(file);
            System.out.println(compilationUnit.toString());
        	//Optional<ClassOrInterfaceDeclaration> classA = compilationUnit.getClassByName(compilationUnit);
        }
        //Test1 obj = new Test1();
    	System.out.println();
    	
    }
 
    // read each line of a file
    /*
    private String getFile(String fileName) {

    	StringBuilder result = new StringBuilder("");

    	//Get file from resources folder
    	ClassLoader classLoader = getClass().getClassLoader();
    	File file = new File(classLoader.getResource(fileName).getFile());

    	try (Scanner scanner = new Scanner(file)) {

    		while (scanner.hasNextLine()) {
    			String line = scanner.nextLine();
    			result.append(line).append("\n");
    		}

    		scanner.close();

    	} catch (IOException e) {
    		e.printStackTrace();
    	}

    	return result.toString();

      }
      */
    
    private static File[] getFileList(String dirPath) {
        File dir = new File(dirPath);   

        File[] fileList = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        return fileList;
    }
}