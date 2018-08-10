package br.com.mpr.admin.controllers;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class BaseController {


    @InitBinder
    public void binder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true){

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try{
                    super.setAsText(text);
                }catch (IllegalArgumentException ex) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date d;
                    try {
                        d = sdf.parse(text);
                        setValue(d);
                    } catch (ParseException e) {
                        throw new IllegalArgumentException("Could not parse date: " + e.getMessage(), e);
                    }
                }

            }
        });
        Locale ptBR = new Locale("pt", "BR");
        NumberFormat numberFormat =
                NumberFormat.getNumberInstance(ptBR); //para números
        binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, numberFormat, true));
    }


}
