package com.tencent.mm.c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public final class a {
    public a fee;
    public b fef = null;

    public static class a {
        static final long feg = ((long) "Micromsg".hashCode());
        public int feh = 0;

        public a(int i) {
            this.feh = i;
        }

        public static a w(byte[] bArr) {
            if (bArr.length == 8) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    j |= ((long) (bArr[i] & 255)) << (i * 8);
                }
                if ((j >> 32) == feg) {
                    return new a((int) j);
                }
            }
            return null;
        }

        static byte[] ah(long j) {
            byte[] bArr = new byte[8];
            for (int i = 0; i < 8; i++) {
                bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
            }
            return bArr;
        }
    }

    public a(b bVar) {
        this.fef = bVar;
    }

    public final int j(File file) {
        try {
            if (cg(file.getAbsolutePath()) != null) {
                System.out.println("Error: duplicate append apk external info!");
                return -1;
            }
            byte[] toByteArray = this.fef.toByteArray();
            byte[] ah = a.ah((a.feg << 32) | ((long) new a(toByteArray.length).feh));
            byte[] bArr = new byte[]{(byte) ((toByteArray.length + 8) % 256), (byte) ((toByteArray.length + 8) / 256)};
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(file.length() - 2);
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(toByteArray);
            fileOutputStream.write(ah);
            fileOutputStream.flush();
            fileOutputStream.close();
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public static a cg(String str) {
        int i = 0;
        if (str != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    i = (int) file.length();
                }
            } catch (Exception e) {
                return null;
            }
        }
        if (i < 8) {
            return null;
        }
        a w = a.w(e(str, i - 8, 8));
        if (w == null || w.feh < 0) {
            return null;
        }
        b bVar = new b();
        bVar.aH(e(str, (i - w.feh) - 8, w.feh));
        a aVar = new a(bVar);
        aVar.fee = w;
        return aVar;
    }

    public static boolean ch(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        a cg = cg(str);
        if (cg == null || cg.fef == null) {
            return false;
        }
        try {
            byte[] bArr = new byte[]{(byte) 0, (byte) 0};
            File file2 = new File(str);
            if (file2.exists()) {
                return cg.fef.apkMd5.equalsIgnoreCase(g.a(file2, (int) ((file.length() - ((long) (cg.fee.feh + 8))) - 2), bArr));
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private static byte[] e(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        int length;
        if (i2 == -1) {
            length = (int) file.length();
        } else {
            length = i2;
        }
        if (i < 0) {
            return null;
        }
        if (length <= 0) {
            return null;
        }
        if (i + length > ((int) file.length())) {
            length = ((int) file.length()) - i;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            byte[] bArr = new byte[length];
            try {
                randomAccessFile.seek((long) i);
                randomAccessFile.readFully(bArr);
                randomAccessFile.close();
                return bArr;
            } catch (Exception e) {
                return bArr;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
