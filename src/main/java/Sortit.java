import java.util.ArrayList;

public class Sortit implements Runnable{

    private int id;
    private Algorithm algorithm;
    private ArrayList<Movie> myMovies;

    public Sortit(ArrayList<Movie> myMovies, Algorithm algorithm){
        this.myMovies = myMovies;
        this.algorithm = algorithm;
    }

    public Sortit(int id){
        this.id = id;
    }


    public void quickSort(){
        System.out.println("quick sorting...");
    }

    public void mergeSort(){
        System.out.println("merge sorting...");
    }

    public void otherSort(){
        System.out.println("other sorting...");
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(algorithm.equals(Algorithm.QUICKSORT)){
                quickSort();
           }
           else if(algorithm.equals(Algorithm.MERGESORT)){
               mergeSort();
           }
           else if (algorithm.equals(Algorithm.OTHERSORT)){
               otherSort();
           }
        }

    }

//    public void kubelkowe/introspektywne


}
