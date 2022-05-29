import java.util.Scanner;

public class Menu {

    public int menu(int a){

        Scanner sc= new Scanner(System.in);
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
