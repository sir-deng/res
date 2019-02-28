package com.tencent.mm.compatible.util;

import com.tencent.mm.loader.stub.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class e extends a {
    public static final String gJc = h.getExternalStorageDirectory().getParent();
    public static String gJd = (bnF + "Download/");
    public static String gJe;
    public static String gJf;
    public static String gJg = (bnF + "vusericon/");
    public static String gJh = (bnF + "Game/");
    public static String gJi = (bnF + "CDNTemp/");
    public static String gJj = (bnF + "Download/VoiceRemind");
    public static String gJk = (bnF + "watchdog/");
    public static String gJl = (bnF + "xlog");
    public static String gJm = (bnF + "avatar/");
    public static String gJn = (bnF + "exdevice/");
    public static String gJo = (bnF + "newyear/");
    public static String gJp = (bnF + "expose/");
    public static String gJq = (bnF + "f2flucky/");
    public static String gJr = (bnF + "WebviewCache/");
    public static String gJs = (bnF + "pattern_recognition/");
    public static String gJt = (bnF + "sniffer/");

    public static void eM(String str) {
        x.i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + bnD);
        if (bi.oN(str)) {
            int i;
            ArrayList cgO = ax.cgO();
            int size = cgO.size();
            for (i = 0; i < size; i++) {
                x.i("MicroMsg.CConstants", "initSdCardPath start list i = " + i + " StatMountParse: " + cgO.get(i));
            }
            if (size > 1) {
                Collections.sort(cgO, new Comparator<ax.a>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        ax.a aVar = (ax.a) obj;
                        ax.a aVar2 = (ax.a) obj2;
                        long j = (aVar.xql * aVar.xqm) - (aVar2.xql * aVar2.xqm);
                        if (j < 0) {
                            return 1;
                        }
                        return j > 0 ? -1 : 0;
                    }
                });
            }
            if (!(size <= 0 || cgO.get(0) == null || bi.oN(((ax.a) cgO.get(0)).xqh))) {
                bnD = ((ax.a) cgO.get(0)).xqh;
                for (i = 0; i < size; i++) {
                    x.i("MicroMsg.CConstants", "initSdCardPath end list i = " + i + " StatMountParse: " + cgO.get(i));
                }
            }
        } else {
            bnD = str;
        }
        bnF = bnD + bnE;
        gJd = bnF + "Download/";
        gJg = bnF + "vusericon/";
        gJh = bnF + "Game/";
        gJi = bnF + "CDNTemp/";
        gJk = bnF + "watchdog/";
        gJl = bnF + "xlog";
        hbx = bnF + "crash/";
        gJm = bnF + "avatar/";
        gJe = bnF + "Cache/";
        String str2 = bnF + "WeChat/";
        String str3 = bnF + "WeiXin/";
        if (com.tencent.mm.a.e.bO(str2) || !(com.tencent.mm.a.e.bO(str3) || w.cfV().equals("zh_CN"))) {
            str3 = str2;
        }
        gJf = str3;
        x.i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + bnD);
    }
}
