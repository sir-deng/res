package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.aj.a.a.b;
import com.tencent.mm.plugin.webview.fts.topstory.a.e;
import com.tencent.mm.plugin.webview.fts.topstory.ui.widget.TopStoryVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public class TopStoryVideoView extends MMVideoView {
    String frp;

    public TopStoryVideoView(Context context) {
        this(context, null);
    }

    public TopStoryVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopStoryVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.frp = "";
        this.mContext = context;
    }

    protected final void TI() {
        this.hVx.hVB = 4;
        this.hVx.hVC = 2;
    }

    protected final f bB(Context context) {
        f topStoryVideoPlayTextureView = new TopStoryVideoPlayTextureView(context);
        topStoryVideoPlayTextureView.vEX = true;
        topStoryVideoPlayTextureView.gD(bQw());
        topStoryVideoPlayTextureView.gE(true);
        return topStoryVideoPlayTextureView;
    }

    private boolean bQw() {
        boolean z = false;
        try {
            g.Dr();
            return g.Dq().Db().getBoolean(a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "check need reset error", new Object[z]);
            return z;
        }
    }

    public final void b(boolean z, String str, int i) {
        super.b(z, str, i);
    }

    protected final void initView() {
        super.initView();
        this.hVg = e.bQh();
        a(e.bQg().tuz);
        this.TAG = "MicroMsg.TopStoryVideoView";
    }

    public final boolean iL(int i) {
        Exception e;
        if (this.hVl == 3) {
            return true;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        boolean isVideoDataAvailable;
        try {
            boolean b;
            int i2;
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            if (i == 0 && this.hVn != null && bQw()) {
                pInt4.value = 0;
                pInt3.value = 0;
                b = this.hVn.b(i + 1, pInt3, pInt4);
            } else {
                b = false;
            }
            int i3 = i + 1;
            if (b) {
                i2 = pInt4.value;
            } else {
                i2 = i3;
            }
            if (this.hVn == null || !this.hVn.a(i, i2, pInt, pInt2)) {
                return false;
            }
            isVideoDataAvailable = e.bQg().tuz.isVideoDataAvailable(this.hVi, pInt.value, pInt2.value);
            if (!isVideoDataAvailable) {
                return isVideoDataAvailable;
            }
            try {
                this.hVs = i2;
                return isVideoDataAvailable;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            isVideoDataAvailable = false;
            x.e(this.TAG, "%s check video data error %s ", atu(), e.toString());
            return isVideoDataAvailable;
        }
    }

    public final void g(String str, int i, int i2) {
        if (bi.fA(this.hVi, str)) {
            x.d(this.TAG, "%s download  onProgress [%d, %d]", atu(), Integer.valueOf(i), Integer.valueOf(i2));
            if (this.hVr && this.hVm == 3) {
                iK(ahA());
            }
        }
    }

    public final boolean s(int i, boolean z) {
        if (this.hVn != null) {
            int WF = this.hVn.WF();
            if (i > WF && WF > 0) {
                x.i(this.TAG, "%s seek to reset time ori[%d] last key frame[%d]", atu(), Integer.valueOf(i), Integer.valueOf(WF));
                i = WF;
            }
        }
        return super.s(i, z);
    }

    protected final boolean a(int i, PInt pInt, PInt pInt2) {
        boolean z;
        pInt.value = Math.max(i, this.hVs);
        if (this.hVm == 1 || this.hVm == 0) {
            if (this.hVn == null || !bQw()) {
                z = false;
            } else {
                pInt2.value = 0;
                pInt.value = 0;
                z = this.hVn.b(i + 1, pInt, pInt2);
            }
            if (!z) {
                pInt.value = i;
                pInt2.value = pInt.value + 4;
            }
        } else {
            z = false;
        }
        if (this.hVm == 2) {
            if (this.hVn != null) {
                z = this.hVn.b(i, pInt, pInt2);
                pInt2.value += 4;
            }
            if (!z) {
                pInt.value = i - 8;
                if (pInt.value < 0) {
                    pInt.value = 0;
                }
                pInt2.value = (pInt.value + this.hVt) + 8;
            }
        }
        if (this.hVm == 3 || this.hVm == 4) {
            pInt.value = this.hVs;
            pInt2.value = this.hVo + 1;
        }
        if (pInt2.value >= this.hVo + 1) {
            pInt2.value = this.hVo + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + 2;
            return false;
        }
        x.d(this.TAG, "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", atu(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.hVm), Integer.valueOf(this.hVs), Integer.valueOf(this.hVt), this.hVi);
        return true;
    }

    public final void OL(String str) {
        this.frp = str;
        start();
    }

    public final void start() {
        super.start();
        com.tencent.mm.plugin.aj.a.a.a.qq(5);
    }

    protected final String nl(String str) {
        return e.OK(str);
    }

    public final boolean isPlaying() {
        boolean z;
        boolean isPlaying = super.isPlaying();
        if (isPlaying && this.hVm == 3) {
            z = true;
        } else {
            z = false;
        }
        x.d(this.TAG, "%s result [%b] is playing[%b] playStatus[%d]", atu(), Boolean.valueOf(z), Boolean.valueOf(isPlaying), Integer.valueOf(this.hVm));
        return isPlaying;
    }

    public final int ahz() {
        int i = 0;
        if (this.kYP != null) {
            i = this.kYP.getCurrentPosition();
        }
        if (this.hVp > 0) {
            return this.hVp * 1000;
        }
        return i;
    }

    public final int ahA() {
        int i = 0;
        if (this.kYP != null) {
            i = Math.round((((float) this.kYP.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        if (this.hVp > 0) {
            return this.hVp;
        }
        return i;
    }

    public final void K(String str, int i) {
        super.K(str, i);
        if (i != 0 && this.jwv != null) {
            this.jwv.c(this.frp, this.hVi, "download error", i, 0);
        }
    }

    public final void onError(int i, int i2) {
        super.onError(i, i2);
        switch (i2) {
            case -3:
                b.qq(b.trg);
                return;
            case -2:
                try {
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.valueOf(true));
                    if (this.kYP instanceof TopStoryVideoPlayTextureView) {
                        ((TopStoryVideoPlayTextureView) this.kYP).gD(true);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace(this.TAG, e, "%s onError [%s]", atu(), e.toString());
                }
                b.qq(b.trf);
                return;
            case -1:
                b.qq(b.tre);
                return;
            default:
                return;
        }
    }

    protected final boolean bQx() {
        return false;
    }

    public final void TL() {
        x.i(this.TAG, "%s onUIResume", atu());
        if (!this.vpt) {
            this.vpt = true;
            if (this.kYP != null) {
                if (this.vpA) {
                    play();
                } else {
                    ((VideoPlayerTextureView) this.kYP).bas();
                }
            }
            fw(110);
        }
    }

    public final void TK() {
        x.i(this.TAG, "%s onUIPause", atu());
        if (this.vpt) {
            this.vpz = ahA();
            this.vpA = isPlaying();
            this.vpG = 0;
            this.vpF = 0;
            pause();
            TN();
            this.vpt = false;
            fw(111);
        }
    }

    protected final String bQy() {
        return this.frp;
    }

    public final void bQz() {
        ((TopStoryVideoPlayTextureView) this.kYP).setAlpha(1.0f);
    }
}
