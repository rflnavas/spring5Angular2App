package com.bolsadeideas.springboot.backend.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.backend.apirest.models.entity.User;
import com.bolsadeideas.springboot.backend.apirest.models.services.IUsuarioService;

/**
 * Usado para añadir información adicional al token
 * @author rafael.navas
 *
 */
@Component
public class TokenEnhancerImpl implements TokenEnhancer{

	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = usuarioService.findByUsername(authentication.getName());
		Map<String, Object> data = new HashMap<>();
		data.put("extra", String.format("Hi: %s", authentication.getName()));
		data.put("usuario", String.format("%s:%s", user.getId(), user.getUsername()));
		((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(data);
		return accessToken;
	}

}
