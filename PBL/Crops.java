import java.util.LinkedList;

public class Crops {
    private String cropName;
    private String year;
    private String district;
    private int size=0;

    Crops(String district,String cropName, String year) {
        this.cropName = cropName;
        this.year = year;
        this.district = district;
        size++;
    }

    Crops(String cropName, String year) {
        this.cropName = cropName;
        this.year = year;
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
}

class CropCountData implements Comparable<CropCountData> {

    private String cropName;
    private int cropCount;
    CropCountData(String cropName, int cropCount) {
        this.cropName = cropName;
        this.cropCount = cropCount;
    }

    int getCropCount(){
        return cropCount;
    }

    @Override
    public int compareTo(CropCountData o) {
        return Integer.compare(this.cropCount,o.cropCount);
    }

    public String getData() {
        return cropName + " " + cropCount;
    }
}

class CropYearData {
    String year;
    LinkedList<Crops> cropData;

    CropYearData(String year) {
        this.year = year;
        cropData = new LinkedList<>();
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
