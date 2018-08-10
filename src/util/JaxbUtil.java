/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/**
 *
 * @author YOUNES
 */
public class JaxbUtil<T> {

    private Class<T> entityClass;

    public JaxbUtil(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T unmarshall(String xmlPath) throws JAXBException, SAXException {
        return unmarshallAndValiadte(xmlPath, null);
    }

    public T unmarshallAndValiadte(String xmlPath, String xsdPath) throws JAXBException, SAXException {
        JAXBContext context = JAXBContext.newInstance(entityClass);
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        if (xsdPath != null) {
            Schema schema = sf.newSchema(new File(xsdPath));
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new MyValidationEventHandler());
        }
        T myObject = (T) unmarshaller.unmarshal(new File(xmlPath));
        return myObject;
    }


    public void marshall(T myObject, String destinationPath, String xmlFileName) {
        try {
            File file = new File(destinationPath + xmlFileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(entityClass);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(myObject, file);
            file.createNewFile();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
   

    public static Object[] validateXML(String inputXml, String xsdPath) throws SAXNotRecognizedException, SAXNotSupportedException {
        return null;
    }


}
