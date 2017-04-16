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
/*
 * 
 */


public class Test1 {
	private static String folderPath = "";
	private static String fileName = "";
	
    public static void main(String[] args) throws ParseException, IOException {
    	//take parameters
    	if(args.length == 2){
    		folderPath = args[0];
    		fileName = args[1];
    	}else if(args.length == 0){
    		System.out.println(" Entered 0 parameters");
    	}
    	

    	
    }
 
}