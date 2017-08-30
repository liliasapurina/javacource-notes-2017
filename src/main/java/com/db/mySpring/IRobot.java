package com.db.mySpring;

import javax.annotation.PostConstruct;

import static com.db.mySpring.Scope.*;

/**
 * Created by Evegeny on 28/08/2017.
 */
@Benchmark
@Component(scope = SINGLETON)
public class IRobot {
    private Speaker speaker;

    @PostConstruct
    public void init() {
        System.out.println(speaker.getClass());
    }

    @InjectByType
    private Cleaner cleaner;

    @InjectByType
    private void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public void cleanRoom() {
        speaker.speak("я начал уборку");
        cleaner.clean();
        speaker.speak("я закончил уборку");
    }

}
