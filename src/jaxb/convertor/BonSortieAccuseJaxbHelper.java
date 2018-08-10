/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.convertor;

import jaxb.vo.AccuseJaxb;
import jaxb.vo.BonSortieJaxb;

/**
 *
 * @author YOUNES
 */
public class BonSortieAccuseJaxbHelper extends AccuseJaxbHelper {
  private BonSortieJaxb bonEntreeJaxb;

    public BonSortieAccuseJaxbHelper(BonSortieJaxb bonEntreeJaxb) {
        this.bonEntreeJaxb = bonEntreeJaxb;
    }

    @Override
    public void beforeGenerate(AccuseJaxb accuseJaxb) {
        accuseJaxb.getInfo().setReferenceBonSortie(bonEntreeJaxb.getBon().getReferenceBon());
    }

    public BonSortieJaxb getBonSortieJaxb() {
        return bonEntreeJaxb;
    }

    public void setBonSortieJaxb(BonSortieJaxb bonEntreeJaxb) {
        this.bonEntreeJaxb = bonEntreeJaxb;
    }

}
