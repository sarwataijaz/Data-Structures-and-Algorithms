import java.util.LinkedList;

public class Crops {
    private String cropName;
    private String year;
    private String district;
    private int size=0;
    int cropCount;

    Crops(String district,String cropName, String year) {
        this.cropName = cropName;
        this.year = year;
        this.district = district;
        size++;
    }

    String getCropName() {
        return cropName;
    }

    String getYear() {
        return year;
    }
    int getSize() {
        return size;
    }
    int getCropCount() {
        return cropCount;
    }

    void increaseCount() {
        cropCount++;
    }
}

class CropCountData implements Comparable<CropCountData> {

    private String cropName;
    public int cropCount;
    CropCountData(String cropName, int cropCount) {
        this.cropName = cropName;
        this.cropCount = cropCount;
    }

    int getCropCount(){
        return cropCount;
    }

    String getCropName() { return cropName; }

    @Override
    public int compareTo(CropCountData o) {
        return Integer.compare(this.cropCount,o.cropCount);
    }

    public String getData() {
        return cropName + " " + cropCount;
    }
}

class CropYearData {
    int cropCount;
    String year;
    LinkedList<Crops> cropData;

    CropYearData(String year) {
        this.year = year;
        cropData = new LinkedList<>();
        cropCount = 0; // Initialize crop count to 0
    }

    void addCropdata(Crops crop) {
        cropData.add(crop);
    }

    String getYear() {
        return year;
    }

    LinkedList<Crops> getCropData() {
        return cropData;
    }

}
