package com.github.sky_vendas.model;

import android.annotation.SuppressLint;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Format implements Serializable{
	private static final long serialVersionUID = -1881160736914356637L;

	public Format() {
	}
	public static String jsonString(String chave, String valor){	
		return "\"" + chave + "\": \"" + valor + "\", \n";
	};
	
	public static String jsonBoolean(String chave, boolean valor){	
		return "\"" + chave + "\": " + valor + ", \n";
	};
	
	public static String jsonDouble(String chave, double valor){	
		return "\"" + chave + "\": " + getString(valor) + ", \n";
	};

	public static String jsonInt(String chave, int valor){	
		return "\"" + chave + "\": " + getString(valor) + ", \n";
	};
	
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
	
    @SuppressLint("SimpleDateFormat")
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
