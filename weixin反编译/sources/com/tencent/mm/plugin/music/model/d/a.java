package com.tencent.mm.plugin.music.model.d;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.h.m;
import com.google.android.exoplayer2.h.o;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.v;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public final class a extends com.tencent.mm.plugin.music.model.g.a implements com.google.android.exoplayer2.h.d.a, com.google.android.exoplayer2.metadata.e.a {
    private long aBM;
    int aBO = 0;
    protected String aBs;
    boolean auM = false;
    protected com.tencent.mm.au.a fBv;
    int hmd = 0;
    ati oQZ;
    boolean oQk;
    private String oQo = "";
    private long oQq = 0;
    private com.tencent.mm.au.d oRa;
    int oRb = 0;
    public v oRc;
    public com.google.android.exoplayer2.g.b oRd;
    private k oRe;
    public com.google.android.exoplayer2.h.f.a oRf;
    public com.google.android.exoplayer2.source.f oRg;
    f oRh = new f();
    public a oRi = new a();
    e oRj = new e();
    d oRk = new d();
    b oRl = new c();
    public Handler oRm = new Handler(Looper.myLooper()) {
        public final void handleMessage(Message message) {
            if (100 == message.what) {
                long duration = a.this.oRc.getDuration();
                long currentPosition = a.this.oRc.getCurrentPosition();
                long bufferedPosition = a.this.oRc.getBufferedPosition();
                long bufferedPercentage = (long) a.this.oRc.getBufferedPercentage();
                x.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", Long.valueOf(duration), Long.valueOf(currentPosition), Long.valueOf(bufferedPosition), Long.valueOf(bufferedPercentage));
                a.this.oRm.removeMessages(100);
                if (a.this.oQk) {
                    a.this.oRm.sendEmptyMessageDelayed(100, 5000);
                }
            }
        }
    };
    public boolean oRn = false;

    private static class f {
        int[] oRp;

        private f() {
            this.oRp = new int[]{1, 1, 1, 1};
        }

        /* synthetic */ f(byte b) {
            this();
        }

        final void q(boolean z, int i) {
            int r = r(z, i);
            x.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + z + "," + i + "], lastState=" + this.oRp[3] + ",newState=" + r);
            if (this.oRp[3] != r) {
                this.oRp[0] = this.oRp[1];
                this.oRp[1] = this.oRp[2];
                this.oRp[2] = this.oRp[3];
                this.oRp[3] = r;
                x.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.oRp[0] + "," + this.oRp[1] + "," + this.oRp[2] + "," + this.oRp[3] + "]");
            }
        }

        static int r(boolean z, int i) {
            return (z ? -268435456 : 0) | i;
        }

        final boolean a(int[] iArr, boolean z) {
            int i = z ? 268435455 : -1;
            int length = this.oRp.length - iArr.length;
            boolean z2 = true;
            for (int i2 = length; i2 < this.oRp.length; i2++) {
                z2 &= (this.oRp[i2] & i) == (iArr[i2 - length] & i) ? 1 : 0;
            }
            return z2;
        }
    }

    private class e implements com.google.android.exoplayer2.a.e {
        private e() {
        }

        /* synthetic */ e(a aVar, byte b) {
            this();
        }

        public final void c(com.google.android.exoplayer2.b.d dVar) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.beT() + "]");
        }

        public final void bW(int i) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + i + "]");
        }

        public final void a(String str, long j, long j2) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.beT() + ", " + str + "]");
        }

        public final void d(Format format) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.beT() + ", " + Format.a(format) + "]");
        }

        public final void d(com.google.android.exoplayer2.b.d dVar) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.beT() + "]");
        }

        public final void c(int i, long j, long j2) {
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", null, "internalError [" + a.this.beT() + ", " + ("audioTrackUnderrun [" + i + ", " + j + ", " + j2 + "]") + "]", new Object[0]);
        }
    }

    private class a implements com.google.android.exoplayer2.f.a {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void ai(boolean z) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + z + "]");
        }

        public final void a(boolean z, int i) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "state [" + a.this.beT() + ", " + z + ", " + b.tW(i) + "]");
            a aVar = a.this;
            if (aVar.oRc != null) {
                boolean ic = aVar.oRc.ic();
                int ib = aVar.oRc.ib();
                if (ic && ib == 3) {
                    x.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
                    if (aVar.oRl != null) {
                        aVar.oRl.beV();
                    }
                } else if (!ic && ib == 3 && aVar.oRb == 2) {
                    x.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
                    if (aVar.oRl != null) {
                        aVar.oRl.beW();
                    }
                } else if (!ic && ib == 3 && aVar.oRb == 3) {
                    x.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
                    if (aVar.oRl != null) {
                        aVar.oRl.beX();
                    }
                }
                int r = f.r(ic, ib);
                if (r != aVar.oRh.oRp[3]) {
                    x.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + ic + "," + ib + "]");
                    aVar.oRh.q(ic, ib);
                    if (r == f.r(true, 4)) {
                        x.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
                        if (aVar.oRl != null) {
                            aVar.oRl.beZ();
                            return;
                        }
                        return;
                    }
                    if (aVar.oRh.a(new int[]{f.r(false, 1), f.r(false, 2), f.r(false, 3)}, false)) {
                        x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
                        if (aVar.oRl != null) {
                            aVar.oRl.beU();
                        }
                    } else if (((aVar.oRh.a(new int[]{100, 2, 3}, true) | aVar.oRh.a(new int[]{2, 100, 3}, true)) | aVar.oRh.a(new int[]{100, 3, 2, 3}, true)) != 0) {
                        x.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
                        if (aVar.oRl != null) {
                            aVar.oRl.beY();
                        }
                    } else {
                        if (aVar.oRh.a(new int[]{f.r(true, 3), f.r(true, 2)}, false)) {
                            x.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
                            aVar.cZ(701, aVar.beS());
                            return;
                        }
                        if (aVar.oRh.a(new int[]{f.r(true, 2), f.r(true, 3)}, false)) {
                            x.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
                            aVar.cZ(702, aVar.beS());
                        }
                    }
                }
            }
        }

        public final void a(com.google.android.exoplayer2.e eVar) {
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", eVar, "playerFailed [" + a.this.beT() + "]", new Object[0]);
            a aVar = a.this;
            if (eVar != null) {
                Throwable cause = eVar.getCause();
                if (cause == null) {
                    aVar.cY(-4999, -1);
                } else if (cause instanceof com.google.android.exoplayer2.h.q.c) {
                    if (cause.toString().contains("Unable to connect")) {
                        boolean isNetworkConnected = ao.isNetworkConnected(ad.getContext());
                        x.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + isNetworkConnected + " caused by:\n" + cause.toString());
                        if (isNetworkConnected) {
                            aVar.cY(-4000, -3);
                            return;
                        } else {
                            aVar.cY(-4000, -2);
                            return;
                        }
                    } else if (cause instanceof com.google.android.exoplayer2.h.q.e) {
                        String th = cause.toString();
                        if (th.contains("403")) {
                            aVar.cY(-4000, -10);
                        } else if (th.contains("404")) {
                            aVar.cY(-4000, -11);
                        } else if (th.contains("500")) {
                            aVar.cY(-4000, -12);
                        } else if (th.contains("502")) {
                            aVar.cY(-4000, -13);
                        } else {
                            aVar.cY(-4000, -30);
                        }
                    }
                } else if (cause instanceof n) {
                    aVar.cY(-4001, -1);
                } else if (cause instanceof IllegalStateException) {
                    aVar.cY(-4002, -1);
                } else if (cause instanceof com.google.android.exoplayer2.e.b.a) {
                    aVar.cY(-4003, -1);
                } else {
                    aVar.cY(-4999, -1);
                }
            }
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", eVar, "ExoPlaybackException", new Object[0]);
        }

        public final void is() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
        }

        public final void a(p pVar) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[]{Float.valueOf(pVar.aew), Float.valueOf(pVar.pitch)}));
        }
    }

    public class c implements b {
        public final void beU() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
            if (a.this.oQZ != null) {
                a.this.o(a.this.oQZ);
            }
            if (a.this.hmd > 0) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", Integer.valueOf(a.this.hmd));
                a.this.ii(a.this.hmd);
            }
            if (a.this.hmd == 0 && !a.this.oRc.ic()) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
                a.this.oRc.af(true);
            }
        }

        public final void beV() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
            if (a.this.oQZ != null) {
                a.this.p(a.this.oQZ);
            }
        }

        public final void beW() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (a.this.oQZ != null && !a.this.oRc.ic()) {
                a.this.r(a.this.oQZ);
            }
        }

        public final void beX() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (a.this.oQZ != null) {
                a.this.s(a.this.oQZ);
            }
        }

        public final void beY() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
            if (a.this.oQZ != null) {
                a.this.t(a.this.oQZ);
            }
            if (a.this.hmd > 0 && a.this.oRc != null && !a.this.oRc.ic()) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete, stay play hls");
                a.this.hmd = 0;
                a.this.oRc.af(true);
            }
        }

        public final void beZ() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
            if (a.this.oQZ != null) {
                a.this.v(a.this.oQZ);
            }
            a.this.oQk = false;
            a.this.oRm.removeMessages(100);
        }

        public final void tV(int i) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", Integer.valueOf(i));
        }

        public final void da(int i, int i2) {
            a aVar;
            x.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (a.this.oQZ != null) {
                int i3;
                aVar = a.this;
                ati ati = a.this.oQZ;
                x.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                aVar.oRJ = "error";
                com.tencent.mm.sdk.b.b jtVar = new jt();
                jtVar.fBu.action = 4;
                jtVar.fBu.fBq = ati;
                jtVar.fBu.state = "error";
                jtVar.fBu.duration = (long) aVar.getDuration();
                jtVar.fBu.fBw = true;
                com.tencent.mm.f.a.jt.a aVar2 = jtVar.fBu;
                x.i("MicroMsg.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", Integer.valueOf(i));
                switch (i) {
                    case -4999:
                        i3 = -1;
                        break;
                    case -4005:
                    case -4004:
                    case -4003:
                    case -4002:
                        i3 = 10001;
                        break;
                    case -4001:
                        i3 = 10004;
                        break;
                    case -4000:
                        i3 = 10002;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                aVar2.errCode = i3;
                com.tencent.mm.f.a.jt.a aVar3 = jtVar.fBu;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("errCode:" + i2 + ", err:");
                switch (i2) {
                    case -4004:
                        stringBuilder.append("load error");
                        break;
                    case -4003:
                        stringBuilder.append("MediaCodec decoder init exception");
                        break;
                    case -4002:
                        stringBuilder.append("illegal state exception");
                        break;
                    case -4001:
                        stringBuilder.append("UnrecognizedInputFormatException");
                        break;
                    case -43:
                        stringBuilder.append("error url format");
                        break;
                    case -42:
                        stringBuilder.append("stop error");
                        break;
                    case -41:
                        stringBuilder.append("prepare error");
                        break;
                    case -30:
                        stringBuilder.append(" network error");
                        break;
                    case -13:
                        stringBuilder.append(" network respCode 502");
                        break;
                    case -12:
                        stringBuilder.append(" network respCode 500");
                        break;
                    case -11:
                        stringBuilder.append(" network respCode 404");
                        break;
                    case -10:
                        stringBuilder.append(" network respCode 403");
                        break;
                    case -3:
                        stringBuilder.append("connect fail");
                        break;
                    case -2:
                        stringBuilder.append(" no network");
                        break;
                    case -1:
                        stringBuilder.append("unknow exception");
                        break;
                }
                aVar3.foE = stringBuilder.toString();
                com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
            }
            if (a.this.oRc != null) {
                a.this.oRc.af(false);
                a.this.oRc.stop();
            }
            a.this.oQk = false;
            a.this.oRm.removeMessages(100);
            aVar = a.this;
            aVar.aBO++;
            if (a.this.aBO == 1) {
                a.a(a.this.fBv, i, i2);
            }
        }
    }

    public interface b {
        void beU();

        void beV();

        void beW();

        void beX();

        void beY();

        void beZ();

        void da(int i, int i2);

        void tV(int i);
    }

    private class d implements com.google.android.exoplayer2.source.a {
        private d() {
        }

        /* synthetic */ d(a aVar, byte b) {
            this();
        }

        public final void a(i iVar, Format format, IOException iOException) {
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", iOException, "internalError [" + a.this.beT() + ", " + "loadError" + "]", new Object[0]);
            if (!(iVar == null || format == null)) {
                x.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", iVar.uri, format.toString());
            }
            a.this.cY(-4004, -40);
        }

        public final void jV() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
        }

        public final void jW() {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
            a.this.auM = true;
        }
    }

    static /* synthetic */ void a(a aVar) {
        URL url;
        x.i("MicroMsg.Music.ExoMusicPlayer", "initPlayer");
        aVar.oQo = g.a(bi.oN(aVar.fBv.field_songWifiUrl) ? aVar.fBv.field_songWebUrl : aVar.fBv.field_songWifiUrl, aVar.fBv.field_songWapLinkUrl, ao.isWifi(ad.getContext()), new PBool());
        x.i("MicroMsg.Music.ExoMusicPlayer", "mSrc:%s", aVar.oQo);
        x.i("MicroMsg.Music.ExoMusicPlayer", "field_songWifiUrl:%s", aVar.fBv.field_songWifiUrl);
        try {
            url = new URL(aVar.oQo);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e, "initPlayer", new Object[0]);
            x.e("MicroMsg.Music.ExoMusicPlayer", "new URL exception:" + e.getMessage());
            url = null;
        }
        if (url == null) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "initPlayer url is null");
            aVar.a(aVar.fBv.Qu(), 500);
            a(aVar.fBv, -4005, -43);
            return;
        }
        if (aVar.oRc != null && (aVar.oRb != 3 || aVar.oRc.ic())) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "stop it first!");
            aVar.oRb = 3;
            aVar.oRc.af(false);
            aVar.oRc.stop();
        }
        aVar.oRh.oRp = new int[]{1, 1, 1, 1};
        aVar.aBs = t.d(ad.getContext(), Token.WX_TOKEN_PLATFORMID_VALUE);
        Uri parse = Uri.parse(aVar.oQo);
        if (aVar.oRc == null) {
            aVar.oRe = new k(aVar.oRm, aVar);
            aVar.oRd = new com.google.android.exoplayer2.g.b();
            aVar.oRc = com.google.android.exoplayer2.g.a(ad.getContext(), aVar.oRd, new com.google.android.exoplayer2.c());
        }
        if (aVar.oRf == null) {
            aVar.oRf = new m(ad.getContext(), aVar.oRe, new o(aVar.aBs, aVar.oRe));
        }
        try {
            aVar.auM = false;
            aVar.oRg = new h(parse, aVar.oRf, aVar.oRm, aVar.oRk);
            aVar.oRc.a(aVar.oRi);
            aVar.oRc.aeD.add(aVar);
            aVar.oRc.aeN = aVar.oRj;
            aVar.oRb = 0;
            if (aVar.hmd == 0) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "startTime is 0, play it when ready!");
                aVar.oRc.af(true);
            } else {
                aVar.oRc.af(false);
            }
            aVar.oRc.a(aVar.oRg);
            aVar.oQk = true;
            aVar.oRm.sendEmptyMessageDelayed(100, 5000);
        } catch (Throwable e2) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "initPlayer exception:" + e2.getMessage());
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e2, "initPlayer", new Object[0]);
            aVar.a(aVar.fBv.Qu(), HardCoderJNI.SCENE_DB);
            a(aVar.fBv, -4005, -41);
        }
    }

    public a() {
        b.bfa();
    }

    public final void j(com.tencent.mm.au.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oQq;
        if (this.fBv != null && this.fBv.a(aVar) && j <= 1000) {
            this.fBv = aVar;
            x.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.oQo, Long.valueOf(j));
        } else if (aVar == null) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
        } else {
            com.tencent.mm.plugin.music.model.f.a(aVar, false);
            this.oQq = currentTimeMillis;
            this.fBv = aVar;
            x.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(aVar.field_startTime));
            if (this.oRc != null && Qx()) {
                this.oRc.stop();
            }
            this.aBO = 0;
            this.hmd = aVar.field_startTime;
            this.aBM = SystemClock.elapsedRealtime();
            this.oQZ = aVar.Qu();
            n(this.oQZ);
            x.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", Integer.valueOf(this.hmd));
            ah.y(new Runnable() {
                public final void run() {
                    a.a(a.this);
                }
            });
        }
    }

    public final void pause() {
        this.oRn = false;
        x.i("MicroMsg.Music.ExoMusicPlayer", "pause");
        if (this.oRc != null) {
            this.oRb = 2;
            this.oRc.af(false);
        }
    }

    public final boolean beu() {
        return this.oQk && this.oRn;
    }

    public final void bet() {
        this.oRn = true;
        x.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
        if (this.oRc != null) {
            this.oRb = 2;
            this.oRc.af(false);
        }
    }

    public final void beH() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
        pause();
        com.tencent.mm.plugin.music.model.h.bei().bdR();
    }

    public final void resume() {
        this.aBO = 0;
        boolean beI = beI();
        boolean Qx = Qx();
        x.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", Boolean.valueOf(beI), Boolean.valueOf(Qx));
        if (this.oRc != null) {
            if (com.tencent.mm.plugin.music.model.h.bei().requestFocus()) {
                this.oRb = 1;
                this.oRc.af(true);
                q(this.oQZ);
            } else {
                x.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
            }
            this.oQk = true;
        }
    }

    public final boolean Qx() {
        if (this.oRc == null) {
            return false;
        }
        switch (this.oRc.ib()) {
            case 1:
            case 3:
                return this.oRc.ic();
            default:
                return false;
        }
    }

    private boolean beI() {
        if (this.oRc != null) {
            return this.oRc.id();
        }
        return false;
    }

    public final boolean Qy() {
        return this.oQk && !beI();
    }

    public final void stopPlay() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
        try {
            if (this.oRc != null) {
                this.oRb = 3;
                this.oRc.af(false);
                this.oRc.stop();
                s(this.oQZ);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e, "stopPlay", new Object[0]);
            a(this.fBv.Qu(), 504);
            a(this.fBv, -4005, -42);
        }
        com.tencent.mm.plugin.music.model.h.bei().bdR();
        this.oQk = false;
        this.oRn = false;
        this.oRm.removeMessages(100);
    }

    public final int getDuration() {
        if (this.oRc != null) {
            return (int) this.oRc.getDuration();
        }
        return 0;
    }

    public final int beS() {
        if (this.oRc != null) {
            return this.oRc.getBufferedPercentage();
        }
        return 0;
    }

    public final boolean ii(int i) {
        boolean z = false;
        int duration = getDuration();
        x.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0 || i > duration) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            return false;
        } else if (this.oRc == null) {
            return true;
        } else {
            u(this.fBv.Qu());
            f fVar = this.oRh;
            if ((this.oRh.oRp[3] & -268435456) != 0) {
                z = true;
            }
            fVar.q(z, 100);
            this.oRb = 4;
            this.oRc.seekTo((long) i);
            return true;
        }
    }

    public final com.tencent.mm.au.d bew() {
        int i = 0;
        int duration = getDuration();
        int currentPosition = this.oRc != null ? (int) this.oRc.getCurrentPosition() : 0;
        boolean Qx = Qx();
        int beS = beS();
        if (beS < 0) {
            beS = 0;
        }
        if ((this.oRg instanceof h) && !this.auM) {
            duration = 0;
        }
        if (this.oRa != null) {
            com.tencent.mm.au.d dVar = this.oRa;
            if (Qx) {
                i = 1;
            }
            dVar.i(duration, currentPosition, i, beS);
        } else {
            if (Qx) {
                i = 1;
            }
            this.oRa = new com.tencent.mm.au.d(duration, currentPosition, i, beS);
        }
        this.oRa.fBw = true;
        this.oRa.hJM = this.oRJ;
        return this.oRa;
    }

    public final boolean bev() {
        return true;
    }

    final void cY(int i, int i2) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.oRl != null) {
            this.oRl.da(i, i2);
        }
    }

    final void cZ(int i, int i2) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + i + "," + i2 + "]");
        if (this.oRl == null) {
            return;
        }
        if (i == 701 || i == 702) {
            this.oRl.tV(i2);
        }
    }

    public final void a(Metadata metadata) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
        b.a(metadata, "  ");
        x.i("MicroMsg.Music.ExoMusicPlayer", "]");
    }

    final String beT() {
        return b.dQ(SystemClock.elapsedRealtime() - this.aBM);
    }

    static void a(com.tencent.mm.au.a aVar, int i, int i2) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(797);
        iDKey.SetKey(2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(797);
        int i3 = aVar.field_musicType;
        x.i("MicroMsg.ExoPlayerErrorHandler", "getExoMusicPlayerErrIdKeyByMusicType, musicType:" + i3);
        switch (i3) {
            case 0:
                i3 = 62;
                break;
            case 1:
                i3 = 63;
                break;
            case 4:
                i3 = 64;
                break;
            case 6:
                i3 = 65;
                break;
            case 7:
                i3 = 66;
                break;
            case 8:
                i3 = 67;
                break;
            case 9:
                i3 = 68;
                break;
            case 10:
                i3 = 69;
                break;
            case 11:
                i3 = 70;
                break;
            default:
                i3 = 71;
                break;
        }
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(797);
        x.i("MicroMsg.ExoPlayerErrorHandler", "getExoMusicPlayerErrTypeIdKey, errType:" + i);
        switch (i) {
            case -4999:
                i3 = 9;
                break;
            case -4005:
                i3 = 8;
                break;
            case -4004:
                i3 = 7;
                break;
            case -4003:
                i3 = 6;
                break;
            case -4002:
                i3 = 5;
                break;
            case -4001:
                i3 = 4;
                break;
            case -4000:
                i3 = 3;
                break;
            default:
                i3 = 9;
                break;
        }
        iDKey3.SetKey(i3);
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(797);
        x.i("MicroMsg.ExoPlayerErrorHandler", "getExoMusicPlayerErrIdKey, errCode:" + i2);
        switch (i2) {
            case -43:
                i3 = 25;
                break;
            case -42:
                i3 = 24;
                break;
            case -41:
                i3 = 23;
                break;
            case -40:
                i3 = 22;
                break;
            case -30:
                i3 = 21;
                break;
            case -13:
                i3 = 20;
                break;
            case -12:
                i3 = 19;
                break;
            case -11:
                i3 = 18;
                break;
            case -10:
                i3 = 17;
                break;
            case -3:
                i3 = 16;
                break;
            case -2:
                i3 = 15;
                break;
            case -1:
                i3 = 14;
                break;
            default:
                i3 = 14;
                break;
        }
        iDKey4.SetKey(i3);
        iDKey4.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        arrayList.add(iDKey4);
        com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, true);
    }
}
