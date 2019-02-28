package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.i.t;

public final class b {
    public int ahS;
    public int ahT;
    public final CryptoInfo ahU;
    public final a ahV;
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;

    @TargetApi(24)
    private static final class a {
        public final CryptoInfo ahU;
        public final Pattern ahW;

        /* synthetic */ a(CryptoInfo cryptoInfo, byte b) {
            this(cryptoInfo);
        }

        private a(CryptoInfo cryptoInfo) {
            this.ahU = cryptoInfo;
            this.ahW = new Pattern(0, 0);
        }
    }

    public b() {
        CryptoInfo cryptoInfo;
        a aVar = null;
        if (t.SDK_INT >= 16) {
            cryptoInfo = new CryptoInfo();
        } else {
            cryptoInfo = null;
        }
        this.ahU = cryptoInfo;
        if (t.SDK_INT >= 24) {
            aVar = new a(this.ahU, (byte) 0);
        }
        this.ahV = aVar;
    }
}
