package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.k;
import com.tencent.mm.a.n;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.f.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.pd;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.zip.CRC32;

public final class b implements a {
    public static final byte[] koH = "GSMW".getBytes();
    private Socket jZd = null;
    private Boolean kwd = Boolean.valueOf(false);
    private ServerSocket kwe = null;
    private ag kwf = null;
    private ag kwg = new ag(Looper.getMainLooper());
    private DataOutputStream kwh = null;
    private int kwi = 0;
    private int kwj = 0;
    private long kwk = 0;
    private Object lock = new Object();

    static /* synthetic */ void a(b bVar, int i) {
        x.i("MicroMsg.BakOldJavaEngine", "doListen port:%d", Integer.valueOf(((i >> 8) & 255) | ((i & 255) << 8)));
        bVar.kwe = null;
        try {
            x.i("MicroMsg.BakOldJavaEngine", "ip:" + InetAddress.getLocalHost().getHostAddress());
            try {
                x.i("MicroMsg.BakOldJavaEngine", "before init ");
                bVar.kwe = new ServerSocket(r1);
                x.i("MicroMsg.BakOldJavaEngine", "before accept server:  " + bVar.kwe.toString());
                bVar.jZd = bVar.kwe.accept();
                bVar.jZd.setKeepAlive(true);
                x.i("MicroMsg.BakOldJavaEngine", "after accept client:  " + bVar.jZd.toString());
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(bVar.jZd.getInputStream()));
                bVar.kwh = new DataOutputStream(new BufferedOutputStream(bVar.jZd.getOutputStream()));
                bVar.kwd = Boolean.valueOf(false);
                bVar.a(true, 0, 10001, null);
                while (!bVar.kwd.booleanValue()) {
                    bVar.a(dataInputStream);
                }
            } catch (IOException e) {
                x.e("MicroMsg.BakOldJavaEngine", "doListen %s", e);
                bVar.aqX();
                bVar.a(true, 0, 10005, ("doListenErr " + e).getBytes());
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.BakOldJavaEngine", e2, "getHostAddress", new Object[0]);
        }
    }

    static /* synthetic */ void a(b bVar, String str, int i) {
        x.i("MicroMsg.BakOldJavaEngine", "doConnect serverIp:%s, port:%d", str, Integer.valueOf(((i & 255) << 8) | ((i >> 8) & 255)));
        try {
            InetAddress byName = InetAddress.getByName(str);
            x.i("MicroMsg.BakOldJavaEngine", "TCP  Connecting...");
            bVar.jZd = new Socket(byName, r0);
            bVar.jZd.setKeepAlive(true);
            x.i("MicroMsg.BakOldJavaEngine", "TCP connected" + bVar.jZd.toString());
            bVar.kwh = new DataOutputStream(new BufferedOutputStream(bVar.jZd.getOutputStream()));
            DataInputStream dataInputStream = new DataInputStream(bVar.jZd.getInputStream());
            bVar.kwd = Boolean.valueOf(false);
            bVar.a(true, 0, 10002, null);
            while (!bVar.kwd.booleanValue()) {
                bVar.a(dataInputStream);
            }
        } catch (IOException e) {
            x.e("MicroMsg.BakOldJavaEngine", "doConnect %s", e);
            bVar.aqX();
            bVar.a(true, 0, 10004, ("doConnect " + e).getBytes());
        }
    }

    public b() {
        aqY();
    }

    public final void b(final int i, final List<pd> list) {
        x.i("MicroMsg.BakOldJavaEngine", "connect type:%d", Integer.valueOf(i));
        aqY();
        e.post(new Runnable() {
            public final void run() {
                switch (i) {
                    case 0:
                        b.a(b.this, ((Integer) ((pd) list.get(0)).weL.getFirst()).intValue());
                        return;
                    case 1:
                        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
                        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                        if (dhcpInfo != null) {
                            int i = dhcpInfo.netmask;
                            String str = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                            x.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", str, Integer.valueOf(i));
                            String str2 = null;
                            int i2 = 0;
                            for (pd pdVar : list) {
                                x.i("MicroMsg.BakOldJavaEngine", "try ip:%s", pdVar.weK);
                                if (pdVar.weK != null) {
                                    if (pdVar.weK.split("\\.").length >= 4) {
                                        int u = n.u(new byte[]{(byte) (bi.getInt(pdVar.weK.split("\\.")[0], 0) & 255), (byte) (bi.getInt(pdVar.weK.split("\\.")[1], 0) & 255), (byte) (bi.getInt(pdVar.weK.split("\\.")[2], 0) & 255), (byte) (bi.getInt(pdVar.weK.split("\\.")[3], 0) & 255)});
                                        if ((i & u) == (i & ipAddress)) {
                                            b.a(b.this, pdVar.weK, ((Integer) pdVar.weL.getFirst()).intValue());
                                            return;
                                        }
                                        String str3;
                                        int intValue;
                                        if ((u & 65535) == (65535 & ipAddress)) {
                                            str3 = pdVar.weK;
                                            intValue = ((Integer) pdVar.weL.getFirst()).intValue();
                                        } else {
                                            intValue = i2;
                                            str3 = str2;
                                        }
                                        str2 = str3;
                                        i2 = intValue;
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            if (str2 != null) {
                                x.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", str2, Integer.valueOf(i2));
                                b.a(b.this, str2, i2);
                                return;
                            }
                            b.this.a(true, 0, 10009, String.format("not match ip mask:%d, localip:%s", new Object[]{Integer.valueOf(i), str}).getBytes());
                            x.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", Integer.valueOf(i), str);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }, "BackupJavaEngine_connect");
    }

    public final void aqW() {
        x.i("MicroMsg.BakOldJavaEngine", "close connect");
        aqX();
        a(true, 0, 10003, null);
    }

    private void aqX() {
        this.kwi = 0;
        this.kwj = 0;
        this.kwk = 0;
        this.kwd = Boolean.valueOf(true);
        try {
            synchronized (this.lock) {
                if (this.kwh != null) {
                    this.kwh.close();
                }
            }
        } catch (Exception e) {
        }
        try {
            if (this.jZd != null) {
                this.jZd.close();
            }
        } catch (Exception e2) {
        }
    }

    private void a(boolean z, int i, int i2, byte[] bArr) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final byte[] bArr2 = bArr;
        this.kwg.post(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.backup.f.b.b(z2, i3, i4, bArr2);
            }
        });
    }

    public final void i(final int i, final byte[] bArr) {
        if (this.kwf != null) {
            ab(bArr);
        } else {
            this.kwg.postDelayed(new Runnable() {
                public final void run() {
                    b.this.ab(bArr);
                }
            }, 200);
        }
    }

    public final int j(int i, byte[] bArr) {
        return 0;
    }

    public final void ab(final byte[] bArr) {
        if (this.kwd.booleanValue()) {
            x.e("MicroMsg.BakOldJavaEngine", "engine has stop");
        } else {
            this.kwf.post(new Runnable() {
                public final void run() {
                    try {
                        synchronized (b.this.lock) {
                            b.this.kwh.write(bArr);
                            b.this.kwh.flush();
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.BakOldJavaEngine", "send_error %s", e);
                        b.this.aqX();
                        b.this.a(true, 0, 10008, ("send_error " + e).getBytes());
                    }
                }
            });
        }
    }

    private void aqY() {
        if (this.kwf == null || !this.kwf.getLooper().getThread().isAlive()) {
            e.b(new Runnable() {
                public final void run() {
                    Looper.prepare();
                    b.this.kwf = new ag();
                    Looper.loop();
                }
            }, "BackupJavaEngine_handler").start();
        }
    }

    private void a(DataInputStream dataInputStream) {
        int i;
        String format;
        while (!this.kwd.booleanValue() && this.kwi != 4) {
            try {
                if (koH[this.kwi] == dataInputStream.readByte()) {
                    this.kwi++;
                } else {
                    long Wx = bi.Wx();
                    if (((long) this.kwj) - (Wx - this.kwk) < 10) {
                        if (this.kwj < 0) {
                            this.kwj = 0;
                        }
                        this.kwj++;
                        this.kwk = Wx;
                        i = 0;
                    } else {
                        boolean i2 = true;
                    }
                    if (i2 == 0) {
                        format = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[]{Integer.valueOf(this.kwi + 1), Integer.valueOf(koH[this.kwi] & 255), Integer.valueOf(r1 & 255)});
                        x.e("MicroMsg.BakOldJavaEngine", format);
                        a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
                    }
                    this.kwi = 0;
                }
            } catch (Exception e) {
                x.e("MicroMsg.BakOldJavaEngine", "loopRead %s", e);
                try {
                    dataInputStream.close();
                } catch (IOException e2) {
                }
                if (!this.kwd.booleanValue()) {
                    a(true, 0, 10006, ("read_error " + e).getBytes());
                }
                aqX();
                return;
            }
        }
        this.kwi = 0;
        int readInt = dataInputStream.readInt();
        short readShort = dataInputStream.readShort();
        short readShort2 = dataInputStream.readShort();
        int readInt2 = dataInputStream.readInt();
        if (readInt2 > 16777216) {
            format = String.format("loopRead size to large:%d", new Object[]{Integer.valueOf(readInt2)});
            x.e("MicroMsg.BakOldJavaEngine", format);
            this.kwd = Boolean.valueOf(true);
            a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
            return;
        }
        int readInt3 = dataInputStream.readInt();
        x.i("MicroMsg.BakOldJavaEngine", "read buf size:" + readInt2);
        byte[] bArr = new byte[(readInt2 - 20)];
        i2 = 0;
        while (i2 < bArr.length) {
            int read = dataInputStream.read(bArr, i2, bArr.length - i2);
            if (read == -1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                }
            } else {
                i2 += read;
            }
        }
        PByteArray pByteArray = new PByteArray();
        byte[] bArr2 = koH;
        if (readShort != (short) 1) {
            format = String.format("unpack failed, getVersion:%d", new Object[]{Short.valueOf(readShort)});
            x.e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i2 = -1;
        } else if (com.tencent.mm.plugin.backup.f.b.aoV() != 1 || readInt3 == com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a(bArr2, readInt, readShort, readShort2, readInt2, bArr)) {
            if (!(readShort2 == (short) 1 || readShort2 == (short) 2)) {
                bArr = k.a(bArr, d.aoW());
            }
            pByteArray.value = bArr;
            i2 = 0;
        } else {
            new CRC32().update(bArr);
            String aa = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.aa(bArr);
            format = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(readInt3), Integer.valueOf(readInt), Short.valueOf(readShort2), Integer.valueOf(readInt2), Integer.valueOf((int) r2.getValue()), aa});
            x.e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i2 = -2;
        }
        x.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", Integer.valueOf(i2));
        if (i2 != 0) {
            a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, (pByteArray.value == null ? "" : new String(pByteArray.value)).getBytes());
            return;
        }
        x.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", Integer.valueOf(i2), Integer.valueOf(readInt), Short.valueOf(readShort2));
        a(false, readInt, readShort2, pByteArray.value);
    }
}
