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
public class UniteJaxb {

    protected String typeUnite;
    protected String sousTypeUnite;
    protected String numUnite;
    protected String numTracteur;
    protected String numPlateau;

    /**
     * Obtient la valeur de la propriété typeUnite.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "typeUnite")
    public String getTypeUnite() {
        return typeUnite;
    }

    /**
     * Définit la valeur de la propriété typeUnite.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setTypeUnite(String value) {
        this.typeUnite = value;
    }

    /**
     * Obtient la valeur de la propriété sousTypeUnite.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "sousTypeUnite")
    public String getSousTypeUnite() {
        return sousTypeUnite;
    }

    /**
     * Définit la valeur de la propriété sousTypeUnite.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setSousTypeUnite(String value) {
        this.sousTypeUnite = value;
    }

    /**
     * Obtient la valeur de la propriété numUnite.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "numUnite")
    public String getNumUnite() {
        return numUnite;
    }

    /**
     * Définit la valeur de la propriété numUnite.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNumUnite(String value) {
        this.numUnite = value;
    }

    /**
     * Obtient la valeur de la propriété numTracteur.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "numTracteur")
    public String getNumTracteur() {
        return numTracteur;
    }

    /**
     * Définit la valeur de la propriété numTracteur.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNumTracteur(String value) {
        this.numTracteur = value;
    }

    /**
     * Obtient la valeur de la propriété numPlateau.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "numPlateau")
    public String getNumPlateau() {
        return numPlateau;
    }

    /**
     * Définit la valeur de la propriété numPlateau.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNumPlateau(String value) {
        this.numPlateau = value;
    }

    @Override
    public String toString() {
        return "typeUnite=" + typeUnite + ", sousTypeUnite=" + sousTypeUnite + ", numUnite=" + numUnite
                + ", numTracteur=" + numTracteur + ", numPlateau=" + numPlateau;
    }

}
