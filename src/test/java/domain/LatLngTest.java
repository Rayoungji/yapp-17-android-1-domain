package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LatLngTest {

    @ParameterizedTest
    @ValueSource(doubles = {1234.1234,12.19385746})
    @DisplayName("위도가 7자리가 아닐 시 예외처리")
    void testCreateLatFail(double lat) {

        //예외처리 테스트 - 첫번째 인자(나와야 할 예외처리에 대한 클래스), 두번째 인자(실행 클래스)
        assertThrows(IllegalArgumentException.class, () -> new LatLng(lat,12.123456));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1234.1234,12.1234567})
    @DisplayName("경도가 6자리가 아닐 시 예외처리")
    void testCreateLngFail(double lng) {

        assertThrows(IllegalArgumentException.class,() -> new LatLng(12.1234567,lng));
    }

    @Test
    @DisplayName("좌표 생성")
    void testCreateLatLngSuccess() {
        //when
        LatLng latLng = new LatLng(0.1234567,12.123456);

        //then
        assertThat(latLng).isNotNull();
    }

}
