package cinema.controller;

import cinema.dto.CinemaHallRequestDto;
import cinema.dto.CinemaHallResponseDto;
import cinema.model.CinemaHall;
import cinema.service.CinemaHallService;
import cinema.service.mapper.CinemaHallMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/halls")
public class CinemaHallController {
    private final CinemaHallMapper cinemaHallMapper;
    private final CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallMapper cinemaHallMapper,
                                CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @PostMapping
    public void create(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = cinemaHallMapper.requestDtoToCinemaHAll(cinemaHallRequestDto);
        cinemaHallService.add(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::cinemaHallToResponseDto)
                .collect(Collectors.toList());

    }
}
