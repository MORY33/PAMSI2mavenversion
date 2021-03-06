import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        Menu menu = new Menu();
        Sortit shortuj;
        int a=0;

        try {
            while(a!=4){

                System.out.println( "\033[1;36m" + "Enter option from listed below: ");
                System.out.println("0 ---> LIST SIZE OF YOUR CHOICE");
                System.out.println("1 ---> LIST SIZE 10 000");
                System.out.println("2 ---> LIST SIZE 100 000");
                System.out.println("3 ---> LIST SIZE OF ALL ELEMENTS (NEARLY 500 000)");
                System.out.println("4 ----> FINISH PROGRAM\n" + "\033[0m");
                Scanner sc= new Scanner(System.in);
                a = sc.nextInt();
                if (a==0 || a==1 || a==2 || a==3){
                    shortuj = new Sortit(menu.menu(a));
                    shortuj.runSort();
                    shortuj.compare();
                }
            }

            System.out.println(menu.menu(a));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
