package tenders.server.configuration.security;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import tenders.server.configuration.security.filter.AuthTokenFilter;
import tenders.server.service.UserService;

@org.springframework.context.annotation.Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
  private final UserService userService;

  @Bean
  public AuthTokenFilter getJWTAuthTokenFilter() {
    return new AuthTokenFilter(userService);
  }

  @SneakyThrows
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) {
    http
      .cors()
      .and()
      .csrf()
      .disable()
      .addFilterBefore(getJWTAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class)
      .authorizeHttpRequests()
      .requestMatchers("/users/**")
      .permitAll()
      .and()
      .authorizeHttpRequests()
      .requestMatchers("/**")
      .authenticated()
      ;
//      .and()
//      .authorizeHttpRequests()
//      .anyRequest()
//      .authenticated()
//      .and()
//      .httpBasic();

    return http.build();
  }
}
