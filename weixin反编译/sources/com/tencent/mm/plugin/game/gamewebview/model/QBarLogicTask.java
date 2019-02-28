package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.a.ak;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public class QBarLogicTask extends GWMainProcessTask {
    public static final Creator<QBarLogicTask> CREATOR = new Creator<QBarLogicTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new QBarLogicTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QBarLogicTask[i];
        }
    };
    private static c gNJ = new c<mt>() {
        {
            this.xmG = mt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mt mtVar = (mt) bVar;
            x.d("MicroMsg.QBarLogicTask", "mRecogResultListener");
            if ((mtVar instanceof mt) && (QBarLogicTask.ndC == null || QBarLogicTask.ndC.containsKey(mtVar.fFy.filePath))) {
                if (QBarLogicTask.ndC != null) {
                    QBarLogicTask.ndC.remove(mtVar.fFy.filePath);
                }
                x.d("MicroMsg.QBarLogicTask", "result: " + mtVar.fFy.result);
                Bundle bundle = new Bundle();
                bundle.putInt("mm_to_client_notify_type", 2);
                bundle.putString("file_path", mtVar.fFy.filePath);
                bundle.putString("result", mtVar.fFy.result);
                bundle.putInt("code_type", mtVar.fFy.fqW);
                bundle.putInt("code_version", mtVar.fFy.fqX);
                a.z(bundle);
            }
            return false;
        }
    };
    private static Map<String, Integer> ndC;
    public String fAn;
    public int type;

    /* synthetic */ QBarLogicTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void YA() {
        String str;
        b mrVar;
        switch (this.type) {
            case 1:
                str = this.fAn;
                if (ndC == null) {
                    ndC = new HashMap();
                    com.tencent.mm.sdk.b.a.xmy.b(gNJ);
                }
                mrVar = new mr();
                mrVar.fFv.filePath = str;
                com.tencent.mm.sdk.b.a.xmy.m(mrVar);
                ndC.put(str, Integer.valueOf(1));
                return;
            case 2:
                str = this.fAn;
                if (ndC == null || !ndC.containsKey(str)) {
                    x.e("MicroMsg.QBarLogicTask", "%s is not recognizing", str);
                    return;
                }
                mrVar = new ak();
                mrVar.fpp.filePath = str;
                com.tencent.mm.sdk.b.a.xmy.m(mrVar);
                ndC.remove(str);
                return;
            default:
                return;
        }
    }

    public final void YB() {
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.fAn = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.fAn);
    }

    private QBarLogicTask(Parcel parcel) {
        f(parcel);
    }
}
