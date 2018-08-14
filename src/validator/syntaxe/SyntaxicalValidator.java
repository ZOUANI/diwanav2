/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.syntaxe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.xml.sax.SAXException;
import util.DateUtils;
import util.NumberConverter;
import util.StringUtils;

/**
 *
 * @author YOUNES
 */
public abstract class SyntaxicalValidator<T> {

    private final List<String> errorMessages = new ArrayList();

    public abstract Object[] validate(T myObjectToValidate, String xmlFileName) throws JAXBException, SAXException;

    public abstract void valiadteSyntaxicalRule(T myObjectToValidate);

    public Object[] validate(T myObjectToValidate, String startingFileName, String ref, String dateMessage, String xmlFileName) throws JAXBException, SAXException {
        errorMessages.clear();
        Object[] resValidateXmlFileName = SyntaxicalValidator.splitXmlFileName(new File(xmlFileName).getName(), startingFileName);
        addErrorMessage(resValidateXmlFileName);
        addErrorMessage(validateRef(resValidateXmlFileName, ref));
        addErrorMessage(validateDate(resValidateXmlFileName, dateMessage));
        valiadteSyntaxicalRule(myObjectToValidate);
        if (errorMessages.isEmpty()) {
            return new Object[]{1, "Succes"};
        }
        return new Object[]{-1, (errorMessages).toString()};
    }

    public static Object[] validateDate(Object[] resValidateXmlFileName, String dateMessage) {
        String errorMesage = "xmlFileNameAndDateNotValidMessage";
        if (dateMessage == null) {
            return new Object[]{-1, errorMesage};
        }
        String rowDate = (resValidateXmlFileName[1] + "");
        boolean resDate = compareRowDateWithFormattedDate(rowDate, dateMessage);
        if (!resDate) {
            return new Object[]{-2, errorMesage};
        } else {
            return new Object[]{1, null};
        }
    }

    public static Object[] validateRef(Object[] resValidateXmlFileName, String ref) {
        String errorMesage = "xmlFileNameAndRefContentNotValidMessage";
        if (resValidateXmlFileName[1] == null) {
            return new Object[]{-1, errorMesage};
        }
        String referenceInXml = (resValidateXmlFileName[2] + "").split("\\.")[0];
        if (StringUtils.isEmpty(ref)) {
            return new Object[]{-2, errorMesage};
        }
        boolean resRef = ref.equals(referenceInXml);
        if (!resRef) {
            return new Object[]{-3, errorMesage};
        } else {
            return new Object[]{1, null};
        }
    }

    private static boolean compareRowDateWithFormattedDate(String rowDate, String formattedDate) {
        String[] resFormated = formattedDate.split("T");
        if (resFormated == null || resFormated.length != 2) {
            return false;
        }
        String yMd = resFormated[0];
        String hms = resFormated[1];
        yMd = yMd.replace("-", "");
        hms = hms.replace(":", "");
        return (yMd + hms).equals(rowDate);
    }

    public static Object[] validateExistMandatoryStyle(String attribute, boolean condition, String attributeNameMessage) {
        int exist = StringUtils.isNotEmptyAsInt(attribute);
        int res;
        if (exist > 0) {
            res = condition ? 1 : -1;
        } else {
            res = -2;
        }
        return new Object[]{res, attributeNameMessage};
    }

    public static Object[] validateExistNotMandatoryStyle(String attribute, boolean condition, String attributeNameMessage) {
        boolean isNull = StringUtils.isEmpty(attribute);
        int res;
        if (isNull) {
            res = 2;
        } else {
            res = (condition) ? 1 : -1;
        }
        return new Object[]{res, attributeNameMessage};
    }

    public static Object[] isValideAndMandatoryExist(String mandatory, String element, String attributeName) {
        return validateExistMandatoryStyle(mandatory, element != null, attributeName);
    }

    public static Object[] isValideStringLenghtAndMandatoryExist(String element, int maxSize, boolean exact, String attributeNameMessage) {
        boolean myCondition = constructCondition(element, maxSize, exact);
        return validateExistMandatoryStyle(element, myCondition, attributeNameMessage);
    }

    public static Object[] isValideStringLenghtAndNotMandatoryExist(String element, int maxSize, boolean exact, String attributeNameMessage) {
        boolean myCondition = constructCondition(element, maxSize, exact);
        return validateExistNotMandatoryStyle(element, myCondition, attributeNameMessage);
    }

    private static boolean constructCondition(String element, int maxSize, boolean exact) {
        return (exact ? element != null && element.length() == maxSize : element != null && element.length() <= maxSize);
    }

    public static Object[] isValideNumberLenghtAndMandatoryExist(String element, int maxSize, boolean exact, String attributeNameMessage) {
        return validateExistMandatoryStyle(element, NumberConverter.convertToLongAsBool(element, maxSize, exact), attributeNameMessage);
    }

    public static Object[] isValideNumberLenghtAndNotMandatoryExist(String element, int maxSize, boolean exact, String attributeNameMessage) {
        return validateExistNotMandatoryStyle(element, NumberConverter.convertToLongAsBool(element, maxSize, exact), attributeNameMessage);
    }

    public static Object[] isValideDecimalLenghtAndMandatoryExist(String element, int beforeVirgule, int afterVirgule, boolean exact, String attributeNameMessage) {
        return validateExistMandatoryStyle(element, NumberConverter.convertToDecimalAsBool(element), attributeNameMessage);
    }

    public static Object[] isValideDecimalLenghtAndNotMandatoryExist(String element, int beforeVirgule, int afterVirgule, boolean exact, String attributeNameMessage) {
        return validateExistNotMandatoryStyle(element, NumberConverter.convertToDecimalAsBool(element), attributeNameMessage);
    }

    public static Object[] isValideDecimalLenghtAndNotMandatoryExist(String element, int maxSize, boolean exact, String attributeNameMessage) {
        return validateExistNotMandatoryStyle(element, NumberConverter.convertToDecimalAsBool(element), attributeNameMessage);
    }

    public static Object[] validateDateAsObject(String date, String messageError, boolean mandatory) {
        return validateDateAsObject(date, null, messageError, mandatory);
    }

    public static Object[] validateDateAsObject(String date, String pattern, String messageError, boolean mandatory) {
        if (!StringUtils.isEmpty(date)) {
            boolean condition = DateUtils.parse(date.replace("T", " "), pattern) != null;
            if (mandatory) {
                return SyntaxicalValidator.validateExistMandatoryStyle(date, condition, messageError);
            } else {
                return SyntaxicalValidator.validateExistNotMandatoryStyle(date, condition, messageError);
            }
        } else {
            if (mandatory) {
                return new Object[]{-1, messageError};
            } else {
                return new Object[]{1, ""};
            }
        }
    }

    public static List<Object[]> validateDateAsList(String date, String messageError, boolean mandatory) {
        List<Object[]> res = new ArrayList();
        res.add(validateDateAsObject(date, messageError, mandatory));
        return res;
    }

    public void addErrorMessage(List<Object[]> resFonction) {
        if (resFonction != null) {
            for (Object[] object : resFonction) {
                addErrorMessage(object);
            }
        }

    }

    public void addErrorMessage(Object[] resFonction) {
        if (new Integer(resFonction[0] + "") < 0) {
            errorMessages.add(resFonction[1] + "");
        }
    }

    public static Object[] splitXmlFileName(String xmlFileName, String startingXml) {
        if (StringUtils.isEmpty(xmlFileName)) {
            return new Object[]{-1, null, null};
        }
        String[] mySplit = xmlFileName.split("_");
        if (xmlFileName.startsWith(startingXml) && mySplit != null && mySplit.length == 3 && mySplit[1].length() == 14) {
            return new Object[]{2, mySplit[1], mySplit[2]};
        } else {
            return new Object[]{-2, "xmlFileNameNotValidMessage", null};
        }
    }

//    public abstract  List<Object[]> validate(T myObject);
//
//    public List<Object[]> validateList(List<T> myList, boolean mandatory) {
//        List<Object[]> res = new ArrayList();
//        if (myList == null || myList.isEmpty()) {
//            if (mandatory) {
//                res.add(new Object[]{-1, "noItem"});
//            } else {
//                res.add(new Object[]{1, ""});
//            }
//            return res;
//        }
//        for (T myObject : myList) {
//            res.addAll(validate(myObject));
//        }
//        return res;
//    }
    public List<String> getErrorMessages() {
        return errorMessages;
    }

}
