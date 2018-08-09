/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jaxb.vo.DeclarationEnDetailJaxb;
import util.StringUtils;

/**
 *
 * @author YOUNES
 */
public class DeclarationEnDetailSyntaxicalValidator {

    private static final List<String> ANNEXE = Arrays.asList("0", "1");

    public static List<Object[]> validate(DeclarationEnDetailJaxb declarationEnDetail) {
        List<Object[]> res = new ArrayList();
        res.add(validateNumVoyage(declarationEnDetail.getNumVoyage(),declarationEnDetail.getReferenceDUM()));
        res.add(validateReferenceDum(declarationEnDetail.getReferenceDUM()));
        res.add(validateAnnexe(declarationEnDetail.getAnnexe()));
        res.add(validateNatureMarchandise(declarationEnDetail.getNatureMarchandise()));
        return res;
    }

    public static List<Object[]> validate(List<DeclarationEnDetailJaxb> declarationEnDetails, boolean mandatory) {
        List<Object[]> res = new ArrayList();
        if (declarationEnDetails == null || declarationEnDetails.isEmpty()) {
            if (mandatory) {
                res.add(new Object[]{-1, "noItem"});
            } else {
                res.add(new Object[]{1, ""});
            }
            return res;
        }
        for (DeclarationEnDetailJaxb declarationEnDetail : declarationEnDetails) {
            res.addAll(validate(declarationEnDetail));
        }
        return res;
    }

    private static Object[] validateNumVoyage(String numVoyage, String refDum) {
        if (StringUtils.isEmpty(refDum) && numVoyage.equals("0")) {
            return new Object[]{1, ""};
        }
        if (!StringUtils.isEmpty(refDum) && numVoyage.equals("1")) {
            return new Object[]{2, ""};
        }
        return new Object[]{-1, "numVoyage"};
    }

    private static Object[] validateReferenceDum(String refDum) {
        return DumSynataxicalValidator.validateRefDum(refDum);
    }

    private static Object[] validateAnnexe(String annexe) {
        return SyntaxicalValidator.validateExistMandatoryStyle(annexe, ANNEXE.indexOf(annexe) != -1, "annexe");
    }

    private static Object[] validateNatureMarchandise(String natureMarchandise) {
        return SyntaxicalValidator.isValideStringLenghtAndNotMandatoryExist(natureMarchandise, 50, false, "natureMarchandise");
    }

}
