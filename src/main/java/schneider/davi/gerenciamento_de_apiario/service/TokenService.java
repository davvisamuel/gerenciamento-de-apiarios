package schneider.davi.gerenciamento_de_apiario.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import schneider.davi.gerenciamento_de_apiario.domain.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${security.jwt.secret}")
    private String secret;

    public String generationToken(User user) {
        var algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("gerenciamento-de-apiario")
                .withSubject(user.getId().toString())
                .withExpiresAt(genExpiresAt())
                .sign(algorithm);
    }

    public Instant genExpiresAt() {
        return LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-03:00"));
    }

}
