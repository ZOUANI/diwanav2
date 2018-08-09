/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.List;
import jaxb.vo.UniteJaxb;

/**
 *
 * @author YOUNES
 */
public class UniteSynataxicalValidator {

    public static List<Object[]> validate(UniteJaxb uniteJaxb) {
        List<Object[]> res = new ArrayList();
        res.add(validateNumPlateau(uniteJaxb.getNumPlateau()));
        res.add(validateNumTracteur(uniteJaxb.getNumTracteur()));
        res.add(validateNumUnite(uniteJaxb.getNumUnite()));
        res.add(validateSousTypeUnite(uniteJaxb.getSousTypeUnite()));
        res.add(validateTypeUnite(uniteJaxb.getTypeUnite()));
        return res;

    }

    private static Object[] validateTypeUnite(String typeUnite) {
        return SyntaxicalValidator.isValideStringLenghtAndMandatoryExist(typeUnite, 50, false, "typeUnite");
    }
    private static Object[] validateSousTypeUnite(String soustypeUnite) {
        return SyntaxicalValidator.isValideStringLenghtAndMandatoryExist(soustypeUnite, 50, false, "soustypeUnite");
    }

    private static Object[] validateNumUnite(String numUnite) {
        return SyntaxicalValidator.isValideStringLenghtAndNotMandatoryExist(numUnite, 30, false, "numUnite");
    }
    private static Object[] validateNumTracteur(String numTracteur) {
        return SyntaxicalValidator.isValideStringLenghtAndNotMandatoryExist(numTracteur, 30, false, "numTracteur");
    }
    private static Object[] validateNumPlateau(String numPlateau) {
        return SyntaxicalValidator.isValideStringLenghtAndNotMandatoryExist(numPlateau, 30, false, "numPlateau");
    }

}
