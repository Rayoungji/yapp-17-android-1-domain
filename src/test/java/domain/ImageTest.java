package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ImageTest {

    @Test
    @DisplayName("이미지 생성 성공")
    void testCreateImageSuccess() throws Exception {
        //when
        Image image = new Image("imgUrl");

        //then
        assertThat(image).isNotNull();
    }
}
