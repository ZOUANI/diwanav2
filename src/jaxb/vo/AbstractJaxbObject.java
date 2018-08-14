/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author YOUNES
 */
public abstract class AbstractJaxbObject {

    protected HeaderJaxb header;

    public abstract String getReferenceInXmlFile();

    @XmlElement(name = "header")
    public HeaderJaxb getHeader() {
        if (header == null) {
            header = new HeaderJaxb();
        }
        return header;
    }

    public void setHeader(HeaderJaxb header) {
        this.header = header;
    }

}
