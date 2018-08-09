/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.convertor;

import jaxb.vo.ack.AccuseHelper;
import jaxb.vo.ack.AccuseReceptionBonSortieJaxb;
import jaxb.vo.BonSortieJaxb;
import util.FileHelper;

import util.JaxbUtil;

/**
 *
 * @author YOUNES
 */
public class AccuseReceptionBonSortieJaxbHelper extends JaxbUtil<AccuseReceptionBonSortieJaxb> {

    public AccuseReceptionBonSortieJaxbHelper() {
        super(AccuseReceptionBonSortieJaxb.class);
    }

    private String constructAckFileName(BonSortieJaxb bonSortieJaxb) {
        return AccuseHelper.constructAckFileName(bonSortieJaxb.getHeader(), bonSortieJaxb.getDum().getReference(), "BS");
    }

    public void marshall(BonSortieJaxb bonSortieJaxb, Object[] resValidation, String destinationPath) {
        FileHelper.createIfNotExist(destinationPath);
        Integer resultatValidation= new Integer(resValidation[0]+"");
        String messageValidation= (resValidation[1]+"");
        AccuseReceptionBonSortieJaxb accuseReceptionJaxb = convert(bonSortieJaxb, resultatValidation, messageValidation);
        super.marshall(accuseReceptionJaxb, destinationPath, constructAckFileName(bonSortieJaxb));
    }

    public AccuseReceptionBonSortieJaxb convert(BonSortieJaxb bonSortieJaxb, int resultatValidation, String messageValidation) {
        AccuseReceptionBonSortieJaxb accuseReceptionJaxb = new AccuseReceptionBonSortieJaxb();

        accuseReceptionJaxb.getHeader().setDateMessage(bonSortieJaxb.getHeader().getDateMessage().replace('T', ' '));
        accuseReceptionJaxb.getHeader().setNumeroMessage(bonSortieJaxb.getHeader().getNumeroMessage());
        
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
