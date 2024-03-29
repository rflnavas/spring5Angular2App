package com.bolsadeideas.springboot.backend.apirest.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.bolsadeideas.springboot.backend.apirest.config.JWTConfigProperties;

/**
 * Tenemos que realizar una doble autenticación. No sólo autetica mos los
 * usuarios sino también las aplicaciones a las que se conectan con el Back
 * 
 * @author rafael.navas
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServeConfig extends AuthorizationServerConfigurerAdapter {

	private static final int ONE_HOUR = 60 * 60;
	private static final int ONE_DAY = ONE_HOUR * 24;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	@Qualifier("authManager")
	private AuthenticationManager authManager;
	
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	@Autowired
	private TokenEnhancerImpl tokenEnhancer;
	
	@Autowired
	private JWTConfigProperties jwtConfigProps;

	/**
	 * Validar la aplicacion
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()");
			
	}
	/**
	 * Validar clientes
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory().withClient("angularApp")
			.secret(passwordEncoder.encode("12345"))
			.scopes("read", "write")
			.authorizedGrantTypes("password", "refresh_token")
			.accessTokenValiditySeconds(ONE_HOUR)
			.refreshTokenValiditySeconds(ONE_DAY);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer, accessTokenConverter()));
		/*
		 * accessTokenConverter : Componente encargada de manejar varia cosas
		 * relacionadas con el token y traducir valores codificados dentro de JWT.
		 * Tambien de validar el token de acceso y que las firmas sean correctas.
		 */
		endpoints.authenticationManager(authManager)
				.tokenStore(tokenStore())
				.userDetailsService(appUserDetailsService)
				.accessTokenConverter(accessTokenConverter())
				.tokenEnhancer(tokenEnhancerChain);
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		//Siempre se guarda en el lado del servidor y NO del cliente.
		jwtAccessTokenConverter.setSigningKey(jwtConfigProps.getPrivateKey());
		jwtAccessTokenConverter.setVerifierKey(jwtConfigProps.getPublicKey());
		return jwtAccessTokenConverter;
	}

}
