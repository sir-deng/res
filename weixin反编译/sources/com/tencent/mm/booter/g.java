package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.app.e.a;
import com.tencent.mm.ay.i;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public final class g {
    public static void run() {
        SharedPreferences sharedPreferences;
        Editor edit;
        int i;
        Context context = ad.getContext();
        a anonymousClass1 = new a() {
            public final void eo(int i) {
                x.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", Integer.valueOf(i));
                com.tencent.mm.plugin.report.service.g.pWK.a(25, (long) i, 1, false);
            }
        };
        if (context != null) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                String[] split = sharedPreferences.getString("crashlist", "").split(";");
                if (split != null && split.length > 0) {
                    edit = sharedPreferences.edit();
                    edit.putString("crashlist", "");
                    edit.commit();
                    for (i = 0; i < split.length; i++) {
                        String[] split2 = split[i] == null ? null : split[i].split(",");
                        if (split2 != null && split2.length >= 2) {
                            if (split2[1].equals("anr")) {
                                anonymousClass1.eo(10);
                            } else {
                                anonymousClass1.eo(11);
                                if ("com.tencent.mm".equals(split2[0])) {
                                    anonymousClass1.eo(14);
                                }
                                if ("com.tencent.mm:push".equals(split2[0])) {
                                    anonymousClass1.eo(17);
                                }
                                if ("com.tencent.mm:tools".equals(split2[0])) {
                                    anonymousClass1.eo(20);
                                }
                                if (split2[1].equals("java")) {
                                    anonymousClass1.eo(12);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.eo(15);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.eo(18);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.eo(21);
                                    }
                                }
                                if (split2[1].equals("jni")) {
                                    anonymousClass1.eo(13);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.eo(16);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.eo(19);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.eo(22);
                                    }
                                }
                                if (split2[1].equals("first")) {
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.eo(23);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.eo(24);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.eo(25);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        context = ad.getContext();
        i = com.tencent.mm.j.g.Af().getInt("AndroidGooglePlayCrashUploadSizeLimit", 3072);
        if (context != null && i > 0) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                if (sharedPreferences.getInt("googleplaysizelimit", 3072) != i) {
                    edit = sharedPreferences.edit();
                    edit.putInt("googleplaysizelimit", i);
                    edit.commit();
                }
            } catch (Throwable th2) {
            }
        }
        as.Hm();
        if (t.bA(t.d((Long) c.Db().get(w.a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, null))) > 21600000) {
            com.tencent.mm.plugin.report.service.g.pWK.a(279, (long) (com.tencent.mm.j.g.Af().getInt("AndroidDynamicConfigVer", 0) % 16), 1, false);
            as.Hm();
            c.Db().a(w.a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, Long.valueOf(t.Wy()));
        }
        as.Hm();
        if (t.bA(t.d((Long) c.Db().get(w.a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, null))) > 21600000) {
            as.Hm();
            c.Db().a(w.a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, Long.valueOf(t.Wy()));
            s Ub = o.Ub();
            int[] iArr = new int[]{0, 0, 0, 0, 0, 0};
            try {
                x.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", "select status, videofuncflag, human from videoinfo2 where lastmodifytime > " + (bi.Wx() - 21600));
                Cursor a = Ub.hiZ.a(r2, null, 2);
                while (a.moveToNext()) {
                    int i2 = a.getInt(0);
                    int i3 = a.getInt(1);
                    String string = a.getString(2);
                    if (111 == i2) {
                        if (i3 == 3) {
                            i2 = 0;
                        } else {
                            i2 = 3;
                        }
                        iArr[i2] = iArr[i2] + 1;
                    } else if (199 != i2) {
                        continue;
                    } else if (q.FY().equals(string)) {
                        i2 = i3 == 3 ? 1 : 4;
                        iArr[i2] = iArr[i2] + 1;
                    } else {
                        i2 = i3 == 3 ? 2 : 5;
                        iArr[i2] = iArr[i2] + 1;
                    }
                }
                a.close();
                com.tencent.mm.plugin.report.service.g.pWK.h(12696, Integer.valueOf(10010), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]), Integer.valueOf(iArr[4]), Integer.valueOf(iArr[5]));
            } catch (Exception e) {
            }
        }
        if (bi.Wy() - bi.a((Long) com.tencent.mm.kernel.g.Dq().Db().get(81939, null), 0) > 86400000) {
            i iVar = new i();
        }
        long currentTimeMillis = System.currentTimeMillis();
        as.Hm();
        boolean booleanValue = ((Boolean) c.Db().get(233475, Boolean.valueOf(false))).booleanValue();
        as.Hm();
        if (c.Ff().cje() <= 0) {
            if (!booleanValue) {
                as.Hm();
                c.Fk().XE("officialaccounts");
                as.Hm();
                c.Db().set(233475, Boolean.valueOf(true));
            }
        } else if (booleanValue) {
            as.Hm();
            c.Db().set(233475, Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.webwx.a.g.bWe().bWg().bWc();
        x.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
