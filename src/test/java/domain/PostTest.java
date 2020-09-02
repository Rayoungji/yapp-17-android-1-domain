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

/*
* TDD (Test Driven Development) - 테스트 주도 개발
* 과정 : 실패 테스트 케이스 -> 성공 시키기 (이과정에서 도메인 모델링을 하게된다) ->테스트 성공 후 리팩토링
*
* DDD(Domain Driven Development) - 도메인 주도 개발
* 도메인 모델 : 하나의 도메인 클래스에 도메인 필드 & 도메인 로직이 존재하는 것
* 핵심 비즈니스 로직은 도메인 모델에 작성해야 한다는 것이 DDD의 가장 중요한 핵심
* why? 코드 응집성 증가, 중복되는 코드를 줄이기 위함
* 만약 도메인에 도메인 로직을 넣다가 도메인이 비대해진다면 "관심사의 분리"를 기억하라 !!
* = 같은 도메인이어도 사용되는 맥락이 다르면 엔티티(도메인)을 별도로 매핑하라 (=bounded context)
* -> 로직의 중복이 생기는거 아뉘냥 ?  맞다 하지만 프로젝트가 커지고 하나의 도메인에 여러 일들이 일어난다면
* 로직의 중복 증가에서 오는 비용보다 관심사의 분리와 응집성 분리에서 오는 효용이 훨씬 큼 ㅋㄷㅋㄷ
* - 현업에서의 경험 : 민감한 중요로직도 안전하게 분리하고 관리가 가능
*                 같은 맥락 안에서의 도메인 로직의 응집성이 높아짐 -> 맥락 이해도 증가
*                 필요한 연관관계를 최소한으로 매핑할 수 있음
* DDD 참고 자료 : http://jaynewho.com/post/45
*
* 음 그니까 도메인 모델에 핵!심! 도메인 로직을 작성하라는 듯!!!!!!!!!!!!!!!!
* 핵!심! 도메인 로직이 줠라리 헷갈리긴 함 ㅋ
*
* 질문 : 1. 도메인로직이란 정확히 무엇인지 왜 조회는 도메인 로직이 아닌지
*       답변 : 도메인 객체를 순수하게 생성 수정하는 일들을 도메인 로직이라함 !
*             그러므로 조회는 도메인 객체를 변화하는 것이 아니고 또한 DTO에 따라 달라질 수 있으므로 도메인 클래스에 작성하지 않는다!
*       2. 도메인 모델에 도메인로직을 작성하므로써의 장점이 무엇인지 그럼 서비스 계층은 사라지는건지? 도메인 로직을 서비스 계층에서 사용하는건지?
*       코드의 응집성이 무엇인지 어떤 경우에 중복되는 코드가 줄어드는지,,,!!!!
** */

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
