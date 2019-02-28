package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.xwalk.core.R;

public final class e {
    public static int kqc;
    public static int kqd;
    public static int kqe;
    public static int kqf;
    public static int kqg;
    public static int kqh;
    public static int kqi;
    public static long kqj;
    public static long kqk;
    public static long kql;

    public static void reset() {
        kqc = 0;
        kqd = 0;
        kqe = 0;
        kqf = 0;
        kqg = 0;
        kqh = 0;
        kqi = 0;
        long Wy = bi.Wy();
        kqj = Wy;
        kql = Wy - kqk;
    }

    public static void mU(int i) {
        switch (i) {
            case 1:
                kqe++;
                break;
            case 3:
                kqc++;
                break;
            case 34:
                kqg++;
                break;
            case 37:
            case 40:
            case R.styleable.AppCompatTheme_dialogTheme /*42*/:
            case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
            case 66:
            case 10000:
                kqd++;
                break;
            case R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                kqf++;
                break;
            case R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                kqh++;
                break;
        }
        kqi++;
    }

    public static void apr() {
        x.d("MicroMsg.TestInfo", "total_count: " + kqi + "text_count: " + kqe + "normal_count : " + kqd + " image_count: " + kqc + " voice_count : " + kqg + " video_count " + kqf + " app_count : " + kqh + " time: " + (bi.Wy() - kqj) + " net: " + kql);
    }

    public static void aps() {
        x.d("MicroMsg.TestInfo", "netTime" + (bi.Wy() - kqk));
    }
}
