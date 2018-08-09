/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo.ack;

/**
 *
 * @author YOUNES
 */
public class AccuseReceptionBonEntreeInfoJaxb extends AccuseInfoJaxb {

    private String numeroAutorisationMouvementPortuaire;

    public String getNumeroAutorisationMouvementPortuaire() {
        return numeroAutorisationMouvementPortuaire;
    }

    public void setNumeroAutorisationMouvementPortuaire(String numeroAutorisationMouvementPortuaire) {
        this.numeroAutorisationMouvementPortuaire = numeroAutorisationMouvementPortuaire;
    }

    @Override
    public String toString() {
        return "numeroAutorisationMouvementPortuaire=" + numeroAutorisationMouvementPortuaire + ", code=" + code + ", description=" + description;
    }

}
