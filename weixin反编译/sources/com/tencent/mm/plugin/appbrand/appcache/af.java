package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class af {
    public static final int VERSION;
    public static final String[] iHD;
    static final a iHE;
    private static Boolean iHF = null;

    enum a {
        CUSTOM,
        DEVELOP,
        STABLE
    }

    static {
        int i = -1;
        try {
            if (ad.cgj()) {
                String aaf = aaf();
                if (!bi.oN(aaf) && e.bO(aaf)) {
                    i = new JSONObject(e.bT(aaf)).optInt("version");
                }
            }
        } catch (Exception e) {
        }
        if (i > 0) {
            VERSION = i;
            iHD = com.tencent.mm.plugin.appbrand.d.a.iPb;
            iHE = a.STABLE;
        } else {
            VERSION = 102;
            iHD = com.tencent.mm.plugin.appbrand.d.a.iPb;
            iHE = a.STABLE;
        }
    }

    public static void aae() {
        b.deleteFile(aaf());
    }

    static String aaf() {
        return new File(ah.aak() + "/MockLibInfo.json").getAbsolutePath();
    }

    public static boolean aag() {
        if (iHF == null) {
            ad.cgg();
            iHF = Boolean.valueOf(false);
        }
        return iHF.booleanValue();
    }

    public static InputStream openRead(String str) {
        String pQ = a.pQ(str);
        switch (iHE) {
            case CUSTOM:
                return pY("wxa_library/local" + pQ);
            case DEVELOP:
                return pY("wxa_library/develop" + pQ);
            default:
                return pY("wxa_library" + pQ);
        }
    }

    private static InputStream pY(String str) {
        try {
            return ad.getContext().getAssets().open(str);
        } catch (Exception e) {
            x.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", str, e);
            return null;
        }
    }

    public static WxaPkgWrappingInfo aah() {
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.iJb = VERSION;
        wxaPkgWrappingInfo.iJd = true;
        return wxaPkgWrappingInfo;
    }
}
