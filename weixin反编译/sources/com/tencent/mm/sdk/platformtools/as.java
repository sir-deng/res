package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Looper;

public final class as {

    private enum b {
        NOTSET,
        ON,
        OFF
    }

    public interface a {
        void vi();
    }

    public static MediaPlayer a(Context context, int i, b bVar, boolean z, a aVar) {
        return a(context, i, bVar, -1, false, aVar);
    }

    public static MediaPlayer a(Context context, int i, b bVar, int i2, boolean z, final a aVar) {
        Throwable e;
        Throwable e2;
        if (context == null || bVar == null) {
            x.e("MicroMsg.PlaySound", "play Err context:%s pathId:%d speekeron:%s looping:%b listener:%s", context, Integer.valueOf(i), bVar, Boolean.valueOf(z), aVar);
            return null;
        }
        final String string = context.getString(i);
        final MediaPlayer mediaPlayer = new MediaPlayer();
        if (bVar != b.NOTSET && -1 == i2) {
            mediaPlayer.setAudioStreamType(bVar == b.ON ? 3 : 8);
        } else if (i2 != -1) {
            mediaPlayer.setAudioStreamType(i2);
        }
        x.i("MicroMsg.PlaySound", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b listener:%s ", Integer.valueOf(mediaPlayer.hashCode()), string, context, Integer.valueOf(i), bVar, Boolean.valueOf(z), aVar);
        AssetFileDescriptor assetFileDescriptor = null;
        AssetFileDescriptor openFd;
        try {
            openFd = context.getAssets().openFd(string);
            try {
                mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                mediaPlayer.setLooping(z);
                mediaPlayer.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        x.i("MicroMsg.PlaySound", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (mediaPlayer != null) {
                            try {
                                mediaPlayer.release();
                            } catch (Exception e) {
                            }
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        return false;
                    }
                });
                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        String str = "MicroMsg.PlaySound";
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
                        if (aVar != null) {
                            aVar.vi();
                        }
                    }
                });
                mediaPlayer.prepare();
                mediaPlayer.start();
                String str = "MicroMsg.PlaySound";
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
                    x.printErrStackTrace("MicroMsg.PlaySound", e3, "", new Object[0]);
                    return mediaPlayer;
                }
            } catch (Exception e4) {
                e3 = e4;
                assetFileDescriptor = openFd;
                try {
                    x.e("MicroMsg.PlaySound", "play failed pathId:%d e:%s", Integer.valueOf(i), e3.getMessage());
                    x.printErrStackTrace("MicroMsg.PlaySound", e3, "", new Object[0]);
                    mediaPlayer.release();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.PlaySound", e22, "", new Object[0]);
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
                            x.printErrStackTrace("MicroMsg.PlaySound", e32, "", new Object[0]);
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
        } catch (Throwable th3) {
            e22 = th3;
            openFd = null;
            if (openFd != null) {
                openFd.close();
            }
            throw e22;
        }
    }

    public static void a(Context context, int i, a aVar) {
        a(context, i, b.ON, false, aVar);
    }

    public static void b(Context context, int i, a aVar) {
        a(context, i, b.NOTSET, false, aVar);
    }

    public static void H(Context context, int i) {
        a(context, i, b.NOTSET, false, null);
    }
}
