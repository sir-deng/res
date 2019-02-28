package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class CommonVideoView extends AbstractVideoView {
    protected boolean avH;
    protected int jwA;
    public String url;

    public CommonVideoView(Context context) {
        super(context);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView() {
        super.initView();
        this.TAG = "MicroMsg.CommonVideoView";
    }

    public void b(boolean z, String str, int i) {
        x.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", atu(), Boolean.valueOf(z), str, Integer.valueOf(i));
        this.avH = z;
        this.url = str;
        this.jwA = i;
        SJ(str);
    }

    public f bB(Context context) {
        this.vpB = 0;
        return new VideoTextureView(context);
    }

    public void start() {
        if (this.kYP != null) {
            x.i(this.TAG, "%s start path [%s] [%s]", atu(), this.kYP.Uy(), bi.chl());
            if (bi.oN(this.kYP.Uy())) {
                this.kYP.setVideoPath(this.url);
                amd();
                bAG();
            } else {
                play();
            }
            fw((long) (TQ() + 1));
        }
    }

    public void a(d dVar) {
        if (this.kYP instanceof VideoTextureView) {
            VideoTextureView videoTextureView = (VideoTextureView) this.kYP;
            videoTextureView.vFg.a(dVar);
            videoTextureView.requestLayout();
            fw((long) (TQ() + 14));
        }
    }

    public final boolean aa(float f) {
        x.i(this.TAG, "%s set play rate [%f]", atu(), Float.valueOf(f));
        if (!(this.kYP instanceof VideoTextureView)) {
            return false;
        }
        fw((long) (TQ() + 13));
        return ((VideoTextureView) this.kYP).aa(f);
    }

    public final int ahy() {
        if (this.jwA <= 0) {
            return super.ahy();
        }
        return this.jwA;
    }

    public int TO() {
        try {
            if (this.kYP instanceof VideoTextureView) {
                return (int) (((((float) ((VideoTextureView) this.kYP).vFA) * 1.0f) / 100.0f) * ((float) super.ahy()));
            }
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "%s get cache time sec error", atu());
        }
        return 0;
    }

    public boolean s(int i, boolean z) {
        if (!ahf()) {
            return super.s(i, z);
        }
        x.w(this.TAG, "%s it is live, don't seek ", atu());
        return false;
    }

    public void TL() {
        super.TL();
        if (this.kYP != null && (this.kYP instanceof VideoTextureView)) {
            if (this.vpA) {
                play();
            } else {
                ((VideoTextureView) this.kYP).bas();
            }
        }
    }

    public void TK() {
        super.TK();
    }

    public final void eC(int i, int i2) {
        x.d(this.TAG, "%s onInfo [%d %d]", atu(), Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 701) {
            amd();
            caG();
            caE();
            fw((long) (TQ() + 40));
        } else if (i == 702) {
            aVF();
            caF();
            caH();
        }
    }

    public void vi() {
        if (ahf()) {
            x.i(this.TAG, "%s it is live video, do not completion", atu());
            stop();
            start();
            return;
        }
        super.vi();
    }

    public final boolean ahf() {
        boolean isPrepared = isPrepared();
        int duration = this.kYP != null ? this.kYP.getDuration() : 0;
        if (this.avH) {
            isPrepared = true;
        } else if (!isPrepared || duration > 0) {
            isPrepared = false;
        } else {
            isPrepared = true;
        }
        x.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", atu(), Boolean.valueOf(isPrepared), Boolean.valueOf(isPrepared()), Integer.valueOf(duration), Boolean.valueOf(this.avH));
        return isPrepared;
    }

    public int TQ() {
        return 0;
    }
}
