package com.db.mySpring;

/**
 * Created by Evegeny on 28/08/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        /* IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();

        while (true) {
            iRobot.cleanRoom();
            Thread.sleep(3500);
        } */

        IRobot iRobot1 = ApplicationContext.getInstance().getComponent(IRobot.class);
        iRobot1.cleanRoom();
        IRobot iRobot2 = ApplicationContext.getInstance().getComponent(IRobot.class);

        if(iRobot1==iRobot2){
            System.out.println("Objects are equal to each other!");
        }

   /*     Worker worker = ObjectFactory.getInstance().createObject(Worker.class);
        worker.drinkBeer();
        worker.work();*/

    }
}
