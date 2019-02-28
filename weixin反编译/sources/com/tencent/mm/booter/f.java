package com.tencent.mm.booter;

import com.tencent.mm.a.g;
import com.tencent.mm.a.n;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.f.a.hd;
import com.tencent.mm.f.a.li;
import com.tencent.mm.f.a.qi;
import com.tencent.mm.modelmulti.d;
import com.tencent.mm.network.aa;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

public final class f {
    public static boolean a(int i, int i2, byte[] bArr, byte[] bArr2, long j) {
        x.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            az(2);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            switch (i2) {
                case 138:
                    az(bArr == null ? 7 : (long) n.p(bArr, 0));
                    break;
                case 268369921:
                    if (bi.by(bArr) || bArr.length <= 8) {
                        x.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
                        break;
                    }
                    int p = n.p(bArr, 0);
                    int p2 = n.p(bArr, 4);
                    x.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + p + " bufLen:" + p2 + " dump:" + bi.P(bArr, 8));
                    if (p2 != bArr.length - 8) {
                        x.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + bArr.length);
                        break;
                    }
                    Object obj = new byte[p2];
                    System.arraycopy(bArr, 8, obj, 0, p2);
                    e bVar = new b();
                    PByteArray pByteArray = new PByteArray();
                    PByteArray pByteArray2 = new PByteArray();
                    PInt pInt = new PInt();
                    PInt pInt2 = new PInt();
                    PInt pInt3 = new PInt(0);
                    PInt pInt4 = new PInt(255);
                    try {
                        boolean unpack = MMProtocalJni.unpack(pByteArray2, obj, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
                        if (pInt3.value != 0) {
                            com.tencent.mm.sdk.b.b hdVar = new hd();
                            hdVar.fyh.fyi = pInt3.value;
                            boolean m = a.xmy.m(hdVar);
                            x.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                            pInt3.value = 0;
                        }
                        if (!unpack) {
                            x.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
                            break;
                        }
                        bVar.vIc = pInt4.value;
                        if (pInt.value != -13) {
                            p2 = bVar.E(pByteArray2.value);
                            x.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
                            bVar.vIb = p2;
                            bVar.vIa = (long) obj.length;
                            byte[] Wj = bi.Wj(ad.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
                            byte[] a = com.tencent.mm.platformtools.n.a(bVar.vID.vYE);
                            if (!bi.by(a) && com.tencent.mm.protocal.ad.h(Wj, a)) {
                                new d(bVar, p, j).a(aa.VX(), new com.tencent.mm.ad.e() {
                                    public final void a(int i, int i2, String str, k kVar) {
                                        x.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
                                    }
                                });
                                if (pInt3.value != 0) {
                                    com.tencent.mm.sdk.b.b hdVar2 = new hd();
                                    hdVar2.fyh.fyi = pInt3.value;
                                    boolean m2 = a.xmy.m(hdVar2);
                                    x.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m2));
                                    pInt3.value = 0;
                                    break;
                                }
                            }
                            x.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
                            break;
                        }
                        bVar.vIb = pInt.value;
                        x.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
                        break;
                    } catch (Throwable e) {
                        x.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", e);
                        x.printErrStackTrace("MicroMsg.NotifySyncMgr", e, "", new Object[0]);
                    }
                    break;
                case 1000000205:
                    com.tencent.mm.protocal.aa.b bVar2 = new com.tencent.mm.protocal.aa.b();
                    try {
                        bVar2.E(bArr);
                        az(bVar2.vII);
                        break;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.NotifySyncMgr", e2, "", new Object[0]);
                        break;
                    }
                case 2147480001:
                    az(7);
                    break;
            }
            return true;
        }
    }

    private static void az(long j) {
        x.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = " + j);
        if ((256 & j) != 0) {
            a.xmy.m(new qi());
        }
        if ((2097152 & j) != 0) {
            a.xmy.m(new li());
        }
        if ((((-257 & j) & -2097153) & 2) != 0) {
            new d().a(aa.VX(), new com.tencent.mm.ad.e() {
                public final void a(int i, int i2, String str, k kVar) {
                    x.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
                }
            });
        }
    }

    public static byte[] a(PInt pInt, int i) {
        String fk = fk(i);
        int ej = ej(fk);
        for (int i2 = 1; i2 <= ej; i2++) {
            String str = fk + "/syncResp.bin" + i2;
            if (com.tencent.mm.a.e.bO(str)) {
                byte[] e = com.tencent.mm.a.e.e(str, 0, -1);
                if (bi.by(e)) {
                    x.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
                    e = com.tencent.mm.a.e.e(str, 0, -1);
                }
                byte[] a = com.tencent.mm.a.k.a(e, g.s((q.yL() + i).getBytes()).getBytes());
                x.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", Integer.valueOf(i2), Integer.valueOf(ej), B(e), B(a), B(r6.getBytes()));
                if (!bi.by(a)) {
                    pInt.value = i2;
                    return a;
                }
            }
        }
        return null;
    }

    public static void aL(int i, int i2) {
        String fk = fk(i2);
        int ej = ej(fk);
        com.tencent.mm.loader.stub.b.deleteFile(fk + "/syncResp.bin" + i);
        x.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", Integer.valueOf(i), Integer.valueOf(ej));
        if (i == ej) {
            com.tencent.mm.loader.stub.b.deleteFile(fk + "/syncResp.ini");
            x.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
        }
    }

    public static int ej(String str) {
        int i = 0;
        byte[] e = com.tencent.mm.a.e.e(str + "/syncResp.ini", i, -1);
        if (bi.by(e)) {
            return i;
        }
        try {
            return Integer.parseInt(new String(e));
        } catch (NumberFormatException e2) {
            return i;
        }
    }

    public static String fk(int i) {
        String str = w.hbv + g.s(("mm" + i).getBytes()) + "/pushSyncResp";
        com.tencent.mm.a.e.bS(str);
        return str;
    }

    public static String B(byte[] bArr) {
        if (bi.by(bArr)) {
            return "buf is nullOrNil";
        }
        if (bArr.length == 1) {
            return "buf.len is 1: " + Integer.toHexString(bArr[0]);
        }
        return "buf last two[len:" + bArr.length + "]: %s, %s" + Integer.toHexString(bArr[bArr.length - 2] & 255) + ", " + Integer.toHexString(bArr[bArr.length - 1] & 255);
    }
}
