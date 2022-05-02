import java.util.Scanner;

public class Menu {

    public static void menu(){
        System.out.println("Enter option from listed below: ");
        Scanner sc=new Scanner(System.in);
        int a= sc.nextInt();
        System.out.println(a);

        switch(a){
            case 1:
                System.out.println("Sentino");
                break;
            case 2:
                System.out.println("Taco");
                break;
            case 3:
                System.out.println("sobel");
                break;
            default:
                break;
        }
    }



}
