/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import javax.xml.bind.JAXBException;
import jaxb.convertor.BonEntreeAccuseJaxbHelper;
import jaxb.convertor.BonEntreeJaxbHelper;
import jaxb.vo.BonEntreeJaxb;
import org.xml.sax.SAXException;
import util.FileHelper;
import validator.syntaxe.BonEntreeSyntaxicalValidator;

/**
 *
 * @author YOUNES
 */
public class BonEntreeTest {

//    public static void main(String[] args) throws JAXBException, SAXException {
//
//        String xmlFilePath = "src/xml/";
//        String accuseFilePath = "E:/ack/BE/";
//
//        File xmlFile = new File(xmlFilePath);
//        String files[] = xmlFile.list();
//        BonEntreeJaxbHelper bonEntreeJaxbHelper = new BonEntreeJaxbHelper();
//        BonEntreeSyntaxicalValidator bonEntreeSyntaxicalValidator = new BonEntreeSyntaxicalValidator();
//
//        for (String file : files) {
//            File myFile = new File(xmlFile, file);
//            if (myFile.getName().startsWith("BE_") && myFile.getName().endsWith(".xml")) {
//
//                BonEntreeJaxb bonEntreeJaxb = bonEntreeJaxbHelper.unmarshall(myFile.getAbsolutePath());
//                System.out.println(bonEntreeJaxb);
//
//                Object[] resValidation = bonEntreeSyntaxicalValidator.validate(bonEntreeJaxb, FileHelper.stripExtension(myFile.getName()));
//                System.out.println(bonEntreeSyntaxicalValidator.getErrorMessages());
//
//                BonEntreeAccuseJaxbHelper accuseReceptionBonEntreeJaxbHelper = new BonEntreeAccuseJaxbHelper(bonEntreeJaxb);
//                accuseReceptionBonEntreeJaxbHelper.generateAccuse(bonEntreeJaxb.getHeader(), bonEntreeJaxb.getAMP().getNumAMP(),
//                        "BE", resValidation, accuseFilePath);
//            }
//        }
//
//    }

}
