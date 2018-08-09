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
public class MarchandiseSousCouvertAutresDocumentsJaxb {

    private String typeDocument;
    private String referenceDocument;
    

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getReferenceDocument() {
        return referenceDocument;
    }

    public void setReferenceDocument(String referenceDocument) {
        this.referenceDocument = referenceDocument;
    }

  

    @Override
    public String toString() {
        return "[typeDoc = " + typeDocument + ", referenceDoc = " + referenceDocument+ "]";
    }
}
