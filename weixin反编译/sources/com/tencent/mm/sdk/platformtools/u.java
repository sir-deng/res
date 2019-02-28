package com.tencent.mm.sdk.platformtools;

import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;

public final class u {
    private ByteBuffer byteBuffer;
    private boolean xnf;

    public final int bt(byte[] bArr) {
        boolean z = (bArr == null || bArr.length == 0) ? true : bArr[0] != (byte) 123 ? true : bArr[bArr.length + -1] != (byte) 125 ? true : false;
        if (z) {
            this.byteBuffer = null;
            return -1;
        }
        this.byteBuffer = ByteBuffer.wrap(bArr);
        this.byteBuffer.position(1);
        this.xnf = false;
        return 0;
    }

    public final int getInt() {
        if (!this.xnf) {
            return this.byteBuffer.getInt();
        }
        throw new Exception("Buffer For Build");
    }

    public final long getLong() {
        if (!this.xnf) {
            return this.byteBuffer.getLong();
        }
        throw new Exception("Buffer For Build");
    }

    public final byte[] getBuffer() {
        if (this.xnf) {
            throw new Exception("Buffer For Build");
        }
        short s = this.byteBuffer.getShort();
        if (s > (short) 2048) {
            this.byteBuffer = null;
            throw new Exception("Buffer String Length Error");
        } else if (s == (short) 0) {
            return new byte[0];
        } else {
            byte[] bArr = new byte[s];
            this.byteBuffer.get(bArr, 0, s);
            return bArr;
        }
    }

    public final String getString() {
        if (this.xnf) {
            throw new Exception("Buffer For Build");
        }
        short s = this.byteBuffer.getShort();
        if (s > (short) 2048) {
            this.byteBuffer = null;
            throw new Exception("Buffer String Length Error");
        } else if (s == (short) 0) {
            return "";
        } else {
            byte[] bArr = new byte[s];
            this.byteBuffer.get(bArr, 0, s);
            return new String(bArr, "UTF-8");
        }
    }

    public final void Du(int i) {
        this.byteBuffer.position(this.byteBuffer.position() + i);
    }

    public final void cfI() {
        if (this.xnf) {
            throw new Exception("Buffer For Build");
        }
        short s = this.byteBuffer.getShort();
        if (s > (short) 2048) {
            this.byteBuffer = null;
            throw new Exception("Buffer String Length Error");
        } else if (s != (short) 0) {
            this.byteBuffer.position(s + this.byteBuffer.position());
        }
    }

    public final boolean cfJ() {
        return this.byteBuffer.limit() - this.byteBuffer.position() <= 1;
    }

    public final int cfK() {
        this.byteBuffer = ByteBuffer.allocate(Downloads.RECV_BUFFER_SIZE);
        this.byteBuffer.put((byte) 123);
        this.xnf = true;
        return 0;
    }

    private int Dv(int i) {
        if (this.byteBuffer.limit() - this.byteBuffer.position() <= i) {
            ByteBuffer allocate = ByteBuffer.allocate(this.byteBuffer.limit() + Downloads.RECV_BUFFER_SIZE);
            allocate.put(this.byteBuffer.array(), 0, this.byteBuffer.position());
            this.byteBuffer = allocate;
        }
        return 0;
    }

    public final int Dw(int i) {
        if (this.xnf) {
            Dv(4);
            this.byteBuffer.putInt(i);
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final int fG(long j) {
        if (this.xnf) {
            Dv(8);
            this.byteBuffer.putLong(j);
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final int bu(byte[] bArr) {
        if (this.xnf) {
            byte[] bArr2 = null;
            if (bArr != null) {
                bArr2 = bArr;
            }
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            if (bArr2.length > 2048) {
                throw new Exception("Buffer String Length Error");
            }
            Dv(bArr2.length + 2);
            this.byteBuffer.putShort((short) bArr2.length);
            if (bArr2.length > 0) {
                this.byteBuffer.put(bArr2);
            }
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final int VA(String str) {
        if (this.xnf) {
            byte[] bArr = null;
            if (str != null) {
                bArr = str.getBytes();
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            if (bArr.length > 2048) {
                throw new Exception("Buffer String Length Error");
            }
            Dv(bArr.length + 2);
            this.byteBuffer.putShort((short) bArr.length);
            if (bArr.length > 0) {
                this.byteBuffer.put(bArr);
            }
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final byte[] cfL() {
        if (this.xnf) {
            Dv(1);
            this.byteBuffer.put((byte) 125);
            Object obj = new byte[this.byteBuffer.position()];
            System.arraycopy(this.byteBuffer.array(), 0, obj, 0, obj.length);
            return obj;
        }
        throw new Exception("Buffer For Parse");
    }
}
