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

    public List<Integer> makeRandomNumber(){
        return pickUniqueNumbersInRange(1,9,3);
    }
    public Ball putNumberToEntity(){
        Ball ball = new Ball();
        List<Integer> list = makeRandomNumber();
        ball.setFirstNumber(list.get(0));
        ball.setSecondNumber(list.get(1));
        ball.setThirdNumber(list.get(2));
        return ball;
    }
    public Player inputNumberFromPlayer(){
        /** 실제사용 **/
        Player player = new Player();
        System.out.println("1~9까지 3자리를 입력해 주세요.");
        String inputString = readLine();
        if(inputString.length()!=3) throw new IllegalArgumentException("입력 갯 수 에러");
        player.setFirstNumber(Integer.parseInt(inputString.substring(0,1)));
        player.setSecondNumber(Integer.parseInt(inputString.substring(1,2)));
        player.setThirdNumber(Integer.parseInt(inputString.substring(2,3)));
        System.out.println("입력하신 볼배합 : "+player.toString());
        return player;
    }
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
    public boolean gameSet(BallCount ballCount){
        if(ballCount.getStrike()==3) return true;
        return false;
    }

    public void playingLogic(Ball ball){
        Player player = new Player();
        BallCount ballCount = new BallCount();
        while (!gameSet(ballCount)){
            player = inputNumberFromPlayer();
            validationUniqueNumber(player);
            validationInRange(player);
            ballCount = checkBallCount(ball,player);
            System.out.println(printScore(ballCount));
        }
    }
}
