/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Sonia
 */
public class DataUtil {
    
    public static Calendar parseDate(java.sql.Date date) {
        
        if(date == null) {
            return null;
        }
        
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        
        return cal;
        
    }
    
    public static String formatDate(Calendar cal) {
    
        if(cal == null) {
            return null;
        }
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(cal.getTime());
    
    }
    
}
