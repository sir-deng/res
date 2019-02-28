package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.audio.c.e;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.p.AnonymousClass1;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.cba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.IOException;

public class WearMessageLogic extends BroadcastReceiver {

    private class b extends d {
        public int pYL;
        public int toR;
        public int toS;
        public byte[] toT;

        private b() {
        }

        /* synthetic */ b(WearMessageLogic wearMessageLogic, byte b) {
            this();
        }

        protected final void execute() {
            switch (this.toS) {
                case CdnLogic.kMediaLittleAppPacket /*30001*/:
                    p pVar = a.bPh().tok.toE;
                    int i = this.pYL;
                    byte[] bArr = this.toT;
                    if (!pVar.iUs.contains(Integer.valueOf(i))) {
                        cba cba = new cba();
                        try {
                            cba.aH(bArr);
                        } catch (IOException e) {
                        }
                        if (pVar.tpA != i) {
                            pVar.reset();
                            pVar.tpA = i;
                            x.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", Integer.valueOf(pVar.tpA));
                            com.tencent.mm.loader.stub.b.deleteFile(p.tpv);
                            if (pVar.tpy == null) {
                                pVar.tpy = new e();
                                pVar.tpy.cL(p.tpv);
                            }
                            if (pVar.tpx == null) {
                                pVar.tpx = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
                                if (pVar.tpx.start() != 0) {
                                    pVar.tpB = -2;
                                    return;
                                }
                            }
                            String str = cba.xgB;
                            if (pVar.tpw == null) {
                                ah.y(new AnonymousClass1(str));
                            }
                            pVar.a(i, cba);
                            return;
                        } else if (cba.xhe) {
                            x.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", Integer.valueOf(i));
                            pVar.reset();
                            return;
                        } else if (cba.xhd) {
                            pVar.a(i, cba);
                            if (pVar.tpy != null) {
                                pVar.tpy.vK();
                                pVar.tpy = null;
                                x.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
                            }
                            if (pVar.tpx != null) {
                                pVar.tpx.stop();
                                pVar.tpx = null;
                                x.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
                            }
                            if (pVar.tpw != null) {
                                pVar.tpw.hYm = true;
                                if (!pVar.fMC) {
                                    as.CN().a(pVar.tpw, 0);
                                }
                                pVar.tpw = null;
                                x.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
                                return;
                            }
                            return;
                        } else {
                            pVar.a(i, cba);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }

        public final String getName() {
            return "LongConnectTask";
        }
    }

    private class a extends d {
        public int pYL;
        public int toR;
        public int toS;
        public byte[] toT;

        private a() {
        }

        /* synthetic */ a(WearMessageLogic wearMessageLogic, byte b) {
            this();
        }

        protected final void execute() {
            x.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", toString());
            com.tencent.mm.plugin.wear.model.e.a zW = a.bPh().toi.zW(this.toS);
            if (zW != null) {
                zW.b(this.toR, this.pYL, this.toS, this.toT);
            }
        }

        public final String getName() {
            return "HttpMessageTask";
        }

        public final String toString() {
            return String.format("connectType=%d funId=%d sessionId=%d", new Object[]{Integer.valueOf(this.toR), Integer.valueOf(this.toS), Integer.valueOf(this.pYL)});
        }
    }

    private class c extends d {
        private c() {
        }

        /* synthetic */ c(WearMessageLogic wearMessageLogic, byte b) {
            this();
        }

        protected final void execute() {
            if (a.bPh().tok.bPn() != null) {
                a.bPh().tok.bPn().bPp();
            }
        }

        public final String getName() {
            return "RefreshConnectTask";
        }
    }

    public WearMessageLogic() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.wear.message");
        ad.getContext().registerReceiver(this, intentFilter, "com.tencent.mm.wear.message", null);
    }

    public void onReceive(Context context, Intent intent) {
        byte b = (byte) 0;
        if (intent.getAction().equals("com.tencent.mm.wear.message")) {
            Bundle extras = intent.getExtras();
            int i = extras.getInt("key_connecttype");
            if (i == 1) {
                Runnable aVar = new a();
                aVar.toR = i;
                aVar.toS = extras.getInt("key_funid");
                aVar.pYL = extras.getInt("key_sessionid");
                aVar.toT = extras.getByteArray("key_data");
                com.tencent.mm.plugin.wear.model.e.a zW = a.bPh().toi.zW(aVar.toS);
                if (zW != null) {
                    b = zW.zV(aVar.toS);
                }
                if (b != (byte) 0) {
                    ah.y(aVar);
                } else {
                    com.tencent.mm.sdk.f.e.post(aVar, "WearHttpMessageTask_" + aVar.toS);
                }
            } else if (i == 2) {
                d bVar = new b();
                bVar.toR = i;
                bVar.toS = extras.getInt("key_funid");
                bVar.pYL = extras.getInt("key_sessionid");
                bVar.toT = extras.getByteArray("key_data");
                a.bPh().tor.a(bVar);
            } else if (i == 3) {
                a.bPh().tor.a(new c());
            }
        }
    }
}
