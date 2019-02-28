package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.e;
import com.tencent.mm.plugin.facedetect.b.n;
import com.tencent.mm.plugin.facedetect.b.o;
import com.tencent.mm.plugin.facedetect.b.s;
import com.tencent.mm.plugin.facedetect.b.t;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.a;
import com.tencent.mm.plugin.facedetect.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a {
    boolean loL;
    private String mlt;
    private String mlu;
    private int mlv;

    c(Context context, e eVar, int i) {
        super(context, eVar, i);
        this.loL = false;
        this.mlq = true;
        this.mlv = i;
    }

    private String getResultKey() {
        switch (this.mlv) {
            case 0:
            case 3:
                return "faceregister_ticket";
            case 1:
            case 4:
                return "faceverify_ticket";
            default:
                return "verify_result";
        }
    }

    public final k aGV() {
        long aGT = aGT();
        String str = this.mlt;
        String str2 = this.mlu;
        switch (this.mlv) {
            case 0:
                return new n(aGT, str, str2);
            case 1:
                return new s(aGT, str, str2);
            case 3:
                return new o(aGT, str, str2);
            case 4:
                return new t(aGT, str, str2);
            default:
                return null;
        }
    }

    public final void onStart() {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onStart and create report session");
        if (this.loL) {
            FaceDetectReporter.aHr().aHs();
            FaceDetectReporter.aHr().D(FaceDetectReporter.pN(this.mlv), this.loL);
        }
    }

    public final void onRelease() {
        if (!FaceDetectReporter.aHr().mmB) {
            FaceDetectReporter.aHr().a(FaceDetectReporter.pN(this.mlv), this.loL, 2, 1, 90006);
        }
    }

    public final void h(int i, int i2, String str) {
        x.v("MicroMsg.FaceDetectLoginController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
    }

    public final boolean e(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i != 0 || i2 != 0) {
            FaceDetectReporter.aHr().a(FaceDetectReporter.pN(this.mlv), this.loL, 1, 2, 90012);
            a(i, i2, str, false, null);
            return true;
        } else if (bundle == null || bi.oN(bundle.getString("key_pic_cdn_id"))) {
            x.e("MicroMsg.FaceDetectLoginController", "hy: not return cdn id!");
            a(4, 6, "not return cdn id", false, null);
            return true;
        } else {
            this.mlt = bundle.getString("key_pic_cdn_id");
            this.mlu = bundle.getString("key_cdn_aes_key");
            x.v("MicroMsg.FaceDetectLoginController", "hy: start upload: picCdnId: %s, aes key: %s", this.mlt, this.mlu);
            return false;
        }
    }

    public final void h(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar instanceof e) {
            e eVar = (e) kVar;
            Bundle bundle = new Bundle();
            bundle.putString(getResultKey(), eVar.aGP());
            if (i == 0 && i2 == 0) {
                FaceDetectReporter.aHr().a(this.mln, eVar.aGO(), 0, i, i2, this.mlp != null ? this.mlp.mkG : 0);
                b pS = a.pS(d.miC);
                pS.moN = true;
                pS.moV = ad.getResources().getString(h.mjZ);
                a(false, true, pS);
                final int i3 = i;
                final int i4 = i2;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                ah.h(new Runnable() {
                    public final void run() {
                        c.this.b(i3, i4, str2, bundle2);
                    }
                }, 1500);
                return;
            }
            int i5;
            FaceDetectReporter aHr = FaceDetectReporter.aHr();
            int i6 = this.mln;
            boolean aGO = eVar.aGO();
            if (this.mlp != null) {
                i5 = this.mlp.mkG;
            } else {
                i5 = 0;
            }
            aHr.a(i6, aGO, 1, i, i2, i5);
            a(i, i2, str, eVar.aGO(), bundle);
        }
    }

    public final void f(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!FaceDetectReporter.aHr().mmB) {
            FaceDetectReporter.aHr().a(FaceDetectReporter.pN(this.mlv), this.loL, 3, i, i2);
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(getResultKey(), bundle.getString(getResultKey()));
            b(i, i2, str, bundle2);
            return;
        }
        b(i, i2, str, null);
    }

    public final void af(int i, String str) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onCancel, errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (!FaceDetectReporter.aHr().mmB) {
            FaceDetectReporter.aHr().a(FaceDetectReporter.pN(this.mlv), this.loL, 2, 1, i);
        }
        b(1, i, str, null);
    }

    public final Bundle aGW() {
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", aGT());
        return bundle;
    }

    private void a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        c(i, i2, str, bundle);
        Context context = ad.getContext();
        if (str == null) {
            string = context.getString(h.mjA);
        } else {
            string = str;
        }
        int i3 = d.mip;
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
                    c cVar = c.this;
                    cVar.aGS();
                    cVar.loL = true;
                    return;
                }
                c.this.b(i4, i5, str2, bundle2);
            }
        };
        i4 = i;
        i5 = i2;
        str2 = str;
        bundle2 = bundle;
        a(true, false, a.a(i3, string, string2, null, string3, anonymousClass2, new OnClickListener() {
            public final void onClick(View view) {
                c.this.b(i4, i5, str2, bundle2);
            }
        }));
    }
}
