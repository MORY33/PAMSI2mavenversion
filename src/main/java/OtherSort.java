import java.io.IOException;
import java.util.ArrayList;


public class OtherSort implements Runnable {
    private final int size;

    private int bucketsQuantity;
    private double max;
    private ArrayList<Movie> otherSorted;

    public ArrayList<ArrayList<Movie>> buckets;

    ArrayList<Movie> sortedArray = new ArrayList<>();

    public boolean exit;
    private MergeSort mergesort;
    private QuickSort quickSort;

    public OtherSort(ArrayList<Movie> otherSorted, int size) throws IOException {
        this.otherSorted = otherSorted;
        this.size = size;
        bucketsQuantity = (int) Math.sqrt(otherSorted.size());
        max =  findMax();
        buckets = new ArrayList<>(bucketsQuantity);
        for(int i=0; i<bucketsQuantity;i++){
            buckets.add(new ArrayList<>());
        }
//        mergesort = new MergeSort(otherSorted, size);
    }

    private double findMax() {
        double m = Integer.MIN_VALUE;
        for (Movie i : otherSorted) {
            m = Math.max(i.getRating(), m);
        }
        return m;
    }

    private int hash(double i, double max, int numberOfBuckets) {
        return (int) ((double) i / max * (numberOfBuckets - 1));
    }

    public ArrayList<Movie> getOtherSorted() {
        return otherSorted;
    }

    public ArrayList<Movie> getSortedArray() {
        return sortedArray;
    }
    public void otherSort() throws IOException {

        for (Movie i : getOtherSorted()) {
            buckets.get(hash(i.getRating(), max, bucketsQuantity)).add(i);
        }

//        QuickSort quickSort = new QuickSort(getOtherSorted(), getSize());
        for(ArrayList<Movie> bucket  : buckets){
            mergesort = new MergeSort(bucket, bucket.size());
            mergesort.divideArrayElements(0, bucket.size() - 1);

//            quickSort.quickShort(0, size-1);
        }



        for(ArrayList<Movie> bucket : buckets) {
            sortedArray.addAll(bucket);
        }

    }




    public int getSize() {
        return size;
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

            try {
                otherSort();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stop();
        }
    }

}