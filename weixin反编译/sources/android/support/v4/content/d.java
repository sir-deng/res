package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;

public final class d {
    private static final Object mLock = new Object();
    private static d tM;
    private final Handler mHandler;
    private final Context tI;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> tJ = new HashMap();
    private final HashMap<String, ArrayList<b>> tK = new HashMap();
    private final ArrayList<a> tL = new ArrayList();

    private static class a {
        final Intent intent;
        final ArrayList<b> tO;

        a(Intent intent, ArrayList<b> arrayList) {
            this.intent = intent;
            this.tO = arrayList;
        }
    }

    private static class b {
        final IntentFilter filter;
        final BroadcastReceiver tP;
        boolean tQ;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.tP = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.tP);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.filter);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(android.support.v4.content.d r8) {
        /*
        r2 = 0;
    L_0x0001:
        r1 = r8.tJ;
        monitor-enter(r1);
        r0 = r8.tL;	 Catch:{ all -> 0x003f }
        r0 = r0.size();	 Catch:{ all -> 0x003f }
        if (r0 > 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        return;
    L_0x000e:
        r4 = new android.support.v4.content.d.a[r0];	 Catch:{ all -> 0x003f }
        r0 = r8.tL;	 Catch:{ all -> 0x003f }
        r0.toArray(r4);	 Catch:{ all -> 0x003f }
        r0 = r8.tL;	 Catch:{ all -> 0x003f }
        r0.clear();	 Catch:{ all -> 0x003f }
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        r3 = r2;
    L_0x001c:
        r0 = r4.length;
        if (r3 >= r0) goto L_0x0001;
    L_0x001f:
        r5 = r4[r3];
        r1 = r2;
    L_0x0022:
        r0 = r5.tO;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x0042;
    L_0x002a:
        r0 = r5.tO;
        r0 = r0.get(r1);
        r0 = (android.support.v4.content.d.b) r0;
        r0 = r0.tP;
        r6 = r8.tI;
        r7 = r5.intent;
        r0.onReceive(r6, r7);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0022;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        throw r0;
    L_0x0042:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.d.a(android.support.v4.content.d):void");
    }

    public static d m(Context context) {
        d dVar;
        synchronized (mLock) {
            if (tM == null) {
                tM = new d(context.getApplicationContext());
            }
            dVar = tM;
        }
        return dVar;
    }

    private d(Context context) {
        this.tI = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        d.a(d.this);
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.tJ) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.tJ.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.tJ.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < intentFilter.countActions()) {
                    String action = intentFilter.getAction(i2);
                    arrayList = (ArrayList) this.tK.get(action);
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                        this.tK.put(action, arrayList);
                    }
                    arrayList.add(bVar);
                    i = i2 + 1;
                }
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.tJ) {
            ArrayList arrayList = (ArrayList) this.tJ.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                IntentFilter intentFilter = (IntentFilter) arrayList.get(i);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    String action = intentFilter.getAction(i2);
                    ArrayList arrayList2 = (ArrayList) this.tK.get(action);
                    if (arrayList2 != null) {
                        int i3 = 0;
                        while (i3 < arrayList2.size()) {
                            int i4;
                            if (((b) arrayList2.get(i3)).tP == broadcastReceiver) {
                                arrayList2.remove(i3);
                                i4 = i3 - 1;
                            } else {
                                i4 = i3;
                            }
                            i3 = i4 + 1;
                        }
                        if (arrayList2.size() <= 0) {
                            this.tK.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Intent r16) {
        /*
        r15 = this;
        r13 = r15.tJ;
        monitor-enter(r13);
        r2 = r16.getAction();	 Catch:{ all -> 0x00c4 }
        r1 = r15.tI;	 Catch:{ all -> 0x00c4 }
        r1 = r1.getContentResolver();	 Catch:{ all -> 0x00c4 }
        r0 = r16;
        r3 = r0.resolveTypeIfNeeded(r1);	 Catch:{ all -> 0x00c4 }
        r5 = r16.getData();	 Catch:{ all -> 0x00c4 }
        r4 = r16.getScheme();	 Catch:{ all -> 0x00c4 }
        r6 = r16.getCategories();	 Catch:{ all -> 0x00c4 }
        r1 = r16.getFlags();	 Catch:{ all -> 0x00c4 }
        r1 = r1 & 8;
        if (r1 == 0) goto L_0x0097;
    L_0x0027:
        r1 = 1;
        r12 = r1;
    L_0x0029:
        if (r12 == 0) goto L_0x004e;
    L_0x002b:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r7 = "Resolving type ";
        r1.<init>(r7);	 Catch:{ all -> 0x00c4 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x00c4 }
        r7 = " scheme ";
        r1 = r1.append(r7);	 Catch:{ all -> 0x00c4 }
        r1 = r1.append(r4);	 Catch:{ all -> 0x00c4 }
        r7 = " of intent ";
        r1 = r1.append(r7);	 Catch:{ all -> 0x00c4 }
        r0 = r16;
        r1.append(r0);	 Catch:{ all -> 0x00c4 }
    L_0x004e:
        r1 = r15.tK;	 Catch:{ all -> 0x00c4 }
        r7 = r16.getAction();	 Catch:{ all -> 0x00c4 }
        r1 = r1.get(r7);	 Catch:{ all -> 0x00c4 }
        r0 = r1;
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x00c4 }
        r8 = r0;
        if (r8 == 0) goto L_0x011a;
    L_0x005e:
        if (r12 == 0) goto L_0x006b;
    L_0x0060:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r7 = "Action list: ";
        r1.<init>(r7);	 Catch:{ all -> 0x00c4 }
        r1.append(r8);	 Catch:{ all -> 0x00c4 }
    L_0x006b:
        r10 = 0;
        r1 = 0;
        r11 = r1;
    L_0x006e:
        r1 = r8.size();	 Catch:{ all -> 0x00c4 }
        if (r11 >= r1) goto L_0x00e5;
    L_0x0074:
        r1 = r8.get(r11);	 Catch:{ all -> 0x00c4 }
        r0 = r1;
        r0 = (android.support.v4.content.d.b) r0;	 Catch:{ all -> 0x00c4 }
        r9 = r0;
        if (r12 == 0) goto L_0x008b;
    L_0x007e:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r7 = "Matching against filter ";
        r1.<init>(r7);	 Catch:{ all -> 0x00c4 }
        r7 = r9.filter;	 Catch:{ all -> 0x00c4 }
        r1.append(r7);	 Catch:{ all -> 0x00c4 }
    L_0x008b:
        r1 = r9.tQ;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x009a;
    L_0x008f:
        if (r12 == 0) goto L_0x011d;
    L_0x0091:
        r1 = r10;
    L_0x0092:
        r7 = r11 + 1;
        r11 = r7;
        r10 = r1;
        goto L_0x006e;
    L_0x0097:
        r1 = 0;
        r12 = r1;
        goto L_0x0029;
    L_0x009a:
        r1 = r9.filter;	 Catch:{ all -> 0x00c4 }
        r7 = "LocalBroadcastManager";
        r1 = r1.match(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00c4 }
        if (r1 < 0) goto L_0x00c7;
    L_0x00a5:
        if (r12 == 0) goto L_0x00b6;
    L_0x00a7:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r14 = "  Filter matched!  match=0x";
        r7.<init>(r14);	 Catch:{ all -> 0x00c4 }
        r1 = java.lang.Integer.toHexString(r1);	 Catch:{ all -> 0x00c4 }
        r7.append(r1);	 Catch:{ all -> 0x00c4 }
    L_0x00b6:
        if (r10 != 0) goto L_0x0120;
    L_0x00b8:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00c4 }
        r1.<init>();	 Catch:{ all -> 0x00c4 }
    L_0x00bd:
        r1.add(r9);	 Catch:{ all -> 0x00c4 }
        r7 = 1;
        r9.tQ = r7;	 Catch:{ all -> 0x00c4 }
        goto L_0x0092;
    L_0x00c4:
        r1 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x00c4 }
        throw r1;
    L_0x00c7:
        if (r12 == 0) goto L_0x011d;
    L_0x00c9:
        switch(r1) {
            case -4: goto L_0x00d6;
            case -3: goto L_0x00d1;
            case -2: goto L_0x00db;
            case -1: goto L_0x00e0;
            default: goto L_0x00cc;
        };
    L_0x00cc:
        r1 = "unknown reason";
        r1 = r10;
        goto L_0x0092;
    L_0x00d1:
        r1 = "action";
        r1 = r10;
        goto L_0x0092;
    L_0x00d6:
        r1 = "category";
        r1 = r10;
        goto L_0x0092;
    L_0x00db:
        r1 = "data";
        r1 = r10;
        goto L_0x0092;
    L_0x00e0:
        r1 = "type";
        r1 = r10;
        goto L_0x0092;
    L_0x00e5:
        if (r10 == 0) goto L_0x011a;
    L_0x00e7:
        r1 = 0;
        r2 = r1;
    L_0x00e9:
        r1 = r10.size();	 Catch:{ all -> 0x00c4 }
        if (r2 >= r1) goto L_0x00fc;
    L_0x00ef:
        r1 = r10.get(r2);	 Catch:{ all -> 0x00c4 }
        r1 = (android.support.v4.content.d.b) r1;	 Catch:{ all -> 0x00c4 }
        r3 = 0;
        r1.tQ = r3;	 Catch:{ all -> 0x00c4 }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x00e9;
    L_0x00fc:
        r1 = r15.tL;	 Catch:{ all -> 0x00c4 }
        r2 = new android.support.v4.content.d$a;	 Catch:{ all -> 0x00c4 }
        r0 = r16;
        r2.<init>(r0, r10);	 Catch:{ all -> 0x00c4 }
        r1.add(r2);	 Catch:{ all -> 0x00c4 }
        r1 = r15.mHandler;	 Catch:{ all -> 0x00c4 }
        r2 = 1;
        r1 = r1.hasMessages(r2);	 Catch:{ all -> 0x00c4 }
        if (r1 != 0) goto L_0x0117;
    L_0x0111:
        r1 = r15.mHandler;	 Catch:{ all -> 0x00c4 }
        r2 = 1;
        r1.sendEmptyMessage(r2);	 Catch:{ all -> 0x00c4 }
    L_0x0117:
        r1 = 1;
        monitor-exit(r13);	 Catch:{ all -> 0x00c4 }
    L_0x0119:
        return r1;
    L_0x011a:
        monitor-exit(r13);	 Catch:{ all -> 0x00c4 }
        r1 = 0;
        goto L_0x0119;
    L_0x011d:
        r1 = r10;
        goto L_0x0092;
    L_0x0120:
        r1 = r10;
        goto L_0x00bd;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.d.a(android.content.Intent):boolean");
    }
}
