package org.kurtlike;

import java.util.concurrent.TimeUnit;

public abstract class SpaceAnimation implements Runnable {
    private final long frameTime; // nano seconds
    private boolean active = false;
    public SpaceAnimation(int frameFrequency){
        this.frameTime = (long)((Math.pow(10,9)/frameFrequency));
    }

    public abstract void handle();


    @Override
    public void run() {
        while (active) {
            long start = System.nanoTime();
            handle();
            long end = System.nanoTime();
            try {
               TimeUnit.NANOSECONDS.sleep(frameTime - (end - start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void start(){
        active = true;
        Thread thread = new Thread(this);
        thread.setName("animation");
        thread.start();
    }
    public void stop(){
        active = false;
    }

    public long getFrameTime() {
        return frameTime;
    }
}
