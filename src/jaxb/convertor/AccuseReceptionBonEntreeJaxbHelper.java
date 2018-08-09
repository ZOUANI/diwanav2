/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.convertor;

import jaxb.vo.BonEntreeJaxb;
import jaxb.vo.ack.AccuseReceptionBonEntreeJaxb;
import jaxb.vo.ack.AccuseHelper;
import util.FileHelper;

import util.JaxbUtil;

/**
 *
 * @author YOUNES
 */
public class AccuseReceptionBonEntreeJaxbHelper extends JaxbUtil<AccuseReceptionBonEntreeJaxb> {

    public AccuseReceptionBonEntreeJaxbHelper() {
        super(AccuseReceptionBonEntreeJaxb.class);
    }

    private String constructAckFileName(BonEntreeJaxb bonEntreeJaxb) {
        return AccuseHelper.constructAckFileName(bonEntreeJaxb.getHeader(), bonEntreeJaxb.getAMP().getNumAMP(), "BE");
    }

    public void marshall(BonEntreeJaxb bonEntreeJaxb, Object[] resValidation, String destinationPath) {
        FileHelper.createIfNotExist(destinationPath);
        Integer resultatValidation = new Integer(resValidation[0] + "");
        String messageValidation = (resValidation[1] + "");
        AccuseReceptionBonEntreeJaxb accuseReceptionBonSortieJaxb = convert(bonEntreeJaxb, resultatValidation, messageValidation);
        super.marshall(accuseReceptionBonSortieJaxb, destinationPath, constructAckFileName(bonEntreeJaxb));
    }

    public AccuseReceptionBonEntreeJaxb convert(BonEntreeJaxb bonEntreeJaxb, int resultatValidation, String messageValidation) {
        AccuseReceptionBonEntreeJaxb accuseReceptionJaxb = new AccuseReceptionBonEntreeJaxb();

        accuseReceptionJaxb.getHeader().setDateMessage(bonEntreeJaxb.getHeader().getDateMessage().replace('T', ' '));
        accuseReceptionJaxb.getHeader().setNumeroMessage(bonEntreeJaxb.getHeader().getNumeroMessage());

        if (resultatValidation > 0) {
            accuseReceptionJaxb.getInfo().setCode("OK");
            accuseReceptionJaxb.getInfo().setDescription("Validation Avec Succes");
        } else {
            accuseReceptionJaxb.getInfo().setCode("NOK");
            accuseReceptionJaxb.getInfo().setDescription(messageValidation);
        }
        return accuseReceptionJaxb;
    }
}
