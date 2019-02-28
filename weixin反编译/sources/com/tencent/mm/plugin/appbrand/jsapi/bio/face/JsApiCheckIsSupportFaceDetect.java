package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.a.hl;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect extends a {
    public static final int CTRL_INDEX = 214;
    public static final String NAME = "checkIsSupportFacialRecognition";
    private GetIsSupportFaceTask jkG = null;

    private static class GetIsSupportFaceTask extends MainProcessTask {
        public static final Creator<GetIsSupportFaceTask> CREATOR = new Creator<GetIsSupportFaceTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetIsSupportFaceTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsSupportFaceTask[i];
            }
        };
        private int errCode = -1;
        private boolean fJK = false;
        private String foE = "not returned";
        private j isW = null;
        private int jfG = -1;
        private JsApiCheckIsSupportFaceDetect jkH;
        private int jkI = -1;

        public final void YB() {
            super.YB();
            x.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", Boolean.valueOf(this.fJK), Integer.valueOf(this.errCode), this.foE, Integer.valueOf(this.jkI));
            Map hashMap = new HashMap(3);
            hashMap.put("errCode", Integer.valueOf(this.errCode));
            hashMap.put("libVersionCode", Integer.valueOf(this.jkI));
            if (this.errCode == 0) {
                this.isW.E(this.jfG, this.jkH.e("ok", hashMap));
            } else {
                this.isW.E(this.jfG, this.jkH.e("fail " + this.foE, hashMap));
            }
            c.bl(this);
        }

        public final void YA() {
            b hlVar = new hl();
            com.tencent.mm.sdk.b.a.xmy.m(hlVar);
            this.fJK = hlVar.fyD.fyE;
            this.errCode = hlVar.fyD.fyF;
            this.foE = hlVar.fyD.fyG;
            this.jkI = hlVar.fyD.fyH;
            x.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", Boolean.valueOf(this.fJK), Integer.valueOf(this.errCode), this.foE, Integer.valueOf(this.jkI));
            afF();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.fJK ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.foE);
            parcel.writeInt(this.jkI);
        }

        public GetIsSupportFaceTask(j jVar, int i, JsApiCheckIsSupportFaceDetect jsApiCheckIsSupportFaceDetect) {
            this.isW = jVar;
            this.jfG = i;
            this.jkH = jsApiCheckIsSupportFaceDetect;
        }

        protected GetIsSupportFaceTask(Parcel parcel) {
            f(parcel);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.fJK = parcel.readByte() != (byte) 0;
            this.errCode = parcel.readInt();
            this.foE = parcel.readString();
            this.jkI = parcel.readInt();
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
        this.jkG = new GetIsSupportFaceTask(jVar, i, this);
        c.bk(this.jkG);
        AppBrandMainProcessService.a(this.jkG);
    }
}
