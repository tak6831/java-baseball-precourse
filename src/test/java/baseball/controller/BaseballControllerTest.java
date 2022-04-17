package baseball.controller;

import baseball.entity.Ball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballControllerTest {
    BaseballController baseballController = new BaseballController();
    //    임의의 1-9까지 서로다른 수 생성
    @Test
    void 랜덤한숫자만들기(){
        assertThat(baseballController.makeRandomNumber())
                .as("0보다 크고 10 보다 작은 정수")
                .isGreaterThan(0)
                .isLessThan(10);
    }
//    생성된 수 볼배합에 넣기.
    @Test
    void 생성된수볼배합에넣기(){
        Ball ball = baseballController.putNumberToEntity();
        System.out.println(ball.toString());
        assertThat(ball.isReady()).isTrue();
    }
//    플레이어에게 1-9 서로다른 수 입력 받기.
//    입력 값 검증
//    검증 후 결과 값 리턴
//    정답 시 게임 종료
//    에러 시 앱 종료
//    게임 종료시 게임 다시하기 및 앱 종료.

    @Test
    void makeRandomNumber() {
    }

    @Test
    void putNumberToArray() {
    }

    @Test
    void inputNumberFromPlayer() {
    }

    @Test
    void confirmNumber() {
    }

    @Test
    void printScore() {
    }

    @Test
    void gameSet() {
    }

    @Test
    void errorToPowerOff() {
    }

    @Test
    void retryAndPowerOff() {
    }
}