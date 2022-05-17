import java.io.IOException;
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
        System.out.println("Mean value: " + getMeanValue());
        System.out.println("Median value: " + getMedian());

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
        double median;

        if (id%2 == 0){
            median = (sorter.getQuickSorted().get(id/2).getRating() + sorter.getQuickSorted().get(id/2 - 1).getRating())/2;
        }
        else {
            median = sorter.getQuickSorted().get(id/2).getRating();
        }

        return median;
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
