package tenders.server.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tenders.server.dto.UserDto;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {
  private static final Key HMAC_KEY = new SecretKeySpec(Base64.getDecoder().decode(Secrets.TOKEN_SECRET), SignatureAlgorithm.HS256.getJcaName());

  public static String createToken(UserDto userDto) {
    Instant now = Instant.now();

    return Jwts.builder()
      .claim("name", userDto.getName())
      .claim("login", userDto.getLogin())
      .setSubject("jane")
      .setId(UUID.randomUUID().toString())
      .setIssuedAt(Date.from(now))
      .setExpiration(Date.from(now.plus(43200, ChronoUnit.MINUTES)))
      .signWith(HMAC_KEY)
      .compact();
  }

  public static Jws<Claims> parseToken(String jwtToken) {
    return Jwts.parserBuilder()
      .setSigningKey(HMAC_KEY)
      .build()
      .parseClaimsJws(jwtToken);
  }
}
