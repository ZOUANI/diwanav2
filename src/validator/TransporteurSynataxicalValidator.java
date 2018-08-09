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
public class TransporteurSynataxicalValidator {

    public static List<Object[]> validate(OperateurJaxb transporteurJaxb,String modeTransport) {
        List<Object[]> res = new ArrayList();
        res.addAll(OperatorSynataxicalValidator.validate(transporteurJaxb,"Transporteur"));
        res.add(validateNavire(transporteurJaxb.getNavire(),modeTransport));
        res.add(validateDateHeureVoyage(transporteurJaxb.getDateHeureVoyage()));
        return res;
        
    }
    
    private static Object[] validateNavire(String navire, String modeTransport) {
        if (modeTransport != null && modeTransport.equals("01")) {
            return SyntaxicalValidator.isValideStringLenghtAndMandatoryExist(navire, 15, true, "navire");
        }
        return new Object[]{1,""};
    }
    
    private static Object[] validateDateHeureVoyage(String dateHeureVoyage) {
            return SyntaxicalValidator.validateDateAsObject(dateHeureVoyage,"yyyy-MM-dd'T'hh:mm", "dateHeureVoyage", true);
    }
}
