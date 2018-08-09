/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo;

/**
 *
 * @author YOUNES
 */
public class MoyenTransportJaxb {

    private String immatriculation;
    private String pays;
    private String typeMoyen;
    private String tare;

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTypeMoyen() {
        return typeMoyen;
    }

    public void setTypeMoyen(String typeMoyen) {
        this.typeMoyen = typeMoyen;
    }

    public String getTare() {
        return tare;
    }

    public void setTare(String tare) {
        this.tare = tare;
    }

    @Override
    public String toString() {
        return " [immatriculation = " + immatriculation + ", pays = " + pays + ", typeMoyen = " + typeMoyen + ", tare = " + tare + "]";
    }
}
