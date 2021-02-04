package cinema;

import cinema.exception.AuthenticationException;
import cinema.lib.Injector;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.ShoppingCart;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import cinema.service.ShoppingCartService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector = Injector.getInstance("cinema");

    public static void main(String[] args) throws AuthenticationException {
        Movie movie1 = new Movie();
        movie1.setTitle("Fast and Furious");
        movie1.setDescription("Vin Diesel teaches everyone how to live by "
                + "saying some bulls**t lines, + cars explode everywhere");
        MovieService movieService = (MovieService)
                injector.getInstance(MovieService.class);
        movieService.add(movie1);
        Movie movie2 = new Movie();
        movie2.setTitle("Big Lebowski");
        movie2.setDescription("Lebowski teaches everyone how to live without saying it"
                + " - not like Vin Diesel");
        movieService.add(movie2);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(10);

        CinemaHallService cinemaHallService = (CinemaHallService)
                injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(cinemaHall);

        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie2);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setDate(LocalDateTime.of(2020,2,1, 20,0));
        MovieSessionService movieSessionService = (MovieSessionService)
                injector.getInstance(MovieSessionService.class);
        movieSessionService.add(movieSession);

        System.out.println(movieSessionService
                .findAvailableSessions(movie2.getId(), LocalDate.now()));

        AuthenticationService authenticationService = (AuthenticationService)
                injector.getInstance(AuthenticationService.class);

        String email = "test@test.com";
        String pass = "testPass";
        authenticationService.register(email, pass);
        User user1 = authenticationService.login(email, pass);

        System.out.println(authenticationService.login(email, pass));

        String email1 = "test1@test.com";
        String pass1 = "testPass1";

        authenticationService.register(email1, pass1);
        User user2 = authenticationService.login(email1, pass1);

        ShoppingCartService shoppingCartService = (ShoppingCartService)
                injector.getInstance(ShoppingCartService.class);

        shoppingCartService.addSession(movieSession,user1);
        shoppingCartService.addSession(movieSession, user2);

        ShoppingCart cartByUser = shoppingCartService.getByUser(user1);
        System.out.println(cartByUser);

        shoppingCartService.clear(cartByUser);
        System.out.println(shoppingCartService.getByUser(user1));
    }
}
