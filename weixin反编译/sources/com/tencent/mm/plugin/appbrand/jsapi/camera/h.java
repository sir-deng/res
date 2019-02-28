package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class h extends a {
    private static final int CTRL_INDEX = 332;
    public static final String NAME = "operateCamera";

    public final void a(final j jVar, final JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null or nil", null));
        } else {
            ah.y(new Runnable() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    r11 = this;
                    r6 = 0;
                    r3 = -1;
                    r4 = 2;
                    r2 = 0;
                    r1 = 1;
                    r0 = r4;
                    r5 = "cameraId";
                    r0 = r0.optInt(r5);
                    r5 = r4;
                    r7 = "type";
                    r7 = r5.optString(r7);
                    r5 = "MicroMsg.JsApiOperateCamera";
                    r8 = "cameraId=%d type=%s";
                    r9 = new java.lang.Object[r4];
                    r10 = java.lang.Integer.valueOf(r0);
                    r9[r2] = r10;
                    r9[r1] = r7;
                    com.tencent.mm.sdk.platformtools.x.i(r5, r8, r9);
                    r5 = com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.jlq;
                    r0 = java.lang.Integer.valueOf(r0);
                    r8 = r5.jlp;
                    r8 = r8.containsKey(r0);
                    if (r8 == 0) goto L_0x0056;
                L_0x003a:
                    r5 = r5.jlp;
                    r0 = r5.get(r0);
                    r0 = (com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView) r0;
                    r5 = r0;
                L_0x0043:
                    if (r5 != 0) goto L_0x0058;
                L_0x0045:
                    r0 = r3;
                    r1 = r5;
                    r2 = com.tencent.mm.plugin.appbrand.jsapi.camera.h.this;
                    r3 = "fail:no such camera";
                    r2 = r2.e(r3, r6);
                    r0.E(r1, r2);
                L_0x0055:
                    return;
                L_0x0056:
                    r5 = r6;
                    goto L_0x0043;
                L_0x0058:
                    r0 = new com.tencent.mm.plugin.appbrand.jsapi.camera.h$1$1;
                    r0.<init>();
                    r5.jlC = r0;
                    r0 = r7.hashCode();
                    switch(r0) {
                        case -1909077165: goto L_0x0093;
                        case -1391995149: goto L_0x009e;
                        case 1484838379: goto L_0x0088;
                        default: goto L_0x0066;
                    };
                L_0x0066:
                    r0 = r3;
                L_0x0067:
                    switch(r0) {
                        case 0: goto L_0x00a9;
                        case 1: goto L_0x0120;
                        case 2: goto L_0x0196;
                        default: goto L_0x006a;
                    };
                L_0x006a:
                    r0 = "MicroMsg.JsApiOperateCamera";
                    r3 = "operateType not supported: %s";
                    r1 = new java.lang.Object[r1];
                    r1[r2] = r7;
                    com.tencent.mm.sdk.platformtools.x.w(r0, r3, r1);
                    r0 = r3;
                    r1 = r5;
                    r2 = com.tencent.mm.plugin.appbrand.jsapi.camera.h.this;
                    r3 = "fail:operateType not supported";
                    r2 = r2.e(r3, r6);
                    r0.E(r1, r2);
                    goto L_0x0055;
                L_0x0088:
                    r0 = "takePhoto";
                    r0 = r7.equals(r0);
                    if (r0 == 0) goto L_0x0066;
                L_0x0091:
                    r0 = r2;
                    goto L_0x0067;
                L_0x0093:
                    r0 = "startRecord";
                    r0 = r7.equals(r0);
                    if (r0 == 0) goto L_0x0066;
                L_0x009c:
                    r0 = r1;
                    goto L_0x0067;
                L_0x009e:
                    r0 = "stopRecord";
                    r0 = r7.equals(r0);
                    if (r0 == 0) goto L_0x0066;
                L_0x00a7:
                    r0 = r4;
                    goto L_0x0067;
                L_0x00a9:
                    r0 = r4;
                    r2 = "quality";
                    r3 = "high";
                    r0 = r0.optString(r2, r3);
                    r2 = r5.jlv;
                    r2 = com.tencent.mm.sdk.platformtools.bi.fA(r2, r0);
                    if (r2 != 0) goto L_0x00bf;
                L_0x00bd:
                    r5.jlv = r0;
                L_0x00bf:
                    r0 = "MicroMsg.AppBrandCameraView";
                    r2 = "takePicture.";
                    com.tencent.mm.sdk.platformtools.x.i(r0, r2);
                    r0 = r5.jlE;
                    if (r0 != 0) goto L_0x00d6;
                L_0x00cc:
                    r0 = "MicroMsg.AppBrandCameraView";
                    r1 = "recordView is null";
                    com.tencent.mm.sdk.platformtools.x.i(r0, r1);
                    goto L_0x0055;
                L_0x00d6:
                    r0 = r5.jlI;
                    if (r0 != r4) goto L_0x00e5;
                L_0x00da:
                    r0 = "MicroMsg.AppBrandCameraView";
                    r1 = "takePicture is recording!!";
                    com.tencent.mm.sdk.platformtools.x.w(r0, r1);
                    goto L_0x0055;
                L_0x00e5:
                    r0 = r5.jlJ;
                    if (r0 != 0) goto L_0x00f5;
                L_0x00e9:
                    r2 = r5.jlK;
                    r2 = com.tencent.mm.sdk.platformtools.bi.bB(r2);
                    r6 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
                    r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r0 >= 0) goto L_0x0100;
                L_0x00f5:
                    r0 = "MicroMsg.AppBrandCameraView";
                    r1 = "not the right time to take picture.";
                    com.tencent.mm.sdk.platformtools.x.i(r0, r1);
                    goto L_0x0055;
                L_0x0100:
                    r2 = com.tencent.mm.sdk.platformtools.bi.Wz();
                    r5.jlK = r2;
                    r5.jlJ = r1;
                    r0 = 3;
                    r5.jlI = r0;
                    r0 = r5.jlE;
                    r1 = new com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$1;
                    r1.<init>();
                    r2 = "on";
                    r3 = r5.jlu;
                    r2 = r2.equals(r3);
                    r0.a(r1, r2);
                    goto L_0x0055;
                L_0x0120:
                    r0 = "MicroMsg.AppBrandCameraView";
                    r6 = "startRecord.";
                    com.tencent.mm.sdk.platformtools.x.i(r0, r6);
                    r0 = com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.jlq;
                    r6 = r0.jln;
                    if (r6 == 0) goto L_0x0135;
                L_0x0131:
                    r6 = r0.jlo;
                    if (r6 != 0) goto L_0x013e;
                L_0x0135:
                    r6 = "MicroMsg.AppBrandCameraMrg";
                    r7 = "no all permission";
                    com.tencent.mm.sdk.platformtools.x.i(r6, r7);
                L_0x013e:
                    r6 = r0.jln;
                    if (r6 == 0) goto L_0x0165;
                L_0x0142:
                    r0 = r0.jlo;
                    if (r0 == 0) goto L_0x0165;
                L_0x0146:
                    r0 = r1;
                L_0x0147:
                    if (r0 != 0) goto L_0x0167;
                L_0x0149:
                    r0 = r5.mContext;
                    r2 = com.tencent.mm.plugin.appbrand.q.j.iEt;
                    r0 = android.widget.Toast.makeText(r0, r2, r1);
                    r0.show();
                    r0 = "MicroMsg.AppBrandCameraView";
                    r1 = "no micro phone permission";
                    com.tencent.mm.sdk.platformtools.x.w(r0, r1);
                    r0 = "permission";
                    r5.I(r3, r0);
                    goto L_0x0055;
                L_0x0165:
                    r0 = r2;
                    goto L_0x0147;
                L_0x0167:
                    r0 = r5.jlI;
                    if (r0 != r4) goto L_0x017c;
                L_0x016b:
                    r0 = "MicroMsg.AppBrandCameraView";
                    r1 = "startRecord is recording!!";
                    com.tencent.mm.sdk.platformtools.x.w(r0, r1);
                    r0 = "is recording";
                    r5.I(r3, r0);
                    goto L_0x0055;
                L_0x017c:
                    r0 = com.tencent.mm.sdk.platformtools.bi.Wz();
                    r5.jlL = r0;
                    r0 = r5.jlE;
                    r0 = r0.owD;
                    r0.vs();
                    r5.jlI = r4;
                    r0 = "";
                    r5.I(r2, r0);
                    r5.agv();
                    goto L_0x0055;
                L_0x0196:
                    r6 = r5.jlL;
                    r6 = com.tencent.mm.sdk.platformtools.bi.bB(r6);
                    r8 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
                    r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
                    if (r0 >= 0) goto L_0x01c3;
                L_0x01a2:
                    r0 = "MicroMsg.AppBrandCameraView";
                    r3 = "stopRecord in %d ms later";
                    r1 = new java.lang.Object[r1];
                    r8 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
                    r8 = r8 - r6;
                    r4 = java.lang.Long.valueOf(r8);
                    r1[r2] = r4;
                    com.tencent.mm.sdk.platformtools.x.i(r0, r3, r1);
                    r0 = new com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$4;
                    r0.<init>();
                    r2 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
                    r2 = r2 - r6;
                    com.tencent.mm.sdk.platformtools.ah.h(r0, r2);
                    goto L_0x0055;
                L_0x01c3:
                    r5.uF();
                    goto L_0x0055;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.camera.h.1.run():void");
                }
            });
        }
    }
}
