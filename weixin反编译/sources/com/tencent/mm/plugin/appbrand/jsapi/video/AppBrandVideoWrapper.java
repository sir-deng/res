package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.d;

public class AppBrandVideoWrapper extends RelativeLayout implements h, a, b, c, d.a {
    private boolean avH;
    private int jwA;
    private boolean jwB;
    private d jwC;
    private h jwu;
    b jwv;
    private g jww;
    private h.d jwx;
    private boolean jwy;
    private float jwz;
    private Context mContext;
    private String url;

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwx = h.d.CONTAIN;
        this.jwy = false;
        this.jwz = -1.0f;
        this.mContext = context;
        this.jwC = new d();
    }

    public final void b(boolean z, String str, int i) {
        boolean z2;
        int i2 = 1;
        this.jwA = i;
        this.avH = z;
        PString pString = new PString();
        pString.value = str;
        if (bi.oN(pString.value) || pString.value.indexOf(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX) != 0) {
            z2 = false;
        } else {
            pString.value = pString.value.substring(9);
            z2 = true;
        }
        this.jwB = z2;
        this.url = pString.value;
        if (this.jwu == null) {
            if (a(this.avH, this.url, "")) {
                x.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.jwu = ahv();
            } else {
                x.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
                this.jwu = ahw();
            }
        } else if (a(this.avH, this.url, "")) {
            if (this.jwu instanceof MMVideoView) {
                this.jwu.stop();
                this.jwu.ahx();
                removeView((View) this.jwu);
                x.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.jwu = ahv();
            } else {
                x.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", Integer.valueOf(hashCode()));
                this.jwu.stop();
                i2 = 0;
            }
        } else if (this.jwu instanceof CommonVideoView) {
            this.jwu.stop();
            this.jwu.ahx();
            removeView((View) this.jwu);
            x.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
            this.jwu = ahw();
        } else {
            x.i("MicroMsg.AppBrandVideoWrapper", "%d use last mm video view !", Integer.valueOf(hashCode()));
            this.jwu.stop();
            i2 = 0;
        }
        a(this.jwx);
        aa(this.jwz);
        setMute(this.jwy);
        if (i2 != 0) {
            a(this.jww);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.jwu, layoutParams);
        }
        this.jwu.b(this.avH, this.url, this.jwA);
    }

    private h ahv() {
        h commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.twz = this;
        commonVideoView.jwv = this;
        a(600, 200, 1, false);
        return commonVideoView;
    }

    private h ahw() {
        h mMVideoView = new MMVideoView(this.mContext);
        mMVideoView.twz = this;
        mMVideoView.jwv = this;
        mMVideoView.a(new AppBrandOnlineVideoProxy());
        mMVideoView.hVk = this;
        String str = e.bnF + "appbrandvideo/";
        i.QZ(str);
        mMVideoView.hVg = str;
        a(600, 201, 1, false);
        return mMVideoView;
    }

    private boolean a(boolean z, String str, String str2) {
        if (z || this.jwB) {
            return true;
        }
        if (com.tencent.mm.compatible.util.d.fO(18)) {
            return true;
        }
        x.d("MicroMsg.AppBrandVideoWrapper", "checkUseSystemPlayer abtestFlag[%d]", Integer.valueOf(ad.getContext().getSharedPreferences("system_config_prefs", 4).getInt("appbrand_video_player", -1)));
        if (ad.getContext().getSharedPreferences("system_config_prefs", 4).getInt("appbrand_video_player", -1) <= 0) {
            x.i("MicroMsg.AppBrandVideoWrapper", "abtest is zero, use system player");
            return true;
        } else if (!bi.oN(str) && str.contains(".m3u8")) {
            x.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", Integer.valueOf(hashCode()));
            a(600, 204, 1, false);
            return true;
        } else if (!q.nt(str2)) {
            return false;
        } else {
            x.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", Integer.valueOf(hashCode()));
            a(600, 204, 1, false);
            return true;
        }
    }

    public final void a(g gVar) {
        this.jww = gVar;
        if (this.jwu != null) {
            this.jwu.a(this.jww);
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
        this.jwy = z;
        if (this.jwu != null) {
            this.jwu.setMute(this.jwy);
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
        this.jwx = dVar;
        if (this.jwu != null) {
            this.jwu.a(this.jwx);
        }
    }

    public final boolean aa(float f) {
        if (f <= 0.0f) {
            return false;
        }
        this.jwz = f;
        if (this.jwu != null) {
            return this.jwu.aa(this.jwz);
        }
        return false;
    }

    public final void V(String str, boolean z) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", Integer.valueOf(hashCode()), str, Boolean.valueOf(z));
        if (!z) {
            int i;
            boolean i2;
            if (a(false, "", str)) {
                if (this.jwu instanceof MMVideoView) {
                    this.jwu.stop();
                    this.jwu.ahx();
                    removeView((View) this.jwu);
                    x.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", Integer.valueOf(hashCode()));
                    this.jwu = ahv();
                    i2 = 1;
                }
                i2 = false;
            } else {
                if (this.jwu instanceof CommonVideoView) {
                    this.jwu.stop();
                    this.jwu.ahx();
                    removeView((View) this.jwu);
                    x.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use mm video view !", Integer.valueOf(hashCode()));
                    this.jwu = ahw();
                    i2 = 1;
                }
                i2 = false;
            }
            a(this.jwx);
            aa(this.jwz);
            setMute(this.jwy);
            if (i2 != 0) {
                a(this.jww);
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(13);
                addView((View) this.jwu, layoutParams);
                this.jwu.b(this.avH, this.url, this.jwA);
                this.jwu.start();
            }
        }
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        x.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.jwv != null) {
            this.jwv.c(str, str2, str3, i, i2);
        }
    }

    public final void bn(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.jwv != null) {
            this.jwv.bn(str, str2);
        }
        if (ahf()) {
            a(600, 203, 1, false);
        } else {
            a(600, 202, 1, false);
        }
    }

    public final void bo(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.jwv != null) {
            this.jwv.bo(str, str2);
        }
    }

    public final void e(String str, String str2, int i, int i2) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.jwv != null) {
            this.jwv.e(str, str2, i, i2);
        }
    }

    public final void bp(String str, String str2) {
        x.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.jwC.bz(false);
        if (this.jwv != null) {
            this.jwv.bp(str, str2);
        }
    }

    public final void bq(String str, String str2) {
        x.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
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
        x.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), bi.chl());
        super.setKeepScreenOn(z);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        com.tencent.mm.plugin.report.service.g.pWK.a(600, j2, 1, false);
    }

    public final void k(int i, String str) {
        com.tencent.mm.plugin.report.service.g.pWK.k(14349, str);
    }
}
