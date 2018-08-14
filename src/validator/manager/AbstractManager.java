/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.manager;

import java.io.File;
import javax.xml.bind.JAXBException;
import jaxb.convertor.AccuseJaxbHelper;
import jaxb.convertor.AccuseJaxbHelperFactory;
import jaxb.convertor.JaxbConvertor;
import jaxb.vo.AbstractJaxbObject;
import org.xml.sax.SAXException;
import validator.syntaxe.SyntaxicalValidator;

/**
 *
 * @author YOUNES
 * @param <T>
 */
public class AbstractManager<T extends AbstractJaxbObject> {

    public void validate(String xmlFilePath, String accuseFilePath, JaxbConvertor<T> jaxbConvertor,
            SyntaxicalValidator<T> syntaxicalValidator, String startingFileName) throws JAXBException, SAXException {
//        String xmlFilePath = "src/xml/";
//        String accuseFilePath = "E:/ack/BE/";
        File xmlFolder = new File(xmlFilePath);
        String files[] = xmlFolder.list();
//        BonEntreeJaxbHelper bonEntreeJaxbHelper = new BonEntreeJaxbHelper();
        // BonEntreeSyntaxicalValidator bonEntreeSyntaxicalValidator = new BonEntreeSyntaxicalValidator();

        for (String xmlFileName : files) {
            File xmlFile = new File(xmlFolder, xmlFileName);
            if (xmlFile.getName().startsWith(startingFileName + "_") && xmlFile.getName().toLowerCase().endsWith(".xml")) {
                // BonEntreeJaxb bonEntreeJaxb = bonEntreeJaxbHelper.unmarshall(myFile.getAbsolutePath());
                AbstractJaxbObject jaxbObject = (AbstractJaxbObject) jaxbConvertor.unmarshall(xmlFile.getAbsolutePath());
                System.out.println(jaxbObject);
                //  Object[] resValidation = bonEntreeSyntaxicalValidator.validate(jaxbObject, FileHelper.stripExtension(myFile.getName()));
                // Object[] resValidation = syntaxicalValidator.validate(jaxbObject, FileHelper.stripExtension(myFile.getName()));
                Object[] resValidation = syntaxicalValidator.validate((T) jaxbObject, xmlFile.getName());
                System.out.println(syntaxicalValidator.getErrorMessages());
                AccuseJaxbHelper accuseJaxbHelper = AccuseJaxbHelperFactory.construct(startingFileName, jaxbObject);
//                accuseJaxbHelper.generateAccuse(jaxbObject.getHeader(), jaxbObject.getAMP().getNumAMP(),
//                        "BE", resValidation, accuseFilePath);
//                System.out.println("ha mon header ==> " + jaxbObject.getHeader());
//                System.out.println("ha mon getReferenceInXmlFile ==> " + jaxbObject.getReferenceInXmlFile());
//                System.out.println("ha mon fileName ==> " + xmlFileName);
                accuseJaxbHelper.generateAccuse(jaxbObject.getHeader(), jaxbObject.getReferenceInXmlFile(), xmlFileName, resValidation, accuseFilePath);
            }
        }

    }
}
