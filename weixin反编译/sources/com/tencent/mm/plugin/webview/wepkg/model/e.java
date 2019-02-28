package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.c.b;
import com.tencent.mm.protocal.c.bzh;
import com.tencent.mm.protocal.c.wh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    private static int tTj = 4;
    private static ByteOrder tTk = ByteOrder.BIG_ENDIAN;
    private volatile String gCB = "";
    private File iHM;
    volatile boolean iHO = false;
    private volatile int tTl;
    private volatile int tTm = 0;
    volatile bzh tTn = null;
    private volatile LinkedList<wh> tTo = null;
    private volatile String tTp = "";

    public e(File file) {
        boolean z = false;
        this.iHM = file;
        if (aaj()) {
            z = true;
        }
        this.iHO = z;
    }

    public final m fc(String str, String str2) {
        if (bi.cC(this.tTo) || this.tTm < tTj || bi.oN(str)) {
            x.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
            return null;
        }
        Iterator it = this.tTo.iterator();
        while (it.hasNext()) {
            wh whVar = (wh) it.next();
            if (bi.oM(whVar.wnt).equals(str)) {
                String str3 = whVar.wnv;
                Object obj = (bi.oN(str3) || !(str3.startsWith("video/") || str3.startsWith("audio/"))) ? null : 1;
                if (obj != null) {
                    x.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", str);
                    return null;
                } else if (((long) whVar.kzt) <= 5242880) {
                    try {
                        x.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", str);
                        return new m(whVar.wnv, str2, new b(this.iHM, ((long) this.tTm) + whVar.wnu, (long) whVar.kzt));
                    } catch (IOException e) {
                        x.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", str, Long.valueOf(whVar.wnu), Integer.valueOf(whVar.kzt), whVar.wnv, e.getMessage());
                    }
                } else {
                    x.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", Integer.valueOf(whVar.kzt), Long.valueOf(5242880), str, Long.valueOf(whVar.wnu), whVar.wnv);
                }
            }
        }
        return null;
    }

    private boolean aaj() {
        boolean z = false;
        FileChannel fileChannel = null;
        try {
            fileChannel = new RandomAccessFile(this.iHM, "r").getChannel();
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + e.getMessage());
        }
        if (fileChannel != null) {
            try {
                fileChannel.position(0);
                ByteBuffer allocate = ByteBuffer.allocate(tTj);
                allocate.order(tTk);
                fileChannel.read(allocate);
                this.tTl = allocate.getInt(0);
                z = a(fileChannel);
            } catch (Exception e2) {
                x.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + e2.getMessage());
            } finally {
                b(fileChannel);
            }
        }
        return z;
    }

    private boolean a(FileChannel fileChannel) {
        if (this.tTl <= 0) {
            return false;
        }
        try {
            fileChannel.position((long) tTj);
            ByteBuffer allocate = ByteBuffer.allocate(this.tTl);
            allocate.order(tTk);
            fileChannel.read(allocate);
            byte[] array = allocate.array();
            if (array == null || array.length == 0) {
                return false;
            }
            this.tTn = new bzh();
            this.tTn.aH(array);
            this.tTo = this.tTn.xgm;
            this.tTp = this.tTn.xgn;
            this.gCB = this.tTn.nkL;
            this.tTm = tTj + this.tTl;
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + e.getMessage());
            return false;
        }
    }

    private static void b(FileChannel fileChannel) {
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException e) {
            }
        }
    }
}
