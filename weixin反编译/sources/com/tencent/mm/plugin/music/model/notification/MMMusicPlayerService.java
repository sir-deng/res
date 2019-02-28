package com.tencent.mm.plugin.music.model.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.g.c;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class MMMusicPlayerService extends Service {
    a oRG;
    Runnable oRH = new Runnable() {
        public final void run() {
            x.i("MicroMsg.Music.MMMusicPlayerService", "quit");
            ah.K(MMMusicPlayerService.this.oRH);
            MMMusicPlayerService.this.stopSelf();
        }
    };

    public class a extends Binder {
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
        x.i("MicroMsg.Music.MMMusicPlayerService", "init");
        this.oRG = new a();
        a aVar = this.oRG;
        x.i("MicroMsg.Music.MMMusicNotification", "init");
        aVar.oRy = this;
        aVar.oRz = (NotificationManager) getSystemService("notification");
        aVar.oRB = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if (intent != null && !bi.oN(intent.getAction())) {
                    String stringExtra = intent.getStringExtra("mm_music_notification_action_key");
                    if (bi.oN(stringExtra)) {
                        x.e("MicroMsg.Music.MMMusicNotification", "action is null, err, return");
                        return;
                    }
                    x.i("MicroMsg.Music.MMMusicNotification", "action:%s", stringExtra);
                    c bdT = h.bef().bdT();
                    if (bdT == null) {
                        x.e("MicroMsg.Music.MMMusicNotification", "musicPlayer is null, return");
                        return;
                    }
                    com.tencent.mm.au.a bdU = h.bef().bdU();
                    if (bdU == null) {
                        x.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
                    } else if (stringExtra.equals("mm_music_notification_action_play")) {
                        bdT.resume();
                        f.a(2, bdU);
                    } else if (stringExtra.equals("mm_music_notification_action_pause")) {
                        bdT.bet();
                        h.bei().bdR();
                        f.a(3, bdU);
                    } else if (stringExtra.equals("mm_music_notification_action_pre")) {
                        if (bdU.field_musicType == 11) {
                            h.bef().bdY();
                        } else if (h.bef().mode == 2) {
                            e bef = h.bef();
                            if (bef.mode != 1) {
                                bef.oPf = (bef.oPf + bef.oPg.size()) - 1;
                                bef.oPf %= bef.oPg.size();
                                bef.bdY();
                                bef.e(null);
                            }
                        } else {
                            bdT.ii(0);
                            bdT.resume();
                        }
                        a.a(bdU, 13, bdT.bev());
                        f.a(1, bdU);
                    } else if (stringExtra.equals("mm_music_notification_action_next")) {
                        if (bdU.field_musicType == 11) {
                            h.bef().bdY();
                        } else if (h.bef().mode == 2) {
                            h.bef().bdX();
                        } else {
                            bdT.ii(0);
                            bdT.resume();
                        }
                        a.a(bdU, 14, bdT.bev());
                        f.a(4, bdU);
                    } else if (stringExtra.equals("mm_music_notification_action_close")) {
                        ah.y(a.this.oRA);
                        bdT.stopPlay();
                        f.a(5, bdU);
                    }
                }
            }
        };
        registerReceiver(aVar.oRB, new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK"));
        aVar.isInit = true;
        refresh();
    }

    final void refresh() {
        x.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
        com.tencent.mm.au.a bdU = h.bef().bdU();
        if (bdU == null) {
            x.e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
        } else if (bi.oN(bdU.field_protocol)) {
            c bdT = h.bef().bdT();
            if (bdT == null) {
                x.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
            } else if (bdT.Qx()) {
                k(bdU);
            } else if (bdT.beu()) {
                l(bdU);
            }
        } else {
            x.e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public final void k(com.tencent.mm.au.a aVar) {
        x.i("MicroMsg.Music.MMMusicPlayerService", "play");
        if (aVar == null) {
            x.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            return;
        }
        ah.K(this.oRH);
        a aVar2 = this.oRG;
        if (!aVar2.isInit) {
            x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
        } else if (aVar2.oRy == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
        } else {
            x.i("MicroMsg.Music.MMMusicNotification", "play");
            ah.K(aVar2.oRA);
            aVar2.oRy.startForeground(JsApiCreateAudioInstance.CTRL_INDEX, aVar2.a(aVar2.oRy, aVar, true));
        }
    }

    public final void l(com.tencent.mm.au.a aVar) {
        x.i("MicroMsg.Music.MMMusicPlayerService", "pause");
        if (aVar == null) {
            x.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            return;
        }
        ah.K(this.oRH);
        a aVar2 = this.oRG;
        if (!aVar2.isInit) {
            x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
        } else if (aVar2.oRy == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
        } else {
            x.i("MicroMsg.Music.MMMusicNotification", "pause");
            ah.K(aVar2.oRA);
            aVar2.oRz.notify(JsApiCreateAudioInstance.CTRL_INDEX, aVar2.a(aVar2.oRy, aVar, false));
        }
    }

    public final void stop() {
        x.i("MicroMsg.Music.MMMusicPlayerService", "stop");
        a aVar = this.oRG;
        if (!aVar.isInit) {
            x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
        } else if (aVar.oRy == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
        } else {
            x.i("MicroMsg.Music.MMMusicNotification", "close");
            ah.K(aVar.oRA);
            ah.h(aVar.oRA, 1000);
        }
        ah.K(this.oRH);
        ah.h(this.oRH, 60000);
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
        a aVar = this.oRG;
        x.i("MicroMsg.Music.MMMusicNotification", "uninit");
        aVar.oRy.unregisterReceiver(aVar.oRB);
        aVar.oRB = null;
        aVar.oRy = null;
        aVar.oRz = null;
        aVar.isInit = false;
    }

    public IBinder onBind(Intent intent) {
        return new a();
    }
}
