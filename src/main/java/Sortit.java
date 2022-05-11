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
        sorter = new QuickSort(Object.CreateList(id), Object.CreateList(id).size());
        mSorter = new MergeSort(Object.CreateList(id), Object.CreateList(id).size());
        oSorter = new OtherSort(Object.CreateList(id), Object.CreateList(id).size());
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


    public void compare(){
        System.out.println("Quick sorted: ");
//        Object.printList(sorter.getQuickSorted());
        System.out.println("Quick sort needed: " + sorter.getTime() +  " ms to sort given list");
        System.out.println("Merge sorted: ");
//        Object.printList(mSorter.getMergeSorted());
        System.out.println("Merge sort needed: " + mSorter.getTime() + " ms to sort given list");

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
