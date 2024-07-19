package com.Training.BankingApp.config;
//
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.http.HttpMethod;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
////
////@EnableMethodSecurity
////@Configuration
////public class SecurityConfig {
////
////
////    @Bean
////    public WebSecurityCustomizer webSecurityCustomizer() {
////        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/swagger-ui.html"));
////    }
////
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////}
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@EnableConfigurationProperties(value = { ApiProperties.class })
//@EnableMethodSecurity
//@Configuration
//class SecurityConfig {
//
//    @Value("${api.security.ignored}")
//    private String[] ignored;
//
//    @Autowired
//    private ApiProperties props;
//
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> {
//            for (String location : props.getIgnored().split(",")) {
//                web.ignoring().requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, location));
//            }
//
//            web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
//            web.ignoring().requestMatchers(new AntPathRequestMatcher("/api/loginAdmin"));
//            web.ignoring().requestMatchers(new AntPathRequestMatcher("/token"));
//
//        };
//    }
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.formLogin(Customizer.withDefaults());
//        http.authorizeHttpRequests(config -> config.anyRequest().authenticated());
//        http.csrf(csrf -> csrf.disable());
//        return http.build();
//    }
//
//
////        @Bean
////    public PasswordEncoder passwordEncoder() {
////      return new BCryptPasswordEncoder();
////
////    }
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.Training.BankingApp.filter.JwtFilter;

@EnableConfigurationProperties(value = { ApiProperties.class })
@EnableMethodSecurity
@Configuration
class SecurityConfig {

    @Value("${api.security.ignored}")
    private String[] ignored;

    @Autowired
    private ApiProperties props;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> {
            for (String location : props.getIgnored().split(",")) {
                web.ignoring().requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, location));
            }

            web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
            web.ignoring().requestMatchers(new AntPathRequestMatcher("/api/loginAdmin"));
            web.ignoring().requestMatchers(new AntPathRequestMatcher("/token"));
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        http.formLogin(Customizer.withDefaults());
        http.authorizeHttpRequests(config -> config
                .anyRequest().authenticated()
        );

        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
