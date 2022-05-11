import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class QuickSort implements Runnable{
    private int size;
    private ArrayList<Movie> quickSorted;

    public long elapsedTime;
    public boolean exit;
    public QuickSort(ArrayList<Movie> quickSorted, int size) throws IOException {
        this.quickSorted = quickSorted;
        this.size = size;
    }


    public int getSize() {
        return size;
    }


    public void quickShort(int lewy, int prawy) {
        int i = lewy;
        int j = prawy;


        double pivot = quickSorted.get(prawy).getRating();

        do
        {
            while (quickSorted.get(i).getRating() < pivot) i++;
            while (quickSorted.get(j).getRating() > pivot) j--;
            if (i <= j)
            {
                Collections.swap(quickSorted,i,j);
                i++;
                j--;
            }
        } while (i<=j);

        if (j > lewy) quickShort(lewy, j);// rekursywanie wywolujemy z lewej
        if (i < prawy) quickShort(i, prawy);// rekursywanie wywolujemy z prawej
//        Object.printList(myMovies);
//        Object.printList(tempmovies);
//        System.out.println("sorted");
//        stop();
    }

    public ArrayList<Movie> getQuickSorted() {
        return quickSorted;
    }

    public double getTime(){
        return elapsedTime*Math.pow(10, -6);
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


            long start = System.nanoTime();
            quickShort(0, size - 1);
            elapsedTime = System.nanoTime() - start;

            stop();
        }
    }




}
