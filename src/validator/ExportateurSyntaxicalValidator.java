/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.List;
import jaxb.vo.OperateurJaxb;

/**
 *
 * @author YOUNES
 */
public class ExportateurSyntaxicalValidator {

    public static List<Object[]> validate(OperateurJaxb exportateurJaxb) {
        List<Object[]> res = new ArrayList();
        res.addAll(OperatorSynataxicalValidator.validate(exportateurJaxb,"Exportateur"));
        res.add(validatePoidsBrut(exportateurJaxb.getPoidsBrut()));
        res.add(validateValeurDeclaree(exportateurJaxb.getValeurDeclaree()));
        res.add(validateNombreContenant(exportateurJaxb.getNombreContenant()));
        return res;

    }

    private static Object[] validatePoidsBrut(String poidsBrut) {
        return SyntaxicalValidator.isValideDecimalLenghtAndMandatoryExist(poidsBrut, 9, 3, false, "poidsBrut");
    }

    private static Object[] validateValeurDeclaree(String valeureDeclaree) {
        return SyntaxicalValidator.isValideDecimalLenghtAndMandatoryExist(valeureDeclaree, 9, 3, false, "valeureDeclaree");
    }

    private static Object[] validateNombreContenant(String nombreContenant) {
        return SyntaxicalValidator.isValideNumberLenghtAndMandatoryExist(nombreContenant, 9, false, "nombreContenant");
    }

}
