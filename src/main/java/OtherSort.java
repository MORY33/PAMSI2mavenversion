import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class OtherSort implements Runnable {
    private final int size;
    private ArrayList<Movie> otherSorted;

    public boolean exit;

    public OtherSort(ArrayList<Movie> otherSorted, int size) throws IOException {
        this.otherSorted = otherSorted;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void sortinggg(){
        System.out.println("soritng");
    }

    public void stop()
    {
        exit = true;
    }


    @Override
    public void run() {
        while(!exit){

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            stop();
        }
    }

}