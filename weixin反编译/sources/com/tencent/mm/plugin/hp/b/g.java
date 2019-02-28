package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.protocal.c.bpd;
import com.tencent.mm.protocal.c.bph;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.Iterator;
import java.util.LinkedList;

public final class g implements a {
    public final boolean a(Context context, final String[] strArr) {
        if (strArr.length < 2) {
            x.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
            return false;
        }
        boolean z;
        String str = strArr[1];
        if (b.cfx()) {
            z = true;
            switch (str.hashCode()) {
                case -838846263:
                    if (str.equals("update")) {
                        z = false;
                        break;
                    }
                    break;
                case 3510:
                    if (str.equals("nd")) {
                        z = true;
                        break;
                    }
                    break;
                case 3083269:
                    if (str.equals("diff")) {
                        z = true;
                        break;
                    }
                    break;
                case 3089570:
                    if (str.equals("down")) {
                        z = true;
                        break;
                    }
                    break;
                case 3529469:
                    if (str.equals("show")) {
                        z = true;
                        break;
                    }
                    break;
                case 94746189:
                    if (str.equals("clear")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    bpd bpd;
                    x.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
                    Object linkedList = new LinkedList();
                    String str2 = "tinker_id_d1ddc930233f0ec33f573e365038b6d979b6ebde";
                    String str3 = "";
                    if (strArr.length >= 3) {
                        str = strArr[2];
                    } else {
                        str = str2;
                    }
                    if (strArr.length >= 4) {
                        str3 = strArr[3];
                    }
                    if (strArr.length >= 5) {
                        bpd = new bpd();
                        bpd.aAM = "sdk";
                        bpd.value = strArr[4];
                        linkedList.add(bpd);
                    } else {
                        bpd = new bpd();
                        bpd.aAM = "sdk";
                        bpd.value = String.valueOf(VERSION.SDK_INT);
                        linkedList.add(bpd);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        bpd = (bpd) it.next();
                        stringBuilder.append(bpd.aAM).append(":").append(bpd.value).append("\n");
                    }
                    x.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", str, str3, stringBuilder.toString());
                    as.CN().a(new com.tencent.mm.plugin.hp.c.a(str, str3, linkedList), 0);
                    return true;
                case true:
                    i.a(ad.getContext().getString(R.l.ejC), ad.getContext().getString(R.l.ejC), ad.getContext().getString(R.l.epL), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(ad.getContext(), "OK", 0).show();
                        }
                    }, ad.getContext().getString(R.l.eSg), null);
                    return true;
                case true:
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            int i;
                            String str = e.bnF + "/Download/2017-07-28_19-43-39.apk";
                            String str2 = e.bnF + "/Download/39-50-diff.apk";
                            String str3 = e.bnF + "/Download/new_50.apk";
                            String str4 = "ab099f75f740be5d88e178d662a36779";
                            if (strArr.length >= 3 && !bi.oN(strArr[2])) {
                                str = strArr[2];
                            }
                            if (strArr.length >= 4 && !bi.oN(strArr[3])) {
                                str2 = strArr[3];
                            }
                            if (strArr.length >= 5 && !bi.oN(strArr[4])) {
                                str3 = strArr[4];
                            }
                            if (strArr.length >= 6 && !bi.oN(strArr[5])) {
                                str4 = strArr[5];
                            }
                            if (com.tencent.mm.a.e.bO(str3)) {
                                i = 0;
                            } else {
                                long currentTimeMillis = System.currentTimeMillis();
                                i = com.tencent.mm.plugin.hp.a.b.b(str, str2, str3, str4);
                                x.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(i));
                            }
                            if (i == 0) {
                                x.i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
                                x.i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", com.tencent.mm.a.g.bV(str3));
                                p.ba(ad.getContext(), str3);
                                x.i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
                                return;
                            }
                            x.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
                        }
                    });
                    return true;
                case true:
                    bph bph = new bph();
                    bph.wYC = 1000;
                    bph.wYz = 2;
                    bph.wYA = 2;
                    bph.state = 2;
                    bph.wdx = "android_tinker_id_123123131231231";
                    beg beg = new beg();
                    beg.wgY = "c3282ad2467fad9561227bc9b5b6712c";
                    beg.wfl = 118617;
                    beg.nlE = "http://dldir1.qq.com/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk";
                    bph.wYz = 3;
                    beg.wgY = "3ba62fdbd98df2bdf5da7d726010d867";
                    beg.wfl = 33338711;
                    beg.nlE = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
                    bph.wYB = beg;
                    new e(new com.tencent.mm.plugin.hp.d.b(bph)).fR(false);
                    return true;
                case true:
                    if (strArr.length >= 6) {
                        bi.Wp(strArr[5]);
                    }
                    return true;
                case true:
                    com.tencent.mm.plugin.hp.tinker.g.ah(ad.getContext(), "");
                    com.tencent.mm.plugin.hp.tinker.g.ai(ad.getContext(), "");
                    com.tencent.mm.plugin.hp.tinker.g.E(ad.getContext(), 0);
                    p.bZS();
                    return true;
                default:
                    x.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a debugger command.", str);
                    break;
            }
        }
        z = true;
        switch (str.hashCode()) {
            case 94627080:
                if (str.equals("check")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                try {
                    com.tinkerboots.sdk.a.cKg().om(true);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", e, "", new Object[0]);
                }
                return true;
            default:
                x.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", str);
                return false;
        }
    }
}
