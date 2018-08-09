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
@XmlRootElement(name = "accuseReceptionBonSortie") 
public class AccuseReceptionBonSortieJaxb extends AccuseJaxb{

    private AccuseHeaderJaxb header;
    private AccuseReceptionBonSortieInfoJaxb info;

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
    public AccuseReceptionBonSortieInfoJaxb getInfo() {
        if(info==null){
            info= new AccuseReceptionBonSortieInfoJaxb();
        }
        return info;
    }

    public void setInfo(AccuseReceptionBonSortieInfoJaxb info) {
        this.info = info;
    }

    public AccuseReceptionBonSortieJaxb() {
    }

    @Override
    public String toString() {
        return "AccuseReceptionJaxb{" + "header=" + header
                + "\n\n, info=" + info + '}';
    }

}
