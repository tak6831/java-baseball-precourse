package baseball.controller;

import java.util.Random;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballController {

    Randoms randoms;
//    생성된 수 배열에 넣기.
    public int putNumberToArray(int start, int end){
        return randoms.pickNumberInRange(start,end);
    }
//    플레이어에게 1-9 서로다른 수 입력 받기.
    public void inputNumberFromPlayer(){

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
