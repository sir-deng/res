package com.tencent.mm.plugin.ipcall.a.e;

public class a {
    public boolean fBn = false;

    public void start() {
        reset();
        this.fBn = true;
    }

    public void reset() {
    }

    protected void aUI() {
    }

    public final void finish() {
        if (this.fBn) {
            aUI();
            this.fBn = false;
        }
    }
}
