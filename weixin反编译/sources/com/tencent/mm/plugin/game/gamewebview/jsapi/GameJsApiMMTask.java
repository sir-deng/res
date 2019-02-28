package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

public class GameJsApiMMTask extends GWMainProcessTask {
    public static final Creator<GameJsApiMMTask> CREATOR = new Creator<GameJsApiMMTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameJsApiMMTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameJsApiMMTask[i];
        }
    };
    public int jgb;
    public String jiz;
    public d nbK;
    public String nbN;
    public String nbO;

    public interface a {
        void sE(String str);
    }

    /* synthetic */ GameJsApiMMTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void YA() {
        Map aPt = e.aPt();
        if (aPt != null) {
            c cVar = (c) aPt.get(this.nbN);
            if (!(cVar instanceof f)) {
                ((a) cVar).a(ad.getContext(), this.jiz, new a() {
                    public final void sE(String str) {
                        GameJsApiMMTask.this.nbO = str;
                        GameJsApiMMTask.this.afF();
                    }
                });
            }
        }
    }

    public final void YB() {
        afz();
        if (this.nbK != null) {
            this.nbK.E(this.jgb, this.nbO);
        }
    }

    public final void f(Parcel parcel) {
        this.jiz = parcel.readString();
        this.nbN = parcel.readString();
        this.nbO = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jiz);
        parcel.writeString(this.nbN);
        parcel.writeString(this.nbO);
    }

    private GameJsApiMMTask(Parcel parcel) {
        f(parcel);
    }
}
