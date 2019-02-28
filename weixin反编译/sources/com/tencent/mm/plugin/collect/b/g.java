package com.tencent.mm.plugin.collect.b;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.f.a.bs;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g extends c<bs> implements e {
    private static final String lnV = (com.tencent.mm.compatible.util.e.bnF + "wallet/voice/");
    private static final com.tencent.mm.bp.b lnW = com.tencent.mm.bp.b.TQ("元");
    private MediaPlayer lnX;
    private MediaPlayer lnY;
    public ConcurrentLinkedQueue<b> lnZ;
    private boolean loa;
    private int lob;
    private int loc;
    private long lod;
    private WeakReference<ArrayList<String>> loe;

    private static class a {
        public static MediaPlayer a(Context context, int i, final OnCompletionListener onCompletionListener, final OnErrorListener onErrorListener) {
            Throwable e;
            AssetFileDescriptor assetFileDescriptor;
            Throwable e2;
            if (context == null) {
                x.e("MicroMsg.F2fRcvVoiceListener", "play Err context:%s pathId:%d", context, Integer.valueOf(i));
                return null;
            }
            final String string = context.getString(i);
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            x.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s context:%s pathId:%d", Integer.valueOf(mediaPlayer.hashCode()), string, context, Integer.valueOf(i));
            AssetFileDescriptor openFd;
            try {
                openFd = context.getAssets().openFd(string);
                try {
                    mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    mediaPlayer.setLooping(false);
                    mediaPlayer.setOnErrorListener(new OnErrorListener() {
                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            x.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                            if (mediaPlayer != null) {
                                try {
                                    mediaPlayer.release();
                                } catch (Exception e) {
                                }
                            }
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (onErrorListener != null) {
                                onErrorListener.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            String str = "MicroMsg.F2fRcvVoiceListener";
                            String str2 = "play completion mp:%d  path:%s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                            objArr[1] = string;
                            x.i(str, str2, objArr);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (onCompletionListener != null) {
                                onCompletionListener.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    String str = "MicroMsg.F2fRcvVoiceListener";
                    String str2 = "play start mp finish [%d], myLooper[%b] mainLooper[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
                    objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                    objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                    x.i(str, str2, objArr);
                    if (openFd == null) {
                        return mediaPlayer;
                    }
                    try {
                        openFd.close();
                        return mediaPlayer;
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e3, "", new Object[0]);
                        return mediaPlayer;
                    }
                } catch (Exception e4) {
                    e3 = e4;
                    assetFileDescriptor = openFd;
                    try {
                        x.e("MicroMsg.F2fRcvVoiceListener", "play failed pathId:%d e:%s", Integer.valueOf(i), e3.getMessage());
                        x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e3, "", new Object[0]);
                        mediaPlayer.release();
                        if (assetFileDescriptor != null) {
                            try {
                                assetFileDescriptor.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e22, "", new Object[0]);
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e22 = th;
                        openFd = assetFileDescriptor;
                        if (openFd != null) {
                            try {
                                openFd.close();
                            } catch (Throwable e32) {
                                x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e32, "", new Object[0]);
                            }
                        }
                        throw e22;
                    }
                } catch (Throwable th2) {
                    e22 = th2;
                    if (openFd != null) {
                        openFd.close();
                    }
                    throw e22;
                }
            } catch (Exception e5) {
                e32 = e5;
                assetFileDescriptor = null;
            } catch (Throwable th3) {
                e22 = th3;
                openFd = null;
                if (openFd != null) {
                    openFd.close();
                }
                throw e22;
            }
        }

        public static MediaPlayer a(final String str, final OnCompletionListener onCompletionListener, final OnErrorListener onErrorListener) {
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            x.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", Integer.valueOf(mediaPlayer.hashCode()), str);
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.setLooping(false);
                mediaPlayer.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        x.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (mediaPlayer != null) {
                            try {
                                mediaPlayer.release();
                            } catch (Exception e) {
                            }
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (onErrorListener != null) {
                            onErrorListener.onError(mediaPlayer, i, i2);
                        }
                        return false;
                    }
                });
                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        String str = "MicroMsg.F2fRcvVoiceListener";
                        String str2 = "play completion mp:%d  path:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = str;
                        x.i(str, str2, objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (onCompletionListener != null) {
                            onCompletionListener.onCompletion(mediaPlayer);
                        }
                    }
                });
                mediaPlayer.prepare();
                mediaPlayer.start();
                String str2 = "MicroMsg.F2fRcvVoiceListener";
                String str3 = "play start mp finish [%d], myLooper[%b] mainLooper[%b]";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
                objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                x.i(str2, str3, objArr);
                return mediaPlayer;
            } catch (Throwable e) {
                x.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", str, e.getMessage());
                x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e, "", new Object[0]);
                mediaPlayer.release();
                return null;
            }
        }
    }

    private class b {
        String fileName;
        String fqL;
        int fws;
        int lol;

        private b() {
        }

        /* synthetic */ b(g gVar, byte b) {
            this();
        }
    }

    static /* synthetic */ void e(g gVar) {
        x.i("MicroMsg.F2fRcvVoiceListener", "reset user vol: %s", Integer.valueOf(gVar.lob));
        f.xN().aM(3, gVar.lob);
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        bs bsVar = (bs) bVar;
        x.i("MicroMsg.F2fRcvVoiceListener", "feeType: %s, source: %s, tradeNo: %s", bsVar.fqI.fqK, Integer.valueOf(bsVar.fqI.cPf), bsVar.fqI.fqL);
        long j = bsVar.fqI.fqN;
        if (j > 60000) {
            x.i("MicroMsg.F2fRcvVoiceListener", "delay over 1min: %s, tradeNo: %s", Long.valueOf(j), bsVar.fqI.fqL);
            if (j <= 120000) {
                com.tencent.mm.plugin.report.service.g.pWK.a(699, 3, 1, false);
            } else if (j <= 300000) {
                com.tencent.mm.plugin.report.service.g.pWK.a(699, 4, 1, false);
            } else if (j <= 600000) {
                com.tencent.mm.plugin.report.service.g.pWK.a(699, 5, 1, false);
            } else if (j <= 1800000) {
                com.tencent.mm.plugin.report.service.g.pWK.a(699, 6, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.a(699, 7, 1, false);
            }
        }
        k iVar;
        if (bsVar.fqI.fqM.equals("wx_f2f")) {
            com.tencent.mm.plugin.collect.a.a.azl();
            boolean azn = com.tencent.mm.plugin.collect.a.a.azn();
            x.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", Integer.valueOf(bsVar.fqI.fqJ), Boolean.valueOf(azn));
            if (!xY(bsVar.fqI.fqL)) {
                if (bsVar.fqI.cPf == 0) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(699, 8, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.a(699, 9, 1, false);
                }
                iVar = new i(bsVar.fqI.fqJ, lnW, bsVar.fqI.fqL);
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(iVar, 0);
            }
        } else if (bsVar.fqI.fqM.equals("wx_md")) {
            iVar = new n(bsVar.fqI.fqJ, lnW, bsVar.fqI.fqL);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(iVar, 0);
        } else {
            x.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", bsVar.fqI.fqM);
        }
        return false;
    }

    public g() {
        this.loa = false;
        this.xmG = bs.class.getName().hashCode();
    }

    private List<String> azq() {
        if (this.loe == null || this.loe.get() == null) {
            x.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
            this.loe = new WeakReference(new ArrayList(bi.fy((String) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_F2F_RCV_VOICE_PLAYED_LIST_STRING_SYNC, (Object) ""), ",")));
        }
        return (List) this.loe.get();
    }

    private synchronized boolean xY(String str) {
        boolean z;
        if (bi.oN(str)) {
            x.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", str);
            z = true;
        } else {
            List subList;
            List azq = azq();
            for (String equals : azq()) {
                if (equals.equals(str)) {
                    x.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", str);
                    z = true;
                    break;
                }
            }
            azq.add(str);
            if (azq.size() > 3) {
                x.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
                int size = azq.size();
                subList = azq.subList(size - 3, size);
            } else {
                subList = azq;
            }
            com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_F2F_RCV_VOICE_PLAYED_LIST_STRING_SYNC, bi.d(subList, ","));
            z = false;
        }
        return z;
    }

    private static boolean l(String str, byte[] bArr) {
        com.tencent.mm.kernel.g.Dr();
        if (!com.tencent.mm.kernel.g.Dq().isSDCardAvailable()) {
            x.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
            return false;
        } else if (FileOp.j(str, bArr) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean azr() {
        x.i("MicroMsg.F2fRcvVoiceListener", "delete files");
        return com.tencent.mm.a.e.bP(lnV);
    }

    private synchronized void azs() {
        boolean z = false;
        synchronized (this) {
            if (System.currentTimeMillis() - this.lod > 10000) {
                x.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", Long.valueOf(this.lod));
                this.loa = false;
            }
            if (this.loa) {
                x.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
            } else {
                this.loa = true;
                this.lod = System.currentTimeMillis();
                final b bVar = (b) this.lnZ.poll();
                f xN = f.xN();
                int streamMaxVolume = xN.getStreamMaxVolume(3);
                this.lob = xN.getStreamVolume(3);
                this.loc = Math.round(((float) streamMaxVolume) * 0.4f);
                x.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", Integer.valueOf(this.lob), Integer.valueOf(streamMaxVolume), Integer.valueOf(this.loc));
                if (VERSION.SDK_INT >= 23) {
                    z = xN.gDM.isStreamMute(3);
                    x.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", Boolean.valueOf(z));
                }
                if (this.lob > 0 && this.lob < this.loc && !z) {
                    xN.aM(3, this.loc);
                }
                if (bVar != null) {
                    int i = i.uPu;
                    if (bVar.lol == 2) {
                        i = i.uSC;
                    }
                    if (bi.oN(bVar.fileName)) {
                        this.lnX = a.a(ad.getContext(), i, new OnCompletionListener() {
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                x.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
                                g.e(g.this);
                                g.this.loa = false;
                                g.this.lnX = null;
                                if (g.this.lnZ.isEmpty()) {
                                    g.azr();
                                } else {
                                    g.this.azs();
                                }
                            }
                        }, new OnErrorListener() {
                            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                x.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
                                g.e(g.this);
                                g.this.loa = false;
                                g.this.lnX = null;
                                return false;
                            }
                        });
                        com.tencent.mm.plugin.report.service.g.pWK.a(699, 2, 1, false);
                    } else {
                        x.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", Integer.valueOf(r2));
                        this.lnX = a.a(ad.getContext(), i, new OnCompletionListener() {
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                x.i("MicroMsg.F2fRcvVoiceListener", "start play money");
                                if (g.this.lnX != null && g.this.loa && g.this.lnY == null) {
                                    g.this.lnY = a.a(bVar.fileName, new OnCompletionListener() {
                                        public final void onCompletion(MediaPlayer mediaPlayer) {
                                            x.i("MicroMsg.F2fRcvVoiceListener", "play done");
                                            g.this.loa = false;
                                            g.this.lnY = null;
                                            g.e(g.this);
                                            if (g.this.lnZ.isEmpty()) {
                                                g.azr();
                                            } else {
                                                g.this.azs();
                                            }
                                        }
                                    }, new OnErrorListener() {
                                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                            x.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
                                            g.this.loa = false;
                                            g.this.lnY = null;
                                            g.e(g.this);
                                            if (g.this.lnZ.isEmpty()) {
                                                g.azr();
                                            } else {
                                                g.this.azs();
                                            }
                                            return false;
                                        }
                                    });
                                } else {
                                    x.i("MicroMsg.F2fRcvVoiceListener", "has played");
                                }
                                g.this.lnX = null;
                            }
                        }, new OnErrorListener() {
                            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                x.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
                                g.this.loa = false;
                                g.this.lnX = null;
                                g.e(g.this);
                                if (g.this.lnZ.isEmpty()) {
                                    g.azr();
                                } else {
                                    g.this.azs();
                                }
                                return false;
                            }
                        });
                        if (this.lnX != null) {
                            x.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", Integer.valueOf(this.lnX.getDuration()));
                            ah.h(new Runnable() {
                                public final void run() {
                                    if (g.this.lnX != null && g.this.loa && g.this.lnY == null) {
                                        x.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                                        com.tencent.mm.plugin.report.service.g.pWK.a(699, 1, 1, false);
                                    }
                                }
                            }, (long) (r0 + 1000));
                        }
                    }
                } else {
                    this.loa = false;
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        File file;
        String str2;
        b bVar;
        if (kVar instanceof i) {
            i iVar = (i) kVar;
            b bVar2;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", iVar);
                bVar2 = new b();
                bVar2.lol = 1;
                bVar2.fqL = iVar.fqL;
                this.lnZ.add(bVar2);
                azs();
            } else if (iVar.lop.lot == 0) {
                file = new File(lnV);
                if (file.exists() || file.mkdirs()) {
                    str2 = lnV + UUID.randomUUID().toString() + ".tmp";
                    x.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", str2);
                    if (l(str2, iVar.lop.waX.oz)) {
                        bVar = new b();
                        bVar.fileName = str2;
                        bVar.fws = iVar.lop.waW;
                        bVar.lol = 1;
                        bVar.fqL = iVar.fqL;
                        this.lnZ.add(bVar);
                        azs();
                        return;
                    }
                    x.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                    return;
                }
                x.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            } else if (iVar.lop.lot <= 100) {
                x.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
                bVar2 = new b();
                bVar2.lol = 1;
                bVar2.fqL = iVar.fqL;
                this.lnZ.add(bVar2);
                azs();
            } else {
                x.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
            }
        } else if (kVar instanceof n) {
            n nVar = (n) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", nVar);
            } else if (nVar.loJ.lot == 0) {
                file = new File(lnV);
                if (file.exists() || file.mkdirs()) {
                    str2 = lnV + UUID.randomUUID().toString() + ".tmp";
                    x.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", str2);
                    if (l(str2, nVar.loJ.waX.oz)) {
                        bVar = new b();
                        bVar.fileName = str2;
                        bVar.fws = nVar.loJ.waW;
                        bVar.lol = 2;
                        this.lnZ.add(bVar);
                        azs();
                        return;
                    }
                    x.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                    return;
                }
                x.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            }
        }
    }
}
