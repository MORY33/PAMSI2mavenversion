import java.io.IOException;
import java.text.DecimalFormat;

public class Sortit{

    private final int id;
    public boolean exit = false;

    public long elapsedTime;
    public Movie Object = new Movie();

    public QuickSort sorter;
    public MergeSort mSorter;
    public OtherSort oSorter;
    private final int size;



    public int getSize() {
        return size;
    }


    public Sortit(int id) throws IOException {
        this.id = id;
        size  = Object.CreateList(id).size();
        sorter = new QuickSort(Object.CreateList(id), Object.CreateList(id).size());
        mSorter = new MergeSort(Object.CreateList(id), Object.CreateList(id).size());
        oSorter = new OtherSort(Object.CreateList(id), Object.CreateList(id).size());
    }


    public void runSort() throws IOException, InterruptedException{

            Runnable[] runners = new Runnable[3];
            Thread[] threads = new Thread[3];

            runners[0] = sorter;
            runners[1] = mSorter;
            runners[2]= oSorter;

            //creates and run all threads
            for (int i=0; i<3; i++){
                threads[i] = new Thread(runners[i]);
            }

            for (int i=0; i<3; i++){
                threads[i].start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

    }


    public void compare() throws IOException {
        DecimalFormat df = new DecimalFormat("#.###");

        checkCreatingListTime();
        System.out.println("\033[0;32m" + "Algorithm needed " + df.format(getElapsedTime()) + " ms to create and filter list\n" + "\033[0m");
        System.out.println("Quick sorted: ");
        System.out.println("Quick sort needed: " + df.format(sorter.getTime()) +  " ms to sort given list");
        System.out.println("Merge sorted: ");
        System.out.println("Merge sort needed: " + df.format(mSorter.getTime()) + " ms to sort given list");
        System.out.println("Other sorted: ");
        System.out.println("Merge sort needed: " + df.format(oSorter.getTime()) + " ms to sort given list\n");
        System.out.println("Mean value: " + df.format(getMeanValue()));
        System.out.println("Median value: " + getMedian() +"\n");

        if(sorter.isSorted() && oSorter.isSorted() && mSorter.isSorted()){
            System.out.println("\033[0;32m" + "Sorted correctly! ???" + "\033[0m");
        }
        else{
            System.out.println("\033[0;31m" + "In some list sorting gone wrong ???" + "\033[0m");
        }

    }


    public double getMeanValue(){
        double mean;
        double ratings = 0;
        for (Movie objects : Object.CreateList(id)){
            ratings+=objects.getRating();
        }
        mean = ratings / Object.CreateList(id).size();
        return mean;
    }



    public double getMedian(){
        double quickMedian;
        double mergeMedian;
        double otherMedian;
        double median = 0;

        if (size%2 == 0){
            quickMedian = (sorter.getQuickSorted().get(size/2).getRating() + sorter.getQuickSorted().get((size/2) - 1).getRating())/2;
        }
        else {
            quickMedian = sorter.getQuickSorted().get(size/2).getRating();
        }

        if (size%2 == 0){
            mergeMedian = (mSorter.getMergeSorted().get(size/2).getRating() + mSorter.getMergeSorted().get((size/2) - 1).getRating())/2;
        }
        else {
            mergeMedian = mSorter.getMergeSorted().get(size/2).getRating();
        }

        if (size%2 == 0){
            otherMedian = (oSorter.getSortedArray().get(size/2).getRating() + oSorter.getSortedArray().get((size/2) - 1).getRating())/2;
        }
        else {
            otherMedian = oSorter.getSortedArray().get(size/2).getRating();
        }

      if(isEqual(mergeMedian, quickMedian) && isEqual(quickMedian,otherMedian)){
          median = mergeMedian;
          System.out.println("\033[0;32m" + "Medians from all methods are the same! ???" + "\033[0m");
      }
      else{
          System.out.println("\033[0;31m" + "Ehh, something is broken and medians are not the same:( ???" + "\033[0m");
      }

        return median;
    }


    public Movie getObject() {
        return Object;
    }

    public double getElapsedTime() {
        return (elapsedTime*Math.pow(10, -6));
    }

    public void checkCreatingListTime(){
        long start = System.nanoTime();
        Object.CreateList(id);
        elapsedTime = System.nanoTime() - start;
    }
    public boolean isEqual(double a, double b){

        double epsilon = 0.000001d;

        return Math.abs(a - b) < epsilon;
    }

    public void stop()
    {
       exit = true;
    }


}
