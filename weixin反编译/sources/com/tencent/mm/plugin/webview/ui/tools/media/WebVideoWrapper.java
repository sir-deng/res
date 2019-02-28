package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;

public class WebVideoWrapper extends RelativeLayout implements h, b, c, a {
    private boolean avH;
    private int jwA;
    private d jwC;
    private h jwu;
    private b jwv;
    private Context mContext;
    private String url;

    public WebVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        this.jwC = new d();
        if (this.jwu == null) {
            h commonVideoView = new CommonVideoView(this.mContext);
            commonVideoView.twz = this;
            commonVideoView.jwv = this;
            a(600, 200, 1, false);
            this.jwu = commonVideoView;
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        addView((View) this.jwu, layoutParams);
    }

    public final void b(boolean z, String str, int i) {
        this.jwA = i;
        this.avH = z;
        this.url = str;
        if (this.jwu != null) {
            this.jwu.b(this.avH, this.url, this.jwA);
        }
    }

    public final void a(g gVar) {
        if (this.jwu != null) {
            this.jwu.a(gVar);
        }
    }

    public final void ahx() {
        if (this.jwu != null) {
            this.jwu.ahx();
        }
    }

    public final boolean kL(int i) {
        if (this.jwu != null) {
            return this.jwu.kL(i);
        }
        return false;
    }

    public final boolean s(int i, boolean z) {
        if (this.jwu != null) {
            return this.jwu.s(i, z);
        }
        return false;
    }

    public final int ahy() {
        if (this.jwu != null) {
            return this.jwu.ahy();
        }
        return this.jwA;
    }

    public final int ahz() {
        if (this.jwu != null) {
            return this.jwu.ahz();
        }
        return 0;
    }

    public final int ahA() {
        if (this.jwu != null) {
            return this.jwu.ahA();
        }
        return 0;
    }

    public final int TO() {
        if (this.jwu != null) {
            return this.jwu.TO();
        }
        return 0;
    }

    public final boolean isPlaying() {
        if (this.jwu != null) {
            return this.jwu.isPlaying();
        }
        return false;
    }

    public final boolean ahf() {
        if (this.jwu != null) {
            return this.jwu.ahf();
        }
        return false;
    }

    public final void start() {
        if (this.jwu != null) {
            this.jwu.start();
            setKeepScreenOn(true);
            this.jwC.a(this);
        }
    }

    public final void stop() {
        if (this.jwu != null) {
            this.jwu.stop();
            this.jwC.bz(false);
            setKeepScreenOn(false);
        }
    }

    public final boolean pause() {
        if (this.jwu == null) {
            return false;
        }
        setKeepScreenOn(false);
        this.jwC.bz(false);
        return this.jwu.pause();
    }

    public final void setMute(boolean z) {
        if (this.jwu != null) {
            this.jwu.setMute(z);
        }
    }

    public final void TL() {
        if (this.jwu != null) {
            this.jwu.TL();
        }
    }

    public final void TK() {
        if (this.jwu != null) {
            this.jwu.TK();
        }
        this.jwC.bz(false);
        setKeepScreenOn(false);
    }

    public final void ahB() {
        if (this.jwu != null) {
            this.jwu.ahB();
        }
        this.jwC.bz(false);
        setKeepScreenOn(false);
    }

    public final void a(h.d dVar) {
        if (this.jwu != null) {
            this.jwu.a(dVar);
        }
    }

    public final boolean aa(float f) {
        if (f > 0.0f && this.jwu != null) {
            return this.jwu.aa(f);
        }
        return false;
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        x.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.jwv != null) {
            this.jwv.c(str, str2, str3, i, i2);
        }
    }

    public final void bn(String str, String str2) {
        x.i("MicroMsg.WebVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.jwv != null) {
            this.jwv.bn(str, str2);
        }
    }

    public final void bo(String str, String str2) {
        x.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.jwv != null) {
            this.jwv.bo(str, str2);
        }
    }

    public final void e(String str, String str2, int i, int i2) {
        x.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.jwv != null) {
            this.jwv.e(str, str2, i, i2);
        }
    }

    public final void bp(String str, String str2) {
        x.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.jwC.bz(false);
        if (this.jwv != null) {
            this.jwv.bp(str, str2);
        }
    }

    public final void bq(String str, String str2) {
        x.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.jwC.a(this);
        if (this.jwv != null) {
            this.jwv.bq(str, str2);
        }
    }

    public final void br(String str, String str2) {
        if (this.jwv != null) {
            this.jwv.br(str, str2);
        }
    }

    public final void bs(String str, String str2) {
        if (this.jwv != null) {
            this.jwv.bs(str, str2);
        }
    }

    public void setKeepScreenOn(boolean z) {
        x.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), bi.chl());
        super.setKeepScreenOn(z);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        com.tencent.mm.plugin.report.service.g.pWK.a(600, j2, 1, false);
    }

    public final void k(int i, String str) {
        com.tencent.mm.plugin.report.service.g.pWK.k(14349, str);
    }
}
