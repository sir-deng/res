package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.a;

import com.tencent.mm.sdk.platformtools.x;

public final class d implements a {
    private long jzd;
    private int jze;
    private long jzf;
    private int mChannels;

    public final void g(long j, int i) {
        this.jzd = j;
        this.mChannels = 1;
        this.jze = 16;
        this.jzf = ((((long) this.jze) * this.jzd) * ((long) this.mChannels)) / 8;
    }

    public final byte[] W(byte[] bArr) {
        long length = 36 + ((long) bArr.length);
        x.i("MicroMsg.WAVEncoder", "alvinluo mSampleRate: %d, channel: %d, byteRate: %d", Long.valueOf(this.jzd), Integer.valueOf(this.mChannels), Long.valueOf(this.jzf));
        long j = this.jzd;
        int i = this.mChannels;
        long j2 = this.jzf;
        Object obj = new byte[]{(byte) 82, (byte) 73, (byte) 70, (byte) 70, (byte) ((int) (255 & length)), (byte) ((int) ((length >> 8) & 255)), (byte) ((int) ((length >> 16) & 255)), (byte) ((int) ((length >> 24) & 255)), (byte) 87, (byte) 65, (byte) 86, (byte) 69, (byte) 102, (byte) 109, (byte) 116, (byte) 32, (byte) 16, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) i, (byte) 0, (byte) ((int) (255 & j)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) (255 & j2)), (byte) ((int) ((j2 >> 8) & 255)), (byte) ((int) ((j2 >> 16) & 255)), (byte) ((int) ((j2 >> 24) & 255)), (byte) ((i * 16) / 8), (byte) 0, (byte) this.jze, (byte) 0, (byte) 100, (byte) 97, (byte) 116, (byte) 97, (byte) ((int) (255 & r2)), (byte) ((int) ((r2 >> 8) & 255)), (byte) ((int) ((r2 >> 16) & 255)), (byte) ((int) ((r2 >> 24) & 255))};
        Object obj2 = new byte[(bArr.length + 44)];
        System.arraycopy(obj, 0, obj2, 0, 44);
        System.arraycopy(bArr, 0, obj2, 44, bArr.length);
        x.i("MicroMsg.WAVEncoder", "alvinluo wav totalAudioLen: %d, totalDataLen: %d, wavHeader length: %d, encodedDataLen: %d", Long.valueOf(r2), Long.valueOf(length), Integer.valueOf(44), Integer.valueOf(obj2.length));
        return obj2;
    }
}
