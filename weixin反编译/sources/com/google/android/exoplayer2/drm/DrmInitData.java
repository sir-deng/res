package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Creator<DrmInitData> CREATOR = new Creator<DrmInitData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DrmInitData[i];
        }
    };
    private int aen;
    public final SchemeData[] ais;
    public final int ait;

    public static final class SchemeData implements Parcelable {
        public static final Creator<SchemeData> CREATOR = new Creator<SchemeData>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SchemeData[i];
            }
        };
        private int aen;
        public final boolean aiu;
        public final byte[] data;
        public final String mimeType;
        public final String type;
        final UUID uuid;

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr, boolean z) {
            this.uuid = (UUID) a.Y(uuid);
            this.type = str;
            this.mimeType = (String) a.Y(str2);
            this.data = (byte[]) a.Y(bArr);
            this.aiu = z;
        }

        SchemeData(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.type = parcel.readString();
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.aiu = parcel.readByte() != (byte) 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (this.mimeType.equals(schemeData.mimeType) && t.h(this.uuid, schemeData.uuid) && t.h(this.type, schemeData.type) && Arrays.equals(this.data, schemeData.data)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            if (this.aen == 0) {
                this.aen = (((((this.type == null ? 0 : this.type.hashCode()) + (this.uuid.hashCode() * 31)) * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.aen;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.type);
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte((byte) (this.aiu ? 1 : 0));
        }
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        SchemeData schemeData = (SchemeData) obj;
        SchemeData schemeData2 = (SchemeData) obj2;
        if (b.acn.equals(schemeData.uuid)) {
            return b.acn.equals(schemeData2.uuid) ? 0 : 1;
        } else {
            return schemeData.uuid.compareTo(schemeData2.uuid);
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    private DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        SchemeData[] schemeDataArr2;
        if (z) {
            schemeDataArr2 = (SchemeData[]) schemeDataArr.clone();
        } else {
            schemeDataArr2 = schemeDataArr;
        }
        Arrays.sort(schemeDataArr2, this);
        for (int i = 1; i < schemeDataArr2.length; i++) {
            if (schemeDataArr2[i - 1].uuid.equals(schemeDataArr2[i].uuid)) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + schemeDataArr2[i].uuid);
            }
        }
        this.ais = schemeDataArr2;
        this.ait = schemeDataArr2.length;
    }

    DrmInitData(Parcel parcel) {
        this.ais = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.ait = this.ais.length;
    }

    public final DrmInitData O(String str) {
        int i;
        int i2 = 0;
        for (SchemeData schemeData : this.ais) {
            if (!t.h(schemeData.type, str)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            return this;
        }
        SchemeData[] schemeDataArr = new SchemeData[this.ais.length];
        while (true) {
            int i3 = i2;
            if (i3 >= schemeDataArr.length) {
                return new DrmInitData(schemeDataArr);
            }
            SchemeData schemeData2;
            SchemeData schemeData3 = this.ais[i3];
            if (t.h(schemeData3.type, str)) {
                schemeData2 = schemeData3;
            } else {
                schemeData2 = new SchemeData(schemeData3.uuid, str, schemeData3.mimeType, schemeData3.data, schemeData3.aiu);
            }
            schemeDataArr[i3] = schemeData2;
            i2 = i3 + 1;
        }
    }

    public final int hashCode() {
        if (this.aen == 0) {
            this.aen = Arrays.hashCode(this.ais);
        }
        return this.aen;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.ais, ((DrmInitData) obj).ais);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.ais, 0);
    }
}
