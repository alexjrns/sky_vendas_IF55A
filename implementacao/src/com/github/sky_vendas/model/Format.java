package com.github.sky_vendas.model;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Format {

	public Format() {
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
}
