package com.tencent.mm.pluginsdk.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.bpe;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.List;

public final class p {
    private static final long[] vmF = new long[]{0, 259200000, 604800000};
    private static String vmG = "tinker-boots-install-info";
    private static String vmH = "tinker-boots-last-show";
    private static String vmI = "tinker-boots-show-time";
    private static String vmJ = "";

    public static String bZL() {
        return ad.getContext().getSharedPreferences("update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
    }

    public static int bZM() {
        return ad.getContext().getSharedPreferences("update_config_prefs", 4).getInt("update_downloaded_pack_update_type", 3);
    }

    public static boolean bZN() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("update_config_prefs", 4);
        long j = sharedPreferences.getLong("update_downloaded_cancel_ts", 0);
        int i = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        x.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", Long.valueOf(j), Integer.valueOf(i));
        if (i > vmF.length - 1) {
            return true;
        }
        if (System.currentTimeMillis() - j > vmF[i]) {
            return false;
        }
        if (System.currentTimeMillis() - j >= 0) {
            return true;
        }
        x.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
        ad.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
        x.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
        return true;
    }

    public static boolean bZO() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("update_config_prefs", 4);
        long j = sharedPreferences.getLong("update_downloading_in_silence", 0);
        boolean z = sharedPreferences.getBoolean("update_download_start_one_immediate", false);
        x.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", Long.valueOf(j));
        if (z || (j != 0 && System.currentTimeMillis() - j > 3600000)) {
            return true;
        }
        return false;
    }

    public static String el(Context context) {
        String em = em(context);
        if (em == null || !new File(em).exists()) {
            return null;
        }
        a cg = a.cg(em);
        return (cg == null || cg.fef == null) ? g.bV(em) : cg.fef.apkMd5;
    }

    public static String em(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
            return null;
        }
    }

    public static void ba(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static bpe bZP() {
        bpe bpe;
        Throwable e;
        String string = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString(vmG, "");
        if (bi.oN(string)) {
            bpe = null;
        } else {
            bpe bpe2;
            try {
                bpe2 = new bpe();
                try {
                    bpe = (bpe) bpe2.aH(Base64.decode(string, 0));
                } catch (Exception e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.UpdateUtil", e, "parse tinker install failed.", new Object[0]);
                    bpe = bpe2;
                    if (bpe == null) {
                        return bpe;
                    }
                    x.i("MicroMsg.UpdateUtil", "update info is null.");
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                bpe2 = null;
                x.printErrStackTrace("MicroMsg.UpdateUtil", e, "parse tinker install failed.", new Object[0]);
                bpe = bpe2;
                if (bpe == null) {
                    return bpe;
                }
                x.i("MicroMsg.UpdateUtil", "update info is null.");
                return null;
            }
        }
        if (bpe == null) {
            return bpe;
        }
        x.i("MicroMsg.UpdateUtil", "update info is null.");
        return null;
    }

    public static boolean bZQ() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4);
        long j = sharedPreferences.getLong(vmH, 0);
        int i = sharedPreferences.getInt(vmI, 0);
        x.d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(j), Integer.valueOf(i));
        if (System.currentTimeMillis() - j <= 21600000 || i >= 3) {
            return false;
        }
        return true;
    }

    public static void bZR() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4);
        sharedPreferences.edit().putLong(vmH, System.currentTimeMillis()).apply();
        sharedPreferences.edit().putInt(vmI, sharedPreferences.getInt(vmI, 0) + 1).apply();
    }

    public static void a(bpe bpe) {
        try {
            ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).edit().putString(vmG, Base64.encodeToString(bpe.toByteArray(), 0)).apply();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
        }
        x.d("MicroMsg.UpdateUtil", "save tinker install update info.");
    }

    public static void bZS() {
        x.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4);
        sharedPreferences.edit().putString(vmG, "").apply();
        sharedPreferences.edit().putLong(vmH, 0).apply();
        sharedPreferences.edit().putInt(vmI, 0).apply();
    }

    public static void bZT() {
        as.Dt().F(new Runnable() {
            public final void run() {
                x.i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
                e.bP(p.bZU());
            }
        });
    }

    public static String bZU() {
        if (bi.oN(vmJ)) {
            vmJ = com.tencent.mm.compatible.util.e.gJd + "bsdiff/";
        }
        return vmJ;
    }

    public static String Su(String str) {
        return bZU() + str + ".apk";
    }

    public static String[] bZV() {
        int i = 0;
        if (r.ifw == null || r.ifw.length() <= 0) {
            String string = ad.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List TT = n.TT(string);
            String[] strArr = new String[TT.size()];
            while (i < TT.size()) {
                strArr[i] = ((n) TT.get(i)).nWa;
                i++;
            }
            return strArr;
        }
        return new String[]{r.ifw};
    }
}
