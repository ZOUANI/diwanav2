/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.convertor;

import jaxb.vo.AbstractJaxbObject;
import jaxb.vo.BonEntreeJaxb;
import jaxb.vo.BonSortieJaxb;

/**
 *
 * @author YOUNES
 */
public class AccuseJaxbHelperFactory {

    public static AccuseJaxbHelper construct(String name, AbstractJaxbObject myObject) {
        if (name.equals("BE")) {
            return new BonEntreeAccuseJaxbHelper((BonEntreeJaxb) myObject);
        } else if (name.equals("BS")) {
            return new BonSortieAccuseJaxbHelper((BonSortieJaxb) myObject);
        } else if (name.equals("EC")) {
            return new EtatChargementAccuseJaxbHelper();
        }
        return null;
    }
}
