package Parser;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;


/**
 * 1. take input parameters and store them.
 * 2. parse java code..
 * 3. output image to local file system.
 * 
 */


public class Test1 {
	private static String folderPath = "";
	private static String fileName = "";
	private static List<File> allJavaFiles;
	
	/**
	 * 
	 * @param args 1. folder path   2. file name
	 * @throws ParseException
	 * @throws IOException
	 */
	
    public static void main(String[] args) throws ParseException, IOException {
    	//take parameters
    	if(args.length == 2){
    		folderPath = args[0];
    		fileName = args[1];
    	}else if(args.length == 0){
    		System.out.println(" Entered 0 parameters");
    	}
    	
    	allJavaFiles = getAllJavaFiles(folderPath);
    	    	
    }
    
    /**
     * 
     * @param folderPath
     * @return
     */
    public static List<File> getAllJavaFiles(String folderPath){
    	File folder = new File(folderPath);
    	File[] files = folder.listFiles();
    	List<File> javaFiles = new ArrayList<>();
    	for(int i = 0; i < files.length; i++){
    		if(files[i].getName().endsWith(".java")){
    			javaFiles.add(files[i]);
    		}
    	}
    	return javaFiles;
    	
    }
}