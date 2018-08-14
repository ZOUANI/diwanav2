/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.manager;

import javax.xml.bind.JAXBException;
import jaxb.convertor.BonSortieJaxbHelper;
import jaxb.convertor.JaxbConvertor;
import jaxb.vo.BonSortieJaxb;
import org.xml.sax.SAXException;
import validator.syntaxe.BonSortieSyntaxicalValidator;

/**
 *
 * @author YOUNES
 */
public class BonSortieManager extends AbstractManager<BonSortieJaxb> {

    JaxbConvertor<BonSortieJaxb> bonSortieJaxbHelper = new BonSortieJaxbHelper();
    BonSortieSyntaxicalValidator bonSortieSyntaxicalValidator = new BonSortieSyntaxicalValidator();
    String xmlFilePath = "src/xml/";
    String accuseFilePath = "E:/ack/BS/";
    String startingFileName = "BS";

    public void validate() throws JAXBException, SAXException {
        super.validate(xmlFilePath, accuseFilePath, bonSortieJaxbHelper,
                bonSortieSyntaxicalValidator, startingFileName);
    }

    public static void main(String[] args) {
        try {
            new BonSortieManager().validate();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        }
    }
}
