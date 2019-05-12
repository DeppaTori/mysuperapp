package com.deppatori.mysuperapp.format;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.springframework.stereotype.Component;

@Component
public class RupiahFormat {
	
	public String format(BigDecimal nilai) {
		DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        decimalFormat.setDecimalFormatSymbols(formatRp);
        
        return decimalFormat.format(nilai);
	}
}
