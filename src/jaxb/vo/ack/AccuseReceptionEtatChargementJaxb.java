/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo.ack;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YOUNES
 */
@XmlRootElement(name = "accuseReceptionEtatChargement") 
public class AccuseReceptionEtatChargementJaxb extends AccuseJaxb{

    private AccuseHeaderJaxb header;
    private AccuseReceptionEtatChargementInfoJaxb info;

    @XmlElement(name = "header")
    @Override
    public AccuseHeaderJaxb getHeader() {
        if(header==null){
            header= new AccuseHeaderJaxb();
        }
        return header;
    }

    @Override
    public void setHeader(AccuseHeaderJaxb header) {
        this.header = header;
    }

    @XmlElement(name = "accuse")
    @Override
    public AccuseReceptionEtatChargementInfoJaxb getInfo() {
        if(info==null){
            info= new AccuseReceptionEtatChargementInfoJaxb();
        }
        return info;
    }

    public void setInfo(AccuseReceptionEtatChargementInfoJaxb info) {
        this.info = info;
    }

    public AccuseReceptionEtatChargementJaxb() {
    }

    @Override
    public String toString() {
        return "AccuseReceptionEtatChargementJaxb{" + "header=" + header
                + "\n\n, info=" + info + '}';
    }

}
