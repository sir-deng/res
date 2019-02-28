package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import junit.framework.Assert;
import org.json.JSONObject;

public final class JsApiLaunchMiniProgram extends a {
    public static final int CTRL_INDEX = 166;
    public static final String NAME = "launchMiniProgram";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram$2 */
    class AnonymousClass2 implements MMToClientEvent.a {
        final /* synthetic */ int gQv;
        final /* synthetic */ j jcM;
        final /* synthetic */ String jrt;
        final /* synthetic */ int jru;

        AnonymousClass2(String str, int i, j jVar, int i2) {
            this.jrt = str;
            this.jru = i;
            this.jcM = jVar;
            this.gQv = i2;
        }

        public final void bc(Object obj) {
            if (obj instanceof LaunchBroadCast) {
                LaunchBroadCast launchBroadCast = (LaunchBroadCast) obj;
                if (this.jrt.equals(launchBroadCast.appId) && this.jru == launchBroadCast.iNi) {
                    MMToClientEvent.b(this);
                    this.jcM.E(this.gQv, JsApiLaunchMiniProgram.this.e(launchBroadCast.fKR ? "ok" : "fail", null));
                }
            }
        }
    }

    private static final class LaunchPreconditionTask extends MainProcessTask {
        public static final Creator<LaunchPreconditionTask> CREATOR = new Creator<LaunchPreconditionTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LaunchPreconditionTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchPreconditionTask[i];
            }
        };
        private String jrv;
        private int jrw;
        private int jrx = a.FAIL.ordinal();

        enum a {
            FAIL("fail"),
            FAIL_MORE_THAN_ONE_TASK("fail can not launch more than 1 mini program"),
            OK("ok");
            
            public final String fpV;

            private a(String str) {
                this.fpV = str;
            }

            public static a kE(int i) {
                for (a aVar : values()) {
                    if (i == aVar.ordinal()) {
                        return aVar;
                    }
                }
                return null;
            }
        }

        public final void f(Parcel parcel) {
            this.jrv = parcel.readString();
            this.jrw = parcel.readInt();
            this.jrx = parcel.readInt();
        }

        public final void YA() {
            d.uT(this.jrv);
            this.jrx = a.OK.ordinal();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.jrv);
            parcel.writeInt(this.jrw);
            parcel.writeInt(this.jrx);
        }

        LaunchPreconditionTask() {
        }

        LaunchPreconditionTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        int i2 = 1;
        final String optString = jSONObject.optString("appId", null);
        if (bi.oN(optString)) {
            jVar.E(i, e("fail:invalid data", null));
        } else if (optString.equals(jVar.mAppId)) {
            jVar.E(i, e("fail target appId is the same as the caller appId", null));
        } else {
            final String optString2 = jSONObject.optString("path", null);
            final String optString3 = jSONObject.optString("extraData", null);
            if (!(jVar.iuk.isS.iRU.iJa == 1 && jSONObject.optBoolean("isDev", false))) {
                i2 = 0;
            }
            final j jVar2 = jVar;
            final int i3 = i;
            ah.y(new Runnable() {
                public final void run() {
                    e eVar = JsApiLaunchMiniProgram.this;
                    j jVar = jVar2;
                    String str = optString;
                    int i = i2;
                    String str2 = optString2;
                    String str3 = optString3;
                    int i2 = i3;
                    MainProcessTask launchPreconditionTask = new LaunchPreconditionTask();
                    launchPreconditionTask.jrv = str;
                    launchPreconditionTask.jrw = i;
                    if (AppBrandMainProcessService.b(launchPreconditionTask)) {
                        a kE = a.kE(launchPreconditionTask.jrx);
                        if (kE == null) {
                            kE = a.FAIL;
                        }
                        if (a.OK != kE) {
                            jVar.E(i2, eVar.e(kE.fpV, null));
                            return;
                        }
                        c.a(jVar.mAppId, c.c.LAUNCH_MINI_PROGRAM);
                        MMToClientEvent.a(new AnonymousClass2(str, i, jVar, i2));
                        if (jVar.getContext() != null && (jVar.getContext() instanceof Activity) && !jVar.getContext().isFinishing()) {
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.scene = 1037;
                            AppBrandStatObject pl = com.tencent.mm.plugin.appbrand.a.pl(jVar.mAppId);
                            if (pl != null) {
                                appBrandStatObject.fJm = pl.fJm;
                            }
                            String str4 = "";
                            p b = e.b(jVar);
                            if (b != null) {
                                str4 = b.afe();
                            }
                            appBrandStatObject.foi = jVar.mAppId + ":" + jVar.iuk.isR.iub;
                            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                            appBrandLaunchReferrer.appId = jVar.mAppId;
                            appBrandLaunchReferrer.iRq = str3;
                            appBrandLaunchReferrer.iRp = 1;
                            appBrandLaunchReferrer.url = str4;
                            AppBrandLaunchProxyUI.a(jVar.getContext(), null, str, str2, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
                            Assert.assertTrue(true);
                            return;
                        }
                        return;
                    }
                    jVar.E(i2, eVar.e("fail precondition error", null));
                }
            });
        }
    }
}
