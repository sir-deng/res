package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public enum i {
    ;
    
    public ah jcC;
    public final f jcD;
    public final g jcE;
    public final h jcF;
    public e jcG;
    public Boolean jcH;
    public boolean jcI;
    public volatile boolean jcJ;
    public long jcK;
    public String mAppId;

    private i(String str) {
        this.jcC = null;
        this.jcD = new f();
        this.jcE = new g();
        this.jcF = new h();
        this.jcH = null;
        this.jcI = false;
        this.jcJ = false;
    }

    public static boolean a(int i, double d) {
        boolean z;
        x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.shouldEnableReport gamePercentage = [%f]", Double.valueOf(d));
        if (new Random(((long) i) ^ System.nanoTime()).nextDouble() <= d) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WAGamePerfManager", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f]", Boolean.valueOf(z), Double.valueOf(r4), Double.valueOf(d));
        return z;
    }

    public final h aey() {
        h hVar;
        synchronized (jcB) {
            if (this.jcJ) {
                hVar = this.jcF;
            } else {
                hVar = null;
            }
        }
        return hVar;
    }

    public final f aez() {
        f fVar;
        synchronized (jcB) {
            if (this.jcJ && this.jcI) {
                fVar = this.jcD;
            } else {
                fVar = null;
            }
        }
        return fVar;
    }

    public final g aeA() {
        g gVar;
        synchronized (jcB) {
            if (this.jcJ) {
                gVar = this.jcE;
            } else {
                gVar = null;
            }
        }
        return gVar;
    }

    public final ah aeB() {
        if (this.jcC == null) {
            this.jcC = new ah("WAGamePerfManager_thread");
        }
        return this.jcC;
    }
}
