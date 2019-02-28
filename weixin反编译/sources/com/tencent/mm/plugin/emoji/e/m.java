package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    public static void a(Context context, sx sxVar, int i, int i2, int i3, String str, int i4) {
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        if (sxVar != null) {
            intent.putExtra("extra_id", sxVar.vPI);
            intent.putExtra("extra_name", sxVar.whv);
            intent.putExtra("extra_copyright", sxVar.whF);
            intent.putExtra("extra_coverurl", sxVar.whD);
            intent.putExtra("extra_description", sxVar.whw);
            intent.putExtra("extra_price", sxVar.why);
            intent.putExtra("extra_type", sxVar.whz);
            intent.putExtra("extra_flag", sxVar.whA);
            intent.putExtra("preceding_scence", i4);
            intent.putExtra("call_by", 1);
            intent.putExtra("check_clickflag", false);
            intent.putExtra("download_entrance_scene", i);
            if (i2 != -1) {
                intent.putExtra("extra_status", i2);
            }
            if (i3 != -1) {
                intent.putExtra("extra_progress", -1);
            }
            if (!bi.oN(str)) {
                intent.putExtra("to_talker_name", str);
            }
        } else {
            x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
        }
        context.startActivity(intent);
    }

    private static void a(Context context, so soVar, int i, int i2) {
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", soVar.vPI);
        intent.putExtra("extra_name", soVar.fpg);
        intent.putExtra("extra_description", soVar.nkL);
        intent.putExtra("preceding_scence", i2);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", i);
        intent.putExtra("check_clickflag", true);
        context.startActivity(intent);
    }

    public static void a(Context context, so soVar, boolean z) {
        if (soVar == null) {
            x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
            return;
        }
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        Intent intent;
        switch (soVar.who) {
            case 0:
                x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
                g.pWK.h(13223, Integer.valueOf(1), Integer.valueOf(soVar.fgJ), soVar.fpg, Integer.valueOf(0), Integer.valueOf(0));
                return;
            case 1:
                if (z) {
                    a(context, soVar, 15, 8);
                } else {
                    a(context, soVar, 3, 5);
                }
                g.pWK.h(13223, Integer.valueOf(1), Integer.valueOf(soVar.fgJ), soVar.fpg, Integer.valueOf(0), Integer.valueOf(4));
                return;
            case 2:
                String str5 = soVar.whm;
                str = soVar.fpg;
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str5);
                intent2.putExtra("title", str);
                b.ihN.j(intent2, context);
                g.pWK.h(13223, Integer.valueOf(1), Integer.valueOf(soVar.fgJ), soVar.fpg, Integer.valueOf(0), Integer.valueOf(3));
                return;
            case 3:
                i = soVar.fgJ;
                str = soVar.fpg;
                str2 = soVar.nkL;
                str3 = soVar.nlA;
                str4 = soVar.whn;
                intent = new Intent();
                intent.setClass(context, EmojiStoreTopicUI.class);
                intent.putExtra("topic_id", i);
                intent.putExtra("topic_name", str);
                intent.putExtra("topic_ad_url", str4);
                intent.putExtra("topic_icon_url", str3);
                intent.putExtra("topic_desc", str2);
                if (z) {
                    intent.putExtra("extra_scence", 15);
                } else {
                    intent.putExtra("extra_scence", 3);
                }
                context.startActivity(intent);
                g.pWK.h(13223, Integer.valueOf(1), Integer.valueOf(soVar.fgJ), soVar.fpg, Integer.valueOf(0), Integer.valueOf(2));
                return;
            case 4:
                i = soVar.fgJ;
                str = soVar.fpg;
                str2 = soVar.nkL;
                str3 = soVar.nlA;
                str4 = soVar.whn;
                intent = new Intent();
                intent.putExtra("set_id", i);
                intent.putExtra("headurl", str4);
                intent.putExtra("set_title", str);
                intent.putExtra("set_iconURL", str3);
                intent.putExtra("set_desc", str2);
                intent.setClass(context, EmojiStoreV2SingleProductUI.class);
                context.startActivity(intent);
                g.pWK.h(13223, Integer.valueOf(1), Integer.valueOf(soVar.fgJ), soVar.fpg, Integer.valueOf(0), Integer.valueOf(1));
                return;
            default:
                x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", Integer.valueOf(soVar.who));
                return;
        }
    }
}
