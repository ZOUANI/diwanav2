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
@XmlRootElement(name = "bonSortie")
public class BonSortieJaxb extends AbstractJaxbObject{

    private BonSortieInfoJaxb bon;
    private DumJaxb dum;
   // private HeaderJaxb header;
    private OperateurJaxb operateur;

    @XmlElement(name = "bon")
    public BonSortieInfoJaxb getBon() {
        if (bon == null) {
            bon = new BonSortieInfoJaxb();
        }
        return bon;
    }

    public void setBon(BonSortieInfoJaxb bon) {
        this.bon = bon;
    }

    @XmlElement(name = "dum")
    public DumJaxb getDum() {
        if (dum == null) {
            dum = new DumJaxb();
        }
        return dum;
    }

    public void setDum(DumJaxb dum) {
        this.dum = dum;
    }

//    public HeaderJaxb getHeader() {
//        if (header == null) {
//            header = new HeaderJaxb();
//        }
//        return header;
//    }
//
//    public void setHeader(HeaderJaxb header) {
//        this.header = header;
//    }

    @XmlElement(name = "operateur")
    public OperateurJaxb getOperateur() {
        if (operateur == null) {
            operateur = new OperateurJaxb();
        }
        return operateur;
    }

    public void setOperateur(OperateurJaxb operateur) {
        this.operateur = operateur;
    }

    @Override
    public String toString() {
        return "BonSortie{\n" + "bon=" + bon + "\n\n, dum=" + dum
                + "\n\n, header=" + header + "\n\n, operateur=" + operateur + "\n\n}";
    }
    
    @Override
    public String getReferenceInXmlFile() {
        return this.getBon().getReferenceBon();
    }


}
