import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    String filePath = "D:\\JAVAA\\uni\\Sir Mohsin Project\\India Agriculture Crop Production.csv";
    LinkedList<States> allStates = new LinkedList<>();
    Stack<CropCountData> cropCount = new Stack<>();
    public void storingStates() {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstIteration = true;
            States previousState = null;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                States state;
                Crops crop = new Crops(data[1], data[2], data[3]);

                if (firstIteration) {
                    state = new States(data[0], crop);
                    allStates.add(state);
                    previousState = state;
                    firstIteration = false;
                } else {
                    if (previousState.getStateName().equals(data[0])) { // sem state but diff crop data
                        previousState.setCropdata(crop);
                    } else {
                        // as the previous state data has been collected, we need to look for the crop count of it then move forward
                        LinkedList previousStateCropData = previousState.getCropdata();
                        setCropCount(previousStateCropData);
                        state = new States(data[0], crop);
                        allStates.add(state);
                        previousState = state;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setCropCount(LinkedList<Crops> cropData) {
        Crops tempDuplicate = cropData.get(0);
        int counter = 0;

        for(Crops crop: cropData) {
            if(tempDuplicate.equals(crop)) {
                counter++;
            } else {
                cropCount.add(new CropCountData(tempDuplicate.getCropName(), counter));
                tempDuplicate = crop;
                counter = 0;
            }
        }
    }

    public static void main(String[] args) {

    }

}
