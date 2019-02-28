package com.tencent.mm.plugin.ipcall.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiAdDataReport;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.f.c;
import com.tencent.mm.plugin.ipcall.a.f.d;
import com.tencent.mm.plugin.ipcall.a.f.e;
import com.tencent.mm.plugin.ipcall.a.f.f;
import com.tencent.mm.plugin.ipcall.a.f.h;
import com.tencent.mm.plugin.ipcall.a.f.i;
import com.tencent.mm.protocal.c.azo;
import com.tencent.mm.protocal.c.azq;
import com.tencent.mm.protocal.c.azw;
import com.tencent.mm.protocal.c.azx;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.Iterator;

public final class g implements com.tencent.mm.plugin.ipcall.a.a.a.a, com.tencent.mm.plugin.ipcall.a.a.b.a {
    public boolean fEQ = false;
    public int nIi = 0;
    public int nIj = 0;
    public int nIk = 0;
    public boolean nIl = false;
    public boolean nIm = false;
    public a nIn;
    public d nIo = new d();
    i nIp = new i();
    com.tencent.mm.plugin.ipcall.a.f.a nIq = new com.tencent.mm.plugin.ipcall.a.f.a();
    h nIr = new h();
    c nIs = new c();
    public e nIt = new e();
    com.tencent.mm.plugin.ipcall.a.f.g nIu = new com.tencent.mm.plugin.ipcall.a.f.g();
    f nIv = new f();
    public com.tencent.mm.plugin.ipcall.a.a.c nIw;
    public boolean nIx = false;
    public boolean nIy = false;
    n nIz = new com.tencent.mm.network.n.a() {
        public final void eq(int i) {
            int i2 = 0;
            x.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", Integer.valueOf(i));
            if (i.aUf().nKq) {
                f aUi = i.aUi();
                if (aUi.nIg == 4 || aUi.nIg == 5) {
                    i2 = 1;
                }
                if (i2 != 0 && i == 4 && g.this.nIv != null) {
                    g.this.nIv.a(g.this.nIw);
                }
            }
        }
    };

    public interface a {
        void A(String str, String str2, int i);

        void aTA();

        void aTw();

        void aTx();

        void aTy();

        void aTz();

        void bu(String str, int i);

        void bv(String str, int i);

        void bw(String str, int i);

        void w(String str, String str2, int i);

        void x(String str, String str2, int i);

        void y(String str, String str2, int i);

        void z(String str, String str2, int i);
    }

    public final void aUc() {
        if (this.nIw.nJJ) {
            x.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
        }
        this.nIl = true;
        x.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", Integer.valueOf(this.nIw.nJe), Integer.valueOf(this.nIw.nJh));
        this.nIs.stop();
        this.nIp.stop();
        this.nIq.a(this.nIw);
        this.nIu.a(this.nIw);
    }

    public final void rK(int i) {
        if (!this.nIw.nJJ) {
            x.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
        }
        x.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", Integer.valueOf(this.nIw.nJe), Integer.valueOf(this.nIw.nJh));
        this.nIm = true;
        this.nIs.stop();
        this.nIp.stop();
        this.nIr.nMi = false;
        this.nIr.nMh = i;
        this.nIr.a(this.nIw);
        this.nIu.a(this.nIw);
    }

    private void fV(boolean z) {
        x.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", Boolean.valueOf(z), Boolean.valueOf(this.nIl), Boolean.valueOf(this.nIm));
        if (this.nIl || this.nIm) {
            x.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
        } else if (z) {
            if (this.nIn != null) {
                if (this.nIw.nJt) {
                    this.nIn.aTw();
                } else {
                    this.nIn.A(this.nIw.nJl, this.nIw.lUd, this.nIw.nJk);
                }
            }
            x.i("MicroMsg.IPCallSvrLogic", "start sync");
            this.nIp.a(this.nIw);
        } else if (this.nIn == null) {
        } else {
            if (this.nIw.nJq) {
                this.nIn.x(this.nIw.nJl, this.nIw.lUd, this.nIw.nJk);
            } else if (this.nIw.nJr) {
                this.nIn.y(this.nIw.nJl, this.nIw.lUd, this.nIw.nJk);
            } else if (this.nIw.nJs) {
                this.nIn.z(this.nIw.nJl, this.nIw.lUd, this.nIw.nJk);
            } else if (this.nIw.nJt) {
                this.nIn.w(this.nIw.nJl, this.nIw.lUd, this.nIw.nJk);
            } else {
                this.nIn.A(this.nIw.nJl, this.nIw.lUd, this.nIw.nJk);
            }
        }
    }

    private void fW(boolean z) {
        x.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", Boolean.valueOf(z));
        if (z) {
            this.nIi = 0;
            return;
        }
        this.nIi++;
        if (this.nIi >= 2) {
            x.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
            this.nIs.stop();
            if (i.aUi().aUb() && this.nIn != null) {
                this.nIn.aTA();
            }
        }
    }

    private void l(boolean z, int i) {
        x.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", Boolean.valueOf(z));
        if (!z && i < 0 && this.nIk <= 0) {
            this.nIk++;
            x.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", Integer.valueOf(this.nIk));
            this.nIq.a(this.nIw);
        }
    }

    private void m(boolean z, int i) {
        x.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", Boolean.valueOf(z), Boolean.valueOf(this.nIr.nMi));
        if (!z && i < 0 && this.nIj <= 0) {
            this.nIj++;
            x.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", Integer.valueOf(this.nIj), Boolean.valueOf(this.nIr.nMi));
            this.nIr.a(this.nIw);
        }
    }

    private void fX(boolean z) {
        int i = 1;
        x.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", Boolean.valueOf(z));
        if (z && i.aUf().nKq) {
            i.aUf().rM(this.nIw.nJz);
        }
        if (!z) {
            x.e("MicroMsg.IPCallSvrLogic", "sync failed!");
            this.nIp.stop();
            if (i.aUi().nIg != 3) {
                i = 0;
            }
            if (i != 0 && this.nIn != null) {
                this.nIn.bw(this.nIw.lUd, this.nIw.nJk);
            }
        } else if (this.nIw != null && z) {
            rL(this.nIw.aUw());
        }
    }

    private void fY(boolean z) {
        x.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", Boolean.valueOf(z));
        if (z && i.aUf().nKq) {
            i.aUf().rM(this.nIw.nJz);
        }
        if (this.nIw != null && z) {
            int aUw = this.nIw.aUw();
            if (aUw == 2 || aUw == 1) {
                if (this.nIy) {
                    x.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
                    return;
                } else {
                    as.CN().a(new o(this.nIw.nJe, this.nIw.nJf, this.nIw.aUv(), this.nIw.nJg, false), 0);
                }
            }
            rL(this.nIw.aUw());
        }
    }

    public final boolean rL(int i) {
        switch (i) {
            case 1:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
                if (this.nIx) {
                    return true;
                }
                this.nIx = true;
                if (this.nIn == null) {
                    return true;
                }
                this.nIn.aTx();
                return true;
            case 2:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", Boolean.valueOf(this.nIl), Boolean.valueOf(this.nIm));
                if (this.nIl || this.nIm) {
                    return true;
                }
                this.nIp.stop();
                if (this.fEQ) {
                    return true;
                }
                this.fEQ = true;
                if (this.nIw != null) {
                    this.nIw.nJJ = true;
                }
                if (this.nIn != null) {
                    this.nIn.aTy();
                }
                this.nIs.a(this.nIw);
                return true;
            case 3:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
                this.nIp.stop();
                this.nIs.stop();
                if (this.nIn == null) {
                    return true;
                }
                this.nIn.bv(this.nIw.lUd, this.nIw.nJk);
                return true;
            case 4:
            case 7:
            case 8:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
                if (this.nIw.nJs) {
                    if (this.nIn == null) {
                        return true;
                    }
                    this.nIn.z(this.nIw.nJl, this.nIw.lUd, this.nIw.nJk);
                    return true;
                } else if (this.nIn == null) {
                    return true;
                } else {
                    this.nIn.bu(this.nIw.lUd, this.nIw.nJk);
                    return true;
                }
            case 5:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
                if (this.nIn == null) {
                    return true;
                }
                this.nIn.aTz();
                return true;
            case 6:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
                this.nIw.nJq = true;
                if (this.nIn == null) {
                    return true;
                }
                this.nIn.x(this.nIw.nJl, this.nIw.lUd, this.nIw.nJk);
                return true;
            default:
                x.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", Integer.valueOf(i));
                return false;
        }
    }

    private void fZ(boolean z) {
        buw buw = null;
        x.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", Boolean.valueOf(z));
        if (z) {
            buw buw2;
            com.tencent.mm.plugin.ipcall.a.c.a aUf = i.aUf();
            com.tencent.mm.plugin.ipcall.a.a.c cVar = this.nIw;
            x.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
            if (cVar == null || cVar.krz == null || cVar.krz.size() <= 0) {
                buw2 = null;
            } else {
                buw2 = com.tencent.mm.plugin.ipcall.b.c.Y(cVar.krz);
            }
            if (!(cVar == null || cVar.nJC == null || cVar.nJC.size() <= 0)) {
                buw = com.tencent.mm.plugin.ipcall.b.c.Y(cVar.nJC);
            }
            aUf.nKn.a(buw2, buw2, buw, 0, 0);
        }
    }

    public final void a(int i, Object obj, int i2, int i3) {
        if (c(i, obj, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
            return;
        }
        switch (i) {
            case 1:
                fV(true);
                return;
            case 3:
                l(true, i3);
                return;
            case 4:
                m(true, i3);
                return;
            case 6:
                fZ(true);
                return;
            case 8:
                fY(true);
                return;
            default:
                return;
        }
    }

    public final void b(int i, Object obj, int i2, int i3) {
        if (c(i, obj, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
            return;
        }
        switch (i) {
            case 1:
                fV(false);
                return;
            case 3:
                l(false, i3);
                return;
            case 4:
                m(false, i3);
                return;
            case 6:
                fZ(false);
                return;
            case 8:
                fY(false);
                return;
            default:
                return;
        }
    }

    public final void a(int i, k kVar, int i2, int i3) {
        if (c(i, kVar, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
            return;
        }
        switch (i) {
            case 2:
                fX(true);
                return;
            case 5:
                fW(true);
                return;
            default:
                return;
        }
    }

    public final void b(int i, k kVar, int i2, int i3) {
        if (c(i, kVar, i2, i3)) {
            x.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
            return;
        }
        switch (i) {
            case 2:
                fX(false);
                return;
            case 5:
                fW(false);
                return;
            default:
                return;
        }
    }

    private boolean c(int i, Object obj, int i2, int i3) {
        if (this.nIw == null || obj == null) {
            x.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
            return true;
        }
        Object obj2;
        Iterator it;
        com.tencent.mm.plugin.ipcall.a.a.d dVar;
        switch (i) {
            case 1:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.i) {
                    com.tencent.mm.plugin.ipcall.a.d.i iVar = (com.tencent.mm.plugin.ipcall.a.d.i) obj;
                    bek bek = iVar.nLn;
                    if (this.nIw.nJh == iVar.nLm.wMS) {
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", Integer.valueOf(this.nIw.nJh));
                        b aUg = i.aUg();
                        if (aUg.nJh == this.nIw.nJh) {
                            x.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", Integer.valueOf(i3));
                            aUg.nKF = i3;
                        }
                        if (i2 == 0 && i3 == 0) {
                            if (this.nIw != null) {
                                this.nIw.nJe = bek.wil;
                                this.nIw.nJf = bek.wim;
                                this.nIw.nJg = bek.wMU;
                                this.nIw.nJm = bek.wNd;
                                this.nIw.nJo = bek.wNe * 1000;
                                this.nIw.nJv = bek.nJv;
                                this.nIw.nJw = bek.nJw;
                                this.nIw.krz = bek.vQG;
                                this.nIw.nJC = bek.wNf;
                                this.nIw.nJH = bek.wNg;
                                if (bek.nJD > 0) {
                                    this.nIw.nJD = bek.nJD;
                                }
                                this.nIw.nJx = bek.nJx;
                                this.nIw.nJy = bek.nJy;
                                this.nIw.nJu = bek.wNi;
                                if (bek.nJA > 0) {
                                    this.nIw.nJA = bek.nJA - 1;
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.nIw.nJA + "] from Invite resp");
                                } else {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                                    this.nIw.nJA = 2;
                                }
                                this.nIw.nJB = bek.wNh;
                                x.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", Integer.valueOf(bek.nJp));
                                if (bek.nJp > 0) {
                                    this.nIw.nJt = false;
                                    this.nIw.nJp = bek.nJp;
                                } else {
                                    this.nIw.nJt = true;
                                    this.nIw.nJp = 0;
                                }
                                this.nIw.nJl = bek.nJl;
                                this.nIw.nJk = bek.nJk;
                                this.nIw.lUc = i3;
                                this.nIw.lUd = bi.oM(com.tencent.mm.platformtools.n.a(bek.wRa.vRT));
                                break;
                            }
                        }
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
                        if (bek.wRa == null) {
                            this.nIw.nJl = "";
                            this.nIw.nJk = 2;
                            this.nIw.lUd = ad.getContext().getString(R.l.dNx);
                            this.nIw.lUc = i3;
                            break;
                        }
                        if (i3 == 433) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                            this.nIw.nJq = true;
                        } else if (i3 == aq.CTRL_INDEX) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                            this.nIw.nJr = true;
                        } else if (i3 == JsApiAdDataReport.CTRL_INDEX) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                            this.nIw.nJs = true;
                        }
                        if (bek.nJp > 0) {
                            this.nIw.nJt = false;
                            this.nIw.nJp = bek.nJp;
                        } else {
                            this.nIw.nJt = true;
                            this.nIw.nJp = 0;
                        }
                        this.nIw.nJl = bek.nJl;
                        this.nIw.nJk = bek.nJk;
                        this.nIw.lUc = i3;
                        if (bek.wRa != null) {
                            this.nIw.lUd = bi.oM(com.tencent.mm.platformtools.n.a(bek.wRa.vRT));
                            x.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", Integer.valueOf(bek.nJk), Integer.valueOf(i3), this.nIw.lUd);
                            break;
                        }
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", Integer.valueOf(this.nIw.nJh), Integer.valueOf(iVar.nLm.wMS));
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
                return true;
                break;
            case 2:
                if (obj instanceof o) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    o oVar = (o) obj;
                    azw azw = oVar.nLz;
                    if (this.nIw.nJe == oVar.nLy.wil) {
                        if (i2 == 0 && i3 == 0) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", Integer.valueOf(azw.wil), Integer.valueOf(azw.wNr), Integer.valueOf(azw.wNs), Integer.valueOf(azw.wNp));
                            if (azw.wil == this.nIw.nJe && azw.wim == this.nIw.nJf) {
                                if (azw.wNs == this.nIw.nJm) {
                                    x.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
                                    if (azw.wNp > this.nIw.nJn) {
                                        this.nIw.nJn = azw.wNp;
                                        if (azw.wNr != 0) {
                                            this.nIw.jlI = azw.wNr;
                                        }
                                    }
                                } else {
                                    x.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
                                    obj2 = null;
                                    it = this.nIw.nJE.iterator();
                                    while (true) {
                                        Object obj3 = obj2;
                                        if (it.hasNext()) {
                                            dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it.next();
                                            if (dVar.nJK == azw.wNs) {
                                                if (azw.wNp > dVar.nJn) {
                                                    dVar.nJn = azw.wNp;
                                                    if (azw.wNr != 0) {
                                                        dVar.gRd = azw.wNr;
                                                    }
                                                }
                                                obj2 = 1;
                                            } else {
                                                obj2 = obj3;
                                            }
                                        } else if (obj3 == null) {
                                            dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                            dVar.nJK = azw.wNs;
                                            dVar.gRd = azw.wNr;
                                            dVar.nJn = azw.wNp;
                                            this.nIw.nJE.add(dVar);
                                        }
                                    }
                                }
                                if (azw.lUc == TencentLocation.ERROR_UNKNOWN || azw.lUc == 484) {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
                                    this.nIw.nJs = true;
                                }
                                this.nIw.lUd = azw.lUd;
                                this.nIw.lUc = azw.lUc;
                                this.nIw.nJk = azw.nJk;
                                this.nIw.nJl = azw.nJl;
                                this.nIw.nJz = azw.nJz;
                                break;
                            }
                        }
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nIw.nJe), Integer.valueOf(oVar.nLy.wil));
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
                return true;
            case 3:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.a) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (this.nIw.nJh != ((com.tencent.mm.plugin.ipcall.a.d.a) obj).nKV.wMS) {
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", Integer.valueOf(this.nIw.nJh), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.a) obj).nKV.wMS));
                        return true;
                    }
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
                return true;
                break;
            case 4:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.n) {
                    if (this.nIw.nJe == ((com.tencent.mm.plugin.ipcall.a.d.n) obj).nLw.wil) {
                        if (i2 != 0 || i3 != 0) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
                            break;
                        }
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                        this.nIw.jlI = 5;
                        break;
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nIw.nJe), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.n) obj).nLw.wil));
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                return true;
                break;
            case 5:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.h) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (this.nIw.nJe != ((com.tencent.mm.plugin.ipcall.a.d.h) obj).nLk.wil) {
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nIw.nJe), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.h) obj).nLk.wil));
                        return true;
                    }
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
                return true;
                break;
            case 6:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.k) {
                    com.tencent.mm.plugin.ipcall.a.d.k kVar = (com.tencent.mm.plugin.ipcall.a.d.k) obj;
                    azq azq = kVar.nLr;
                    if (this.nIw.nJe == kVar.nLq.wil) {
                        if (i2 != 0 || i3 != 0) {
                            x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
                            break;
                        }
                        x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
                        this.nIw.krz = azq.vQG;
                        this.nIw.nJC = azq.wNf;
                        break;
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nIw.nJe), Integer.valueOf(kVar.nLq.wil));
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
                return true;
                break;
            case 8:
                if (obj instanceof azo) {
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
                    azo azo = (azo) obj;
                    if (this.nIw.nJe == azo.wil) {
                        if (i2 == 0 && i3 == 0) {
                            this.nIw.nJz = azo.nJz;
                            x.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", Integer.valueOf(azo.wNj.size()));
                            it = azo.wNj.iterator();
                            while (it.hasNext()) {
                                azx azx = (azx) it.next();
                                if (this.nIw.nJm == azx.wNs) {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", Integer.valueOf(this.nIw.nJm), Integer.valueOf(azx.wLS), Integer.valueOf(azx.wNt));
                                    if (azx.wNt > this.nIw.nJn) {
                                        this.nIw.nJn = azx.wNt;
                                        if (azx.wLS != 0) {
                                            this.nIw.jlI = azx.wLS;
                                        }
                                    }
                                } else {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", Integer.valueOf(azx.wNs), Integer.valueOf(azx.wLS), Integer.valueOf(azx.wNt));
                                    Object obj4 = null;
                                    Iterator it2 = this.nIw.nJE.iterator();
                                    while (it2.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it2.next();
                                        if (dVar.nJK == azx.wNs) {
                                            if (azx.wNt > dVar.nJn) {
                                                dVar.nJn = azx.wNt;
                                                if (azx.wLS != 0) {
                                                    dVar.gRd = azx.wLS;
                                                }
                                            }
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj4;
                                        }
                                        obj4 = obj2;
                                    }
                                    if (obj4 == null) {
                                        dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                        dVar.nJK = azx.wNs;
                                        dVar.gRd = azx.wLS;
                                        dVar.nJn = azx.wNt;
                                        this.nIw.nJE.add(dVar);
                                    }
                                }
                                if (azx.lUc == TencentLocation.ERROR_UNKNOWN || azx.lUc == 484) {
                                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
                                    this.nIw.nJs = true;
                                }
                                this.nIw.lUd = azx.lUd;
                                this.nIw.lUc = azx.lUc;
                                this.nIw.nJk = azx.nJk;
                                this.nIw.nJl = azx.nJl;
                            }
                            break;
                        }
                    }
                    x.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nIw.nJe), Integer.valueOf(azo.wil));
                    return true;
                }
                x.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
                return true;
                break;
        }
        return false;
    }
}
