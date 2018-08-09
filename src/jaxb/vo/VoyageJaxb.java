/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author YOUNES
 */
public class VoyageJaxb {

    private OperateurJaxb transporteur;

    private String navire;
    private String bureauSortie;
    private String dateHeureVoyage;

    @XmlElement(name = "transporteur")
    public OperateurJaxb getTransporteur() {
          if (transporteur == null) {
            transporteur = new OperateurJaxb();
        }
        return transporteur;
    }

    public void setTransporteur(OperateurJaxb transporteur) {
        this.transporteur = transporteur;
    }

    public String getNavire() {
        return navire;
    }

    public void setNavire(String navire) {
        this.navire = navire;
    }

    public String getBureauSortie() {
        return bureauSortie;
    }

    public void setBureauSortie(String bureauSortie) {
        this.bureauSortie = bureauSortie;
    }

    public String getDateHeureVoyage() {
        return dateHeureVoyage;
    }

    public void setDateHeureVoyage(String dateHeureVoyage) {
        this.dateHeureVoyage = dateHeureVoyage;
    }

    @Override
    public String toString() {
        return "[transporteur = " + transporteur + ", navire = " + navire + ", bureauSortie = " + bureauSortie + ", dateHeureVoyage = " + dateHeureVoyage + "]";
    }
}
