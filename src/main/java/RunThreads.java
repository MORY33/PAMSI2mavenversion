import java.io.IOException;

public class RunThreads {
    Movie Object = new Movie();
    Sortit newShort = new Sortit();
    public void runThreads() throws IOException {

//        Movie tempList = new Movie();

        newShort.myMovies = Object.CreateList();
        Object.printList(newShort.myMovies);

        Runnable[] runners = new Runnable[4];
        Thread[] threads = new Thread[4];

        runners[0] = new Sortit(Object.CreateList(), Algorithm.QUICKSORT);
        runners[1] = new Sortit(Object.CreateList(), Algorithm.MERGESORT);
        runners[2]= new Sortit(Object.CreateList(), Algorithm.OTHERSORT);
        runners[3] = new Sortit(Object.CreateList(), Algorithm.COMPARE);

        //creates and run all threads
        for (int i=0; i<4; i++){
            threads[i] = new Thread(runners[i]);
        }

        for (int i=0; i<4; i++){
            threads[i].start();
        }


//       Object.printList(tempoList);
        System.out.println("Wątki odpalone, mozna miec wyjebane");
    }
}
