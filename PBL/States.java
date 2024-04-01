import java.util.LinkedList;

public class States {
    private String stateName;
    private LinkedList<Crops> crops;
    private CropCountData highestCountCrop;

    public States(String name, Crops crop) {
        stateName = name;
        crops = new LinkedList<>();
        crops.add(crop);
        highestCountCrop = new CropCountData(crop.getCropName(), 1); // Initialize with the first crop and count 1
    }

    public String getStateName() {
        return stateName;
    }

    public void setCropdata(Crops crop) {
        crops.add(crop);
        updateHighestCountCrop(crop);
    }

    public LinkedList<Crops> getCropdata() {
        return crops;
    }

    public CropCountData getHighestCountCrop() {
        return highestCountCrop;
    }

    // Method to update the highest count crop
    private void updateHighestCountCrop(Crops crop) {
        for (Crops c : crops) {
            if (c.getCropName().equals(crop.getCropName())) {
                c.increaseCount(); // Increase count for the corresponding crop
                if (c.getCropCount() > highestCountCrop.getCropCount()) {
                    highestCountCrop = new CropCountData(c.getCropName(), c.getCropCount());
                }
                return; // Crop count updated, no need to continue searching
            }
        }
    }
}
