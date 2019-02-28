package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.a.qv;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public final class JsApiMakeVoIPCall extends a {
    public static final int CTRL_INDEX = 154;
    public static final String NAME = "makeVoIPCall";
    private j isW;
    private int jfG;

    private static class StartVoIPCall extends MainProcessTask {
        public static final Creator<StartVoIPCall> CREATOR = new Creator<StartVoIPCall>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartVoIPCall(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartVoIPCall[i];
            }
        };
        private e jfZ;
        private c jgH = new c<qv>() {
            {
                this.xmG = qv.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                qv qvVar = (qv) bVar;
                if (qvVar != null && (qvVar instanceof qv)) {
                    StartVoIPCall.this.status = qvVar.fJw.status;
                    a.xmy.c(StartVoIPCall.this.jgH);
                    StartVoIPCall.this.afF();
                }
                return false;
            }
        };
        private j jga;
        private int jgb;
        public int status;

        public StartVoIPCall(e eVar, j jVar, int i) {
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public StartVoIPCall(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            a.xmy.b(this.jgH);
        }

        public final void YB() {
            afz();
            x.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", Integer.valueOf(this.status));
            if (this.status == 1) {
                this.jga.E(this.jgb, this.jfZ.e("cancel", null));
            } else if (this.status == 2) {
                this.jga.E(this.jgb, this.jfZ.e("ok", null));
            } else if (this.status == 3) {
                this.jga.E(this.jgb, this.jfZ.e("fail:network error", null));
            } else if (this.status == 4) {
                this.jga.E(this.jgb, this.jfZ.e("fail:param not match", null));
            } else {
                this.jga.E(this.jgb, this.jfZ.e("fail:unknow", null));
            }
        }

        public final void f(Parcel parcel) {
            this.status = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.status);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        this.isW = jVar;
        this.jfG = i;
        String optString = jSONObject.optString("context");
        String optString2 = jSONObject.optString("avatarUrl");
        boolean optBoolean = jSONObject.optBoolean("showOther");
        boolean optBoolean2 = jSONObject.optBoolean("allowBackCamera");
        String optString3 = jSONObject.optString("toUserName");
        String oM = bi.oM(jSONObject.optString("scene"));
        String oM2 = bi.oM(jSONObject.optString(Columns.TYPE));
        AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
        if (bi.oN(optString3) && appBrandSysConfig != null) {
            optString3 = appBrandSysConfig.foe;
        }
        if (bi.oN(jVar.mAppId) || bi.oN(optString3)) {
            x.e("MicroMsg.JsApiMakeVoIPCall", "appId or toUserName invalid!");
            jVar.E(i, e("fail", null));
            return;
        }
        x.d("MicroMsg.JsApiMakeVoIPCall", "allowBackCamera: %s, showOther: %s, avatarUrl: %s, context: %s, toUserName: %s", Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean), optString2, optString, optString3);
        MainProcessTask startVoIPCall = new StartVoIPCall(this, jVar, i);
        startVoIPCall.afy();
        AppBrandMainProcessService.a(startVoIPCall);
        Intent intent = new Intent();
        intent.putExtra("voipCSBizId", optString3);
        intent.putExtra("voipCSAppId", jVar.mAppId);
        intent.putExtra("voipCSAllowBackCamera", optBoolean2 ? "1" : "0");
        intent.putExtra("voipCSShowOther", optBoolean ? "1" : "0");
        intent.putExtra("voipCSAvatarUrl", optString2);
        intent.putExtra("voipCSContext", optString);
        intent.putExtra("voipCSScene", oM);
        intent.putExtra("voipCSType", oM2);
        intent.putExtra("launch_from_appbrand", true);
        intent.setClassName(jVar.getContext(), jVar.getContext().getPackageName() + ".plugin.voip_cs.ui.VoipCSMainUI");
        AppBrandProcessProxyUI.m(jVar.getContext(), intent);
    }
}
