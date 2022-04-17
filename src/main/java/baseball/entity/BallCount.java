package baseball.entity;

public class BallCount {
    private int strike;
    private int ball;

    public BallCount() {

    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "BallCount{" +
                "strike=" + strike +
                ", ball=" + ball +
                '}';
    }

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

}
