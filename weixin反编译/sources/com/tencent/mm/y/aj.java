package com.tencent.mm.y;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public interface aj extends al {
    int a(Notification notification, boolean z);

    Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i2, String str4, PendingIntent pendingIntent2, int i3, String str5, PendingIntent pendingIntent3, String str6);

    Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    void a(int i, Notification notification, boolean z);

    void aW(boolean z);

    void aX(boolean z);

    int b(Notification notification);

    void cancel(int i);

    void cancelNotification(String str);

    void eq(String str);

    void er(String str);

    void fl(int i);

    void fm(int i);

    void fn(int i);

    void n(int i, String str);

    void notify(int i, Notification notification);

    void uq();

    void v(String str, int i);

    String xe();

    void xf();

    boolean xg();

    void xh();

    void xi();
}
