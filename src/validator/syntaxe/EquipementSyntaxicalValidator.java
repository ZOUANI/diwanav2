/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.syntaxe;

import java.util.ArrayList;
import java.util.List;
import jaxb.vo.EquipementJaxb;

/**
 *
 * @author YOUNES
 */
public class EquipementSyntaxicalValidator {

    public static List<Object[]> validate(EquipementJaxb equipement) {
        List<Object[]> res = new ArrayList();
        res.add(validateReferenceEquipement(equipement));
        res.add(validateCodeTypeEquipement(equipement));
        return res;
    }

    public static List<Object[]> validate(List<EquipementJaxb> equipements, boolean mandatory) {
        List<Object[]> res = new ArrayList();
        if (equipements == null || equipements.isEmpty()) {
            if (mandatory) {
                res.add(new Object[]{-1, "noItem"});
            } else {
                res.add(new Object[]{1, null});
            }
            return res;
        }
        for (EquipementJaxb equipement : equipements) {
            res.addAll(validate(equipement));
        }
        return res;
    }

    private static Object[] validateReferenceEquipement(EquipementJaxb equipement) {
        return SyntaxicalValidator.isValideStringLenghtAndMandatoryExist(equipement.getReferenceEquipement(), 30, false, "referenceEquipement");
    }

    private static Object[] validateCodeTypeEquipement(EquipementJaxb equipement) {
        return SyntaxicalValidator.isValideStringLenghtAndMandatoryExist(equipement.getTypeEquipement(), 30, false, "codeTypeEquipement");
    }

}
