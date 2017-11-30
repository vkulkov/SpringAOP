package com.springinaction.general;

public class Juggler implements Performer {
    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() {
        System.out.println("Juggling " + beanBags + " beanbags");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
    }
}
