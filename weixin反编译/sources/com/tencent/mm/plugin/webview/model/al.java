package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.af.y;
import com.tencent.mm.plugin.ae.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.base.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.Set;

public final class al extends a {
    public static String tzN = "";

    public final int getType() {
        return 2;
    }

    public final void l(Context context, Intent intent) {
        final String wm = c.wm(t.j(intent, SlookAirButtonFrequentContactAdapter.ID));
        final String wm2 = c.wm(t.j(intent, "ext_info"));
        Object j = t.j(intent, "token");
        if (TextUtils.isEmpty(wm) || TextUtils.isEmpty(wm2) || TextUtils.isEmpty(j)) {
            x.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        if (!j.equals(d.bQ(wm2, stringBuilder.append(com.tencent.mm.y.c.Cn()).toString()))) {
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("app_brand_global_sp", 0);
            if (sharedPreferences == null) {
                x.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
                return;
            }
            Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet == null || stringSet.isEmpty()) {
                x.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
                return;
            }
            Set hashSet = new HashSet();
            for (String bQ : stringSet) {
                hashSet.add(c.bQ(wm2, bQ));
            }
            if (!hashSet.contains(j)) {
                x.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", j);
                Toast.makeText(context, context.getString(R.l.eYJ), 1).show();
                return;
            }
        }
        intent.putExtra(Columns.TYPE, 0);
        intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, "");
        String bQ2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=" + wm2;
        if (!bi.oN(tzN)) {
            bQ2 = bQ2 + "&" + tzN;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", bQ2);
        intent2.putExtra("from_shortcut", true);
        intent2.putExtra("game_hv_menu_appid", wm2);
        intent2.addFlags(67108864);
        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.game.H5GameWebViewUI", intent2);
        y.Mv().jz(wm);
        Object j2 = t.j(intent, "digest");
        if (TextUtils.isEmpty(j2)) {
            x.i("MicroMsg.WebViewShortcutEntry", "digest is null");
            return;
        }
        as.Hm();
        com.tencent.mm.storage.x Xv = com.tencent.mm.y.c.Ff().Xv(wm);
        if (Xv == null || bi.oN(Xv.AW())) {
            x.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
            return;
        }
        String AW = Xv.AW();
        h jp = n.JW().jp(wm);
        if (jp == null || bi.oN(jp.JN())) {
            x.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
        } else if (j2.equals(g.s((AW + jp.JN()).getBytes()))) {
            x.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
        } else {
            Bitmap a = b.a(wm, false, -1);
            if (a == null || a.isRecycled()) {
                x.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
                return;
            }
            x.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", AW);
            d.c(context, wm, wm2, c.wm(t.j(intent, "ext_info_1")));
            ah.h(new Runnable() {
                public final void run() {
                    d.a(ad.getContext(), wm, wm2, null);
                }
            }, 1000);
        }
    }
}
