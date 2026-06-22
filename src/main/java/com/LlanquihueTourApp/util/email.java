package com.LlanquihueTourApp.util;

public class email {
    private String email;

    /**
     *
     * @param email
     */

    public email(String email) {
        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,3}$")){
            throw new IllegalArgumentException("Formato de Email invalido");
        }
        this.email = email;
    }


    public String getNumber(){
        return email;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString(){
        return " " + email;
    }
}
