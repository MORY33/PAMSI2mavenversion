import java.io.IOException;
import java.util.ArrayList;


public class OtherSort implements Runnable {
    private final int size;
    private final int bucketsQuantity;
    private final double max;
    public long elapsedTime;
    private final ArrayList<Movie> otherSorted;

    public ArrayList<ArrayList<Movie>> buckets;

    ArrayList<Movie> sortedArray = new ArrayList<>();

    public boolean exit;

    public OtherSort(ArrayList<Movie> otherSorted, int size){
        this.otherSorted = otherSorted;
        this.size = size;
        bucketsQuantity = (int) Math.sqrt(otherSorted.size());
        max =  findMax();
        buckets = new ArrayList<>(bucketsQuantity);
        for(int i=0; i<bucketsQuantity;i++){
            buckets.add(new ArrayList<>());
        }
    }



    public void otherSort() throws IOException {

        for (Movie i : getOtherSorted()) {
            buckets.get(hash(i.getRating(), max, bucketsQuantity)).add(i);
        }

        for(ArrayList<Movie> bucket  : buckets){
            MergeSort mergesort = new MergeSort(bucket, bucket.size());
            mergesort.divideArrayElements(0, bucket.size() - 1);
        }



        for(ArrayList<Movie> bucket : buckets) {
            sortedArray.addAll(bucket);
        }

    }


    private double findMax() {
        double m = Integer.MIN_VALUE;
        for (Movie i : otherSorted) {
            m = Math.max(i.getRating(), m);
        }
        return m;
    }

    private int hash(double i, double max, int numberOfBuckets) {
        return (int) ( i / max * (numberOfBuckets - 1));
    }



    public ArrayList<Movie> getOtherSorted() {
        return otherSorted;
    }

    public ArrayList<Movie> getSortedArray() {
        return sortedArray;
    }

    public int getSize() {
        return size;
    }



    public void stop()
    {
        exit = true;
    }

    public double getTime(){
        return elapsedTime*Math.pow(10, -6);
    }


    public boolean isSorted(){
        boolean sorted = false;
        for (int i = 0; i < getSortedArray().size() -1; i++) {
            if(getSortedArray().get(i).getRating() > getSortedArray().get(i+1).getRating()){
                return sorted;
            }
        }
        return true;
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
                long start = System.nanoTime();
                otherSort();
                elapsedTime = System.nanoTime() - start;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stop();
        }
    }

}