/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo;

/**
 *
 * @author YOUNES
 */
public class AccuseHeaderJaxb {

    private String numeroMessage;
    private String dateMessage;

    public AccuseHeaderJaxb() {
    }

    public String getNumeroMessage() {
        return numeroMessage;
    }

    public void setNumeroMessage(String numeroMessage) {
        this.numeroMessage = numeroMessage;
    }

    public String getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(String dateMessage) {
        this.dateMessage = dateMessage;
    }

    @Override
    public String toString() {
        return "numeroMessage=" + numeroMessage + ", dateMessage=" + dateMessage;
    }
    
    

}
