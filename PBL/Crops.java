public class Crops {
    private String cropName;
    private String year;
    private String district;

    Crops(String district,String cropName, String year) {
        this.cropName = cropName;
        this.year = year;
        this.district = district;
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
