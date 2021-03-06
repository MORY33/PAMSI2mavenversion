import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Movie {
    private double rating;
    private String title;
    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;

    }
    public Movie() {
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


    public ArrayList<Movie> CreateList(int row){

        Movie tempMovie = new Movie();
        Movie oneMovie;


        ArrayList<Movie> movieList = new ArrayList<>();

        String currentWorkingDir = System.getProperty("user.dir");
        currentWorkingDir+="\\src\\main\\resources\\dane.csv";

//        String path = "C:\\Users\\rafal\\Documents\\STUDIA\\SEM4\\PAMSI\\PAMSI2mavenversion\\src\\main\\resources\\dane.csv";
        String path = currentWorkingDir;

        String line;
        int counter = 0;
        String title = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null && counter < row) {
                if(line.trim().indexOf("movie") == 0 || line.trim().indexOf("movie") == 1 || line.trim().indexOf("movie") == 2)
                    continue;

                String[] values = line.split(",");
                String helpful;

                if (Objects.equals(values[values.length - 1], "") || !values[values.length-1].endsWith(".0")){
                    continue;
                }

                else if (values.length > 3 && !Objects.equals(values[values.length - 1], "")){

                    for (int i=1; i<= values.length-2;i++){
                        helpful = values[i];
                        title += helpful;
                    }
                    tempMovie.setRating(Double.parseDouble(values[values.length - 1]));
                    tempMovie.setTitle(title);
                    oneMovie = new Movie(tempMovie.getTitle(), tempMovie.getRating());
                    movieList.add(oneMovie);
                }
                else if (3 > values.length || Objects.equals(values[1], "") || Objects.equals(values[2], "")){
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
        return movieList;
    }


    public void printList(ArrayList<Movie> list){
        System.out.println(" ");
        for(Movie name: list) {
            System.out.println(name.getTitle() + " : " + name.getRating());
        }
    }








}
