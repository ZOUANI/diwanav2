/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.convertor;

import jaxb.vo.AccuseJaxb;
import jaxb.vo.BonEntreeJaxb;

/**
 *
 * @author YOUNES
 */
public class BonEntreeAccuseJaxbHelper extends AccuseJaxbHelper {

    private BonEntreeJaxb bonEntreeJaxb;

    public BonEntreeAccuseJaxbHelper(BonEntreeJaxb bonEntreeJaxb) {
        this.bonEntreeJaxb = bonEntreeJaxb;
    }

    @Override
    public void beforeGenerate(AccuseJaxb accuseJaxb) {
        accuseJaxb.getInfo().setNumeroAutorisationMouvementPortuaire(bonEntreeJaxb.getAMP().getNumAMP());
    }

    public BonEntreeJaxb getBonEntreeJaxb() {
        return bonEntreeJaxb;
    }

    public void setBonEntreeJaxb(BonEntreeJaxb bonEntreeJaxb) {
        this.bonEntreeJaxb = bonEntreeJaxb;
    }

}
