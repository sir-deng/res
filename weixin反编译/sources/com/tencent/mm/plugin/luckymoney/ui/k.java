package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.x;

public final class k {

    private enum a {
        NOTSET,
        ON,
        OFF
    }

    public static void H(Context context, int i) {
        a aVar = a.NOTSET;
        if (context == null || aVar == null) {
            x.e("MicroMsg.LuckySoundUtil", "play Err context:%s pathId:%d speekeron:%s looping:%b", context, Integer.valueOf(i), aVar, Boolean.valueOf(false));
        } else if (com.tencent.mm.j.a.zv() && com.tencent.mm.j.a.zy()) {
            final String string = context.getString(i);
            MediaPlayer jVar = new j();
            if (aVar != a.NOTSET) {
                jVar.setAudioStreamType(aVar == a.ON ? 5 : 0);
            }
            x.i("MicroMsg.LuckySoundUtil", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b ", Integer.valueOf(jVar.hashCode()), string, context, Integer.valueOf(i), aVar, Boolean.valueOf(false));
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd(string);
                jVar.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                openFd.close();
                jVar.setLooping(false);
                jVar.prepare();
                jVar.start();
                jVar.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        x.i("MicroMsg.LuckySoundUtil", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                        return false;
                    }
                });
                jVar.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        String str = "MicroMsg.LuckySoundUtil";
                        String str2 = "play completion mp:%d  path:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = string;
                        x.i(str, str2, objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                    }
                });
            } catch (Throwable e) {
                x.e("MicroMsg.LuckySoundUtil", "play failed pathId:%d e:%s", Integer.valueOf(i), e.getMessage());
                x.printErrStackTrace("MicroMsg.LuckySoundUtil", e, "", new Object[0]);
            }
        }
    }
}
