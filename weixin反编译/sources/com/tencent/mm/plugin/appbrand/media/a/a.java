package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.InputStream;

public final class a implements d {
    private long currentPosition;
    private String filePath;
    private String iGz;
    public com.tencent.mm.plugin.appbrand.k.a jFB = null;

    public a(String str, String str2) {
        this.filePath = str;
        this.iGz = str2;
        this.jFB = bz(str, str2);
    }

    public final boolean isOpen() {
        return this.jFB != null;
    }

    public final void open() {
        x.i("MicroMsg.WxaAudioDataSource", "open");
        if (this.jFB == null) {
            this.jFB = bz(this.filePath, this.iGz);
        }
        this.currentPosition = 0;
        if (this.jFB != null) {
            this.jFB.seek(0);
        }
    }

    private static com.tencent.mm.plugin.appbrand.k.a bz(String str, String str2) {
        long nanoTime = System.nanoTime();
        if (bi.oN(str2)) {
            x.e("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
            return null;
        }
        ag agVar = new ag(new File(str2));
        if (!agVar.iHO) {
            agVar.close();
            x.e("MicroMsg.WxaAudioDataSource", "pkg invalid");
            return null;
        } else if (agVar.aai()) {
            InputStream qa = agVar.qa(str);
            if (qa == null) {
                agVar.close();
                x.e("MicroMsg.WxaAudioDataSource", "inputstream for %s is null", str);
                return null;
            }
            agVar.close();
            x.d("MicroMsg.WxaAudioDataSource", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
            return (com.tencent.mm.plugin.appbrand.k.a) qa;
        } else {
            agVar.close();
            x.e("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
            return null;
        }
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        int i3 = -1;
        if (this.jFB == null) {
            x.e("MicroMsg.WxaAudioDataSource", "[readAt]inputstream is null");
        } else if (bArr == null || bArr.length <= 0) {
            x.e("MicroMsg.WxaAudioDataSource", "[readAt]bytes is null");
        } else if (j < 0 || i < 0 || i2 <= 0) {
            x.e("MicroMsg.WxaAudioDataSource", "position:%d, offset:%d, size:%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        } else if (bArr == null || i + i2 <= bArr.length) {
            if (((long) i2) + j > getSize()) {
                x.e("MicroMsg.WxaAudioDataSource", "position:%d, size:%d, getSize():%d", Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(getSize()));
            }
            if (this.currentPosition != j) {
                this.jFB.seek((int) j);
                this.currentPosition = j;
            }
            i3 = this.jFB.read(bArr, i, i2);
            if (i3 >= 0) {
                this.currentPosition += (long) i3;
            }
        } else {
            x.e("MicroMsg.WxaAudioDataSource", "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length));
        }
        return i3;
    }

    public final long getSize() {
        if (this.jFB != null) {
            return (long) this.jFB.jMu.limit();
        }
        x.e("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
        return 0;
    }

    public final int JE() {
        String str;
        if (this.jFB == null) {
            this.jFB = bz(this.filePath, this.iGz);
        }
        if (this.jFB == null) {
            x.e("MicroMsg.WxaAudioDataSource", "[getAudioType] inputStream is null");
            return 0;
        } else if (this.filePath.toLowerCase().endsWith(".mp3")) {
            x.d("MicroMsg.WxaAudioDataSource", "[getAudioType] mp3");
            return 2;
        } else if (this.filePath.toLowerCase().contains(".wav")) {
            x.d("MicroMsg.WxaAudioDataSource", "[getAudioType] wav");
            return 3;
        } else if (this.filePath.toLowerCase().contains(".ogg")) {
            x.d("MicroMsg.WxaAudioDataSource", "[getAudioType] ogg");
            return 4;
        } else {
            try {
                byte[] bArr = new byte[64];
                this.jFB.seek(0);
                this.jFB.read(bArr);
                str = new String(bArr);
            } catch (Exception e) {
                x.e("MicroMsg.WxaAudioDataSource", "getAudioType", e);
                str = null;
                return str != null ? 0 : 0;
            } finally {
                str = this.jFB;
                str.seek(0);
                str = null;
                if (str != null) {
                }
            }
            if (str != null && str.contains("ftyp")) {
                x.d("MicroMsg.WxaAudioDataSource", "[getAudioType] aac");
                return 1;
            }
        }
    }

    public final void close() {
        if (this.jFB != null) {
            x.i("MicroMsg.WxaAudioDataSource", "close");
            this.jFB.close();
            this.jFB = null;
        }
    }
}
