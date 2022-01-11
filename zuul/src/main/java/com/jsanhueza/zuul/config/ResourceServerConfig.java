package com.jsanhueza.zuul.config;

import java.util.Arrays;

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

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/uaa/oauth/**").permitAll()
				.antMatchers(HttpMethod.POST ,"/alumno/alumno").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/alumno/alumno/{codigo}").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.GET, "/alumno/alumnos/").hasAnyRole("ADMIN", "USER")

				.antMatchers(HttpMethod.POST ,"/curso/curso").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/curso/curso/{codigo}").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.GET, "/curso/cursos/").hasAnyRole("ADMIN", "USER")

				.antMatchers(HttpMethod.GET, "/matricula/alumno/{codigo}").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.GET, "/matricula/matricula/alumno/{codigo}").hasAnyRole("ADMIN", "USER")

				.and()
				.cors()
				.configurationSource(corsConfigurationSource());
	}
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("*"));
		corsConfig.setAllowedMethods(Arrays.asList("POST","GET","PUT","DELETE","OPTIONS"));
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedHeaders(Arrays.asList("Authorization","Content-Type"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
