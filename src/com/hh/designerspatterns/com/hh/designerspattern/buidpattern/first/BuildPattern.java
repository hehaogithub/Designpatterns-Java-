package com.hh.designerspatterns.com.hh.designerspattern.buidpattern.first;
//建造者模式
//1.需要建造的东西 2.抽象建造者 3.具体建造者 4.指挥者
public class BuildPattern {
    public static void main(String[] args) {
        SingRobotBuilder singRobotBuilder=new SingRobotBuilder();
        Director director=new Director(singRobotBuilder);
        Robot robot=director.makeRobot();
        System.out.println(robot);
    }
}
//建造的具体(产品)
class  Robot{
    private String head;
    private String body;
    private String hand;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", hand='" + hand + '\'' +
                ", foot='" + foot + '\'' +
                '}';
    }
}
//抽象建造者
interface  RobotBuilder{
    void buildHead();
    void buildBody();
    void buildHand();
    void buildFoot();
    Robot build();
}

//唱歌机器人建造者（具体建造者)
class SingRobotBuilder implements RobotBuilder{
    private Robot robot;

    public SingRobotBuilder() {
        this.robot = new Robot();
    }

    @Override
    public void buildHead() {
        robot.setHead("大脑写入歌曲");
    }

    @Override
    public void buildBody() {
        robot.setBody("灵活的身体");
    }

    @Override
    public void buildHand() {
        robot.setHand("灵活的手");
    }

    @Override
    public void buildFoot() {
        robot.setFoot("可以跳的脚");
    }

    @Override
    public Robot build() {
        return robot;
    }

}

//指挥者，负责指挥建造步骤，具体建造工作仍由建造者
class Director{
    RobotBuilder robotBuilder;

    public Director(RobotBuilder robotBuilder) {
        this.robotBuilder = robotBuilder;
    }
    public Robot makeRobot(){
        robotBuilder.buildBody();
        robotBuilder.buildHead();
        robotBuilder.buildHand();
        robotBuilder.buildFoot();
        return robotBuilder.build();
    }
}
