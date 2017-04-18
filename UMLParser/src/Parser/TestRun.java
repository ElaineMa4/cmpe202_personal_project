package Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

/**
 * 1. take input parameters and store them.
 * 2. parse...
 * 3. output image to local file system.
 *
 */
public class TestRun {
	private static String folderPath = "";
	private static String fileName = "";
	private static List<File> allJavaFiles;
	private static List<CompilationUnit> allCompilationUnit;
	
	/**
	 * 
	 * @param args 1. folder path
	 * 			   2. file name
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// take parameters
		if (args.length == 2) {
			folderPath = args[0];
			fileName = args[1];
		} else if (args.length == 0){
			System.out.println("entered 0 parameters");
		}
		
		allJavaFiles = getAllJavaFiles(folderPath);
		allCompilationUnit = new ArrayList<>();
		
		Map<String, MyClass> classMap = new HashMap<>(); // Map<[Class Name], [MyClass instance]> 
		
		
		// 1. get extends from and implements from
		for (File file : allJavaFiles) {
			String name = file.getName().substring(0, file.getName().lastIndexOf('.'));
			classMap.put(name, new MyClass());
			
			CompilationUnit cUnit = JavaParser.parse(file);
			allCompilationUnit.add(cUnit);
		}
		
		for (int i = 0; i < allCompilationUnit.size(); i++) {
			CompilationUnit cUnit = allCompilationUnit.get(i);
			List<TypeDeclaration<?>> types = cUnit.getTypes();
			
			MyClass currentClass;

			for (TypeDeclaration typeDeclaration : types) {
				if (typeDeclaration instanceof ClassOrInterfaceDeclaration) {
					ClassOrInterfaceDeclaration classDeclaration = (ClassOrInterfaceDeclaration)typeDeclaration;
					// get MyClass instance according to current class name
					currentClass = classMap.get(classDeclaration.getNameAsString());
					// get extend
					List<ClassOrInterfaceType> list = classDeclaration.getExtendedTypes();
					for (ClassOrInterfaceType eachType : list) {
						currentClass.setExtendsFrom(eachType.getNameAsString());
					}

					// get implement
					List<ClassOrInterfaceType> implementList = classDeclaration.getImplementedTypes();
					for (ClassOrInterfaceType eachType : implementList) {
						currentClass.getImplementFrom().add(eachType.getNameAsString());
					}
				}
			}
		}
		
		
	}
	
	/**
	 * 
	 * @param folderPath
	 * @return
	 */
	public static List<File> getAllJavaFiles(String folderPath) {
		File folder = new File(folderPath);
		File[] files = folder.listFiles();  // xm
		List<File> javaFiles = new ArrayList<>();
		for(int i = 0; i < files.length; i++){
			if(files[i].getName().endsWith(".java")){
				javaFiles.add(files[i]);
			}
		}
		return javaFiles;
	}
	
}