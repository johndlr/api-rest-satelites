package com.auroracode.springboot.satelitesRestApi.exception;

public class SateliteErrorResponse {
    private int estatus;
    private String mensaje;

    public SateliteErrorResponse() {
    }

    public SateliteErrorResponse(int estatus, String mensaje) {
        this.estatus = estatus;
        this.mensaje = mensaje;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
