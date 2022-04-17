package baseball.controller;

import baseball.entity.Ball;
import baseball.entity.BallCount;
import baseball.entity.Player;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class BaseballController {

//      임의의 1-9까지 서로다른 수 생성
    public List<Integer> makeRandomNumber(){
        return pickUniqueNumbersInRange(1,9,3);
    }
//    생성된 수 볼배합에 넣기.
    public Ball putNumberToEntity(){
        Ball ball = new Ball();
        List<Integer> list = makeRandomNumber();
        ball.setFirstNumber(list.get(0));
        ball.setSecondNumber(list.get(1));
        ball.setThirdNumber(list.get(2));
        return ball;
    }
//    플레이어에게 1-9 서로다른 수 입력 받기.
    public Player inputNumberFromPlayer() throws IllegalArgumentException{
        /** 실제사용 **/
        Player player = new Player();
        System.out.println("1~9까지 중복되지 않는 볼 배합을 입력해 주세요.");
        System.out.println("첫번쨰 숫자 :");
        player.setFirstNumber(Integer.parseInt(readLine()));
        System.out.println("두번째 숫자 :");
        player.setSecondNumber(Integer.parseInt(readLine()));
        System.out.println("세번째 숫자 :");
        player.setThirdNumber(Integer.parseInt(readLine()));
        System.out.println("입력하신 볼배합 : "+player.toString());
        return player;
    }
//    public Player inputNumberFromPlayerTest() throws IllegalArgumentException{
//        /**테스트용**/
//        Player player = new Player();
//        System.out.println("1~9까지 중복되지 않는 볼 배합을 입력해 주세요.");
//        System.out.println("첫번쨰 숫자 :");
//        player.setFirstNumber(Integer.parseInt("1"));
//        System.out.println("두번째 숫자 :");
//        player.setSecondNumber(Integer.parseInt("2"));
//        System.out.println("세번째 숫자 :");
//        player.setThirdNumber(Integer.parseInt("2"));
//        return player;
//    }
    //    입력 값 검증
    public void validationUniqueNumber(Player player){
        if(player.getFirstNumber()==player.getSecondNumber()
                ||player.getSecondNumber()==player.getThirdNumber()
                ||player.getThirdNumber()==player.getFirstNumber()) throw new IllegalArgumentException("중복된 수를 입력했습니다.");
    }
    public void validationInRange(Player player){
        for(int i : player.toList()){
            if(i<1 || i>9){
                throw new IllegalArgumentException("범위에 벗어난 수를 입력하셨습니다.");
            }
        }
    }
//    검증 후 결과 값 리턴
    public BallCount checkBallCount(Ball ball, Player player){
        int strikeScore = 0;
        int ballScore = 0;

        for(int i=0;i<player.toList().size();i++){
            if(player.toList().get(i)==ball.toList().get(i)){
                strikeScore++;
                continue;
            }
            if(ball.toList().contains(player.toList().get(i))){
                ballScore++;
                continue;
            };
        }

        return new BallCount(strikeScore,ballScore);
    }
    public String printScore(BallCount ballCount){
        String result = "";
        if(ballCount.getBall()!=0) result += ballCount.getBall()+"볼";
        if(ballCount.getStrike()!=0) result += ballCount.getStrike()+"스트라이크";
        if(result=="") result = "낫싱";
        return result;
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
