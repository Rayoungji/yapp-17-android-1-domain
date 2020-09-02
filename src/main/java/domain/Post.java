package domain;

import java.time.LocalDate;
import java.util.List;

public class Post {
    private double lat;
    private double lng;
    private String address;
    private String content;
    private String city;
    private LocalDate createdDate;
    private List<Image> imageList;
    private Emotion emotion;

    public Post(double lat, double lng, String address, String content, String city, LocalDate createdDate, List<Image> imageList, Emotion emotion) {
        checkLocationLat(lat);
        checkLocationLng(lng);
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.content = content;
        this.city = city;
        this.createdDate = createdDate;
        this.imageList = imageList;
        this.emotion = emotion;
    }

    public static void checkLocationLat(double lat) {
        String x = String.valueOf(lat);
        String str[] = x.split("\\.");
        int length = str[1].length();

        if (length != 6) {
            throw new IllegalArgumentException("위도는 소수점 6자리까지 작성하여주세요");
        }
    }

    public static void checkLocationLng(double lng) {
        String x = String.valueOf(lng);
        String str[] = x.split("\\.");
        int length = str[1].length();

        if (length != 7) {
            throw new IllegalArgumentException("경도는 소수점 7자리까지 작성하여주세요");
        }
    }

}
