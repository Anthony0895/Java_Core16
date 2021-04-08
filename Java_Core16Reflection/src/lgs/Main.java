package lgs;

import java.util.Arrays;
import java.lang.reflect.*;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		

	Class ac = Animal.class;
	
	String simplenameOfclass = ac.getSimpleName();
	System.out.println("The simple name of class  -- "+ simplenameOfclass);
	System.out.println("Name class = " + ac.getName());
	System.out.println("Modifirer = " + Modifier.toString(ac.getModifiers()));
	System.out.println("Package name class = " + ac.getPackage());
	System.out.println("Name Super Class = " + ac.getSuperclass());
	System.out.println("Interfaces = " + Arrays.toString(ac.getInterfaces()));
	
	
	Constructor<Animal>[] constructors = ac.getConstructors();
	Constructor<Animal> constructor = constructors[0];

	Class<?>[] parameterTypes = constructor.getParameterTypes();
	for (int i = 0; i < parameterTypes.length; i++) {
		Class<?> class1 = parameterTypes[i];
		System.out.println("Type parameter " + i + " = " + class1);
	}
	
	Method[] methods = ac.getMethods();
	for (int i = 0; i < methods.length; i++) {
		Method method = methods[i];
		System.out.println("Metod " + i + " =" + method);
	}
	Constructor<Animal> constructor1 = ac.getConstructor(String.class, int.class);
	Animal newInstance = constructor1.newInstance("Cat", 4);
	System.out.println(newInstance);
	
	methods[4].invoke(newInstance, "Dog");
	System.out.println("New animal =" + newInstance);

	methods[5].invoke(newInstance, "China");
	System.out.println("New country =" + newInstance);
	
	System.out.println(newInstance);
	Field[] fields = ac.getFields();
	for (int i = 0; i < fields.length; i++) {
		System.out.println("Fields " + i + " = " + fields[i]);
	}

	fields = ac.getDeclaredFields();
	for (int i = 0; i < fields.length; i++) {
		System.out.println("Fields declared " + i + " = " + fields[i]);
	}

	Field previaField = ac.getField("age");
	previaField.set(newInstance, 7);
	System.out.println("\n" + newInstance);

	

}
}