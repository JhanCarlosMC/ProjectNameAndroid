package com.projectname.trackingreserva.logic;

import java.io.Serializable;

public class TrackingUser implements Serializable {

    private String fecha;
    private String hora;
    private String user;
    private double latitud;
    private double longitud;
    private String estado;

    public TrackingUser() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUserl() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
