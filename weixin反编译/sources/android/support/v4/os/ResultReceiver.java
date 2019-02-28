package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new Creator<ResultReceiver>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };
    public final Handler mHandler = null;
    public final boolean vD = false;
    public a vE;

    class a extends android.support.v4.os.a.a {
        a() {
        }

        public final void send(int i, Bundle bundle) {
            if (ResultReceiver.this.mHandler != null) {
                ResultReceiver.this.mHandler.post(new b(i, bundle));
            } else {
                ResultReceiver.this.onReceiveResult(i, bundle);
            }
        }
    }

    class b implements Runnable {
        final int vG;
        final Bundle vH;

        public b(int i, Bundle bundle) {
            this.vG = i;
            this.vH = bundle;
        }

        public final void run() {
            ResultReceiver.this.onReceiveResult(this.vG, this.vH);
        }
    }

    public void onReceiveResult(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.vE == null) {
                this.vE = new a();
            }
            parcel.writeStrongBinder(this.vE.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.vE = android.support.v4.os.a.a.b(parcel.readStrongBinder());
    }
}
