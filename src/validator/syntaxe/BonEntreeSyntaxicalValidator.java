package validator.syntaxe;

import javax.xml.bind.JAXBException;
import jaxb.vo.BonEntreeJaxb;

import org.xml.sax.SAXException;

public class BonEntreeSyntaxicalValidator extends SyntaxicalValidator<BonEntreeJaxb> {

    
    // probleme avec la date !!!! quelle date ? op ou bien message ?
    @Override
    public Object[] validate(BonEntreeJaxb bonEntreeJaxb, String xmlFileName) throws JAXBException, SAXException {
        return super.validate(bonEntreeJaxb, "BE", bonEntreeJaxb.getAMP().getNumAMP(), bonEntreeJaxb.getDateOperation(), xmlFileName);
    }

    @Override
    public void valiadteSyntaxicalRule(BonEntreeJaxb bonEntreeJaxb) {
        String fonction = bonEntreeJaxb.getHeader().getFonctionMessage();
        addErrorMessage(HeaderSyntaxicalValidator.validate(bonEntreeJaxb.getHeader()));
        addErrorMessage(AMPSynataxicalValidator.validate(bonEntreeJaxb.getAMP()));
        addErrorMessage(validateDateOpeartion(bonEntreeJaxb.getDateOperation()));
        if (fonction.equals("1") || fonction.equals("2")) {
            addErrorMessage(DumSynataxicalValidator.validate(bonEntreeJaxb.getDums()));
            addErrorMessage(UniteSynataxicalValidator.validate(bonEntreeJaxb.getUnite()));
            addErrorMessage(EtatChargementSynataxicalValidator.validateRefEtatChargement(bonEntreeJaxb.getEtatChargement()));
        }
    }

    private static Object[] validateDateOpeartion(String dateOperation) {
        return SyntaxicalValidator.validateDateAsObject(dateOperation, "dateOperation", true);
    }

}
