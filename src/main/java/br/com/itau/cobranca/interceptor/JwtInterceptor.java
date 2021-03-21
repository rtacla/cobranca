package br.com.itau.cobranca.interceptor;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.com.itau.cobranca.exception.CobrancaException;

public class JwtInterceptor implements HandlerInterceptor {

	private String jwtSecret;

	private static final String ISSUER = "www.itau.com.br";    

	public JwtInterceptor(String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		this.checkJwt(request);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {}

	private void checkJwt(HttpServletRequest request) throws UnsupportedEncodingException {
		String jwtHeader = request.getHeader("Authorization");
		if(jwtHeader==null || jwtHeader.isEmpty()) {
			throw new CobrancaException("Autenticacao Requerida");
		}

		jwtHeader = jwtHeader.replace("Bearer ", "");

		Algorithm algorithmHS = Algorithm.HMAC256(jwtSecret);
		JWTVerifier verifier = JWT.require(algorithmHS).withIssuer(ISSUER).build();
		try {
			DecodedJWT jwt = verifier.verify(jwtHeader);
			if(jwt==null) {
				throw new CobrancaException("Autenticacao Invalida");
			}

		} catch (TokenExpiredException te) {
			throw new CobrancaException("Autenticacao Invalida, token expirado");
		}
	}

}
