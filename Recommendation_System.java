import java.util.*;
/* enter your preferred genre name like (Sci-Fi,Action,Drama,Crime,Romance)*/
class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ")";
    }
}

class RecommendationSystem {
    private List<Movie> movieDatabase;

    public RecommendationSystem() {
        movieDatabase = new ArrayList<>();
        loadMovies();
    }

    // Load movies into the database
    private void loadMovies() {
        movieDatabase.add(new Movie("Inception", "Sci-Fi"));
        movieDatabase.add(new Movie("The Godfather", "Crime"));
        movieDatabase.add(new Movie("The Dark Knight", "Action"));
        movieDatabase.add(new Movie("Forrest Gump", "Drama"));
        movieDatabase.add(new Movie("Pulp Fiction", "Crime"));
        movieDatabase.add(new Movie("Interstellar", "Sci-Fi"));
        movieDatabase.add(new Movie("The Shawshank Redemption", "Drama"));
        movieDatabase.add(new Movie("Gladiator", "Action"));
        movieDatabase.add(new Movie("Titanic", "Romance"));
        movieDatabase.add(new Movie("The Notebook", "Romance"));
    }

    // Recommend movies based on user's genre preferences
    public List<Movie> recommendMovies(String preferredGenre) {
        List<Movie> recommendedMovies = new ArrayList<>();
        for (Movie movie : movieDatabase) {
            if (movie.getGenre().equalsIgnoreCase(preferredGenre)) {
                recommendedMovies.add(movie);
            }
        }
        return recommendedMovies;
    }
}

public class Recommendation_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecommendationSystem recommendationSystem = new RecommendationSystem();

        System.out.println("Welcome to the Movie Recommendation System!");
        System.out.print("Enter your preferred genre (e.g., Sci-Fi, Action, Drama): ");
        String preferredGenre = scanner.nextLine();

        List<Movie> recommendations = recommendationSystem.recommendMovies(preferredGenre);

        if (recommendations.isEmpty()) {
            System.out.println("Sorry, we couldn't find any movies matching your preferred genre.");
        } else {
            System.out.println("Here are some movies you might like:");
            for (Movie movie : recommendations) {
                System.out.println("- " + movie);
            }
        }

        scanner.close();
    }
}
