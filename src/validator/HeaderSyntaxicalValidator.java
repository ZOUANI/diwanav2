/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jaxb.vo.HeaderJaxb;
import util.NumberConverter;

/**
 *
 * @author YOUNES
 */
public class HeaderSyntaxicalValidator {

    private static final List<String> CODE_FONCTION_MESSAGES = Arrays.asList("1", "2", "3");

    public static List<Object[]> validate(HeaderJaxb headerJaxb) {
        List<Object[]> res = new ArrayList();
        res.add(validateDateMessage(headerJaxb.getDateMessage()));
        res.add(validateNumeroMessage(headerJaxb.getNumeroMessage()));
        res.add(validateFonctionMessage(headerJaxb.getFonctionMessage()));
        return res;
    }

    private static Object[] validateNumeroMessage(String numeroMessage) {
        return SyntaxicalValidator.validateExistMandatoryStyle(numeroMessage,
                NumberConverter.convertToLongAsBool(numeroMessage, 19, false),
                "numeroMessage");
    }

    private static Object[] validateDateMessage(String dateMessage) {
        return SyntaxicalValidator.validateDateAsObject(dateMessage, "dateMessage", true);
    }

    private static Object[] validateFonctionMessage(String fonctionMessage) {
        return SyntaxicalValidator.validateExistMandatoryStyle(fonctionMessage, CODE_FONCTION_MESSAGES.indexOf(fonctionMessage) != -1, "fonctionMessage");
    }

}
