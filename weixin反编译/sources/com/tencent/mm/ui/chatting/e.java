package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.q;

public final class e {

    public interface c {
        boolean a(String str, Context context, u uVar, String str2);
    }

    static final class a implements c {
        a() {
        }

        public final boolean a(String str, Context context, u uVar, String str2) {
            Intent intent;
            if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendnormalhbrequest")) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_type", 0);
                com.tencent.mm.bl.d.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent2);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendrandomhbrequest")) {
                intent = new Intent();
                intent.putExtra("key_type", 1);
                com.tencent.mm.bl.d.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendhblistrequest")) {
                intent = new Intent();
                intent.putExtra("key_type", 1);
                com.tencent.mm.bl.d.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startreceivehblistrequest")) {
                intent = new Intent();
                intent.putExtra("key_type", 2);
                com.tencent.mm.bl.d.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/openDetail")) {
                intent = new Intent();
                intent.putExtra("key_native_url", str);
                com.tencent.mm.bl.d.b(context, "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
                return true;
            } else if (!str.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                return false;
            } else {
                intent = new Intent();
                intent.putExtra("key_way", 5);
                intent.putExtra("key_native_url", str);
                intent.putExtra("key_static_from_scene", 1);
                com.tencent.mm.bl.d.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                return true;
            }
        }
    }

    static final class b implements c {
        b() {
        }

        public final boolean a(java.lang.String r4, android.content.Context r5, com.tencent.mm.ui.u r6, java.lang.String r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = 0;
            r1 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
            if (r1 == 0) goto L_0x0008;
        L_0x0007:
            return r0;
        L_0x0008:
            r1 = "weixin://openNativeUrl/myDeviceList";
            r1 = r4.startsWith(r1);
            if (r1 == 0) goto L_0x0027;
        L_0x0011:
            r0 = new android.content.Intent;
            r0.<init>();
            r1 = "device_brand_name";
            r0.putExtra(r1, r7);
            r1 = "exdevice";
            r2 = ".ui.ExdeviceManageDeviceUI";
            com.tencent.mm.bl.d.b(r5, r1, r2, r0);
            r0 = 1;
            goto L_0x0007;
        L_0x0027:
            r1 = "weixin://openNativeUrl/bindMyDevice";
            r1 = r4.startsWith(r1);
            if (r1 == 0) goto L_0x0007;
        L_0x0030:
            goto L_0x0007;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.e.b.a(java.lang.String, android.content.Context, com.tencent.mm.ui.u, java.lang.String):boolean");
        }
    }

    static final class d implements c {
        d() {
        }

        public final boolean a(String str, Context context, u uVar, String str2) {
            Intent intent;
            if (bi.oN(str)) {
                x.d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
                return false;
            } else if (str.startsWith("weixin://wesport/recommend") && uVar != null) {
                intent = new Intent(context, SelectConversationUI.class);
                intent.putExtra("Select_Talker_Name", str2);
                intent.putExtra("Select_block_List", str2);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("Select_Send_Card", true);
                uVar.startActivityForResult(intent, 224);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/rankMyHomepage")) {
                String FY = q.FY();
                if (bi.oN(FY)) {
                    x.e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
                    return false;
                }
                intent = new Intent();
                intent.putExtra("username", FY);
                com.tencent.mm.bl.d.b(context, "exdevice", ".ui.ExdeviceProfileUI", intent);
                x.i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
                return true;
            } else if (!str.startsWith("weixin://openNativeUrl/rankSetting")) {
                return false;
            } else {
                com.tencent.mm.bl.d.y(context, "exdevice", ".ui.ExdeviceSettingUI");
                return true;
            }
        }
    }

    public static boolean a(String str, Context context, u uVar, String str2) {
        if (bi.oN(str)) {
            return false;
        }
        c cVar = null;
        if (str.startsWith("weixin://openNativeUrl/weixinHB")) {
            cVar = new a();
        } else {
            boolean z;
            if (str == null || !(str.startsWith("weixin://openNativeUrl/myDeviceList") || str.startsWith("weixin://openNativeUrl/bindMyDevice"))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                cVar = new b();
            } else {
                if (str == null || !(str.startsWith("weixin://wesport/recommend") || str.startsWith("weixin://openNativeUrl/rankMyHomepage") || str.startsWith("weixin://openNativeUrl/rankSetting"))) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    cVar = new d();
                }
            }
        }
        if (cVar == null || !cVar.a(str, context, uVar, str2)) {
            return false;
        }
        return true;
    }
}
