import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
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
            boolean firstLine = true;
            boolean firstIteration = true;
            States previousState = null;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                States state;
                Crops crop = new Crops(data[1], data[2], data[3]);

                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the first line
                }

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
                        LinkedList<Crops> previousStateCropData = previousState.getCropdata();

                        for(Crops c: previousStateCropData) {
                            System.out.println(c.getCropName()+" "+c.getYear());
                        }

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

        for(Crops c: cropData) {
            System.out.println(c.getCropName()+" "+c.getYear());
        }
//        String tempDuplicate = cropData.getFirst().getCropName();
//        int counter = 1;
//
//        for (int i = 1; i < cropData.size(); i++) {
//            Crops crop = cropData.get(i);
//            if(tempDuplicate.equals(crop.getCropName())) {
//                counter++;
//            } else {
//                cropCount.push(new CropCountData(tempDuplicate, counter));
//                tempDuplicate = crop.getCropName();
//                counter = 1;
//            }
//        }

    }


    public static void main(String[] args) {
        Main main = new Main();
        main.storingStates();
    }

}
