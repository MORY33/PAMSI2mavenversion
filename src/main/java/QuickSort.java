import java.util.ArrayList;
import java.util.Collections;

public class QuickSort extends Sortit {
    private final int size;
    private ArrayList<Movie> quickSorted;

    public QuickSort(ArrayList<Movie> quickSorted, int size) {
        this.quickSorted = quickSorted;
        this.size = size;
    }

    public QuickSort(int size) {
        super();
        this.size = size;
    }

    Movie bnt = new Movie("Bnt fchuj", 4);

    public int getSize() {
        return size;
    }

    public void addMovie(){
        quickSorted.add(bnt);
    }

    public void quickShort(int lewy, int prawy) {
        int i = lewy;
        int j = prawy;


        double pivot = quickSorted.get(prawy).getRating();

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

        if (j > lewy) quickShort(lewy, j);// rekursywanie wywolujemy z lewej
        if (i < prawy) quickShort(i, prawy);// rekursywanie wywolujemy z prawej
//        Object.printList(myMovies);
//        Object.printList(tempmovies);
//        System.out.println("sorted");
//        stop();
    }

    public ArrayList<Movie> getQuickSorted() {
        return quickSorted;
    }
}
