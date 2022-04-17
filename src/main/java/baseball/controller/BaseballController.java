package baseball.controller;

import baseball.entity.Ball;

import java.util.List;
import java.util.Random;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballController {

//      임의의 1-9까지 서로다른 수 생성
    public int makeRandomNumber(){
        return pickNumberInRange(1,9);
    }
//    생성된 수 볼배합에 넣기.
    public Ball putNumberToEntity(){
        return new Ball(makeRandomNumber(),makeRandomNumber(),makeRandomNumber());
    }
//    플레이어에게 1-9 서로다른 수 입력 받기.
    public void inputNumberFromPlayer(){
        readLine();
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
