/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author YOUNES
 */
public class DumsJaxb {

    private List<DumJaxb> dumJaxbs;

    @XmlElement(name = "dum")
    public List<DumJaxb> getDumJaxbs() {
        if (dumJaxbs == null) {
            dumJaxbs = new ArrayList();
        }
        return dumJaxbs;
    }

    public void setDumJaxbs(List<DumJaxb> dumsJaxbs) {
        this.dumJaxbs = dumsJaxbs;
    }

    @Override
    public String toString() {
        return "dumJaxbs=" + dumJaxbs + '}';
    }

}
