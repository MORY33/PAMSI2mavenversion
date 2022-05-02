import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        Movie tempList = new Movie();
        tempList.CreateList();
        Menu menu = new Menu();
//        menu.menu();
        tempList.printList(tempList.CreateList());

    }
}
