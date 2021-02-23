package com.assignment1;

class Singleton_Class_Example
{ 

    private static Singleton_Class_Example single_instance = null; 

    public int student_marks; 

    private Singleton_Class_Example() 
    { 
        student_marks = 70;
    } 
  
    public static Singleton_Class_Example increaseMarks() 
    { 
        if (single_instance == null) 
            single_instance = new Singleton_Class_Example(); 
  
        return single_instance; 
    } 
} 

public class SingletonClass {

	public static void main(String args[]) 
    { 
		Singleton_Class_Example student1 = Singleton_Class_Example.increaseMarks(); 

		Singleton_Class_Example student2 = Singleton_Class_Example.increaseMarks(); 

		Singleton_Class_Example student3 = Singleton_Class_Example.increaseMarks(); 
  
		student1.student_marks += 10;
		
		student2.student_marks += 10;
		
		student3.student_marks += 10;

		System.out.println("This shows student 1 marks::::   " + student1.student_marks);
		System.out.println("This shows student 2 marks::::   " + student2.student_marks);
		System.out.println("This shows student 3 marks::::   " + student3.student_marks);
		System.out.println("As we can see, In the Singleton_Class_Example class, when we first time "
				+ "call increaseMarks() method, it creates an object of the class with name"
				+ " single_instance and return it to the variable. Since single_instance is "
				+ "static, it is changed from null to some object. Next time, if we try to "
				+ "call increaseMarks() method, since single_instance is not null, it is returned "
				+ "to the variable, instead of instantiating the Singleton class again. Thus, "
				+ "when we create new objects, they point to the same object and incrase the value of the "
				+ "same student_marks every time.");
    } 
}
