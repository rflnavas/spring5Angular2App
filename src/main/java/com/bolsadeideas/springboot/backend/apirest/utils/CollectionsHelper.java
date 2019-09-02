package com.bolsadeideas.springboot.backend.apirest.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CollectionsHelper {

	private CollectionsHelper() {
		
	}
	
	public static <T> List<T> toList(final Iterable<T> iterable){
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}
}
