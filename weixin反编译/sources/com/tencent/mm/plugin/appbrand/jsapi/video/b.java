package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import org.json.JSONObject;

public final class b extends c {
    private static final int CTRL_INDEX = 114;
    public static final String NAME = "operateVideoPlayer";

    protected final int j(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean c(com.tencent.mm.plugin.appbrand.page.p r9, int r10, android.view.View r11, org.json.JSONObject r12) {
        /*
        r8 = this;
        r1 = -1;
        r3 = 1;
        r2 = 0;
        r0 = "MicroMsg.JsApiOperateVideoPlayer";
        r4 = "onUpdateView : videoPlayerId=%d";
        r5 = new java.lang.Object[r3];
        r6 = java.lang.Integer.valueOf(r10);
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r5);
        r0 = r11 instanceof com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
        if (r0 != 0) goto L_0x002b;
    L_0x0018:
        r0 = "MicroMsg.JsApiOperateVideoPlayer";
        r1 = "the view(%s) is not a instance of CoverViewContainer";
        r3 = new java.lang.Object[r3];
        r4 = java.lang.Integer.valueOf(r10);
        r3[r2] = r4;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r3);
        r0 = r2;
    L_0x002a:
        return r0;
    L_0x002b:
        r11 = (com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer) r11;
        r0 = com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.class;
        r0 = r11.w(r0);
        r0 = (com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView) r0;
        if (r0 != 0) goto L_0x0042;
    L_0x0037:
        r0 = "MicroMsg.JsApiOperateVideoPlayer";
        r1 = "view not AppBrandVideoView";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r2;
        goto L_0x002a;
    L_0x0042:
        r4 = "type";
        r5 = r12.optString(r4);
        r4 = "MicroMsg.JsApiOperateVideoPlayer";
        r6 = "onUpdateView operateType=%s";
        r7 = new java.lang.Object[r3];
        r7[r2] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r4, r6, r7);
        r4 = r5.hashCode();
        switch(r4) {
            case -802181223: goto L_0x009c;
            case 1222225: goto L_0x00bd;
            case 3443508: goto L_0x0070;
            case 3526264: goto L_0x00b2;
            case 3540994: goto L_0x0086;
            case 106440182: goto L_0x007b;
            case 458133450: goto L_0x0091;
            case 1355420059: goto L_0x00a7;
            default: goto L_0x005d;
        };
    L_0x005d:
        r4 = r1;
    L_0x005e:
        switch(r4) {
            case 0: goto L_0x00c8;
            case 1: goto L_0x00ce;
            case 2: goto L_0x00d2;
            case 3: goto L_0x00d6;
            case 4: goto L_0x00f7;
            case 5: goto L_0x00fb;
            case 6: goto L_0x014f;
            case 7: goto L_0x0189;
            default: goto L_0x0061;
        };
    L_0x0061:
        r0 = "MicroMsg.JsApiOperateVideoPlayer";
        r1 = "onUpdateView operateType not supported: %s";
        r3 = new java.lang.Object[r3];
        r3[r2] = r5;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r3);
        r0 = r2;
        goto L_0x002a;
    L_0x0070:
        r4 = "play";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x005d;
    L_0x0079:
        r4 = r2;
        goto L_0x005e;
    L_0x007b:
        r4 = "pause";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x005d;
    L_0x0084:
        r4 = r3;
        goto L_0x005e;
    L_0x0086:
        r4 = "stop";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x005d;
    L_0x008f:
        r4 = 2;
        goto L_0x005e;
    L_0x0091:
        r4 = "requestFullScreen";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x005d;
    L_0x009a:
        r4 = 3;
        goto L_0x005e;
    L_0x009c:
        r4 = "exitFullScreen";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x005d;
    L_0x00a5:
        r4 = 4;
        goto L_0x005e;
    L_0x00a7:
        r4 = "playbackRate";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x005d;
    L_0x00b0:
        r4 = 5;
        goto L_0x005e;
    L_0x00b2:
        r4 = "seek";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x005d;
    L_0x00bb:
        r4 = 6;
        goto L_0x005e;
    L_0x00bd:
        r4 = "sendDanmu";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x005d;
    L_0x00c6:
        r4 = 7;
        goto L_0x005e;
    L_0x00c8:
        r0.start();
    L_0x00cb:
        r0 = r3;
        goto L_0x002a;
    L_0x00ce:
        r0.pause();
        goto L_0x00cb;
    L_0x00d2:
        r0.stop();
        goto L_0x00cb;
    L_0x00d6:
        r4 = "data";
        r4 = r12.optJSONArray(r4);
        if (r4 == 0) goto L_0x00e5;
    L_0x00df:
        r5 = r4.length();
        if (r5 != 0) goto L_0x00f2;
    L_0x00e5:
        r2 = "MicroMsg.JsApiOperateVideoPlayer";
        r4 = "onUpdateView directionArr nil";
        com.tencent.mm.sdk.platformtools.x.w(r2, r4);
    L_0x00ee:
        r0.f(r3, r1);
        goto L_0x00cb;
    L_0x00f2:
        r1 = r4.optInt(r2, r1);
        goto L_0x00ee;
    L_0x00f7:
        r0.f(r2, r1);
        goto L_0x00cb;
    L_0x00fb:
        r1 = "data";
        r1 = r12.optJSONArray(r1);
        if (r1 == 0) goto L_0x010a;
    L_0x0104:
        r4 = r1.length();
        if (r4 != 0) goto L_0x0116;
    L_0x010a:
        r0 = "MicroMsg.JsApiOperateVideoPlayer";
        r1 = "onUpdateView dataArr nil";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = r2;
        goto L_0x002a;
    L_0x0116:
        r4 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r4 = r1.optDouble(r2, r4);
        r6 = 0;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 >= 0) goto L_0x0136;
    L_0x0122:
        r0 = "MicroMsg.JsApiOperateVideoPlayer";
        r1 = "rate invalid %f";
        r3 = new java.lang.Object[r3];
        r4 = java.lang.Double.valueOf(r4);
        r3[r2] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);
        r0 = r2;
        goto L_0x002a;
    L_0x0136:
        r1 = (float) r4;
        r4 = "MicroMsg.AppBrandVideoView";
        r5 = "setPlaybackRate %s";
        r6 = new java.lang.Object[r3];
        r7 = java.lang.Float.valueOf(r1);
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r0 = r0.jvA;
        r0.aa(r1);
        goto L_0x00cb;
    L_0x014f:
        r4 = "data";
        r4 = r12.optJSONArray(r4);
        if (r4 == 0) goto L_0x015e;
    L_0x0158:
        r5 = r4.length();
        if (r5 != 0) goto L_0x016a;
    L_0x015e:
        r0 = "MicroMsg.JsApiOperateVideoPlayer";
        r1 = "onUpdateView dataArr nil";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = r2;
        goto L_0x002a;
    L_0x016a:
        r1 = r4.optInt(r2, r1);
        if (r1 >= 0) goto L_0x0184;
    L_0x0170:
        r0 = "MicroMsg.JsApiOperateVideoPlayer";
        r4 = "pos invalid %d";
        r3 = new java.lang.Object[r3];
        r1 = java.lang.Integer.valueOf(r1);
        r3[r2] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r3);
        r0 = r2;
        goto L_0x002a;
    L_0x0184:
        r0.w(r1, r2);
        goto L_0x00cb;
    L_0x0189:
        r1 = "data";
        r1 = r12.optJSONArray(r1);
        if (r1 == 0) goto L_0x0198;
    L_0x0192:
        r4 = r1.length();
        if (r4 != 0) goto L_0x01a4;
    L_0x0198:
        r0 = "MicroMsg.JsApiOperateVideoPlayer";
        r1 = "onUpdateView dataArr nil";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = r2;
        goto L_0x002a;
    L_0x01a4:
        r4 = r1.length();
        if (r4 != r3) goto L_0x01b9;
    L_0x01aa:
        r4 = "";
        r1 = r1.optString(r2, r4);
        r2 = "";
        r0.bm(r1, r2);
        goto L_0x00cb;
    L_0x01b9:
        r4 = "";
        r2 = r1.optString(r2, r4);
        r4 = "";
        r1 = r1.optString(r3, r4);
        r0.bm(r2, r1);
        goto L_0x00cb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.b.c(com.tencent.mm.plugin.appbrand.page.p, int, android.view.View, org.json.JSONObject):boolean");
    }
}
