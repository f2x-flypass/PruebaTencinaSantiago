package com.test.santiago.financial.entity.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utils {
    public static Integer getAge(Date date){
        String format = "dd/MM/yyyy";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(format);
        LocalDate fechaNac = LocalDate.parse(converDateToString(date, format), fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);

        System.out.printf("Tu edad es: %s años, %s meses y %s días",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());
        return periodo.getYears();
    }

    public static String converDateToString(Date dateIn, String format) {
        SimpleDateFormat spdf = new SimpleDateFormat(format);
        try {
            dateIn = spdf.parse(spdf.format(dateIn));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return spdf.format(dateIn);
    }
    public static int getEightDigitsNumber() {
        double fiveDigits = 00000000 + Math.random() * 99999999;
        return (int) fiveDigits;
    }
}
