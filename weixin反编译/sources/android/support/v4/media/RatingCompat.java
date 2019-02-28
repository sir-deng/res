package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new Creator<RatingCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat(), (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    private final int vg;
    private final float vh;

    /* synthetic */ RatingCompat(int i, float f, byte b) {
        this(i, f);
    }

    private RatingCompat(int i, float f) {
        this.vg = i;
        this.vh = f;
    }

    public final String toString() {
        return "Rating:style=" + this.vg + " rating=" + (this.vh < 0.0f ? "unrated" : String.valueOf(this.vh));
    }

    public final int describeContents() {
        return this.vg;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.vg);
        parcel.writeFloat(this.vh);
    }
}
