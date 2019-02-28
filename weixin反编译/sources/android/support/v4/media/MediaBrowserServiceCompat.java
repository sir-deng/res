package android.support.v4.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    private final android.support.v4.e.a<IBinder, b> ut = new android.support.v4.e.a();
    private final f uu = new f();
    Token uv;

    private class e implements d {
        final Messenger uK;

        e(Messenger messenger) {
            this.uK = messenger;
        }

        public final IBinder asBinder() {
            return this.uK.getBinder();
        }

        public final void a(String str, Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 1);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            a(1, bundle2);
        }

        public final void bw() {
            a(2, null);
        }

        public final void a(String str, List<MediaItem> list, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putBundle("data_options", bundle);
            if (list != null) {
                bundle2.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            a(3, bundle2);
        }

        private void a(int i, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            this.uK.send(obtain);
        }
    }

    private final class f extends Handler {
        private final g uL;

        private f() {
            this.uL = new g(MediaBrowserServiceCompat.this, (byte) 0);
        }

        /* synthetic */ f(MediaBrowserServiceCompat mediaBrowserServiceCompat, byte b) {
            this();
        }

        public final void handleMessage(Message message) {
            Bundle data = message.getData();
            g gVar;
            g gVar2;
            String string;
            switch (message.what) {
                case 1:
                    gVar = this.uL;
                    String string2 = data.getString("data_package_name");
                    int i = data.getInt("data_calling_uid");
                    Bundle bundle = data.getBundle("data_root_hints");
                    d eVar = new e(message.replyTo);
                    if (MediaBrowserServiceCompat.a(gVar.uz, string2, i)) {
                        gVar.uz.uu.c(new AnonymousClass1(eVar, string2, bundle, i));
                        return;
                    }
                    throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + string2);
                case 2:
                    gVar2 = this.uL;
                    gVar2.uz.uu.c(new AnonymousClass2(new e(message.replyTo)));
                    return;
                case 3:
                    gVar = this.uL;
                    string = data.getString("data_media_item_id");
                    data = data.getBundle("data_options");
                    gVar.uz.uu.c(new AnonymousClass3(new e(message.replyTo), string, data));
                    return;
                case 4:
                    gVar = this.uL;
                    string = data.getString("data_media_item_id");
                    data = data.getBundle("data_options");
                    gVar.uz.uu.c(new AnonymousClass4(new e(message.replyTo), string, data));
                    return;
                case 5:
                    gVar = this.uL;
                    Object string3 = data.getString("data_media_item_id");
                    ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    if (!TextUtils.isEmpty(string3) && resultReceiver != null) {
                        gVar.uz.uu.c(new AnonymousClass5(string3, resultReceiver));
                        return;
                    }
                    return;
                case 6:
                    gVar2 = this.uL;
                    gVar2.uz.uu.c(new AnonymousClass6(new e(message.replyTo)));
                    return;
                case 7:
                    gVar2 = this.uL;
                    gVar2.uz.uu.c(new AnonymousClass7(new e(message.replyTo)));
                    return;
                default:
                    new StringBuilder("Unhandled message: ").append(message).append("\n  Service version: 1\n  Client version: ").append(message.arg1);
                    return;
            }
        }

        public final boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }

        private void c(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    private class h {
    }

    public static final class a {
        final Bundle mExtras;
        final String uB;
    }

    public static class c<T> {
        Object uH;
        private boolean uI;
        boolean uJ;
        int ur;

        c(Object obj) {
            this.uH = obj;
        }

        final boolean isDone() {
            return this.uI || this.uJ;
        }

        void a(T t, int i) {
        }
    }

    private class g {

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$g$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ d uM;
            final /* synthetic */ String uN;
            final /* synthetic */ Bundle uO;
            final /* synthetic */ int uP;

            AnonymousClass1(d dVar, String str, Bundle bundle, int i) {
                this.uM = dVar;
                this.uN = str;
                this.uO = bundle;
                this.uP = i;
            }

            public final void run() {
                IBinder asBinder = this.uM.asBinder();
                MediaBrowserServiceCompat.this.ut.remove(asBinder);
                b bVar = new b(MediaBrowserServiceCompat.this, (byte) 0);
                bVar.uC = this.uN;
                bVar.uD = this.uO;
                bVar.uE = this.uM;
                bVar.uF = MediaBrowserServiceCompat.this.bv();
                if (bVar.uF == null) {
                    new StringBuilder("No root for client ").append(this.uN).append(" from service ").append(getClass().getName());
                    try {
                        this.uM.bw();
                        return;
                    } catch (RemoteException e) {
                        new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.uN);
                        return;
                    }
                }
                try {
                    MediaBrowserServiceCompat.this.ut.put(asBinder, bVar);
                    if (MediaBrowserServiceCompat.this.uv != null) {
                        this.uM.a(bVar.uF.uB, MediaBrowserServiceCompat.this.uv, bVar.uF.mExtras);
                    }
                } catch (RemoteException e2) {
                    new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.uN);
                    MediaBrowserServiceCompat.this.ut.remove(asBinder);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$g$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ d uM;

            AnonymousClass2(d dVar) {
                this.uM = dVar;
            }

            public final void run() {
                MediaBrowserServiceCompat.this.ut.remove(this.uM.asBinder());
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$g$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ d uM;
            final /* synthetic */ String uR;
            final /* synthetic */ Bundle uy;

            AnonymousClass3(d dVar, String str, Bundle bundle) {
                this.uM = dVar;
                this.uR = str;
                this.uy = bundle;
            }

            public final void run() {
                b bVar = (b) MediaBrowserServiceCompat.this.ut.get(this.uM.asBinder());
                if (bVar == null) {
                    new StringBuilder("addSubscription for callback that isn't registered id=").append(this.uR);
                } else {
                    MediaBrowserServiceCompat.a(MediaBrowserServiceCompat.this, this.uR, bVar, this.uy);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$g$5 */
        class AnonymousClass5 implements Runnable {
            final /* synthetic */ ResultReceiver uA;
            final /* synthetic */ String uS;

            AnonymousClass5(String str, ResultReceiver resultReceiver) {
                this.uS = str;
                this.uA = resultReceiver;
            }

            public final void run() {
                MediaBrowserServiceCompat.a(MediaBrowserServiceCompat.this, this.uS, this.uA);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$g$7 */
        class AnonymousClass7 implements Runnable {
            final /* synthetic */ d uM;

            AnonymousClass7(d dVar) {
                this.uM = dVar;
            }

            public final void run() {
                MediaBrowserServiceCompat.this.ut.remove(this.uM.asBinder());
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$g$4 */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ d uM;
            final /* synthetic */ String uR;
            final /* synthetic */ Bundle uy;

            AnonymousClass4(d dVar, String str, Bundle bundle) {
                this.uM = dVar;
                this.uR = str;
                this.uy = bundle;
            }

            public final void run() {
                b bVar = (b) MediaBrowserServiceCompat.this.ut.get(this.uM.asBinder());
                if (bVar == null) {
                    new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.uR);
                } else if (!MediaBrowserServiceCompat.a(this.uR, bVar, this.uy)) {
                    new StringBuilder("removeSubscription called for ").append(this.uR).append(" which is not subscribed");
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$g$6 */
        class AnonymousClass6 implements Runnable {
            final /* synthetic */ d uM;

            AnonymousClass6(d dVar) {
                this.uM = dVar;
            }

            public final void run() {
                IBinder asBinder = this.uM.asBinder();
                MediaBrowserServiceCompat.this.ut.remove(asBinder);
                b bVar = new b(MediaBrowserServiceCompat.this, (byte) 0);
                bVar.uE = this.uM;
                MediaBrowserServiceCompat.this.ut.put(asBinder, bVar);
            }
        }

        private g() {
        }

        /* synthetic */ g(MediaBrowserServiceCompat mediaBrowserServiceCompat, byte b) {
            this();
        }
    }

    private class b {
        String uC;
        Bundle uD;
        d uE;
        a uF;
        HashMap<String, List<Bundle>> uG;

        private b() {
            this.uG = new HashMap();
        }

        /* synthetic */ b(MediaBrowserServiceCompat mediaBrowserServiceCompat, byte b) {
            this();
        }
    }

    private interface d {
        void a(String str, Token token, Bundle bundle);

        void a(String str, List<MediaItem> list, Bundle bundle);

        IBinder asBinder();

        void bw();
    }

    private class i extends h {
    }

    public abstract a bv();

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, b bVar, Bundle bundle) {
        List list = (List) bVar.uG.get(str);
        List<Bundle> arrayList = list == null ? new ArrayList() : list;
        for (Bundle a : arrayList) {
            if (a.a(bundle, a)) {
                return;
            }
        }
        arrayList.add(bundle);
        bVar.uG.put(str, arrayList);
        final b bVar2 = bVar;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        c anonymousClass1 = new c<List<MediaItem>>(str) {
            final /* synthetic */ void a(Object obj, int i) {
                List list = null;
                if (MediaBrowserServiceCompat.this.ut.get(bVar2.uE.asBinder()) == bVar2) {
                    List list2;
                    if ((i & 1) != 0) {
                        Bundle bundle = bundle2;
                        int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                        int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                        if (!(i2 == -1 && i3 == -1)) {
                            int i4 = i3 * (i2 - 1);
                            int i5 = i4 + i3;
                            if (i2 <= 0 || i3 <= 0 || i4 >= list.size()) {
                                list2 = list;
                                bVar2.uE.a(str2, list2, bundle2);
                            }
                            if (i5 > list.size()) {
                                i5 = list.size();
                            }
                            list2 = list.subList(i4, i5);
                            bVar2.uE.a(str2, list2, bundle2);
                        }
                    }
                    list2 = list;
                    try {
                        bVar2.uE.a(str2, list2, bundle2);
                    } catch (RemoteException e) {
                        new StringBuilder("Calling onLoadChildren() failed for id=").append(str2).append(" package=").append(bVar2.uC);
                    }
                }
            }
        };
        if (bundle != null) {
            anonymousClass1.ur = 1;
        }
        if (!anonymousClass1.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.uC + " id=" + str);
        }
    }

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, final ResultReceiver resultReceiver) {
        c anonymousClass2 = new c<MediaItem>(str) {
            final /* synthetic */ void a(Object obj, int i) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", null);
                ResultReceiver resultReceiver = resultReceiver;
                if (resultReceiver.vD) {
                    if (resultReceiver.mHandler != null) {
                        resultReceiver.mHandler.post(new b(0, bundle));
                    } else {
                        resultReceiver.onReceiveResult(0, bundle);
                    }
                } else if (resultReceiver.vE != null) {
                    try {
                        resultReceiver.vE.send(0, bundle);
                    } catch (RemoteException e) {
                    }
                }
            }
        };
        if (anonymousClass2.uJ) {
            throw new IllegalStateException("sendResult() called twice for: " + anonymousClass2.uH);
        }
        anonymousClass2.uJ = true;
        anonymousClass2.a(null, anonymousClass2.ur);
        if (!anonymousClass2.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    static /* synthetic */ boolean a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean a(String str, b bVar, Bundle bundle) {
        List<Bundle> list = (List) bVar.uG.get(str);
        if (list == null) {
            return false;
        }
        boolean z;
        for (Bundle bundle2 : list) {
            if (a.a(bundle, bundle2)) {
                list.remove(bundle2);
                z = true;
                break;
            }
        }
        z = false;
        if (list.size() != 0) {
            return z;
        }
        bVar.uG.remove(str);
        return z;
    }
}
