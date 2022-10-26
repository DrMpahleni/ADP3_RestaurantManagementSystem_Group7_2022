package za.ac.cput.factory.role;

import za.ac.cput.domain.role.Receptionist;
import za.ac.cput.util.genericHelper;

public class ReceptionistFactory {

    public static Receptionist createReceptionist(String receptionId, int positionId) {
        String receptionID = genericHelper.generateId();
        Receptionist receptionist = new Receptionist.Builder().setReceptionId(receptionId).setPositionId(positionId).build();
        return receptionist;
    }

}
