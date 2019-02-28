package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.internal.ao.AnonymousClass2;
import java.util.concurrent.FutureTask;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR = new bb();
    final String bdo;
    final String ben;
    final String beo;
    final int mVersionCode;

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl$1 */
    class AnonymousClass1 extends aw<Status> {
        final /* synthetic */ Uri bep;
        final /* synthetic */ boolean beq = false;

        AnonymousClass1(c cVar, Uri uri, boolean z) {
            this.bep = uri;
            super(cVar);
        }

        public final /* synthetic */ g b(Status status) {
            return status;
        }

        protected final /* synthetic */ void b(b bVar) {
            ao aoVar = (ao) bVar;
            String a = ChannelImpl.this.ben;
            Uri uri = this.bep;
            boolean z = this.beq;
            try {
                w.ag(this);
                w.ag(a);
                w.ag(uri);
                aoVar.beV.submit(new FutureTask(new AnonymousClass2(uri, this, z, a), null));
            } catch (RuntimeException e) {
                c(new Status(8));
                throw e;
            }
        }
    }

    ChannelImpl(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.ben = (String) w.ag(str);
        this.bdo = (String) w.ag(str2);
        this.beo = (String) w.ag(str3);
    }

    public final e<Status> a(c cVar, Uri uri) {
        w.i(cVar, "client is null");
        w.i(uri, "uri is null");
        return cVar.b(new AnonymousClass1(cVar, uri, false));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) obj;
        return this.ben.equals(channelImpl.ben) && v.b(channelImpl.bdo, this.bdo) && v.b(channelImpl.beo, this.beo) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public final String getPath() {
        return this.beo;
    }

    public int hashCode() {
        return this.ben.hashCode();
    }

    public final String rp() {
        return this.bdo;
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.ben + '\'' + ", nodeId='" + this.bdo + '\'' + ", path='" + this.beo + '\'' + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        bb.a(this, parcel);
    }
}
