package jaxb.vo;

import javax.xml.bind.annotation.XmlElement;

public class AMPJaxb {

    protected String numVersionAMP;
    protected String numAMP;

    /**
     * Obtient la valeur de la propriété numVersionAMP.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "numVersionAMP")
    public String getNumVersionAMP() {
        return numVersionAMP;
    }

    /**
     * Définit la valeur de la propriété numVersionAMP.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNumVersionAMP(String value) {
        this.numVersionAMP = value;
    }

    /**
     * Obtient la valeur de la propriété numAMP.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "numAMP")
    public String getNumAMP() {
        return numAMP;
    }

    /**
     * Définit la valeur de la propriété numAMP.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNumAMP(String value) {
        this.numAMP = value;
    }

    @Override
    public String toString() {
        return "numVersionAMP=" + numVersionAMP + ", numAMP=" + numAMP;
    }

}
