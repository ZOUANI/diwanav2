/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jaxb.vo.MarchandiseSousCouvertAutresDocumentsJaxb;

/**
 *
 * @author YOUNES
 */
public class MarchandiseSousCouvertAutresDocumentsSyntaxicalValidator {

    private static final List<String> TYPE_DOCUMENT = Arrays.asList("2", "3", "4", "5", "6");

    public static List<Object[]> validate(MarchandiseSousCouvertAutresDocumentsJaxb marchandiseSousCouvertAutresDocumentsJaxb) {
        List<Object[]> res = new ArrayList();
        res.add(validateTypeDocument(marchandiseSousCouvertAutresDocumentsJaxb.getTypeDocument()));
        res.add(validateRefDocument(marchandiseSousCouvertAutresDocumentsJaxb.getReferenceDocument()));
        return res;

    }

    private static Object[] validateTypeDocument(String typeDocument) {
        return SyntaxicalValidator.validateExistMandatoryStyle(typeDocument, TYPE_DOCUMENT.indexOf(typeDocument) != -1, "typeDocument");
    }

    private static Object[] validateRefDocument(String refDocument) {
        return SyntaxicalValidator.isValideStringLenghtAndNotMandatoryExist(refDocument, 50, true, "refDocument");

    }

}
