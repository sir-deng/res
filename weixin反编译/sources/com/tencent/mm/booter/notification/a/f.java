package com.tencent.mm.booter.notification.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.IOException;
import java.nio.charset.Charset;

public final class f {
    Context context;
    boolean gCd;
    MediaPlayer gCe;
    @SuppressLint({"HandlerLeak"})
    ag gCf;
    private ag gCg;

    /* renamed from: com.tencent.mm.booter.notification.a.f$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String gCi;
        final /* synthetic */ boolean gCj = false;

        AnonymousClass2(String str, boolean z) {
            this.gCi = str;
        }

        public final void run() {
            f fVar = f.this;
            String str = this.gCi;
            boolean z = this.gCj;
            if (fVar.context == null) {
                fVar.context = ad.getContext();
            }
            if (fVar.context == null) {
                x.w("MicroMsg.Notification.Tool.Sound", "playSound:context is null!!");
                return;
            }
            try {
                AudioManager audioManager = (AudioManager) fVar.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (audioManager.getStreamVolume(5) != 0) {
                    Uri defaultUri;
                    fVar.gCf.removeMessages(305419896);
                    fVar.gCf.sendEmptyMessageDelayed(305419896, 8000);
                    x.i("MicroMsg.Notification.Tool.Sound", "doPlaySound playerIsInit: %s", Boolean.valueOf(fVar.gCd));
                    if (fVar.gCd) {
                        try {
                            if (fVar.gCe != null) {
                                if (fVar.gCe.isPlaying()) {
                                    fVar.gCe.stop();
                                }
                                fVar.gCe.release();
                                x.i("MicroMsg.Notification.Tool.Sound", "try to release player before playSound playerIsInit: %s", Boolean.valueOf(fVar.gCd));
                            }
                        } catch (IllegalStateException e) {
                            x.w("MicroMsg.Notification.Tool.Sound", "try to release player before playSound error");
                            if (fVar.gCe != null) {
                                fVar.gCe.release();
                            }
                        }
                        fVar.gCd = false;
                    }
                    fVar.gCe = new j();
                    x.i("MicroMsg.Notification.Tool.Sound", "doPlaySound player: %s", fVar.gCe);
                    MediaPlayer mediaPlayer = fVar.gCe;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (bi.oN(str)) {
                        defaultUri = RingtoneManager.getDefaultUri(2);
                    } else if (z) {
                        AssetFileDescriptor openFd = fVar.context.getAssets().openFd(str);
                        mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        openFd.close();
                        defaultUri = null;
                    } else {
                        defaultUri = Uri.parse(str);
                    }
                    if (defaultUri != null) {
                        try {
                            mediaPlayer.setDataSource(fVar.context, defaultUri);
                        } catch (IOException e2) {
                            if (bi.oN(str)) {
                                x.i("MicroMsg.Notification.Tool.Sound", "setPlayerDataSource IOException soundUri:%s, isAsset:%s", str, Boolean.valueOf(z));
                            } else {
                                mediaPlayer.setDataSource(fVar.context, RingtoneManager.getDefaultUri(2));
                            }
                        }
                    }
                    x.i("MicroMsg.Notification.Tool.Sound", "summeranrt setPlayerDataSource tid[%d] [%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (audioManager.isWiredHeadsetOn()) {
                        com.tencent.mm.compatible.b.f.xU();
                        x.d("MicroMsg.Notification.Tool.Sound", "headset on, selected stream type: %s", Integer.valueOf(0));
                        float streamVolume = (float) audioManager.getStreamVolume(0);
                        float streamMaxVolume = (float) audioManager.getStreamMaxVolume(0);
                        float streamVolume2 = ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
                        x.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s, maxVolume: %s, toneScale: %s", Float.valueOf(streamVolume), Float.valueOf(streamMaxVolume), Float.valueOf(streamVolume / streamMaxVolume));
                        x.d("MicroMsg.Notification.Tool.Sound", "headset on, toneMUSICVolume: %s, maxMUSICVolume: %s, toneMusicScale: %s", Float.valueOf(r3), Float.valueOf(r5), Float.valueOf(streamVolume2));
                        if (streamVolume / streamMaxVolume > streamVolume2) {
                            streamVolume = streamMaxVolume * streamVolume2;
                            x.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s", Float.valueOf(streamVolume));
                        }
                        audioManager.setSpeakerphoneOn(false);
                        x.i("MicroMsg.Notification.Tool.Sound", "notificationSetMode: %s", Integer.valueOf(q.gHP.gHl));
                        if (q.gHP.gHl == 1) {
                            x.i("MicroMsg.Notification.Tool.Sound", "notification set mode enable, set mode now");
                            if (audioManager.getMode() == 0) {
                                audioManager.setMode(3);
                            }
                            fVar.gCe.setOnCompletionListener(new AnonymousClass3(audioManager));
                            fVar.gCe.setOnErrorListener(new AnonymousClass4(audioManager));
                        } else {
                            fVar.gCe.setOnCompletionListener(new OnCompletionListener() {
                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", f.this.gCe);
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    if (f.this.gCe != null) {
                                        f.this.gCe.release();
                                    }
                                }
                            });
                            fVar.gCe.setOnErrorListener(new OnErrorListener() {
                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", f.this.gCe);
                                    if (mediaPlayer != null) {
                                        mediaPlayer.release();
                                    }
                                    if (f.this.gCe != null) {
                                        f.this.gCe.release();
                                    }
                                    return false;
                                }
                            });
                        }
                        fVar.gCe.setAudioStreamType(0);
                        fVar.gCe.setLooping(true);
                        fVar.gCe.prepare();
                        fVar.gCe.setVolume(streamVolume / streamMaxVolume, streamVolume / streamMaxVolume);
                        fVar.gCe.setLooping(false);
                        fVar.gCe.start();
                        fVar.gCd = true;
                        return;
                    }
                    x.d("MicroMsg.Notification.Tool.Sound", "getStreamVolume =  %d, soundUri = %s", Integer.valueOf(audioManager.getStreamVolume(5)), str);
                    fVar.gCe.setOnCompletionListener(new OnCompletionListener() {
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            x.i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", f.this.gCe);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (f.this.gCe != null) {
                                f.this.gCe.release();
                                x.i("MicroMsg.Notification.Tool.Sound", "play sound real finish, player: %s,playerIsInit:%s", f.this.gCe, Boolean.valueOf(f.this.gCd));
                            }
                        }
                    });
                    fVar.gCe.setOnErrorListener(new OnErrorListener() {
                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            x.i("MicroMsg.Notification.Tool.Sound", "play sound error, player: %s", f.this.gCe);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (f.this.gCe != null) {
                                f.this.gCe.release();
                                x.i("MicroMsg.Notification.Tool.Sound", "play sound real error, player: %s,playerIsInit:%s", f.this.gCe, Boolean.valueOf(f.this.gCd));
                            }
                            return false;
                        }
                    });
                    fVar.gCe.setAudioStreamType(5);
                    fVar.gCe.setLooping(true);
                    fVar.gCe.prepare();
                    fVar.gCe.setLooping(false);
                    fVar.gCe.start();
                    fVar.gCd = true;
                    String str2 = "MicroMsg.Notification.Tool.Sound";
                    String str3 = "doPlaySound start finish playerIsInit:%s, myLooper[%b] mainLooper[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(fVar.gCd);
                    objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                    objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                    x.i(str2, str3, objArr);
                }
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e3, "PlaySound Exception:", new Object[0]);
                try {
                    if (fVar.gCe != null) {
                        fVar.gCe.release();
                    }
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e32, "try to release player in Exception:", new Object[0]);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.booter.notification.a.f$4 */
    class AnonymousClass4 implements OnErrorListener {
        final /* synthetic */ AudioManager gCk;

        AnonymousClass4(AudioManager audioManager) {
            this.gCk = audioManager;
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", f.this.gCe);
            this.gCk.setMode(0);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (f.this.gCe != null) {
                f.this.gCe.release();
            }
            return false;
        }
    }

    private static class a {
        private static final f gCl = new f();
    }

    /* renamed from: com.tencent.mm.booter.notification.a.f$3 */
    class AnonymousClass3 implements OnCompletionListener {
        final /* synthetic */ AudioManager gCk;

        AnonymousClass3(AudioManager audioManager) {
            this.gCk = audioManager;
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            x.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", f.this.gCe);
            this.gCk.setMode(0);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (f.this.gCe != null) {
                f.this.gCe.release();
            }
        }
    }

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        String str = null;
        this.gCd = false;
        this.gCe = null;
        this.gCf = new ag(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                x.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", Boolean.valueOf(f.this.gCd));
                try {
                    if (f.this.gCe != null) {
                        if (f.this.gCe.isPlaying()) {
                            f.this.gCe.stop();
                        }
                        f.this.gCe.release();
                        f.this.gCd = false;
                        x.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", Boolean.valueOf(f.this.gCd));
                    }
                } catch (IllegalStateException e) {
                    x.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", Boolean.valueOf(f.this.gCd));
                    if (f.this.gCe != null) {
                        f.this.gCe.release();
                    }
                }
            }
        };
        this.context = ad.getContext();
        String str2 = w.hbv + "deviceconfig.cfg";
        x.i("MicroMsg.ServerConfigInfoStorage", "readConfigFromLocalFile, path: %s, isExist: %s", str2, Boolean.valueOf(e.bO(str2)));
        if (e.bO(str2)) {
            byte[] e = e.e(str2, 0, -1);
            if (!bi.by(e)) {
                str2 = new String(e, Charset.defaultCharset());
                if (!bi.oN(str2)) {
                    str = str2;
                }
            }
        }
        q.eK(str);
    }

    public final synchronized void ex(String str) {
        if (this.gCg == null) {
            x.i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
            HandlerThread dc = com.tencent.mm.sdk.f.e.dc("playSoundThread", 0);
            dc.start();
            this.gCg = new ag(dc.getLooper());
        }
        this.gCg.post(new AnonymousClass2(str, false));
    }
}
