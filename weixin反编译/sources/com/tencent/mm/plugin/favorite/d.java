package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ab.a;
import com.tencent.mm.y.ab.b;
import com.tencent.mm.y.q;
import com.tencent.mm.y.u;
import java.util.ArrayList;

public final class d implements p {
    public static n ihN;
    public static m ihO;

    public final void a(n nVar) {
        ihN = nVar;
    }

    public static void j(Intent intent, Context context) {
        intent.putExtra("geta8key_scene", 14);
        ihN.j(intent, context);
    }

    public static void a(long j, vg vgVar, String str, String str2, ArrayList<String> arrayList, Context context) {
        if (vgVar != null && context != null) {
            Intent intent = new Intent();
            intent.putExtra("KFavLocSigleView", true);
            intent.putExtra("map_view_type", 2);
            intent.putExtra("kFavInfoLocalId", j);
            intent.putExtra("kwebmap_slat", vgVar.lat);
            intent.putExtra("kwebmap_lng", vgVar.lng);
            intent.putExtra("kPoiName", vgVar.fEp);
            intent.putExtra("Kwebmap_locaion", vgVar.label);
            if (vgVar.fAq >= 0) {
                intent.putExtra("kwebmap_scale", vgVar.fAq);
            }
            intent.putExtra("kisUsername", str);
            intent.putExtra("kwebmap_from_to", true);
            intent.putExtra("kRemark", str2);
            intent.putExtra("kTags", arrayList);
            intent.putExtra("kFavCanDel", true);
            intent.putExtra("kFavCanRemark", true);
            ihN.o(intent, context);
        }
    }

    public static void c(String str, Context context) {
        if (bi.oN(str)) {
            x.w("MicroMsg.FavApplication", "share image to timeline fail, filePath is null");
            return;
        }
        Intent intent = new Intent();
        String str2 = "fav_" + q.FY() + "_0";
        String hC = u.hC(str2);
        u.GQ().t(hC, true).o("prePublishId", str2);
        intent.putExtra("reportSessionId", hC);
        ihN.a(str, intent, context);
    }

    public static void d(String str, Context context) {
        if (bi.oN(str)) {
            x.w("MicroMsg.FavApplication", "share image to friend fail, imgPath is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        ihN.l(intent, context);
    }

    public static void a(String str, String str2, Context context) {
        if (bi.oN(str)) {
            x.w("MicroMsg.FavApplication", "save image fail, path is null");
        } else if (!com.tencent.mm.platformtools.d.a(str, context, R.l.dYb)) {
            Toast.makeText(context, str2, 1).show();
        }
    }

    public static String getAppName(Context context, String str) {
        b bVar = a.hht;
        if (bVar != null) {
            return bVar.l(context, str);
        }
        return "";
    }

    public final void a(m mVar) {
        ihO = mVar;
    }

    public static String dh(long j) {
        if (j == 0) {
            return "0KB";
        }
        if ((((double) j) * 1.0d) / 1048576.0d >= 1.0d) {
            return String.format("%dMB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1048576.0d))});
        } else if ((((double) j) * 1.0d) / 1024.0d < 1.0d) {
            return "1KB";
        } else {
            return String.format("%dKB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1024.0d))});
        }
    }
}
