/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.syntaxe;

import java.util.ArrayList;
import java.util.List;
import jaxb.vo.AMPJaxb;

/**
 *
 * @author YOUNES
 */
public class AMPSynataxicalValidator {

    public static List<Object[]> validate(AMPJaxb ampJaxb) {
        List<Object[]> res = new ArrayList();
        res.add(validateNumVersionAMP(ampJaxb.getNumVersionAMP()));
        res.add(validateNumAMP(ampJaxb.getNumAMP()));
        return res;

    }

    private static Object[] validateNumVersionAMP(String numVersionAMP) {
        return SyntaxicalValidator.isValideStringLenghtAndMandatoryExist(numVersionAMP, 2, false,"numVersionAMP");
    }

    private static Object[] validateNumAMP(String numAMP) {
        return SyntaxicalValidator.isValideStringLenghtAndMandatoryExist(numAMP, 30, false, "numAMP");
    }

}
