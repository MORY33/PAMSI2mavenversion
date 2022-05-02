import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        Movie tempList = new Movie();
        tempList.CreateList();
        Menu menu = new Menu();
//        menu.menu();
        tempList.printList(tempList.CreateList());

        Runnable[] runners = new Runnable[3];
        Thread[] threads = new Thread[3];

//        for (int i=0; i<3; i++){
//            runners[i] = new Sortit(i);
//        }
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
}
