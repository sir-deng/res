package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class c {
    private TRVADNative Aac;
    private int iaf;
    private int jGZ;

    public static class a {
        public int Aad = 0;
        public int Aae = 256;
        public int Aaf = WXMediaMessage.TITLE_LENGTH_LIMIT;
        private int Aag = 0;
        public int Aah = 0;
    }

    public c(int i) {
        this.Aac = new TRVADNative();
        this.iaf = i;
        this.jGZ = 5000000;
    }

    public c() {
        this.Aac = new TRVADNative();
        this.iaf = 500000;
        this.jGZ = 10000000;
    }

    public final int start() {
        int mfeInit = this.Aac.mfeInit(this.iaf, this.jGZ);
        if (mfeInit == 0) {
            mfeInit = this.Aac.mfeOpen();
            if (mfeInit == 0) {
                mfeInit = this.Aac.mfeEnableNoiseDetection(true);
                if (mfeInit == 0) {
                    mfeInit = this.Aac.mfeStart();
                }
            }
        }
        return mfeInit == 0 ? 0 : -1;
    }

    public final int stop() {
        int mfeStop = this.Aac.mfeStop();
        if (mfeStop == 0) {
            mfeStop = this.Aac.mfeClose();
            if (mfeStop == 0) {
                mfeStop = this.Aac.mfeExit();
            }
        }
        return mfeStop == 0 ? 0 : -1;
    }

    public final synchronized void a(short[] sArr, int i, a aVar) {
        double d = 26.0d;
        int i2 = 0;
        synchronized (this) {
            if (i > 0) {
                switch (this.Aac.mfeSendData(sArr, i)) {
                    case 1:
                        aVar.Aad = 1;
                        break;
                    case 2:
                        aVar.Aad = 2;
                        break;
                    case 3:
                        aVar.Aad = 3;
                        break;
                    default:
                        aVar.Aad = 0;
                        break;
                }
                int i3 = 0;
                while (i2 < i) {
                    i3 = (int) (((double) i3) + (Math.sqrt((double) (sArr[i2] * sArr[i2])) / ((double) i)));
                    i2++;
                }
                if (i3 < 100) {
                    d = 0.0d;
                } else if (i3 <= 16383) {
                    d = 26.0d * ((((double) i3) - 100.0d) / 32667.0d);
                }
                aVar.Aah = (int) d;
                new StringBuilder("volumn��").append(aVar.Aah);
            }
        }
    }
}
