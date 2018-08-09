/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBException;
import jaxb.vo.EtatChargementJaxb;
import org.xml.sax.SAXException;

/**
 *
 * @author YOUNES
 */
public class EtatChargementSynataxicalValidator extends SyntaxicalValidator<EtatChargementJaxb> {

    private static final List<String> MODE_TRANSPORT = Arrays.asList("01", "02");
    private static final List<String> DECISION_SELECTIVITE = Arrays.asList("AC", "VP");

    // probleme avec la date !!!! quelle date ? op ou bien message ?
    public Object[] validate(EtatChargementJaxb etatChargementJaxb, String xmlFileName) throws JAXBException, SAXException {
        return super.validate(etatChargementJaxb, "EC", etatChargementJaxb.getReferenceEtatChagement(), etatChargementJaxb.getHeader().getDateMessage(), xmlFileName);
    }

    @Override
    public void valiadteSyntaxicalRule(EtatChargementJaxb etatChargementJaxb) {
        String fonction = etatChargementJaxb.getHeader().getFonctionMessage();
        addErrorMessage(HeaderSyntaxicalValidator.validate(etatChargementJaxb.getHeader()));
        addErrorMessage(validateEtatChargement(etatChargementJaxb));
        if (fonction.equals("1") || fonction.equals("2")) {
            addErrorMessage(OperatorSynataxicalValidator.validate(etatChargementJaxb.getOperateurTransporteurTerrestre(),"OperateurTransporteurTerrestre"));
            addErrorMessage(VoyageSynataxicalValidator.validate(etatChargementJaxb.getVoyage()));
            addErrorMessage(TransporteurSynataxicalValidator.validate(etatChargementJaxb.getTransporteur(), etatChargementJaxb.getModeTransport()));
            addErrorMessage(MoyenTransportSyntaxicalValidator.validate(etatChargementJaxb.getMoyenTransports()));
            addErrorMessage(MarchandiseSousCouvertAutresDocumentsSyntaxicalValidator.validate(etatChargementJaxb.getMarchandiseSousCouvertAutresDocuments()));
            addErrorMessage(ExportateurSyntaxicalValidator.validate(etatChargementJaxb.getExportateur()));

        }
    }

    private static List<Object[]> validateEtatChargement(EtatChargementJaxb etatChargementJaxb) {
        List<Object[]> res = new ArrayList();
        String fonction = etatChargementJaxb.getHeader().getFonctionMessage();
        res.add(validateRefEtatChargement(etatChargementJaxb));
        res.add(validateDateEnregistrement(etatChargementJaxb));
        res.add(validateDateDepot(etatChargementJaxb));
        res.add(validateDecisionSelectivite(etatChargementJaxb));
        if (!fonction.equals("3")) {
            res.add(validateModeTransport(etatChargementJaxb));
            res.add(validateNumeroVersion(etatChargementJaxb));
            res.add(validateAgentControle(etatChargementJaxb));
        }
        return res;

    }

    public static Object[] validateRefEtatChargement(EtatChargementJaxb etatChargementJaxb) {
        return SyntaxicalValidator.isValideNumberLenghtAndMandatoryExist(etatChargementJaxb.getReferenceEtatChagement(), 17, true, "referenceEtatChargement");
    }

    private static Object[] validateModeTransport(EtatChargementJaxb etatChargementJaxb) {
        String modeTransport = etatChargementJaxb.getModeTransport();
        return SyntaxicalValidator.validateExistMandatoryStyle(modeTransport, MODE_TRANSPORT.indexOf(modeTransport) != -1, "modeTransport");
    }

    private static Object[] validateNumeroVersion(EtatChargementJaxb etatChargementJaxb) {
        return SyntaxicalValidator.isValideNumberLenghtAndMandatoryExist(etatChargementJaxb.getNumeroVersion(), 4, true, "numeroVersion");
    }

    private static Object[] validateDateEnregistrement(EtatChargementJaxb etatChargementJaxb) {
        return SyntaxicalValidator.validateDateAsObject(etatChargementJaxb.getDateEnregistrement(), "yyyy-MM-dd hh:mm", "dateEnregistrement", true);
    }

    private static Object[] validateDateDepot(EtatChargementJaxb etatChargementJaxb) {
        return SyntaxicalValidator.validateDateAsObject(etatChargementJaxb.getDateDepot(), "yyyy-MM-dd hh:mm", "dateDepot", false);
    }

    private static Object[] validateDecisionSelectivite(EtatChargementJaxb etatChargementJaxb) {
        String decisionSelectivite = etatChargementJaxb.getDecisionSelectivite();
        return SyntaxicalValidator.validateExistNotMandatoryStyle(decisionSelectivite, DECISION_SELECTIVITE.indexOf(decisionSelectivite) != -1, "decisionSelectivite");
    }

    private static Object[] validateAgentControle(EtatChargementJaxb etatChargementJaxb) {
        String agentControle = etatChargementJaxb.getAgentControle();
        return SyntaxicalValidator.isValideStringLenghtAndNotMandatoryExist(agentControle, 30, true, "agentControle");
    }

}
