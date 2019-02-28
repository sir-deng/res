package com.tencent.mm.plugin.appbrand.compat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.f.a.hm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyWebViewUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.protocal.c.aiu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.Map;

final class a implements com.tencent.mm.plugin.appbrand.compat.a.a {
    a() {
    }

    public final void J(Context context, String str) {
        Intent putExtra = new Intent(context, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", str);
        putExtra.putExtra("geta8key_scene", 41);
        putExtra.putExtra("title", context.getString(R.l.dEj));
        if (!(context instanceof Activity)) {
            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(putExtra, 3);
        } else {
            context.startActivity(putExtra);
        }
    }

    public final void K(Context context, String str) {
        Intent putExtra = new Intent(context, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", str);
        putExtra.putExtra("geta8key_scene", 41);
        putExtra.putExtra("title", context.getString(R.l.dEg));
        if (!(context instanceof Activity)) {
            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(putExtra, 4);
        } else {
            context.startActivity(putExtra);
        }
    }

    public final Intent bK(Context context) {
        Intent QT = ((f) g.h(f.class)).QT();
        QT.setClass(context, AppBrandSearchUI.class);
        QT.putExtra("key_trust_url", true);
        QT.putExtra("title", context.getString(R.l.dEf));
        QT.putExtra("searchbar_tips", context.getString(R.l.dEf));
        QT.putExtra("KRightBtn", true);
        QT.putExtra("ftsneedkeyboard", true);
        QT.putExtra("ftsType", 64);
        QT.putExtra("ftsbizscene", 201);
        Map aca = ((f) g.h(f.class)).aca();
        String Ja = b.Ja();
        aca.put("WASessionId", Ja);
        QT.putExtra("rawUrl", ((f) g.h(f.class)).r(aca));
        QT.putExtra("key_load_js_without_delay", true);
        QT.addFlags(67108864);
        QT.putExtra("key_session_id", Ja);
        String str = "key_search_input_hint";
        Object obj = g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC, null);
        String str2 = (obj == null || !(obj instanceof String)) ? "" : (String) obj;
        QT.putExtra(str, str2);
        return QT;
    }

    public final void a(com.tencent.mm.x.g.a aVar, String str, String str2, String str3, byte[] bArr) {
        l.a(aVar, str, str2, str3, null, bArr);
    }

    public final Intent k(Context context, String str, String str2) {
        Parcelable intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), str2);
        Intent intent2 = new Intent(context, AppChooserUI.class);
        intent2.putExtra(Columns.TYPE, 0);
        intent2.putExtra("title", context.getResources().getString(R.l.dTI));
        intent2.putExtra("mimetype", str2);
        intent2.putExtra("targetintent", intent);
        return intent2;
    }

    public final View c(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.i.dmD, viewGroup, false);
    }

    public final String bL(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        return context.getString(R.l.eMO);
    }

    public final String bM(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        return context.getString(R.l.eMK);
    }

    public final String bN(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        return context.getString(R.l.eMM);
    }

    public final String bO(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        return context.getString(R.l.eMT);
    }

    public final int abJ() {
        com.tencent.mm.sdk.b.b hmVar = new hm();
        com.tencent.mm.sdk.b.a.xmy.m(hmVar);
        return hmVar.fyI.fyJ;
    }

    public final void a(final com.tencent.mm.plugin.appbrand.compat.a.a.a aVar) {
        com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
        aVar2.hnT = new ait();
        aVar2.hnU = new aiu();
        aVar2.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
        aVar2.hnS = 1926;
        aVar2.hnV = 0;
        aVar2.hnW = 0;
        u.a(aVar2.Kf(), new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                boolean z = true;
                if (kVar.getType() == 1926) {
                    boolean z2;
                    if (i == 0 && i2 == 0) {
                        aiu aiu = (aiu) bVar.hnR.hnY;
                        z2 = aiu != null && aiu.wwP;
                    } else {
                        z2 = false;
                        z = false;
                    }
                    if (aVar != null) {
                        aVar.m(z, z2);
                    }
                }
                return 0;
            }
        }, true);
    }
}
