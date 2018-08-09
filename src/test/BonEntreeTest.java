/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.xml.bind.JAXBException;
import jaxb.convertor.AccuseReceptionBonEntreeJaxbHelper;
import jaxb.convertor.BonEntreeJaxbHelper;
import jaxb.vo.BonEntreeJaxb;
import org.xml.sax.SAXException;
import validator.BonEntreeSyntaxicalValidator;

/**
 *
 * @author YOUNES
 */
public class BonEntreeTest {

    public static void main(String[] args) throws JAXBException, SAXException {

        String xmlFilePath = "src/xml/BE_20180719090554_E180108121.xml";
        String accuseFilePath = "E:/ack/BE/";
        BonEntreeJaxbHelper bonEntreeJaxbHelper = new BonEntreeJaxbHelper();
        BonEntreeJaxb bonEntreeJaxb = bonEntreeJaxbHelper.unmarshall(xmlFilePath);
        System.out.println(bonEntreeJaxb);

        BonEntreeSyntaxicalValidator bonEntreeSyntaxicalValidator = new BonEntreeSyntaxicalValidator();
        Object[] resValidation = bonEntreeSyntaxicalValidator.validate(bonEntreeJaxb, xmlFilePath);
        System.out.println(bonEntreeSyntaxicalValidator.getErrorMessages());

        AccuseReceptionBonEntreeJaxbHelper accuseReceptionBonEntreeJaxbHelper = new AccuseReceptionBonEntreeJaxbHelper();
        accuseReceptionBonEntreeJaxbHelper.marshall(bonEntreeJaxb, resValidation, accuseFilePath);

    }

}
