import java.util.ArrayList;

public class MergeSort implements Runnable{
    private final int size;
    private final ArrayList<Movie> mergeSorted;

    public boolean exit;

    public long elapsedTime;

    public MergeSort(ArrayList<Movie> mergeSorted, int size){
        this.mergeSorted = mergeSorted;
        this.size = size;
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

        ArrayList<Movie> tempArray = new ArrayList<>();

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


    public boolean isSorted(){
        boolean sorted = false;
        for (int i = 0; i < getMergeSorted().size() -1; i++) {
            if(getMergeSorted().get(i).getRating() > getMergeSorted().get(i+1).getRating()){
                return sorted;
            }
        }
        return true;
    }

    public void stop()
    {
        exit = true;
    }

    public double getTime(){
       return elapsedTime*Math.pow(10, -6);
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Movie> getMergeSorted() {
        return mergeSorted;
    }



    @Override
    public void run() {
        while(!exit){

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            long start = System.nanoTime();
            divideArrayElements(0, size - 1);
            elapsedTime = System.nanoTime() - start;
            stop();
        }
    }


}

