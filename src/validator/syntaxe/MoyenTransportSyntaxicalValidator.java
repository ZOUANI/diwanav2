/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.syntaxe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jaxb.vo.MoyenTransportJaxb;

/**
 *
 * @author YOUNES
 */
public class MoyenTransportSyntaxicalValidator {

    private static final List<String> TYPE_MOYEN = Arrays.asList("351", "005", "006", "007", "254");

    public static List<Object[]> validate(List<MoyenTransportJaxb> moyenTransportJaxbs) {
        List<Object[]> res = new ArrayList();
        if (moyenTransportJaxbs == null || moyenTransportJaxbs.isEmpty()) {
            res.add(new Object[]{-1, "noItem"});
        } else {
            for (MoyenTransportJaxb moyenTransportJaxb : moyenTransportJaxbs) {
                res.addAll(validate(moyenTransportJaxb));
            }
        }
        return res;
    }

    public static List<Object[]> validate(MoyenTransportJaxb moyenTransportJaxb) {
        List<Object[]> res = new ArrayList();
        res.add(validatePays(moyenTransportJaxb.getPays()));
        res.add(validateTypeMoyen(moyenTransportJaxb.getTypeMoyen()));
        res.add(validateImmatriculation(moyenTransportJaxb.getImmatriculation()));
        res.add(validateTare(moyenTransportJaxb.getTare()));
        return res;
    }

    private static Object[] validatePays(String pays) {
        return SyntaxicalValidator.isValideStringLenghtAndMandatoryExist(pays, 2, true, "pays");
    }

    private static Object[] validateTypeMoyen(String typeMoyen) {
        return SyntaxicalValidator.validateExistMandatoryStyle(typeMoyen, TYPE_MOYEN.indexOf(typeMoyen) != -1, "typeMoyen");
    }

    private static Object[] validateImmatriculation(String immatriculation) {
        return SyntaxicalValidator.isValideStringLenghtAndNotMandatoryExist(immatriculation, 30, false, "immatriculation");
    }

    private static Object[] validateTare(String tare) {
        return SyntaxicalValidator.isValideDecimalLenghtAndNotMandatoryExist(tare, 10, 3, false, "tare");
    }

}
