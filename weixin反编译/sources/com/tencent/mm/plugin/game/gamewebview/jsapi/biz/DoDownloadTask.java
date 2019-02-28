package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.a.gq;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class DoDownloadTask extends GWMainProcessTask {
    public static Creator<DoDownloadTask> CREATOR = new Creator<DoDownloadTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DoDownloadTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DoDownloadTask[i];
        }
    };
    public String appId;
    public String extInfo;
    public long fnS;
    public boolean fqR;
    public String frM;
    public String jzA;
    public String nbW;
    public String nbX;
    public long nbY;
    public String packageName;
    public int scene;
    public int type;
    public String url;

    /* synthetic */ DoDownloadTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void YA() {
        boolean z = false;
        boolean z2 = true;
        x.i("MicroMsg.AddDownloadTask", "doDownloadTask, type = " + this.type);
        switch (this.type) {
            case 1:
                x.i("MicroMsg.AddDownloadTask", "addDownloadTask");
                b gqVar = new gq();
                gqVar.fxE.url = this.url;
                gqVar.fxE.frM = this.frM;
                gqVar.fxE.extInfo = this.extInfo;
                gqVar.fxE.appId = this.appId;
                gqVar.fxE.scene = this.scene;
                a.xmy.m(gqVar);
                g.a aVar = new g.a();
                aVar.yr(this.url);
                aVar.ys(this.nbW);
                aVar.cj(this.nbY);
                aVar.yt(this.jzA);
                aVar.yu(this.frM);
                aVar.setAppId(this.appId);
                aVar.cu(this.packageName);
                aVar.et(true);
                aVar.oP(bi.getInt(this.nbX, 1));
                aVar.lO(this.scene);
                this.fnS = f.aAK().a(aVar.lyp);
                return;
            case 2:
                x.i("MicroMsg.AddDownloadTask", "pauseDownloadTask");
                z = f.aAK().ca(this.fnS);
                break;
            case 3:
                x.i("MicroMsg.AddDownloadTask", "resumeDownloadTask");
                com.tencent.mm.plugin.downloader.e.a cf = e.cf(this.fnS);
                if (cf != null) {
                    cf.field_scene = this.scene;
                    e.c(cf);
                }
                z = f.aAK().cb(this.fnS);
                break;
            case 4:
                x.i("MicroMsg.AddDownloadTask", f.NAME);
                if (f.aAK().bY(this.fnS) <= 0) {
                    z2 = false;
                }
                this.fqR = z2;
                return;
            case 5:
                x.i("MicroMsg.AddDownloadTask", f.NAME);
                FileDownloadTaskInfo bZ = f.aAK().bZ(this.fnS);
                if (bZ.status != -1) {
                    if (bZ.status == 3) {
                        if (com.tencent.mm.a.e.bO(bZ.path)) {
                            z = q.e(ad.getContext(), Uri.fromFile(new File(bZ.path)));
                            break;
                        }
                    }
                    x.e("MicroMsg.AddDownloadTask", "installDownloadTask fail, invalid status = " + bZ.status);
                    break;
                }
                x.e("MicroMsg.AddDownloadTask", "installDownloadTask fail, apilevel not supported");
                break;
                break;
            default:
                return;
        }
        this.fqR = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.jzA);
        parcel.writeString(this.url);
        parcel.writeString(this.nbW);
        parcel.writeString(this.frM);
        parcel.writeString(this.extInfo);
        parcel.writeString(this.nbX);
        parcel.writeString(this.appId);
        parcel.writeString(this.packageName);
        parcel.writeLong(this.nbY);
        parcel.writeInt(this.scene);
        parcel.writeLong(this.fnS);
        parcel.writeByte((byte) (this.fqR ? 1 : 0));
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.type = parcel.readInt();
        this.jzA = parcel.readString();
        this.url = parcel.readString();
        this.nbW = parcel.readString();
        this.frM = parcel.readString();
        this.extInfo = parcel.readString();
        this.nbX = parcel.readString();
        this.appId = parcel.readString();
        this.packageName = parcel.readString();
        this.nbY = parcel.readLong();
        this.scene = parcel.readInt();
        this.fnS = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.fqR = z;
    }

    private DoDownloadTask(Parcel parcel) {
        f(parcel);
    }
}
