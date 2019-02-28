package com.tencent.mm.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.zip.ZipException;

public final class c {
    private static final k feq = new k(84298576);
    private static final k fer = new k(50613072);
    private static int fes = 0;
    private static final k fet = new k(101010256);

    private static class a {
        Properties feu;
        byte[] fev;

        private a() {
            this.feu = new Properties();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        final void y(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                c.feq.getBytes();
                byte[] bArr2 = new byte[4];
                wrap.get(bArr2);
                System.out.println("securityPart: " + new k(bArr2).value);
                int i;
                if (c.feq.equals(new k(bArr2))) {
                    if (bArr.length - 4 <= 2) {
                        System.err.println("data.length - securityMarkLength <= 2");
                        return;
                    }
                    bArr2 = new byte[2];
                    wrap.get(bArr2);
                    i = new l(bArr2).value;
                    if ((bArr.length - 4) - 2 < i) {
                        System.err.println("data.length - securityMarkLength - 2 < len");
                        System.err.println("exit");
                        return;
                    }
                    byte[] bArr3 = new byte[i];
                    wrap.get(bArr3);
                    this.feu.load(new ByteArrayInputStream(bArr3));
                    i = ((bArr.length - 4) - i) - 2;
                    if (i > 0) {
                        c.fer.getBytes();
                        bArr3 = new byte[4];
                        wrap.get(bArr3);
                        if (!c.fer.equals(new k(bArr3))) {
                            return;
                        }
                        if (i - 4 <= 2) {
                            System.err.println("data.length - oriMarkLength <= 2");
                            return;
                        }
                        bArr3 = new byte[2];
                        wrap.get(bArr3);
                        int i2 = new l(bArr3).value;
                        if ((i - 4) - 2 < i2) {
                            System.err.println("data.length - oriMarkLength - 2 < len");
                            System.err.println("exit");
                            return;
                        }
                        this.fev = new byte[i2];
                        wrap.get(this.fev);
                    }
                } else if (c.fer.equals(new k(bArr2))) {
                    c.fer.getBytes();
                    if (bArr.length - 4 <= 2) {
                        System.err.println("data.length - oriMarkLength <= 2");
                        return;
                    }
                    bArr2 = new byte[2];
                    wrap.get(bArr2);
                    i = new l(bArr2).value;
                    if ((bArr.length - 4) - 2 < i) {
                        System.err.println("data.length - oriMarkLength - 2 < len");
                        System.err.println("exit");
                        return;
                    }
                    this.fev = new byte[i];
                    wrap.get(this.fev);
                } else {
                    throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
                }
            }
        }

        final byte[] tr() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (this.feu.size() > 0) {
                String str;
                byteArrayOutputStream.write(c.feq.getBytes());
                String str2 = "";
                Iterator it = this.feu.keySet().iterator();
                while (true) {
                    str = str2;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    str2 = new StringBuilder(String.valueOf(str)).append(next).append("=").append(this.feu.getProperty((String) next)).append("\r\n").toString();
                }
                byte[] bytes = str.getBytes();
                byteArrayOutputStream.write(new l(bytes.length).getBytes());
                byteArrayOutputStream.write(bytes);
            }
            if (this.fev != null && this.fev.length > 0) {
                byteArrayOutputStream.write(c.fer.getBytes());
                byteArrayOutputStream.write(new l(this.fev.length).getBytes());
                byteArrayOutputStream.write(this.fev);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    private static byte[] b(RandomAccessFile randomAccessFile) {
        int i = 1;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = fet.getBytes();
        byte read = randomAccessFile.read();
        while (read != (byte) -1) {
            if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        i = 0;
        if (i == 0) {
            System.err.println("archive is not a ZIP archive");
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek((length + 16) + 4);
        if (((long) fes) != (length + 16) + 4) {
            fes = (int) ((length + 16) + 4);
        }
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        System.err.println("readComment:length bytes data = " + x(bArr));
        i = new l(bArr).value;
        if (i == 0) {
            return null;
        }
        bArr = new byte[i];
        randomAccessFile.read(bArr);
        return bArr;
    }

    public static void b(File file, String str) {
        Throwable th;
        byte[] bArr = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                byte[] b = b(randomAccessFile);
                if (b != null) {
                    ByteBuffer wrap = ByteBuffer.wrap(b);
                    feq.getBytes();
                    byte[] bArr2 = new byte[4];
                    wrap.get(bArr2);
                    if (feq.equals(new k(bArr2))) {
                        bArr = b;
                    } else if (fer.equals(new k(bArr2))) {
                        bArr = b;
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.write(fer.getBytes());
                        byteArrayOutputStream.write(new l(b.length).getBytes());
                        byteArrayOutputStream.write(b);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                }
                a aVar = new a();
                aVar.y(bArr);
                aVar.feu.setProperty("apkSecurityCode", str);
                b = aVar.tr();
                randomAccessFile.seek((long) fes);
                randomAccessFile.write(new l(b.length).getBytes());
                randomAccessFile.write(b);
                randomAccessFile.setLength((long) ((b.length + fes) + 2));
                System.err.println("file length is = " + randomAccessFile.length());
                randomAccessFile.close();
                System.err.println("exit writeSecurityCode");
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                System.err.println("exit writeSecurityCode");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            System.err.println("exit writeSecurityCode");
            throw th;
        }
    }

    public static String k(File file) {
        Throwable th;
        String str = null;
        System.err.println("enter getSecurityCode");
        System.err.println("apkFile filename:" + file.getName());
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] b = b(randomAccessFile);
                if (b == null) {
                    System.err.println("null == readComment");
                    System.err.println("exit");
                    randomAccessFile.close();
                    System.err.println("exit getSecurityCode");
                } else {
                    a aVar = new a();
                    aVar.y(b);
                    str = aVar.feu.getProperty("apkSecurityCode");
                    randomAccessFile.close();
                    System.err.println("exit getSecurityCode");
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                System.err.println("exit getSecurityCode");
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            randomAccessFile = null;
            th = th4;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            System.err.println("exit getSecurityCode");
            throw th;
        }
    }

    private static String x(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            stringBuilder.append(bArr[i]);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}
