import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    String filePath = "D:\\JAVAA\\uni\\Sir Mohsin Project\\India Agriculture Crop Production.csv";
    LinkedList<States> allStates = new LinkedList<>();
    Stack<CropCountData> cropCount = new Stack<>();
    LinkedListQueue<CropYearData> oneStateData = new LinkedListQueue();
    String stateName = "Andhra Pradesh";


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

                        setCropCount(previousStateCropData);

                        if(previousState.getStateName().equals(stateName)) {
                            // the whole crop data of Andra Pradesh state being passed
                            addQueueData(previousStateCropData);
                        }

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


        String tempDuplicate = cropData.getFirst().getCropName();

        int counter = 1;

        for (int i = 1; i < cropData.size(); i++) {
            Crops crop = cropData.get(i);
            if (tempDuplicate.equals(crop.getCropName())) {
                counter++;
            } else {
                if (counter != 1) {
                    cropCount.push(new CropCountData(tempDuplicate, counter));
                    tempDuplicate = crop.getCropName();
                    counter = 1;
                }
            }
        }

        sortStackData();

    }

    // step 2
    void sortStackData() {
        Stack<CropCountData> tempStack = new Stack<>();

        while (!cropCount.isEmpty()) {
            CropCountData temp = cropCount.pop();

            // Move elements from the original stack to the temporary stack
            while (!tempStack.isEmpty() && tempStack.peek().compareTo(temp) > 0) {
                cropCount.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        // Move elements back from the temporary stack to the original stack
        while (!tempStack.isEmpty()) {
            cropCount.push(tempStack.pop());
        }

    }

    // step 3
    void addQueueData(LinkedList<Crops> cropData) {
        String year = cropData.getFirst().getYear();

        for(int i = 0; i < cropData.size(); i++) {
            if(!year.equals(cropData.get(i).getYear()) || i==0) {
                CropYearData yearData = new CropYearData(year);
                year = cropData.get(i).getYear();

                for(int j = i; j<cropData.size(); j++) {
                    if(year.equals(cropData.get(j).getYear())) {
                        yearData.addCropdata(cropData.get(j));
                    }
                }
                oneStateData.add(yearData);
            }
        }

//        while (oneStateData.getSize() > 0) {
//            CropYearData temp = oneStateData.first();
//            System.out.println("Year: " + temp.getYear());
//            LinkedList<Crops> ll = temp.getCropData();
//            for (int j = 0; j < ll.size(); j++) {
//                System.out.println(ll.get(j).getCropName());
//            }
//            System.out.println();
//            oneStateData.remove();
//        }


    }


        public static void main (String[]args){
            Main main = new Main();
            main.storingStates();
        }

    }

