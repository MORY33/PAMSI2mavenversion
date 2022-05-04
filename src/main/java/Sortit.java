import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Sortit implements Runnable{

    private int id;
    private boolean exit = false;
    private Algorithm algorithm;
    public ArrayList<Movie> myMovies;

    public Sortit(ArrayList<Movie> myMovies, Algorithm algorithm){
        this.myMovies = myMovies;
        this.algorithm = algorithm;
    }

    public Sortit() {
    }

    public ArrayList<Movie> getArrayAfterSorting() {
        return myMovies;
    }


    Movie Object = new Movie();


    public void runThreads() throws IOException {

//        Movie tempList = new Movie();
        myMovies = Object.CreateList();
        Object.printList(myMovies);

        Runnable[] runners = new Runnable[3];
        Thread[] threads = new Thread[3];

        runners[0] = new Sortit(Object.CreateList(), Algorithm.QUICKSORT);
        runners[1] = new Sortit(Object.CreateList(), Algorithm.MERGESORT);
        runners[2]= new Sortit(Object.CreateList(), Algorithm.OTHERSORT);

        //creates and run all threads
        for (int i=0; i<3; i++){
            threads[i] = new Thread(runners[i]);
        }

        for (int i=0; i<3; i++){
            threads[i].start();
        }

//       Object.printList(tempoList);

    }




    public void divideArrayElements(int indexStart, int indexEnd) {

        if (indexStart < indexEnd && (indexEnd - indexStart) >= 1) {
            int middleElement = (indexEnd + indexStart) / 2;

            divideArrayElements(indexStart, middleElement);
            divideArrayElements(middleElement + 1, indexEnd);

            mergeArrayElements(indexStart, middleElement, indexEnd);
        }
    }

    public void mergeArrayElements(int indexStart, int indexMiddle, int indexEnd) {

        ArrayList<Movie> tempArray = new ArrayList<Movie>();
        ArrayList<Movie> tempmovies = new ArrayList<Movie>();
        tempmovies = myMovies;

        int getLeftIndex = indexStart;
        int getRightIndex = indexMiddle + 1;

        while (getLeftIndex <= indexMiddle && getRightIndex <= indexEnd) {

            if (tempmovies.get(getLeftIndex).getRating() <= tempmovies.get(getRightIndex).getRating()) {

                tempArray.add(tempmovies.get(getLeftIndex));
                getLeftIndex++;

            } else {

                tempArray.add(tempmovies.get(getRightIndex));
                getRightIndex++;

            }
        }

        while (getLeftIndex <= indexMiddle) {
            tempArray.add(tempmovies.get(getLeftIndex));
            getLeftIndex++;
        }

        while (getRightIndex <= indexEnd) {
            tempArray.add(tempmovies.get(getRightIndex));
            getRightIndex++;
        }


        for (int i = 0; i < tempArray.size(); indexStart++) {
            tempmovies.set(indexStart, tempArray.get(i++));

        }

    }





    public ArrayList<Movie> quickShort(int lewy, int prawy) {
        int i = lewy;
        int j = prawy;

        ArrayList<Movie> tempmovies = new ArrayList<Movie>();
        tempmovies = myMovies;

        double pivot = tempmovies.get(prawy).getRating();

        do
        {
            while (tempmovies.get(i).getRating() < pivot) i++;
            while (tempmovies.get(j).getRating() > pivot) j--;
            if (i <= j)
            {
                Collections.swap(tempmovies,i,j);
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
        return tempmovies;

    }



    public void mergeSort()  {
        System.out.println("merge sorting...");


//        Movie oneMovie = new Movie("BNT FCHUJ", 5);
//        myMovies.add(oneMovie);
        System.out.println("0");
//        Object.printList(myMovies);
        System.out.println("0");
//        TimeUnit.SECONDS.sleep(2);
        stop();
    }

    public void otherSort() throws InterruptedException {
        System.out.println("other sorting...");


//        TimeUnit.SECONDS.sleep(12);
        stop();
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
                Movie oneMovie = new Movie("BNT FCHUJ", 5);
                myMovies.add(oneMovie);
//                quickShort(0, myMovies.size() - 1);

                stop();
//                Object.printList(quickShort(0, myMovies.size() - 1));
                System.out.println("Quick sorted");

            }
           else if(algorithm.equals(Algorithm.MERGESORT)){
                    mergeSort();

                    divideArrayElements(0, myMovies.size() - 1);
                    System.out.println("Merge Sorted");
                    Object.printList(getArrayAfterSorting());
                    stop();


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

}
