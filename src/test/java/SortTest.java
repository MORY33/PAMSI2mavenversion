import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Hashtable;

public class SortTest {
    @Test
    public void testSort() throws IOException {

        Sortit testSort = new Sortit(10);

        QuickSort sorter = testSort.sorter;
        Movie tempMovie = new Movie();
//        Assert.assertEquals(sorter.getQuickSorted(), sorter.getQuickSorted().sort());

        ArrayList<Double> list = new ArrayList<>();
        ArrayList<Movie> sortedList = new ArrayList<>();
        QuickSort sort;

        String filmList = "Piękna i bestia";
        Double[] filmRating = {3.0,6.0,4.0,2.0,4.0,9.0, 3.0};


        for (double index : filmRating){
            list.add(index);
        }


        sorter.quickShort(0, list.size() - 1);

//        Assert.assertEquals(sorter.getQuickSorted(), list.sort() );
//
//
//
//
//
//
//        tempMovie.printList(list);


    }
}
