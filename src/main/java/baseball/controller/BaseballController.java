package baseball.controller;

import baseball.entity.Ball;
import baseball.entity.Player;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class BaseballController {

//      임의의 1-9까지 서로다른 수 생성
    public List<Integer> makeRandomNumber(){
        return pickUniqueNumbersInRange(1,9,3);
    }
//    생성된 수 볼배합에 넣기.
    public Ball putNumberToEntity(){
        Ball ball = new Ball();
        ball.setFirstNumber(makeRandomNumber().get(0));
        ball.setSecondNumber(makeRandomNumber().get(1));
        ball.setThirdNumber(makeRandomNumber().get(2));
        return ball;
    }
//    플레이어에게 1-9 서로다른 수 입력 받기.
    public Player inputNumberFromPlayer() throws IllegalArgumentException{
        Player player = new Player();
        System.out.println("1~9까지 중복되지 않는 볼 배합을 입력해 주세요.");
        System.out.println("첫번쨰 숫자");
//        player.setFirstNumber(Integer.parseInt(readLine()));
        player.setFirstNumber(Integer.parseInt("1"));
        System.out.println("두번째 숫자");
//        player.setFirstNumber(Integer.parseInt(readLine()));
        player.setSecondNumber(Integer.parseInt("2"));
        System.out.println("세번째 숫자");
//        player.setFirstNumber(Integer.parseInt(readLine()));
        player.setThirdNumber(Integer.parseInt("3"));
        System.out.println("입력하신 볼배합 : "+player.toString());

        return player;
    }
//    입력 값 검증
    public void confirmNumber(){

    }
//    검증 후 결과 값 리턴
    public void printScore(){

    }
//    정답 시 게임종료
    public void gameSet(){

    }
//    에러 시 앱 종료
    public void errorToPowerOff(){

    }
//    게임 종료시 게임 다시하기 및 앱 종료.
    public void retryAndPowerOff(){

    }
}
