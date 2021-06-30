package com.zomeli.villanueva.desafiobcp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum CurrencyTypeEnum {

    SOLES("Soles", "PEN"),

    EURO("Euros", "EUR"),

    DOLARES("Dolar Estadounidense", "USD"),

    PESOS_CHILENOS("Pesos Chilenos", "CLP"),

    BOLIVARES("Bolivares", "VEF"),

    YENES_JAPONESES("Yenes Japoneses", "JPY"),

    LIBRAS_ESTERLINAS("Libras Esterlinas", "GBP");


    private String value;
    private String anotherValue;

    CurrencyTypeEnum(String value, String anotherValue) {
	this.value = value;
	this.anotherValue = anotherValue;
    }

    public String toValueString() {
	return String.valueOf(value);
    }
    public String toAnotherValueString() {
	return String.valueOf(anotherValue);
    }

    public static String valueOfLabel(String label) {
	for (CurrencyTypeEnum e : values()) {
	    if (e.anotherValue.equals(label)) {
		return e.value;
	    }
	}
	return null;
    }

}
