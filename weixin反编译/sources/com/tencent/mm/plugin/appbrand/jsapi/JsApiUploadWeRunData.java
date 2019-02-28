package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.protocal.c.bse;
import com.tencent.mm.protocal.c.bsf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bv;
import org.json.JSONObject;

public class JsApiUploadWeRunData extends a {
    public static final int CTRL_INDEX = 323;
    public static final String NAME = "uploadWeRunData";
    private UploadMiniAppStepTask jhE;

    private static class UploadMiniAppStepTask extends MainProcessTask {
        public static final Creator<UploadMiniAppStepTask> CREATOR = new Creator<UploadMiniAppStepTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new UploadMiniAppStepTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UploadMiniAppStepTask[i];
            }
        };
        private String appId;
        private boolean fsk;
        private e jfZ;
        private j jga;
        private int jgb;
        private int jhF;
        private boolean jhG;

        public UploadMiniAppStepTask(e eVar, j jVar, int i, int i2, boolean z) {
            x.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
            this.jhF = i2;
            this.jhG = z;
            this.appId = jVar.mAppId;
        }

        public UploadMiniAppStepTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            long Ik = bv.Ik();
            x.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", Long.valueOf(Ik / 1000));
            if (Ik == 0) {
                Ik = System.currentTimeMillis();
            }
            a aVar = new a();
            com.tencent.mm.bp.a bse = new bse();
            aVar.hnT = bse;
            aVar.hnU = new bsf();
            aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
            aVar.hnS = 1949;
            aVar.hnV = 0;
            aVar.hnW = 0;
            bse.nlV = this.appId;
            bse.kzx = this.jhF;
            bse.wZZ = this.jhG;
            bse.nnd = (int) (Ik / 1000);
            u.a(aVar.Kf(), new u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (kVar.getType() == 1949) {
                        if (i == 0 && i2 == 0) {
                            UploadMiniAppStepTask.this.fsk = true;
                            x.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
                        } else {
                            UploadMiniAppStepTask.this.fsk = false;
                            x.i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        }
                        UploadMiniAppStepTask.this.afF();
                    }
                    return 0;
                }
            }, true);
        }

        public final void YB() {
            if (this.fsk) {
                this.jga.E(this.jgb, this.jfZ.e("ok", null));
            } else {
                this.jga.E(this.jgb, this.jfZ.e("fail", null));
            }
            afz();
        }

        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.jhF = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.jhG = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.fsk = z2;
            this.appId = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeInt(this.jhF);
            if (this.jhG) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.fsk) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            parcel.writeString(this.appId);
        }
    }

    public void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiUploadWeRunData", "data is null");
            return;
        }
        a(this, jVar, i, jSONObject.optInt("step"), false);
    }

    public final void a(e eVar, j jVar, int i, int i2, boolean z) {
        if (i2 <= 0) {
            jVar.E(i, eVar.e("fail:step invalid", null));
            return;
        }
        this.jhE = new UploadMiniAppStepTask(eVar, jVar, i, i2, z);
        this.jhE.afy();
        AppBrandMainProcessService.a(this.jhE);
    }
}
