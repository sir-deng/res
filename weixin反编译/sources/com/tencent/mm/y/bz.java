package com.tencent.mm.y;

import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class bz {
    public static boolean hjH = false;
    private static bz hjK = null;
    private ArrayList<String> hjI = new ArrayList();
    private String hjJ = "";

    public bz(String str, boolean z) {
        Throwable e;
        RandomAccessFile randomAccessFile;
        try {
            String format;
            this.hjJ = str + "version_history.cfg";
            randomAccessFile = new RandomAccessFile(this.hjJ, "rw");
            long length = randomAccessFile.length();
            x.i("MicroMsg.VersionHistory", "init fileLen:%d isNewAcc:%b curVer:0x%x path:%s", Long.valueOf(length), Boolean.valueOf(z), Integer.valueOf(d.vHl), this.hjJ);
            if (length <= 0 || length > 10240) {
                randomAccessFile.seek(0);
                if (!z) {
                    format = String.format("%x", new Object[]{Integer.valueOf(536870913)});
                    randomAccessFile.write((format + "\n").getBytes());
                    this.hjI.add(format);
                }
            } else {
                while (randomAccessFile.getFilePointer() < length) {
                    format = bi.aD(randomAccessFile.readLine(), "");
                    if (format.length() != 8) {
                        x.e("MicroMsg.VersionHistory", "Read ver history failed , line len:%d path:%s", Integer.valueOf(format.length()), this.hjJ);
                    } else {
                        try {
                            if (format.startsWith("2")) {
                                this.hjI.add(format);
                            } else {
                                x.e("MicroMsg.VersionHistory", "Read ver history failed , line:%s %s", format, this.hjJ);
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                }
            }
            format = String.format("%x", new Object[]{Integer.valueOf(d.vHl)});
            if (this.hjI.size() == 0 || !format.equals(this.hjI.get(this.hjI.size() - 1))) {
                hjH = true;
                this.hjI.add(format);
                randomAccessFile.seek(length);
                randomAccessFile.write((format + "\n").getBytes());
            }
            format = "";
            int i = 0;
            while (i < this.hjI.size()) {
                String str2 = format + ((String) this.hjI.get(i)) + ";";
                i++;
                format = str2;
            }
            x.i("MicroMsg.VersionHistory", "Read succ isupdate:%b ver:%s file:%s", Boolean.valueOf(hjH), format, this.hjJ);
            try {
                randomAccessFile.close();
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.VersionHistory", e3, "Close Version History file failed.", "");
            }
        } catch (Exception e4) {
            e3 = e4;
            randomAccessFile = null;
            try {
                x.printErrStackTrace("MicroMsg.VersionHistory", e3, "Open Version History file failed.", "");
                try {
                    randomAccessFile.close();
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.VersionHistory", e32, "Close Version History file failed.", "");
                }
                if (hjK != null) {
                    return;
                }
                return;
            } catch (Throwable th) {
                e32 = th;
                try {
                    randomAccessFile.close();
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.VersionHistory", e5, "Close Version History file failed.", "");
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            randomAccessFile = null;
            randomAccessFile.close();
            throw e32;
        }
        if (hjK != null && hjK != this && hjK.hjI.size() < this.hjI.size()) {
            hjK.hjI = this.hjI;
            k.r(this.hjJ, hjK.hjJ, false);
        }
    }

    public static void ig(String str) {
        hjK = new bz(str, true);
    }

    public static String Im() {
        if (hjK == null) {
            return "";
        }
        bz bzVar = hjK;
        String str = "";
        String str2 = str;
        for (int size = 4 >= bzVar.hjI.size() ? 0 : bzVar.hjI.size() - 4; size < bzVar.hjI.size(); size++) {
            str2 = str2 + ((String) bzVar.hjI.get(size)) + ";";
        }
        return str2;
    }
}
