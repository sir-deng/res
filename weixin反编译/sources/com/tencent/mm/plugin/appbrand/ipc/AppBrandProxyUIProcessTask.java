package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Constructor;

public abstract class AppBrandProxyUIProcessTask implements com.tencent.mm.ui.MMActivity.a {
    public b jeE;

    public static abstract class ProcessRequest implements Parcelable {
        public abstract Class<? extends AppBrandProxyUIProcessTask> afD();

        public ProcessRequest(Parcel parcel) {
            h(parcel);
        }

        public boolean afB() {
            return false;
        }

        public String afC() {
            return null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
        }

        public void h(Parcel parcel) {
        }
    }

    public interface b<R extends ProcessResult> {
        void c(R r);
    }

    public static abstract class ProcessResult implements Parcelable {
        public abstract void h(Parcel parcel);

        public ProcessResult(Parcel parcel) {
            h(parcel);
        }
    }

    static final class a {
        static <_Model extends AppBrandProxyUIProcessTask> _Model su(String str) {
            try {
                Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return (AppBrandProxyUIProcessTask) declaredConstructor.newInstance(new Object[0]);
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", str, bi.i(e));
                return null;
            }
        }
    }

    public abstract void a(ProcessRequest processRequest);

    public final MMActivity afu() {
        return this.jeE.afu();
    }

    public final void a(final ProcessResult processResult) {
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                if (AppBrandProxyUIProcessTask.this.jeE != null) {
                    AppBrandProxyUIProcessTask.this.jeE.a(processResult);
                }
            }
        };
        if (this.jeE != null) {
            this.jeE.runOnUiThread(anonymousClass1);
        }
    }

    public void b(int i, int i2, Intent intent) {
    }

    public void afA() {
    }
}
