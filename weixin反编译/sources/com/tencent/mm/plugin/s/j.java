package com.tencent.mm.plugin.s;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    long aep;
    public long aqA;
    boolean kYN;
    ag ovF;
    ag ovG;
    ag ovH;
    long ovI;
    boolean ovJ = false;
    public k ovK;
    boolean ovL = false;
    a ovM;
    private a ovN = new a() {
        public final boolean handleMessage(Message message) {
            x.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", j.this.ovj.atw(), Integer.valueOf(message.what), Integer.valueOf(j.this.state), Integer.valueOf(j.this.ovK.state));
            boolean z;
            switch (message.what) {
                case 0:
                    if (j.this.ovJ && (j.this.kYN || j.this.ovL)) {
                        j.this.ovk.obtainMessage(6).sendToTarget();
                        break;
                    }
                case 2:
                    int z2;
                    if (j.this.state < 2) {
                        z2 = 1;
                    } else {
                        z2 = false;
                    }
                    if (z2 != 0) {
                        z2 = d.sN(j.this.ovK.state);
                        if (j.this.ovM != null) {
                            z2 &= d.sN(j.this.ovM.state);
                        }
                        if (z2) {
                            j.this.setState(2);
                            j.this.ovk.obtainMessage(1).sendToTarget();
                            break;
                        }
                    }
                    break;
                case 7:
                    j.a(j.this);
                    break;
                case 9:
                    if (!d.sQ(j.this.state)) {
                        if (!d.sR(j.this.state) && !d.sP(j.this.state)) {
                            z2 = d.sQ(j.this.ovK.state);
                            if (j.this.ovM != null) {
                                z2 &= d.sQ(j.this.ovM.state);
                            }
                            if (z2) {
                                j.this.setState(9);
                                j.this.ovk.obtainMessage(2).sendToTarget();
                                break;
                            }
                        }
                        j.this.setState(9);
                        j.this.ovk.obtainMessage(2).sendToTarget();
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private a ovO = new a() {
        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (!j.this.ovK.bap()) {
                        j.this.ovk.obtainMessage(5, -1, -1).sendToTarget();
                        break;
                    }
                    j.this.aqA = j.this.ovK.aqA;
                    j.this.a(j.this.ovF, SystemClock.elapsedRealtime(), 0);
                    break;
                case 2:
                    g gVar = j.this.ovj;
                    long bB = bi.bB(gVar.ovb);
                    if (gVar.ovb > 0 && bB >= 30) {
                        x.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", gVar.atw(), Long.valueOf(gVar.ovb), Long.valueOf(bB));
                        gVar.ovc = 0;
                    }
                    if (!d.sQ(j.this.ovK.state)) {
                        boolean z;
                        int x = j.this.ovK.x(j.this.aep, j.this.ovI);
                        if (d.sN(x)) {
                            j.this.ovH.obtainMessage(2).sendToTarget();
                        }
                        if (x == 7) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            if (!d.sS(x)) {
                                if (j.this.state == 3) {
                                    j.this.a(j.this.ovF, SystemClock.elapsedRealtime(), j.this.ovj.ovc);
                                } else if (j.this.state == 5) {
                                    j.this.a(j.this.ovF, SystemClock.elapsedRealtime(), 0);
                                } else if (j.this.state == 1) {
                                    j.this.a(j.this.ovF, SystemClock.elapsedRealtime(), 0);
                                } else if (j.this.state == 0) {
                                    j.this.a(j.this.ovF, SystemClock.elapsedRealtime(), 0);
                                } else if (j.this.state == 6) {
                                    j.this.a(j.this.ovF, SystemClock.elapsedRealtime(), 0);
                                } else {
                                    j.this.ovF.removeMessages(2);
                                }
                                j.this.ovj.ovb = bi.Wz();
                                break;
                            }
                            j.this.a(j.this.ovF, SystemClock.elapsedRealtime(), 0);
                            j.this.ovj.ovb = bi.Wz();
                            break;
                        }
                        j.this.ovH.obtainMessage(7).sendToTarget();
                        j.this.ovF.removeMessages(2);
                        break;
                    }
                    j.this.ovH.obtainMessage(9).sendToTarget();
                    j.this.ovF.removeMessages(2);
                    break;
                case 3:
                    j.this.sW(3);
                    j.this.ovK.start();
                    j.this.a(j.this.ovF, SystemClock.elapsedRealtime(), 0);
                    break;
                case 4:
                    j.this.sW(4);
                    j.this.a(j.this.ovF, SystemClock.elapsedRealtime(), 0);
                    j.this.ovK.pause();
                    break;
                case 7:
                    j.this.ovK.release();
                    j.this.ovJ = true;
                    j.this.ovH.obtainMessage(0).sendToTarget();
                    break;
            }
            return false;
        }
    };
    private a ovP = new a() {
        public final boolean handleMessage(Message message) {
            if (j.this.ovM != null) {
                switch (message.what) {
                    case 1:
                        if (!j.this.ovM.bap()) {
                            j.this.ovM = null;
                        }
                        j.this.a(j.this.ovG, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 2:
                        if (!d.sQ(j.this.ovM.state)) {
                            if (d.sN(j.this.ovM.x(j.this.aep, j.this.ovI))) {
                                j.this.ovH.sendMessageDelayed(j.this.ovH.obtainMessage(2), 10);
                            }
                            if (j.this.state != 3) {
                                if (j.this.state != 5) {
                                    if (j.this.state != 1) {
                                        if (j.this.state != 0) {
                                            j.this.ovG.removeMessages(2);
                                            break;
                                        }
                                        j.this.a(j.this.ovG, SystemClock.elapsedRealtime(), 0);
                                        break;
                                    }
                                    j.this.a(j.this.ovG, SystemClock.elapsedRealtime(), 0);
                                    break;
                                }
                                j.this.a(j.this.ovG, SystemClock.elapsedRealtime(), 0);
                                break;
                            }
                            j.this.a(j.this.ovG, SystemClock.elapsedRealtime(), j.this.ovj.ovc);
                            break;
                        }
                        j.this.ovH.obtainMessage(9).sendToTarget();
                        j.this.ovG.removeMessages(2);
                        break;
                    case 3:
                        j.this.ovM.start();
                        j.this.a(j.this.ovG, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 4:
                        j.this.a(j.this.ovG, SystemClock.elapsedRealtime(), 0);
                        j.this.ovM.pause();
                        break;
                    case 7:
                        j.this.ovM.release();
                        j.this.ovL = true;
                        j.this.ovH.obtainMessage(0).sendToTarget();
                        break;
                }
            }
            return false;
        }
    };
    public g ovj;
    ag ovk;
    int state;

    static /* synthetic */ void a(j jVar) {
        x.i("MicroMsg.VideoPlayerImpl", "%s seek done", jVar.ovj.atw());
        jVar.ovK.setState(5);
        if (jVar.ovM != null) {
            jVar.ovj.ova = jVar.ovM.sU((int) jVar.ovj.ouY);
            jVar.ovM.setState(5);
        }
        jVar.sW(7);
        jVar.setState(4);
        jVar.ovk.obtainMessage(3, 0, 0).sendToTarget();
        jVar.ovj.ouZ = jVar.ovj.ouY * 1000;
        jVar.ovj.ouY = -1;
    }

    public j(ag agVar, Looper looper, Looper looper2, Looper looper3, boolean z) {
        this.ovk = agVar;
        this.kYN = false;
        this.ovj = new g(this.kYN);
        this.ovH = new ag(looper, this.ovN);
        this.ovK = new k(this.ovj, this.ovk);
        this.ovF = new ag(looper2, this.ovO);
        if (looper3 != null) {
            this.ovM = new a(this.ovj, this.ovk);
            this.ovG = new ag(looper3, this.ovP);
        }
    }

    public final void bar() {
        x.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", this.ovj.atw(), Long.valueOf(this.ovj.ouZ));
        if (this.ovK != null) {
            this.ovK.y(this.ovj.ouZ, -1);
            this.ovK.ban();
            this.ovK.ovn = 0;
        }
    }

    public final void bas() {
        if (this.ovK != null) {
            x.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", this.ovj.atw());
            this.ovK.setState(10);
            a(this.ovF, SystemClock.elapsedRealtime(), 0);
        }
    }

    public final void start() {
        setState(3);
        this.ovF.obtainMessage(3).sendToTarget();
        if (this.ovM != null) {
            this.ovG.obtainMessage(3).sendToTarget();
        }
    }

    public final void pause() {
        setState(4);
        this.ovF.obtainMessage(4).sendToTarget();
        if (this.ovM != null) {
            this.ovG.obtainMessage(4).sendToTarget();
        }
    }

    public final void G(int i, boolean z) {
        x.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", this.ovj.atw(), Integer.valueOf(i), Boolean.valueOf(true));
        this.ovK.pause();
        if (this.ovM != null) {
            this.ovM.pause();
        }
        if (((long) i) >= this.aqA) {
            x.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", Integer.valueOf(i), Long.valueOf(this.aqA));
            setState(6);
            this.ovH.obtainMessage(9).sendToTarget();
            return;
        }
        long sU = this.ovK.sU(i);
        boolean z2 = sU >= 0 && sU < ((long) i);
        x.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", this.ovj.atw(), Boolean.valueOf(z2), Long.valueOf(sU), Integer.valueOf(i));
        this.ovK.setState(6);
        setState(6);
        if (z2) {
            this.ovj.ouY = (long) i;
        } else {
            this.ovj.ouY = sU;
        }
        sW(6);
        a(this.ovF, SystemClock.elapsedRealtime(), 0);
    }

    public final void stop() {
        setState(8);
    }

    public final void release() {
        setState(9);
        this.ovH.removeMessages(2);
        this.ovH.removeMessages(9);
        this.ovF.removeMessages(1);
        this.ovF.removeMessages(2);
        this.ovF.removeMessages(3);
        this.ovF.removeMessages(4);
        this.ovF.removeMessages(6);
        this.ovF.removeCallbacksAndMessages(null);
        try {
            this.ovK.setState(9);
            x.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", r0.atw(), Boolean.valueOf(this.ovK.ovR));
            if (this.ovK.ovR && d.fP(19)) {
                this.ovK.kM();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoPlayerImpl", e, "release error %s", e.toString());
        }
        this.ovF.obtainMessage(7).sendToTarget();
        if (this.ovG != null) {
            this.ovG.removeMessages(1);
            this.ovG.removeMessages(2);
            this.ovG.removeMessages(3);
            this.ovG.removeMessages(4);
            this.ovG.removeMessages(6);
            this.ovG.obtainMessage(7).sendToTarget();
        }
        g gVar = this.ovj;
        gVar.ouW = 0;
        gVar.ouX = 0;
        gVar.ouY = -1;
        gVar.aep = 0;
        gVar.ouZ = 0;
        gVar.ova = 0;
    }

    protected final void setState(int i) {
        x.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d stack %s", this.ovj.atw(), Integer.valueOf(this.state), Integer.valueOf(i), bi.chl());
        this.state = i;
        this.ovj.ovb = 0;
    }

    final void sW(int i) {
        x.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", this.ovj.atw(), Integer.valueOf(i), Long.valueOf(this.ovj.ouW), Long.valueOf(this.ovj.ouX), Long.valueOf(this.ovj.aep));
        g gVar;
        switch (i) {
            case 3:
                if (this.ovj.ouX > 0) {
                    gVar = this.ovj;
                    gVar.aep += this.ovj.ouX - this.ovj.ouW;
                    this.ovj.ouX = 0;
                }
                this.ovj.ouW = SystemClock.elapsedRealtime();
                break;
            case 4:
                if (this.ovj.ouW > 0) {
                    this.ovj.ouX = SystemClock.elapsedRealtime();
                    break;
                }
                this.ovj.ouX = 0;
                break;
            case 5:
                this.ovj.aep = this.ovj.ouY;
                this.ovj.ouW = SystemClock.elapsedRealtime();
                this.ovj.ouX = 0;
                gVar = this.ovj;
                this.ovj.ova = 0;
                gVar.ouZ = 0;
                break;
            case 6:
                this.ovj.aep = this.ovj.ouY;
                gVar = this.ovj;
                this.ovj.ouX = 0;
                gVar.ouW = 0;
                gVar = this.ovj;
                this.ovj.ova = 0;
                gVar.ouZ = 0;
                break;
            case 7:
                this.ovj.aep = this.ovj.ouY;
                gVar = this.ovj;
                this.ovj.ouX = 0;
                gVar.ouW = 0;
                break;
        }
        this.ovI = this.ovj.ouW;
        this.aep = this.ovj.aep;
        x.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", this.ovj.atw(), Integer.valueOf(i), Long.valueOf(this.ovI), Long.valueOf(this.aep));
    }

    private void a(ag agVar, long j, long j2) {
        if (!d.sQ(this.state)) {
            try {
                Thread thread = agVar.getLooper().getThread();
                if (!(thread == null || thread.isAlive())) {
                    return;
                }
            } catch (Exception e) {
            }
            agVar.removeMessages(2);
            long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                agVar.sendEmptyMessage(2);
            } else {
                agVar.sendEmptyMessageDelayed(2, elapsedRealtime);
            }
        }
    }
}
