/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.convertor;

import jaxb.vo.EtatChargementJaxb;
import jaxb.vo.ack.AccuseHelper;
import jaxb.vo.ack.AccuseReceptionEtatChargementJaxb;
import util.FileHelper;
import util.JaxbUtil;

/**
 *
 * @author YOUNES
 */
public class AccuseReceptionEtatChargementJaxbHelper extends JaxbUtil<AccuseReceptionEtatChargementJaxb> {

    public AccuseReceptionEtatChargementJaxbHelper() {
        super(AccuseReceptionEtatChargementJaxb.class);
    }

    private String constructAckFileName(EtatChargementJaxb etatChargementJaxb) {
        return AccuseHelper.constructAckFileName(etatChargementJaxb.getHeader(), etatChargementJaxb.getReferenceEtatChagement(), "EC");
    }

    public void marshall(EtatChargementJaxb etatChargementJaxb, Object[] resValidation, String destinationPath) {
        FileHelper.createIfNotExist(destinationPath);
        Integer resultatValidation= new Integer(resValidation[0]+"");
        String messageValidation= (resValidation[1]+"");
        AccuseReceptionEtatChargementJaxb accuseReceptionJaxb = convert(etatChargementJaxb, resultatValidation, messageValidation);
        super.marshall(accuseReceptionJaxb, destinationPath, constructAckFileName(etatChargementJaxb));
    }

    public AccuseReceptionEtatChargementJaxb convert(EtatChargementJaxb etatChargementJaxb, int resultatValidation, String messageValidation) {
        AccuseReceptionEtatChargementJaxb accuseReceptionJaxb = new AccuseReceptionEtatChargementJaxb();

        accuseReceptionJaxb.getHeader().setDateMessage(etatChargementJaxb.getHeader().getDateMessage().replace('T', ' '));
        accuseReceptionJaxb.getHeader().setNumeroMessage(etatChargementJaxb.getHeader().getNumeroMessage());
        
        if (resultatValidation>0) {
            accuseReceptionJaxb.getInfo().setCode("OK");
            accuseReceptionJaxb.getInfo().setDescription("Validation Avec Succes");
        } else {
            accuseReceptionJaxb.getInfo().setCode("NOK");
            accuseReceptionJaxb.getInfo().setDescription(messageValidation);
        }
        return accuseReceptionJaxb;
    }
}