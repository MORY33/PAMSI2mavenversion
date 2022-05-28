import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Sortit{

    private final int id;
    //    private int id;
    public boolean exit = false;
    Algorithm algorithm;
    public ArrayList<Movie> myMovies;
    public Movie Object = new Movie();

    public QuickSort sorter;
    public MergeSort mSorter;
    public OtherSort oSorter;
    private int size;



    public int getSize() {
        return size;
    }


    public Sortit(int id) throws IOException {
        this.id = id;
//        myMovies = Object.CreateList(id);
//        sorter = new QuickSort(myMovies, myMovies.size());
        size  = Object.CreateList(id).size();
        sorter = new QuickSort(Object.CreateList(id), Object.CreateList(id).size());
        mSorter = new MergeSort(Object.CreateList(id), Object.CreateList(id).size());
        oSorter = new OtherSort(Object.CreateList(id), Object.CreateList(id).size());
    }

    public Movie getObject() {
        return Object;
    }

    public ArrayList<Movie> getArrayAfterSorting() {
        return myMovies;
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
        System.out.println("Quick sorted: ");
//        Object.printList(sorter.getQuickSorted());
        System.out.println("Quick sort needed: " + sorter.getTime() +  " ms to sort given list");
//        mSorter.clearArray();
        System.out.println("Merge sorted: ");
//        Object.printList(mSorter.getMergeSorted());
        System.out.println("Merge sort needed: " + mSorter.getTime() + " ms to sort given list");

        System.out.println("Other sorted: ");
//        Object.printList(oSorter.getSortedArray());


        System.out.println("Merge sort needed: " + oSorter.getTime() + " ms to sort given list\n");
        System.out.println("Mean value: " + getMeanValue());
        System.out.println("Median value: " + getMedian() +"\n");

    }


    public double getMeanValue() throws IOException {
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
          System.out.println("Medians from all methods are the same!");
      }
      else{
          System.out.println("Ehh, something is broken and medians are not the same:(");
      }

        return median;
    }

    public boolean isEqual(double a, double b){

        double epsilon = 0.000001d;

        if (Math.abs(a-b) < epsilon) {
            return true;
        }
        return false;
    }

    public void stop()
    {
       exit = true;
    }

    public ArrayList<Movie> getMyMovies() {
        return myMovies;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

}
