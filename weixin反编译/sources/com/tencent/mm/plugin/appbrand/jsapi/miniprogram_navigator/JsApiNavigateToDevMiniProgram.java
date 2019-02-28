package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.launching.i;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class JsApiNavigateToDevMiniProgram extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 351;
    private static final String NAME = "navigateToDevMiniProgram";

    private static final class DevPkgInfo implements Parcelable {
        public static final Creator<DevPkgInfo> CREATOR = new Creator<DevPkgInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DevPkgInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DevPkgInfo[i];
            }
        };
        String appId;
        String fJi;
        String fwM;
        String jrD;

        DevPkgInfo() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.fwM);
            parcel.writeString(this.fJi);
            parcel.writeString(this.jrD);
        }

        DevPkgInfo(Parcel parcel) {
            this.appId = parcel.readString();
            this.fwM = parcel.readString();
            this.fJi = parcel.readString();
            this.jrD = parcel.readString();
        }
    }

    private static final class a implements j<DevPkgInfo, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ Object at(Object obj) {
            DevPkgInfo devPkgInfo = (DevPkgInfo) obj;
            ((i) e.u(i.class)).n(devPkgInfo.appId, 1, devPkgInfo.jrD);
            if (e.Zz().a(devPkgInfo.appId, 1, devPkgInfo.fwM, devPkgInfo.fJi, 0, bi.Wx() + 7200)) {
                d.aL(devPkgInfo.appId, 1);
            }
            return IPCVoid.gOQ;
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.j jVar, JSONObject jSONObject, final int i) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("downloadURL");
        String optString3 = jSONObject.optString("checkSumMd5");
        a a = a.a(jSONObject.optString("envVersion"), a.DEVELOP);
        String optString4 = jSONObject.optString("relativeURL");
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        String optString5 = jSONObject.optString("extoptions");
        if (bi.oN(optString)) {
            jVar.E(i, e("fail invalid appId", null));
        } else if (a.DEVELOP == a && (bi.oN(optString2) || bi.oN(optString3))) {
            jVar.E(i, e("fail invalid downloadURL & checkSumMd5", null));
        } else {
            if (a.DEVELOP == a) {
                DevPkgInfo devPkgInfo = new DevPkgInfo();
                devPkgInfo.appId = optString;
                devPkgInfo.fwM = optString2;
                devPkgInfo.fJi = optString3;
                devPkgInfo.jrD = optString5;
                XIPCInvoker.a("com.tencent.mm", devPkgInfo, a.class);
            }
            e.a(jVar, optString, a.iNi, 0, optString4, null, optJSONObject, new b() {
                public final void cQ(boolean z) {
                    jVar.E(i, JsApiNavigateToDevMiniProgram.this.e(z ? "ok" : "fail", null));
                }
            });
        }
    }
}
