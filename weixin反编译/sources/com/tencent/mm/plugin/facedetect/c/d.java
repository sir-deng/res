package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.m;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.a;
import com.tencent.mm.plugin.facedetect.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    String appId;
    private String fCU;
    boolean loL;
    String mlA;
    private String mlt;
    private String mlu;

    d(Context context, e eVar, int i, Bundle bundle) {
        super(context, eVar, i);
        this.loL = false;
        this.mlq = true;
        this.appId = bundle.getString("k_app_id", null);
        this.fCU = bundle.getString("request_verify_pre_info", null);
        this.mlA = bundle.getString("key_feedback_url", null);
    }

    public final k aGV() {
        return new m(aGT(), this.appId, this.fCU, this.mlt, this.mlu);
    }

    public final void onStart() {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onStart and create report session");
        if (this.loL) {
            FaceDetectReporter.aHr().aHs();
        }
        FaceDetectReporter.aHr().D(this.mln, this.loL);
        FaceDetectReporter aHr = FaceDetectReporter.aHr();
        aHr.mmH++;
        x.v("MicroMsg.FaceDetectReporter", "alvinluo addFaceDetectCount: %d", Integer.valueOf(aHr.mmH));
    }

    public final void onRelease() {
        if (!FaceDetectReporter.aHr().mmB) {
            FaceDetectReporter.aHr().a(this.mln, this.loL, 2, 1, 90006);
        }
    }

    public final void h(int i, int i2, String str) {
        x.v("MicroMsg.FaceDetectMpController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
    }

    public final boolean e(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i != 0 || i2 != 0) {
            FaceDetectReporter.aHr().a(this.mln, this.loL, 1, 2, 90012);
            a(i, i2, str, false, null);
            return true;
        } else if (bundle == null || bi.oN(bundle.getString("key_pic_cdn_id"))) {
            x.e("MicroMsg.FaceDetectMpController", "hy: not return cdn id!");
            a(4, 6, "not return cdn id", false, null);
            return true;
        } else {
            this.mlt = bundle.getString("key_pic_cdn_id");
            this.mlu = bundle.getString("key_cdn_aes_key");
            x.v("MicroMsg.FaceDetectMpController", "hy: start upload: picCdnId: %s, aes key: %s", this.mlt, this.mlu);
            return false;
        }
    }

    public final void h(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar instanceof m) {
            Bundle bundle = new Bundle();
            bundle.putString("verify_result", ((m) kVar).mkZ);
            if (i == 0 && i2 == 0) {
                FaceDetectReporter.aHr().a(this.mln, this.loL, 0, i, i2, this.mlp != null ? this.mlp.mkG : 0);
                FaceDetectReporter.aHr().mmI = true;
                b pS = a.pS(com.tencent.mm.plugin.facedetect.a.d.miC);
                pS.moN = true;
                pS.moV = ad.getResources().getString(h.mjZ);
                a(false, true, pS);
                final int i3 = i;
                final int i4 = i2;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                ah.h(new Runnable() {
                    public final void run() {
                        d.this.b(i3, i4, str2, bundle2);
                    }
                }, 1500);
                return;
            }
            int i5;
            FaceDetectReporter aHr = FaceDetectReporter.aHr();
            int i6 = this.mln;
            boolean z = this.loL;
            if (this.mlp != null) {
                i5 = this.mlp.mkG;
            } else {
                i5 = 0;
            }
            aHr.a(i6, z, 1, i, i2, i5);
            a(i, i2, str, ((m) kVar).mla, bundle);
        }
    }

    public final void f(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!FaceDetectReporter.aHr().mmB) {
            FaceDetectReporter.aHr().a(this.mln, this.loL, 3, i, i2);
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("verify_result", bundle.getString("verify_result"));
            b(i, i2, str, bundle2);
            return;
        }
        b(i, i2, str, null);
    }

    public final void af(int i, String str) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onCancel, errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (!FaceDetectReporter.aHr().mmB) {
            FaceDetectReporter.aHr().a(this.mln, this.loL, 2, 1, i);
        }
        b(1, i, str, null);
    }

    public final Bundle aGW() {
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", aGT());
        bundle.putString("key_app_id", this.appId);
        return bundle;
    }

    private void a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        c(i, i2, str, bundle);
        final Context context = ad.getContext();
        if (str == null) {
            string = context.getString(h.mjA);
        } else {
            string = str;
        }
        int i3 = com.tencent.mm.plugin.facedetect.a.d.mip;
        String string2 = z ? context.getString(h.mjY) : context.getString(h.mjX);
        String string3 = z ? context.getString(h.dEy) : null;
        final boolean z2 = z;
        final int i4 = i;
        final int i5 = i2;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        AnonymousClass2 anonymousClass2 = new OnClickListener() {
            public final void onClick(View view) {
                if (z2) {
                    d dVar = d.this;
                    dVar.aGS();
                    dVar.loL = true;
                    return;
                }
                d.this.b(i4, i5, str2, bundle2);
            }
        };
        i4 = i;
        i5 = i2;
        str2 = str;
        bundle2 = bundle;
        b a = a.a(i3, string, string2, null, string3, anonymousClass2, new OnClickListener() {
            public final void onClick(View view) {
                d.this.b(i4, i5, str2, bundle2);
            }
        });
        final Bundle bundle3 = bundle;
        final int i6 = i2;
        a.a(a, context.getString(h.mjE), new OnClickListener() {
            public final void onClick(View view) {
                if (bi.oN(d.this.mlA)) {
                    x.e("MicroMsg.FaceDetectMpController", "alvinluo feedback url is null");
                    return;
                }
                if (!(d.this.mll == null || d.this.mll.get() == null)) {
                    ((e) d.this.mll.get()).aGX();
                }
                String str = null;
                if (bundle3 != null) {
                    str = bundle3.getString("verify_result");
                }
                try {
                    String str2 = "appid=%s;errcode=%d;identifyid=%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = d.this.appId != null ? d.this.appId : "";
                    objArr[1] = Integer.valueOf(i6);
                    if (str == null) {
                        str = "";
                    }
                    objArr[2] = str;
                    x.i("MicroMsg.FaceDetectMpController", "alvinluo feedback url: %s", d.this.mlA + "?customInfo=" + p.encode(String.format(str2, objArr), "UTF-8"));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FaceDetectMpController", e, "alvinluo start feedback webview exception", new Object[0]);
                }
            }
        });
        a(true, false, a);
    }
}
