package com.tencent.mm.booter.notification.queue;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.j.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class NotificationQueue {
    public ParcelNotificationQueue gBU;

    public static class ParcelNotificationQueue extends LinkedList<NotificationItem> implements Parcelable {
        public static final Creator<ParcelNotificationQueue> CREATOR = new Creator<ParcelNotificationQueue>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                ParcelNotificationQueue parcelNotificationQueue = new ParcelNotificationQueue();
                int readInt = parcel.readInt();
                for (int i = 0; i < readInt; i++) {
                    parcelNotificationQueue.add((NotificationItem) parcel.readParcelable(NotificationItem.class.getClassLoader()));
                }
                return parcelNotificationQueue;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ParcelNotificationQueue[i];
            }
        };

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                parcel.writeParcelable((NotificationItem) it.next(), 0);
            }
        }
    }

    private void save() {
        if (this.gBU != null) {
            x.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", Integer.valueOf(this.gBU.size()));
            if (this.gBU.isEmpty()) {
                a.zt().edit().putString("com.tencent.preference.notification.queue", "").apply();
                if (this.gBU == null) {
                    restore();
                }
                x.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", Integer.valueOf(this.gBU.size()));
            }
        }
    }

    public final synchronized void restore() {
        x.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
        if (this.gBU == null) {
            this.gBU = new ParcelNotificationQueue();
        }
        x.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", Integer.valueOf(this.gBU.size()));
    }

    public final synchronized boolean c(NotificationItem notificationItem) {
        boolean remove;
        if (this.gBU == null) {
            restore();
        }
        remove = this.gBU.remove(notificationItem);
        if (remove) {
            save();
        }
        return remove;
    }

    public final synchronized NotificationItem fr(int i) {
        NotificationItem notificationItem;
        if (this.gBU == null) {
            restore();
        }
        Iterator it = this.gBU.iterator();
        while (it.hasNext()) {
            notificationItem = (NotificationItem) it.next();
            if (notificationItem.id == i) {
                break;
            }
        }
        notificationItem = null;
        if (notificationItem != null && this.gBU.remove(notificationItem)) {
            save();
        }
        return notificationItem;
    }

    public final synchronized boolean d(NotificationItem notificationItem) {
        boolean add;
        if (this.gBU == null) {
            restore();
        }
        add = this.gBU.add(notificationItem);
        if (add) {
            save();
        }
        return add;
    }
}
