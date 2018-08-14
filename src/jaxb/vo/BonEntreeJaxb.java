package jaxb.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bonEntree")
public class BonEntreeJaxb extends AbstractJaxbObject{

 //   private HeaderJaxb header;
    private AMPJaxb AMP;
    private UniteJaxb unite;
    private DumsJaxb dums;
    private EtatChargementJaxb etatChargement;
    private String dateOperation;
    private OperateurJaxb operateur;

//    @XmlElement(name = "header")
//    public HeaderJaxb getHeader() {
//        if (header == null) {
//            header = new HeaderJaxb();
//        }
//        return header;
//    }
//
//    public void setHeader(HeaderJaxb value) {
//        this.header = value;
//    }

    @XmlElement(name = "unite")
    public UniteJaxb getUnite() {
        if (unite == null) {
            unite = new UniteJaxb();
        }
        return unite;
    }

    public void setUnite(UniteJaxb value) {
        this.unite = value;
    }

    @XmlElement(name = "dums")
    public DumsJaxb getDums() {
        if (dums == null) {
            dums = new DumsJaxb();
        }
        return dums;
    }

    public void setDums(DumsJaxb value) {
        this.dums = value;
    }

    @XmlElement(name = "etatChargement")
    public EtatChargementJaxb getEtatChargement() {
        if (etatChargement == null) {
            etatChargement = new EtatChargementJaxb();
        }
        return etatChargement;
    }

    public void setEtatChargement(EtatChargementJaxb value) {
        this.etatChargement = value;
    }

    @XmlElement(name = "dateOperation")
    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String value) {
        this.dateOperation = value;
    }

    @XmlElement(name = "AMP")
    public AMPJaxb getAMP() {
        if (AMP == null) {
            AMP = new AMPJaxb();
        }
        return AMP;
    }

    public void setAMP(AMPJaxb AMP) {
        this.AMP = AMP;
    }

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
        return "BonEntreeJaxb{\n" + "header=" + header + "\n, amp=" + AMP + "\n, unite=" + unite + "\n"
                + ", dums=" + dums + "\n, etatChargement=" + etatChargement + "\n, dateOperation=" + dateOperation + "\n"
                + ", operateur=" + operateur + '}';
    }

    @Override
    public String getReferenceInXmlFile() {
        return this.getAMP().getNumAMP();
    }

}
