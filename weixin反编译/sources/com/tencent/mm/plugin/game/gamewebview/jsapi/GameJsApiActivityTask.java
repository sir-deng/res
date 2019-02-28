package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class GameJsApiActivityTask extends GameProcessActivityTask {
    public static final Creator<GameJsApiActivityTask> CREATOR = new Creator<GameJsApiActivityTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameJsApiActivityTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameJsApiActivityTask[i];
        }
    };
    public int jgb;
    public String jiz;
    public d nbK;
    public String nbN;
    public String nbO;

    /* synthetic */ GameJsApiActivityTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void a(Context context, final a aVar) {
        x.i("MicroMsg.GameJsApiActivityTask", "runInMainProcess, apiName = %s", this.nbN);
        Map aPt = e.aPt();
        if (aPt != null) {
            c cVar = (c) aPt.get(this.nbN);
            if (!(cVar instanceof f)) {
                ((a) cVar).a(context, this.jiz, new GameJsApiMMTask.a() {
                    public final void sE(String str) {
                        GameJsApiActivityTask.this.nbO = str;
                        aVar.afx();
                    }
                });
            }
        }
    }

    public final void YB() {
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

    public GameJsApiActivityTask(Context context) {
        super(context);
    }

    private GameJsApiActivityTask(Parcel parcel) {
        f(parcel);
    }
}
