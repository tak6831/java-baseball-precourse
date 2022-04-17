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
        Player player = new Player();
        System.out.println("1~9까지 3자리를 입력해 주세요.");
        String inputString = readLine();
        if(inputString.length()!=3) throw new IllegalArgumentException("입력 갯 수 에러");
        player.setFirstNumber(Integer.parseInt(inputString.substring(0,1)));
        player.setSecondNumber(Integer.parseInt(inputString.substring(1,2)));
        player.setThirdNumber(Integer.parseInt(inputString.substring(2,3)));
        System.out.println("입력한 볼 배합 : "+player.toString());
        return player;
    }
    public void validationUniqueNumber(Player player){
        if(player.getFirstNumber()==player.getSecondNumber()
                ||player.getSecondNumber()==player.getThirdNumber()
                ||player.getThirdNumber()==player.getFirstNumber()) throw new IllegalArgumentException("중복된 수를 입력했습니다.");
    }
    public void validationInRange(Player player){
        for(int i : player.toList()) checkNumber(i);
    }
    public void checkNumber(int i){
        if(i<1 || i>9) throw new IllegalArgumentException("범위에 벗어난 수를 입력하셨습니다.");
    }
    public BallCount checkBallCount(Ball ball, Player player){
        BallCount ballCount = new BallCount();
        for(int i=0;i<player.toList().size();i++){
            putBallCount(ballCount, ball, player, i);
        }
        return ballCount;
    }
    public void putBallCount(BallCount ballCount, Ball ball, Player player, int i){
        if(player.toList().get(i)==ball.toList().get(i)){
            ballCount.setStrike(ballCount.getStrike()+1);
            return;
        }
        if(ball.toList().contains(player.toList().get(i))){
            ballCount.setBall(ballCount.getBall()+1);
            return;
        };
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
        BallCount ballCount = new BallCount();
        while (!gameSet(ballCount)){
            Player player = inputNumberFromPlayer();
            validationUniqueNumber(player);
            validationInRange(player);
            ballCount = checkBallCount(ball,player);
            System.out.println(printScore(ballCount));
        }
    }
}
