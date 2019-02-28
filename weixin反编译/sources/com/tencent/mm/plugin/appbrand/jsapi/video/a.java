package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 6;
    public static final String NAME = "insertVideoPlayer";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        return new CoverViewContainer(context, new AppBrandVideoView(context));
    }

    protected final int j(JSONObject jSONObject) {
        return jSONObject.getInt("videoPlayerId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", Integer.valueOf(i));
        final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).w(AppBrandVideoView.class);
        final y anonymousClass1 = new y() {
            public final void agJ() {
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                x.i("MicroMsg.AppBrandVideoView", "onExitFullScreen");
                if (appBrandVideoView.jvD.jwp) {
                    appBrandVideoView.jvD.agI();
                }
                appBrandVideoView.db(false);
            }
        };
        final f anonymousClass2 = new f() {
            public final void agq() {
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                x.i("MicroMsg.AppBrandVideoView", "onUIResume");
                appBrandVideoView.jvA.TL();
            }
        };
        final d anonymousClass3 = new d() {
            public final void afQ() {
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                x.i("MicroMsg.AppBrandVideoView", "onUIPause");
                appBrandVideoView.jvA.TK();
            }
        };
        final p pVar2 = pVar;
        e anonymousClass4 = new e() {
            public final void onDestroy() {
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                x.i("MicroMsg.AppBrandVideoView", "onUIDestroy");
                appBrandVideoView.clean();
                pVar2.b(anonymousClass2);
                pVar2.b(anonymousClass3);
                pVar2.b((e) this);
            }
        };
        pVar.a(anonymousClass2);
        pVar.a(anonymousClass3);
        pVar.a(anonymousClass4);
        final p pVar3 = pVar;
        final int i2 = i;
        appBrandVideoView.jvS = new com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a() {
            public final void kC(int i) {
                pVar3.aeW().a(i2, anonymousClass1, i);
            }

            public final void agI() {
                pVar3.aeW().lJ(i2);
            }

            public final boolean isFullScreen() {
                return pVar3.aeW().lI(i2);
            }
        };
        appBrandVideoView.setMute(jSONObject.optBoolean("muted", false));
        boolean optBoolean = jSONObject.optBoolean("needEvent", false);
        JSONObject jSONObject2 = jSONObject;
        x.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", Boolean.valueOf(jSONObject2.optBoolean("autoplay", false)), Boolean.valueOf(optBoolean));
        boolean optBoolean2 = jSONObject.optBoolean("showDanmuBtn", true);
        boolean optBoolean3 = jSONObject.optBoolean("enableDanmu", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("danmuList");
        String optString = jSONObject.optString("objectFit");
        String optString2 = jSONObject.optString("poster");
        boolean optBoolean4 = jSONObject.optBoolean("showBasicControls", true);
        String optString3 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        int optInt = jSONObject.optInt(TencentLocation.EXTRA_DIRECTION, 90);
        boolean optBoolean5 = jSONObject.optBoolean("loop", false);
        boolean optBoolean6 = jSONObject.optBoolean("pageGesture", false);
        int optInt2 = jSONObject.optInt("initialTime", 0);
        boolean optBoolean7 = jSONObject.optBoolean("showLiveBtn", true);
        boolean optBoolean8 = jSONObject.optBoolean("showProgress", true);
        boolean optBoolean9 = jSONObject.optBoolean("showFullScreenBtn", true);
        boolean optBoolean10 = jSONObject.optBoolean("showPlayBtn", true);
        boolean optBoolean11 = jSONObject.optBoolean("showCenterPlayBtn", true);
        boolean optBoolean12 = jSONObject.optBoolean("enableProgressGesture", true);
        x.i("MicroMsg.AppBrandVideoView", "setAppId appid=%s", pVar.mAppId);
        appBrandVideoView.mAppId = r22;
        x.i("MicroMsg.AppBrandVideoView", "setIsGame game=%s", Boolean.valueOf(pVar.iuk.YI()));
        appBrandVideoView.jvX = r22;
        appBrandVideoView.jvM = optString3;
        appBrandVideoView.cS(optBoolean4);
        appBrandVideoView.tj(optString2);
        appBrandVideoView.kG(optInt);
        appBrandVideoView.tk(optString);
        appBrandVideoView.cR(optBoolean5);
        appBrandVideoView.da(optBoolean6);
        try {
            appBrandVideoView.jvN = j(jSONObject);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", e);
        }
        appBrandVideoView.cZ(optBoolean2);
        x.i("MicroMsg.AppBrandVideoView", "setDanmakuEnable isEnable=%b", Boolean.valueOf(optBoolean3));
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = appBrandVideoView.jvD;
        appBrandVideoViewControlBar.jwq = optBoolean3;
        appBrandVideoViewControlBar.ahp();
        appBrandVideoView.h(optJSONArray);
        appBrandVideoView.kH(optInt2);
        appBrandVideoView.cT(optBoolean7);
        appBrandVideoView.cU(optBoolean8);
        appBrandVideoView.cV(optBoolean9);
        appBrandVideoView.cW(optBoolean10);
        appBrandVideoView.cY(optBoolean11);
        appBrandVideoView.cX(optBoolean12);
        if (optBoolean) {
            appBrandVideoView.jvP = new e(appBrandVideoView, pVar);
        }
        int optInt3 = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, -1);
        x.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", jSONObject.optString(DownloadInfoColumns.FILEPATH), Boolean.valueOf(jSONObject.optBoolean("live", false)));
        appBrandVideoView.e(r4, optBoolean2, optInt3);
    }
}
