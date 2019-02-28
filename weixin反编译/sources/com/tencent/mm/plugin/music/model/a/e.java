package com.tencent.mm.plugin.music.model.a;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.ab.c;
import com.tencent.mm.f.a.t;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.f.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.ArrayList;

public final class e extends d {
    int aBO;
    AudioType audioType;
    protected com.tencent.mm.ab.a foA;
    String foy;
    long gLZ;
    int hmd;
    boolean hml;
    ag jFp;
    int lPJ;
    CommonPlayer oQi;
    private c oQj;
    boolean oQk;
    boolean oQl;
    a oQm;
    private IMediaHTTPService oQn;
    String oQo;
    boolean oQp;
    private long oQq;
    boolean oQr;
    long oQs;
    private PlayerListenerCallback oQt;

    private class a implements Runnable {
        boolean isStop;

        private a() {
            this.isStop = true;
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            x.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (e.this.oQi != null && e.this.Qx()) {
                        e.this.beM();
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + e.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    public e() {
        this.foy = "";
        this.oQl = false;
        this.hml = false;
        this.oQo = "";
        this.aBO = 0;
        this.lPJ = 0;
        this.hmd = 0;
        this.oQp = false;
        this.oQq = 0;
        this.audioType = AudioType.UNSUPPORT;
        this.oQr = false;
        this.oQs = 0;
        this.gLZ = 0;
        this.oQt = new PlayerListenerCallback() {
            com.tencent.mm.ab.a oQu = null;

            static /* synthetic */ void a(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onPrepared");
                anonymousClass1.oQu = e.this.foA;
                if (e.this.hml || e.this.oQl) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                    if (e.this.oQi != null) {
                        e.this.oQi.stop();
                    }
                    if (e.this.oQl) {
                        e.this.beB();
                    }
                } else if (e.this.hmd != 0) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "seek to startTime:%d", Integer.valueOf(e.this.hmd));
                    e.this.ii(e.this.hmd);
                } else {
                    if (!(e.this.oQi == null || e.this.oQi.getCurrentAudioInformation() == null || e.this.oQi.getCurrentAudioInformation().getAudioType() == null)) {
                        e.this.audioType = e.this.oQi.getCurrentAudioInformation().getAudioType();
                        if (e.this.audioType != null) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "getAudioType:%d", Integer.valueOf(e.this.audioType.getValue()));
                        }
                        e eVar = e.this;
                        if (eVar.audioType != null) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(eVar.audioType.getValue()), Boolean.valueOf(eVar.oQr));
                            if (!eVar.oQr) {
                                x.i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType OK");
                                eVar.oQr = true;
                                IDKey iDKey = new IDKey();
                                iDKey.SetID(688);
                                int value = eVar.audioType.getValue();
                                value = value == 2 ? 42 : value == 3 ? 43 : value == 4 ? 44 : value == 5 ? 45 : value == 6 ? 46 : value == 7 ? 47 : value == 8 ? 48 : value == 9 ? 49 : 50;
                                iDKey.SetKey(value);
                                iDKey.SetValue(1);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(iDKey);
                                g.pWK.a(arrayList, true);
                            }
                        }
                    }
                    e.this.bey();
                    if (e.this.oQp) {
                        x.i("MicroMsg.Audio.QQAudioPlayer", "start to play");
                        try {
                            if (e.this.oQi != null) {
                                e.this.oQi.setVolume((float) e.this.foA.hmi, (float) e.this.foA.hmi);
                                e.this.oQi.start();
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "_onPrepared", new Object[0]);
                            e.this.tK(502);
                            e.this.tL(502);
                        }
                        e.this.oQk = true;
                        return;
                    }
                    x.i("MicroMsg.Audio.QQAudioPlayer", "autoplay is false, don't start auto play!");
                }
            }

            static /* synthetic */ void b(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onPreparing");
                anonymousClass1.oQu = e.this.foA;
                if (anonymousClass1.oQu == null) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "cbMusic is null");
                } else if (e.this.hml || e.this.oQl) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                } else {
                    d dVar = e.this;
                    x.i("MicroMsg.Audio.BaseAudioPlayer", "onPreparintEvent %b", Boolean.valueOf(dVar.Qx()));
                    b tVar = new t();
                    tVar.foD.action = 9;
                    tVar.foD.state = "waiting";
                    tVar.foD.foy = dVar.bex();
                    tVar.foD.appId = dVar.getAppId();
                    com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
                }
            }

            static /* synthetic */ void c(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onStart");
                anonymousClass1.oQu = e.this.foA;
                if (e.this.hml || e.this.oQl) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                    if (e.this.oQi != null && e.this.oQk) {
                        e.this.oQk = false;
                        e.this.oQi.stop();
                        return;
                    }
                    return;
                }
                e.this.bez();
                if (e.this.oQm != null) {
                    e.this.oQm.isStop = true;
                }
                e.this.oQm = new a(e.this, (byte) 0);
                Runnable runnable = e.this.oQm;
                runnable.isStop = false;
                com.tencent.mm.sdk.f.e.post(runnable, "audio_play_progress_runnable");
            }

            static /* synthetic */ void d(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onPause");
                e.this.beB();
            }

            static /* synthetic */ void e(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onStop");
                if (anonymousClass1.oQu == null) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "currentMusic is null");
                    return;
                }
                e.this.oQk = false;
                e.this.gLZ = System.currentTimeMillis();
                if (!e.this.foy.equalsIgnoreCase(anonymousClass1.oQu.foy)) {
                    return;
                }
                if (e.this.hml) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
                    e.this.beB();
                    return;
                }
                e.this.beC();
            }

            static /* synthetic */ void f(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onCompletion");
                e.this.beE();
                if (e.this.oQm != null) {
                    e.this.oQm.isStop = true;
                    e.this.oQm = null;
                }
                e.this.gLZ = System.currentTimeMillis();
                x.i("MicroMsg.Audio.QQAudioPlayer", "play end, isPausedOnBackground:%b, playParam.loop:%b, isStartPlaying:%b, ", Boolean.valueOf(e.this.hml), Boolean.valueOf(e.this.foA.hmg), Boolean.valueOf(e.this.oQk));
                if (e.this.hml) {
                    e.this.oQk = false;
                    e.this.hmd = 0;
                    e.this.oQp = true;
                    x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground is true, do stop player and don't play again");
                } else if (e.this.oQl) {
                    e.this.oQk = false;
                    e.this.hmd = 0;
                    e.this.oQp = true;
                    x.i("MicroMsg.Audio.QQAudioPlayer", "isForcePause is true, do stop player and don't play again");
                } else if (e.this.foA.hmg && e.this.oQk) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "play end normally and loop play again");
                    e.this.oQk = false;
                    e.this.hmd = 0;
                    e.this.oQp = true;
                    e.this.beG();
                } else {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "play end, but not loop play");
                    e.this.oQk = false;
                    e.this.hmd = 0;
                    e.this.oQp = true;
                }
            }

            public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
            }

            public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
            }

            public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer) {
                e.this.jFp.post(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete");
                        if (e.this.hmd != 0) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", Integer.valueOf(e.this.hmd));
                            e.this.hmd = 0;
                            AnonymousClass1.a(AnonymousClass1.this);
                            return;
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        x.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
                        e.this.beD();
                        if (e.this.Qx()) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
                            e.this.beA();
                        }
                    }
                });
            }

            public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), e.this.foy);
                if (this.oQu == null) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
                    return;
                }
                boolean isNetworkConnected = ao.isNetworkConnected(ad.getContext());
                if (i2 == 80 && isNetworkConnected) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
                }
                if (e.this.aBO > 0) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", Integer.valueOf(e.this.aBO));
                    return;
                }
                e.this.oQk = false;
                e eVar = e.this;
                eVar.aBO++;
                e.this.lPJ = i2;
                e.this.gLZ = System.currentTimeMillis();
                e.this.tL(i2);
                if (e.this.foy.equalsIgnoreCase(this.oQu.foy)) {
                    e.this.stopPlay();
                    ah.y(new Runnable() {
                        public final void run() {
                            as.Hm();
                            if (((Boolean) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MUSIC_SHOW_AUDIO_TOAST_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue()) {
                                Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.exd), 0).show();
                            }
                        }
                    });
                }
                e.this.tK(i2);
                if (e.this.oQm != null) {
                    e.this.oQm.isStop = true;
                    e.this.oQm = null;
                }
                if (i == 91 && i2 == 55) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
                    com.tencent.mm.plugin.music.model.b.e.deleteFile(e.this.oQo);
                }
            }

            public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
            }

            public final void onStateChanged(final int i) {
                e.this.jFp.post(new Runnable() {
                    public final void run() {
                        String str = e.this.foy;
                        x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", Integer.valueOf(i), str);
                        if (i == 3) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
                            AnonymousClass1.b(AnonymousClass1.this);
                            e.this.oQs = System.currentTimeMillis();
                        } else if (i == 2) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
                            x.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", Long.valueOf(System.currentTimeMillis() - e.this.oQs));
                            AnonymousClass1.a(AnonymousClass1.this);
                        } else if (i == 4) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED! audioId:%s", e.this.foy);
                            x.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", Long.valueOf(System.currentTimeMillis() - e.this.oQs));
                            AnonymousClass1.c(AnonymousClass1.this);
                        } else if (i == 5) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
                            AnonymousClass1.d(AnonymousClass1.this);
                        } else if (i == 6) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED! audioId:%s", e.this.foy);
                            AnonymousClass1.e(AnonymousClass1.this);
                        } else if (i == 7) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                            AnonymousClass1.f(AnonymousClass1.this);
                        } else if (i == 8) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
                            x.i("MicroMsg.Audio.QQAudioPlayer", "_onEnd");
                        } else if (i == 9) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
                        }
                    }
                });
            }

            public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
            }
        };
        this.foy = com.tencent.mm.ab.b.JD();
        c.bes();
        this.oQe = new ar();
        this.oQe.eW(ad.getContext());
        this.oQe.a(new com.tencent.mm.sdk.platformtools.ar.a() {
            public final void fj(int i) {
                switch (i) {
                    case 0:
                        if (d.this.oQf) {
                            d.this.oQf = false;
                            d.this.resume();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        if (d.this.Qx()) {
                            d.this.oQf = true;
                            d.this.pause();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
        x.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
        this.jFp = new ag(Looper.myLooper());
    }

    public final void GL(String str) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", str);
        this.foy = str;
    }

    public final void c(com.tencent.mm.ab.a aVar) {
        this.foA = aVar;
        this.hmd = aVar.hmd;
        this.oQp = aVar.hmf;
        if (this.oQi != null && Qx()) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", this.foy, this.oQo, Double.valueOf(this.foA.hmi));
            this.oQi.setVolume((float) this.foA.hmi, (float) this.foA.hmi);
        }
    }

    public final void d(com.tencent.mm.ab.a aVar) {
        if (aVar == null) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
            beF();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oQq;
        if (this.foA == null || !this.foA.a(aVar) || j > 100) {
            f.tH(aVar.fromScene);
            this.oQq = currentTimeMillis;
            this.foA = aVar;
            x.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, currentTime:%d, fromScene:%d, audioId:%s", Long.valueOf(currentTimeMillis), Integer.valueOf(this.foA.fromScene), this.foy);
            if (this.oQi != null && Qx()) {
                this.oQi.stop();
            }
            this.aBO = 0;
            this.hmd = aVar.hmd;
            this.oQp = aVar.hmf;
            this.audioType = null;
            this.oQr = false;
            this.hml = false;
            this.oQl = false;
            beG();
            return;
        }
        this.foA = aVar;
        this.hmd = aVar.hmd;
        this.oQp = aVar.hmf;
        x.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", this.oQo, Long.valueOf(j));
    }

    private void beG() {
        int i = 1;
        x.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
        if (!TextUtils.isEmpty(this.foA.filePath) && this.foA.hmj == null) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", this.foA.filePath);
            if (this.oQi == null) {
                this.oQi = new CommonPlayer(this.oQt);
            }
            this.oQi.reset();
            try {
                this.oQi.setDataSource(this.foA.filePath);
                this.oQi.prepare();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "initPlayer exception", new Object[0]);
                tK(HardCoderJNI.SCENE_DB);
                tL(HardCoderJNI.SCENE_DB);
            }
        } else if (TextUtils.isEmpty(this.foA.filePath) || this.foA.hmj == null) {
            boolean z;
            URL url;
            x.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", this.foA.hmc);
            this.oQo = this.foA.hmc;
            if (com.tencent.mm.plugin.music.model.g.Gs(this.oQo)) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", this.oQo);
            String str = "MicroMsg.Audio.QQAudioPlayer";
            String str2 = "isqqmusic:%d";
            Object[] objArr = new Object[1];
            if (!z) {
                i = 0;
            }
            objArr[0] = Integer.valueOf(i);
            x.i(str, str2, objArr);
            com.tencent.mm.plugin.music.model.b.e.GQ(this.oQo);
            com.tencent.mm.plugin.music.model.b.e.at(this.oQo, z);
            try {
                url = new URL(this.oQo);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e2, "initPlayer", new Object[0]);
                url = null;
            }
            if (url == null) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
                tK(500);
                tL(500);
                return;
            }
            if (this.oQi == null) {
                this.oQi = new CommonPlayer(this.oQt);
            }
            this.oQi.reset();
            if (this.oQn == null) {
                this.oQn = new d();
            }
            try {
                this.oQi.setDataSource(this.oQn, Uri.parse(url.toString()));
                this.oQi.prepare();
            } catch (Throwable e22) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e22.getMessage());
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e22, "initPlayer", new Object[0]);
                tK(HardCoderJNI.SCENE_DB);
                tL(HardCoderJNI.SCENE_DB);
            }
        } else {
            x.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", this.foA.filePath);
            if (this.oQi == null) {
                this.oQi = new CommonPlayer(this.oQt);
            }
            this.oQi.reset();
            try {
                this.oQi.setDataSource(new com.tencent.mm.plugin.music.model.f.b(this.foA.hmj));
                this.oQi.prepare();
            } catch (Throwable e222) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e222.getMessage());
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e222, "initPlayer", new Object[0]);
                tK(HardCoderJNI.SCENE_DB);
                tL(HardCoderJNI.SCENE_DB);
            }
        }
    }

    public final void pause() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", this.foy);
        this.oQl = true;
        if (this.oQi != null && Qx()) {
            try {
                x.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
                this.oQi.pause();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "pause", new Object[0]);
                tK(503);
                tL(503);
            }
        } else if (this.oQi != null && isCompleted()) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
            this.oQk = false;
        }
    }

    public final void beH() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
        pause();
    }

    public final void resume() {
        this.aBO = 0;
        boolean beI = beI();
        boolean Qx = Qx();
        this.oQl = false;
        x.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", Boolean.valueOf(beI), Boolean.valueOf(Qx), Boolean.valueOf(this.oQk), this.foy);
        if (this.oQi != null && !isPrepared() && !beI && !Qx && !this.oQk) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
            this.hmd = 0;
            this.oQp = true;
            this.hml = false;
            beG();
            f.tH(this.foA.fromScene);
        } else if (this.oQi == null) {
        } else {
            if ((isPaused() || isPrepared()) && !Qx) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
                try {
                    this.oQi.setVolume((float) this.foA.hmi, (float) this.foA.hmi);
                    this.oQi.start();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "resume", new Object[0]);
                    tK(502);
                    tL(502);
                }
                this.oQk = true;
            }
        }
    }

    public final boolean Qx() {
        if (this.oQi == null || this.oQi.getPlayerState() != 4) {
            return false;
        }
        return true;
    }

    public final boolean beI() {
        if (this.oQi == null || this.oQi.getPlayerState() != 3) {
            return false;
        }
        return true;
    }

    public final boolean isPrepared() {
        if (this.oQi == null || this.oQi.getPlayerState() != 2) {
            return false;
        }
        return true;
    }

    public final boolean isPaused() {
        if (this.oQi == null || this.oQi.getPlayerState() != 5) {
            return false;
        }
        return true;
    }

    public final boolean isCompleted() {
        if (this.oQi == null || this.oQi.getPlayerState() != 7) {
            return false;
        }
        return true;
    }

    public final boolean isStopped() {
        if (this.oQi == null || this.oQi.getPlayerState() != 6) {
            return false;
        }
        return true;
    }

    public final boolean Qy() {
        return this.oQk && !beI();
    }

    public final void stopPlay() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
        this.hml = false;
        beJ();
    }

    final void beJ() {
        try {
            if (this.oQi != null) {
                this.oQi.setVolume(0.0f, 0.0f);
                this.oQi.stop();
            }
            if (this.oQm != null) {
                this.oQm.isStop = true;
                this.oQm = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "stopPlay", new Object[0]);
            tK(504);
            tL(504);
        }
        this.oQk = false;
        this.oQl = true;
        this.gLZ = System.currentTimeMillis();
    }

    public final int beK() {
        if (this.oQi != null) {
            return (int) this.oQi.getCurrentPosition();
        }
        return -1;
    }

    public final int getDuration() {
        if (this.oQi != null) {
            return this.oQi.getDuration();
        }
        return -1;
    }

    public final boolean ii(int i) {
        int duration = getDuration();
        x.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            stopPlay();
            return false;
        } else if (i > duration) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            return false;
        } else {
            if (this.oQi != null) {
                x.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
                b tVar = new t();
                tVar.foD.action = 10;
                tVar.foD.state = "seeking";
                tVar.foD.foy = bex();
                tVar.foD.appId = getAppId();
                com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
                this.oQi.seekTo(i);
            }
            return true;
        }
    }

    public final c beL() {
        int bufferedPercentage;
        boolean z = false;
        if (this.oQj == null) {
            this.oQj = new c();
        }
        int duration = getDuration();
        int beK = beK();
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
        this.oQj.foz = beK;
        this.oQj.duration = duration;
        c cVar = this.oQj;
        if (!Qx) {
            z = true;
        }
        cVar.hmk = z;
        this.oQj.hml = this.hml;
        this.oQj.hmm = (bufferedPercentage * duration) / 100;
        if (this.foA == null) {
            return null;
        }
        this.oQj.hmd = this.foA.hme;
        this.oQj.hmn = this.foA.hmc;
        return this.oQj;
    }

    public final String bex() {
        return this.foy;
    }

    public final String getAppId() {
        if (this.foA != null) {
            return this.foA.appId;
        }
        return "";
    }

    private void tL(int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(688);
        iDKey.SetKey(1);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(688);
        int i2 = this.foA.fromScene;
        x.i("MicroMsg.PlayerErrorHandler", "getQQAudioPlayerErrSceneIdKey, scene:" + i2);
        switch (i2) {
        }
        iDKey2.SetKey(9);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(688);
        x.i("MicroMsg.PlayerErrorHandler", "getQQAudioPlayerErrIdKey, errCode:" + i);
        switch (i) {
            case 53:
                i2 = 17;
                break;
            case 54:
                i2 = 18;
                break;
            case 55:
                i2 = 19;
                break;
            case 62:
                i2 = 20;
                break;
            case 63:
                i2 = 21;
                break;
            case 64:
                i2 = 22;
                break;
            case 66:
                i2 = 23;
                break;
            case 67:
                i2 = 24;
                break;
            case 69:
                i2 = 25;
                break;
            case 70:
                i2 = 36;
                break;
            case 74:
                i2 = 26;
                break;
            case 80:
                i2 = 27;
                break;
            case 101:
                i2 = 28;
                break;
            case 102:
                i2 = 29;
                break;
            case 500:
                i2 = 31;
                break;
            case HardCoderJNI.SCENE_DB /*501*/:
                i2 = 32;
                break;
            case 502:
                i2 = 33;
                break;
            case 503:
                i2 = 34;
                break;
            case 504:
                i2 = 35;
                break;
            default:
                i2 = 30;
                break;
        }
        iDKey3.SetKey(i2);
        iDKey3.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        g.pWK.a(arrayList, true);
    }

    public final void release() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "release");
        this.oQa = null;
        if (this.oQi != null) {
            this.oQi.release();
            this.oQi = null;
        }
        if (this.oQe != null) {
            this.oQe.end();
            this.oQe.cgF();
        }
    }

    public final void beM() {
        if (this.foy.equalsIgnoreCase(this.foA.foy) && this.oQi != null && Qx()) {
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
