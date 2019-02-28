package com.tencent.mm.plugin.appbrand.game.e;

public abstract class c implements Runnable {
    e<c> jdF;

    public abstract void execute();

    public void run() {
        execute();
        if (this.jdF != null) {
            this.jdF.j(this);
        }
    }
}
