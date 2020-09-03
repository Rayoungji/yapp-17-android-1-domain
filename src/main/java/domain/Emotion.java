package domain;

public class Emotion {
    private EmotionColor color;
    private String emotion;

    public Emotion(EmotionColor color, String emotion) {
        this.color = color;
        this.emotion = emotion;
    }

    public static Emotion createEmotion(EmotionColor color, String emotion) {
        return new Emotion(color,emotion);
    }

    public void updateEmotion(String emotion) {
       this.emotion = emotion;
    }

    public String getEmotion(){
        return this.emotion;
    }
}
