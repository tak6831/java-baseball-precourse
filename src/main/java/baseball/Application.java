package baseball;

import baseball.controller.BaseballController;
import baseball.entity.Ball;
import baseball.entity.BallCount;
import baseball.entity.Player;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        // TODO: 프로그램 구현

        Thread thread = new Thread() {
            @Override
            public void run(){
                while(true){
                    Ball ball = new Ball();
                    System.out.println("야구 게임을 시작합니다.");
                    ball = baseballController.putNumberToEntity();
                    System.out.println("볼 배합 완료");
                    System.out.println("플레이어 차레입니다.");
                    baseballController.playingLogic(ball);
                    System.out.println("다시시작 하시겠습니까? Yes:1 / No:2");
                    if(!readLine().equals("1")) break;
                }
            };
        };
        thread.start();
    }

}
