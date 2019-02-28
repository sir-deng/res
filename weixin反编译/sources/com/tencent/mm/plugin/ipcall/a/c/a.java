package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.protocal.c.bwf;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class a {
    public v2protocal nKn = new v2protocal(this.nKo);
    private ag nKo = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message == null || message.what != 59998) {
                super.handleMessage(message);
                return;
            }
            x.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
            a aVar;
            switch (message.arg1) {
                case 3:
                    x.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
                    return;
                case 4:
                    x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
                    aVar = a.this;
                    x.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
                    if (aVar.nKs != null) {
                        aVar.nKs.aTB();
                        return;
                    }
                    return;
                case 5:
                    x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        x.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
                        a.a(a.this, 34);
                        return;
                    } else if (message.arg2 == 1) {
                        x.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
                        a.a(a.this, 20);
                        return;
                    } else if (message.arg2 == 5) {
                        x.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
                        a.a(a.this, 30);
                        return;
                    } else {
                        return;
                    }
                case 6:
                    aVar = a.this;
                    x.d("MicroMsg.IPCallEngineManager", "channel connect!");
                    if (aVar.nKq) {
                        x.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
                        return;
                    }
                    x.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", Integer.valueOf(aVar.nKn.startEngine()));
                    if (aVar.nKn.startEngine() == 0) {
                        aVar.nKn.suJ = 0;
                    } else {
                        aVar.nKn.suJ = 1;
                    }
                    aVar.nKn.setInactive();
                    aVar.nKq = true;
                    if (aVar.nKs != null) {
                        aVar.nKs.aTC();
                        return;
                    }
                    return;
                case 9:
                    x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
                    return;
                case 10:
                    x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
                    x.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
                    g aUe = i.aUe();
                    x.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
                    if (aUe.fEQ) {
                        x.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
                        return;
                    }
                    aUe.nIy = true;
                    if (aUe.nIw != null) {
                        aUe.nIw.jlI = 2;
                        as.CN().a(new o(aUe.nIw.nJe, aUe.nIw.nJf, aUe.nIw.aUv(), aUe.nIw.nJg, true), 0);
                    }
                    aUe.rL(2);
                    return;
                default:
                    return;
            }
        }
    };
    private boolean nKp = false;
    public boolean nKq = false;
    public boolean nKr = false;
    public a nKs = null;

    public interface a {
        void aTB();

        void aTC();

        void rH(int i);
    }

    static /* synthetic */ void a(a aVar, int i) {
        x.d("MicroMsg.IPCallEngineManager", "channel connect failed!");
        if (aVar.nKs != null) {
            aVar.nKs.rH(i);
        }
    }

    public final void aUz() {
        x.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
        if (!this.nKq) {
            x.d("MicroMsg.IPCallEngineManager", "channel not connect now");
        }
        this.nKn.setActive();
    }

    public final void aUA() {
        if (this.nKp) {
            x.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
            return;
        }
        x.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
        c cVar = i.aUe().nIw;
        if (cVar != null) {
            if (cVar.krz != null) {
                buw Y = com.tencent.mm.plugin.ipcall.b.c.Y(cVar.krz);
                buw Y2 = com.tencent.mm.plugin.ipcall.b.c.Y(cVar.nJC);
                bwf bwf = new bwf();
                bwf.xdY = 0;
                bwf.xdZ = 0;
                bwf.xea = 0;
                bwf.userName = "";
                bwf.mHK = "";
                this.nKn.a(Y, Y, Y2, bwf);
            }
            x.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
            this.nKn.sun = cVar.nJx;
            this.nKn.svg = cVar.nJA;
            if (cVar.nJB != null) {
                this.nKn.svh = cVar.nJB.toByteArray();
            }
            if (cVar.nJy != null) {
                this.nKn.suo = cVar.nJy.toByteArray();
            }
            this.nKn.nJe = cVar.nJe;
            this.nKn.nJf = cVar.nJf;
            this.nKn.nJm = cVar.nJm;
            this.nKn.suq = cVar.nJv;
            this.nKn.sup = cVar.nJw;
            this.nKn.sur = cVar.nJD;
            int configInfo = this.nKn.setConfigInfo(this.nKn.sui, (long) this.nKn.nJe, this.nKn.nJm, this.nKn.nJf, this.nKn.field_peerId, 1, this.nKn.sup, this.nKn.suq, this.nKn.sun, this.nKn.suo == null ? 0 : this.nKn.suo.length, this.nKn.suo, this.nKn.sur, 0, 0, this.nKn.svg, this.nKn.svh, 255, 0);
            x.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", Integer.valueOf(configInfo));
            if (configInfo == 0) {
                configInfo = this.nKn.connectToPeer();
            }
            if (configInfo < 0) {
                x.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", Integer.valueOf(configInfo));
                if (this.nKs != null) {
                    this.nKs.rH(21);
                }
            }
            this.nKp = true;
        }
    }

    public final void rM(int i) {
        if (this.nKq) {
            x.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", Integer.valueOf(i));
            if (this.nKn.SetDTMFPayload(i) < 0) {
                x.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", Integer.valueOf(this.nKn.SetDTMFPayload(i)));
            }
        }
    }

    public final void aUB() {
        this.nKq = false;
        this.nKp = false;
        this.nKr = false;
    }
}
