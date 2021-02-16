package cinema.controller;

import cinema.dto.MovieRequestDto;
import cinema.dto.MovieResponseDto;
import cinema.model.Movie;
import cinema.service.MovieService;
import cinema.service.mapper.MovieMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
        this.movieService = movieService;
    }

    @PostMapping
    public void create(@RequestBody MovieRequestDto movieRequestDto) {
        Movie movie = movieMapper.requestDtoToMovie(movieRequestDto);
        movieService.add(movie);
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapper::movieToResponseDto)
                .collect(Collectors.toList());
    }
}
