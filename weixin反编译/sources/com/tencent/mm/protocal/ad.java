package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class ad {
    public static byte[] g(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length <= 0) {
            x.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
            return bArr2;
        } else if (bArr2 == null || bArr2.length <= 0) {
            x.e("MicroMsg.SyncKeyUtil", "newKey is null");
            return null;
        } else {
            PByteArray pByteArray = new PByteArray();
            try {
                if (MMProtocalJni.mergeSyncKey(bArr, bArr2, pByteArray)) {
                    return pByteArray.value;
                }
                x.e("MicroMsg.SyncKeyUtil", "merge key failed");
                return null;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Crash", e, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(e));
            }
        }
    }

    private static Map<Integer, Long> bj(byte[] bArr) {
        if (bi.by(bArr)) {
            return null;
        }
        try {
            boi boi = (boi) new boi().aH(bArr);
            if (boi == null) {
                return null;
            }
            x.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + boi.wTO);
            LinkedList linkedList = boi.wTP;
            if (linkedList.size() != boi.wTO) {
                return null;
            }
            Map<Integer, Long> hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= boi.wTO) {
                    break;
                }
                hashMap.put(Integer.valueOf(((aof) linkedList.get(i2)).pWg), Long.valueOf(4294967295L & ((long) ((aof) linkedList.get(i2)).wBQ)));
                i = i2 + 1;
            }
            if (hashMap.size() != boi.wTO) {
                return null;
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    public static String bk(byte[] bArr) {
        if (bi.by(bArr)) {
            return "";
        }
        Map bj = bj(bArr);
        if (bj == null || bj.size() <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" MsgKey:" + bj.get(Integer.valueOf(2)));
        stringBuffer.append(" profile:" + bj.get(Integer.valueOf(1)));
        stringBuffer.append(" contact:" + bj.get(Integer.valueOf(3)));
        stringBuffer.append(" chatroom:" + bj.get(Integer.valueOf(11)));
        stringBuffer.append(" Bottle:" + bj.get(Integer.valueOf(7)));
        stringBuffer.append(" QContact:" + bj.get(Integer.valueOf(5)));
        return stringBuffer.toString();
    }

    public static boolean h(byte[] bArr, byte[] bArr2) {
        Map bj = bj(bArr);
        if (bj == null) {
            x.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
            return true;
        }
        Map bj2 = bj(bArr2);
        if (bj2 == null) {
            x.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
            return false;
        }
        for (Integer num : bj2.keySet()) {
            Long l = (Long) bj.get(num);
            Long l2 = (Long) bj2.get(num);
            if (l == null) {
                x.d("MicroMsg.SyncKeyUtil", "dkpush local key null :" + num);
                return true;
            }
            x.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + num + " sv:" + l2 + " lv:" + l);
            if (l2.longValue() > l.longValue()) {
                return true;
            }
        }
        x.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
        return false;
    }
}
