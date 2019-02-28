package com.tencent.mm.plugin.music.model.g;

import android.os.Looper;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a implements c {
    public boolean fBx;
    private ar oQe;
    protected boolean oQf;
    protected com.tencent.mm.plugin.music.model.g.c.a oQg;
    public String oRJ = "";

    protected final void bfc() {
        this.oQe = new ar();
        this.oQe.eW(ad.getContext());
        this.oQe.a(new com.tencent.mm.sdk.platformtools.ar.a() {
            public final void fj(int i) {
                switch (i) {
                    case 0:
                        if (a.this.oQf) {
                            a.this.oQf = false;
                            a.this.resume();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        if (a.this.Qx()) {
                            a.this.oQf = true;
                            a.this.pause();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public final void bfd() {
        if (this.oQe != null) {
            this.oQe.end();
            this.oQe.cgF();
        }
    }

    public final void n(ati ati) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onPreparintEvent %b", Boolean.valueOf(Qx()));
        this.oRJ = "waiting";
        b jtVar = new jt();
        jtVar.fBu.action = 11;
        jtVar.fBu.fBq = ati;
        jtVar.fBu.state = "waiting";
        jtVar.fBu.duration = (long) getDuration();
        jtVar.fBu.fBw = bev();
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
    }

    public final void o(ati ati) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", Boolean.valueOf(Qx()));
        this.oRJ = "canplay";
        b jtVar = new jt();
        jtVar.fBu.action = 9;
        jtVar.fBu.fBq = ati;
        jtVar.fBu.state = "canplay";
        jtVar.fBu.duration = (long) getDuration();
        jtVar.fBu.fBw = bev();
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
    }

    public final void p(ati ati) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", Boolean.valueOf(Qx()));
        this.oRJ = "play";
        b jtVar = new jt();
        jtVar.fBu.action = 0;
        jtVar.fBu.fBq = ati;
        jtVar.fBu.state = "play";
        jtVar.fBu.duration = (long) getDuration();
        jtVar.fBu.fBw = bev();
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
        f.bec();
        f.hmh = System.currentTimeMillis();
        f.c(h.bef().bdU());
    }

    public final void q(ati ati) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
        this.oRJ = "play";
        b jtVar = new jt();
        jtVar.fBu.action = 1;
        jtVar.fBu.fBq = ati;
        jtVar.fBu.state = "play";
        jtVar.fBu.duration = (long) getDuration();
        jtVar.fBu.fBw = bev();
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
        f.hmh = System.currentTimeMillis();
    }

    public final void r(ati ati) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
        this.oRJ = "pause";
        b jtVar = new jt();
        jtVar.fBu.action = 3;
        jtVar.fBu.fBq = ati;
        jtVar.fBu.state = "pause";
        jtVar.fBu.duration = (long) getDuration();
        jtVar.fBu.fBw = bev();
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
        f.xZ();
    }

    public final void s(ati ati) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.oRJ = "stop";
        b jtVar = new jt();
        jtVar.fBu.action = 2;
        jtVar.fBu.fBq = ati;
        jtVar.fBu.state = "stop";
        jtVar.fBu.duration = (long) getDuration();
        jtVar.fBu.fBw = bev();
        com.tencent.mm.f.a.jt.a aVar = jtVar.fBu;
        boolean z = this.fBx;
        this.fBx = false;
        aVar.fBx = z;
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
        f.bec();
    }

    public final void t(ati ati) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
        this.oRJ = "seeked";
        b jtVar = new jt();
        jtVar.fBu.action = 8;
        jtVar.fBu.fBq = ati;
        jtVar.fBu.state = "seeked";
        jtVar.fBu.duration = (long) getDuration();
        jtVar.fBu.fBw = bev();
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
    }

    public final void u(ati ati) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
        this.oRJ = "seeking";
        b jtVar = new jt();
        jtVar.fBu.action = 12;
        jtVar.fBu.fBq = ati;
        jtVar.fBu.state = "seeking";
        jtVar.fBu.duration = (long) getDuration();
        jtVar.fBu.fBw = bev();
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
    }

    public final void v(ati ati) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.oRJ = "ended";
        b jtVar = new jt();
        jtVar.fBu.action = 7;
        jtVar.fBu.fBq = ati;
        jtVar.fBu.state = "ended";
        jtVar.fBu.duration = (long) getDuration();
        jtVar.fBu.fBw = bev();
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
        f.bec();
        if (h.bef().mode == 2) {
            h.bef().bdX();
        }
    }

    public final void a(ati ati, int i) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", Integer.valueOf(i));
        this.oRJ = "error";
        b jtVar = new jt();
        jtVar.fBu.action = 4;
        jtVar.fBu.fBq = ati;
        jtVar.fBu.state = "error";
        jtVar.fBu.duration = (long) getDuration();
        jtVar.fBu.fBw = bev();
        jtVar.fBu.errCode = h.ua(i);
        jtVar.fBu.foE = h.ub(i);
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
        f.bec();
    }

    public final void w(ati ati) {
        x.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
        a(ati, -1);
    }

    public final void a(com.tencent.mm.plugin.music.model.g.c.a aVar) {
        this.oQg = aVar;
    }
}
