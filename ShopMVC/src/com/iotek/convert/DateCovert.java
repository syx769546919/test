package com.iotek.convert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

public class DateCovert implements Converter<String, Date> {

	

	@Override
	public Date convert(String arg0) {
		Date date=null;
		DateFormat df=new SimpleDateFormat("yyyy-MM-DD");
		try {
			date=df.parse(arg0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
