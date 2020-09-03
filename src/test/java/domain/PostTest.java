package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.jeasy.random.EasyRandom;

class PostTest {

    @Test
    @DisplayName("게시글 생성 성공")
    void testCreatePostSuccess() {
        //given
        Emotion emotion = new Emotion(EmotionColor.RED, "분노");
        LatLng latLng = new LatLng(0.11111, 1.12345);
        Image image = new EasyRandom().nextObject(Image.class);
        Image image2 = new EasyRandom().nextObject(Image.class);
        List<Image> imageList = new ArrayList<>();
        imageList.add(image);
        imageList.add(image2);

        //when
        Post post = Post.createPost(latLng, "서울시 성북구", "서울시",
                "게시물 테스트", imageList, emotion, LocalDate.now());

        //then
        assertThat(post).isNotNull();

    }

    @Test
    @DisplayName("게시글 상세 조회시 모든 이미지 url 출력")
    void testGetPostImages() throws Exception {
        //given
        Emotion emotion = new Emotion(EmotionColor.RED, "분노");
        LatLng latLng = new LatLng(0.11111, 1.12345);
        Image image = new EasyRandom().nextObject(Image.class);
        Image image2 = new EasyRandom().nextObject(Image.class);
        List<Image> imageList = new ArrayList<>();
        imageList.add(image);
        imageList.add(image2);
        Post post = Post.createPost(latLng, "서울시 성북구", "서울시",
                "게시물 테스트", imageList, emotion, LocalDate.now());

        //when
        List<Image> imagesForPost= post.getImages();

        //then
        assertThat(imagesForPost.get(0).getImageUrl()).isEqualTo(image.getImageUrl());
        assertThat(imagesForPost.get(1).getImageUrl()).isEqualTo(image2.getImageUrl());
    }

    @Test
    @DisplayName("게시글 전체 조회 시 이미지 url은 랜덤으로 하나 출력")
    void testGetPostRandomImage() {
        //given
        Posts postList = new EasyRandom().nextObject(Posts.class);

        //when
        String getRandomImage = postList.getPosts().get(0).getRandomImage();

        //then
        assertThat(getRandomImage).isNotEqualTo(postList.getPosts().get(0).getImages());
    }
}
