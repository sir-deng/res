package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

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

public class a implements com.tencent.mm.ad.g.a, b, com.tencent.mm.sdk.platformtools.SensorController.a {
    public static volatile a ufn = null;
    private int fws;
    public List<a> gzt = new LinkedList();
    public SensorController kIB;
    private boolean kIE = true;
    public az kIF;
    private long kIG = -1;
    private boolean kIH;
    private boolean kIL = false;
    private g mvW = ((o) com.tencent.mm.kernel.g.h(o.class)).uo();
    String path;

    interface a {
        void RF(String str);

        void bYC();
    }

    private a() {
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
        if (this.kIB == null) {
            this.kIB = new SensorController(ad.getContext());
        }
        if (this.kIF == null) {
            this.kIF = new az(ad.getContext());
        }
    }

    public static a bYD() {
        if (ufn == null) {
            synchronized (a.class) {
                if (ufn == null) {
                    ufn = new a();
                }
            }
        }
        return ufn;
    }

    public final boolean startPlay(String str, int i) {
        if (this.mvW == null) {
            x.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", str, Integer.valueOf(i));
            return false;
        }
        this.mvW.stop();
        if (!(this.kIB == null || this.kIB.xqv)) {
            this.kIB.a(this);
            if (this.kIF.O(new Runnable() {
                public final void run() {
                    a.this.kIG = bi.Wz();
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
        for (a aVar : this.gzt) {
            if (aVar != null) {
                aVar.RF(str);
            }
        }
        return true;
    }

    public final void stopPlay() {
        x.i("MicroMsg.RecordVoiceHelper", "stop play");
        af.VJ("keep_app_silent");
        if (this.mvW != null) {
            this.mvW.stop();
            for (a aVar : this.gzt) {
                if (aVar != null) {
                    aVar.bYC();
                }
            }
        }
        if (this.kIB != null) {
            this.kIB.cgS();
        }
        if (this.kIF != null) {
            this.kIF.cgT();
        }
    }

    public final boolean aJh() {
        if (this.mvW != null) {
            return this.mvW.isPlaying();
        }
        x.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
        return false;
    }

    public final void onError() {
        x.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        stopPlay();
    }

    public final void vi() {
        x.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        stopPlay();
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
