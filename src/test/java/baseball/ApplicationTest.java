package baseball;

import baseball.controller.BaseballController;
import camp.nextstep.edu.missionutils.test.NsTest;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    BaseballController baseballController;
//    임의의 1-9까지 서로다른 수 생성
    @Test
    void 랜덤한숫자만들기(){
        baseballController.makeRandomNumber();
    }
//    생성된 수 배열에 넣기.
//    플레이어에게 1-9 서로다른 수 입력 받기.
//    입력 값 검증
//    검증 후 결과 값 리턴
//    정답 시 게임 종료
//    에러 시 앱 종료
//    게임 종료시 게임 다시하기 및 앱 종료.

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
