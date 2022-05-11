import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MergeSort implements Runnable{
    private final int size;
    private ArrayList<Movie> mergeSorted;
    public boolean exit;

    public MergeSort(ArrayList<Movie> mergeSorted, int size) throws IOException {
        this.mergeSorted = mergeSorted;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    Movie bnt = new Movie("Bnt fchuj", 6);

    public void addMovie() {
//        mergeSorted = mergeSorted.add(10, "bntfchuj");
        Movie oneMovie = new Movie("Bnt fest", 9);
        mergeSorted.add(oneMovie);
    }


    public ArrayList<Movie> getMergeSorted() {
        return mergeSorted;
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
//        ArrayList<Movie> tempmovies = new ArrayList<Movie>();
//        tempmovies = myMovies;

        int getLeftIndex = indexStart;
        int getRightIndex = indexMiddle + 1;

        while (getLeftIndex <= indexMiddle && getRightIndex <= indexEnd) {

            if (mergeSorted.get(getLeftIndex).getRating() <= mergeSorted.get(getRightIndex).getRating()) {

                tempArray.add(mergeSorted.get(getLeftIndex));
                getLeftIndex++;

            } else {

                tempArray.add(mergeSorted.get(getRightIndex));
                getRightIndex++;

            }
        }

        while (getLeftIndex <= indexMiddle) {
            tempArray.add(mergeSorted.get(getLeftIndex));
            getLeftIndex++;
        }

        while (getRightIndex <= indexEnd) {
            tempArray.add(mergeSorted.get(getRightIndex));
            getRightIndex++;
        }


        for (int i = 0; i < tempArray.size(); indexStart++) {
            mergeSorted.set(indexStart, tempArray.get(i++));

        }

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

            divideArrayElements(0, size - 1);
            stop();
        }
    }

}

