package com.tencent.mm.plugin.a;

import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

public final class d {
    private static final int ihb = Q(new byte[]{(byte) 102, (byte) 114, (byte) 101, (byte) 101});
    private static final int ihc = Q(new byte[]{(byte) 106, (byte) 117, (byte) 110, (byte) 107});
    private static final int ihd = Q(new byte[]{(byte) 109, (byte) 100, (byte) 97, (byte) 116});
    private static final int ihe = Q(new byte[]{(byte) 109, (byte) 111, (byte) 111, (byte) 118});
    private static final int ihf = Q(new byte[]{(byte) 112, (byte) 110, (byte) 111, (byte) 116});
    private static final int ihg = Q(new byte[]{(byte) 115, (byte) 107, (byte) 105, (byte) 112});
    private static final int ihh = Q(new byte[]{(byte) 119, (byte) 105, (byte) 100, (byte) 101});
    private static final int ihi = Q(new byte[]{(byte) 80, (byte) 73, (byte) 67, (byte) 84});
    private static final int ihj = Q(new byte[]{(byte) 102, (byte) 116, (byte) 121, (byte) 112});
    private static final int ihk = Q(new byte[]{(byte) 117, (byte) 117, (byte) 105, (byte) 100});
    private static final int ihl = Q(new byte[]{(byte) 99, (byte) 109, (byte) 111, (byte) 118});
    private static final int ihm = Q(new byte[]{(byte) 115, (byte) 116, (byte) 99, (byte) 111});
    private static final int ihn = Q(new byte[]{(byte) 99, (byte) 111, (byte) 54, (byte) 52});

    private static boolean aF(String str, String str2) {
        Exception e;
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        File file = new File(str);
        File file2 = new File(str2);
        if (file.length() != file2.length()) {
            x.w("MicroMsg.FastStart", "check size not right");
            return false;
        }
        long oP = new b().oP(str);
        f fVar = new f();
        fVar.r(str, oP);
        int i = fVar.ihv;
        long oP2 = new b().oP(str2);
        f fVar2 = new f();
        fVar2.r(str2, oP2);
        int i2 = fVar2.ihv;
        if (i2 != i) {
            x.w("MicroMsg.FastStart", "check duration not right");
            return false;
        }
        x.d("MicroMsg.FastStart", "old duration:" + i + " new duration: " + i2);
        i = new Random().nextInt(i2 - 1) + 1;
        if (i + 1 <= i2) {
            i2 = i + 1;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        fVar.a(i, i2, pInt, pInt2);
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        fVar2.a(i, i2, pInt3, pInt4);
        if (pInt4.value != pInt2.value) {
            x.w("MicroMsg.FastStart", "check len not right");
            return false;
        }
        FileInputStream fileInputStream3;
        FileInputStream fileInputStream4;
        try {
            fileInputStream3 = new FileInputStream(file);
            try {
                fileInputStream3.skip((long) pInt.value);
                byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                fileInputStream3.read(bArr);
                fileInputStream4 = new FileInputStream(file2);
                try {
                    fileInputStream4.skip((long) pInt3.value);
                    byte[] bArr2 = new byte[Downloads.RECV_BUFFER_SIZE];
                    fileInputStream3.read(bArr2);
                    if (Arrays.equals(bArr, bArr2)) {
                        x.w("MicroMsg.FastStart", "check data not right");
                        try {
                            fileInputStream3.close();
                        } catch (IOException e2) {
                        }
                        try {
                            fileInputStream4.close();
                        } catch (IOException e3) {
                        }
                        return false;
                    }
                    try {
                        fileInputStream3.close();
                    } catch (IOException e4) {
                    }
                    try {
                        fileInputStream4.close();
                    } catch (IOException e5) {
                    }
                    return true;
                } catch (Exception e6) {
                    e = e6;
                    fileInputStream = fileInputStream4;
                    fileInputStream2 = fileInputStream3;
                    try {
                        x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream4 = fileInputStream;
                        fileInputStream3 = fileInputStream2;
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (fileInputStream4 != null) {
                            try {
                                fileInputStream4.close();
                            } catch (IOException e10) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream3 != null) {
                        fileInputStream3.close();
                    }
                    if (fileInputStream4 != null) {
                        fileInputStream4.close();
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                fileInputStream = null;
                fileInputStream2 = fileInputStream3;
                x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return true;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream4 = null;
                if (fileInputStream3 != null) {
                    fileInputStream3.close();
                }
                if (fileInputStream4 != null) {
                    fileInputStream4.close();
                }
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
            x.w("MicroMsg.FastStart", "fast start error: " + e.toString());
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return true;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream4 = null;
            fileInputStream3 = null;
            if (fileInputStream3 != null) {
                fileInputStream3.close();
            }
            if (fileInputStream4 != null) {
                fileInputStream4.close();
            }
            throw th;
        }
    }

    private static int Q(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    private static int bC(long j) {
        if (j <= 2147483647L && j >= 0) {
            return (int) j;
        }
        throw new Exception("uint32 value is too large");
    }

    private static boolean a(FileChannel fileChannel, ByteBuffer byteBuffer) {
        byteBuffer.clear();
        int read = fileChannel.read(byteBuffer);
        byteBuffer.flip();
        return read == byteBuffer.capacity();
    }

    private static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                x.w("MicroMsg.FastStart", "Failed to close file: ");
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r9, java.lang.String r10, com.tencent.mm.pointers.PInt r11) {
        /*
        r1 = 0;
        r4 = 0;
        r0 = new java.io.File;
        r0.<init>(r9);
        r5 = new java.io.File;
        r5.<init>(r10);
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0034, all -> 0x0059 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0034, all -> 0x0059 }
        r0 = r3.getChannel();	 Catch:{ Exception -> 0x006b, all -> 0x0062 }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x006b, all -> 0x0062 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x006b, all -> 0x0062 }
        r1 = r2.getChannel();	 Catch:{ Exception -> 0x006f, all -> 0x0065 }
        r0 = a(r0, r1, r11);	 Catch:{ Exception -> 0x006f, all -> 0x0065 }
        if (r0 == 0) goto L_0x0028;
    L_0x0024:
        r0 = aF(r9, r10);	 Catch:{ Exception -> 0x0074, all -> 0x0065 }
    L_0x0028:
        e(r3);
        e(r2);
    L_0x002e:
        if (r0 != 0) goto L_0x0033;
    L_0x0030:
        r5.delete();
    L_0x0033:
        return r0;
    L_0x0034:
        r0 = move-exception;
        r2 = r1;
        r3 = r4;
    L_0x0037:
        r4 = "MicroMsg.FastStart";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0069 }
        r7 = "fast start error: ";
        r6.<init>(r7);	 Catch:{ all -> 0x0069 }
        r0 = r0.toString();	 Catch:{ all -> 0x0069 }
        r0 = r6.append(r0);	 Catch:{ all -> 0x0069 }
        r0 = r0.toString();	 Catch:{ all -> 0x0069 }
        com.tencent.mm.sdk.platformtools.x.w(r4, r0);	 Catch:{ all -> 0x0069 }
        e(r2);
        e(r1);
        r0 = r3;
        goto L_0x002e;
    L_0x0059:
        r0 = move-exception;
        r2 = r1;
    L_0x005b:
        e(r2);
        e(r1);
        throw r0;
    L_0x0062:
        r0 = move-exception;
        r2 = r3;
        goto L_0x005b;
    L_0x0065:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x005b;
    L_0x0069:
        r0 = move-exception;
        goto L_0x005b;
    L_0x006b:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        goto L_0x0037;
    L_0x006f:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x0037;
    L_0x0074:
        r1 = move-exception;
        r8 = r1;
        r1 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r8;
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.a.d.b(java.lang.String, java.lang.String, com.tencent.mm.pointers.PInt):boolean");
    }

    private static boolean a(FileChannel fileChannel, FileChannel fileChannel2, PInt pInt) {
        int bC;
        int i = 0;
        long j = 0;
        ByteBuffer byteBuffer = null;
        ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        long j2 = 0;
        Object obj = null;
        Object obj2 = null;
        long j3 = -1;
        while (a(fileChannel, order)) {
            long j4 = 4294967295L & ((long) order.getInt());
            i = order.getInt();
            if (i == ihj) {
                obj = 1;
                bC = bC(j4);
                byteBuffer = ByteBuffer.allocate(bC).order(ByteOrder.BIG_ENDIAN);
                order.rewind();
                byteBuffer.put(order);
                if (fileChannel.read(byteBuffer) < bC - 8) {
                    obj2 = null;
                    j = j4;
                    break;
                }
                byteBuffer.flip();
                j2 = fileChannel.position();
                j = j4;
            } else if (i == ihe) {
                j = fileChannel.position() - 8;
                if (obj2 == null) {
                    x.d("MicroMsg.FastStart", "it moov before mdat, needn't fast start");
                    pInt.value = 1;
                    return false;
                }
                x.d("MicroMsg.FastStart", "it moov after mdat, need fast start");
                obj2 = 1;
                j3 = j;
                j = j4;
            } else {
                if (i == ihd) {
                    obj2 = 1;
                }
                if (j4 == 1) {
                    order.clear();
                    if (!a(fileChannel, order)) {
                        obj2 = null;
                        j = j4;
                        break;
                    }
                    j4 = order.getLong();
                    if (j4 < 0) {
                        throw new Exception("uint64 value is too large");
                    }
                    fileChannel.position((fileChannel.position() + j4) - 16);
                    j = j4;
                } else {
                    fileChannel.position((fileChannel.position() + j4) - 8);
                    j = j4;
                }
            }
            if (j < 8) {
                x.w("MicroMsg.FastStart", "atom size less 8, it error mp4.");
                return false;
            }
        }
        obj2 = null;
        if (obj == null || r2 == null) {
            x.w("MicroMsg.FastStart", "it can not find moov or ftyp");
            return false;
        } else if (i != ihe || j3 < 0) {
            x.w("MicroMsg.FastStart", "it can not find moov atom");
            return false;
        } else {
            int bC2 = bC(j);
            ByteBuffer order2 = ByteBuffer.allocate(bC2).order(ByteOrder.BIG_ENDIAN);
            order2.clear();
            int read = fileChannel.read(order2, j3);
            order2.flip();
            if ((read == order2.capacity() ? 1 : null) == null) {
                x.w("MicroMsg.FastStart", "failed to read moov atom");
                return false;
            } else if (order2.getInt(12) == ihl) {
                x.w("MicroMsg.FastStart", "this utility does not support compressed moov atoms yet");
                return false;
            } else {
                while (order2.remaining() >= 8) {
                    read = order2.position();
                    i = order2.getInt(read + 4);
                    if (i != ihm && i != ihn) {
                        order2.position(order2.position() + 1);
                    } else if ((((long) order2.getInt(read)) & 4294967295L) > ((long) order2.remaining())) {
                        x.w("MicroMsg.FastStart", "bad atom size");
                        return false;
                    } else {
                        order2.position(read + 12);
                        if (order2.remaining() < 4) {
                            x.w("MicroMsg.FastStart", "malformed atom");
                            return false;
                        }
                        bC = bC((long) order2.getInt());
                        if (i == ihm) {
                            if (order2.remaining() < bC * 4) {
                                x.w("MicroMsg.FastStart", "bad atom size/element count");
                                return false;
                            }
                            for (read = 0; read < bC; read++) {
                                i = order2.getInt(order2.position());
                                int i2 = i + bC2;
                                if (i < 0 && i2 >= 0) {
                                    return false;
                                }
                                order2.putInt(i2);
                            }
                            continue;
                        } else if (i != ihn) {
                            continue;
                        } else if (order2.remaining() < bC * 8) {
                            x.w("MicroMsg.FastStart", "bad atom size/element count");
                            return false;
                        } else {
                            for (read = 0; read < bC; read++) {
                                order2.putLong(order2.getLong(order2.position()) + ((long) bC2));
                            }
                        }
                    }
                }
                fileChannel.position(j2);
                if (byteBuffer != null) {
                    byteBuffer.rewind();
                    fileChannel2.write(byteBuffer);
                }
                order2.rewind();
                fileChannel2.write(order2);
                fileChannel.transferTo(j2, j3 - j2, fileChannel2);
                fileChannel.transferTo(j3 + ((long) bC2), (fileChannel.size() - j3) - ((long) bC2), fileChannel2);
                return true;
            }
        }
    }
}
