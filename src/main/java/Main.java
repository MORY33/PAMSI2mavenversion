import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {


        Menu menu = new Menu();
//        Movie movie = new Movie();
//        ArrayList<Movie> arej = new ArrayList<Movie>();
        int a=0;


        Sortit shortuj = null;
        try {
//            while(a!=5){
//                menu.menu(a);
//            }
            shortuj = new Sortit(menu.menu());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            shortuj.runSort();
            shortuj.compare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
