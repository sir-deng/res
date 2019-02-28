package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public String mMessage;
    public int nFO;
    public int tgN = 0;

    private a(int i, String str) {
        this.nFO = i;
        this.mMessage = str;
    }

    public static a aR(int i, String str) {
        int i2 = 6;
        int i3 = i.vfa;
        if (i > -15001) {
            switch (i) {
                case 0:
                    i3 = i.veZ;
                    i2 = i;
                    break;
                case 1:
                    i3 = i.vfb;
                    i2 = i;
                    break;
                case 3:
                case 105:
                    i2 = 3;
                    str = "Google Play not install";
                    break;
                case 6:
                    return new a(6, str);
                case 103:
                case 104:
                case 100000002:
                    i2 = 100000002;
                    i3 = i.veY;
                    break;
                case 106:
                case 100000001:
                    i3 = i.vfa;
                    break;
                case 109:
                    i3 = i.vfc;
                    i2 = i;
                    break;
                case 110:
                    i3 = i.vfe;
                    i2 = i;
                    break;
                case 111:
                    i3 = i.vff;
                    i2 = i;
                    break;
                case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                    i3 = i.vfd;
                    i2 = i;
                    break;
                case 113:
                    i3 = i.vfa;
                    i2 = i;
                    break;
                default:
                    i3 = i.vfa;
                    break;
            }
        }
        i2 = i;
        x.i("MicroMsg.IapResult", "code : " + i + ", errMsg : " + str + ", convert to errCode : " + i2);
        if (bi.oN(str)) {
            return new a(i2, ad.getContext().getString(i3));
        }
        return new a(i2, str);
    }

    public final boolean bOa() {
        return this.nFO == 104 || this.nFO == 100000002;
    }

    public final boolean isFailure() {
        return ((this.nFO == 0) || bOa()) ? false : true;
    }

    public final String toString() {
        return "IapResult: " + this.mMessage;
    }
}
