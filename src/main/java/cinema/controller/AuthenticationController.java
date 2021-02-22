package cinema.controller;

import cinema.dto.UserRequestDto;
import cinema.service.AuthenticationService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserRequestDto requestDto) {
        service.register(requestDto.getEmail(), requestDto.getPassword());
    }
}
