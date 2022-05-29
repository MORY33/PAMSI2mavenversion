import java.util.ArrayList;
import java.util.Collections;

public class QuickSort implements Runnable{
    private final int size;
    private final ArrayList<Movie> quickSorted;

    public long elapsedTime;
    public boolean exit;
    public QuickSort(ArrayList<Movie> quickSorted, int size){
        this.quickSorted = quickSorted;
        this.size = size;
    }


    public void quickShort(int left, int right) {
        int i = left;
        int j = right;


        double pivot = quickSorted.get(right).getRating();

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

        if (j > left) quickShort(left, j);// recursively from left
        if (i < right) quickShort(i, right);// recursively from right
//
    }

    public ArrayList<Movie> getQuickSorted() {
        return quickSorted;
    }

    public double getTime(){
        return elapsedTime*Math.pow(10, -6);
    }

    public boolean isSorted(){
        boolean sorted = false;
        for (int i = 0; i < getQuickSorted().size() -1; i++) {
            if(getQuickSorted().get(i).getRating() > getQuickSorted().get(i+1).getRating()){
                return sorted;
            }
        }
        return true;
    }

    public void stop()
    {
        exit = true;
    }

    public int getSize() {
        return size;
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
