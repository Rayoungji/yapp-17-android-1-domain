package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmotionTest {

    @Test
    @DisplayName("감정과 색깔 생성 성공")
    public void testCreatEmotionSuccess() throws Exception {
        //when
        Emotion e = new Emotion(Color.YELLOW,"행복함");

        //then
        assertThat(e).isNotNull();
    }

}
