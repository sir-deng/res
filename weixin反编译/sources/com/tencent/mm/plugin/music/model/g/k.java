package com.tencent.mm.plugin.music.model.g;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.au.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.music.model.a.c;
import com.tencent.mm.plugin.music.model.b.e;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.ArrayList;

public final class k extends a {
    int aBO = 0;
    AudioType audioType = AudioType.UNSUPPORT;
    protected com.tencent.mm.au.a fBv;
    int hmd = 0;
    public CommonPlayer oQi;
    boolean oQk;
    private IMediaHTTPService oQn;
    String oQo = "";
    private long oQq = 0;
    private boolean oQr = false;
    private PlayerListenerCallback oQt = new PlayerListenerCallback() {
        com.tencent.mm.au.a oSt = null;

        public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
        }

        public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
        }

        public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete");
            if (k.this.hmd != 0) {
                x.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", Integer.valueOf(k.this.hmd));
                k.this.hmd = 0;
                bfk();
                return;
            }
            x.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
            if (this.oSt == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                return;
            }
            ati Qu = this.oSt.Qu();
            k.this.t(Qu);
            if (k.this.Qx()) {
                x.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
                k.this.q(Qu);
            }
        }

        public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
            x.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            com.tencent.mm.au.a bdU = h.bef().bdU();
            if (bdU == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
                return;
            }
            this.oSt = k.this.fBv;
            if (this.oSt == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
                return;
            }
            boolean isNetworkConnected = ao.isNetworkConnected(ad.getContext());
            if (i2 == 80 && isNetworkConnected) {
                x.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
            }
            if (k.this.aBO > 0) {
                x.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", Integer.valueOf(k.this.aBO));
                return;
            }
            k kVar = k.this;
            kVar.aBO++;
            k.this.a(this.oSt, i2);
            ati Qu = this.oSt.Qu();
            if (bdU.a(this.oSt)) {
                k.this.stopPlay();
                ah.y(new Runnable() {
                    public final void run() {
                        Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.exd), 0).show();
                    }
                });
            }
            k.this.s(Qu);
            k.this.a(Qu, i2);
            if (k.this.oSs != null) {
                k.this.oSs.isStop = true;
                k.this.oSs = null;
            }
            if (i == 91 && i2 == 55) {
                x.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
                e.deleteFile(k.this.oQo);
            }
        }

        public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
        }

        public final void onStateChanged(int i) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", Integer.valueOf(i));
            if (i == 3) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
                this.oSt = k.this.fBv;
                if (this.oSt == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                k.this.n(this.oSt.Qu());
            } else if (i == 2) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
                bfk();
            } else if (i == 4) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
                this.oSt = k.this.fBv;
                if (this.oSt == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                k.this.p(this.oSt.Qu());
                if (k.this.oSs != null) {
                    k.this.oSs.isStop = true;
                }
                k.this.oSs = new a(k.this, (byte) 0);
                Runnable runnable = k.this.oSs;
                runnable.isStop = false;
                com.tencent.mm.sdk.f.e.post(runnable, "music_play_progress_runnable");
            } else if (i == 5) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
                if (this.oSt == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                k.this.r(this.oSt.Qu());
            } else if (i == 6) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
                if (this.oSt == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                } else if (h.bef().bdU() == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
                } else if (k.this.fBv.a(this.oSt)) {
                    k.this.s(k.this.fBv.Qu());
                }
            } else if (i == 7) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
                if (this.oSt == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                k.this.oQk = false;
                k.this.v(this.oSt.Qu());
                if (k.this.oSs != null) {
                    k.this.oSs.isStop = true;
                    k.this.oSs = null;
                }
            } else if (i == 8) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
            } else if (i == 9) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
            }
        }

        public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
        }

        private void bfk() {
            x.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
            if (k.this.hmd != 0) {
                x.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", Integer.valueOf(k.this.hmd));
                k.this.ii(k.this.hmd);
                return;
            }
            x.i("MicroMsg.Music.QQMusicPlayer", "start to play");
            if (!h.bei().requestFocus()) {
                x.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
            } else if (k.this.fBv == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            } else {
                k.this.o(k.this.fBv.Qu());
                try {
                    if (k.this.oQi != null) {
                        k.this.oQi.start();
                        if (!(k.this.oQi.getCurrentAudioInformation() == null || k.this.oQi.getCurrentAudioInformation().getAudioType() == null)) {
                            x.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", Integer.valueOf(k.this.oQi.getCurrentAudioInformation().getAudioType().getValue()));
                            k.this.audioType = k.this.oQi.getCurrentAudioInformation().getAudioType();
                            k.a(k.this);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "_onPrepared", new Object[0]);
                    k.this.a(k.this.fBv.Qu(), 502);
                    k.this.a(k.this.fBv, 502);
                }
                k.this.oQk = true;
            }
        }
    };
    private d oRa;
    public boolean oRn = false;
    a oSs;

    private class a implements Runnable {
        boolean isStop;

        private a() {
            this.isStop = true;
        }

        /* synthetic */ a(k kVar, byte b) {
            this();
        }

        public final void run() {
            x.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (k.this.oQi != null && k.this.Qx()) {
                        k.this.beM();
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + e.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    static /* synthetic */ void a(k kVar) {
        if (kVar.audioType != null) {
            x.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(kVar.audioType.getValue()), Boolean.valueOf(kVar.oQr));
            if (!kVar.oQr) {
                x.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType OK");
                kVar.oQr = true;
                IDKey iDKey = new IDKey();
                iDKey.SetID(558);
                int value = kVar.audioType.getValue();
                value = value == 2 ? 92 : value == 3 ? 93 : value == 4 ? 94 : value == 5 ? 95 : value == 6 ? 96 : value == 7 ? 97 : value == 8 ? 98 : value == 9 ? 99 : 100;
                iDKey.SetKey(value);
                iDKey.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                g.pWK.a(arrayList, true);
                Object GT = e.GT(kVar.oQo);
                x.i("MicroMsg.Music.QQMusicPlayer", "mineTypeStr:%s", GT);
                if (kVar.fBv == null || TextUtils.isEmpty(GT)) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "music is null or mineTypeStr is empty");
                    return;
                }
                int Hb = h.Hb(GT);
                g.pWK.h(14486, Integer.valueOf(1), Integer.valueOf(kVar.fBv.field_musicType), Integer.valueOf(Hb), GT);
            }
        }
    }

    public k() {
        bfc();
        c.bes();
    }

    public final void j(com.tencent.mm.au.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oQq;
        if (this.fBv != null && this.fBv.a(aVar) && j <= 3000) {
            this.fBv = aVar;
            x.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.oQo, Long.valueOf(j));
        } else if (aVar == null) {
            x.e("MicroMsg.Music.QQMusicPlayer", "music is null");
        } else {
            URL url;
            f.a(aVar, false);
            this.oQq = currentTimeMillis;
            this.fBv = aVar;
            x.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(aVar.field_startTime));
            if (this.oQi != null && Qx()) {
                this.oQi.stop();
            }
            this.aBO = 0;
            this.hmd = aVar.field_startTime;
            this.audioType = null;
            this.oQr = false;
            x.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
            this.oQo = this.fBv.hJE;
            x.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s", this.oQo);
            x.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", this.fBv.field_songWifiUrl);
            if (this.oQo != null) {
                e.GQ(this.oQo);
                e.bL(this.oQo, 0);
                e.bM(this.oQo, 0);
            }
            try {
                url = new URL(this.oQo);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "initPlayer", new Object[0]);
                x.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + e.getMessage());
                url = null;
            }
            if (url == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
                a(this.fBv.Qu(), 500);
                a(this.fBv, 500);
                return;
            }
            if (this.oQi == null) {
                this.oQi = new CommonPlayer(this.oQt);
            }
            this.oQi.reset();
            if (this.oQn == null) {
                this.oQn = new com.tencent.mm.plugin.music.model.f.d();
            }
            try {
                this.oQi.setDataSource(this.oQn, Uri.parse(url.toString()));
                this.oQi.prepare();
            } catch (Throwable e2) {
                x.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + e2.getMessage());
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "initPlayer", new Object[0]);
                a(this.fBv.Qu(), HardCoderJNI.SCENE_DB);
                a(this.fBv, HardCoderJNI.SCENE_DB);
            }
        }
    }

    public final void pause() {
        this.oRn = false;
        x.i("MicroMsg.Music.QQMusicPlayer", "pause");
        if (this.oQi != null && Qx()) {
            try {
                this.oQi.pause();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "pause", new Object[0]);
                a(this.fBv.Qu(), 503);
                a(this.fBv, 503);
            }
        }
    }

    public final void beH() {
        x.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
        pause();
        h.bei().bdR();
    }

    public final boolean beu() {
        return this.oQk && this.oRn;
    }

    public final void bet() {
        this.oRn = true;
        x.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
        if (this.oQi != null && Qx()) {
            try {
                this.oQi.pause();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "passivePause", new Object[0]);
                a(this.fBv.Qu(), 503);
                a(this.fBv, 503);
            }
        }
    }

    public final void resume() {
        this.aBO = 0;
        x.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", Boolean.valueOf(beI()), Boolean.valueOf(Qx()));
        if (this.oQi != null && !r0 && !r1) {
            if (h.bei().requestFocus()) {
                try {
                    this.oQi.start();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "resume", new Object[0]);
                    a(this.fBv.Qu(), 502);
                    a(this.fBv, 502);
                }
                q(h.bef().bdV());
            } else {
                x.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
            }
            this.oQk = true;
        }
    }

    public final boolean Qx() {
        if (this.oQi == null || this.oQi.getPlayerState() != 4) {
            return false;
        }
        return true;
    }

    private boolean beI() {
        if (this.oQi == null || this.oQi.getPlayerState() != 3) {
            return false;
        }
        return true;
    }

    public final boolean Qy() {
        return this.oQk && !beI();
    }

    public final void stopPlay() {
        x.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
        try {
            if (this.oQi != null) {
                this.oQi.stop();
            }
            if (this.oSs != null) {
                this.oSs.isStop = true;
                this.oSs = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "stopPlay", new Object[0]);
            a(this.fBv.Qu(), 504);
            a(this.fBv, 504);
        }
        h.bei().bdR();
        this.oQk = false;
        this.oRn = false;
    }

    public final int getDuration() {
        if (this.oQi != null) {
            return this.oQi.getDuration();
        }
        return -1;
    }

    public final boolean ii(int i) {
        int duration = getDuration();
        x.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0 || i > duration) {
            x.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            stopPlay();
            return false;
        } else if (this.oQi == null) {
            return true;
        } else {
            u(this.fBv.Qu());
            this.oQi.seekTo(i);
            return true;
        }
    }

    public final d bew() {
        int bufferedPercentage;
        int i = 0;
        int duration = getDuration();
        int currentPosition = this.oQi != null ? (int) this.oQi.getCurrentPosition() : -1;
        boolean Qx = Qx();
        if (this.oQi != null) {
            bufferedPercentage = this.oQi.getBufferedPercentage();
        } else {
            bufferedPercentage = 0;
        }
        if (bufferedPercentage < 0 || bufferedPercentage > 100) {
            bufferedPercentage = 0;
        }
        if (bufferedPercentage < 0) {
            bufferedPercentage = 0;
        }
        if (this.oRa != null) {
            d dVar = this.oRa;
            if (Qx) {
                i = 1;
            }
            dVar.i(duration, currentPosition, i, bufferedPercentage);
        } else {
            if (Qx) {
                i = 1;
            }
            this.oRa = new d(duration, currentPosition, i, bufferedPercentage);
        }
        this.oRa.fBw = true;
        this.oRa.hJM = this.oRJ;
        return this.oRa;
    }

    private void a(com.tencent.mm.au.a aVar, int i) {
        int i2;
        int GX;
        IDKey iDKey = new IDKey();
        iDKey.SetID(558);
        iDKey.SetKey(4);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(558);
        int i3 = aVar.field_musicType;
        x.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerErrIdKeyByMusicType, musicType:" + i3);
        switch (i3) {
            case 0:
                i3 = 49;
                break;
            case 1:
                i3 = 50;
                break;
            case 4:
                i3 = 51;
                break;
            case 5:
                i3 = 52;
                break;
            case 6:
                i3 = 53;
                break;
            case 7:
                i3 = 54;
                break;
            case 8:
                i3 = 55;
                break;
            case 9:
                i3 = 56;
                break;
            case 10:
                i3 = 7;
                break;
            case 11:
                i3 = 8;
                break;
            default:
                i3 = 9;
                break;
        }
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(558);
        iDKey3.SetKey(h.uc(i));
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(558);
        iDKey4.SetValue(1);
        ArrayList arrayList = new ArrayList();
        if (i == 80) {
            i3 = aVar.field_musicType;
            x.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerNetworkErrIdKeyByMusicType, musicType:" + i3);
            switch (i3) {
                case 0:
                    i3 = 167;
                    break;
                case 1:
                    i3 = JsApiSetClipboardData.CTRL_INDEX;
                    break;
                case 4:
                    i3 = y.CTRL_INDEX;
                    break;
                case 6:
                    i3 = 170;
                    break;
                case 7:
                    i3 = 171;
                    break;
                case 8:
                    i3 = 172;
                    break;
                case 9:
                    i3 = af.CTRL_BYTE;
                    break;
                case 10:
                    i3 = GameJsApiOperateGameCenterMsg.CTRL_BYTE;
                    break;
                case 11:
                    i3 = ac.CTRL_BYTE;
                    break;
                default:
                    i3 = n.CTRL_BYTE;
                    break;
            }
            iDKey4.SetKey(i3);
            arrayList.add(iDKey4);
            i2 = 1;
            GX = e.GX(this.oQo);
            i3 = e.GY(this.oQo);
            if (e.GX(this.oQo) == ap.CTRL_INDEX) {
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(558);
                iDKey5.SetValue(1);
                iDKey5.SetKey(h.uc(700));
                arrayList.add(iDKey5);
            }
        } else if (e.GT(this.oQo) == null || !e.GT(this.oQo).contains("text/html")) {
            if (i != 70) {
                Object obj;
                switch (i) {
                    case 62:
                    case 63:
                    case 64:
                    case 67:
                    case 74:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    IDKey iDKey6 = new IDKey();
                    iDKey6.SetID(558);
                    iDKey6.SetValue(1);
                    i3 = aVar.field_musicType;
                    x.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerDecodeErrIdKeyByMusicType, musicType:" + i3);
                    switch (i3) {
                        case 0:
                            i3 = 202;
                            break;
                        case 1:
                            i3 = 203;
                            break;
                        case 4:
                            i3 = com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX;
                            break;
                        case 6:
                            i3 = com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX;
                            break;
                        case 7:
                            i3 = b.CTRL_INDEX;
                            break;
                        case 8:
                            i3 = 207;
                            break;
                        case 9:
                            i3 = com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX;
                            break;
                        case 10:
                            i3 = com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX;
                            break;
                        case 11:
                            i3 = i.CTRL_INDEX;
                            break;
                        default:
                            i3 = n.CTRL_BYTE;
                            break;
                    }
                    iDKey6.SetKey(i3);
                    arrayList.add(iDKey6);
                }
                i3 = aVar.field_musicType;
                x.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerPlayErrIdKeyByMusicType, musicType:" + i3);
                switch (i3) {
                    case 0:
                        i3 = 178;
                        break;
                    case 1:
                        i3 = 179;
                        break;
                    case 4:
                        i3 = 180;
                        break;
                    case 6:
                        i3 = 181;
                        break;
                    case 7:
                        i3 = au.CTRL_BYTE;
                        break;
                    case 8:
                        i3 = 183;
                        break;
                    case 9:
                        i3 = 184;
                        break;
                    case 10:
                        i3 = 185;
                        break;
                    case 11:
                        i3 = 186;
                        break;
                    default:
                        i3 = n.CTRL_BYTE;
                        break;
                }
                iDKey4.SetKey(i3);
                arrayList.add(iDKey4);
            }
            i3 = 0;
            GX = 0;
            i2 = 0;
        } else {
            IDKey iDKey7 = new IDKey();
            iDKey7.SetID(558);
            iDKey7.SetValue(1);
            iDKey7.SetKey(h.uc(701));
            arrayList.add(iDKey7);
            i2 = 0;
            i3 = 0;
            GX = 701;
        }
        g.pWK.h(14777, Integer.valueOf(1), Integer.valueOf(this.fBv.field_musicType), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(GX), Integer.valueOf(i3));
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        g.pWK.a(arrayList, true);
    }

    public final void beM() {
        com.tencent.mm.au.a bdU = h.bef().bdU();
        if (bdU != null && bdU.a(this.fBv) && this.oQi != null && Qx()) {
            int currentPosition = (int) this.oQi.getCurrentPosition();
            int duration = this.oQi.getDuration();
            if (currentPosition > 0 && duration > 0 && this.oQg != null) {
                this.oQg.bK(currentPosition, duration);
            }
        }
    }

    public final boolean bev() {
        return true;
    }
}
