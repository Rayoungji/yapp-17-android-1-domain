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
    @DisplayName("게시글 생성 성공")
    void testCreatePostSuccess() throws Exception {

    }

    @Test
    @DisplayName("게시글 생성 시 이미지가 없을 때 예외처리")
    void testNoImageException() throws Exception {

    }

    @Test
    @DisplayName("게시글 상세 조회시 모든 이미지 url 출력")
    void testGetPostImages() throws Exception {

    }

    @Test
    @DisplayName("게시글 전체 조회 시 이미지 url은 랜덤으로 하나 출력")
    void testGetPostRandomImage() throws Exception {

    }
}
