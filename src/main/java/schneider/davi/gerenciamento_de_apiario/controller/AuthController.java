package schneider.davi.gerenciamento_de_apiario.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schneider.davi.gerenciamento_de_apiario.dto.request.AuthLoginRequest;
import schneider.davi.gerenciamento_de_apiario.dto.request.AuthRegisterRequest;
import schneider.davi.gerenciamento_de_apiario.dto.response.AuthLoginResponse;
import schneider.davi.gerenciamento_de_apiario.dto.response.AuthRegisterResponse;
import schneider.davi.gerenciamento_de_apiario.mapper.AuthMapper;
import schneider.davi.gerenciamento_de_apiario.mapper.UserMapper;
import schneider.davi.gerenciamento_de_apiario.service.AuthService;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserMapper userMapper;
    private final AuthMapper authMapper;

    @PostMapping("/register")
    public ResponseEntity<AuthRegisterResponse> register(@RequestBody @Valid AuthRegisterRequest authRegisterRequest) {

        var user = userMapper.toUser(authRegisterRequest);

        var savedUser = authService.save(user);

        var userPostResponse = userMapper.toUserPostResponse(savedUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(userPostResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody @Valid AuthLoginRequest authLoginRequest) {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authLoginRequest.username(), authLoginRequest.password());

        var token = authService.login(usernamePasswordAuthenticationToken);

        var authLoginResponse = authMapper.toAuthLoginResponse(token);

        return ResponseEntity.ok(authLoginResponse);

    }
}
