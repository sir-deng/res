package oicq.wlogin_sdk.request;

import android.content.Context;
import java.security.SecureRandom;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public final class i {
    public static byte[] AFO = new byte[0];
    public SecureRandom AFD = new SecureRandom();
    public byte[] AFE = util.cKQ();
    public byte[] AFF = null;
    public byte[] AFG = new byte[16];
    public f AFH = new f();
    public g AFI = new g();
    public long AFJ = 0;
    public int AFK = 0;
    public long AFL = -1;
    public int AFM = 0;
    byte[] AFN = new byte[0];
    byte[] AFP = new byte[0];
    int AFQ = 0;
    byte[] AFR = new byte[0];
    byte[] AFS = new byte[0];
    byte[] AFT = new byte[0];
    byte[] AFU = new byte[0];
    byte[] AFV = new byte[0];
    byte[] AFW = new byte[0];
    int AFX = 0;
    int AFY = 0;
    int AFZ = 0;
    int AGa = 0;
    byte[] AGb = new byte[0];
    ErrMsg AGc = new ErrMsg();
    byte[] AGd = new byte[0];
    byte[] AGe = new byte[4];
    byte[] AGf = new byte[0];
    c AGg = null;
    public Context _context = null;
    public long _uin = 0;

    public static long cKH() {
        return System.currentTimeMillis() / 1000;
    }

    public final synchronized int a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        util.adi("put siginfo:" + j + "," + j2 + "," + j3 + "," + j4 + "," + j5 + "," + j6 + "," + util.ci(bArr) + "," + util.ci(bArr2) + "," + util.ci(bArr3) + "," + util.ci(bArr4) + "," + util.ci(bArr5) + "," + util.ci(bArr6) + "," + util.ci(bArr7) + "," + util.ci(bArr8) + "," + util.ci(bArr9) + "," + util.ci(bArr10) + "," + util.ci(bArr11) + "," + util.ci(bArr12) + "," + util.ci(bArr13) + "," + util.ci(bArr14) + "," + util.ci(bArr15) + "," + util.ci(bArr16));
        String str = "";
        for (int i = 0; i < bArr17.length; i++) {
            str = new StringBuilder(String.valueOf(str)).append(String.format("reserve[%d]: %d ", new Object[]{Integer.valueOf(i), Long.valueOf(util.ci(bArr17[i]))})).toString();
        }
        util.adi("reserve:" + str);
        return this.AGg.a(j, j2, j3, j4, j5, j6, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
    }

    public final synchronized WloginSigInfo N(long j, long j2) {
        WloginSigInfo N;
        util.gp("get_siginfo", "uin=" + j + "appid=522017402");
        N = this.AGg.N(j, 522017402);
        if (N != null) {
        }
        return N;
    }

    public final synchronized void h(Long l) {
        this.AGg.h(l);
    }
}
