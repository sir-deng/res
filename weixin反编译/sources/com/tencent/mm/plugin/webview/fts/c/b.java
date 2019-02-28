package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass4;
import com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass5;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements e {
    private Context context;
    public d tsa;
    private b txY;
    com.tencent.mm.plugin.webview.fts.ui.b tyc;
    private ba<FtsWebVideoView> tyd = new ba(3);

    public interface a {
        boolean aeX();

        void afQ();

        void agJ();

        void agq();

        void bQK();

        void bRj();

        void onDestroy();
    }

    public interface b {
        void a(a aVar);

        void bRk();

        void j(View view, boolean z);
    }

    public b(Context context, MMWebView mMWebView, b bVar) {
        this.context = context;
        this.txY = bVar;
        this.tyc = new com.tencent.mm.plugin.webview.fts.ui.b(mMWebView, bVar);
    }

    public final void v(final int i, String str, String str2) {
        x.i("FtsVideoPlayerMgr", "insert player id %d,viewProps %s,videoProps %s", Integer.valueOf(i), str, str2);
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                x.e("FtsVideoPlayerMgr", "insert args invalid");
                return;
            }
            View ftsWebVideoView;
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            View view = (FtsWebVideoView) this.tyd.bH();
            if (view == null) {
                ftsWebVideoView = new FtsWebVideoView(this.context, jSONObject2.optBoolean("autoPlay"));
            } else {
                view.stop();
                ftsWebVideoView = view;
            }
            x.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", Boolean.valueOf(true));
            ftsWebVideoView.jvO = true;
            ftsWebVideoView.txC = jSONObject2.optInt("fileSize");
            ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
            ftsWebVideoView.tj(jSONObject2.optString("coverUrl"));
            ftsWebVideoView.jvN = i;
            ftsWebVideoView.setAutoPlay(jSONObject2.optBoolean("autoPlay"));
            ftsWebVideoView.cz(c.af(jSONObject2), jSONObject2.optInt("durationSec"));
            final a anonymousClass1 = new a() {
                public final void agJ() {
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    x.i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
                    if (ftsWebVideoView.txq.jwp) {
                        ftsWebVideoView.txq.agI();
                    }
                    ftsWebVideoView.db(false);
                }
            };
            ftsWebVideoView.txz = new com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a() {
                public final void kt(boolean z) {
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.tyc;
                    bd anonymousClass4 = new AnonymousClass4(Boolean.valueOf(false), i, anonymousClass1, z);
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) anonymousClass4.b(null)).booleanValue();
                    } else {
                        ((Boolean) anonymousClass4.b(bVar.mHandler)).booleanValue();
                    }
                }

                public final void agI() {
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.tyc;
                    bd anonymousClass5 = new AnonymousClass5(Boolean.valueOf(false), i);
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) anonymousClass5.b(null)).booleanValue();
                    } else {
                        ((Boolean) anonymousClass5.b(bVar.mHandler)).booleanValue();
                    }
                }

                public final boolean isFullScreen() {
                    return b.this.tyc.lI(i);
                }
            };
            a anonymousClass3 = new a() {
                public final void agq() {
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    x.i("MicroMsg.FtsWebVideoView", "onUIResume");
                    ftsWebVideoView.txp.TL();
                }

                public final void afQ() {
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    x.i("MicroMsg.FtsWebVideoView", "onUIPause");
                    ftsWebVideoView.txp.TK();
                }

                public final void onDestroy() {
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    x.i("MicroMsg.FtsWebVideoView", "onUIDestroy");
                    x.i("MicroMsg.FtsWebVideoView", "clean");
                    ftsWebVideoView.stop();
                    ftsWebVideoView.txp.ahB();
                    ftsWebVideoView.txq.onDestroy();
                    try {
                        ftsWebVideoView.getContext().unregisterReceiver(ftsWebVideoView.txJ);
                    } catch (Exception e) {
                    }
                }

                public final void agJ() {
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = b.this.tyc;
                    a Ay = bVar.Ay(bVar.jKU);
                    float[] fArr = bVar.jKR;
                    if (Ay != null && Ay.jLe != null && fArr != null) {
                        View view = (View) Ay.jLe.get();
                        if (view != null) {
                            if (bVar.jKU != bVar.jKQ) {
                                a Ay2 = bVar.Ay(bVar.jKQ);
                                if (!(Ay2 == null || Ay2.jLe == null)) {
                                    View view2 = (View) Ay2.jLe.get();
                                    if (view2 != null) {
                                        bVar.a(bVar.jKQ, fArr, view2.getVisibility());
                                    }
                                }
                            }
                            int i = bVar.jKU;
                            bVar.jKQ = -1;
                            bVar.jKU = -1;
                            if (bVar.txX != null) {
                                bVar.txX.agJ();
                                bVar.txX = null;
                            }
                            bVar.a(i, fArr, view.getVisibility());
                        }
                    }
                }

                public final boolean aeX() {
                    if (!ftsWebVideoView.ahd()) {
                        return false;
                    }
                    ftsWebVideoView.ks(false);
                    return true;
                }

                public final void bQK() {
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    if (!ftsWebVideoView.kYN && ftsWebVideoView.bQZ() == 0) {
                        ftsWebVideoView.setMute(true);
                    }
                }

                public final void bRj() {
                    FtsWebVideoView ftsWebVideoView = ftsWebVideoView;
                    if (ftsWebVideoView.kYN && ftsWebVideoView.bQZ() > 0) {
                        ftsWebVideoView.setMute(false);
                    }
                }
            };
            ftsWebVideoView.txB = anonymousClass3;
            this.txY.a(anonymousClass3);
            ftsWebVideoView.txA = new d(ftsWebVideoView, this.txY, this.tsa);
            com.tencent.mm.plugin.webview.fts.ui.b bVar = this.tyc;
            bd anonymousClass12 = new com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass1(Boolean.valueOf(false), ftsWebVideoView, i, 0, c.a(jSONObject, this.context), c.l(jSONObject));
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ((Boolean) anonymousClass12.b(null)).booleanValue();
            } else {
                ((Boolean) anonymousClass12.b(bVar.mHandler)).booleanValue();
            }
        } catch (JSONException e) {
            x.e("FtsVideoPlayerMgr", "", e);
        }
    }

    public final void w(int i, String str, String str2) {
        x.i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", Integer.valueOf(i), str, str2);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                com.tencent.mm.plugin.webview.fts.ui.b bVar = this.tyc;
                bd anonymousClass3 = new com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass3(Boolean.valueOf(false), i, c.a(jSONObject, this.context), c.l(jSONObject));
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    ((Boolean) anonymousClass3.b(null)).booleanValue();
                } else {
                    ((Boolean) anonymousClass3.b(bVar.mHandler)).booleanValue();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject(str2);
                FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.tyc.lG(i);
                if (ftsWebVideoView == null) {
                    x.i("FtsVideoPlayerMgr", "can not find video View by id %d", Integer.valueOf(i));
                    return;
                }
                if (jSONObject2.has("autoPlay")) {
                    ftsWebVideoView.setAutoPlay(jSONObject2.optBoolean("autoPlay"));
                }
                if (jSONObject2.has("coverUrl")) {
                    ftsWebVideoView.tj(jSONObject2.optString("coverUrl"));
                }
                if (jSONObject2.has("durationSec")) {
                    FtsWebVideoView.setDuration(jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("playUrl")) {
                    ftsWebVideoView.cz(c.af(jSONObject2), jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("isMute")) {
                    ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
                }
            }
        } catch (JSONException e) {
            x.e("FtsVideoPlayerMgr", "", e);
        }
    }

    public final void Az(int i) {
        x.i("FtsVideoPlayerMgr", "remove palyer id %d", Integer.valueOf(i));
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.tyc.lG(i);
        if (ftsWebVideoView == null) {
            x.w("FtsVideoPlayerMgr", "can not find player by id %d", Integer.valueOf(i));
        }
        com.tencent.mm.plugin.webview.fts.ui.b bVar = this.tyc;
        bd anonymousClass2 = new com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass2(Boolean.valueOf(false), i);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ((Boolean) anonymousClass2.b(null)).booleanValue();
        } else {
            ((Boolean) anonymousClass2.b(bVar.mHandler)).booleanValue();
        }
        if (ftsWebVideoView != null) {
            ftsWebVideoView.stop();
            ftsWebVideoView.txA.clean();
            ftsWebVideoView.txA = null;
            ftsWebVideoView.setVisibility(0);
            ftsWebVideoView.txD = false;
            this.tyd.j(ftsWebVideoView);
        }
    }

    public final void aS(int i, String str) {
        x.i("FtsVideoPlayerMgr", "op player id %d,type %s", Integer.valueOf(i), str);
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.tyc.lG(i);
        if (ftsWebVideoView != null) {
            boolean z = true;
            switch (str.hashCode()) {
                case 3443508:
                    if (str.equals("play")) {
                        z = false;
                        break;
                    }
                    break;
                case 3540994:
                    if (str.equals("stop")) {
                        z = true;
                        break;
                    }
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        z = true;
                        break;
                    }
                    break;
                case 640038740:
                    if (str.equals("setUnMute")) {
                        z = true;
                        break;
                    }
                    break;
                case 1984790939:
                    if (str.equals("setMute")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    ftsWebVideoView.kr(false);
                    return;
                case true:
                    ftsWebVideoView.pause();
                    return;
                case true:
                    ftsWebVideoView.stop();
                    return;
                case true:
                    ftsWebVideoView.setMute(true);
                    return;
                case true:
                    ftsWebVideoView.setMute(false);
                    return;
                default:
                    x.i("FtsVideoPlayerMgr", "unknown op type %s", str);
                    return;
            }
        }
        x.i("FtsVideoPlayerMgr", "can not find player by id %d", Integer.valueOf(i));
    }
}
