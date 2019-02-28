package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.f.a.ir;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUI;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class JsApiLaunchApplication extends a {
    private static final int CTRL_INDEX = 427;
    private static final String NAME = "launchApplication";

    private static class LaunchApplicationTask extends AppBrandProxyTransparentUIProcessTask {
        public static final Creator<LaunchApplicationTask> CREATOR = new Creator<LaunchApplicationTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LaunchApplicationTask(parcel, (byte) 0);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchApplicationTask[i];
            }
        };
        public String appId;
        public String extInfo;
        public Bundle frc;
        public Runnable jfW;
        public String jgA;
        public int showType;
        public boolean success;

        /* synthetic */ LaunchApplicationTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public final void a(Context context, final com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a aVar) {
            boolean a;
            if (!g.m(context, this.appId)) {
                x.e("MicroMsg.JsApiLaunchApplication", "app is not installed, appid:[%s]", this.appId);
                this.success = false;
                aVar.afx();
            }
            Object aVar2 = new a(new a() {
                public final void n(boolean z, boolean z2) {
                    x.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (z) {
                        LaunchApplicationTask.this.success = true;
                        aVar.afx();
                        return;
                    }
                    LaunchApplicationTask.this.success = false;
                    aVar.afx();
                }
            });
            IMediaObject wXAppExtendObject = new WXAppExtendObject();
            wXAppExtendObject.extInfo = this.extInfo;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
            wXMediaMessage.sdkVer = 620823552;
            wXMediaMessage.messageExt = this.extInfo;
            b irVar = new ir();
            irVar.fzV.fzX = wXMediaMessage;
            irVar.fzV.appId = this.appId;
            irVar.fzV.showType = this.showType;
            irVar.fzV.context = context;
            irVar.fzV.frc = this.frc;
            irVar.fzV.fzY = aVar2;
            com.tencent.mm.sdk.b.a.xmy.m(irVar);
            boolean z = irVar.fzW.fzZ;
            if (!z) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.jgA));
                x.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                List y = bi.y(context, intent);
                if (!(y == null || y.isEmpty())) {
                    Object b;
                    if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                        b = g.b((ResolveInfo) y.get(0));
                    } else {
                        b = intent.getPackage();
                    }
                    if (!bi.oM(ad.getPackageName()).equals(b)) {
                        aVar2.hpc = false;
                        aVar2.jgD = false;
                        aVar2.jgE = false;
                        aVar2.fzZ = false;
                        a = g.a(context, intent, null, aVar2, this.frc);
                        aVar2.cJ(a);
                    }
                }
            }
            a = z;
            aVar2.cJ(a);
        }

        public final void YB() {
            x.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess");
            if (this.jfW != null) {
                x.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess asyncCallback != null");
                this.jfW.run();
            }
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.showType = parcel.readInt();
            this.appId = parcel.readString();
            this.jgA = parcel.readString();
            this.extInfo = parcel.readString();
            this.frc = parcel.readBundle();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.showType);
            parcel.writeString(this.appId);
            parcel.writeString(this.jgA);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.frc);
            parcel.writeByte((byte) (this.success ? 1 : 0));
        }

        public LaunchApplicationTask(MMActivity mMActivity) {
            super(mMActivity);
        }

        private LaunchApplicationTask(Parcel parcel) {
            f(parcel);
        }
    }

    private static class a implements com.tencent.mm.pluginsdk.model.app.g.a {
        volatile boolean fzZ;
        volatile boolean hpc;
        volatile boolean jgD;
        volatile boolean jgE;
        a jgF;

        interface a {
            void n(boolean z, boolean z2);
        }

        a(a aVar) {
            this.jgF = aVar;
        }

        public final void cI(boolean z) {
            this.hpc = true;
            this.jgD = z;
            if (this.jgE && this.jgF != null) {
                this.jgF.n(this.fzZ, z);
            }
        }

        final void cJ(boolean z) {
            this.fzZ = z;
            this.jgE = true;
            if (this.hpc && this.jgF != null) {
                this.jgF.n(z, this.jgD);
            }
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiLaunchApplication", "data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        final String optString = jSONObject.optString("appId");
        final String optString2 = jSONObject.optString("schemeUrl");
        final String optString3 = jSONObject.optString("parameter");
        int i2 = bi.getInt(jSONObject.optString("alertType"), 0);
        final String optString4 = jSONObject.optString("extInfo");
        x.i("MicroMsg.JsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", optString, optString2, optString4, optString3);
        if (bi.oN(optString) && bi.oN(optString2)) {
            x.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
            jVar.E(i, e("fail:appid and scheme is null or nil", null));
            return;
        }
        String url;
        String str = jVar.mAppId;
        p b = e.b(jVar);
        if (b != null) {
            url = b.getURL();
        } else {
            x.e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
            url = null;
        }
        final Bundle bundle = new Bundle();
        if (!bi.oN(url)) {
            try {
                bundle.putString("current_page_url", URLEncoder.encode(url, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        bundle.putString("current_page_appid", str);
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new ami();
        aVar.hnU = new amj();
        aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        aVar.hnS = 1125;
        ami ami = (ami) aVar.Kf().hnQ.hnY;
        ami.fGh = str;
        ami.wzZ = optString;
        ami.scene = jVar.iuk.itc.scene;
        ami.url = url;
        ami.wAa = optString2;
        ami.low = i2;
        ami.wAb = 1;
        x.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", str, optString, Integer.valueOf(ami.scene), ami.url, ami.wAa, Integer.valueOf(ami.low));
        final j jVar2 = jVar;
        final int i3 = i;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.Kf(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                x.i("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    final amj amj = (amj) bVar.hnR.hnY;
                    switch (amj.fun) {
                        case 0:
                            final a aVar = new a(new a() {
                                public final void n(boolean z, boolean z2) {
                                    x.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                                    if (z) {
                                        jVar2.E(i3, JsApiLaunchApplication.this.e("ok", null));
                                    } else {
                                        jVar2.E(i3, JsApiLaunchApplication.this.e("fail:scheme launch fail", null));
                                    }
                                }
                            });
                            x.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", Integer.valueOf(amj.wAc), Integer.valueOf(amj.fun));
                            if (!bi.oN(optString2)) {
                                final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                List y = bi.y(jVar2.getContext(), intent);
                                if (!(y == null || y.isEmpty())) {
                                    Object b;
                                    if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                                        b = g.b((ResolveInfo) y.get(0));
                                    } else {
                                        b = intent.getPackage();
                                    }
                                    if (!bi.oM(ad.getPackageName()).equals(b)) {
                                        ah.y(new Runnable() {
                                            public final void run() {
                                                aVar.cJ(g.a(jVar2.getContext(), intent, null, amj.wAc, aVar, bundle));
                                            }
                                        });
                                        return;
                                    }
                                }
                            }
                            final AppBrandProxyTransparentUIProcessTask launchApplicationTask = new LaunchApplicationTask((MMActivity) jVar2.getContext());
                            launchApplicationTask.appId = optString;
                            launchApplicationTask.jgA = optString3;
                            launchApplicationTask.extInfo = optString4;
                            launchApplicationTask.frc = bundle;
                            launchApplicationTask.showType = amj.wAc;
                            launchApplicationTask.jfW = new Runnable() {
                                public final void run() {
                                    x.i("MicroMsg.JsApiLaunchApplication", "callback task.success:%b", Boolean.valueOf(launchApplicationTask.success));
                                    launchApplicationTask.afz();
                                    if (launchApplicationTask.success) {
                                        jVar2.E(i3, JsApiLaunchApplication.this.e("ok", null));
                                    } else {
                                        jVar2.E(i3, JsApiLaunchApplication.this.e("fail:sdk launch fail", null));
                                    }
                                }
                            };
                            launchApplicationTask.afy();
                            if (launchApplicationTask.mContext != null) {
                                AppBrandProxyTransparentUIProcessTask.jea.put(launchApplicationTask.jeC, new WeakReference(launchApplicationTask));
                                Intent intent2 = new Intent();
                                intent2.setClass(launchApplicationTask.mContext, AppBrandProxyTransparentUI.class);
                                intent2.putExtra("task_object", launchApplicationTask);
                                intent2.putExtra("task_class_name", launchApplicationTask.getClass().getName());
                                intent2.putExtra("task_id", launchApplicationTask.jeC);
                                intent2.putExtra("orientation", launchApplicationTask.jeA);
                                if (launchApplicationTask.mContext instanceof MMActivity) {
                                    launchApplicationTask.afy();
                                    ((MMActivity) launchApplicationTask.mContext).jCj = launchApplicationTask.jeB;
                                    ((MMActivity) launchApplicationTask.mContext).startActivityForResult(intent2, launchApplicationTask.hashCode() & 65535);
                                    return;
                                }
                                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                launchApplicationTask.mContext.startActivity(intent2);
                                return;
                            }
                            return;
                        case 2:
                            jVar2.E(i3, JsApiLaunchApplication.this.e("fail:check fail forbidden scene 2", null));
                            return;
                        default:
                            jVar2.E(i3, JsApiLaunchApplication.this.e("fail:check fail 1", null));
                            return;
                    }
                }
                jVar2.E(i3, JsApiLaunchApplication.this.e("fail:check fail", null));
            }
        });
    }
}
