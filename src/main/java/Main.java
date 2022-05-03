import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Sortit shortit = new Sortit(1);
        shortit.runThreads();



//        Movie tempList = new Movie();
//        tempList.CreateList();
//        Menu menu = new Menu();
////        menu.menu();
//        tempList.printList(tempList.CreateList());
//
//        Runnable[] runners = new Runnable[3];
//        Thread[] threads = new Thread[3];
//
////        for (int i=0; i<3; i++){
////            runners[i] = new Sortit(i);
////        }
//        runners[0] = new Sortit(tempList.CreateList(), Algorithm.QUICKSORT);
//        runners[1] = new Sortit(tempList.CreateList(), Algorithm.MERGESORT);
//        runners[2]= new Sortit(tempList.CreateList(), Algorithm.OTHERSORT);
//
//
//
////        Sortit tempQuick = new Sortit(tempList.CreateList(), Algorithm.QUICKSORT);
////        Sortit tempMerge = new Sortit(tempList.CreateList(), Algorithm.QUICKSORT);
////        Sortit tempOther = new Sortit(tempList.CreateList(), Algorithm.QUICKSORT);
////
////        tempQuick = (Sortit) runners[0];
////        tempMerge = (Sortit) runners[1];
////        tempOther = (Sortit) runners[2];
////
////        tempOther.quickSort();
//
//
//        //tworzy i odpala wszystkie wątki
//        for (int i=0; i<3; i++){
//            threads[i] = new Thread(runners[i]);
//        }
//
//        for (int i=0; i<3; i++){
//            threads[i].start();
//        }

//        Sortit shortItMerge = new Sortit(tempList.CreateList(), Algorithm.MERGESORT);
//
//        if (shortItMerge.mergeSort() == 0){
//            threads[1].stop();
//            System.out.println("Thread killed");
//        }









    }
}
