package com.db.mySpring;

/**
 * Created by Evegeny on 28/08/2017.
 */
public class Main {
    public static void main(String[] args) {
       /* IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();*/

        Worker worker = ObjectFactory.getInstance().createObject(Worker.class);
        worker.drinkBeer();
        worker.work();

    }
}
