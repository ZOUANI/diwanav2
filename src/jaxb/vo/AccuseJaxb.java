/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YOUNES
 */
@XmlRootElement(name = "accuseReception")
public class AccuseJaxb {

    protected AccuseHeaderJaxb header;
    protected AccuseInfoJaxb info;

    @XmlElement(name = "header")
    public AccuseHeaderJaxb getHeader() {
        if (header == null) {
            header = new AccuseHeaderJaxb();
        }
        return header;
    }

    public void setHeader(AccuseHeaderJaxb header) {
        this.header = header;
    }

    @XmlElement(name = "accuse")
    public AccuseInfoJaxb getInfo() {
        if (info == null) {
            info = new AccuseInfoJaxb();
        }
        return info;
    }

    public void setInfo(AccuseInfoJaxb info) {
        this.info = info;
    }

}
