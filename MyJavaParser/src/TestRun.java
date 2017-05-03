import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
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
	//int a;
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
		//System.out.println(args[0]);
		
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
		
		for(String key : classMap.keySet()){
			boolean haveExtendsOrImplements = false;
			if(!classMap.get(key).getExtendsFrom().isEmpty()){
				System.out.print(key + " extends " + classMap.get(key).getExtendsFrom());
				haveExtendsOrImplements = true;
			}
			for(String name : classMap.get(key).getImplementFrom()){
				if(!classMap.get(key).getImplementFrom().isEmpty()){
					haveExtendsOrImplements = true;
				}
				System.out.print(key + " implements " + name); 
				
			}
			if(haveExtendsOrImplements){
				System.out.println();
			}
		}
		
		//2.get variables and methods from each class
		for(CompilationUnit unit : allCompilationUnit ){
			List<TypeDeclaration<?>> varTypes = unit.getTypes();
			//MyVariable currentVariable;
			
			for(TypeDeclaration  typeDeclaration :varTypes){
				List<BodyDeclaration> members = typeDeclaration.getMembers();
				for(BodyDeclaration member : members){
					//get method name
					if(member instanceof MethodDeclaration){
						MethodDeclaration method = (MethodDeclaration) member;
						System.out.print("Methods: " + method.getModifiers() + " " + method.getType() + " "+ method.getName());
						
						for(int i = 0; i < method.getParameters().size(); i++){
							System.out.print(method.getParameter(i) + " ");
						}
						System.out.println();												
					}					
					
					if(member instanceof FieldDeclaration){
						FieldDeclaration myType = (FieldDeclaration) member;
						// get modifier  
							System.out.println(myType.getModifiers().toString());
						// get each variable
						List<VariableDeclarator> varFields = myType.getVariables();
						//System.out.println(varFields.size());
						for(int i = 0; i < varFields.size(); i++){
							System.out.println("Fields:" + varFields.get(i).getType() + " " + varFields.get(i).getName());
						}
					}
				}
			}
			System.out.println(); 			
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
