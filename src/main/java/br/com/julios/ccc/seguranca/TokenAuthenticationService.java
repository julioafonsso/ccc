package br.com.julios.ccc.seguranca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
	
	
	static final long ONE_MINUTE = 60000;
	static final long EXPIRATION_TIME = ONE_MINUTE * 60 * 8;
	static final String SECRET = "MySecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";

	static void addAuthentication(HttpServletResponse response, String username) {
		String JWT = Jwts.builder()
						.setSubject(username)
						.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
						.signWith(SignatureAlgorithm.HS512, SECRET)
						.compact();

		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
		response.addHeader("Access-Control-Expose-Headers", HEADER_STRING);
		
	}

	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);

		if (token != null) {
			String user = Jwts.parser()
							.setSigningKey(SECRET)
							.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
							.getBody()
							.getSubject();

			
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, roles);
			}
		}
		return null;
	}

}
