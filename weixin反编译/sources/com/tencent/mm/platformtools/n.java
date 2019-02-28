package com.tencent.mm.platformtools;

import com.tencent.mm.bp.b;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;

public final class n {
    public static bes N(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        bes bes = new bes();
        bes.bl(bArr);
        return bes;
    }

    public static byte[] a(bes bes) {
        if (bes == null || bes.wRm == null) {
            return null;
        }
        return bes.wRm.toByteArray();
    }

    public static byte[] a(bes bes, byte[] bArr) {
        return (bes == null || bes.wRm == null) ? bArr : bes.wRm.toByteArray();
    }

    public static String a(bet bet) {
        if (bet == null) {
            return null;
        }
        return bet.wRo;
    }

    public static bet oK(String str) {
        if (str == null) {
            return null;
        }
        bet bet = new bet();
        bet.Vf(str);
        return bet;
    }

    public static String a(b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.cec();
    }

    public static String b(bes bes) {
        if (bes == null || bes.wRm == null) {
            return null;
        }
        return bes.wRm.cec();
    }
}
