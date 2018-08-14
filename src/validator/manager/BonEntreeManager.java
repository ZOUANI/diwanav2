/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.manager;

import javax.xml.bind.JAXBException;
import jaxb.convertor.BonEntreeJaxbHelper;
import jaxb.convertor.JaxbConvertor;
import jaxb.vo.BonEntreeJaxb;
import org.xml.sax.SAXException;
import validator.syntaxe.BonEntreeSyntaxicalValidator;

/**
 *
 * @author YOUNES
 */
public class BonEntreeManager extends AbstractManager<BonEntreeJaxb> {

    JaxbConvertor<BonEntreeJaxb> bonEntreeJaxbHelper = new BonEntreeJaxbHelper();
    BonEntreeSyntaxicalValidator bonEntreeSyntaxicalValidator = new BonEntreeSyntaxicalValidator();
    String xmlFilePath = "src/xml/";
    String accuseFilePath = "E:/ack/BE/";
    String startingFileName = "BE";

    public void validate() throws JAXBException, SAXException {

        super.validate(xmlFilePath, accuseFilePath, bonEntreeJaxbHelper,
                bonEntreeSyntaxicalValidator, startingFileName);
    }

    public static void main(String[] args) {
        try {
            new BonEntreeManager().validate();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        }
    }
}
