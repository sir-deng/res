package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.protocal.c.btg;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class a {
    public v2protocal nKn = new v2protocal(this.nKo);
    private ag nKo = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message == null) {
                super.handleMessage(message);
                return;
            }
            x.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
            a aVar;
            switch (message.arg1) {
                case 3:
                    x.d("MicroMsg.VoipCSEngine", "start dev!");
                    return;
                case 5:
                    x.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        x.i("MicroMsg.VoipCSEngine", "channel broken...");
                        b.bJE().sCu = 1;
                    } else if (message.arg2 == 5) {
                        x.i("MicroMsg.VoipCSEngine", "channel event network failer...");
                        b.bJE().sCu = 6;
                    } else {
                        x.i("MicroMsg.VoipCSEngine", "channel connect fail...");
                        b.bJE().sCu = 5;
                    }
                    aVar = a.this;
                    x.i("MicroMsg.VoipCSEngine", "channel connect failed!");
                    b.bJE().bjS = 1;
                    if (aVar.sDJ != null) {
                        aVar.sDJ.bJS();
                        return;
                    }
                    return;
                case 6:
                    x.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
                    c bJE = b.bJE();
                    x.d("MicroMsg.VoipCSReportHelper", "channelConnect");
                    bJE.sCx = 1;
                    aVar = a.this;
                    x.i("MicroMsg.VoipCSEngine", "channel connect!");
                    if (aVar.nKq) {
                        x.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
                        return;
                    }
                    aVar.nKq = true;
                    x.i("MicroMsg.VoipCSEngine", "start engine");
                    aVar.nKn.setInactive();
                    x.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
                    if (!aVar.nKq) {
                        x.d("MicroMsg.VoipCSEngine", "channel not connect now");
                    }
                    aVar.nKn.setActive();
                    int startEngine = aVar.nKn.startEngine();
                    if (startEngine == 0) {
                        x.i("MicroMsg.VoipCSEngine", "start engine suc!");
                        int[] iArr = new int[]{b.bJC().nKn.svq, b.bJC().nKn.svr};
                        ByteBuffer allocate = ByteBuffer.allocate(8);
                        allocate.asIntBuffer().put(iArr);
                        if (b.bJC().nKn.setAppCmd(34, allocate.array(), 2) < 0) {
                            x.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + iArr[0] + "," + iArr[1] + ",ret:" + startEngine);
                        }
                        b.bJE().sCv = 1;
                    } else {
                        x.i("MicroMsg.VoipCSEngine", "start engine fail!");
                        b.bJE().sCv = 0;
                    }
                    if (aVar.sDJ != null && b.bJD().sDa != 2) {
                        aVar.sDJ.aTC();
                        b.bJD().sDa = 2;
                        return;
                    }
                    return;
                case 8:
                    byte[] bArr = (byte[]) message.obj;
                    a aVar2 = a.this;
                    try {
                        btg btg = (btg) new btg().aH(bArr);
                        com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + btg.xbl);
                        switch (btg.xbl) {
                            case 3:
                                if (btg.xbm != null) {
                                    Object obj = btg.xbm.oz;
                                    com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.VoipCSEngine", "steve: remote new network type:" + obj);
                                    int appCmd = aVar2.nKn.setAppCmd(HardCoderJNI.SCENE_QUIT_CHATTING, obj, 4);
                                    if (appCmd < 0) {
                                        com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + obj + "fail:" + appCmd + ", [roomid=" + aVar2.nKn.suj + ", roomkey=" + aVar2.nKn.nJf + "]");
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                                return;
                            default:
                                return;
                        }
                    } catch (Exception e) {
                        com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                        return;
                    }
                    com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                    return;
                case 100:
                    com.tencent.mm.plugin.voip.b.a.b((byte[]) message.obj, "MicroMsg.VoipCSEngine", message.arg2);
                    return;
                case 101:
                    com.tencent.mm.plugin.voip.b.a.b((byte[]) message.obj, "MicroMsg.VoipCSEngine-JNI_CORE", message.arg2);
                    return;
                default:
                    return;
            }
        }
    };
    public boolean nKp = false;
    public boolean nKq = false;
    public a sDJ = null;

    public interface a {
        void aTC();

        void bJS();
    }

    public static int Nq(String str) {
        String[] split = str.split("\\.");
        return bi.getInt(split[3], 0) + (((bi.getInt(split[0], 0) << 24) + (bi.getInt(split[1], 0) << 16)) + (bi.getInt(split[2], 0) << 8));
    }
}
