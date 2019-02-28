package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.bl.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GameProcessActivityTask implements Parcelable {
    private static Map<String, WeakReference<GameProcessActivityTask>> jea = new ConcurrentHashMap();
    static final Set<Object> jez = new HashSet();
    private int jeA = -1;
    private com.tencent.mm.ui.MMActivity.a jeB = new com.tencent.mm.ui.MMActivity.a() {
        public final void b(int i, int i2, Intent intent) {
            if (i == (GameProcessActivityTask.this.hashCode() & 65535) && intent != null) {
                GameProcessActivityTask gameProcessActivityTask = (GameProcessActivityTask) intent.getParcelableExtra("task_object");
                GameProcessActivityTask Ci = GameProcessActivityTask.Ci(intent.getStringExtra("task_id"));
                if (Ci == null) {
                    x.e("MicroMsg.GameProcessActivityTask", "task is null");
                    return;
                }
                GameProcessActivityTask.a(gameProcessActivityTask, Ci);
                GameProcessActivityTask.jez.remove(Ci);
                Ci.YB();
                GameProcessActivityTask.this.mContext = null;
            }
        }
    };
    private String jeC = (Process.myPid() + hashCode());
    Context mContext;

    public interface a {
        void afx();
    }

    public abstract void a(Context context, a aVar);

    static /* synthetic */ GameProcessActivityTask Ci(String str) {
        if (jea.containsKey(str)) {
            return ((WeakReference) jea.get(str)).get() == null ? null : (GameProcessActivityTask) ((WeakReference) jea.get(str)).get();
        } else {
            return null;
        }
    }

    static /* synthetic */ void a(GameProcessActivityTask gameProcessActivityTask, GameProcessActivityTask gameProcessActivityTask2) {
        Parcel obtain = Parcel.obtain();
        gameProcessActivityTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        gameProcessActivityTask2.f(obtain);
        obtain.recycle();
    }

    public GameProcessActivityTask(Context context) {
        this.mContext = context;
    }

    public void YB() {
    }

    public void f(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final void aLl() {
        if (this.mContext != null) {
            jea.put(this.jeC, new WeakReference(this));
            Intent intent = new Intent();
            intent.putExtra("task_object", this);
            intent.putExtra("task_id", this.jeC);
            intent.putExtra("orientation", this.jeA);
            if (this.mContext instanceof MMActivity) {
                jez.add(this);
                ((MMActivity) this.mContext).jCj = this.jeB;
                d.b(this.mContext, "game", ".gamewebview.ui.GameIpcProxyUI", intent, hashCode() & 65535);
                return;
            }
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            d.b(this.mContext, "game", ".gamewebview.ui.GameIpcProxyUI", intent);
        }
    }
}
