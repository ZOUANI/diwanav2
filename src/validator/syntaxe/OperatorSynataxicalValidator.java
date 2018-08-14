/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.syntaxe;

import java.util.ArrayList;
import java.util.List;
import jaxb.vo.OperateurJaxb;
import util.NumberConverter;

/**
 *
 * @author YOUNES
 */
public class OperatorSynataxicalValidator {

    public static List<Object[]> validate(OperateurJaxb operateurJaxb,String prefix) {
        List<Object[]> res = new ArrayList();
        res.add(validateNumeroRc(operateurJaxb.getNumeroRC(),prefix));
        res.add(validateCentreRc(operateurJaxb.getCentreRC(),prefix));
        return res;

    }

    private static Object[] validateNumeroRc(String numeroRC,String prefix) {
        return new Object[]{NumberConverter.convertToLongAsInt(numeroRC), "numeroRc"+prefix};
    }

    private static Object[] validateCentreRc(String centreRc,String prefix) {
        return new Object[]{NumberConverter.convertToLongAsInt(centreRc), "centreRc"+prefix};
    }

}
