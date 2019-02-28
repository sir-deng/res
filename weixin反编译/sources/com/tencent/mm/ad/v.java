package com.tencent.mm.ad;

import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class v {
    private b hpG = null;
    private long hpH = 0;

    class a extends oicq.wlogin_sdk.tools.b {
        public final void s(int i, String str) {
            OnLog(i, "", str);
        }

        public final void OnLog(int i, String str, String str2) {
            if (i == 1) {
                x.i("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            } else if (i == 2) {
                x.d("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            } else if (i == 0) {
                x.w("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            }
        }
    }

    public v() {
        try {
            long Wy = bi.Wy();
            this.hpG = new b(ad.getContext(), d.vHl);
            util.AHs = 1;
            util.AHt = new a();
            x.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", Long.valueOf(bi.bA(Wy)));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WtloginMgr", e, "Failed initializing WtloginMgr.", new Object[0]);
        }
    }

    public final byte[] a(long j, String str, boolean z) {
        String str2 = "MicroMsg.WtloginMgr";
        String str3 = "dkwt isTestWtLogin:%b val:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(r.ifN == 10006);
        objArr[1] = Integer.valueOf(r.ifO);
        x.d(str2, str3, objArr);
        if (r.ifN == 10006) {
            if (r.ifO == 1) {
                r.ifO = 0;
                return new byte[0];
            } else if (r.ifO == 2) {
                return new byte[0];
            }
        }
        try {
            boolean z2;
            this.hpH = j;
            byte[] a = z ? null : this.hpG.a(j, oicq.wlogin_sdk.request.b.a.USER_WITH_A1, "");
            str3 = "MicroMsg.WtloginMgr";
            String str4 = "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ";
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(8256);
            objArr2[1] = Long.valueOf(j);
            objArr2[2] = Boolean.valueOf(z);
            if (bi.by(a)) {
                z2 = false;
            } else {
                z2 = true;
            }
            objArr2[3] = Boolean.valueOf(z2);
            x.d(str3, str4, objArr2);
            if (bi.by(a)) {
                return this.hpG.a(j, oicq.wlogin_sdk.request.b.a.USER_WITH_MD5, new String(bi.Wj(str), "ISO-8859-1"));
            }
            return a;
        } catch (Throwable e) {
            x.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", e.getMessage());
            x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
            return new byte[0];
        }
    }

    public final boolean a(long j, byte[] bArr) {
        if (j != this.hpH) {
            x.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.hpH), Long.valueOf(j));
            return false;
        } else if (bi.by(bArr)) {
            x.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
            return false;
        } else {
            try {
                int i;
                b bVar = this.hpG;
                if (bArr == null || bArr.length == 0 || bVar.AFe == null) {
                    i = -1017;
                } else {
                    util.adi("user:" + bVar.AEY._uin + " ResolveSvrData ...");
                    i = bVar.AFe.T(bArr, bArr.length);
                    if (i == 1) {
                        bVar.gL(bVar.AEY._uin);
                    }
                    util.adi("user:" + bVar.AEY._uin + " ResolveSvrData ret=" + i);
                }
                x.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", Integer.valueOf(bArr.length), Integer.valueOf(i));
                if (i == 0) {
                    return true;
                }
                return false;
            } catch (Throwable e) {
                x.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", e.getMessage());
                x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
                return false;
            }
        }
    }

    public final byte[] aQ(long j) {
        if (j != this.hpH) {
            x.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.hpH), Long.valueOf(j));
            return new byte[0];
        }
        try {
            return this.hpG.gK(j);
        } catch (Throwable e) {
            x.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", e.getMessage());
            x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
            return new byte[0];
        }
    }

    public final byte[] c(long j, String str) {
        if (j != this.hpH) {
            x.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.hpH), Long.valueOf(j));
            return new byte[0];
        }
        byte[] bytes;
        if (bi.oN(str)) {
            bytes = "****".getBytes();
        } else {
            bytes = str.getBytes();
        }
        try {
            return this.hpG.f(j, bytes);
        } catch (Throwable e) {
            x.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", e.getMessage());
            x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
            return new byte[0];
        }
    }

    public final byte[] aR(long j) {
        if (j != this.hpH) {
            x.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.hpH), Long.valueOf(j));
            return new byte[0];
        }
        try {
            WUserSigInfo wUserSigInfo;
            WloginSigInfo N = this.hpG.AEY.N(j, 522017402);
            if (N == null) {
                wUserSigInfo = null;
            } else {
                wUserSigInfo = new WUserSigInfo();
                wUserSigInfo.get_clone(N);
            }
            return wUserSigInfo == null ? new byte[0] : wUserSigInfo._A2;
        } catch (Throwable e) {
            x.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", e.getMessage());
            x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
            return new byte[0];
        }
    }

    public final void aS(long j) {
        if (j != this.hpH) {
            x.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.hpH), Long.valueOf(j));
            return;
        }
        try {
            this.hpG.gL(j);
        } catch (Throwable e) {
            x.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", e.getMessage());
            x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
        }
    }
}
