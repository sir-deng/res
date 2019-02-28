package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.ag;
import android.support.v4.app.z;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public class NotificationItem implements Parcelable {
    public static final Creator<NotificationItem> CREATOR = new Creator<NotificationItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NotificationItem(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NotificationItem[i];
        }
    };
    private final String TAG;
    private Bitmap b;
    PendingIntent gBI;
    public String gBJ;
    public long gBK;
    public int gBL;
    public boolean gBM;
    public int gBN;
    public int gBO;
    public int id;
    Notification sx;

    /* synthetic */ NotificationItem(Parcel parcel, byte b) {
        this(parcel);
    }

    public NotificationItem(int i, String str, Notification notification) {
        this(i, str, notification, true);
    }

    public NotificationItem(int i, Notification notification, boolean z) {
        this(i, null, notification, z);
    }

    public NotificationItem(Notification notification, boolean z) {
        this(-1, notification, z);
    }

    @TargetApi(11)
    private NotificationItem(int i, String str, Notification notification, boolean z) {
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.gBK = 0;
        this.gBL = 0;
        this.gBM = true;
        this.gBN = 0;
        this.gBO = 0;
        this.id = i;
        this.gBJ = str;
        if (VERSION.SDK_INT >= 11) {
            this.b = notification.largeIcon;
        }
        this.sx = notification;
        this.gBM = z;
        this.gBN = 0;
    }

    public final synchronized void clear() {
        if (!(this.b == null || this.b.isRecycled())) {
            x.i("MicroMsg.NotificationItem", "recycle bitmap:%s", this.b.toString());
            this.b.recycle();
        }
        this.sx = null;
        this.b = null;
        this.gBI = null;
    }

    public final synchronized int a(g gVar) {
        int i;
        NotificationItem notificationItem = null;
        synchronized (this) {
            this.id = this.id == -1 ? b.xp().aZ(this.gBM) : this.id;
            Context context = ad.getContext();
            if (context == null) {
                x.e("MicroMsg.NotificationItem", "error, show notification but MMApplicationContext.getContext() == null");
                i = -1;
            } else if (this.sx == null) {
                x.e("MicroMsg.NotificationItem", "error, show notification but mNotification == null");
                i = -1;
            } else {
                NotificationItem notificationItem2;
                b xp = b.xp();
                String str = this.gBJ;
                if (t.oN(str)) {
                    notificationItem2 = null;
                } else {
                    Iterator it = xp.iterator();
                    while (it.hasNext()) {
                        notificationItem2 = (NotificationItem) it.next();
                        if (notificationItem2 != null && notificationItem2.gBJ != null && notificationItem2.gBJ.equals(str)) {
                            break;
                        }
                    }
                    notificationItem2 = null;
                }
                if (notificationItem2 != null) {
                    b xp2 = b.xp();
                    x.d("MicroMsg.Notification.Queue", "mark: %d", Integer.valueOf(notificationItem2.id));
                    xp2.mark = r7;
                }
                if (!(notificationItem2 == null || notificationItem2.sx.tickerText == null || this.sx.tickerText == null || !notificationItem2.sx.tickerText.equals(this.sx.tickerText))) {
                    this.sx.tickerText += " ";
                }
                xp = b.xp();
                if (this == null) {
                    x.e("MicroMsg.Notification.Queue", "notification item null when put");
                } else if (this.id == -1) {
                    x.e("MicroMsg.Notification.Queue", "notification id = -1(NotificationItem.INVALID_ID) when put");
                } else {
                    if (xp.mark > 0) {
                        if (xp.mark == this.id) {
                            x.d("MicroMsg.Notification.Queue", "remove mark: %d", Integer.valueOf(xp.mark));
                            xp.remove(xp.mark);
                        }
                        xp.mark = -1;
                    }
                    xp.remove(this.id);
                    if (xp.size() >= 5) {
                        notificationItem = xp.xq();
                    }
                    xp.gBV.d(this);
                    xp.gBW.b(this);
                    x.i("MicroMsg.Notification.Queue", "put item: %d, queuesize: %d", Integer.valueOf(this.id), Integer.valueOf(xp.size()));
                }
                if (notificationItem != null) {
                    b.xp().cancel(notificationItem.id);
                }
                this.gBO = d.a(this.sx, gVar);
                if (context != null) {
                    if (this.sx == null) {
                        x.e("MicroMsg.NotificationItem", "error, notify but mNotification == null");
                    } else {
                        Context context2 = ad.getContext();
                        if (context2 == null) {
                            x.e("MicroMsg.NotificationItem", "error, safeCheck but MMApplicationContext.getContext() == null");
                        } else if (this.sx == null) {
                            x.e("MicroMsg.NotificationItem", "error, safeCheck but mNotification == null");
                        } else {
                            if (context2.getResources().getDrawable(this.sx.icon) == null) {
                                this.sx.icon = R.g.icon;
                            }
                        }
                        x.i("MicroMsg.NotificationItem", "notificaiton.defaults: %d, notification.sound: %s, notification.vibrate: %s", Integer.valueOf(this.sx.defaults), this.sx.sound, g.a(this.sx.vibrate));
                        try {
                            if (e.xy() == 1 && this.sx.defaults != 2 && this.sx.vibrate == null) {
                                this.sx.defaults = 0;
                                this.sx.sound = null;
                                x.i("MicroMsg.NotificationItem", "mode == vibrate & wechat shake is close, so notification switch to silent");
                            }
                            ag j = ag.j(ad.getContext());
                            int i2 = this.id;
                            Notification notification = this.sx;
                            Bundle a = z.a(notification);
                            Object obj = (a == null || !a.getBoolean("android.support.useSideChannel")) ? null : 1;
                            if (obj != null) {
                                j.a(new f(j.mContext.getPackageName(), i2, null, notification));
                                ag.ta.a(j.sX, null, i2);
                            } else {
                                ag.ta.a(j.sX, null, i2, notification);
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NotificationItem", e, "Notification Exception?", new Object[0]);
                        }
                        if (this.gBK != 0) {
                            c.aA(this.gBK);
                        }
                    }
                }
                i = this.id;
            }
        }
        return i;
    }

    private NotificationItem(Parcel parcel) {
        this.TAG = "MicroMsg.NotificationItem";
        this.id = -1;
        this.gBK = 0;
        this.gBL = 0;
        this.gBM = true;
        this.gBN = 0;
        this.gBO = 0;
        if (parcel != null) {
            boolean z;
            this.id = parcel.readInt();
            this.gBJ = parcel.readString();
            this.b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
            this.sx = (Notification) parcel.readParcelable(Notification.class.getClassLoader());
            this.gBI = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.gBM = z;
            this.gBK = parcel.readLong();
            this.gBL = parcel.readInt();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeInt(this.id);
        parcel.writeString(this.gBJ == null ? "" : this.gBJ);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.sx, 0);
        parcel.writeParcelable(this.gBI, 0);
        if (this.gBM) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.gBK);
        parcel.writeInt(this.gBL);
    }

    public String toString() {
        return "id: " + this.id + ",msgId: " + this.gBK + ",userName: " + this.gBJ + ",unreadCount: " + this.gBL;
    }
}
