package com.cindyokino.projectmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8"); // texto que quero decodificar e o padrao de decodificacao (UTF-8 é o padrao da web)
		} catch (UnsupportedEncodingException e) {
			return "";
		} // retorna um String decodificado ou uma String vazia se der erro
	}	
}
