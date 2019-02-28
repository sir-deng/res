package com.tencent.mm.plugin.emoji.e;

import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class n {
    private static boolean lCS = false;
    private static boolean lCT = false;
    private static boolean lCU = false;
    private static boolean lCV = false;

    public static boolean aBR() {
        if ((g.Af().getInt("EmotionRewardOption", 0) & 1) == 1) {
            return false;
        }
        return true;
    }

    public static boolean aBS() {
        if ((g.Af().getInt("EmotionRewardOption", 0) & 2) == 2) {
            return false;
        }
        return true;
    }

    public static boolean aBT() {
        if ((g.Af().getInt("EmotionRewardOption", 0) & 4) == 4) {
            return true;
        }
        return false;
    }

    public static int aBU() {
        return bi.getInt(g.Af().getValue("CustomEmojiMaxSize"), 150);
    }

    public static String aBV() {
        return g.Af().getValue("C2CEmojiNotAutoDownloadTimeRange");
    }

    public static String aBW() {
        return g.Af().getValue("EmotionPanelConfigName");
    }

    public static boolean aBX() {
        if (!lCS) {
            c fp = com.tencent.mm.y.c.c.IL().fp("100296");
            int i;
            if (fp.isValid()) {
                i = bi.getInt((String) fp.civ().get("EnableEmoticonExternUrl"), 0);
            } else {
                i = 0;
            }
            int i2 = g.Af().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i2 & 1) != 1 && (i & 1) != 1) {
                lCU = false;
            } else if (aBZ() || aCa()) {
                lCU = false;
            } else {
                lCU = true;
            }
            if (errorCode < 0) {
                lCU = false;
                switch (errorCode) {
                    case -906:
                        com.tencent.mm.plugin.report.service.g.pWK.a(711, 10, 1, false);
                        break;
                    case -905:
                        com.tencent.mm.plugin.report.service.g.pWK.a(711, 9, 1, false);
                        break;
                    case -904:
                        com.tencent.mm.plugin.report.service.g.pWK.a(711, 8, 1, false);
                        break;
                    case -903:
                        com.tencent.mm.plugin.report.service.g.pWK.a(711, 7, 1, false);
                        break;
                    case -902:
                        com.tencent.mm.plugin.report.service.g.pWK.a(711, 6, 1, false);
                        break;
                    case -901:
                        com.tencent.mm.plugin.report.service.g.pWK.a(711, 5, 1, false);
                        break;
                }
            }
            lCS = true;
            x.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", Boolean.valueOf(lCU));
        }
        return lCU;
    }

    public static boolean aBY() {
        if (!lCT) {
            int i = 0;
            c fp = com.tencent.mm.y.c.c.IL().fp("100296");
            if (fp.isValid()) {
                i = bi.getInt((String) fp.civ().get("EnableEmoticonExternUrl"), 0);
            }
            int i2 = g.Af().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i2 & 2) == 2 || (i & 2) == 2) {
                if (aBZ() || aCa()) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(711, 0, 1, false);
                } else {
                    lCV = true;
                    com.tencent.mm.plugin.report.service.g.pWK.a(711, 1, 1, false);
                    if (errorCode < 0) {
                        lCV = false;
                    }
                    lCT = true;
                    x.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", Boolean.valueOf(lCV));
                }
            }
            lCV = false;
            if (errorCode < 0) {
                lCV = false;
            }
            lCT = true;
            x.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", Boolean.valueOf(lCV));
        }
        return lCV;
    }

    private static boolean aBZ() {
        try {
            ad.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static boolean aCa() {
        try {
            ad.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
