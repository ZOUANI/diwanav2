/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.XMLGregorianCalendar;

public class HeaderJaxb {

    protected String typeMessage;
    protected String fonctionMessage;
    protected String emetteur;
    protected String destinataire;
    protected String numeroMessage;
    protected String dateMessage;

    /**
     * Obtient la valeur de la propriété typeMessage.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "typeMessage")
    public String getTypeMessage() {
        return typeMessage;
    }

    /**
     * Définit la valeur de la propriété typeMessage.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setTypeMessage(String value) {
        this.typeMessage = value;
    }

    /**
     * Obtient la valeur de la propriété fonctionMessage.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "fonctionMessage")
    public String getFonctionMessage() {
        return fonctionMessage;
    }

    /**
     * Définit la valeur de la propriété fonctionMessage.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setFonctionMessage(String value) {
        this.fonctionMessage = value;
    }

    /**
     * Obtient la valeur de la propriété emetteur.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "emetteur")
    public String getEmetteur() {
        return emetteur;
    }

    /**
     * Définit la valeur de la propriété emetteur.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setEmetteur(String value) {
        this.emetteur = value;
    }

    /**
     * Obtient la valeur de la propriété destinataire.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "destinataire")
    public String getDestinataire() {
        return destinataire;
    }

    /**
     * Définit la valeur de la propriété destinataire.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setDestinataire(String value) {
        this.destinataire = value;
    }

    /**
     * Obtient la valeur de la propriété numeroMessage.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "numeroMessage")
    public String getNumeroMessage() {
        return numeroMessage;
    }

    /**
     * Définit la valeur de la propriété numeroMessage.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNumeroMessage(String value) {
        this.numeroMessage = value;
    }

    /**
     * Obtient la valeur de la propriété dateMessage.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     *
     */
    @XmlElement(name = "dateMessage")
    public String getDateMessage() {
        return dateMessage;
    }

    /**
     * Définit la valeur de la propriété dateMessage.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     *
     */
    public void setDateMessage(String value) {
        this.dateMessage = value;
    }

    @Override
    public String toString() {
        return "typeMessage=" + typeMessage + ", fonctionMessage=" + fonctionMessage + ", emetteur=" + emetteur + ", destinataire=" + destinataire
                + ", numeroMessage=" + numeroMessage + ", dateMessage=" + dateMessage;
    }

}
