package com.tencent.mm.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public final class q {
    public static byte[] q(byte[] bArr) {
        Throwable e;
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (!deflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                }
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Zlib", e2, "", new Object[0]);
                }
            } catch (Exception e3) {
                e2 = e3;
            } catch (OutOfMemoryError e4) {
                throw new OutOfMemoryError("crash upload data length:" + bArr.length);
            }
        } catch (Exception e5) {
            e2 = e5;
            byteArrayOutputStream = null;
            try {
                x.printErrStackTrace("MicroMsg.Zlib", e2, "", new Object[0]);
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Zlib", e22, "", new Object[0]);
                    }
                }
                deflater.end();
                return bArr;
            } catch (Throwable th) {
                e22 = th;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e6) {
                        x.printErrStackTrace("MicroMsg.Zlib", e6, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (OutOfMemoryError e7) {
            byteArrayOutputStream = null;
            throw new OutOfMemoryError("crash upload data length:" + bArr.length);
        } catch (Throwable th2) {
            e22 = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw e22;
        }
        deflater.end();
        return bArr;
    }

    public static byte[] v(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        Throwable e = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (!inflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Zlib", e2, "", new Object[0]);
            }
        } catch (Exception e3) {
            e = e3;
            x.printErrStackTrace("MicroMsg.Zlib", e, "exception when loop read byte", new Object[0]);
            try {
                byteArrayOutputStream.close();
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.Zlib", e22, "", new Object[0]);
            }
        } catch (Throwable e4) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable e5) {
                x.printErrStackTrace("MicroMsg.Zlib", e5, "", new Object[0]);
            }
            throw e4;
        }
        inflater.end();
        if (e4 == null) {
            return bArr;
        }
        throw new Exception(e4);
    }
}
