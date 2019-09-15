package com.bolsadeideas.springboot.backend.apirest.auth;

import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Securizar por el lado de OAUTH2
 * @author rafael.navas
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//From most specific paths/permissions to most generic ones.
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/clients", "/api/clients/page/**", "api/uploads/img/**").permitAll()
			//Some of this secutirty configs will be moved to the controllers themselves.
			//.antMatchers(HttpMethod.GET, "/api/clients/{id}").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/api/clients/upload").hasAnyRole("USER", "ADMIN")
			//.antMatchers(HttpMethod.POST, "/api/clients").hasRole("ADMIN")
			.antMatchers("/api/clients/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("https://localhost:4200"));
        configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("Content-type", "Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return filter;
	}

}
