import java.lang.Math;
class quadratic{
public static void main(String args[]){
int a,b,c;
double r1,r2;
Scanner scan = new Scanner(System.in);
System.out.println("Enter the value of a:");
a=scan.nextInt();
System.out.println("Enter the value of b:");
b = scan.nextInt();
System.out.println("Enter the value of c:");
c=scan.nextInt();
scan.close();
float d=b*b-(4*a*c);
System.out.println("The value of d is:" +d);
if(a==0){
System.out.println("Not a quadratic equation");
}
if(d==0){
r1=(-b)/(2*a);
System.out.println("Roots are real and equal");
System.out.println("Root 1 is" +r1+ "\nRoot 2 is" +r1);
}
else if(d>0)
{
r1=((-b) + (Math.sqrt(d)))/(double)(2*a);
r2=((-b) - (Math.sqrt(d)))/(double)(2*a);
System.out.println("Root 1 is" +r1+ "\nRoot 2 is" +r1);
}
else if(d<0)
{
System.out.println("Roots are imaginary");
r1=(-b)/(2*a);
r2 = Math.sqrt(-d)/(2*a);
System.out.println("Root 1 is " +r1+ "+" +r2+"i");
}
}
}
