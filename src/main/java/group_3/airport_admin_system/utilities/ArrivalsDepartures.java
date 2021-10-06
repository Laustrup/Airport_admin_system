package group_3.airport_admin_system.utilities;

/*!!TEST CLASS!!*/
//Dummy class used to check if capture groups are caught
public class ArrivalsDepartures {

    private String dato, arrdep, routenumber, stastd, ac;

    public ArrivalsDepartures(String dato, String arrdep, String routenumber, String stastd, String ac) {
        this.dato = dato;
        this.arrdep = arrdep;
        this.routenumber = routenumber;
        this.stastd = stastd;
        this.ac = ac;
    }

    @Override
    public String toString(){
        return "" + dato + " " + arrdep + " " + routenumber + " " + stastd + " " + ac;
    }
}
