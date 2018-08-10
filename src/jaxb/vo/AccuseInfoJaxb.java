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
public class AccuseInfoJaxb {

    private String numeroAutorisationMouvementPortuaire;
    private String code;
    private String description;
    private String referenceBonSortie;

     public String getReferenceBonSortie() {
        return referenceBonSortie;
    }

    public void setReferenceBonSortie(String referenceBonSortie) {
        this.referenceBonSortie = referenceBonSortie;
    }

    public String getNumeroAutorisationMouvementPortuaire() {
        return numeroAutorisationMouvementPortuaire;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumeroAutorisationMouvementPortuaire(String numeroAutorisationMouvementPortuaire) {
        this.numeroAutorisationMouvementPortuaire = numeroAutorisationMouvementPortuaire;
    }

    @Override
    public String toString() {
        return "numeroAutorisationMouvementPortuaire=" + numeroAutorisationMouvementPortuaire + ", code=" + code + ", description=" + description;
    }

}
