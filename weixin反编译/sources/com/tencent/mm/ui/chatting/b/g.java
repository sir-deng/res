package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.mm.a.e;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;

public final class g {
    public static void a(p pVar, au auVar, Intent intent) {
        if (pVar != null && auVar != null) {
            String str;
            int i;
            Bundle bundle;
            String csn = pVar.csn();
            String str2 = pVar.csW().field_username;
            if (pVar.csS() || pVar.csT()) {
                if (pVar.csS()) {
                    String hS = bb.hS(auVar.field_content);
                    if (str2 == null || hS == null || hS.length() <= 0) {
                        hS = str2;
                    }
                    str2 = hS;
                } else if (auVar != null) {
                    str2 = auVar.field_bizChatUserId;
                }
            }
            Bundle bundle2 = new Bundle();
            if (pVar.csS()) {
                str = "stat_scene";
                i = 2;
                bundle = bundle2;
            } else {
                str = "stat_scene";
                if (s.gI(csn)) {
                    i = 7;
                    bundle = bundle2;
                } else {
                    i = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str, i);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
            bundle2.putString("stat_chat_talker_username", csn);
            bundle2.putString("stat_send_msg_user", str2);
            intent.putExtra("_stat_obj", bundle2);
        }
    }

    public static boolean c(au auVar, String str) {
        if (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bi.oN(str) && e.bO(str))) {
            return false;
        }
        return true;
    }

    public static boolean W(x xVar) {
        return xVar.field_username.equals("medianote") && (q.Gc() & 16384) == 0;
    }

    public static ViewStub a(u uVar, int i) {
        ViewStub viewStub = (ViewStub) uVar.findViewById(i);
        if (viewStub != null) {
            viewStub.inflate();
        }
        return viewStub;
    }

    public static boolean ZP(String str) {
        int i = -1;
        if (s.gH(str) || !s.gz(str) || q.gt(str)) {
            return false;
        }
        int i2;
        as.Hm();
        ag Xv = c.Ff().Xv(str);
        if (Xv != null) {
            i2 = Xv.field_type;
            as.Hm();
            Xv = c.Ff().Xv(Xv.field_encryptUsername);
            if (Xv != null) {
                i = Xv.field_type;
            }
        } else {
            i2 = -1;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", str, Integer.valueOf(i2), Integer.valueOf(i));
        return true;
    }
}
