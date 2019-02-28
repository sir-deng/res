package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public class QueryDownloadInfoTask extends GWMainProcessTask {
    public static Creator<QueryDownloadInfoTask> CREATOR = new Creator<QueryDownloadInfoTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new QueryDownloadInfoTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QueryDownloadInfoTask[i];
        }
    };
    public long fnS;
    public ArrayList<FileDownloadTaskInfo> lUX;
    public ArrayList<String> ncW;
    public int type;

    /* synthetic */ QueryDownloadInfoTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void YA() {
        x.i("MicroMsg.QueryDownloadInfoTask", "QueryDownloadInfoTask");
        switch (this.type) {
            case 1:
                FileDownloadTaskInfo bZ = f.aAK().bZ(this.fnS);
                this.lUX = new ArrayList();
                this.lUX.add(bZ);
                return;
            case 2:
                if (this.ncW == null || this.ncW.size() == 0) {
                    x.i("MicroMsg.QueryDownloadInfoTask", "appIdList is null");
                    return;
                }
                f.aAK();
                this.lUX = f.n(this.ncW);
                return;
            default:
                return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeLong(this.fnS);
        parcel.writeList(this.ncW);
        parcel.writeList(this.lUX);
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.fnS = parcel.readLong();
        this.ncW = parcel.readArrayList(QueryDownloadInfoTask.class.getClassLoader());
        this.lUX = parcel.readArrayList(QueryDownloadInfoTask.class.getClassLoader());
    }

    private QueryDownloadInfoTask(Parcel parcel) {
        f(parcel);
    }
}
