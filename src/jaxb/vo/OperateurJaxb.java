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
public class OperateurJaxb {

    private String numeroRC;
    private String centreRC;
    private String navire;
    private String dateHeureVoyage;
    private String poidsBrut;
    private String nombreContenant;
    private String valeurDeclaree;

    public String getPoidsBrut() {
        return poidsBrut;
    }

    public void setPoidsBrut(String poidsBrut) {
        this.poidsBrut = poidsBrut;
    }

    public String getNombreContenant() {
        return nombreContenant;
    }

    public void setNombreContenant(String nombreContenant) {
        this.nombreContenant = nombreContenant;
    }

    public String getValeurDeclaree() {
        return valeurDeclaree;
    }

    public void setValeurDeclaree(String valeurDeclaree) {
        this.valeurDeclaree = valeurDeclaree;
    }

    public String getNavire() {
        return navire;
    }

    public void setNavire(String navire) {
        this.navire = navire;
    }

    public String getDateHeureVoyage() {
        return dateHeureVoyage;
    }

    public void setDateHeureVoyage(String dateHeureVoyage) {
        this.dateHeureVoyage = dateHeureVoyage;
    }

    public String getNumeroRC() {
        return numeroRC;
    }

    public void setNumeroRC(String numeroRC) {
        this.numeroRC = numeroRC;
    }

    public String getCentreRC() {
        return centreRC;
    }

    public void setCentreRC(String centreRC) {
        this.centreRC = centreRC;
    }

    @Override
    public String toString() {
        return " numeroRC = " + numeroRC + ", centreRC = " + centreRC;
    }
}
