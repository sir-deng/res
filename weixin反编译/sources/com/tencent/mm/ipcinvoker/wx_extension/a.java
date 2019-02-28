package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.mm.ad.b;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.ipcinvoker.extension.a {
    public final boolean au(Object obj) {
        return obj instanceof b;
    }

    public final void a(Object obj, Parcel parcel) {
        b bVar = (b) obj;
        c.a(bVar.hnQ.hnY, parcel);
        if (ad.cgj()) {
            c.a(bVar.hnR.hnY, parcel);
        } else {
            parcel.writeString(bVar.hnR.hnY.getClass().getName());
        }
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.hnS);
        parcel.writeInt(bVar.hnQ.cmdId);
        parcel.writeInt(bVar.hnR.cmdId);
    }

    public final Object d(Parcel parcel) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = (com.tencent.mm.bp.a) c.a(c.class.getName(), parcel);
        if (ad.cgj()) {
            try {
                aVar.hnU = (com.tencent.mm.bp.a) Class.forName(parcel.readString()).newInstance();
            } catch (Exception e) {
                x.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", e);
                aVar.hnU = new com.tencent.mm.bp.a();
            }
        } else {
            com.tencent.mm.bp.a aVar2 = (com.tencent.mm.bp.a) c.a(c.class.getName(), parcel);
            if (aVar2 == null) {
                aVar2 = new com.tencent.mm.bp.a();
            }
            aVar.hnU = aVar2;
        }
        aVar.uri = parcel.readString();
        aVar.hnS = parcel.readInt();
        aVar.hnV = parcel.readInt();
        aVar.hnW = parcel.readInt();
        return aVar.Kf();
    }
}
