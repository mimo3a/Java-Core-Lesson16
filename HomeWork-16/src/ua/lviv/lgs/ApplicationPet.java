package ua.lviv.lgs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ApplicationPet {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class petClass = Pet.class;
		
//		get name of class
		
		System.out.println("full name of class = " + petClass.getName());
		System.out.println("simple name of class = " + petClass.getSimpleName());
		
//		get modifier of class
		
		int modifier = petClass.getModifiers();
		System.out.println("mofifier of class = " + Modifier.toString(modifier));
		
		System.out.println("is static = " + Modifier.isStatic(modifier));
		System.out.println("is private" + Modifier.isPrivate(modifier));
		System.out.println("is abstract = " + Modifier.isAbstract(modifier));
		
//		package info
		
		System.out.println("name of package = " + petClass.getPackage());
		
//		get superclass
		
		System.out.println("name of superclass = " + petClass.getSuperclass());
		
//		get interfaces
		
		Class [] interfaces = petClass.getInterfaces();		
		System.out.println("name of interfaces = " + Arrays.toString(interfaces));
		
//		get constructors
		
		Constructor [] petConstructors = petClass.getConstructors();
		for (Constructor constructor : petConstructors) {
			System.out.println(constructor);						
		}
		System.out.println("amount of constructors = " + petConstructors.length);
		
//		get parameters of constructor
		
		Constructor myConstructor = petConstructors[0];
		Class [] parametersType = myConstructor.getParameterTypes();
		for (Class parameter : parametersType) {
			System.out.println("parameter = " + parameter);
			
		}
		
//		get constructor by parameters
		
		Constructor <Pet>findConstructor = petClass.getConstructor(String.class, String.class, int.class);
		System.out.println("faund constructor = " + findConstructor);
		Pet pet1 = findConstructor.newInstance("cat", "sahra", 12);
		System.out.println(pet1);
		
//		get fields
		
		
		
		Field [] petFields = petClass.getDeclaredFields();
		System.out.println("fields of class");
		for (Field field : petFields) {
			System.out.println(field);
		}
		
//		get methods
		
		System.out.println("methods of class");
		Method [] methods = petClass.getMethods();
		for (Method method : methods) {
			System.out.println(method);			
		}
		
//		changing the value of field
		
		System.out.println("pet1 before changing = " + pet1);
		Field petName = petFields[1];
		petName.setAccessible(true);
		petName.set(pet1, "Kesha");
		System.out.println("pet1 after changing = " + pet1);
		
//		using methods
		
		methods[9].invoke(pet1, "Murka", 3);
		System.out.println("new name and age = " + pet1);
		
		methods[4].invoke(pet1, "Barsik");
		System.out.println("new name = " + pet1);
		
		
		
		
		
		
		
		
		

	}

}
