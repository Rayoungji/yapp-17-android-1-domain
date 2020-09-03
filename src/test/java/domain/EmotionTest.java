package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmotionTest {

    @Test
    @DisplayName("감정 생성 성공")
    void testCreateEmotionSuccess() {
        //when
        Emotion emotion = Emotion.createEmotion(EmotionColor.BLUE,"상쾌하다");

        //then
        assertThat(emotion).isNotNull();
    }

    @Test
    @DisplayName("감정 수정 성공")
    void testUpdateEmotionSuccess() {
        //given
        Emotion emotion = Emotion.createEmotion(EmotionColor.ORANGE, "행복");

        //when
        emotion.updateEmotion("슬픔");

        //then
        assertThat(emotion.getEmotion()).isEqualTo("슬픔");

    }
}
