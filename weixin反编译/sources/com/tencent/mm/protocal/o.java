package com.tencent.mm.protocal;

import com.tencent.mm.a.c;
import com.tencent.mm.a.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class o {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public int fEo = 0;
        public int fvG = 0;
        public int hQv = 0;
        public String vIm = "";
        public byte[] vIn = new byte[0];

        private byte[] cew() {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(this.hQv);
                dataOutputStream.writeShort(this.vIm.getBytes().length);
                dataOutputStream.write(this.vIm.getBytes());
                dataOutputStream.writeShort(this.vIn.length);
                dataOutputStream.write(this.vIn);
                dataOutputStream.close();
            } catch (IOException e) {
                x.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + e.getMessage());
            }
            return byteArrayOutputStream.toByteArray();
        }

        private byte[] bh(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeByte(this.fvG);
                dataOutputStream.writeByte(this.fEo);
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            } catch (IOException e) {
                x.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + e.getMessage());
            }
            return byteArrayOutputStream.toByteArray();
        }

        public final byte[] Hw() {
            byte[] cew = cew();
            PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, cew, o.TU(this.vHU));
            return bh(pByteArray.value);
        }

        public final int Hx() {
            return 10;
        }

        public final int getCmdId() {
            return 8;
        }

        public final boolean cev() {
            return true;
        }

        public final boolean KN() {
            return false;
        }
    }

    public static class b extends e implements k.c {
        public byte[] content;
        public String deviceID;
        private int fEo;
        private int fvG;
        public String hOy;
        private int hQv;

        public b() {
            this.hOy = "";
            this.content = new byte[0];
            this.deviceID = "";
            this.fvG = 0;
            this.fEo = 0;
            this.hQv = 0;
            this.hOy = "";
            this.content = new byte[0];
        }

        public final int getCmdId() {
            return 8;
        }

        public final boolean cev() {
            return true;
        }

        private byte[] bi(byte[] bArr) {
            if (bArr == null || bArr.length < 2) {
                x.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
                return null;
            }
            byte[] bArr2 = new byte[(bArr.length - 2)];
            try {
                InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                this.fvG = dataInputStream.readByte();
                this.fEo = dataInputStream.readByte();
                dataInputStream.readFully(bArr2);
                x.d("MicroMsg.MMDirectSend", "cmdId:" + this.fvG + ", flag=" + this.fEo + ", tail len=" + bArr2.length);
                byteArrayInputStream.close();
                return bArr2;
            } catch (IOException e) {
                x.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e.getMessage());
                return bArr2;
            }
        }

        public final int E(byte[] bArr) {
            byte[] TU = o.TU(this.deviceID);
            PByteArray pByteArray = new PByteArray();
            if (c.b(pByteArray, bi(bArr), TU) != 0) {
                byte[] bArr2 = new byte[16];
                for (int i = 0; i < 16; i++) {
                    bArr2[i] = (byte) 0;
                }
                if (c.b(pByteArray, bi(bArr), bArr2) != 0) {
                    x.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", bi.bx(TU));
                    return -1;
                }
            }
            byte[] bArr3 = pByteArray.value;
            if (bArr3 == null) {
                x.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
                return 0;
            }
            try {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr3));
                this.hQv = dataInputStream.readInt();
                x.d("MicroMsg.MMDirectSend", "seq=" + this.hQv);
                short readShort = dataInputStream.readShort();
                if (readShort < (short) 0) {
                    throw new IOException("sender empty");
                }
                byte[] bArr4 = new byte[readShort];
                dataInputStream.readFully(bArr4);
                this.hOy = new String(bArr4);
                x.d("MicroMsg.MMDirectSend", "recievers len=" + readShort + ", sender=" + this.hOy);
                readShort = dataInputStream.readShort();
                if (readShort < (short) 0) {
                    throw new IOException("content empty");
                }
                this.content = new byte[readShort];
                dataInputStream.readFully(this.content);
                x.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
                return 0;
            } catch (IOException e) {
                x.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e.getMessage());
                return 0;
            }
        }
    }

    static /* synthetic */ byte[] TU(String str) {
        Object obj = new byte[16];
        System.arraycopy(str.getBytes(), 0, obj, 0, 15);
        obj[15] = null;
        x.d("MicroMsg.MMDirectSend", "new direct send: key=%s", bi.bx(g.t(obj)));
        return g.t(obj);
    }
}
