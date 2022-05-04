import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Menu menu = new Menu();
//        menu.menu();
        Sortit shortit = new Sortit();
//        shortit.runThreads();
        RunThreads runnit = new RunThreads();
        runnit.runThreads();


    }
}
