package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ad.g;
import com.tencent.mm.ad.g.b;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.LinkedList;
import java.util.List;

public final class m implements com.tencent.mm.ad.g.a, b, com.tencent.mm.sdk.platformtools.SensorController.a {
    public static SensorController kIB;
    private int fws;
    public List<a> gzt = new LinkedList();
    private boolean kIE = true;
    private az kIF;
    long kIG = -1;
    private boolean kIH;
    private boolean kIL = false;
    public g mvW = ((o) com.tencent.mm.kernel.g.h(o.class)).uo();
    public String path;

    public interface a {
        void IQ(String str);

        void onFinish();
    }

    public m() {
        as.Hm();
        Boolean bool = (Boolean) c.Db().get(26, Boolean.valueOf(false));
        this.kIH = bool.booleanValue();
        this.kIE = !bool.booleanValue();
        if (this.mvW != null) {
            this.mvW.a((com.tencent.mm.ad.g.a) this);
            this.mvW.a((b) this);
            this.mvW.aO(this.kIE);
        } else {
            x.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (kIB == null) {
            kIB = new SensorController(ad.getContext());
        }
        if (this.kIF == null) {
            this.kIF = new az(ad.getContext());
        }
    }

    public final boolean startPlay(String str, int i) {
        if (this.mvW == null) {
            x.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i));
            return false;
        }
        this.mvW.stop();
        for (a IQ : this.gzt) {
            IQ.IQ(str);
        }
        if (!(kIB == null || kIB.xqv)) {
            kIB.a(this);
            if (this.kIF.O(new Runnable() {
                public final void run() {
                    m.this.kIG = bi.Wz();
                }
            })) {
                this.kIG = 0;
            } else {
                this.kIG = -1;
            }
        }
        this.path = str;
        this.fws = i;
        if (bi.oN(str) || !this.mvW.a(str, this.kIE, true, i)) {
            return false;
        }
        af.VI("keep_app_silent");
        return true;
    }

    public final boolean aJh() {
        if (this.mvW != null) {
            return this.mvW.isPlaying();
        }
        x.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
        return false;
    }

    public final void stopPlay() {
        x.d("MicroMsg.RecordVoiceHelper", "stop play");
        af.VJ("keep_app_silent");
        if (this.mvW != null) {
            this.mvW.stop();
        }
        asA();
    }

    public final void onError() {
        x.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
        for (a onFinish : this.gzt) {
            onFinish.onFinish();
        }
    }

    public final void vi() {
        x.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
        for (a onFinish : this.gzt) {
            onFinish.onFinish();
        }
    }

    public final void asA() {
        if (kIB != null) {
            kIB.cgS();
        }
        if (this.kIF != null) {
            this.kIF.cgT();
        }
    }

    public final void dX(boolean z) {
        boolean z2 = true;
        if (!bi.oN(this.path)) {
            if (this.kIL) {
                if (z) {
                    z2 = false;
                }
                this.kIL = z2;
            } else if (z || this.kIG == -1 || bi.bB(this.kIG) <= 400) {
                this.kIL = false;
                if (this.mvW != null && this.mvW.ve()) {
                    return;
                }
                if (this.kIH) {
                    if (this.mvW != null) {
                        this.mvW.aO(false);
                    }
                    this.kIE = false;
                } else if (this.mvW == null || this.mvW.isPlaying()) {
                    if (this.mvW != null) {
                        this.mvW.aO(z);
                    }
                    this.kIE = z;
                    if (!z) {
                        startPlay(this.path, this.fws);
                    }
                } else {
                    this.mvW.aO(true);
                    this.kIE = true;
                }
            } else {
                this.kIL = true;
            }
        }
    }
}
