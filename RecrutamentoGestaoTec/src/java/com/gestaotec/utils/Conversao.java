package com.gestaotec.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Acer
 */

public class Conversao {
    public static Date converterData(String data) throws ParseException{
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    if(data == null || data.trim().equals("")){
        return null;
    } else{
        Date date = fmt.parse(data);
        return date;
    }
    }



public static String data2String(Date data){
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatada = fmt.format(data);
    return dataFormatada;
    }

public static Date dataAtual() {
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    Date novaData = new Date(System.currentTimeMillis());
    return novaData;
    }
}