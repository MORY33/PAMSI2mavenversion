import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Movie {
    private int rating;
    private String title;

    public Movie(String title, int rating) {
        this.title = title;
        this.rating = rating;

    }
    public Movie() {
        this.title = title;
        this.rating = rating;

    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }


    public ArrayList<Movie> CreateList() throws IOException {
        Movie tempMovie = new Movie();
        Movie oneMovie = new Movie();

        ArrayList<Movie> movieList = new ArrayList<Movie>();


        String path = "C:\\Users\\rafal\\Documents\\STUDIA\\SEM4\\PAMSI\\PAMSI2mavenversion\\src\\main\\java\\Zeszyt1.csv";

//        C:\Users\rafal\Documents\STUDIA\SEM4\PAMSI\PAMSI2mavenversion\src\main\java
        String line = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if(line.trim().indexOf("movie") == 1)
                    continue;
                String[] values = line.split(",");
//                System.out.println(values[0] + " : " + values[1]);

                if (2 > values.length){
                    continue;
                }
                else{
                    tempMovie.setTitle(values[0]);
                    tempMovie.setRating(Integer.parseInt(values[1]));
                    oneMovie = new Movie(tempMovie.getTitle(), tempMovie.getRating());
                    movieList.add(oneMovie);
                }

            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

//        printList(movieList);
        return movieList;
    }

    public void printList(ArrayList<Movie> list){
        System.out.println(" ");
        for(Movie name: list) {
            System.out.println(name.getTitle() + " : " + name.getRating());
        }
        System.out.println("");
    }








}
