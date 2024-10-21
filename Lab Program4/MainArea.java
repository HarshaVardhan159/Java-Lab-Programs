import java.util.Scanner;
import java.lang.Math;
abstract class Shape{
double length,breadth,radius,height,base,result;
abstract void printArea();
}

class Rectangle extends Shape{

void printArea(){

Scanner sc= new Scanner(System.in);
System.out.println("Enter the dimensions of rectangle:");
length=sc.nextDouble();
breadth=sc.nextDouble();
result=length*breadth;
System.out.println("Area of rectangle:"+result);

}
}

class Triangle extends Shape{

void printArea(){

Scanner sc= new Scanner(System.in);
System.out.println("Enter the dimensions of Triangle:");
base=sc.nextDouble();
height=sc.nextDouble();
result= 0.5*base*height;
System.out.println("Area of triangle:"+result);

}
}

class Circle extends Shape{

void printArea(){

Scanner sc= new Scanner(System.in);
System.out.println("Enter the radius of circle:");
radius=sc.nextDouble();
result=Math.PI*radius*radius;
System.out.println("Area of rectangle:"+result);

}
}

class MainArea{

public static void main(String args[])
{
	Rectangle r =new Rectangle();
	
	r.printArea();
	
	Triangle t=new Triangle();
	
	t.printArea();
	
	Circle c = new Circle();
	
	c.printArea();
System.out.println("Name: Harsha Vardhan");
System.out.println("USN:1BM23CS136");
}
}

