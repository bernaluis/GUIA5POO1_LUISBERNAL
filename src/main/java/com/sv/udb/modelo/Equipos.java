/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author vergo_000
 */
public class Equipos {
    private int codi_equi;
    private String nomb_equi;
    private String desc_equi;

    public Equipos(int codi_equi, String nomb_equi, String desc_equi) {
        this.codi_equi = codi_equi;
        this.nomb_equi = nomb_equi;
        this.desc_equi = desc_equi;
    }

    public Equipos() {
    }

    public int getCodi_equi() {
        return codi_equi;
    }

    public void setCodi_equi(int codi_equi) {
        this.codi_equi = codi_equi;
    }

    public String getNomb_equi() {
        return nomb_equi;
    }

    public void setNomb_equi(String nomb_equi) {
        this.nomb_equi = nomb_equi;
    }

    public String getDesc_equi() {
        return desc_equi;
    }

    public void setDesc_equi(String desc_equi) {
        this.desc_equi = desc_equi;
    }

       @Override
    public String toString() {
        return this.nomb_equi;
    }

}
