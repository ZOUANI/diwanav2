/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.manager;

import javax.xml.bind.JAXBException;
import jaxb.convertor.EtatChargementJaxbHelper;
import jaxb.convertor.JaxbConvertor;
import jaxb.vo.EtatChargementJaxb;
import org.xml.sax.SAXException;
import validator.syntaxe.EtatChargementSynataxicalValidator;

/**
 *
 * @author YOUNES
 */
public class EtatChargementManager extends AbstractManager<EtatChargementJaxb> {

    JaxbConvertor<EtatChargementJaxb> etatChargementJaxbHelper = new EtatChargementJaxbHelper();
    EtatChargementSynataxicalValidator etatChargementSyntaxicalValidator = new EtatChargementSynataxicalValidator();
    String xmlFilePath = "src/xml/";
    String accuseFilePath = "E:/ack/EC/";
    String startingFileName = "EC";

    public void validate() throws JAXBException, SAXException {
        super.validate(xmlFilePath, accuseFilePath, etatChargementJaxbHelper,
                etatChargementSyntaxicalValidator, startingFileName);
    }

    public static void main(String[] args) {
        try {
            new EtatChargementManager().validate();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        }
    }
}
