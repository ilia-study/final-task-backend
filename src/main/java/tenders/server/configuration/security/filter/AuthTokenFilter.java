package tenders.server.configuration.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import tenders.server.service.UserService;
import tenders.server.utils.JwtUtil;

@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {
  public static final String _BEARER = "Bearer ";

  private final UserService userService;

  @SneakyThrows
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
    String headerAuth = request.getHeader(HttpHeaders.AUTHORIZATION);

    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(_BEARER)) {
      String jwtToken = headerAuth.substring(7);

      String username = (String) JwtUtil.parseToken(jwtToken).getBody().get("login");

      UserDetails userDetails = userService.find(username);
      UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(
          userDetails, null, userDetails.getAuthorities());
      authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }
}