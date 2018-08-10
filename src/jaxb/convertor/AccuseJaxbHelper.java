/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.convertor;

import jaxb.vo.HeaderJaxb;
import jaxb.vo.AccuseJaxb;
import util.FileHelper;
import util.JaxbUtil;

/**
 *
 * @author YOUNES
 */
public abstract class AccuseJaxbHelper extends JaxbUtil<AccuseJaxb> {

    public AccuseJaxbHelper() {
        super(AccuseJaxb.class);
    }

    private String constructAckFileName(HeaderJaxb headerJaxb, String ref, String typeFile) {
        String[] myLocalDate = (headerJaxb.getDateMessage()).split("T");
        String[] myDate = myLocalDate[0].split("-");
        String[] myTime = myLocalDate[1].split(":");
        String formattedDate = myDate[0] + myDate[1] + myDate[2] + myTime[0] + myTime[1] + myTime[2];
        return "ACK_" + typeFile + "_" + formattedDate + "_" + ref + ".xml";
    }

    private AccuseJaxb convert(HeaderJaxb headerJaxb, int resultatValidation, String messageValidation) {
        AccuseJaxb accuseJaxb = new AccuseJaxb();

        accuseJaxb.getHeader().setDateMessage(headerJaxb.getDateMessage().replace('T', ' '));
        accuseJaxb.getHeader().setNumeroMessage(headerJaxb.getNumeroMessage());
        if (resultatValidation > 0) {
            accuseJaxb.getInfo().setCode("OK");
            accuseJaxb.getInfo().setDescription("Validation Avec Succes");
        } else {
            accuseJaxb.getInfo().setCode("NOK");
            accuseJaxb.getInfo().setDescription(messageValidation);
        }
        return accuseJaxb;
    }

    public void generateAccuse(HeaderJaxb headerJaxb, String ref, String typeFile, Object[] resValidation, String destinationPath) {
        FileHelper.createIfNotExist(destinationPath);
        Integer resultatValidation = new Integer(resValidation[0] + "");
        String messageValidation = (resValidation[1] + "");
        AccuseJaxb accuseJaxb = convert(headerJaxb, resultatValidation, messageValidation);
        beforeGenerate(accuseJaxb);
        marshall(accuseJaxb, destinationPath, constructAckFileName(headerJaxb, ref, typeFile));
    }

    public abstract void beforeGenerate(AccuseJaxb accuseJaxb) ;

}
