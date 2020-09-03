package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PostTest {

    @Test
    @DisplayName("게시글 생성")
    public void testCreatePost() throws Exception {
        //given
        Emotion emotion = new Emotion(Color.ORANGE, "즐거움");
        LocalDate createdDate = LocalDate.now();
        Image image1 = new EasyRandom().nextObject(Image.class);
        Image image2 = new EasyRandom().nextObject(Image.class);
        List<Image> imageList = new ArrayList<>();
        imageList.add(image1);
        imageList.add(image2);

        //when
        Post post = new Post(
                1.111111, 0.11111111,
                "서울시 성북구", "게시글 생성 테스트",
                "서울시", createdDate, imageList, emotion
        );

        //then
        assertThat(post).isNotNull();

    }

    @ParameterizedTest
    @ValueSource(doubles = {0.11111, 1.11111111, 0.980767})
    @DisplayName("위도가 6자리가 아니면 예외처리")
    void testLatFail(double lat) throws Exception {
        //given
        Emotion emotion = new Emotion(Color.ORANGE, "즐거움");
        LocalDate createdDate = LocalDate.now();
        Image image1 = new EasyRandom().nextObject(Image.class);
        Image image2 = new EasyRandom().nextObject(Image.class);
        List<Image> imageList = new ArrayList<>();
        imageList.add(image1);
        imageList.add(image2);

        assertThrows(IllegalArgumentException.class, () -> new Post(
                lat, 0.11111111,
                "서울시 성북구", "게시글 생성 테스트",
                "서울시", createdDate, imageList, emotion
        ));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2222222686, 1234.121234})
    @DisplayName("경도가 7자리가 아니면 예외처리")
    void testLngFail(double lng) throws Exception {
        //given
        Emotion emotion = new Emotion(Color.ORANGE, "즐거움");
        LocalDate createdDate = LocalDate.now();
        Image image1 = new EasyRandom().nextObject(Image.class);
        Image image2 = new EasyRandom().nextObject(Image.class);
        List<Image> imageList = new ArrayList<>();
        imageList.add(image1);
        imageList.add(image2);

        assertThrows(IllegalArgumentException.class, () -> new Post(
                0.123456, lng,
                "서울시 성북구", "게시글 생성 테스트",
                "서울시", createdDate, imageList, emotion
        ));
    }
}
