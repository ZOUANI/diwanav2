/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.xml.bind.JAXBException;
import jaxb.convertor.BonSortieAccuseJaxbHelper;
import jaxb.convertor.BonSortieJaxbHelper;
import jaxb.vo.BonSortieJaxb;
import org.xml.sax.SAXException;
import validator.BonSortieSyntaxicalValidator;

/**
 *
 * @author YOUNES
 */
public class BonSortieTest {

    public static void main(String[] args) throws JAXBException, SAXException {

        String xmlFilePath = "src/xml/BS_20180620094000_41101020180000988.xml";
        String accuseFilePath = "E:/ack/BS/";

        BonSortieJaxbHelper bonSortieJaxbHelper = new BonSortieJaxbHelper();
        BonSortieJaxb bonSortieJaxb = bonSortieJaxbHelper.unmarshall(xmlFilePath);
        System.out.println(bonSortieJaxb);

        BonSortieSyntaxicalValidator bonSortieSyntaxicalValidator = new BonSortieSyntaxicalValidator();
        Object[] resValidation = bonSortieSyntaxicalValidator.validate(bonSortieJaxb, xmlFilePath);
        System.out.println(bonSortieSyntaxicalValidator.getErrorMessages());

        BonSortieAccuseJaxbHelper accuseReceptionBonEntreeJaxbHelper = new BonSortieAccuseJaxbHelper(bonSortieJaxb);
        accuseReceptionBonEntreeJaxbHelper.generateAccuse(bonSortieJaxb.getHeader(), bonSortieJaxb.getDum().getReference()
                , "BS", resValidation, accuseFilePath);
    }

}
