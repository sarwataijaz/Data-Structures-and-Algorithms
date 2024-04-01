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

                        if (previousState.getStateName().equals(stateName)) {
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
                    cropCount.push(new CropCountData(tempDuplicate, counter));
                    tempDuplicate = crop.getCropName();
                    counter = 1;

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
        Set<String> yearSet = new HashSet<>();

        for (int i = 0; i < cropData.size(); i++) {
            String year = cropData.get(i).getYear();

            if (!yearSet.contains(year)) {
                CropYearData yearData = new CropYearData(year);

                for (int j = i; j < cropData.size(); j++) {
                    if (year.equals(cropData.get(j).getYear())) {
                        yearData.addCropdata(cropData.get(j));
                    }
                }
                oneStateData.add(yearData);
                yearSet.add(year);
            }
        }

    }


    // problem 1
    void popularCropInParticularYear(String year) {

        Map<String, Integer> cropCounts = new HashMap<>();

        // Iterate over all states and their crop data
        for (States state : allStates) {
            LinkedList<Crops> cropData = state.getCropdata();
            for (Crops crop : cropData) {
                if (crop.getYear().equals(year)) {
                    String cropName = crop.getCropName();
                    cropCounts.put(cropName, cropCounts.getOrDefault(cropName, 0) + 1);
                }
            }
        }

        // Find the popular crop(s) with the highest count
        LinkedList<String> popularCrops = new LinkedList<>();
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : cropCounts.entrySet()) {
            int count = entry.getValue();
            if (count > maxCount) {
                popularCrops.clear(); // Clear previous popular crops
                popularCrops.add(entry.getKey());
                maxCount = count;
            } else if (count == maxCount) {
                popularCrops.add(entry.getKey());
            }
        }

        if (!popularCrops.isEmpty()) {
            System.out.println("Popular crop in " + year + ": " + popularCrops + "-> Count: " + maxCount);
        } else {
            System.out.println("No crop data available for the year " + year);
        }

    }

    // problem 2
    void getStatePopularityForCrops() {
        for (States state : allStates) {
            String stateName = state.getStateName();
            CropCountData highestCountCrop = state.getHighestCountCrop();

            // Print the highest count crop for the current state
            System.out.println("The most popular crop for " + stateName + " is: " + highestCountCrop.getCropName());
        }
    }

    // problem 3

    void getRecentCropOfAndraPradesh() {
        if (oneStateData.getSize() == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        String recentYear = oneStateData.first().getYear();
        CropYearData recent = oneStateData.first();

        // Find the most recent year
        for (int i = 1; i < oneStateData.getSize(); i++) {
            CropYearData current = oneStateData.first();
            String currentYear = current.getYear();
            if (currentYear.compareTo(recentYear) > 0) {
                recentYear = currentYear;
                recent = current;
            }
            oneStateData.add(oneStateData.remove()); // Move the current element to the end of the queue
        }

        LinkedList<Crops> crops = recent.getCropData();
        System.out.println("The most recent crop of Andhra Pradesh is:");
        for (Crops crop : crops) {
            System.out.println(crop.getCropName());
        }
    }

    void getOldestCropOfAndraPradesh() {
        if (oneStateData.getSize() == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        String oldestYear = oneStateData.first().getYear();
        CropYearData oldest = oneStateData.first();

        // Find the oldest year
        for (int i = 1; i < oneStateData.getSize(); i++) {
            CropYearData current = oneStateData.first();
            String currentYear = current.getYear();
            if (currentYear.compareTo(oldestYear) < 0) {
                oldestYear = currentYear;
                oldest = current;
            }
            oneStateData.add(oneStateData.remove()); // Move the current element to the end of the queue
        }

        LinkedList<Crops> oldestCrops = oldest.getCropData();
        System.out.println("The oldest crop of Andhra Pradesh is:");
        for (Crops crop : oldestCrops) {
            System.out.println(crop.getCropName());
        }
    }



    public static void main (String[]args){
            Main main = new Main();

            main.storingStates();

            main.popularCropInParticularYear("2001-02");
            main.getOldestCropOfAndraPradesh();
            main.getRecentCropOfAndraPradesh();
            main.getStatePopularityForCrops();
        }

    }

