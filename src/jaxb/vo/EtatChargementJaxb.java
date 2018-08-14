/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.vo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "etatChargement")
public class EtatChargementJaxb extends AbstractJaxbObject{

    protected String referenceEtatChagement;
    private String agentControle;
    private String decisionSelectivite;
    private String dateEnregistrement;
    private String dateDepot;
    private String modeTransport;
    private String numeroVersion;

    private VoyageJaxb voyage;
    private OperateurJaxb operateurTransporteurTerrestre;
    private OperateurJaxb transporteur;
 //   private HeaderJaxb header;
    private List<DeclarationEnDetailJaxb> declarationEnDetails;
    private List<MoyenTransportJaxb> moyenTransports;
    private MarchandiseSousCouvertAutresDocumentsJaxb marchandiseSousCouvertAutresDocuments;
    private OperateurJaxb exportateur;

    @XmlElement(name = "exportateur")
    public OperateurJaxb getExportateur() {
        if (exportateur == null) {
            exportateur = new OperateurJaxb();
        }
        return exportateur;
    }

    public void setExportateur(OperateurJaxb exportateur) {
        this.exportateur = exportateur;
    }

    @XmlElement(name = "declarationEnDetail")
    public List<DeclarationEnDetailJaxb> getDeclarationEnDetails() {
        if (declarationEnDetails == null) {
            declarationEnDetails = new ArrayList();
        }
        return declarationEnDetails;
    }

    public void setDeclarationEnDetails(List<DeclarationEnDetailJaxb> declarationEnDetails) {
        this.declarationEnDetails = declarationEnDetails;
    }

    @XmlElement(name = "moyenTransport")
    public List<MoyenTransportJaxb> getMoyenTransports() {
        if (moyenTransports == null) {
            moyenTransports = new ArrayList();
        }
        return moyenTransports;
    }

    public void setMoyenTransport(List<MoyenTransportJaxb> moyenTransports) {
        this.moyenTransports = moyenTransports;
    }

    @XmlElement(name = "marchandiseSousCouvertAutresDocuments")
    public MarchandiseSousCouvertAutresDocumentsJaxb getMarchandiseSousCouvertAutresDocuments() {
        if (marchandiseSousCouvertAutresDocuments == null) {
            marchandiseSousCouvertAutresDocuments = new MarchandiseSousCouvertAutresDocumentsJaxb();
        }
        return marchandiseSousCouvertAutresDocuments;
    }

    public void setMarchandiseSousCouvertAutresDocuments(MarchandiseSousCouvertAutresDocumentsJaxb marchandiseSousCouvertAutresDocuments) {
        this.marchandiseSousCouvertAutresDocuments = marchandiseSousCouvertAutresDocuments;
    }

    @XmlElement(name = "voyage")
    public VoyageJaxb getVoyage() {
        if (voyage == null) {
            voyage = new VoyageJaxb();
        }
        return voyage;
    }

    public void setVoyage(VoyageJaxb voyage) {
        this.voyage = voyage;
    }

    @XmlElement(name = "operateurTransporteurTerrestre")
    public OperateurJaxb getOperateurTransporteurTerrestre() {
        if (operateurTransporteurTerrestre == null) {
            operateurTransporteurTerrestre = new OperateurJaxb();
        }
        return operateurTransporteurTerrestre;
    }

    public void setOperateurTransporteurTerrestre(OperateurJaxb operateurTransporteurTerrestre) {
        this.operateurTransporteurTerrestre = operateurTransporteurTerrestre;
    }

    @XmlElement(name = "transporteur")
    public OperateurJaxb getTransporteur() {
        if (transporteur == null) {
            transporteur = new OperateurJaxb();
        }
        return transporteur;
    }

    public void setTransporteur(OperateurJaxb transporteur) {
        this.transporteur = transporteur;
    }

//    @XmlElement(name = "header")
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

    public String getDecisionSelectivite() {
        return decisionSelectivite;
    }

    public void setDecisionSelectivite(String decisionSelectivite) {
        this.decisionSelectivite = decisionSelectivite;
    }

    public String getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(String dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public String getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(String dateDepot) {
        this.dateDepot = dateDepot;
    }

    public String getModeTransport() {
        return modeTransport;
    }

    public void setModeTransport(String modeTransport) {
        this.modeTransport = modeTransport;
    }

    public String getNumeroVersion() {
        return numeroVersion;
    }

    public void setNumeroVersion(String numeroVersion) {
        this.numeroVersion = numeroVersion;
    }

    public String getAgentControle() {
        return agentControle;
    }

    public void setAgentControle(String agentControle) {
        this.agentControle = agentControle;
    }

    public String getReferenceEtatChagement() {
        return referenceEtatChagement;
    }

    public void setReferenceEtatChagement(String value) {
        this.referenceEtatChagement = value;
    }

    @Override
    public String toString() {
        return "referenceEtatChagement=" + referenceEtatChagement + ", agentControle=" + agentControle + ", decisionSelectivite=" + decisionSelectivite + "\n"
                + ", dateEnregistrement=" + dateEnregistrement + ", dateDepot=" + dateDepot + ", modeTransport=" + modeTransport + "\n"
                + ", numeroVersion=" + numeroVersion
                + "\n, voyage=" + voyage + "\n"
                + ", operateurTransporteurTerrestre=" + operateurTransporteurTerrestre + "\n"
                + ", header=" + header + "\n"
                + ", declarationEnDetails=" + declarationEnDetails + "\n"
                + ", moyenTransports=" + moyenTransports + "\n"
                + ", marchandiseSousCouvertAutresDocuments=" + marchandiseSousCouvertAutresDocuments + '}';
    }
    
     @Override
    public String getReferenceInXmlFile() {
        return this.getReferenceEtatChagement();
    }

}
