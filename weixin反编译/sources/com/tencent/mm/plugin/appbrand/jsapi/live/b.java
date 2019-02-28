package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveConstants;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 364;
    public static final String NAME = "insertLivePlayer";

    private static final class b extends f {
        private static final int CTRL_INDEX = 412;
        private static final String NAME = "onLivePlayerNetStatus";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static final class c extends f {
        private static final int CTRL_INDEX = 369;
        private static final String NAME = "onLivePlayerEvent";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private static final class a extends f {
        private static final int CTRL_INDEX = 371;
        private static final String NAME = "onLivePlayerFullScreenChange";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        k.agK();
        if (jSONObject.optInt("mode", 0) != 2) {
            super.a(pVar, jSONObject, i);
        } else if (pVar.mContext instanceof Activity) {
            try {
                if (android.support.v4.content.a.b((Activity) pVar.mContext, "android.permission.RECORD_AUDIO") == 0) {
                    super.a(pVar, jSONObject, i);
                    return;
                }
                Map hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10001));
                pVar.E(i, e("fail:system permission denied", hashMap));
            } catch (Exception e) {
                x.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", e);
                pVar.E(i, e("fail", null));
            }
        } else {
            x.w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
            pVar.E(i, e("fail", null));
        }
    }

    protected final int j(JSONObject jSONObject) {
        return jSONObject.getInt("livePlayerId");
    }

    protected final View a(p pVar, JSONObject jSONObject) {
        return new CoverViewContainer(pVar.mContext, new AppBrandLivePlayerView(pVar.mContext));
    }

    protected final void a(final p pVar, final int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            j jVar;
            final AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) ((CoverViewContainer) view).w(AppBrandLivePlayerView.class);
            final y anonymousClass1 = new y() {
                public final void agJ() {
                    AppBrandLivePlayerView appBrandLivePlayerView = appBrandLivePlayerView;
                    x.i("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
                    appBrandLivePlayerView.cO(false);
                }
            };
            final p.f anonymousClass2 = new p.f() {
                public final void agq() {
                    l lVar = appBrandLivePlayerView.jof;
                    j sN = (lVar.joG && lVar.joM) ? lVar.sN("resume") : new j();
                    x.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", Integer.valueOf(sN.errorCode), sN.joy);
                }
            };
            final d anonymousClass3 = new d() {
                public final void afQ() {
                    j sN;
                    l lVar = appBrandLivePlayerView.jof;
                    lVar.joG = lVar.joC.isPlaying();
                    if (lVar.joG && lVar.joM) {
                        if (lVar.joj && lVar.joD != null) {
                            lVar.joD.onPlayEvent(6000, new Bundle());
                        }
                        sN = lVar.sN("pause");
                    } else {
                        sN = new j();
                    }
                    x.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", Integer.valueOf(sN.errorCode), sN.joy);
                }
            };
            final p pVar2 = pVar;
            e anonymousClass4 = new e() {
                public final void onDestroy() {
                    appBrandLivePlayerView.sX();
                    pVar2.b(anonymousClass2);
                    pVar2.b(anonymousClass3);
                    pVar2.b((e) this);
                }
            };
            pVar.a(anonymousClass2);
            pVar.a(anonymousClass3);
            pVar.a(anonymousClass4);
            appBrandLivePlayerView.jog = new com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.a() {
                public final void kC(int i) {
                    pVar.aeW().a(i, anonymousClass1, i);
                }

                public final void agI() {
                    pVar.aeW().lJ(i);
                }

                public final boolean isFullScreen() {
                    return pVar.aeW().lI(i);
                }
            };
            appBrandLivePlayerView.joj = jSONObject.optBoolean("needEvent", false);
            appBrandLivePlayerView.joh = new com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.b() {
                public final void e(boolean z, int i) {
                    a aVar = new a();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("fullScreen", z);
                        jSONObject.put(TencentLocation.EXTRA_DIRECTION, i);
                        jSONObject.put("livePlayerId", i);
                    } catch (JSONException e) {
                    }
                    f aA = aVar.aA(pVar.mAppId, pVar.hashCode());
                    aA.mData = jSONObject.toString();
                    aA.afI();
                }
            };
            Bundle bundle = new Bundle();
            bundle.putString("playUrl", jSONObject.optString("playUrl"));
            bundle.putInt("mode", jSONObject.optInt("mode", 0));
            bundle.putBoolean("autoplay", jSONObject.optBoolean("autoplay", false));
            bundle.putBoolean("muted", jSONObject.optBoolean("muted", false));
            bundle.putString("orientation", jSONObject.optString("orientation"));
            bundle.putString("objectFit", jSONObject.optString("objectFit"));
            bundle.putBoolean("backgroundMute", jSONObject.optBoolean("backgroundMute", true));
            bundle.putFloat("minCache", BigDecimal.valueOf(jSONObject.optDouble("minCache", 1.0d)).floatValue());
            bundle.putFloat("maxCache", BigDecimal.valueOf(jSONObject.optDouble("maxCache", 3.0d)).floatValue());
            bundle.putBoolean("needEvent", jSONObject.optBoolean("needEvent", false));
            bundle.putBoolean("debug", jSONObject.optBoolean("debug", false));
            bundle.putString("soundMode", jSONObject.optString("soundMode", "speaker"));
            x.i("MicroMsg.JsApiInsertLivePlayer", "convertParams playUrl:%s", jSONObject.optString("playUrl"));
            l lVar = appBrandLivePlayerView.jof;
            if (appBrandLivePlayerView == null) {
                jVar = new j(-1, "invalid params");
            } else {
                l.c("initLivePlayer", bundle);
                lVar.joA = appBrandLivePlayerView;
                lVar.joA.disableLog(false);
                lVar.joC.setPlayerView(appBrandLivePlayerView);
                lVar.joE = bundle.getString("playUrl", lVar.joE);
                lVar.joF = lVar.v(bundle);
                lVar.w(bundle);
                lVar.mAutoPlay = bundle.getBoolean("autoplay", lVar.mAutoPlay);
                if (!(!lVar.mAutoPlay || lVar.joE == null || lVar.joE.isEmpty())) {
                    x.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
                    lVar.joC.startPlay(lVar.joE, lVar.joF);
                }
                lVar.gOP = true;
                jVar = new j();
            }
            x.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", Integer.valueOf(jVar.errorCode), jVar.joy);
            appBrandLivePlayerView.jof.joD = new ITXLivePlayListener() {
                public final void onPlayEvent(int i, Bundle bundle) {
                    x.i("MicroMsg.JsApiInsertLivePlayer", "onPlayEvent errCode:%d", Integer.valueOf(i));
                    c cVar = new c();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errCode", i);
                        jSONObject.put("errMsg", bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
                        jSONObject.put("livePlayerId", i);
                    } catch (JSONException e) {
                    }
                    f aA = cVar.aA(pVar.mAppId, pVar.hashCode());
                    aA.mData = jSONObject.toString();
                    aA.afI();
                }

                public final void onNetStatus(Bundle bundle) {
                    b bVar = new b();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("livePlayerId", i);
                        JSONObject jSONObject2 = new JSONObject();
                        if (bundle != null) {
                            for (String str : bundle.keySet()) {
                                jSONObject2.put(str, bundle.get(str));
                            }
                        }
                        jSONObject.put("info", jSONObject2);
                    } catch (JSONException e) {
                    }
                    f aA = bVar.aA(pVar.mAppId, pVar.hashCode());
                    aA.mData = jSONObject.toString();
                    aA.afI();
                }
            };
            return;
        }
        x.w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
    }
}
