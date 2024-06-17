package com.example.projectboard.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("비지니스 로직 - 페이지네이션")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = PaginationService.class) // 기본값 Mock. port등의 환경도 지정 가능 class는 원래는 root
class PaginationServiceTest {

    private final PaginationService sut;

    public PaginationServiceTest(@Autowired PaginationService paginationService) {
        this.sut = paginationService;
    }

    @DisplayName("현재 페이지 번호와 총 페이지 수를 주면, 페이징 바 리스트를 반환한다.")
    @MethodSource // static으로 이름 같은 메서드 만들기
    @ParameterizedTest(name = "[{index}] 현재 페이지: {0}, 총 페이지: {1} => {2}") // patameter test
    void givenCurrentPageNumberAndTotalPages_whenCalculating_thenReturnPaginationBarNumbers(int currentPageNumber, int totalPages, List<Integer> expected) {
        // Given

        // When
        List<Integer> actual = sut.getPaginationBarNumbers(currentPageNumber, totalPages);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> givenCurrentPageNumberAndTotalPages_whenCalculating_thenReturnPaginationBarNumbers() {
        // Parameter test써서 여러 개 테스트해볼 수 있음
        return Stream.of(
                arguments(0, 123, List.of(0, 1, 2, 3, 4)), // Page 0부터 시작
                arguments(1, 123, List.of(0, 1, 2, 3, 4)),
                arguments(2, 123, List.of(0, 1, 2, 3, 4)),
                arguments(3, 123, List.of(1, 2, 3, 4, 5)),
                arguments(4, 123, List.of(2, 3, 4, 5, 6)),
                arguments(5, 123, List.of(3, 4, 5, 6, 7)),
                arguments(6, 123, List.of(4, 5, 6, 7, 8)),
                arguments(7, 123, List.of(5, 6, 7, 8, 9)),
                arguments(8, 123, List.of(6, 7, 8, 9, 10)),
                arguments(9, 123, List.of(7, 8, 9, 10, 11)),
                arguments(10, 123, List.of(8, 9, 10, 11, 12)),
                arguments(11, 123, List.of(9, 10, 11, 12, 13)),
                arguments(12, 123, List.of(10, 11, 12, 13 ,14))
        );
    }

    @DisplayName("현재 설정되어있는 페이지네이션 바의 길이를 알려준다.") // 페이지네이션 바 길이 알려주기 위한 테스트
    @Test
    void givenNothing_whenCalling_thenReturnsCurrentBarLength() {
        // Given

        // When
        int barLength = sut.currentBarLength();

        // Then
        assertThat(barLength).isEqualTo(5);
    }

}