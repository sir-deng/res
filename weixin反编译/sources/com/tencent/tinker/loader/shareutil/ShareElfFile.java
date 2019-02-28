package com.tencent.tinker.loader.shareutil;

import com.tencent.wcdb.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ShareElfFile implements Closeable {
    private final FileInputStream AtR;
    private final Map<String, SectionHeader> AtS = new HashMap();
    public ElfHeader AtT = null;
    public ProgramHeader[] AtU = null;
    public SectionHeader[] AtV = null;

    public static class ElfHeader {
        public final byte[] AtW;
        public final short AtX;
        public final short AtY;
        public final int AtZ;
        public final long Aua;
        public final long Aub;
        public final long Auc;
        public final int Aud;
        public final short Aue;
        public final short Auf;
        public final short Aug;
        public final short Auh;
        public final short Aui;
        public final short Auj;

        /* synthetic */ ElfHeader(FileChannel fileChannel, byte b) {
            this(fileChannel);
        }

        private ElfHeader(FileChannel fileChannel) {
            this.AtW = new byte[16];
            fileChannel.position(0);
            fileChannel.read(ByteBuffer.wrap(this.AtW));
            if (this.AtW[0] == Byte.MAX_VALUE && this.AtW[1] == (byte) 69 && this.AtW[2] == (byte) 76 && this.AtW[3] == (byte) 70) {
                ShareElfFile.x(this.AtW[4], 2, "bad elf class: " + this.AtW[4]);
                ShareElfFile.x(this.AtW[5], 2, "bad elf data encoding: " + this.AtW[5]);
                ByteBuffer allocate = ByteBuffer.allocate(this.AtW[4] == (byte) 1 ? 36 : 48);
                allocate.order(this.AtW[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                ShareElfFile.a(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.AtX = allocate.getShort();
                this.AtY = allocate.getShort();
                this.AtZ = allocate.getInt();
                ShareElfFile.x(this.AtZ, 1, "bad elf version: " + this.AtZ);
                switch (this.AtW[4]) {
                    case (byte) 1:
                        this.Aua = (long) allocate.getInt();
                        this.Aub = (long) allocate.getInt();
                        this.Auc = (long) allocate.getInt();
                        break;
                    case (byte) 2:
                        this.Aua = allocate.getLong();
                        this.Aub = allocate.getLong();
                        this.Auc = allocate.getLong();
                        break;
                    default:
                        throw new IOException("Unexpected elf class: " + this.AtW[4]);
                }
                this.Aud = allocate.getInt();
                this.Aue = allocate.getShort();
                this.Auf = allocate.getShort();
                this.Aug = allocate.getShort();
                this.Auh = allocate.getShort();
                this.Aui = allocate.getShort();
                this.Auj = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[]{Byte.valueOf(this.AtW[0]), Byte.valueOf(this.AtW[1]), Byte.valueOf(this.AtW[2]), Byte.valueOf(this.AtW[3])}));
        }
    }

    public static class ProgramHeader {
        public final int Auk;
        public final int Aul;
        public final long Aum;
        public final long Aun;
        public final long Auo;
        public final long Aup;
        public final long Auq;
        public final long Aur;

        /* synthetic */ ProgramHeader(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        private ProgramHeader(ByteBuffer byteBuffer, int i) {
            switch (i) {
                case 1:
                    this.Auk = byteBuffer.getInt();
                    this.Aum = (long) byteBuffer.getInt();
                    this.Aun = (long) byteBuffer.getInt();
                    this.Auo = (long) byteBuffer.getInt();
                    this.Aup = (long) byteBuffer.getInt();
                    this.Auq = (long) byteBuffer.getInt();
                    this.Aul = byteBuffer.getInt();
                    this.Aur = (long) byteBuffer.getInt();
                    return;
                case 2:
                    this.Auk = byteBuffer.getInt();
                    this.Aul = byteBuffer.getInt();
                    this.Aum = byteBuffer.getLong();
                    this.Aun = byteBuffer.getLong();
                    this.Auo = byteBuffer.getLong();
                    this.Aup = byteBuffer.getLong();
                    this.Auq = byteBuffer.getLong();
                    this.Aur = byteBuffer.getLong();
                    return;
                default:
                    throw new IOException("Unexpected elf class: " + i);
            }
        }
    }

    public static class SectionHeader {
        public final long AuA;
        public final long AuB;
        public String AuC;
        public final int Aus;
        public final int Aut;
        public final long Auu;
        public final long Auv;
        public final long Auw;
        public final long Aux;
        public final int Auy;
        public final int Auz;

        /* synthetic */ SectionHeader(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        private SectionHeader(ByteBuffer byteBuffer, int i) {
            switch (i) {
                case 1:
                    this.Aus = byteBuffer.getInt();
                    this.Aut = byteBuffer.getInt();
                    this.Auu = (long) byteBuffer.getInt();
                    this.Auv = (long) byteBuffer.getInt();
                    this.Auw = (long) byteBuffer.getInt();
                    this.Aux = (long) byteBuffer.getInt();
                    this.Auy = byteBuffer.getInt();
                    this.Auz = byteBuffer.getInt();
                    this.AuA = (long) byteBuffer.getInt();
                    this.AuB = (long) byteBuffer.getInt();
                    break;
                case 2:
                    this.Aus = byteBuffer.getInt();
                    this.Aut = byteBuffer.getInt();
                    this.Auu = byteBuffer.getLong();
                    this.Auv = byteBuffer.getLong();
                    this.Auw = byteBuffer.getLong();
                    this.Aux = byteBuffer.getLong();
                    this.Auy = byteBuffer.getInt();
                    this.Auz = byteBuffer.getInt();
                    this.AuA = byteBuffer.getLong();
                    this.AuB = byteBuffer.getLong();
                    break;
                default:
                    throw new IOException("Unexpected elf class: " + i);
            }
            this.AuC = null;
        }
    }

    static /* synthetic */ void x(int i, int i2, String str) {
        if (i <= 0 || i > i2) {
            throw new IOException(str);
        }
    }

    public ShareElfFile(File file) {
        int i;
        int i2 = 0;
        this.AtR = new FileInputStream(file);
        FileChannel channel = this.AtR.getChannel();
        this.AtT = new ElfHeader(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(FileUtils.S_IWUSR);
        allocate.limit(this.AtT.Auf);
        allocate.order(this.AtT.AtW[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.AtT.Aub);
        this.AtU = new ProgramHeader[this.AtT.Aug];
        for (i = 0; i < this.AtU.length; i++) {
            a(channel, allocate, "failed to read phdr.");
            this.AtU[i] = new ProgramHeader(allocate, this.AtT.AtW[4], (byte) 0);
        }
        channel.position(this.AtT.Auc);
        allocate.limit(this.AtT.Auh);
        this.AtV = new SectionHeader[this.AtT.Aui];
        for (i = 0; i < this.AtV.length; i++) {
            a(channel, allocate, "failed to read shdr.");
            this.AtV[i] = new SectionHeader(allocate, this.AtT.AtW[4], (byte) 0);
        }
        if (this.AtT.Auj > (short) 0) {
            SectionHeader sectionHeader = this.AtV[this.AtT.Auj];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) sectionHeader.Aux);
            this.AtR.getChannel().position(sectionHeader.Auw);
            a(this.AtR.getChannel(), allocate2, "failed to read section: " + sectionHeader.AuC);
            SectionHeader[] sectionHeaderArr = this.AtV;
            int length = sectionHeaderArr.length;
            while (i2 < length) {
                SectionHeader sectionHeader2 = sectionHeaderArr[i2];
                allocate2.position(sectionHeader2.Aus);
                sectionHeader2.AuC = x(allocate2);
                this.AtS.put(sectionHeader2.AuC, sectionHeader2);
                i2++;
            }
        }
    }

    public static int ac(File file) {
        Throwable th;
        InputStream inputStream;
        try {
            byte[] bArr = new byte[4];
            InputStream fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                if (bArr[0] == (byte) 100 && bArr[1] == (byte) 101 && bArr[2] == (byte) 121 && bArr[3] == (byte) 10) {
                    try {
                        fileInputStream.close();
                        return 0;
                    } catch (Throwable th2) {
                        return 0;
                    }
                } else if (bArr[0] == Byte.MAX_VALUE && bArr[1] == (byte) 69 && bArr[2] == (byte) 76 && bArr[3] == (byte) 70) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                    }
                    return 1;
                } else {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                    }
                    return -1;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                    }
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static void a(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
        }
        byteBuffer.flip();
    }

    private static String x(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != (byte) 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public void close() {
        this.AtR.close();
        this.AtS.clear();
        this.AtU = null;
        this.AtV = null;
    }
}
