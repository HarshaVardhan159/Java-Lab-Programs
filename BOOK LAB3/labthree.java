import java.util.Scanner;

class Book{
    String name;
    String author;
    int price;
    int numPages;

    Book(String name, String author, int price, int numPages){
        this.name=name;
        this.author=author;
        this.price=price;
        this.numPages=numPages;
    }
    public String toString(){
        String name,author,price,numPages;
        name = "Name: " + this.name + "\n";
        author = "Author: " + this.author + "\n";
        price = "Price: " + this.price + "\n";
        numPages = "Number of Pages: " + this.numPages + "\n";
        String total = "";
        total+=name+author+price+numPages;
        return total;
    }
}


public class labthree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of Books here: ");
        int n = sc.nextInt();
        //Array of objects:
        Book[] arr = new Book[n];

        for (int i = 0; i < n; i++) {

            String name,author;
            int price,numPages;

            System.out.println("Enter the name of " + (i+1) +" book: ");
            name = sc.next();


            System.out.println("Enter the Price of the " + (i+1) + " Book: ");
            price = sc.nextInt();

            System.out.println("Enter the Author of the " + (i+1) + " Book: ");
            author = sc.next();

            System.out.println("Enter the Total Number of Pages of the " + (i+1) + " Book: ");
            numPages = sc.nextInt();

            arr[i] = new Book(name,author,price,numPages);
            System.out.println(arr[i]);


        }

        System.out.println("Name: K Harsha Vardhan");
        System.out.println("USN: 1BM23CS136 ");

    }
}