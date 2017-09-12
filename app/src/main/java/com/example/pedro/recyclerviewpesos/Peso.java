package com.example.pedro.recyclerviewpesos;

/**
 * Created by Pedro on 30/08/2017.
 */

public class Peso {
    private String mFecha;
    private String mPeso;

    public Peso(String fecha, String peso) {
        mFecha = fecha;
        mPeso = peso;
    }

    public String getFecha() {
        return mFecha;
    }

    public void setFecha(String fecha) {
        mFecha = fecha;
    }

    public String getPeso() {
        return mPeso;
    }

    public void setPeso(String peso) {
        mPeso = peso;
    }
}
