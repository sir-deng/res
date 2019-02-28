package com.tencent.mm.plugin.music.model.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.support.v4.app.z.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.a.c.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.ui.MusicMainUI;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public final class a {
    boolean isInit = false;
    Runnable oRA = new Runnable() {
        public final void run() {
            x.i("MicroMsg.Music.MMMusicNotification", "close");
            ah.K(a.this.oRA);
            a.this.oRy.stopForeground(true);
        }
    };
    BroadcastReceiver oRB;
    MMMusicPlayerService oRy;
    NotificationManager oRz;

    public static void a(com.tencent.mm.au.a aVar, int i, boolean z) {
        x.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", Integer.valueOf(i));
        b jtVar = new jt();
        jtVar.fBu.action = i;
        jtVar.fBu.state = "";
        jtVar.fBu.fBq = aVar.Qu();
        jtVar.fBu.appId = "not from app brand appid";
        jtVar.fBu.fBw = z;
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
    }

    final Notification a(Context context, final com.tencent.mm.au.a aVar, boolean z) {
        CharSequence charSequence;
        Bitmap bitmap;
        int i;
        Intent intent = new Intent(context, MusicMainUI.class);
        intent.putExtra("key_scene", 5);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        d dVar = new d(context);
        dVar.sa = activity;
        d U = dVar.U(com.tencent.mm.bk.a.bYI());
        CharSequence charSequence2 = aVar.field_songName;
        String str = aVar.field_songSinger;
        if (bi.oN(aVar.field_songAlbum)) {
            Object charSequence3 = str;
        } else {
            charSequence3 = str + aVar.field_songAlbum;
        }
        if (aVar == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
            bitmap = null;
        } else {
            bitmap = null;
            x.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", Integer.valueOf(aVar.field_musicType));
            switch (aVar.field_musicType) {
                case 0:
                case 5:
                case 7:
                case 10:
                case 11:
                    bitmap = o.PC().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bu.a.getDensity(this.oRy), true);
                    break;
                case 1:
                case 8:
                case 9:
                    are are = new are();
                    are.nMq = aVar.field_songMediaId;
                    are.wEP = aVar.field_songAlbumUrl;
                    are.wEQ = aVar.field_songAlbumType;
                    are.nlE = are.wEP;
                    if (n.qWB != null) {
                        bitmap = n.qWB.b(are);
                        break;
                    }
                    break;
                case 6:
                    bitmap = o.PC().b(aVar.field_songAlbumLocalPath, com.tencent.mm.bu.a.getDensity(this.oRy), true);
                    break;
            }
            if (bitmap == null) {
                bitmap = o.PG().lC(aVar.field_songAlbumUrl);
                if (bitmap == null) {
                    final String c = g.c(aVar, false);
                    com.tencent.mm.ap.a.a.c.a aVar2 = new com.tencent.mm.ap.a.a.c.a();
                    aVar2.hFn = g.c(aVar, false);
                    aVar2.hFl = true;
                    aVar2.bc(com.tencent.mm.bu.a.aa(this.oRy, R.f.notification_large_icon_width), com.tencent.mm.bu.a.aa(this.oRy, R.f.notification_large_icon_height));
                    aVar2.hFj = true;
                    o.PG().a(aVar.field_songAlbumUrl, aVar2.PQ(), new c() {
                        public final void a(boolean z, Object... objArr) {
                            x.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", aVar.field_songAlbumUrl, Boolean.valueOf(z));
                            if (z) {
                                Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(c, null);
                                if (decodeFile == null) {
                                    x.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                                    return;
                                }
                                o.PG().i(aVar.field_songAlbumUrl, decodeFile);
                                a.this.oRy.refresh();
                            }
                        }
                    });
                }
            }
            bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, 12.0f, false);
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.i.dqX);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.h.cyp, bitmap);
        } else {
            remoteViews.setImageViewResource(R.h.cyp, R.g.bBE);
        }
        if (bi.oN(charSequence2)) {
            remoteViews.setViewVisibility(R.h.cyv, 8);
        } else {
            remoteViews.setViewVisibility(R.h.cyv, 0);
            remoteViews.setTextViewText(R.h.cyv, charSequence2);
        }
        if (bi.oN(charSequence3)) {
            remoteViews.setViewVisibility(R.h.cyr, 8);
        } else {
            remoteViews.setViewVisibility(R.h.cyr, 0);
            remoteViews.setTextViewText(R.h.cyr, charSequence3);
        }
        Context context2 = this.oRy;
        RemoteViews remoteViews2 = new d(context2).build().contentView;
        if (remoteViews2 == null) {
            i = WebView.NIGHT_MODE_COLOR;
        } else {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context2).inflate(remoteViews2.getLayoutId(), null);
            TextView textView = (TextView) viewGroup.findViewById(16908310);
            i = textView != null ? textView.getCurrentTextColor() : h(viewGroup);
        }
        i |= WebView.NIGHT_MODE_COLOR;
        int red = Color.red(WebView.NIGHT_MODE_COLOR) - Color.red(i);
        int green = Color.green(WebView.NIGHT_MODE_COLOR) - Color.green(i);
        i = Color.blue(WebView.NIGHT_MODE_COLOR) - Color.blue(i);
        Object obj = Math.sqrt((double) ((i * i) + ((red * red) + (green * green)))) < 180.0d ? 1 : null;
        Intent intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 134217728);
        remoteViews.setImageViewResource(R.h.cyu, obj != null ? R.g.bFr : R.g.bFs);
        remoteViews.setOnClickPendingIntent(R.h.cyu, broadcast);
        intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        if (z) {
            intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
        } else {
            intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
        }
        broadcast = PendingIntent.getBroadcast(context, 1, intent2, 134217728);
        int i2 = R.h.cyt;
        red = z ? obj != null ? R.g.bFn : R.g.bFo : obj != null ? R.g.bFp : R.g.bFq;
        remoteViews.setImageViewResource(i2, red);
        remoteViews.setOnClickPendingIntent(R.h.cyt, broadcast);
        intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
        broadcast = PendingIntent.getBroadcast(context, 2, intent2, 134217728);
        remoteViews.setImageViewResource(R.h.cys, obj != null ? R.g.bFl : R.g.bFm);
        remoteViews.setOnClickPendingIntent(R.h.cys, broadcast);
        intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 3, intent2, 134217728);
        remoteViews.setImageViewResource(R.h.cyq, obj != null ? R.g.bFj : R.g.bFk);
        remoteViews.setOnClickPendingIntent(R.h.cyq, broadcast2);
        U.sx.contentView = remoteViews;
        return U.build();
    }

    private static int h(ViewGroup viewGroup) {
        List<TextView> arrayList = new ArrayList();
        a(viewGroup, arrayList);
        TextView textView = null;
        for (TextView textView2 : arrayList) {
            TextView textView22;
            if (textView22.getTextSize() <= -1.0f) {
                textView22 = textView;
            }
            textView = textView22;
        }
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return WebView.NIGHT_MODE_COLOR;
    }

    private static void a(View view, List<TextView> list) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), list);
            }
        } else if (view instanceof TextView) {
            list.add((TextView) view);
        }
    }
}
