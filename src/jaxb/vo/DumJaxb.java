package jaxb.vo;

import javax.xml.bind.annotation.XmlElement;

public class DumJaxb {

    protected String referenceDUM;
    private String reference;

    @XmlElement(name = "reference")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Obtient la valeur de la propriété referenceDUM.
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "referenceDUM")
    public String getReferenceDUM() {
        return referenceDUM;
    }

    /**
     * Définit la valeur de la propriété referenceDUM.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setReferenceDUM(String value) {
        this.referenceDUM = value;
    }

    @Override
    public String toString() {
        return "referenceDUM=" + referenceDUM;
    }

}
