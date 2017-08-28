package tdd;

import lombok.SneakyThrows;

public class NDSResolverImpl {
    @SneakyThrows
    public double getNDS(){
        Thread.sleep(3000);
        return 0.18;
    };
}
