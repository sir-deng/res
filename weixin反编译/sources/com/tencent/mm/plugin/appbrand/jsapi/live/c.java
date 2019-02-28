package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 360;
    public static final String NAME = "insertLivePusher";
    private int jor;

    private static final class a extends f {
        private static final int CTRL_INDEX = 411;
        private static final String NAME = "onLivePusherNetStatus";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static final class b extends f {
        private static final int CTRL_INDEX = 368;
        private static final String NAME = "onLivePusherEvent";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        k.agK();
        if (pVar.mContext instanceof Activity) {
            this.jor = 0;
            a((Activity) pVar.mContext, pVar, jSONObject, i);
            return;
        }
        x.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
        pVar.E(i, e("fail", null));
        com.tencent.mm.plugin.appbrand.a.pj(pVar.mAppId);
    }

    protected final View a(p pVar, JSONObject jSONObject) {
        return new CoverViewContainer(pVar.mContext, new AppBrandLivePusherView(pVar.mContext));
    }

    protected final int j(JSONObject jSONObject) {
        return jSONObject.getInt("livePusherId");
    }

    protected final void a(final p pVar, final int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            j jVar;
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[]{pVar.mAppId}));
            final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) ((CoverViewContainer) view).w(AppBrandLivePusherView.class);
            final p.f anonymousClass1 = new p.f() {
                public final void agq() {
                    j agL = appBrandLivePusherView.jok.agL();
                    x.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", Integer.valueOf(agL.errorCode), agL.joy);
                }
            };
            final d anonymousClass2 = new d() {
                public final void afQ() {
                    j cP = appBrandLivePusherView.jok.cP(false);
                    x.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", Integer.valueOf(cP.errorCode), cP.joy);
                }
            };
            final com.tencent.mm.plugin.appbrand.c.b anonymousClass3 = new com.tencent.mm.plugin.appbrand.c.b() {
                public final void a(com.tencent.mm.plugin.appbrand.c.c cVar) {
                    AppBrandLivePusherView appBrandLivePusherView = appBrandLivePusherView;
                    x.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", cVar);
                    if (cVar == com.tencent.mm.plugin.appbrand.c.c.BACK || cVar == com.tencent.mm.plugin.appbrand.c.c.CLOSE || cVar == com.tencent.mm.plugin.appbrand.c.c.LAUNCH_MINI_PROGRAM) {
                        appBrandLivePusherView.jok.cP(true);
                    }
                }

                public final void onResume() {
                    appBrandLivePusherView.jok.agL();
                }

                public final void onDestroy() {
                    com.tencent.mm.plugin.appbrand.c.b(pVar.mAppId, this);
                }
            };
            final p pVar2 = pVar;
            e anonymousClass4 = new e() {
                public final void onDestroy() {
                    appBrandLivePusherView.sX();
                    pVar2.b(anonymousClass1);
                    pVar2.b(anonymousClass2);
                    pVar2.b((e) this);
                    com.tencent.mm.plugin.appbrand.c.b(pVar2.mAppId, anonymousClass3);
                }
            };
            pVar.a(anonymousClass1);
            pVar.a(anonymousClass2);
            pVar.a(anonymousClass4);
            com.tencent.mm.plugin.appbrand.c.a(pVar.mAppId, anonymousClass3);
            appBrandLivePusherView.jol = new ITXLivePushListener() {
                public final void onPushEvent(int i, Bundle bundle) {
                    x.i("MicroMsg.JsApiInsertLivePusher", "onPushEvent errCode:%d", Integer.valueOf(i));
                    b bVar = new b();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("errMsg", bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
                        jSONObject.put("livePusherId", i);
                    } catch (JSONException e) {
                    }
                    f aA = bVar.aA(pVar.mAppId, pVar.hashCode());
                    aA.mData = jSONObject.toString();
                    aA.afI();
                }

                public final void onNetStatus(Bundle bundle) {
                    a aVar = new a();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("livePusherId", i);
                        JSONObject jSONObject2 = new JSONObject();
                        if (bundle != null) {
                            for (String str : bundle.keySet()) {
                                jSONObject2.put(str, bundle.get(str));
                            }
                        }
                        jSONObject.put("info", jSONObject2);
                    } catch (JSONException e) {
                    }
                    f aA = aVar.aA(pVar.mAppId, pVar.hashCode());
                    aA.mData = jSONObject.toString();
                    aA.afI();
                }
            };
            appBrandLivePusherView.jok.joQ = appBrandLivePusherView.jol;
            Bundle bundle = new Bundle();
            bundle.putString("pushUrl", jSONObject.optString("pushUrl"));
            bundle.putInt("mode", jSONObject.optInt("mode", 0));
            bundle.putBoolean("autopush", jSONObject.optBoolean("autopush", false));
            bundle.putBoolean("muted", jSONObject.optBoolean("muted", false));
            bundle.putBoolean("enableCamera", jSONObject.optBoolean("enableCamera", true));
            bundle.putInt("focusMode", jSONObject.optInt("focusMode", 0));
            bundle.putString("orientation", jSONObject.optString("orientation"));
            bundle.putInt("beauty", jSONObject.optInt("beauty", 0));
            bundle.putInt("whiteness", jSONObject.optInt("whiteness", 0));
            bundle.putString("audioQuality", jSONObject.optString("audioQuality", "high"));
            bundle.putInt("aspect", jSONObject.optInt("aspect", 0));
            bundle.putInt("minBitrate", jSONObject.optInt("minBitrate", 0));
            bundle.putInt("maxBitrate", jSONObject.optInt("maxBitrate", 0));
            bundle.putBoolean("backgroundMute", jSONObject.optBoolean("backgroundMute", false));
            bundle.putBoolean("needEvent", jSONObject.optBoolean("needEvent", false));
            bundle.putBoolean("debug", jSONObject.optBoolean("debug", false));
            x.i("MicroMsg.JsApiInsertLivePusher", "convertParams pushUrl:%s", jSONObject.optString("pushUrl"));
            m mVar = appBrandLivePusherView.jok;
            if (appBrandLivePusherView == null) {
                jVar = new j(-1, "invalid params");
            } else {
                m.c("InitLivePusher", bundle);
                mVar.joA = appBrandLivePusherView;
                mVar.joA.disableLog(false);
                mVar.joR = bundle.getString("pushUrl", "");
                mVar.c(bundle, true);
                if (!(!bundle.getBoolean("autopush", false) || mVar.joR == null || mVar.joR.isEmpty() || mVar.joP.isPushing())) {
                    x.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
                    mVar.joA.setVisibility(0);
                    if (mVar.joZ) {
                        mVar.joP.startCameraPreview(mVar.joA);
                    }
                    mVar.joP.startPusher(mVar.joR);
                }
                mVar.gOP = true;
                jVar = new j();
            }
            x.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", Integer.valueOf(jVar.errorCode), jVar.joy);
            a.a(jSONObject.optString("backgroundImage"), jSONObject.optString("backgroundMD5"), new com.tencent.mm.plugin.appbrand.jsapi.live.a.a() {
                public final void sL(String str) {
                    x.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath onDownload localPath:%s", str);
                    Bundle bundle = new Bundle();
                    bundle.putString("backgroundImage", str);
                    appBrandLivePusherView.u(bundle);
                }
            });
            return;
        }
        x.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
    }

    private void a(Activity activity, p pVar, JSONObject jSONObject, int i) {
        int i2 = this.jor;
        this.jor = i2 + 1;
        if (i2 > 5) {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
            return;
        }
        final Activity activity2 = activity;
        final p pVar2 = pVar;
        final JSONObject jSONObject2 = jSONObject;
        final int i3 = i;
        com.tencent.mm.plugin.appbrand.a.a(pVar.mAppId, new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                x.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", Integer.valueOf(i));
                if (i == 117) {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        x.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                        pVar2.E(i3, c.this.e("fail:system permission denied", null));
                        return;
                    }
                    ah.h(new Runnable() {
                        public final void run() {
                            c.this.a(activity2, pVar2, jSONObject2, i3);
                        }
                    }, 50);
                } else if (i != 118) {
                } else {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        x.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                        pVar2.E(i3, c.this.e("fail:system permission denied", null));
                        return;
                    }
                    ah.h(new Runnable() {
                        public final void run() {
                            c.this.a(activity2, pVar2, jSONObject2, i3);
                        }
                    }, 50);
                }
            }
        });
        if (!com.tencent.mm.pluginsdk.g.a.a(activity, "android.permission.CAMERA", 117, "", "")) {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
        } else if (com.tencent.mm.pluginsdk.g.a.a(activity, "android.permission.RECORD_AUDIO", 118, "", "")) {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
            super.a(pVar, jSONObject, i);
        } else {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
        }
    }
}
