package com.tencent.mm.audio.b;

import android.os.Build;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class g {
    public static final String flH = (e.bnF + "test.wav");
    public static final String flI = (e.bnF + "test.pcm");

    public static class a {
        public byte[] buf;
        public int flJ = 0;
        public boolean flK = false;

        public a(byte[] bArr, int i) {
            this.buf = bArr;
            this.flJ = i;
            this.flK = false;
        }

        public a(byte[] bArr, int i, boolean z) {
            this.buf = bArr;
            this.flJ = i;
            this.flK = z;
        }
    }

    public static class b {
        private static boolean flL;
        private static boolean flM;

        static {
            flL = false;
            flM = false;
            int yw = m.yw();
            x.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(yw));
            if (!bi.oN(Build.CPU_ABI) && !Build.CPU_ABI.contains("armeabi") && !bi.oN(Build.CPU_ABI2) && !Build.CPU_ABI2.contains("armeabi")) {
                x.i("MicroMsg.RecorderUtil", "don't contains armeabi");
                k.b("wechatvoicesilk_v5", g.class.getClassLoader());
                flL = true;
                flM = false;
            } else if ((yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                try {
                    k.b("wechatvoicesilk_v7a", g.class.getClassLoader());
                    flL = true;
                    flM = true;
                } catch (UnsatisfiedLinkError e) {
                    x.e("MicroMsg.RecorderUtil", "load library failed!");
                    flL = false;
                    flM = false;
                }
            } else if ((yw & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                k.b("wechatvoicesilk", g.class.getClassLoader());
                flL = true;
                flM = true;
            } else {
                k.b("wechatvoicesilk_v5", g.class.getClassLoader());
                flL = true;
                flM = false;
            }
            x.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", Boolean.valueOf(flL), Boolean.valueOf(flM));
        }

        public static boolean vx() {
            return flM;
        }
    }

    public static int t(String str, int i) {
        try {
            return bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue(str), i);
        } catch (Exception e) {
            x.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: " + str);
            return i;
        } catch (Error e2) {
            x.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: " + str);
            return i;
        }
    }
}
