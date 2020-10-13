package com.hh.designerspatterns.com.hh.designerspattern.buidpattern.second;
//建造者模式（链式调用)
//1.需要建造的东西 2.抽象建造者 3.具体建造者
public class BuildPattern1 {
    public static void main(String[] args) {
        SingRobotBuilder robotBuilder=new SingRobotBuilder();
        Robot robot=robotBuilder.buildHead("头")
                .buildBody("身体")
                .buildHand("手")
                .buildFoot("脚")
                .build();
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
    RobotBuilder buildHead(String head);
    RobotBuilder buildBody(String body);
    RobotBuilder buildHand(String hand);
    RobotBuilder buildFoot(String foot);
    Robot build();
}

//唱歌机器人建造者（具体建造者)
class SingRobotBuilder implements RobotBuilder {
    private Robot robot;

    public SingRobotBuilder() {
        this.robot = new Robot();
    }

    @Override
    public RobotBuilder buildHead(String head) {
        robot.setHead(head);
        return this;
    }

    @Override
    public RobotBuilder buildBody(String body) {
        robot.setBody(body);
        return this;
    }

    @Override
    public RobotBuilder buildHand(String hand) {
        robot.setHand(hand);
        return this;
    }

    @Override
    public RobotBuilder buildFoot(String foot) {
        robot.setFoot(foot);
        return this;
    }

    @Override
    public Robot build() {
        return robot;
    }

}


