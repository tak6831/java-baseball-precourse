package baseball.controller;

import baseball.entity.Ball;
import baseball.entity.BallCount;
import baseball.entity.Player;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballControllerTest {
    BaseballController baseballController = new BaseballController();
    //    임의의 1-9까지 서로다른 수 생성 숫자가 겹칠 수 있어서 사용하지 않음.
    @Test
    void 랜덤한_숫자만들기(){
        for(int i=0;i<baseballController.makeRandomNumber().size();i++){
            assertThat(baseballController.makeRandomNumber().get(i))
                    .as("0보다 크고 10 보다 작은 정수")
                    .isGreaterThan(0)
                    .isLessThan(10);
        }
    }
//    생성된 수 볼배합에 넣기.
    @Test
    void 생성된_수_볼배합에_넣기(){
        Ball ball = baseballController.putNumberToEntity();
        System.out.println(ball.toString());
        assertThat(ball.isReady()).isTrue();
    }
//    플레이어에게 1-9 서로다른 수 입력 받기.
    @Test
    void 플레이어에게_서로다른_수_입력받기(){
        //readLine 테스트를 어떻게 해야하는지?
        Player player = baseballController.inputNumberFromPlayer();
        assertThat(player).isInstanceOf(Player.class);
    }
//    입력 값 검증
    @Test
    void 중복된수입력체크(){
        assertThatThrownBy(() -> {
            baseballController.validationUniqueNumber(new Player(1, 2, 2));
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 입력한_수_범위체크(){
        assertThatThrownBy(() -> {
            baseballController.validationInRange(new Player(1,2,0));
        }).isInstanceOf(IllegalArgumentException.class);
    }
//    검증 후 결과 값 리턴
    @Test
    void 볼카운트확인() {
        BallCount ballCount = baseballController.checkBallCount(new Ball(1, 2, 9), new Player(1, 3, 2));
//        assertThat(ballCount.getStrike()).isEqualTo(1);
        assertThat(ballCount.getBall()).isEqualTo(1);
    }
    @Test
    void 결과값출력(){
        assertThat(baseballController.printScore(new BallCount(1,1))).isEqualTo("낫싱");
    }
//    정답 시 게임 종료
    @Test
    void 쓰리스트라이크종료(){
        assertThatThrownBy(() -> {
            baseballController.gameSet(new BallCount(3,0));
        }).isInstanceOf(InterruptedException.class);
    }
//    에러 시 앱 종료
//    게임 종료시 게임 다시하기 및 앱 종료.
}