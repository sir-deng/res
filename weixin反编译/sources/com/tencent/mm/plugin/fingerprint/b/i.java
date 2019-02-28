package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.f.a.lg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

public final class i extends c<lg> {
    private String fvC;
    boolean mEN;
    private a mFi;
    lg mFj;
    private k mFk;
    private Runnable mFl;

    public class a implements com.tencent.mm.pluginsdk.wallet.c {
        public final void aH(int i, int i2) {
            if (i.this.mEN) {
                x.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
                return;
            }
            String string;
            switch (i) {
                case 0:
                    x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
                    i iVar = i.this;
                    x.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
                    iVar.mEN = true;
                    com.tencent.mm.plugin.fingerprint.a.aKz();
                    com.tencent.mm.plugin.fingerprint.a.aKA();
                    ((l) g.h(l.class)).a(iVar.mFj, i2);
                    if (iVar.mEN) {
                        iVar.mFj = null;
                    }
                    x.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
                    i.aLg();
                    return;
                case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                    x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
                    return;
                case 2001:
                    i.this.fq(false);
                    x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
                    return;
                case 2002:
                    x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
                    i.this.mEN = false;
                    i.aLg();
                    i.this.fq(true);
                    i.this.X(1, "");
                    return;
                case TXLiveConstants.PLAY_EVT_PLAY_BEGIN /*2004*/:
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                case 10308:
                    x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", Integer.valueOf(i));
                    i.this.mEN = true;
                    string = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.uUQ);
                    if (i == 10308) {
                        string = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.uUR);
                    } else if (i == TXLiveConstants.PLAY_EVT_PLAY_LOADING) {
                        s.sVy.mFw = true;
                    }
                    i.aLg();
                    i.this.X(2, string);
                    return;
                case TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION /*2009*/:
                    x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", Integer.valueOf(i));
                    if (i.this.mFj != null) {
                        com.tencent.mm.plugin.soter.c.a.yt(i.this.mFj.fDr.fDu);
                    }
                    i.this.mEN = true;
                    string = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.uUQ);
                    i.aLg();
                    i.this.X(i, string);
                    return;
                default:
                    return;
            }
        }
    }

    public i() {
        this.mFk = null;
        this.mFl = null;
        this.mEN = false;
        this.fvC = "";
        this.xmG = lg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lg lgVar = (lg) bVar;
        if (g.Do().CF()) {
            this.mEN = false;
            if (lgVar instanceof lg) {
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "handle OpenFingerPrintAuthEventListener");
                if (e.aKP()) {
                    this.mFj = lgVar;
                    if (this.mFj == null) {
                        x.e("MicroMsg.OpenFingerPrintAuthEventListener", null, "mEvent is null !!!");
                    } else {
                        this.mFl = this.mFj.fDr.fDv;
                        this.fvC = lgVar.fDr.fxT;
                        com.tencent.mm.plugin.fingerprint.a.aKz();
                        if (com.tencent.mm.plugin.fingerprint.a.aKA() == null) {
                            return true;
                        }
                        com.tencent.mm.plugin.fingerprint.a.aKz();
                        com.tencent.mm.plugin.fingerprint.a.aKA();
                        boolean aKI = c.aKI();
                        if (this.mFi == null) {
                            this.mFi = new a();
                        }
                        com.tencent.mm.plugin.fingerprint.a.aKz();
                        com.tencent.mm.plugin.fingerprint.a.aKA();
                        this.mFk = ((l) g.h(l.class)).aKU();
                        if (this.mFk == null) {
                            return fq(false);
                        }
                        this.mFk.a(new com.tencent.mm.pluginsdk.wallet.a() {
                            public final void ai(int i, String str) {
                                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: pre processing done. errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                                if (i == 0) {
                                    i.this.fq(false);
                                } else {
                                    i.this.X(1, "");
                                }
                            }
                        });
                        return aKI;
                    }
                }
                x.e("MicroMsg.OpenFingerPrintAuthEventListener", "device is not support FingerPrintAuth");
                this.mEN = true;
                X(1, "");
                return true;
            }
        }
        x.e("MicroMsg.OpenFingerPrintAuthEventListener", "OpenFingerPrintAuthEvent account is not ready");
        return false;
    }

    public final void release() {
        com.tencent.mm.plugin.fingerprint.a.aKz();
        if (com.tencent.mm.plugin.fingerprint.a.aKA() != null) {
            com.tencent.mm.plugin.fingerprint.a.aKz();
            com.tencent.mm.plugin.fingerprint.a.aKA();
            c.release();
        }
        this.mFj = null;
    }

    public static void aLg() {
        com.tencent.mm.plugin.fingerprint.a.aKz();
        if (com.tencent.mm.plugin.fingerprint.a.aKA() != null) {
            boolean z;
            com.tencent.mm.plugin.fingerprint.a.aKz();
            com.tencent.mm.plugin.fingerprint.a.aKA();
            c.abort();
            com.tencent.mm.plugin.fingerprint.a.aKz();
            com.tencent.mm.plugin.fingerprint.a.aKA();
            c.release();
            String str = "MicroMsg.OpenFingerPrintAuthEventListener";
            String str2 = "stopIdentify() isSoter: %b";
            Object[] objArr = new Object[1];
            com.tencent.mm.plugin.fingerprint.a.aKz();
            com.tencent.mm.plugin.fingerprint.a.aKA();
            if (((l) g.h(l.class)).type() == 2) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
        }
    }

    final boolean fq(boolean z) {
        aLg();
        com.tencent.mm.plugin.fingerprint.a.aKz();
        com.tencent.mm.plugin.fingerprint.a.aKA();
        if (c.aKI()) {
            com.tencent.mm.plugin.fingerprint.a.aKz();
            com.tencent.mm.plugin.fingerprint.a.aKA();
            if (c.a(this.mFi, z) != 0) {
                x.e("MicroMsg.OpenFingerPrintAuthEventListener", "failed to start identify");
                release();
                this.mEN = true;
                X(1, "");
                return false;
            }
            x.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
            return true;
        }
        x.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
        release();
        this.mEN = true;
        X(1, "");
        return false;
    }

    final void X(int i, String str) {
        x.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
        com.tencent.mm.plugin.fingerprint.a.aKz();
        com.tencent.mm.plugin.fingerprint.a.aKA();
        ((l) g.h(l.class)).a(this.mFj, i, str);
        if (this.mEN) {
            this.mFj = null;
        }
        x.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    }
}
