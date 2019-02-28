package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

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
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.ami;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class GameJsApiLaunchApplication extends a {
    public static final int CTRL_BYTE = 260;
    public static final String NAME = "launchApplication";

    private static class LaunchApplicationTask extends GameProcessActivityTask {
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

        public final void a(Context context, final GameProcessActivityTask.a aVar) {
            if (g.m(context, this.appId)) {
                IMediaObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = this.extInfo;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620823552;
                wXMediaMessage.messageExt = this.extInfo;
                final b irVar = new ir();
                irVar.fzV.fzX = wXMediaMessage;
                irVar.fzV.appId = this.appId;
                irVar.fzV.showType = this.showType;
                irVar.fzV.context = context;
                irVar.fzV.frc = this.frc;
                irVar.fzV.fzY = new g.a() {
                    public final void cI(boolean z) {
                        if (irVar.fzW.fzZ || z) {
                            LaunchApplicationTask.this.success = true;
                            aVar.afx();
                        }
                    }
                };
                com.tencent.mm.sdk.b.a.xmy.m(irVar);
                if (!irVar.fzW.fzZ) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.jgA));
                    x.i("MicroMsg.GameJsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
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
                            g.a(context, intent, null, new g.a() {
                                public final void cI(boolean z) {
                                    LaunchApplicationTask.this.success = true;
                                    aVar.afx();
                                }
                            }, this.frc);
                            return;
                        }
                    }
                    this.success = false;
                    aVar.afx();
                    return;
                }
                return;
            }
            x.e("MicroMsg.GameJsApiLaunchApplication", "app is not installed, appid:[%s]", this.appId);
            this.success = false;
            aVar.afx();
        }

        public final void YB() {
            if (this.jfW != null) {
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

    public final void a(final d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiLaunchApplication", "invoke");
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiLaunchApplication", "data is null");
            dVar.E(i, a.e("launchApplication:fail", null));
            return;
        }
        final Context aPO = dVar.aPO();
        final String optString = jSONObject.optString("appID");
        final String optString2 = jSONObject.optString("schemeUrl");
        String optString3 = jSONObject.optString("parameter");
        int optInt = jSONObject.optInt("alertType");
        final String optString4 = jSONObject.optString("extInfo");
        x.i("MicroMsg.GameJsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", optString, optString2, optString4, optString3);
        if (bi.oN(optString) && bi.oN(optString2)) {
            x.e("MicroMsg.GameJsApiLaunchApplication", "appid and scheme is null or nil");
            dVar.E(i, a.e("launchApplication:fail", null));
            return;
        }
        Object aPS = dVar.aPS();
        final Bundle bundle = new Bundle();
        try {
            bundle.putString("current_page_url", URLEncoder.encode(dVar.aPR(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }
        bundle.putString("current_page_appid", aPS);
        if (!bi.oN(optString)) {
            final a.a aVar = new a.a(dVar, i);
            com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
            aVar2.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
            aVar2.hnS = 1125;
            com.tencent.mm.bp.a ami = new ami();
            ami.fGh = aPS;
            ami.wzZ = optString;
            ami.scene = dVar.neZ;
            ami.url = dVar.aPR();
            ami.wAa = optString2;
            ami.low = optInt;
            ami.wAb = 0;
            x.i("MicroMsg.GameJsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", aPS, optString, Integer.valueOf(ami.scene), ami.url, ami.wAa, Integer.valueOf(ami.low));
            aVar2.hnT = ami;
            aVar2.hnU = new amj();
            com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.Kf(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                    x.d("MicroMsg.GameJsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    a.a aVar;
                    GameJsApiLaunchApplication gameJsApiLaunchApplication;
                    if (i == 0 && i2 == 0) {
                        amj amj = (amj) bVar.hnR.hnY;
                        switch (amj.fun) {
                            case 0:
                                if (!bi.oN(optString2)) {
                                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    List y = bi.y(aPO, intent);
                                    if (!(y == null || y.isEmpty())) {
                                        Object b;
                                        if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                                            b = g.b((ResolveInfo) y.get(0));
                                        } else {
                                            b = intent.getPackage();
                                        }
                                        if (!bi.oM(ad.getPackageName()).equals(b)) {
                                            g.a(aPO, intent, null, amj.wAc, new g.a() {
                                                public final void cI(boolean z) {
                                                    a.a aVar = aVar;
                                                    GameJsApiLaunchApplication gameJsApiLaunchApplication = GameJsApiLaunchApplication.this;
                                                    aVar.sE(a.e("launchApplication:ok", null));
                                                }
                                            }, bundle);
                                            return;
                                        }
                                    }
                                }
                                final LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(aPO);
                                launchApplicationTask.appId = optString;
                                launchApplicationTask.extInfo = optString4;
                                launchApplicationTask.frc = bundle;
                                launchApplicationTask.showType = amj.wAc == 1 ? 1 : 0;
                                launchApplicationTask.jfW = new Runnable() {
                                    public final void run() {
                                        x.i("MicroMsg.GameJsApiLaunchApplication", "callback");
                                        a.a aVar;
                                        GameJsApiLaunchApplication gameJsApiLaunchApplication;
                                        if (launchApplicationTask.success) {
                                            aVar = aVar;
                                            gameJsApiLaunchApplication = GameJsApiLaunchApplication.this;
                                            aVar.sE(a.e("launchApplication:ok", null));
                                            return;
                                        }
                                        aVar = aVar;
                                        gameJsApiLaunchApplication = GameJsApiLaunchApplication.this;
                                        aVar.sE(a.e("launchApplication:fail", null));
                                    }
                                };
                                launchApplicationTask.aLl();
                                return;
                            case 2:
                                aVar = aVar;
                                gameJsApiLaunchApplication = GameJsApiLaunchApplication.this;
                                aVar.sE(a.e("launchApplication:fail_check fail forbidden scene", null));
                                return;
                            default:
                                aVar = aVar;
                                gameJsApiLaunchApplication = GameJsApiLaunchApplication.this;
                                aVar.sE(a.e("launchApplication:fail_check fail", null));
                                return;
                        }
                    }
                    aVar = aVar;
                    gameJsApiLaunchApplication = GameJsApiLaunchApplication.this;
                    aVar.sE(a.e("launchApplication:fail_check fail", null));
                }
            });
        } else if (TextUtils.isEmpty(aPS)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            List y = bi.y(aPO, intent);
            if (!(y == null || y.isEmpty())) {
                if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                    aPS = g.b((ResolveInfo) y.get(0));
                } else {
                    aPS = intent.getPackage();
                }
                if (!bi.oM(ad.getPackageName()).equals(aPS)) {
                    final int i2 = i;
                    g.a(aPO, intent, null, new g.a() {
                        public final void cI(boolean z) {
                            d dVar = dVar;
                            int i = i2;
                            GameJsApiLaunchApplication gameJsApiLaunchApplication = GameJsApiLaunchApplication.this;
                            dVar.E(i, a.e("launchApplication:ok", null));
                        }
                    }, bundle);
                    return;
                }
            }
            dVar.E(i, a.e("launchApplication:fail", null));
        } else {
            dVar.E(i, a.e("launchApplication:fail", null));
        }
    }
}
