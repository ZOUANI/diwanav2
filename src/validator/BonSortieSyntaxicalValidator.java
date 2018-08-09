package validator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBException;
import jaxb.vo.BonSortieJaxb;

import org.xml.sax.SAXException;
import util.NumberConverter;
import util.StringUtils;

public class BonSortieSyntaxicalValidator extends SyntaxicalValidator<BonSortieJaxb> {

    private final static List<String> TYPE_DECLARATION_DS = Arrays.asList("01", "03", "04", "05", "06", "07");
    private final static List<String> CODE_TYPE_CONTENANT = Arrays.asList("000", "001", "010", "020", "030", "040", "050", "060");

   
    // probleme avec la date !!!! quelle date ? op ou bien message ?
    public Object[] validate(BonSortieJaxb bonSortieJaxb, String xmlFileName) throws JAXBException, SAXException {
        return super.validate(bonSortieJaxb, "BS", bonSortieJaxb.getBon().getReferenceDS(), bonSortieJaxb.getHeader().getDateMessage(), xmlFileName);
    }

    @Override
    public void valiadteSyntaxicalRule(BonSortieJaxb bonSortieJaxb) {
        addErrorMessage(HeaderSyntaxicalValidator.validate(bonSortieJaxb.getHeader()));
        addErrorMessage(OperatorSynataxicalValidator.validate(bonSortieJaxb.getOperateur(),"Operateur"));
        addErrorMessage(DumSynataxicalValidator.validate(bonSortieJaxb.getDum()));
        addErrorMessage(validateBonSortie(bonSortieJaxb));
    }

    private static List<Object[]> validateBonSortie(BonSortieJaxb bonSortieJaxb) {
        List<Object[]> res = new ArrayList();
        String fonctionMessage = bonSortieJaxb.getHeader().getFonctionMessage();

        if ("3".equals(fonctionMessage) || "2".equals(fonctionMessage)) {
            res.add(validateReferenceBonSortieSyntaxe(bonSortieJaxb));
        }
        if ("1".equals(fonctionMessage) || "2".equals(fonctionMessage)) {

            res.add(validateTypeDs(bonSortieJaxb));
            res.add(validateTypeDsByRefDs(bonSortieJaxb));

            res.add(validateReferenceDs(bonSortieJaxb));

            res.add(validateLotDedouanement(bonSortieJaxb));
            res.add(validateLotDedouanementByRefDs(bonSortieJaxb));

            res.add(validateLieuChargement(bonSortieJaxb));
            res.add(validateLieuChargementByRefDs(bonSortieJaxb));

            res.add(validateTypeContenant(bonSortieJaxb));
            res.add(validateTypeContenantByRefDs(bonSortieJaxb));

            res.add(validateNombreContenantSyntax(bonSortieJaxb));
            res.add(validateNombreContenant(bonSortieJaxb));

            res.add(validateImmatrculationsVehicules(bonSortieJaxb));

            res.add(validateMarqueMarchandise(bonSortieJaxb));
            res.add(validateMarqueMarchandiseByRefDs(bonSortieJaxb));

            res.add(validatePoidsNetSyntaxe(bonSortieJaxb));

            res.add(validateTareSyntax(bonSortieJaxb));

            res.add(validatePoidsBrutSyntaxe(bonSortieJaxb));

            res.addAll(EquipementSyntaxicalValidator.validate(bonSortieJaxb.getBon().getEquipements(), false));
        }

        return res;

    }

    private static Object[] validateReferenceBonSortieSyntaxe(BonSortieJaxb bonSortie) {
        String bonReference = bonSortie.getBon().getReferenceBon();
        return isValideNumberLenghtAndMandatoryExist(bonReference, 22, true, "referenceBonSortieSyntaxe");
    }

    private static Object[] validateLotDedouanement(BonSortieJaxb bonSortie) {
        String lotDedouanement = bonSortie.getBon().getReferenceLot();
        return validateExistNotMandatoryStyle(lotDedouanement, (lotDedouanement != null && lotDedouanement.length() <= 10), "lotDedouanement");
    }

    // UN LOCODE ????
    private static Object[] validateLieuChargement(BonSortieJaxb bonSortie) {
        String lieuChargement = bonSortie.getBon().getLieuChargement();
        return validateExistNotMandatoryStyle(lieuChargement, (lieuChargement != null && lieuChargement.length() <= 10), "lieuChargement");
    }

    private static Object[] validateTypeContenant(BonSortieJaxb bonSortie) {
        String typeContenant = bonSortie.getBon().getTypeContenant();
        return validateExistNotMandatoryStyle(typeContenant, (typeContenant != null && typeContenant.length() <= 30), "typeContenant");
    }

    private static Object[] validateNombreContenantSyntax(BonSortieJaxb bonSortie) {
        String nombreContenant = bonSortie.getBon().getNombreContenant();
        return validateExistNotMandatoryStyle(nombreContenant, (NumberConverter.convertToLongAsBool(nombreContenant, 10, false)), "nombreContenantSyntax");
    }

    private static Object[] validateMarqueMarchandise(BonSortieJaxb bonSortie) {
        String marqueMarchandise = bonSortie.getBon().getMarqueMarchandise();
        return isValideStringLenghtAndMandatoryExist(marqueMarchandise, 30, false, "marqueMarchandise");
    }

    private static Object[] validateImmatrculationsVehicules(BonSortieJaxb bonSortie) {
        String immatrculationsVehicules = bonSortie.getBon().getImmatrculationsVehicules();
        return isValideStringLenghtAndMandatoryExist(immatrculationsVehicules, 30, false, "immatrculationsVehicules");
    }

    private static Object[] validateTypeDs(BonSortieJaxb bonSortie) {
        String typeDs = bonSortie.getBon().getTypeDS();
        return validateExistNotMandatoryStyle(typeDs, TYPE_DECLARATION_DS.indexOf(typeDs) != -1, "typeDs");
    }

    private static Object[] validateReferenceDs(BonSortieJaxb bonSortie) {
        String referenceDS = (bonSortie.getBon().getReferenceDS());
        return isValideNumberLenghtAndNotMandatoryExist(referenceDS, 17, true, "referenceDS");
    }

    private static Object[] validatePoidsNetSyntaxe(BonSortieJaxb bonSortie) {
        String poidsNet = bonSortie.getBon().getPoidsNet();
        return validateExistNotMandatoryStyle(poidsNet, (NumberConverter.convertToDecimalAsBool12Dot3(poidsNet)), "poidsNetSyntaxe");
    }

    private static Object[] validateTareSyntax(BonSortieJaxb bonSortie) {
        String tare = bonSortie.getBon().getTare();
        return validateExistNotMandatoryStyle(tare, (NumberConverter.convertToDecimalAsBool12Dot3(tare)), "tareSyntaxe");
    }

    private static Object[] validatePoidsBrutSyntaxe(BonSortieJaxb bonSortie) {
        String poidsBrut = bonSortie.getBon().getPoidsBrut();
        return validateExistNotMandatoryStyle(poidsBrut, (NumberConverter.convertToDecimalAsBool12Dot3(poidsBrut)), "poidsBrutSyntaxe");
    }

    private static Object[] validateTypeDsByRefDs(BonSortieJaxb bonSortie) {
        return isValide(bonSortie, bonSortie.getBon().getTypeDS(), "typeDsByRefDs");
    }

    private static Object[] validateLieuChargementByRefDs(BonSortieJaxb bonSortie) {
        return isValide(bonSortie, bonSortie.getBon().getLieuChargement(), "lieuChargementByRefDs");
    }

    private static Object[] validateLotDedouanementByRefDs(BonSortieJaxb bonSortie) {
        return isValide(bonSortie, bonSortie.getBon().getReferenceLot(), "lotDedouanementByRefDs");
    }

    private static Object[] validateTypeContenantByRefDs(BonSortieJaxb bonSortie) {
        return isValide(bonSortie, bonSortie.getBon().getTypeContenant(), "typeContenantByRefDs");
    }

    private static Object[] validateNombreContenant(BonSortieJaxb bonSortie) {
        int index = CODE_TYPE_CONTENANT.indexOf(bonSortie.getBon().getTypeContenant());
        int res;
        if (index == -1) {
            int notEmpty = StringUtils.isNotEmptyAsInt(bonSortie.getBon().getNombreContenant());
            if (notEmpty > 0) {
                res = NumberConverter.convertToBigInteger(bonSortie.getBon().getNombreContenant(), 0, false).compareTo(new BigInteger("0")) != 0 ? 1 : -2;
            } else {
                res = notEmpty;
            }
        } else {
            res = 2;
        }
        return new Object[]{res, "nombreContenant"};

    }

    private static Object[] validateMarqueMarchandiseByRefDs(BonSortieJaxb bonSortie) {
        int res;
        if (bonSortie.getBon().getReferenceDS() == null) {
            res = StringUtils.isNotEmptyAsInt(bonSortie.getBon().getMarqueMarchandise());
        } else {
            res = 2;
        }
        return new Object[]{res, "marqueMarchandiseByRefDs"};
    }

    private static Object[] isValide(BonSortieJaxb bonSortie, String element, String attributeName) {
        String referenceDs = bonSortie.getBon().getReferenceDS();
        return isValideAndMandatoryExist(referenceDs, element, attributeName);
    }
}
