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

    public Post(double lat, double lng, String address, String content, String city,
                LocalDate createdDate, List<Image> imageList, Emotion emotion) {
        this.lat = lat;
        this.lng = lng;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.content = content;
        this.city = city;
        this.createdDate = createdDate;
        this.imageList = imageList;
        this.emotion = emotion;
    }

    public Post createPost(LatLng latLng, String address, String city,
                           String content, List<Image> imageList, Emotion emotion, LocalDate createdDate){
        return new Post(latLng.getLat(), latLng.getLng(), address, content, city, createdDate, imageList, emotion);
    }
}
