package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.sdk.platformtools.x;

public class GeneralControlWrapper implements Parcelable {
    public static final Creator<GeneralControlWrapper> CREATOR = new Creator<GeneralControlWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GeneralControlWrapper(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeneralControlWrapper[i];
        }
    };
    public static final GeneralControlWrapper vHv = new GeneralControlWrapper(10);
    public static final GeneralControlWrapper vHw = new GeneralControlWrapper(1);
    public int vHx;

    /* synthetic */ GeneralControlWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    public GeneralControlWrapper(xm xmVar) {
        this.vHx = xmVar.woy;
        x.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    }

    public GeneralControlWrapper(int i) {
        this.vHx = i;
        x.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    }

    public final boolean cem() {
        boolean z = (this.vHx & 8192) != 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = " + z);
        return z;
    }

    public final boolean cen() {
        boolean z = (this.vHx & 2) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = " + z);
        return z;
    }

    public final boolean ceo() {
        boolean z = (this.vHx & 64) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = " + z);
        return z;
    }

    public final boolean cep() {
        boolean z = (this.vHx & 2048) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + z);
        return z;
    }

    public final boolean ceq() {
        boolean z = (this.vHx & 16384) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + z);
        return z;
    }

    public final boolean cer() {
        boolean z = (this.vHx & WXMediaMessage.THUMB_LENGTH_LIMIT) > 0;
        x.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = " + z);
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[bitset=0x");
        stringBuilder.append(Integer.toHexString(this.vHx));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.vHx);
    }

    private GeneralControlWrapper(Parcel parcel) {
        this.vHx = parcel.readInt();
    }
}
