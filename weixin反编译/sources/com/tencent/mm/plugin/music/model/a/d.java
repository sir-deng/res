package com.tencent.mm.plugin.music.model.a;

import android.os.Looper;
import com.tencent.mm.f.a.t;
import com.tencent.mm.plugin.music.model.a.b.a;
import com.tencent.mm.plugin.music.model.g.c;
import com.tencent.mm.plugin.music.model.g.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d implements c {
    protected a oQa = null;
    ar oQe;
    protected boolean oQf;
    protected c.a oQg;

    public abstract String bex();

    public abstract String getAppId();

    public final void bet() {
    }

    public final boolean beu() {
        return false;
    }

    public boolean bev() {
        return false;
    }

    public final com.tencent.mm.au.d bew() {
        return null;
    }

    public final void bey() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent %b", Boolean.valueOf(Qx()));
        b tVar = new t();
        tVar.foD.action = 7;
        tVar.foD.state = "canplay";
        tVar.foD.duration = (long) getDuration();
        tVar.foD.foy = bex();
        tVar.foD.appId = getAppId();
        com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
    }

    public final void bez() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", Boolean.valueOf(Qx()));
        b tVar = new t();
        tVar.foD.action = 0;
        tVar.foD.state = "play";
        tVar.foD.foy = bex();
        tVar.foD.appId = getAppId();
        com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
        if (this.oQa != null) {
            this.oQa.onStart(bex());
        }
    }

    public final void beA() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
        b tVar = new t();
        tVar.foD.action = 1;
        tVar.foD.state = "play";
        tVar.foD.foy = bex();
        tVar.foD.appId = getAppId();
        com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
        if (this.oQa != null) {
            this.oQa.onStart(bex());
        }
    }

    public final void beB() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
        b tVar = new t();
        tVar.foD.action = 2;
        tVar.foD.state = "pause";
        tVar.foD.foy = bex();
        tVar.foD.appId = getAppId();
        com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
        if (this.oQa != null) {
            this.oQa.GJ(bex());
        }
    }

    public final void beC() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        b tVar = new t();
        tVar.foD.action = 3;
        tVar.foD.state = "stop";
        tVar.foD.foy = bex();
        tVar.foD.appId = getAppId();
        com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
        if (this.oQa != null) {
            this.oQa.As(bex());
        }
    }

    public final void beD() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
        b tVar = new t();
        tVar.foD.action = 6;
        tVar.foD.state = "seeked";
        tVar.foD.foy = bex();
        tVar.foD.appId = getAppId();
        com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
    }

    public final void beE() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        b tVar = new t();
        tVar.foD.action = 5;
        tVar.foD.state = "ended";
        tVar.foD.foy = bex();
        tVar.foD.appId = getAppId();
        com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
        if (this.oQa != null) {
            this.oQa.GK(bex());
        }
    }

    public final void tK(int i) {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", Integer.valueOf(i));
        b tVar = new t();
        tVar.foD.action = 4;
        tVar.foD.state = "error";
        tVar.foD.errCode = h.ua(i);
        tVar.foD.foE = h.ub(i);
        tVar.foD.foy = bex();
        tVar.foD.appId = getAppId();
        com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
        if (this.oQa != null) {
            this.oQa.onError(bex());
        }
    }

    public final void beF() {
        x.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
        tK(-1);
    }

    public final void a(c.a aVar) {
        this.oQg = aVar;
    }

    public final void a(a aVar) {
        this.oQa = aVar;
    }
}
