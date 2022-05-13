import javax.management.StringValueExp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Movie {
    private double rating;
    private String title;

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;

    }
    public Movie() {
        this.title = title;
        this.rating = rating;

    }


    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }


//    public ArrayList<Movie> CreateList() throws IOException {
//        Movie tempMovie = new Movie();
//        Movie oneMovie = new Movie();
//
//
//        ArrayList<Movie> movieList = new ArrayList<Movie>();
//
//
//
//        String path = "C:\\Users\\rafal\\Documents\\STUDIA\\SEM4\\PAMSI\\PAMSI2mavenversion\\src\\main\\java\\Zeszyt1.csv";
//
////        C:\Users\rafal\Documents\STUDIA\SEM4\PAMSI\PAMSI2mavenversion\src\main\java
//        String line = null;
//
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(path));
//            while ((line = br.readLine()) != null) {
//                if(line.trim().indexOf("movie") == 1)
//                    continue;
//                String[] values = line.split(",");
//
//                if (2 > values.length){
//                    continue;
//                }
//                else{
//                    tempMovie.setTitle(values[0]);
//                    tempMovie.setRating(Integer.parseInt(values[1]));
//                    oneMovie = new Movie(tempMovie.getTitle(), tempMovie.getRating());
//                    movieList.add(oneMovie);
//                }
//
//            }
//        }
//        catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return movieList;
//    }

    public ArrayList<Movie> CreateList(int row) throws IOException {
        Movie tempMovie = new Movie();
        Movie oneMovie = new Movie();

//        int row = 5;

        ArrayList<Movie> movieList = new ArrayList<Movie>();



        String path = "C:\\Users\\rafal\\Documents\\STUDIA\\SEM4\\PAMSI\\PAMSI2mavenversion\\src\\main\\java\\dane.csv";



        String line = null;
        int counter = 0;
        int regexCounter = 0;
        String title = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null && counter < row) {
                if(line.trim().indexOf("movie") == 0 || line.trim().indexOf("movie") == 1 || line.trim().indexOf("movie") == 2)
                    continue;

                String[] values = line.split(",");
                String helpful;

                if (values[values.length-1]=="" || !values[values.length-1].endsWith(".0")){
                    continue;
                }

                else if (values.length > 3 && values[values.length-1]!= ""){
//                    tempMovie.setTitle(values[1] + values[values.length-2]);

                    for (int i=1; i<= values.length-2;i++){
                        helpful = values[i];
                        title += helpful;
                    }
                    tempMovie.setRating(Double.parseDouble(values[values.length - 1]));
                    tempMovie.setTitle(title);
                    oneMovie = new Movie(tempMovie.getTitle(), tempMovie.getRating());
                    movieList.add(oneMovie);
                }
                else if (3 > values.length || values[1]=="" || values[2]==""){
                    continue;
                }
                else{
                    tempMovie.setTitle(values[1]);
                    tempMovie.setRating(Double.parseDouble(values[2]));
                    oneMovie = new Movie(tempMovie.getTitle(), tempMovie.getRating());
                    movieList.add(oneMovie);
                }
                counter ++;
                title ="";
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
