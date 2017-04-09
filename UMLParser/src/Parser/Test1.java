package Parser;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;



public class Test1 {
    public static void main(String[] args) throws ParseException, IOException {

        File[] fileList = getFileList("..\\UMLParser\\src\\uml_parser_test1");
        //A a = new A();
        for(File file : fileList) {
            //System.out.println(file.getName());
            CompilationUnit compilationUnit = JavaParser.parse(file);
            System.out.println(compilationUnit.toString());
        	//Optional<ClassOrInterfaceDeclaration> classA = compilationUnit.getClassByName(compilationUnit);
        }
        //Test1 obj = new Test1();
    	System.out.println();
    	
    }
 
    
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