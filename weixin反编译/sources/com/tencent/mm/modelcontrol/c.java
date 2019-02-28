package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bb.b;
import com.tencent.mm.y.p;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c implements ap {
    public static synchronized c MX() {
        c cVar;
        synchronized (c.class) {
            cVar = (c) p.s(c.class);
        }
        return cVar;
    }

    public static boolean l(au auVar) {
        if (auVar == null) {
            x.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
            return false;
        } else if (!auVar.cjT()) {
            x.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
            return false;
        } else if (m(auVar)) {
            return MY();
        } else {
            x.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
            return false;
        }
    }

    public static boolean MY() {
        String value = ((a) g.h(a.class)).Af().getValue("C2CImgNotAutoDownloadTimeRange");
        x.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: " + value);
        if (b.kN(value)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
            return false;
        }
        int i = bi.getInt(((a) g.h(a.class)).Af().getValue("ChatImgAutoDownload"), 1);
        if (i == 3) {
            x.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : " + i);
            return false;
        }
        Context context = ad.getContext();
        if (i == 2 && ao.isWifi(context)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            return true;
        } else if (i == 1 && ao.isWifi(context)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            return true;
        } else {
            long j = (long) bi.getInt(((a) g.h(a.class)).Af().getValue("ChatImgAutoDownloadMax"), 0);
            long a = bi.a((Long) g.Dq().Db().get(w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long Wp = bi.Wp((String) DateFormat.format("M", System.currentTimeMillis()));
            long a2 = bi.a((Long) g.Dq().Db().get(w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, null), 0);
            x.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + Wp + " month " + a2 + " maxcount " + j + " current " + a + " downloadMode: " + i);
            if (Wp != a2) {
                x.i("MicroMsg.SubCoreAutoDownload", "update month %d ", Long.valueOf(Wp));
                g.Dq().Db().a(w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(0));
                g.Dq().Db().a(w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(Wp));
                a2 = 0;
            } else {
                a2 = a;
            }
            if (a2 > j && j > 0) {
                x.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + a2 + " C2C image, can not auto download.");
                return false;
            } else if (i == 1 && (ao.isWifi(context) || ao.is3G(context) || ao.is4G(context))) {
                x.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
                return true;
            } else {
                x.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
                return false;
            }
        }
    }

    public static boolean MZ() {
        String value = ((a) g.h(a.class)).Af().getValue("SnsImgPreLoadingAroundTimeLimit");
        x.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: " + value);
        if (b.kN(value)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
            return false;
        }
        x.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
        return true;
    }

    public static boolean a(PInt pInt, PInt pInt2, PInt pInt3) {
        pInt.value = 0;
        int i = bi.getInt(((a) g.h(a.class)).Af().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            x.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
            return false;
        }
        boolean isWifi = ao.isWifi(ad.getContext());
        if (i == 2 && !isWifi) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
            return false;
        } else if (ao.is2G(ad.getContext())) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
            return false;
        } else {
            String value = ((a) g.h(a.class)).Af().getValue("SnsSightNoAutoDownload");
            if (!bi.oN(value)) {
                try {
                    x.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq " + value);
                    long j = bi.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0) - ((((long) (((int) b.MW()) - 8)) * 60) / 1000);
                    String[] split = value.split(",");
                    long j2 = bi.getLong(split[0], 0);
                    if (j <= bi.getLong(split[1], 0) && j >= j2) {
                        x.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
                        pInt3.value = 1;
                        return false;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", value, e.getMessage());
                }
            }
            String value2 = ((a) g.h(a.class)).Af().getValue("SnsSightNotAutoDownloadTimeRange");
            x.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: " + value2);
            if (b.kN(value2)) {
                int i2;
                x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                return false;
            }
            x.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
            return true;
        }
    }

    public static boolean a(PInt pInt, PInt pInt2) {
        pInt.value = 0;
        int i = bi.getInt(((a) g.h(a.class)).Af().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            x.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
            return false;
        }
        boolean isWifi = ao.isWifi(ad.getContext());
        if (i == 2 && !isWifi) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
            return false;
        } else if (ao.is2G(ad.getContext())) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
            return false;
        } else {
            String value = ((a) g.h(a.class)).Af().getValue("SnsAdSightNotAutoDownloadTimeRange");
            x.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: " + value);
            if (b.kN(value)) {
                int i2;
                x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                return false;
            }
            x.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
            return true;
        }
    }

    public static boolean m(au auVar) {
        if (auVar == null) {
            x.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
            return false;
        }
        b hW = bb.hW(auVar.gkD);
        if (hW == null) {
            x.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
            return true;
        }
        String str = hW.hiy;
        if (bi.oN(str)) {
            x.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
            return true;
        } else if (b.kN(str)) {
            x.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : " + str);
            return false;
        } else {
            x.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: " + str);
            return true;
        }
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
