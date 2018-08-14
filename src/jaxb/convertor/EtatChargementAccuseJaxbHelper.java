/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.convertor;

import jaxb.vo.AccuseJaxb;

/**
 *
 * @author YOUNES
 */
public class EtatChargementAccuseJaxbHelper extends AccuseJaxbHelper {
    @Override
    public void beforeGenerate(AccuseJaxb accuseJaxb) {
        // accuseJaxb.getInfo().setNumeroAutorisationMouvementPortuaire(etatChargementJaxb.get);
    }

//    @Override
//    public AccuseJaxbHelper getInstance(AbstractJaxbObject accuseJaxb) {
//        return new EtatChargementAccuseJaxbHelper();
//    }

}
