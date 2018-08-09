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
public class AccuseReceptionBonSortieInfoJaxb extends AccuseInfoJaxb {

    private String referenceBonSortie;

    public String getReferenceBonSortie() {
        return referenceBonSortie;
    }

    public void setReferenceBonSortie(String referenceBonSortie) {
        this.referenceBonSortie = referenceBonSortie;
    }

    @Override
    public String toString() {
        return "referenceBonSortie=" + referenceBonSortie + ", code=" + code + ", description=" + description;
    }
}
