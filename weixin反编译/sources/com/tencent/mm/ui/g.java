package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.af.b;
import com.tencent.mm.af.c;
import com.tencent.mm.af.d;
import com.tencent.mm.af.e;
import com.tencent.mm.af.y;
import com.tencent.mm.by.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.base.u;

public final class g {
    public static int bl(Context context, String str) {
        if (bi.oN(str)) {
            return 0;
        }
        int i;
        b jA = y.Ms().jA(str);
        if (jA == null || (jA.field_userFlag & 2) == 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return 0;
        }
        if (jA.field_wwExposeTimes < jA.field_wwMaxExposeTimes || p.m(context, "com.tencent.wework")) {
            return 2;
        }
        return 1;
    }

    public static void bm(Context context, String str) {
        if (!bi.oN(str) && !p.m(context, "com.tencent.wework")) {
            y.Ms().jD(str);
        }
    }

    public static void n(Context context, String str, int i) {
        if (p.m(context, "com.tencent.wework")) {
            ad(str, 4, i);
        } else {
            ad(str, 5, i);
        }
    }

    public static void o(final Context context, final String str, final int i) {
        ad(str, 1, i);
        ae(str, 2, i);
        b jB = y.Ms().jB(str);
        if (p.m(context, "com.tencent.wework")) {
            Intent launchIntentForPackage;
            ad(str, 2, i);
            PackageInfo packageInfo = p.getPackageInfo(context, "com.tencent.wework");
            if (bi.oN(packageInfo.versionName) || packageInfo.versionName.compareTo("1.3.3") < 0) {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.wework");
            } else {
                String str2;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                if (i == 2 || i == 4 || i == 6) {
                    str2 = "wxwork://createconversation";
                } else {
                    str2 = "wxwork://conversationlist";
                }
                intent.setData(Uri.parse(str2));
                launchIntentForPackage = intent;
            }
            a.post(new Runnable() {
                public final void run() {
                    com.tencent.mm.pluginsdk.model.app.g.a(context, launchIntentForPackage, context.getString(R.l.eco));
                }
            });
        } else if (jB.field_chatOpen || jB.field_use_preset_banner_tips) {
            h.a(context, R.l.ecr, 0, R.l.ecq, R.l.dEy, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.p(context, str, i);
                }
            }, null);
        } else if (jB.field_show_confirm) {
            j.b bVar = new j.b(context);
            bVar.yix = context.getString(R.l.dEy);
            bVar.EZ(R.l.ecq);
            y.Ms();
            y.Ms();
            bVar.Zr(c.hq(1));
            bVar.a(new j.a() {
                public final void cj(boolean z) {
                }
            }, new j.a() {
                public final void cj(boolean z) {
                    g.p(context, str, i);
                }
            }).pDT.show();
        } else {
            p(context, str, i);
        }
    }

    public static void p(Context context, String str, int i) {
        ad(str, 3, i);
        ae(str, 3, i);
        y.Ml();
        String str2 = "https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s";
        Object[] objArr = new Object[1];
        objArr[0] = bi.oN(e.jR(str)) ? "off" : "on";
        String format = String.format(str2, objArr);
        FileDownloadTaskInfo yp = f.aAK().yp(format);
        if (yp != null && yp.status == 3 && com.tencent.mm.a.e.bO(yp.path)) {
            com.tencent.mm.loader.stub.b.deleteFile(yp.path);
        }
        u.makeText(context, context.getString(R.l.ecs), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN).show();
        com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
        aVar.yr(format);
        aVar.yt(context.getString(R.l.eco));
        aVar.oP(1);
        aVar.et(true);
        f.aAK().a(aVar.lyp);
    }

    private static int ad(String str, int i, int i2) {
        d jN = y.Ml().jN(str);
        if (jN.Ll()) {
            str = jN.Ls();
        }
        b jA = y.Ms().jA(str);
        int i3 = jA != null ? jA.field_qyUin : 0;
        int i4 = jA != null ? jA.field_userUin : 0;
        long j = jA != null ? jA.field_wwCorpId : 0;
        long j2 = jA != null ? jA.field_wwUserVid : 0;
        com.tencent.mm.plugin.report.service.g.pWK.h(13656, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        x.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        return i2;
    }

    public static void di(String str, int i) {
        if (i > 0) {
            int i2;
            int i3;
            b jA = y.Ms().jA(str);
            if (jA != null) {
                i2 = jA.field_qyUin;
            } else {
                i2 = 0;
            }
            if (jA != null) {
                i3 = jA.field_userUin;
            } else {
                i3 = 0;
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(13703, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
            x.d("MicroMsg.EnterpriseHelper", "enterprise click report: %s,%s,%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
        }
    }

    public static void ae(String str, int i, int i2) {
        int i3;
        d jN = y.Ml().jN(str);
        if (i2 == 3) {
            i3 = 2;
        } else {
            i3 = i2;
        }
        if (i3 == 4) {
            i3 = 3;
        }
        if (jN.Ll()) {
            str = jN.Ls();
        }
        b jA = y.Ms().jA(str);
        int i4 = jA.field_chatOpen ? 1 : 0;
        int i5 = jA.field_show_confirm ? 1 : 0;
        com.tencent.mm.plugin.report.service.g.pWK.h(15162, Long.valueOf(jA.field_wwCorpId), Long.valueOf(jA.field_wwUserVid), Integer.valueOf(i4), Integer.valueOf(jA.field_wwUnreadCnt), Integer.valueOf(i5), Integer.valueOf(jA.field_userType), Integer.valueOf(i), Integer.valueOf(i3));
    }
}
