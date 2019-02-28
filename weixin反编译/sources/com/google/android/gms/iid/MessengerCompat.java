package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR = new Creator<MessengerCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return new MessengerCompat[i];
        }
    };
    Messenger aRg;
    c aRh;

    private final class a extends com.google.android.gms.iid.c.a {
        Handler handler;

        a(Handler handler) {
            this.handler = handler;
        }

        public final void send(Message message) {
            message.arg2 = Binder.getCallingUid();
            this.handler.dispatchMessage(message);
        }
    }

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.aRg = new Messenger(handler);
        } else {
            this.aRh = new a(handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.aRg = new Messenger(iBinder);
        } else {
            this.aRh = com.google.android.gms.iid.c.a.l(iBinder);
        }
    }

    public static int g(Message message) {
        return VERSION.SDK_INT >= 21 ? message.sendingUid : message.arg2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return z;
        }
        try {
            return getBinder().equals(((MessengerCompat) obj).getBinder());
        } catch (ClassCastException e) {
            return z;
        }
    }

    public final IBinder getBinder() {
        return this.aRg != null ? this.aRg.getBinder() : this.aRh.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.aRg != null) {
            parcel.writeStrongBinder(this.aRg.getBinder());
        } else {
            parcel.writeStrongBinder(this.aRh.asBinder());
        }
    }
}
