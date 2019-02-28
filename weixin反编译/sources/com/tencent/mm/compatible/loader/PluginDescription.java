package com.tencent.mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.m;
import java.io.Serializable;

public class PluginDescription implements Parcelable, Serializable {
    public static final Creator<PluginDescription> CREATOR = new Creator<PluginDescription>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PluginDescription(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PluginDescription[i];
        }
    };
    public final String frM;
    public final int gIB;
    public final String name;
    public final int size;
    public final String url;
    public final String version;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.frM);
        parcel.writeString(this.version);
        parcel.writeInt(this.size);
        parcel.writeInt(this.gIB);
    }

    protected PluginDescription(Parcel parcel) {
        this.name = (String) m.Y(parcel.readString());
        this.url = (String) m.Y(parcel.readString());
        this.frM = (String) m.Y(parcel.readString());
        this.version = (String) m.Y(parcel.readString());
        this.size = parcel.readInt();
        this.gIB = parcel.readInt();
    }

    public String toString() {
        return String.format("PluginDescription = [name=%s, url=%s, md5=%s, version=%s, size=%d, downloadType=%d]", new Object[]{this.name, this.url, this.frM, this.version, Integer.valueOf(this.size), Integer.valueOf(this.gIB)});
    }
}
