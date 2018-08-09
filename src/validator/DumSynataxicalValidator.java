/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.List;
import jaxb.vo.DumJaxb;
import jaxb.vo.DumsJaxb;

/**
 *
 * @author YOUNES
 */
public class DumSynataxicalValidator {

    public static List<Object[]> validate(DumsJaxb dumsJaxb) {
        List<Object[]> res = new ArrayList();
        List<DumJaxb> dums = dumsJaxb.getDumJaxbs();
        if (dums == null || dums.isEmpty()) {
            res.add(new Object[]{1, ""}); // bdeleha a zine
            return res;
        }
        for (DumJaxb dum : dums) {
            res.add(validateRefDum(dum.getReferenceDUM()));
        }
        return res;

    }

    public static List<Object[]> validate(DumJaxb dumJaxb) {
        List<Object[]> res = new ArrayList();
        res.add(validateRefDum(dumJaxb.getReferenceDUM()));
        return res;

    }

    public static Object[] validateRefDum(String refDum) {
        return SyntaxicalValidator.isValideNumberLenghtAndMandatoryExist(refDum, 17, true, "referenceDUM");
    }

}
