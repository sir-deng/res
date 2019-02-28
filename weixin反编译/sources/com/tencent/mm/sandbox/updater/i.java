package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mm.c.h;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    private static final long[] vmF = new long[]{0, 259200000, 604800000};

    public static int e(Context context, String str, String str2, String str3) {
        return h.b(p.em(context), str, str2, str3);
    }

    public static void ae(Context context, int i) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", false);
        intent.putExtra("intent_extra_opcode", i);
        context.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
    }

    public static void af(Context context, int i) {
        f(context, i, 0);
    }

    public static void f(Context context, int i, int i2) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", true);
        intent.putExtra("intent_extra_opcode", i);
        if (i == 2) {
            intent.putExtra("intent_extra_install_dialog_times", i2);
        }
        context.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
    }

    public static String bZL() {
        return MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
    }

    public static String cff() {
        return MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_sig_key", null);
    }

    public static String cfg() {
        return MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_desc_key", null);
    }

    public static int cfh() {
        return MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).getInt("update_downloaded_pack_download_mode", 0);
    }

    public static void a(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).edit().putString("update_downloaded_pack_md5_key", str).putString("update_downloaded_pack_sig_key", str2).putString("update_downloaded_pack_desc_key", str3).putInt("update_downloaded_pack_size_key", i).putInt("update_downloaded_pack_download_mode", i2).putInt("update_downloaded_pack_update_type", i3).putString("update_download_not_auto_download_range", str4).commit();
        x.i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", str, Integer.valueOf(i), str4);
    }

    public static int cfi() {
        x.i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", Integer.valueOf(MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).getInt("update_downloaded_cancel_times", 0)));
        return MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).getInt("update_downloaded_cancel_times", 0);
    }

    public static void cfj() {
        int i = 0;
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4);
        int i2 = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        x.i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", Integer.valueOf(i2));
        if (i2 >= vmF.length - 1) {
            String bZL = bZL();
            StringBuffer stringBuffer = null;
            if (!bi.oN(bZL)) {
                String[] cfk = cfk();
                stringBuffer = new StringBuffer();
                stringBuffer.append(bZL);
                if (cfk != null) {
                    int length = cfk.length;
                    while (i < length) {
                        String str = cfk[i];
                        if (!bi.oN(str)) {
                            stringBuffer.append(":");
                            stringBuffer.append(str);
                        }
                        i++;
                    }
                }
            }
            sharedPreferences.edit().clear().commit();
            if (stringBuffer != null) {
                sharedPreferences.edit().putString("update_downloaded_ignored_pack", stringBuffer.toString()).commit();
                return;
            }
            return;
        }
        sharedPreferences.edit().putLong("update_downloaded_cancel_ts", System.currentTimeMillis()).putInt("update_downloaded_cancel_times", i2 + 1).commit();
    }

    public static boolean Vk(String str) {
        String[] cfk = cfk();
        if (cfk == null) {
            return false;
        }
        for (String equals : cfk) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static String[] cfk() {
        String string = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).getString("update_downloaded_ignored_pack", null);
        if (bi.oN(string)) {
            return null;
        }
        return string.split(":");
    }

    public static void cfl() {
        MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
        x.i("MicroMsg.UpdateUtil", "putDowningInSilence");
    }

    public static void cfm() {
        MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).edit().putBoolean("update_download_start_one_immediate", true).commit();
        x.i("MicroMsg.UpdateUtil", "putOneDownloadTask");
    }

    public static void cfn() {
        MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).edit().remove("update_downloading_in_silence").commit();
        x.i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
    }

    public static void cfo() {
        MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_config_prefs", 4).edit().clear().commit();
        x.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
    }

    public static long s(String str, long j, long j2) {
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_flowstat_prefs", 4);
        long j3 = sharedPreferences.getLong(str, 0);
        x.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", str, Long.valueOf(j), Long.valueOf(j2));
        x.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", str, Long.valueOf(j3));
        j3 += j + j2;
        sharedPreferences.edit().putLong(str, j3).commit();
        return j3;
    }

    public static long Vl(String str) {
        x.i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", str, Long.valueOf(MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_flowstat_prefs", 4).getLong(str, 0)));
        return MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "update_flowstat_prefs", 4).getLong(str, 0);
    }
}
