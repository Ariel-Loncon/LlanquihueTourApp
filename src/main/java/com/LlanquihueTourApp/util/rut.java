package com.LlanquihueTourApp.util;
import com.LlanquihueTourApp.data.*;

public class rut {
    private String number;

    /**
     *
     * @param numberRUT
     */

    public rut(String numberRUT) {
        if (!numberRUT.matches("^[0-9]{1,2}(\\.?[0-9]{3}){2}-[0-9kK]{1}$")){
            throw new IllegalArgumentException("Formato de RUT invalido");
        }
        this.number = numberRUT;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString(){
        return " " + number;
    }
}
