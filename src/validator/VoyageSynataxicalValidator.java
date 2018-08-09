/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.List;
import jaxb.vo.VoyageJaxb;

/**
 *
 * @author YOUNES
 */
public class VoyageSynataxicalValidator {

    public static List<Object[]> validate(VoyageJaxb voyageJaxb) {
        List<Object[]> res = new ArrayList();
        res.add(validateBureauSortie(voyageJaxb.getBureauSortie()));
        return res;

    }

    private static Object[] validateBureauSortie(String bureauSortie) {
        return SyntaxicalValidator.isValideNumberLenghtAndMandatoryExist(bureauSortie, 3, true,"bureauSortie");
    }

  
}
