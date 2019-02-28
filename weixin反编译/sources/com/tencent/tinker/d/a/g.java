package com.tencent.tinker.d.a;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

public final class g implements Closeable {
    private RandomAccessFile AjN;
    public final LinkedHashMap<String, f> Avs;
    private File Avt;
    private final String filename;
    public String wTu;

    public static class a extends InputStream {
        private final RandomAccessFile Avv;
        private long aqI;
        private long oJ;

        private a(RandomAccessFile randomAccessFile, long j, long j2) {
            this.Avv = randomAccessFile;
            this.oJ = j;
            this.aqI = j2;
        }

        public a(RandomAccessFile randomAccessFile, long j) {
            this(randomAccessFile, j, randomAccessFile.length());
        }

        public final int available() {
            return this.oJ < this.aqI ? 1 : 0;
        }

        public final int read() {
            return e.x(this);
        }

        public final int read(byte[] bArr, int i, int i2) {
            int read;
            synchronized (this.Avv) {
                long j = this.aqI - this.oJ;
                if (((long) i2) > j) {
                    i2 = (int) j;
                }
                this.Avv.seek(this.oJ);
                read = this.Avv.read(bArr, i, i2);
                if (read > 0) {
                    this.oJ += (long) read;
                } else {
                    read = -1;
                }
            }
            return read;
        }

        public final long skip(long j) {
            if (j > this.aqI - this.oJ) {
                j = this.aqI - this.oJ;
            }
            this.oJ += j;
            return j;
        }
    }

    /* renamed from: com.tencent.tinker.d.a.g$1 */
    class AnonymousClass1 implements Enumeration<f> {
        final /* synthetic */ Iterator abx;

        public AnonymousClass1(Iterator it) {
            this.abx = it;
        }

        public final /* synthetic */ Object nextElement() {
            g.this.cIf();
            return (f) this.abx.next();
        }

        public final boolean hasMoreElements() {
            g.this.cIf();
            return this.abx.hasNext();
        }
    }

    public g(File file) {
        this(file, (byte) 0);
    }

    public g(String str) {
        this(new File(str), (byte) 0);
    }

    private g(File file, byte b) {
        this.Avs = new LinkedHashMap();
        this.filename = file.getPath();
        this.Avt = null;
        this.AjN = new RandomAccessFile(this.filename, "r");
        cIg();
    }

    static void a(String str, long j, String str2, long j2, String str3, int i) {
        throw new ZipException("file name:" + str + ", file size" + j + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j2 + ", " + str3 + " signature not found; was " + Integer.toHexString(i));
    }

    public final void close() {
        RandomAccessFile randomAccessFile = this.AjN;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.AjN = null;
                randomAccessFile.close();
            }
            if (this.Avt != null) {
                this.Avt.delete();
                this.Avt = null;
            }
        }
    }

    public final void cIf() {
        if (this.AjN == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public final f acz(String str) {
        cIf();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        f fVar = (f) this.Avs.get(str);
        if (fVar == null) {
            return (f) this.Avs.get(str + "/");
        }
        return fVar;
    }

    public final InputStream a(f fVar) {
        f acz = acz(fVar.name);
        if (acz == null) {
            return null;
        }
        InputStream aVar;
        RandomAccessFile randomAccessFile = this.AjN;
        synchronized (randomAccessFile) {
            aVar = new a(randomAccessFile, acz.Avq);
            DataInputStream dataInputStream = new DataInputStream(aVar);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (((long) reverseBytes) != 67324752) {
                a(this.filename, randomAccessFile.length(), acz.name, acz.Avq, "Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            if ((reverseBytes2 & 1) != 0) {
                throw new ZipException("Invalid General Purpose Bit Flag: " + reverseBytes2);
            }
            dataInputStream.skipBytes(18);
            reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            int reverseBytes3 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            dataInputStream.close();
            aVar.skip((long) (reverseBytes2 + reverseBytes3));
            if (acz.Avn == 0) {
                aVar.aqI = aVar.oJ + acz.size;
            } else {
                aVar.aqI = aVar.oJ + acz.Avm;
            }
        }
        return aVar;
    }

    private void cIg() {
        long j = 0;
        long length = this.AjN.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + this.AjN.length());
        }
        this.AjN.seek(0);
        if (((long) Integer.reverseBytes(this.AjN.readInt())) != 67324752) {
            throw new ZipException("Not a zip archive");
        }
        long j2 = length - HardCoderJNI.ACTION_ALLOC_MEMORY;
        if (j2 < 0) {
            j2 = length;
        } else {
            j = j2;
            j2 = length;
        }
        do {
            this.AjN.seek(j2);
            if (((long) Integer.reverseBytes(this.AjN.readInt())) != 101010256) {
                j2--;
            } else {
                byte[] bArr = new byte[18];
                this.AjN.readFully(bArr);
                b a = c.a(bArr, 18, ByteOrder.LITTLE_ENDIAN);
                int readShort = a.readShort() & 65535;
                int readShort2 = a.readShort() & 65535;
                int readShort3 = a.readShort() & 65535;
                int readShort4 = a.readShort() & 65535;
                a.cIe();
                long readInt = ((long) a.readInt()) & 4294967295L;
                int readShort5 = a.readShort() & 65535;
                if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
                    if (readShort5 > 0) {
                        bArr = new byte[readShort5];
                        this.AjN.readFully(bArr);
                        this.wTu = new String(bArr, 0, bArr.length, d.UTF_8);
                    }
                    InputStream bufferedInputStream = new BufferedInputStream(new a(this.AjN, readInt), Downloads.RECV_BUFFER_SIZE);
                    byte[] bArr2 = new byte[46];
                    for (readShort5 = 0; readShort5 < readShort3; readShort5++) {
                        f fVar = new f(bArr2, bufferedInputStream, d.UTF_8);
                        if (fVar.Avq >= readInt) {
                            throw new ZipException("Local file header offset is after central directory");
                        }
                        String str = fVar.name;
                        if (this.Avs.put(str, fVar) != null) {
                            throw new ZipException("Duplicate entry name: " + str);
                        }
                    }
                    return;
                }
                throw new ZipException("Spanned archives not supported");
            }
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }
}
