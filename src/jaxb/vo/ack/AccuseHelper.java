/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo.ack;

import jaxb.vo.HeaderJaxb;

/**
 *
 * @author YOUNES
 */
public class AccuseHelper {

    public static String constructAckFileName(HeaderJaxb headerJaxb, String ref, String typeFile) {
        String[] myLocalDate = (headerJaxb.getDateMessage()).split("T");
        String[] myDate = myLocalDate[0].split("-");
        String[] myTime = myLocalDate[1].split(":");
        String formattedDate = myDate[0] + myDate[1] + myDate[2] + myTime[0] + myTime[1] + myTime[2];
        return "ACK_" + typeFile + "_" + formattedDate + "_" + ref + ".xml";
    }

    public static AccuseJaxb convert(HeaderJaxb headerJaxb, int resultatValidation, String messageValidation) {
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
}
