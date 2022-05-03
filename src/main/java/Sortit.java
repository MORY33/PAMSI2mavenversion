import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Sortit implements Runnable{

    private int id;
    private boolean exit = false;
    private Algorithm algorithm;
    private ArrayList<Movie> myMovies;

    public Sortit(ArrayList<Movie> myMovies, Algorithm algorithm){
        this.myMovies = myMovies;
        this.algorithm = algorithm;
    }

    ArrayList<Movie> tempList = new ArrayList<Movie>();

    public Sortit(int id){
        this.id = id;
    }


    public ArrayList<Movie> loadMovieList() throws IOException {
        ArrayList<Movie> tempList = new ArrayList<Movie>();
        Movie movieList = new Movie();
        tempList = movieList.CreateList();
        return tempList;
    }



    public void runThreads() throws IOException {

        Movie tempList = new Movie();
        tempList.CreateList();
        tempList.printList(tempList.CreateList());

        Runnable[] runners = new Runnable[3];
        Thread[] threads = new Thread[3];

        runners[0] = new Sortit(tempList.CreateList(), Algorithm.QUICKSORT);
        runners[1] = new Sortit(tempList.CreateList(), Algorithm.MERGESORT);
        runners[2]= new Sortit(tempList.CreateList(), Algorithm.OTHERSORT);

        //tworzy i odpala wszystkie wątki
        for (int i=0; i<3; i++){
            threads[i] = new Thread(runners[i]);
        }

        for (int i=0; i<3; i++){
            threads[i].start();
        }

    }


    public ArrayList<Movie> quickSort() throws InterruptedException {
        ArrayList<Movie> tempmovie = new ArrayList<Movie>();
        System.out.println("quick sorting...");



//        TimeUnit.SECONDS.sleep(2);
//        stop();
        return tempmovie;
    }



    public int mergeSort() throws InterruptedException {
        System.out.println("merge sorting...");
        int i = 5;

        TimeUnit.SECONDS.sleep(2);
        i = 0;
//        stop();
        return i;
    }

    public void otherSort() throws InterruptedException {
        System.out.println("other sorting...");



//        TimeUnit.SECONDS.sleep(12);
//        stop();
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
            if(algorithm.equals(Algorithm.QUICKSORT)){
                try {
                    quickSort();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
           else if(algorithm.equals(Algorithm.MERGESORT)){
                try {
                    mergeSort();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
           else if (algorithm.equals(Algorithm.OTHERSORT)){
                try {
                    otherSort();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }

//    public void kubelkowe/introspektywne


}
