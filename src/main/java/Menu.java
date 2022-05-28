import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {

    public int menu(){
        System.out.println("Enter option from listed below: ");
        System.out.println("0 ---> LIST SIZE OF YOUR CHOICE");
        System.out.println("1 ---> LIST SIZE 10 000");
        System.out.println("2 ---> LIST SIZE 100 000");
        System.out.println("3 ---> LIST SIZE OF ALL ELEMENTS (NEARLY 500 000)");
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();
//        System.out.println(a);
        int listSize = 0;

        switch(a){
            case 0:
                listSize=sc.nextInt();
                break;
            case 1:
                listSize=10000;
                break;
            case 2:
                listSize=100000;
                break;
            case 3:
                listSize=500000;
                break;
            default:
                listSize=0;
                System.exit(0);
                break;

        }
        return listSize;
    }



}
