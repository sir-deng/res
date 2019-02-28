package com.tencent.mm.compatible.b;

import java.util.concurrent.locks.Lock;

public final class a {
    public int gDA = 0;
    public int gDB = 0;
    public boolean gDC = false;
    public Lock gDD = null;
    public int gDx = 0;
    public int gDy = 0;
    public byte[] gDz = null;

    public final int xL() {
        if (this.gDC) {
            this.gDD.lock();
        }
        if (this.gDA == this.gDB) {
            return 0;
        }
        if (this.gDA < this.gDB) {
            this.gDy = this.gDB - this.gDA;
        } else if (this.gDA > this.gDB) {
            this.gDy = (this.gDB + this.gDx) - this.gDA;
        }
        if (this.gDC) {
            this.gDD.unlock();
        }
        return this.gDy;
    }
}
