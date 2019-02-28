package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;

public final class a {
    private static int oqJ = 39;
    private static int oqK = 40;
    private static int oqL = 95;
    private static int oqM = 0;
    private static int oqN = 0;

    public static void c(MMActivity mMActivity) {
        int height;
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(mMActivity, oqJ);
        int fromDPToPix2 = com.tencent.mm.bu.a.fromDPToPix(mMActivity, oqK);
        int i = ae.fA(mMActivity).y;
        if (ae.fz(mMActivity)) {
            i -= ae.fy(mMActivity);
        }
        if (mMActivity.getSupportActionBar() != null) {
            height = mMActivity.getSupportActionBar().getHeight();
        } else {
            height = 0;
        }
        int fromDPToPix3 = com.tencent.mm.bu.a.fromDPToPix(mMActivity, oqL);
        oqM = Math.round(((float) (((i - (fromDPToPix * 2)) - fromDPToPix2) - height)) / 5.0f);
        x.i("MicroMsg.FunctionGridSizeCalculator", "calc GRID_HEIGHT_SIZE_PX: %s, minHeight: %s", Integer.valueOf(oqM), Integer.valueOf(fromDPToPix3));
        if (oqM < fromDPToPix3) {
            oqM = fromDPToPix3;
        }
        oqN = Math.round(((float) (oqM * 4)) / 3.0f);
        x.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", Integer.valueOf(oqM), Integer.valueOf(oqN));
    }

    public static int aYE() {
        return oqM;
    }

    public static int aYF() {
        return oqN;
    }

    public static int aYG() {
        return com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), oqJ);
    }
}
