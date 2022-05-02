public class MergeSort implements Runnable{
    private int id;
    public MergeSort(int id){
        this.id = id;
        System.out.println("Merge sorting...");
    }



    @Override
    public void run() {
        while(true){
            System.out.println("Wątek " +id);
            System.out.println("Merge sorting...");
            try{
                //sleeping for 100ms
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
