/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.xml.bind.JAXBException;
import jaxb.convertor.AccuseJaxbHelper;
import jaxb.convertor.BonEntreeAccuseJaxbHelper;
import jaxb.convertor.EtatChargementAccuseJaxbHelper;
import jaxb.convertor.EtatChargementJaxbHelper;
import jaxb.vo.EtatChargementJaxb;
import org.xml.sax.SAXException;
import validator.syntaxe.EtatChargementSynataxicalValidator;

/**
 *
 * @author YOUNES
 */
public class EtatChargementTest {

//    public static void main(String[] args) throws JAXBException, SAXException {
//
//        String xmlFilePath = "src/xml/EC_20180412152523_30900120180000006.xml";
//        String accuseFilePath = "E:/ack/EC/";
//        EtatChargementJaxbHelper etatChargementJaxbHelper = new EtatChargementJaxbHelper();
//        EtatChargementJaxb etatChargementJaxb = etatChargementJaxbHelper.unmarshall(xmlFilePath);
//        System.out.println(etatChargementJaxb);
//
//        EtatChargementSynataxicalValidator etatChargementSynataxicalValidator = new EtatChargementSynataxicalValidator();
//        Object[] resValidation = etatChargementSynataxicalValidator.validate(etatChargementJaxb, xmlFilePath);
//        System.out.println(etatChargementSynataxicalValidator.getErrorMessages());
//
//        EtatChargementAccuseJaxbHelper etatChargementAccuseJaxbHelper = new EtatChargementAccuseJaxbHelper();
//        etatChargementAccuseJaxbHelper.generateAccuse(etatChargementJaxb.getHeader(), etatChargementJaxb.getReferenceEtatChagement(),
//                 "EC", resValidation, accuseFilePath);
//    }

}
