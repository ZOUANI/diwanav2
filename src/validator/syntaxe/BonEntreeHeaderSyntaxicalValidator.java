/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.syntaxe;

import java.util.Arrays;
import java.util.List;
import jaxb.vo.HeaderJaxb;

/**
 *
 * @author YOUNES
 */
public class BonEntreeHeaderSyntaxicalValidator {

    private static final List<String> EMMETEUR_DEFAULT = Arrays.asList("TMSA");
    private static final List<String> DISTINATAIRE_DEFAULT = Arrays.asList("ADII");
    private static final List<String> TYPE_MESSAGE_DEFAULT = Arrays.asList("BON_ENTREE");

     public static List<Object[]> validate(HeaderJaxb headerJaxb, boolean bonEntree) {
        List<Object[]> res = HeaderSyntaxicalValidator.validate(headerJaxb);
        if (bonEntree) {
            res.add(validateEmeteurDefaultValue(headerJaxb.getEmetteur()));
            res.add(validateDistinataireDefaultValue(headerJaxb.getDestinataire()));
            res.add(validatetTpeMessageDefaultValue(headerJaxb.getTypeMessage()));
        }

        return res;
    }

    private static Object[] validateEmeteurDefaultValue(String emeteur) {
        return SyntaxicalValidator.validateExistMandatoryStyle(emeteur, EMMETEUR_DEFAULT.indexOf(emeteur) != -1, "emeteurDefaultValue");
    }

    private static Object[] validatetTpeMessageDefaultValue(String typeMessage) {
        return SyntaxicalValidator.validateExistMandatoryStyle(typeMessage, TYPE_MESSAGE_DEFAULT.indexOf(typeMessage) != -1, "typeMessageDefaultValue");
    }

    private static Object[] validateDistinataireDefaultValue(String distinataire) {
        return SyntaxicalValidator.validateExistMandatoryStyle(distinataire, DISTINATAIRE_DEFAULT.indexOf(distinataire) != -1, "distinataireDefaultValue");
    }
}
