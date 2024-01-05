/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author DOUGLAS
 */
public class FuncaoData {
    public static Date transformarEmDate(String data) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date date = (Date) formatter.parse(data);
        return date;
    }
    
    public static int diferencaData(String data1, String data2) throws ParseException {//(data1 - data2) sendo data1 maior que data2;
        int diferenca = 0;

        Date datamaior = transformarEmDate(data1);
        Date datamenor = transformarEmDate(data2);
        String a = "" + datamenor;
        String b = datamaior + "";
        while (!a.equals(b)) {
            datamenor = somarData(1,datamenor);
            a=""+datamenor;
            diferenca++;

        }

        return diferenca;
    }

    public static boolean compararData(String data, String data2) {
        boolean result = false;
        String[] aux1 = data.split("/");
        String[] aux2 = data2.split("/");
        int cont = 0;
        if (data != data2) {
            if (Integer.parseInt(aux1[2]) >= Integer.parseInt(aux2[2])) {
                cont++;
                if (Integer.parseInt(aux1[1]) >= Integer.parseInt(aux2[1])) {
                    cont++;
                    if (Integer.parseInt(aux1[0]) >= Integer.parseInt(aux2[0])) {
                        cont++;

                    } else {
                        cont-=3;
                    }
                } else {
                    cont-=2;
                }

            } else {
                cont--;
            }
            if (cont >= 0) {
                result = true;
            }

        }
        return result;
    }

    public static Date somarData(int dias, Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, dias);

        return calendar.getTime();
    }

    public static String getData(Date data) {
        String[] aux;
        String pegames;
        String sdata = "" + data;
        aux = sdata.split(" ");
        sdata = "";
        switch (aux[1]) {
            case "Jan":
                aux[3] = "01";
                break;
            case "Feb":
                aux[3] = "02";
                break;
            case "Mar":
                aux[3] = "03";
                break;
            case "Apr":
                aux[3] = "04";
                break;
            case "May":
                aux[3] = "05";
                break;
            case "Jun":
                aux[3] = "06";
                break;
            case "Jul":
                aux[3] = "07";
                break;
            case "Aug":
                aux[3] = "08";
                break;
            case "Sep":
                aux[3] = "09";
                break;
            case "Oct":
                aux[3] = "10";
                break;
            case "Nov":
                aux[3] = "11";
                break;
            case "Dec":
                aux[3] = "12";
                break;
        }
        sdata = aux[2] + "/" + aux[3] + "/" + aux[5];
        return sdata;
    }

}
