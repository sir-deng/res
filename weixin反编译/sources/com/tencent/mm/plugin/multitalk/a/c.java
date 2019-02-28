package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiVoiceSplitJoint;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.pb.talkroom.sdk.b;
import com.tencent.pb.talkroom.sdk.d;

public final class c implements e {
    a flv = new a() {
        public final void q(byte[] bArr, int i) {
            if (i <= 0) {
                x.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
            } else if (c.this.oLy != null) {
                c.this.oLy.R(bArr, i);
            }
        }

        public final void aK(int i, int i2) {
            x.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        }
    };
    com.tencent.mm.plugin.voip.model.a oLA = new com.tencent.mm.plugin.voip.model.a() {
        public final int M(byte[] bArr, int i) {
            int Q;
            if (c.this.oLz != null) {
                Q = c.this.oLz.Q(bArr, i);
            } else {
                Q = 0;
            }
            if (Q < 0) {
                return -1;
            }
            return 0;
        }
    };
    public d oLv;
    b oLw;
    com.tencent.mm.audio.b.c oLx;
    com.tencent.pb.talkroom.sdk.c oLy;
    b oLz;

    static /* synthetic */ void a(c cVar) {
        byte[] bArr = new byte[]{(byte) 0};
        byte[] bArr2 = new byte[2];
        if (q.gHG.gFb >= 0) {
            bArr2[0] = (byte) q.gHG.gFb;
            cVar.oLv.setAppCmd(au.CTRL_INDEX, bArr2, 1);
        } else if (q.gHG.gFb == -2) {
            cVar.oLv.setAppCmd(JsApiPrivateAddContact.CTRL_INDEX, bArr, 1);
        }
        if (q.gHG.gFe >= 0) {
            byte[] bArr3 = new byte[5];
            if (q.gHG.gFf >= 0 && q.gHG.gFg >= 0) {
                bArr3[0] = (byte) q.gHG.gFf;
                bArr3[1] = (byte) q.gHG.gFg;
                if (q.gHG.gFh >= 0) {
                    bArr3[2] = (byte) q.gHG.gFh;
                    bArr3[3] = (byte) q.gHG.gFe;
                    bArr3[4] = (byte) q.gHG.gFi;
                    cVar.oLv.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr3, 5);
                } else {
                    cVar.oLv.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr3, 2);
                }
            }
        } else if (q.gHG.gFe == -2) {
            cVar.oLv.setAppCmd(405, bArr, 1);
        }
        if (q.gHG.gFc >= 0) {
            bArr2[0] = (byte) q.gHG.gFc;
            cVar.oLv.setAppCmd(av.CTRL_INDEX, bArr2, 1);
        } else if (q.gHG.gFc == -2) {
            cVar.oLv.setAppCmd(409, bArr, 1);
        }
        if (q.gHG.gFn[0] > (short) 0 || q.gHG.gFn[1] > (short) 0) {
            bArr2[0] = (byte) 0;
            bArr2[1] = (byte) 0;
            if (q.gHG.gFn[0] > (short) 0 && q.gHG.gFn[0] < (short) 10000) {
                bArr2[0] = (byte) q.gHG.gFn[0];
            }
            if (q.gHG.gFn[1] > (short) 0 && q.gHG.gFn[1] < (short) 10000) {
                bArr2[1] = (byte) q.gHG.gFn[1];
            }
            cVar.oLv.setAppCmd(423, bArr2, 2);
        }
        if (q.gHG.gEE >= 0 || q.gHG.gEG >= 0) {
            bArr2[0] = (byte) -1;
            bArr2[1] = (byte) -1;
            if (q.gHG.gEE >= 0) {
                bArr2[0] = (byte) q.gHG.gEE;
            }
            if (q.gHG.gEG >= 0) {
                bArr2[1] = (byte) q.gHG.gEG;
            }
            cVar.oLv.setAppCmd(com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, bArr2, 2);
        }
        if (q.gHG.gEF >= 0 || q.gHG.gEH >= 0) {
            bArr2[0] = (byte) -1;
            bArr2[1] = (byte) -1;
            if (q.gHG.gEF >= 0) {
                bArr2[0] = (byte) q.gHG.gEF;
            }
            if (q.gHG.gEH >= 0) {
                bArr2[1] = (byte) q.gHG.gEH;
            }
            cVar.oLv.setAppCmd(415, bArr2, 2);
        }
        if (q.gHG.gEI >= 0 || q.gHG.gEJ >= 0) {
            bArr2[0] = (byte) -1;
            bArr2[1] = (byte) -1;
            if (q.gHG.gEI >= 0) {
                bArr2[0] = (byte) q.gHG.gEI;
            }
            if (q.gHG.gEJ >= 0) {
                bArr2[1] = (byte) q.gHG.gEJ;
            }
            cVar.oLv.setAppCmd(422, bArr2, 2);
        }
        if (q.gHG.gEK >= 0) {
            bArr2[0] = (byte) q.gHG.gEK;
            cVar.oLv.setAppCmd(416, bArr2, 1);
        }
        if (q.gHG.gEL >= 0 && q.gHG.gEL != 5) {
            bArr2[0] = (byte) q.gHG.gEL;
            cVar.oLv.setAppCmd(417, bArr2, 1);
        }
        if (q.gHG.gEM >= 0 && q.gHG.gEM != 5) {
            bArr2[0] = (byte) q.gHG.gEM;
            cVar.oLv.setAppCmd(418, bArr2, 1);
        }
        if (q.gHG.gEN >= 0) {
            bArr2[0] = (byte) q.gHG.gEN;
            cVar.oLv.setAppCmd(419, bArr2, 1);
        }
        if (1 == q.gHG.gFl) {
            byte[] bArr4 = new byte[30];
            for (int i = 0; i < 15; i++) {
                bArr4[i * 2] = (byte) (q.gHG.gFm[i] & 255);
                bArr4[(i * 2) + 1] = (byte) ((q.gHG.gFm[i] >> 8) & 255);
            }
            cVar.oLv.setAppCmd(420, bArr4, 30);
        }
        if (q.gHG.gFl == 0) {
            cVar.oLv.setAppCmd(421, bArr, 1);
        }
        if (q.gHG.gFp > 0) {
            bArr2[0] = (byte) q.gHG.gFp;
            cVar.oLv.setAppCmd(424, bArr2, 1);
        }
        if (q.gHG.gEO > 0) {
            bArr2[0] = (byte) q.gHG.gEO;
            cVar.oLv.setAppCmd(com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, bArr2, 4);
        }
        if (q.gHG.gFx >= 0) {
            cVar.oLv.setAppCmd(JsApiVoiceSplitJoint.CTRL_INDEX, new byte[]{(byte) q.gHG.gFx, (byte) q.gHG.gFy, (byte) q.gHG.gFz, (byte) q.gHG.gFA}, 4);
        }
    }

    public c() {
        x.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
        Context context = ad.getContext();
        d cIF = com.tencent.wecall.talkroom.model.e.cIF();
        com.tencent.wecall.talkroom.model.e.iN(context);
        this.oLv = cIF;
        this.oLv.cDQ();
        this.oLw = new b();
        int e = bi.e((Integer) as.Hk().get(1));
        this.oLv.a(o.bdB(), new com.tencent.pb.talkroom.sdk.e() {
            public final boolean m(int i, String str, String str2) {
                switch (i) {
                    case 0:
                        x.v(str, str2);
                        break;
                    case 1:
                        x.d(str, str2);
                        break;
                    case 2:
                        x.i(str, str2);
                        break;
                    case 3:
                        x.w(str, str2);
                        break;
                    case 4:
                        x.e(str, str2);
                        break;
                    case 5:
                        x.f(str, str2);
                        break;
                    default:
                        x.v(str, str2);
                        break;
                }
                return false;
            }

            public final boolean b(int i, int i2, byte[] bArr) {
                x.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + i + " cmdid " + i2);
                as.CN().a(new n(i, i2, bArr), 0);
                return false;
            }

            public final boolean bcB() {
                int yw = m.yw();
                x.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:" + yw);
                if ((yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    com.tencent.mm.compatible.loader.d.t(ad.getContext(), "libvoipCodec_v7a.so");
                } else if ((yw & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                    com.tencent.mm.compatible.loader.d.t(ad.getContext(), "libvoipCodec.so");
                } else {
                    com.tencent.mm.compatible.loader.d.t(ad.getContext(), "libvoipCodec_v5.so");
                }
                return true;
            }

            public final int yw() {
                return m.yw();
            }

            public final int bcC() {
                as.Hm();
                String ckJ = com.tencent.mm.y.c.Dc().ckJ();
                q.eK(ckJ);
                x.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: " + ckJ);
                c.a(c.this);
                return 0;
            }

            public final boolean gS(boolean z) {
                x.i("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", Boolean.valueOf(z));
                c.this.oLw.ga(z);
                return true;
            }

            public final int a(int i, int i2, b bVar) {
                int i3;
                c.this.oLz = bVar;
                f.a aVar = c.this.oLw;
                com.tencent.mm.plugin.voip.model.a aVar2 = c.this.oLA;
                if (aVar.fBn) {
                    x.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
                    i3 = -1;
                } else {
                    x.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay");
                    if (aVar.nJL == null) {
                        aVar.nJL = new com.tencent.mm.plugin.voip.model.b();
                        aVar.nJL.Y(i, i2, 0);
                    }
                    aVar.nJL.l(ad.getContext(), false);
                    aVar.nJL.soY = aVar2;
                    as.Hn().a(aVar);
                    aVar.nJZ = as.Hn().xY();
                    aVar.nJY = as.Hn().xS();
                    x.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", Boolean.valueOf(aVar.nJZ), Boolean.valueOf(aVar.nJY));
                    i3 = aVar.nJL.bGN();
                    aVar.hZB.requestFocus();
                    aVar.nJU.a(ad.getContext(), aVar);
                    aVar.fBn = true;
                }
                x.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", Boolean.valueOf(as.Hn().xX()), Boolean.valueOf(o.bdB().oLI));
                if (as.Hn().xX() != o.bdB().oLI && o.bdB().nIN.aiV()) {
                    c.this.oLw.ga(o.bdB().oLI);
                }
                return i3;
            }

            public final int a(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
                c.this.oLy = cVar;
                c.this.oLx = new com.tencent.mm.audio.b.c(i, 1, 7);
                c.this.oLx.et(i2);
                c.this.oLx.aR(true);
                c.this.oLx.vr();
                c.this.oLx.fkT = -19;
                c.this.oLx.n(1, false);
                c.this.oLx.aQ(true);
                c.this.oLx.fle = c.this.flv;
                if (c.this.oLx.vs()) {
                    return 1;
                }
                return -1;
            }

            public final boolean bcD() {
                x.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
                f.a aVar = c.this.oLw;
                if (aVar.fBn) {
                    x.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay");
                    synchronized (aVar.nJM) {
                        com.tencent.mm.sdk.f.e.post(new a(aVar.nJL), "MultiTalkAudioPlayer_stop");
                        aVar.fBn = false;
                        aVar.nJL = null;
                    }
                    aVar.nJU.dB(ad.getContext());
                    as.Hn().b(aVar);
                    aVar.hZB.zk();
                }
                return true;
            }

            public final boolean bcE() {
                x.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
                try {
                    if (c.this.oLx != null) {
                        c.this.oLx.fle = null;
                        c.this.oLx.vj();
                    }
                    c.this.oLx = null;
                    return true;
                } catch (Exception e) {
                    x.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :" + e);
                    return false;
                }
            }

            public final int bcF() {
                int i = 0;
                x.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
                if (c.this.oLw != null) {
                    b bVar = c.this.oLw;
                    if (bVar.nJL != null) {
                        i = bVar.nJL.bGR();
                    }
                }
                return (int) ((((float) as.Hn().getStreamVolume(i)) / ((float) as.Hn().getStreamMaxVolume(i))) * 100.0f);
            }

            public final int bcG() {
                x.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
                if (c.this.oLx != null) {
                    return c.this.oLx.vu();
                }
                return -2;
            }

            public final int bcH() {
                x.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
                if (c.this.oLx != null) {
                    return c.this.oLx.fkJ;
                }
                return 0;
            }

            public final int bcI() {
                x.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
                if (c.this.oLw == null) {
                    return 0;
                }
                b bVar = c.this.oLw;
                if (bVar.nJL != null) {
                    return bVar.nJL.bGQ();
                }
                return 0;
            }
        });
        this.oLv.bg(e, com.tencent.mm.y.q.FY());
        as.CN().a(1918, (e) this);
        as.CN().a(1919, (e) this);
        as.CN().a(1927, (e) this);
        as.CN().a(1928, (e) this);
        as.CN().a(1929, (e) this);
        as.CN().a(1931, (e) this);
        as.CN().a(1932, (e) this);
        as.CN().a(1933, (e) this);
        as.CN().a(1935, (e) this);
        as.CN().a(1937, (e) this);
        as.CN().a(1938, (e) this);
        as.CN().a(1939, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        n nVar = (n) kVar;
        x.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + i + " errCode " + i2 + " cmdid " + nVar.lPI);
        this.oLv.c(i2, nVar.lPH, nVar.lPI, nVar.fLf);
    }
}
