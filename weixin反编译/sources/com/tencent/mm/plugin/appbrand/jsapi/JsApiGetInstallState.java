package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiGetInstallState extends a {
    public static final int CTRL_INDEX = 439;
    public static final String NAME = "getInstallState";

    private static class GetInstallStateTask extends MainProcessTask {
        public static final Creator<GetInstallStateTask> CREATOR = new Creator<GetInstallStateTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetInstallStateTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetInstallStateTask[i];
            }
        };
        private j isW;
        private e jfE;
        private int jfG;
        private boolean jfQ;
        private boolean jgm;
        private String mPackageName;
        private String mVersionName;

        public GetInstallStateTask(e eVar, j jVar, int i, JSONObject jSONObject) {
            this.jfE = eVar;
            this.isW = jVar;
            this.jfG = i;
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            this.jfQ = true;
        }

        public GetInstallStateTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            PackageInfo packageInfo = p.getPackageInfo(ad.getContext(), this.mPackageName);
            int i = packageInfo == null ? 0 : packageInfo.versionCode;
            String str = packageInfo == null ? "null" : packageInfo.versionName;
            x.i("MicroMsg.JsApiGetInstallState", "doGetInstallState, packageName = " + this.mPackageName + ", packageInfo = " + packageInfo + ", version = " + i + ", versionName = " + str);
            if (packageInfo == null) {
                this.jgm = false;
            } else {
                this.mVersionName = str;
                this.jgm = true;
            }
            this.jfQ = false;
            afF();
        }

        public final void YB() {
            if (this.jfQ) {
                this.isW.E(this.jfG, this.jfE.e("fail", null));
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("versionName", this.mVersionName);
            hashMap.put("isInstalled", Boolean.valueOf(this.jgm));
            this.isW.E(this.jfG, this.jfE.e("ok", hashMap));
        }

        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.mPackageName = parcel.readString();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.jfQ = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.jgm = z2;
            this.mVersionName = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeString(this.mPackageName);
            if (this.jfQ) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.jgm) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeString(this.mVersionName);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new GetInstallStateTask(this, jVar, i, jSONObject));
    }
}
