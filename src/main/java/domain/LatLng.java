package domain;

public class LatLng {
    private double lat;
    private double lng;

    public LatLng(double lat, double lng) {
        int STANDARDLAT = 7;
        validateLatLng(lat, STANDARDLAT);
        int STANDARDLNG = 6;
        validateLatLng(lng, STANDARDLNG);
        this.lat = lat;
        this.lng = lng;
    }

    public void validateLatLng(double latLng, int standard){
        String split[] = Double.toString(latLng).split("\\.");
        int latLngSize = split[1].length();

        if(standard==7 && latLngSize!=7){
            throw new IllegalArgumentException("위도는 7자리여야 합니다");
        }
        if(standard==6 && latLngSize!=6){
            throw new IllegalArgumentException("경도는 6자리여야 합니다");
        }
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return  lng;
    }
}
