import java.awt.image.CropImageFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    String filePath = "D:\\JAVAA\\uni\\Sir Mohsin Project\\India Agriculture Crop Production.csv";
    LinkedList<States> allStates = new LinkedList<>();
    Stack<CropCountData> cropCount = new Stack<>();

    // step 1
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

    // step 2
    void setCropCount(LinkedList<Crops> cropData) {
        Crops tempDuplicate = cropData.getFirst();
        int counter = 0;

        for (int i = 1; i < cropData.size(); i++) {
            Crops crop = cropData.get(i);
            if(tempDuplicate.equals(crop)) {
                counter++;
            } else {
                if(cropCount.isEmpty()) {
                    cropCount.push(new CropCountData(tempDuplicate.getCropName(), counter));
                } else {
                    setSequenceOfCrop();
                }
                tempDuplicate = crop;
                counter = 0;
            }
        }
    }

    //step 2
    void setSequenceOfCrop() {
//      int highCount = cropCount.firstElement().getCropCount();
//
//      for(CropCountData data : cropCount) {
//          if(highCount<data.getCropCount()) {
//              cropCount.peek();
//          }
//      }
    }

    public static void main(String[] args) {

    }

}
