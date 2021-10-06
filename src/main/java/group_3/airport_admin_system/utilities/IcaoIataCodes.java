package group_3.airport_admin_system.utilities;

/*!!TEST CLASS!!*/
//Dummy class used to check if capture groups are caught
public class IcaoIataCodes {

    private String iCAOCode, iATACode, aircraftModel, wakecategory;

    public IcaoIataCodes(String iCAOCode, String iATACode, String aircraftModel, String wakecategory) {
        this.iCAOCode = iCAOCode;
        this.iATACode = iATACode;
        this.aircraftModel = aircraftModel;
        this.wakecategory = wakecategory;
    }

    @Override
    public String toString(){

        return "" + iCAOCode + " " + iATACode + " " + aircraftModel + " " + wakecategory;
    }
}
