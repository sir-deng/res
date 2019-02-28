package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_BYTE = 104;
    public static final String NAME = "chooseImage";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiChooseImage", "invoke");
        final Context aPO = dVar.aPO();
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiChooseImage", "data is null");
            dVar.E(i, a.e("chooseImage:fail_invalid_data", null));
            return;
        }
        int i2;
        Serializable valueOf;
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        int i3 = 0;
        if (optJSONArray != null) {
            x.i("MicroMsg.GameJsApiChooseImage", "sourceType = " + optJSONArray.toString());
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (optJSONArray.optString(i2).equals(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                    i3 |= 1;
                } else if (optJSONArray.optString(i2).equals("camera")) {
                    i3 |= 2;
                }
            }
        }
        i2 = i3;
        if (i2 == 0) {
            i2 = 3;
        }
        x.i("MicroMsg.GameJsApiChooseImage", "real scene = %d", Integer.valueOf(i2));
        if (i2 == 2 || i2 == 3) {
            x.d("MicroMsg.GameJsApiChooseImage", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(aPO, "android.permission.CAMERA", 113, "", "")));
            if (!com.tencent.mm.pluginsdk.g.a.a(aPO, "android.permission.CAMERA", 113, "", "")) {
                dVar.E(i, a.e("chooseImage:fail_android_permission_denied", null));
                return;
            }
        }
        int optInt = jSONObject.optInt("count", 0);
        Boolean valueOf2 = Boolean.valueOf(false);
        Boolean valueOf3 = Boolean.valueOf(false);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sizeType");
        if (optJSONArray2 != null) {
            for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                if (optJSONArray2.optString(i3).equals("original")) {
                    valueOf2 = Boolean.valueOf(true);
                } else if (optJSONArray2.optString(i3).equals("compressed")) {
                    valueOf3 = Boolean.valueOf(true);
                }
            }
        }
        Object valueOf4;
        if (valueOf2.booleanValue() && !valueOf3.booleanValue()) {
            i3 = 7;
            valueOf4 = Boolean.valueOf(true);
        } else if (valueOf2.booleanValue() || !valueOf3.booleanValue()) {
            i3 = 8;
            valueOf4 = Boolean.valueOf(false);
        } else {
            i3 = 7;
            valueOf4 = Boolean.valueOf(false);
        }
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i2);
        intent.putExtra("key_pick_local_pic_count", optInt);
        intent.putExtra("key_pick_local_pic_query_source_type", i3);
        intent.putExtra("key_pick_local_pic_send_raw", valueOf4);
        intent.putExtra("query_media_type", 1);
        x.i("MicroMsg.GameJsApiChooseImage", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", Integer.valueOf(i2), Integer.valueOf(optInt), Integer.valueOf(i3), valueOf4);
        aPO.jCj = new MMActivity.a() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void b(int r9, int r10, android.content.Intent r11) {
                /*
                r8 = this;
                r2 = 0;
                r7 = 1;
                r1 = 0;
                r0 = 14;
                if (r9 != r0) goto L_0x0048;
            L_0x0007:
                if (r11 != 0) goto L_0x0049;
            L_0x0009:
                r0 = r1;
            L_0x000a:
                r3 = "MicroMsg.GameJsApiChooseImage";
                r4 = "request to open file chooser, result code = %d, hasShowMemoryWarning = %b";
                r5 = 2;
                r5 = new java.lang.Object[r5];
                r6 = java.lang.Integer.valueOf(r10);
                r5[r1] = r6;
                r6 = java.lang.Boolean.valueOf(r0);
                r5[r7] = r6;
                com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
                r3 = new java.util.HashMap;
                r3.<init>();
                if (r0 == 0) goto L_0x0033;
            L_0x0029:
                r0 = "memoryWarning";
                r4 = java.lang.Boolean.valueOf(r7);
                r3.put(r0, r4);
            L_0x0033:
                switch(r10) {
                    case -1: goto L_0x0051;
                    case 0: goto L_0x0093;
                    default: goto L_0x0036;
                };
            L_0x0036:
                r0 = r11;
                r1 = r13;
                r4 = "chooseImage:fail";
                r3 = com.tencent.mm.plugin.game.gamewebview.jsapi.a.e(r4, r3);
                r0.E(r1, r3);
            L_0x0044:
                r0 = r0;
                r0.jCj = r2;
            L_0x0048:
                return;
            L_0x0049:
                r0 = "key_pick_local_media_show_memory_warning";
                r0 = r11.getBooleanExtra(r0, r1);
                goto L_0x000a;
            L_0x0051:
                if (r11 == 0) goto L_0x0091;
            L_0x0053:
                r0 = "key_pick_local_pic_callback_local_ids";
                r0 = r11.getStringExtra(r0);
            L_0x005a:
                r4 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
                if (r4 != 0) goto L_0x0036;
            L_0x0060:
                r4 = "MicroMsg.GameJsApiChooseImage";
                r5 = "localIds = %s";
                r6 = new java.lang.Object[r7];
                r6[r1] = r0;
                com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
                r1 = "localIds";
                r3.put(r1, r0);
                r0 = "key_pick_local_pic_source_type";
                r0 = r11.getStringExtra(r0);
                if (r0 == 0) goto L_0x0082;
            L_0x007c:
                r1 = "sourceType";
                r3.put(r1, r0);
            L_0x0082:
                r0 = r11;
                r1 = r13;
                r4 = "chooseImage:ok";
                r3 = com.tencent.mm.plugin.game.gamewebview.jsapi.a.e(r4, r3);
                r0.E(r1, r3);
                goto L_0x0044;
            L_0x0091:
                r0 = r2;
                goto L_0x005a;
            L_0x0093:
                r0 = r11;
                r1 = r13;
                r4 = "chooseImage:cancel";
                r3 = com.tencent.mm.plugin.game.gamewebview.jsapi.a.e(r4, r3);
                r0.E(r1, r3);
                goto L_0x0044;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.gamewebview.jsapi.biz.h.1.b(int, int, android.content.Intent):void");
            }
        };
        com.tencent.mm.bl.d.a(aPO, "webview", ".ui.tools.OpenFileChooserUI", intent, 14, false);
    }
}
