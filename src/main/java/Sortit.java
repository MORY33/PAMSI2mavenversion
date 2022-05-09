import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Sortit implements Runnable{

    private int id;
    private boolean exit = false;
    Algorithm algorithm;
    public ArrayList<Movie> myMovies;
    public ArrayList<Movie> quickMovies;
    public ArrayList<Movie> mergeMovies;
    public ArrayList<Movie> otherMovies;
    private int size;

    public int getSize() {
        return size;
    }

    public Sortit(ArrayList<Movie> myMovies, Algorithm algorithm){
        this.myMovies = myMovies;
        this.algorithm = algorithm;
    }

    public Sortit(Algorithm algorithm){
//        this.myMovies = myMovies;
        this.algorithm = algorithm;
    }



    public Sortit() {
    }


    public ArrayList<Movie> getArrayAfterSorting() {
        return myMovies;
    }

    Movie Object = new Movie();



    public void otherSort() throws InterruptedException {
        System.out.println("other sorting...");
        Movie oneMovie = new Movie("BNT FCHUJ", 5);
        myMovies.add(oneMovie);
//        TimeUnit.SECONDS.sleep(12);
        stop();
//        Object.printList(myMovies);
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

    @Override
    public void run() {

        while(!exit){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(algorithm.equals(Algorithm.QUICKSORT)){

                stop();

            }
           else if(algorithm.equals(Algorithm.MERGESORT)){

                    stop();

            }
           else if (algorithm.equals(Algorithm.OTHERSORT)){
                System.out.println("Other sorted");
                stop();
            }
           else if (algorithm.equals(Algorithm.COMPARE)){
//                ArrayList<Movie> temp = new ArrayList<Movie>();
//                temp = myMovies;
//                Movie moviemovie = new Movie("bnf ajakze", 5);
//                temp.add(moviemovie);
//                System.out.println("QuickSorted: \n");
//
//                QuickSort sorter = new QuickSort(temp, temp.size());
//                sorter.quickShort(0, sorter.getSize() - 1);
//                Object.printList(sorter.getQuickSorted());
//
//                System.out.println("MergeSorted: \n");
//
//                temp = null;
//                mergeMovies = myMovies;
//
//                MergeSort mSorter = new MergeSort(mergeMovies, mergeMovies.size());
////                mSorter.addMovie();
//                mSorter.divideArrayElements(0, mSorter.getSize() - 1);
//                Object.printList(mSorter.getMergeSorted());

                ArrayList<Movie> temp = new ArrayList<Movie>();
                Movie moviemovie = new Movie("bnf ajakze", 5);
//                temp.add(moviemovie);
                System.out.println("QuickSorted: \n");

                ArrayList<Movie> quick = new ArrayList<Movie>();
                ArrayList<Movie> merge = new ArrayList<Movie>();
                ArrayList<Movie> other = new ArrayList<Movie>();

                try {
                    quick = Object.CreateList();
                    quick.add(moviemovie);
                    merge = Object.CreateList();
                    other = Object.CreateList();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                QuickSort sorter = new QuickSort(quick, quick.size());
                sorter.quickShort(0, sorter.getSize() - 1);

                Object.printList(sorter.getQuickSorted());


                System.out.println("MergeSorted: \n");

                MergeSort mSorter = new MergeSort(merge, merge.size());
                mSorter.divideArrayElements(0, mSorter.getSize() - 1);
                Object.printList(mSorter.getMergeSorted());



                stop();

            }

        }


    }

}
