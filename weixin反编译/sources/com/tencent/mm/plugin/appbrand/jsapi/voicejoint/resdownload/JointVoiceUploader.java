package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class JointVoiceUploader {
    private static String jrW = null;
    private static com.tencent.mm.plugin.appbrand.c.b jzF = null;
    private static c jzG = null;
    private static ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> jzH = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> jzI = new ConcurrentHashMap();

    private static class JointVoiceCancelTask extends MainProcessTask {
        public static final Creator<JointVoiceCancelTask> CREATOR = new Creator<JointVoiceCancelTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new JointVoiceCancelTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new JointVoiceCancelTask[0];
            }
        };
        private String appId;

        public final void YA() {
            JointVoiceUploader.tr(this.appId);
            afF();
        }

        public final void YB() {
            com.tencent.mm.plugin.appbrand.r.c.bl(this);
        }

        public JointVoiceCancelTask(Parcel parcel) {
            f(parcel);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.appId = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.appId);
        }
    }

    private static class a extends com.tencent.mm.plugin.appbrand.c.b {
        public final void onCreate() {
            super.onCreate();
        }

        public final void onDestroy() {
            super.onDestroy();
            x.i("MicroMsg.JointVoiceUploader", "alvinluo JointVoiceUploader appbrand lifeCycle onDestroy, and cancelAllTAsk, processName: %s", bi.r(ad.getContext(), Process.myPid()));
            MainProcessTask jointVoiceCancelTask = new JointVoiceCancelTask();
            jointVoiceCancelTask.appId = JointVoiceUploader.jrW;
            com.tencent.mm.plugin.appbrand.r.c.bk(jointVoiceCancelTask);
            AppBrandMainProcessService.a(jointVoiceCancelTask);
            if (JointVoiceUploader.jrW != null && JointVoiceUploader.jzF != null) {
                x.i("MicroMsg.JointVoiceUploader", "alvinluo jointVoice remove AppBrandLifeCycleListener");
                com.tencent.mm.plugin.appbrand.c.b(JointVoiceUploader.jrW, JointVoiceUploader.jzF);
                JointVoiceUploader.jzF = null;
            }
        }
    }

    public interface c {
        void a(String str, String str2, b bVar);

        void a(String str, String str2, String str3, String str4, b bVar);
    }

    public interface b {
        void L(int i, String str);

        void a(b bVar);

        void bK(int i, int i2);
    }

    static /* synthetic */ void access$000(String str, String str2) {
        if (jzH != null) {
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) jzH.get(str);
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.remove(str2);
            }
        }
    }

    static /* synthetic */ void bv(String str, String str2) {
        if (jzI != null) {
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) jzI.get(str);
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.remove(str2);
            }
        }
    }

    static /* synthetic */ void tr(String str) {
        int i = 0;
        if (!bi.oN(str)) {
            int i2;
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) jzH.get(str);
            ConcurrentLinkedQueue concurrentLinkedQueue2 = (ConcurrentLinkedQueue) jzI.get(str);
            String str2 = "MicroMsg.JointVoiceUploader";
            String str3 = "alvinluo joint voice uploader cancel all task, upload: %d, download: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(concurrentLinkedQueue != null ? concurrentLinkedQueue.size() : 0);
            if (concurrentLinkedQueue2 != null) {
                i = concurrentLinkedQueue2.size();
            }
            objArr[1] = Integer.valueOf(i);
            x.i(str2, str3, objArr);
            if (concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0) {
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    g.MP().kK((String) it.next());
                    i2 = f.jzB;
                    f.kS(8023);
                }
            }
            if (concurrentLinkedQueue2 != null && concurrentLinkedQueue2.size() > 0) {
                Iterator it2 = concurrentLinkedQueue2.iterator();
                while (it2.hasNext()) {
                    g.MP().kK((String) it2.next());
                    i2 = f.jzB;
                    f.kS(8024);
                }
            }
        }
    }

    public static void a(final String str, String str2, final b bVar) {
        x.i("MicroMsg.JointVoiceUploader", "alvinluo uploadVoice fileName: %s", str2);
        if (jzG == null) {
            jzG = new c();
        }
        final String tu = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.tu(str2);
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) jzH.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            jzH.put(str, concurrentLinkedQueue);
        }
        concurrentLinkedQueue.add(tu);
        b anonymousClass1 = new b() {
            public final void a(b bVar) {
                JointVoiceUploader.access$000(str, tu);
                if (bVar != null) {
                    bVar.a(bVar);
                }
            }

            public final void L(int i, String str) {
                JointVoiceUploader.access$000(str, tu);
                if (bVar != null) {
                    bVar.L(i, str);
                }
            }

            public final void bK(int i, int i2) {
                if (bVar != null) {
                    bVar.bK(i, i2);
                }
            }
        };
        tq(str);
        jzG.a(tu, str2, anonymousClass1);
    }

    public static void a(final String str, String str2, String str3, String str4, final b bVar) {
        x.i("MicroMsg.JointVoiceUploader", "alvinluo downloadVoice fileName: %s, fileId: %s", str2, str3);
        if (jzG == null) {
            jzG = new c();
        }
        final String tu = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.tu(str2);
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) jzI.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            jzI.put(str, concurrentLinkedQueue);
        }
        concurrentLinkedQueue.add(tu);
        b anonymousClass2 = new b() {
            public final void a(b bVar) {
                JointVoiceUploader.bv(str, tu);
                if (bVar != null) {
                    bVar.a(bVar);
                }
            }

            public final void L(int i, String str) {
                JointVoiceUploader.bv(str, tu);
                if (bVar != null) {
                    bVar.L(i, str);
                }
            }

            public final void bK(int i, int i2) {
                if (bVar != null) {
                    bVar.bK(i, i2);
                }
            }
        };
        tq(str);
        jzG.a(tu, str2, str3, str4, anonymousClass2);
    }

    private static void tq(String str) {
        if (!(jrW == null || jrW.equals(str))) {
            com.tencent.mm.plugin.appbrand.c.b(jrW, jzF);
        }
        if (jzF == null) {
            jzF = new a();
        }
        jrW = str;
        com.tencent.mm.plugin.appbrand.c.a(str, jzF);
    }
}
