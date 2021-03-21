package br.com.itau.cobranca.jwtTest;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtGeneratorTest {
	
	
	private static final String SECRET = "1923810238uoweyroiqwer89183123b1vbavsd";
	
	private static final String EMISSOR = "www.itau.com.br";
	
	@Test
	public void gerarToken() throws UnsupportedEncodingException {
		Algorithm algorithmHS = Algorithm.HMAC256( SECRET );
		String generatedJWT = JWT.create()
        .withIssuedAt(new Date())
        .withExpiresAt(Date.from(Instant.now().plus(Duration.ofMinutes(10))))
        .withIssuer(EMISSOR)
        .sign(algorithmHS);
		log.info("Bearer " + generatedJWT);
		
	}

}
