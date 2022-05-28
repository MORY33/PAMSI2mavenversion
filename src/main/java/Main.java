import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {


        Menu menu = new Menu();
        Movie movie = new Movie();
//        ArrayList<Movie> arej = new ArrayList<Movie>();
        int a=0;


        Sortit shortuj = null;
        try {
            while(a!=4){
                System.out.println("Enter option from listed below: ");
                System.out.println("0 ---> LIST SIZE OF YOUR CHOICE");
                System.out.println("1 ---> LIST SIZE 10 000");
                System.out.println("2 ---> LIST SIZE 100 000");
                System.out.println("3 ---> LIST SIZE OF ALL ELEMENTS (NEARLY 500 000)");
                System.out.println("4 ----> FINISH PROGRAM\n");
                Scanner sc= new Scanner(System.in);
                a = sc.nextInt();
                if (a==0 || a==1 || a==2 || a==3){
                    shortuj = new Sortit(menu.menu(a));
                    shortuj.runSort();
                    shortuj.compare();
                }
            }

            System.out.println(menu.menu(a));
//            shortuj = new Sortit(menu.menu(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
