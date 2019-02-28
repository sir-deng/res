package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.u;
import java.io.File;

public final class p {
    public static boolean us() {
        boolean z = true;
        if (g.Do().CF()) {
            boolean z2;
            if (bi.PZ() || f.fei == 1 || bi.getInt(com.tencent.mm.j.g.Af().getValue("ShowWeixinPBIntro"), 0) != 0 || com.tencent.mm.pluginsdk.model.app.p.m(ad.getContext(), "com.tencent.pb")) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                int a = bi.a((Integer) g.Dq().Db().get(a.USERINFO_WXPHONE_PB_COUNT_INT, null), 3);
                x.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", Integer.valueOf(a));
                if (a <= 0) {
                    return false;
                }
                g.Dq().Db().set(352257, Integer.valueOf(a - 1));
                return true;
            }
            String str = "MicroMsg.WxPhoneBookHelper";
            String str2 = "%b, %b, %b, %b";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(bi.PZ());
            if (f.fei != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (bi.getInt(com.tencent.mm.j.g.Af().getValue("ShowWeixinPBIntro"), 0) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            if (com.tencent.mm.pluginsdk.model.app.p.m(ad.getContext(), "com.tencent.pb")) {
                z = false;
            }
            objArr[3] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            return false;
        }
        x.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
        return false;
    }

    public static void d(Context context, Bundle bundle) {
        int i = bundle != null ? bundle.getInt("fromScene") : 0;
        com.tencent.mm.plugin.report.service.g.pWK.h(11621, Integer.valueOf(i), Integer.valueOf(0));
        FileDownloadTaskInfo yp = com.tencent.mm.plugin.downloader.model.f.aAK().yp("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
        if (yp == null || yp.status != 3) {
            u.makeText(context, context.getString(R.l.dSF), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN).show();
            com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
            aVar.yr("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
            aVar.yt(context.getString(R.l.dSL));
            aVar.oP(1);
            aVar.et(true);
            com.tencent.mm.plugin.downloader.model.f.aAK().a(aVar.lyp);
            return;
        }
        x.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
        if (e.bO(yp.path)) {
            q.e(context, Uri.fromFile(new File(yp.path)));
        }
    }
}
