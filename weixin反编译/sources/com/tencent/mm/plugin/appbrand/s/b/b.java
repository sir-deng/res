package com.tencent.mm.plugin.appbrand.s.b;

import com.tencent.mm.plugin.appbrand.s.d.c;
import com.tencent.mm.plugin.appbrand.s.d.d;
import com.tencent.mm.plugin.appbrand.s.d.e;
import com.tencent.mm.plugin.appbrand.s.e.f;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.plugin.appbrand.s.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class b extends a {
    private final Random jZA = new Random();
    private ByteBuffer jZy;
    private d jZz = null;

    private class a extends Throwable {
        int jZB;

        public a(int i) {
            this.jZB = i;
        }
    }

    public static int d(f fVar) {
        int i = -1;
        String vs = fVar.vs("Sec-WebSocket-Version");
        if (vs.length() <= 0) {
            return i;
        }
        try {
            return new Integer(vs.trim()).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public final int a(com.tencent.mm.plugin.appbrand.s.e.a aVar, h hVar) {
        int i = 1;
        String vs = aVar.vs("Sec-WebSocket-Protocol");
        String vs2 = hVar.vs("Sec-WebSocket-Protocol");
        if (!(bi.oN(vs) || bi.oN(vs2))) {
            x.d("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", vs2);
            for (Object equals : vs.split(", ")) {
                if (vs2.equals(equals)) {
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                return com.tencent.mm.plugin.appbrand.s.b.a.b.jZw;
            }
        }
        if (!aVar.vt("Sec-WebSocket-Key") || !hVar.vt("Sec-WebSocket-Accept")) {
            return com.tencent.mm.plugin.appbrand.s.b.a.b.jZw;
        }
        if (vp(aVar.vs("Sec-WebSocket-Key")).equals(hVar.vs("Sec-WebSocket-Accept"))) {
            return com.tencent.mm.plugin.appbrand.s.b.a.b.jZv;
        }
        return com.tencent.mm.plugin.appbrand.s.b.a.b.jZw;
    }

    public int a(com.tencent.mm.plugin.appbrand.s.e.a aVar) {
        int d = d((f) aVar);
        if (d != 7 && d != 8) {
            return com.tencent.mm.plugin.appbrand.s.b.a.b.jZw;
        }
        Object obj = (aVar.vs("Upgrade").equalsIgnoreCase("websocket") && aVar.vs("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade")) ? 1 : null;
        return obj != null ? com.tencent.mm.plugin.appbrand.s.b.a.b.jZv : com.tencent.mm.plugin.appbrand.s.b.a.b.jZw;
    }

    public final ByteBuffer d(d dVar) {
        int i;
        int i2;
        int i3 = -128;
        int i4 = 0;
        ByteBuffer amC = dVar.amC();
        int i5 = this.jYT == com.tencent.mm.plugin.appbrand.s.a.b.jYF ? 1 : 0;
        int i6 = amC.remaining() <= 125 ? 1 : amC.remaining() <= 65535 ? 2 : 8;
        if (i6 > 1) {
            i = i6 + 1;
        } else {
            i = i6;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((i5 != 0 ? 4 : 0) + (i + 1)) + amC.remaining());
        com.tencent.mm.plugin.appbrand.s.d.d.a amF = dVar.amF();
        if (amF == com.tencent.mm.plugin.appbrand.s.d.d.a.CONTINUOUS) {
            i = 0;
        } else if (amF == com.tencent.mm.plugin.appbrand.s.d.d.a.TEXT) {
            i = 1;
        } else if (amF == com.tencent.mm.plugin.appbrand.s.d.d.a.BINARY) {
            i = 2;
        } else if (amF == com.tencent.mm.plugin.appbrand.s.d.d.a.CLOSING) {
            i = 8;
        } else if (amF == com.tencent.mm.plugin.appbrand.s.d.d.a.PING) {
            i = 9;
        } else if (amF == com.tencent.mm.plugin.appbrand.s.d.d.a.PONG) {
            i = 10;
        } else {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + amF.toString());
            i = 8;
        }
        if (dVar.amD()) {
            i2 = -128;
        } else {
            i2 = 0;
        }
        allocate.put((byte) (i | ((byte) i2)));
        byte[] j = j((long) amC.remaining(), i6);
        if (i6 == 1) {
            byte b = j[0];
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (b | i3));
        } else if (i6 == 2) {
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (i3 | 126));
            allocate.put(j);
        } else if (i6 == 8) {
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (i3 | 127));
            allocate.put(j);
        } else {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
        }
        if (i5 != 0) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.jZA.nextInt());
            allocate.put(allocate2.array());
            while (amC.hasRemaining()) {
                allocate.put((byte) (amC.get() ^ allocate2.get(i4 % 4)));
                i4++;
            }
        } else {
            allocate.put(amC);
        }
        allocate.flip();
        return allocate;
    }

    public final List<d> a(ByteBuffer byteBuffer, boolean z) {
        c eVar = new e();
        try {
            eVar.u(byteBuffer);
        } catch (com.tencent.mm.plugin.appbrand.s.c.b e) {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.do(true);
        eVar.a(com.tencent.mm.plugin.appbrand.s.d.d.a.BINARY);
        eVar.dp(z);
        return Collections.singletonList(eVar);
    }

    public final List<d> Z(String str, boolean z) {
        c eVar = new e();
        try {
            eVar.u(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.s.f.b.vu(str)));
        } catch (com.tencent.mm.plugin.appbrand.s.c.b e) {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.do(true);
        eVar.a(com.tencent.mm.plugin.appbrand.s.d.d.a.TEXT);
        eVar.dp(z);
        return Collections.singletonList(eVar);
    }

    private static String vp(String str) {
        String str2 = str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            return com.tencent.mm.plugin.appbrand.s.f.a.Y(MessageDigest.getInstance("SHA1").digest(str2.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + e.toString());
            return "";
        }
    }

    public com.tencent.mm.plugin.appbrand.s.e.b a(com.tencent.mm.plugin.appbrand.s.e.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put("Connection", "Upgrade");
        bVar.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.jZA.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", com.tencent.mm.plugin.appbrand.s.f.a.Y(bArr));
        return bVar;
    }

    public com.tencent.mm.plugin.appbrand.s.e.c a(com.tencent.mm.plugin.appbrand.s.e.a aVar, i iVar) {
        iVar.put("Upgrade", "websocket");
        iVar.put("Connection", aVar.vs("Connection"));
        iVar.vr("Switching Protocols");
        String vs = aVar.vs("Sec-WebSocket-Key");
        if (vs == null) {
            throw new com.tencent.mm.plugin.appbrand.s.c.d("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", vp(vs));
        return iVar;
    }

    private static byte[] j(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    public final List<d> r(ByteBuffer byteBuffer) {
        List<d> linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.jZy == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.jZy.remaining();
                if (remaining2 > remaining) {
                    this.jZy.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    return Collections.emptyList();
                }
                this.jZy.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(t((ByteBuffer) this.jZy.duplicate().position(0)));
                this.jZy = null;
            } catch (a e) {
                this.jZy.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a.md(e.jZB));
                this.jZy.rewind();
                allocate.put(this.jZy);
                this.jZy = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(t(byteBuffer));
            } catch (a e2) {
                byteBuffer.reset();
                this.jZy = ByteBuffer.allocate(a.md(e2.jZB));
                this.jZy.put(byteBuffer);
            }
        }
        return linkedList;
    }

    private d t(ByteBuffer byteBuffer) {
        int i = 10;
        int i2 = 0;
        int remaining = byteBuffer.remaining();
        if (remaining < 2) {
            throw new a(2);
        }
        boolean z;
        byte b = byteBuffer.get();
        if ((b >> 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        byte b2 = (byte) ((b & 127) >> 4);
        if (b2 != (byte) 0) {
            throw new com.tencent.mm.plugin.appbrand.s.c.c("bad rsv " + b2);
        }
        int i3;
        com.tencent.mm.plugin.appbrand.s.d.d.a aVar;
        b2 = byteBuffer.get();
        if ((b2 & -128) != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        b2 = (byte) (b2 & 127);
        b = (byte) (b & 15);
        switch (b) {
            case (byte) 0:
                aVar = com.tencent.mm.plugin.appbrand.s.d.d.a.CONTINUOUS;
                break;
            case (byte) 1:
                aVar = com.tencent.mm.plugin.appbrand.s.d.d.a.TEXT;
                break;
            case (byte) 2:
                aVar = com.tencent.mm.plugin.appbrand.s.d.d.a.BINARY;
                break;
            case (byte) 8:
                aVar = com.tencent.mm.plugin.appbrand.s.d.d.a.CLOSING;
                break;
            case (byte) 9:
                aVar = com.tencent.mm.plugin.appbrand.s.d.d.a.PING;
                break;
            case (byte) 10:
                aVar = com.tencent.mm.plugin.appbrand.s.d.d.a.PONG;
                break;
            default:
                throw new com.tencent.mm.plugin.appbrand.s.c.c("unknow optcode " + ((short) b));
        }
        if (z || !(aVar == com.tencent.mm.plugin.appbrand.s.d.d.a.PING || aVar == com.tencent.mm.plugin.appbrand.s.d.d.a.PONG || aVar == com.tencent.mm.plugin.appbrand.s.d.d.a.CLOSING)) {
            int intValue;
            int i4;
            byte intValue2;
            if (b2 >= (byte) 0 && b2 <= (byte) 125) {
                i = 2;
                intValue2 = b2;
            } else if (aVar == com.tencent.mm.plugin.appbrand.s.d.d.a.PING || aVar == com.tencent.mm.plugin.appbrand.s.d.d.a.PONG || aVar == com.tencent.mm.plugin.appbrand.s.d.d.a.CLOSING) {
                throw new com.tencent.mm.plugin.appbrand.s.c.c("more than 125 octets");
            } else if (b2 == (byte) 126) {
                if (remaining < 4) {
                    throw new a(4);
                }
                byte[] bArr = new byte[3];
                bArr[1] = byteBuffer.get();
                bArr[2] = byteBuffer.get();
                intValue2 = new BigInteger(bArr).intValue();
                i = 4;
            } else if (remaining < 10) {
                throw new a(10);
            } else {
                byte[] bArr2 = new byte[8];
                for (intValue2 = 0; intValue2 < 8; intValue2++) {
                    bArr2[intValue2] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr2).longValue();
                if (longValue > 2147483647L) {
                    x.e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
                    intValue2 = b2;
                } else {
                    intValue2 = (int) longValue;
                }
            }
            if (i3 != 0) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            i4 = (i4 + i) + intValue2;
            if (remaining < i4) {
                throw new a(i4);
            }
            d bVar;
            ByteBuffer allocate = ByteBuffer.allocate(a.md(intValue2));
            if (i3 != 0) {
                byte[] bArr3 = new byte[4];
                byteBuffer.get(bArr3);
                while (i2 < intValue2) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr3[i2 % 4]));
                    i2++;
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (aVar == com.tencent.mm.plugin.appbrand.s.d.d.a.CLOSING) {
                bVar = new com.tencent.mm.plugin.appbrand.s.d.b();
            } else {
                bVar = new e();
                bVar.do(z);
                bVar.a(aVar);
            }
            allocate.flip();
            bVar.u(allocate);
            return bVar;
        }
        throw new com.tencent.mm.plugin.appbrand.s.c.c("control frames may no be fragmented");
    }

    public final void reset() {
        this.jZy = null;
    }

    public a amA() {
        return new b();
    }

    public final int amz() {
        return com.tencent.mm.plugin.appbrand.s.b.a.a.jZt;
    }
}
