package com.github.skyvendas.service.entitys;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Format {

	public Format() {
	}

    public static String getString(String value) {
        if (value == null) {
            return "";
        }
        return value.trim();
    }
    
    public static String getString(double value){
    	return getString(String.valueOf(value));
    }

    public static String getString(int value){
    	return getString(String.valueOf(value));
    }
	
	public static Calendar getData(String value) {
        if ((value != null) && (!value.isEmpty())) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar dataCadastro = Calendar.getInstance();
            try {
                dataCadastro.setTime(sdf.parse(value));
            } catch (Exception e) {
                //Excecoes.erro(e);
            }
            return dataCadastro;
        } else {
            return Calendar.getInstance();
        }
    }
    
    public static double getDouble(String value, double defval) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            ///Excecoes.erro(e);
            return defval;
        }
    }

    public static double getDouble(Object value, double defval) {
        try {
            return getDouble((String) value, defval);
        } catch (Exception e) {
            //Excecoes.erro(e);
            return defval;
        }
    }
    
    public static int getInt(String value, int defval) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            //Excecoes.erro(e);
            return defval;
        }
    }

    public static int getInt(Object value, int defval) {
        try {
            return getInt((String) value, defval);
        } catch (Exception e) {
            //Excecoes.erro(e);
            return defval;
        }
    }

    public static int getInt(String value) {
        return getInt(value, 0);
    }
}
