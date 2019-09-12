package com.bolsadeideas.springboot.backend.apirest.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

public class ResponseUtils {

	private ResponseUtils() {
	}

	public static Map<String, Object> buildValidationErrorResponse(BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			errors = result.getFieldErrors().stream()
					.map(e -> String.format("Field %s %s", e.getField(), e.getDefaultMessage()))
					.collect(Collectors.toList());
			response.put("errors", errors);
		}
		return response;
	}

	public static boolean hasError(Map<String, Object> response) {
		return response.get("errors") != null;
	}

}
