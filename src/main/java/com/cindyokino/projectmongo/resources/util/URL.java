package com.cindyokino.projectmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8"); // texto que quero decodificar e o padrao de decodificacao (UTF-8 é o padrao da web)
		} catch (UnsupportedEncodingException e) {
			return "";
		} // retorna um String decodificado ou uma String vazia se der erro
	}
	
	public static Date convertDate(String textDate, Date defaultValue) { // recebe uma data em formato de String, ou uma data com valor padrao caso a outra falhe na conversao
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	try {
		return sdf.parse(textDate);
	} catch (ParseException e) {
		return defaultValue;
	}
	}
}
