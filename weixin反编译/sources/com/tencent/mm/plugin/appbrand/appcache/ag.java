package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Map;

public final class ag implements Closeable {
    public static final ByteOrder iHL = ByteOrder.BIG_ENDIAN;
    private volatile int aIt;
    public final File iHM;
    private volatile FileChannel iHN;
    public volatile boolean iHO;
    private volatile int iHP;
    private volatile int iHQ;
    private volatile int iHR;
    public volatile Map<String, a> iHS;
    public volatile FileStructStat iHT;

    public static class a {
        public final String fileName;
        public final String iHU;
        public final int iHV;
        public final int iHW;

        public a(String str, String str2, int i, int i2) {
            this.iHU = str;
            this.fileName = str2;
            this.iHV = i;
            this.iHW = i2;
        }
    }

    public ag(File file) {
        int i;
        boolean z = true;
        this.iHN = null;
        this.iHO = true;
        this.aIt = -1;
        this.iHP = 0;
        this.iHQ = 0;
        this.iHR = -1;
        this.iHS = null;
        this.iHM = file;
        if (this.iHM == null || !this.iHM.exists()) {
            i = 0;
        } else if (this.iHM.length() <= 14) {
            i = 0;
        } else {
            boolean i2 = true;
        }
        if (i2 == 0 || !aaj()) {
            z = false;
        }
        this.iHO = z;
    }

    public ag(String str) {
        this(new File(str));
    }

    public final void close() {
        if (this.iHN != null) {
            try {
                this.iHN.close();
                this.iHN = null;
            } catch (IOException e) {
            }
        }
    }

    public final a pZ(String str) {
        int i = 0;
        if (this.iHS == null || bi.oN(str)) {
            String str2 = "MicroMsg.AppBrandWxaPkg";
            String str3 = "openReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.iHS == null);
            if (this.iHS != null) {
                i = this.iHS.size();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = str;
            x.e(str2, str3, objArr);
            return null;
        }
        return (a) this.iHS.get(a.pQ(str));
    }

    public final InputStream qa(String str) {
        a pZ = pZ(str);
        if (pZ == null) {
            return null;
        }
        try {
            ByteBuffer map = this.iHN.map(MapMode.READ_ONLY, (long) pZ.iHV, (long) pZ.iHW);
            map.order(iHL);
            map.limit(pZ.iHW);
            return new com.tencent.mm.plugin.appbrand.k.a(map);
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandWxaPkg", "openReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", str, Integer.valueOf(pZ.iHV), Integer.valueOf(pZ.iHW), bi.i(e));
            return null;
        }
    }

    public final boolean aai() {
        if (!this.iHO || this.iHN == null || this.iHP <= 4) {
            x.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", Boolean.valueOf(this.iHO), this.iHN, Integer.valueOf(this.iHQ));
            return false;
        } else if (this.iHS != null && this.iHR >= 0 && this.iHR == this.iHS.size()) {
            return true;
        } else {
            try {
                this.iHN.position(14);
                ByteBuffer allocate = ByteBuffer.allocate(this.iHP);
                allocate.order(iHL);
                this.iHN.read(allocate);
                byte[] array = allocate.array();
                this.iHR = a.A(array, 0);
                Map aVar = new android.support.v4.e.a();
                a aVar2 = null;
                int i = 4;
                for (int i2 = 0; i2 < this.iHR; i2++) {
                    int A = a.A(array, i);
                    i += 4;
                    String str = new String(array, i, A);
                    i += A;
                    int A2 = a.A(array, i);
                    i += 4;
                    int A3 = a.A(array, i);
                    i += 4;
                    aVar2 = new a(this.iHM.getAbsolutePath(), str, A2, A3);
                    aVar.put(str, aVar2);
                }
                this.iHS = aVar;
                if (aVar2 == null || ((long) (aVar2.iHV + aVar2.iHW)) <= this.iHM.length()) {
                    return true;
                }
                x.e("MicroMsg.AppBrandWxaPkg", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", Integer.valueOf(aVar2.iHV), Integer.valueOf(aVar2.iHW), Long.valueOf(this.iHM.length()));
                return false;
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", bi.i(e));
                return false;
            }
        }
    }

    private boolean aaj() {
        if (this.iHN == null) {
            try {
                this.iHN = new RandomAccessFile(this.iHM, "r").getChannel();
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", bi.i(e));
            }
        }
        if (this.iHN == null) {
            return false;
        }
        try {
            this.iHN.position(0);
            ByteBuffer allocate = ByteBuffer.allocate(14);
            allocate.order(iHL);
            this.iHN.read(allocate);
            if ((byte) -66 != allocate.get(0) || (byte) -19 != allocate.get(13)) {
                return false;
            }
            byte[] array = allocate.array();
            this.aIt = a.A(array, 1);
            this.iHP = a.A(array, 5);
            this.iHQ = a.A(array, 9);
            return true;
        } catch (Throwable e2) {
            x.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", bi.i(e2));
        }
    }
}
