import java.util.LinkedList;

public class States {
    private String stateName;
    private LinkedList<Crops> crops;

    String getStateName() {
        return stateName;
    }
    States(String name, Crops crop) {
        stateName = name;
        crops =  new LinkedList<>();
        crops.add(crop);
    }

    void setCropdata(Crops crop) {
        crops.add(crop);
    }

    LinkedList<Crops> getCropdata() {
        return crops;
    }
}
