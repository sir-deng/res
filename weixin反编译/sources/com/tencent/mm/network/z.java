package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

public final class z {
    final a[] ict = new a[100];

    /* renamed from: com.tencent.mm.network.z$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int icu;
        final /* synthetic */ int icv;

        AnonymousClass1(int i, int i2) {
            this.icu = i;
            this.icv = i2;
        }

        public final void run() {
            MMLogic.reportCGIServerError(this.icu, this.icv);
        }
    }

    private static class a {
        r icx;
        l icy;
        c icz;
        long startTime;
        int taskId;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    protected final void finalize() {
        reset();
        super.finalize();
    }

    final boolean VL() {
        synchronized (this.ict) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.ict[i] != null && (701 == this.ict[i].icx.getType() || 702 == this.ict[i].icx.getType())) {
                        x.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.ict[i].icx.getType());
                        return true;
                    }
                } catch (Throwable e) {
                    this.ict[i] = null;
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", bi.i(e), Integer.valueOf(i));
                }
                i++;
            }
            return false;
        }
    }

    final boolean VM() {
        synchronized (this.ict) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.ict[i] != null && 1000 == this.ict[i].icx.getType()) {
                        x.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.ict[i].icx.getType());
                        return true;
                    }
                } catch (Throwable e) {
                    this.ict[i] = null;
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", bi.i(e), Integer.valueOf(i));
                }
                i++;
            }
            return false;
        }
    }

    final r cg(boolean z) {
        synchronized (this.ict) {
            int i = 0;
            r rVar = null;
            while (i < 100) {
                if (this.ict[i] != null) {
                    if (z) {
                        try {
                            if (this.ict[i].icx instanceof com.tencent.mm.network.r.a) {
                                continue;
                            }
                        } catch (Throwable e) {
                            x.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bi.i(e));
                        }
                    }
                    if (z || (this.ict[i].icx instanceof com.tencent.mm.network.r.a)) {
                        if (701 == this.ict[i].icx.getType() || 702 == this.ict[i].icx.getType()) {
                            x.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.ict[i].icx.getType());
                            return null;
                        } else if (rVar == null) {
                            rVar = this.ict[i].icx;
                        } else {
                            continue;
                        }
                    }
                }
                i++;
            }
            return rVar;
        }
    }

    public final int VN() {
        int i = 0;
        for (int i2 = 0; i2 < 100; i2++) {
            try {
                if (this.ict[i2] != null) {
                    this.ict[i2].icx.getType();
                }
            } catch (Throwable e) {
                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", bi.i(e), Integer.valueOf(i2));
                i++;
                this.ict[i2] = null;
            }
        }
        return i;
    }

    public final int a(r rVar, l lVar, c cVar, int i) {
        if (rVar == null) {
            x.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
            return -1;
        }
        int i2;
        rVar.hashCode();
        Task task = new Task();
        synchronized (this.ict) {
            int i3 = 0;
            while (i3 < 100) {
                try {
                    if (this.ict[i3] == null) {
                        this.ict[i3] = new a();
                        this.ict[i3].icx = rVar;
                        this.ict[i3].icy = lVar;
                        this.ict[i3].icz = cVar;
                        this.ict[i3].startTime = bi.Wy();
                        this.ict[i3].taskId = task.taskID;
                        task.cmdID = rVar.KO().getCmdId();
                        task.cgi = rVar.getUri();
                        int type = rVar.getType();
                        task.needAuthed = (rVar.Ke() & 1) != 1;
                        if (type == 126 || type == 701 || type == 702) {
                            task.needAuthed = false;
                            if (type == 701) {
                                task.retryCount = 1;
                            }
                        }
                        task.limitFlow = true;
                        if (type == f.CTRL_INDEX || type == JsApiChooseMedia.CTRL_INDEX || type == 220 || type == JsApiUploadWeRunData.CTRL_INDEX || type == p.CTRL_INDEX || type == 326 || type == 327) {
                            task.limitFlow = false;
                        }
                        task.channelStrategy = 0;
                        if (type == 233 || type == 835 || type == bc.CTRL_BYTE) {
                            task.channelStrategy = 1;
                        }
                        task.sendOnly = false;
                        if (type == 10 || type == 268369922) {
                            task.sendOnly = true;
                        }
                        if (rVar.KO().KN() && rVar.getUri() != null && rVar.getUri().length() > 0) {
                            task.channelSelect |= 1;
                        }
                        if (task.cmdID != 0) {
                            task.channelSelect |= 2;
                        }
                        task.reportArg = String.valueOf(type);
                        if (type == 522) {
                            task.totalTimeout = 300000;
                            task.priority = 0;
                        }
                        if (type == 710) {
                            task.totalTimeout = 15000;
                            task.serverProcessCost = 0;
                        }
                        x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", Integer.valueOf(i3), Integer.valueOf(task.taskID), Integer.valueOf(rVar.Kn()), Integer.valueOf(task.channelSelect), task.cgi, Boolean.valueOf(task.needAuthed));
                        i2 = i3;
                    } else {
                        i3++;
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bi.i(e));
                }
            }
            i2 = -1;
        }
        if (-1 != i2) {
            if (i == 1) {
                task.retryCount = 0;
            }
            StnLogic.startTask(task);
        } else {
            x.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        x.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=" + i2);
        return i2;
    }

    public final void reset() {
        int i = 0;
        x.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
        StnLogic.reset();
        synchronized (this.ict) {
            while (true) {
                int i2 = i;
                if (i2 < 100) {
                    if (this.ict[i2] != null) {
                        try {
                            x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i2), Integer.valueOf(this.ict[i2].icx.getType()), Integer.valueOf(this.ict[i2].icx.Kn()));
                            this.ict[i2] = null;
                        } catch (Throwable e) {
                            x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bi.i(e));
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public final void e(int i, int i2, String str) {
        x.i("MicroMsg.MMNativeNetTaskAdapter", "clearTaskAndCallback errType=" + i + ", errCode=" + i2 + ", errMsg=" + str);
        StnLogic.clearTask();
        StnLogic.reset();
        a[] aVarArr = new a[100];
        synchronized (this.ict) {
            for (int i3 = 0; i3 < 100; i3++) {
                aVarArr[i3] = this.ict[i3];
                this.ict[i3] = null;
            }
        }
        for (int i4 = 0; i4 < 100; i4++) {
            if (aVarArr[i4] != null) {
                try {
                    x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi clearTaskAndCallback outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i4), Integer.valueOf(aVarArr[i4].icx.getType()), Integer.valueOf(aVarArr[i4].icx.Kn()));
                    aVarArr[i4].icy.a(i4, i, i2, str, aVarArr[i4].icx, null);
                } catch (Throwable e) {
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bi.i(e));
                }
            }
        }
    }

    final int iU(int i) {
        int i2 = 0;
        synchronized (this.ict) {
            int iV = iV(i);
            if (-1 == iV) {
                x.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
            } else {
                try {
                    i2 = this.ict[iV].icx.KP().KT();
                } catch (Throwable e) {
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bi.i(e));
                }
            }
        }
        return i2;
    }

    final boolean a(int i, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        synchronized (this.ict) {
            int iV = iV(i);
            if (-1 == iV) {
                return false;
            }
            boolean a;
            try {
                x.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s", Integer.valueOf(i2), Boolean.valueOf(this.ict[iV].icz.KB()), bi.bA(this.ict[iV].icz.Ky()));
                this.ict[iV].icx.KO().H(this.ict[iV].icz.CM());
                this.ict[iV].icx.KO().eE(this.ict[iV].icz.Cn());
                a = this.ict[iV].icx.KO().a(this.ict[iV].icx.getType(), this.ict[iV].icz.CM(), this.ict[iV].icz.Ky(), this.ict[iV].icz.KA(), 0, this.ict[iV].icz.KB());
                if (a) {
                    byteArrayOutputStream.write(this.ict[iV].icx.KO().KH());
                } else {
                    iArr[0] = 0;
                    d.pVE.a(162, (long) iArr[0], 1, false);
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
                }
            } catch (Throwable e) {
                iArr[0] = 1;
                d.pVE.a(162, (long) iArr[0], 1, false);
                x.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", bi.i(e));
                a = false;
            } catch (Throwable e2) {
                iArr[0] = 2;
                d.pVE.a(162, (long) iArr[0], 1, false);
                x.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", bi.i(e2));
                a = false;
            } catch (Throwable e22) {
                iArr[0] = 3;
                d.pVE.a(162, (long) iArr[0], 1, false);
                x.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", bi.i(e22));
                a = false;
            }
            x.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", Boolean.valueOf(a));
            return a;
        }
    }

    final int a(int i, byte[] bArr, int[] iArr, int[] iArr2) {
        int iV;
        Throwable e;
        synchronized (this.ict) {
            iV = iV(i);
            if (-1 == iV) {
                iV = -1;
            } else {
                int i2 = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
                try {
                    byte[] KL = this.ict[iV].icx.KO().KL();
                    h KP = this.ict[iV].icx.KP();
                    if (KP.a(this.ict[iV].icx.getType(), bArr, KL)) {
                        iV = KP.KR();
                        iArr2[0] = 0;
                        if ((iV & 2) == 0) {
                            iArr2[0] = iArr2[0] | 2;
                            d.pVE.a(656, 0, 1, false);
                        }
                        if ((iV & 4) == 0) {
                            iArr2[0] = iArr2[0] | 4;
                            d.pVE.a(656, 1, 1, false);
                        }
                        if (!(KP.Ky() == null || -13 != KP.KT() || aa.VX() == null)) {
                            aa.VX().VB();
                        }
                        int i3;
                        if (-13 == KP.KT()) {
                            i3 = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            try {
                                iArr[0] = KP.KT();
                                iV = i3;
                            } catch (RemoteException e2) {
                                e = e2;
                                i2 = i3;
                                d.pVE.a(162, 5, 1, false);
                                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bi.i(e));
                                iV = i2;
                                return iV;
                            } catch (Exception e3) {
                                e = e3;
                                i2 = i3;
                                d.pVE.a(162, 7, 1, false);
                                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bi.i(e));
                                iV = i2;
                                return iV;
                            }
                        } else if (-3002 == KP.KT() || -3003 == KP.KT()) {
                            i3 = StnLogic.RESP_FAIL_HANDLE_TASK_END;
                            iArr[0] = KP.KT();
                            iV = i3;
                        } else if (-3001 == KP.KT()) {
                            i3 = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            iArr[0] = KP.KT();
                            iV = i3;
                        } else {
                            iV = StnLogic.RESP_FAIL_HANDLE_NORMAL;
                        }
                    } else {
                        d.pVE.a(162, 4, 1, false);
                        x.e("MicroMsg.MMNativeNetTaskAdapter", "buf to resp failed, change server and try again");
                        iV = i2;
                    }
                } catch (RemoteException e4) {
                    e = e4;
                    d.pVE.a(162, 5, 1, false);
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bi.i(e));
                    iV = i2;
                    return iV;
                } catch (Exception e5) {
                    e = e5;
                    d.pVE.a(162, 7, 1, false);
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", bi.i(e));
                    iV = i2;
                    return iV;
                }
            }
        }
        return iV;
    }

    final int iV(int i) {
        int i2 = 0;
        while (i2 < 100 && (this.ict[i2] == null || i != this.ict[i2].taskId)) {
            i2++;
        }
        if (100 <= i2) {
            return -1;
        }
        return i2;
    }
}
