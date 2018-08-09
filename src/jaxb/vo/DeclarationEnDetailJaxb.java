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
public class DeclarationEnDetailJaxb {

    private String referenceDUM;
    private String numVoyage;
    private String natureMarchandise;
    private String annexe;

    public String getReferenceDUM() {
        return referenceDUM;
    }

    public void setReferenceDUM(String referenceDUM) {
        this.referenceDUM = referenceDUM;
    }

    public String getNumVoyage() {
        return numVoyage;
    }

    public void setNumVoyage(String numVoyage) {
        this.numVoyage = numVoyage;
    }

    public String getNatureMarchandise() {
        return natureMarchandise;
    }

    public void setNatureMarchandise(String natureMarchandise) {
        this.natureMarchandise = natureMarchandise;
    }

    public String getAnnexe() {
        return annexe;
    }

    public void setAnnexe(String annexe) {
        this.annexe = annexe;
    }

    @Override
    public String toString() {
        return "DeclarationEnDetail [referenceDUM = " + referenceDUM + ", numVoyage = " + numVoyage + ", natureMarchandise = " + natureMarchandise + ", annexe = " + annexe + "]";
    }
}
