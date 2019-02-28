package com.tencent.mm.plugin.webview.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class WepkgRunCgi {

    public interface a {
        void a(int i, int i2, String str, b bVar);
    }

    /* renamed from: com.tencent.mm.plugin.webview.wepkg.utils.WepkgRunCgi$1 */
    static class AnonymousClass1 implements com.tencent.mm.ad.u.a {
        final /* synthetic */ a tUA;

        public AnonymousClass1(a aVar) {
            this.tUA = aVar;
        }

        public final int a(int i, int i2, String str, b bVar, k kVar) {
            if (this.tUA != null) {
                this.tUA.a(i, i2, str, bVar);
            }
            return 0;
        }
    }

    private static final class RemoteCgiTask extends WepkgMainProcessTask implements com.tencent.mm.ad.u.a {
        public static final Creator<RemoteCgiTask> CREATOR = new Creator<RemoteCgiTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new RemoteCgiTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RemoteCgiTask[i];
            }
        };
        private String jfR;
        private int lPJ;
        private int lPV;
        public int tUB = 0;
        private b tUC;
        public b tUD;
        public a tUE;

        public final void YA() {
            u.a(this.tUD, this, true);
        }

        public final int a(int i, int i2, String str, b bVar, k kVar) {
            this.lPV = i;
            this.lPJ = i2;
            this.jfR = str;
            this.tUC = bVar;
            this.tUB = 2;
            Du();
            return 0;
        }

        public final void YB() {
            d.bl(this);
            if (this.tUE != null) {
                this.tUE.a(this.lPV, this.lPJ, this.jfR, this.tUC);
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.tUB);
            switch (this.tUB) {
                case 1:
                    WepkgRunCgi.a(this.tUD, parcel);
                    return;
                case 2:
                    parcel.writeInt(this.lPV);
                    parcel.writeInt(this.lPJ);
                    parcel.writeString(this.jfR);
                    WepkgRunCgi.a(this.tUC, parcel);
                    return;
                default:
                    return;
            }
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.tUB = parcel.readInt();
            switch (this.tUB) {
                case 1:
                    this.tUD = WepkgRunCgi.k(parcel);
                    return;
                case 2:
                    this.lPV = parcel.readInt();
                    this.lPJ = parcel.readInt();
                    this.jfR = parcel.readString();
                    this.tUC = WepkgRunCgi.k(parcel);
                    return;
                default:
                    return;
            }
        }

        RemoteCgiTask(Parcel parcel) {
            f(parcel);
        }
    }

    static /* synthetic */ void a(b bVar, Parcel parcel) {
        parcel.writeString(bVar.hnQ.hnY.getClass().getName());
        byte[] bArr = new byte[0];
        try {
            bArr = bVar.hnQ.hnY.toByteArray();
        } catch (Exception e) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.hnR.hnY.getClass().getName());
        bArr = new byte[0];
        try {
            bArr = bVar.hnR.hnY.toByteArray();
        } catch (Exception e2) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.hnS);
        parcel.writeInt(bVar.hnQ.cmdId);
        parcel.writeInt(bVar.hnR.cmdId);
    }

    static b k(Parcel parcel) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        String readString = parcel.readString();
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar.hnT = ((com.tencent.mm.bp.a) Class.forName(readString).newInstance()).aH(bArr);
        } catch (Exception e) {
        }
        String readString2 = parcel.readString();
        byte[] bArr2 = new byte[parcel.readInt()];
        parcel.readByteArray(bArr2);
        try {
            aVar.hnU = ((com.tencent.mm.bp.a) Class.forName(readString2).newInstance()).aH(bArr2);
        } catch (Exception e2) {
            if (e2 instanceof e.a.a.b) {
                try {
                    aVar.hnU = (com.tencent.mm.bp.a) Class.forName(readString2).newInstance();
                } catch (Throwable e3) {
                    x.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", bi.i(e3));
                }
            }
        }
        aVar.uri = parcel.readString();
        aVar.hnS = parcel.readInt();
        aVar.hnV = parcel.readInt();
        aVar.hnW = parcel.readInt();
        return aVar.Kf();
    }
}
