package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import java.util.LinkedList;

public class V8Executor extends Thread {
    private Exception exception;
    private volatile boolean forceTerminating;
    private boolean longRunning;
    private String messageHandler;
    private LinkedList<String[]> messageQueue;
    private String result;
    private V8 runtime;
    private final String script;
    private volatile boolean shuttingDown;
    private volatile boolean terminated;

    class ExecutorTermination implements JavaVoidCallback {
        ExecutorTermination() {
        }

        public void invoke(V8Object v8Object, V8Array v8Array) {
            if (V8Executor.this.forceTerminating) {
                throw new RuntimeException("V8Thread Termination");
            }
        }
    }

    public V8Executor(String str, boolean z, String str2) {
        this.terminated = false;
        this.shuttingDown = false;
        this.forceTerminating = false;
        this.exception = null;
        this.messageQueue = new LinkedList();
        this.script = str;
        this.longRunning = z;
        this.messageHandler = str2;
    }

    public V8Executor(String str) {
        this(str, false, null);
    }

    protected void setup(V8 v8) {
    }

    public String getResult() {
        return this.result;
    }

    public void postMessage(String... strArr) {
        synchronized (this) {
            this.messageQueue.add(strArr);
            notify();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r8 = this;
        r3 = 0;
        monitor-enter(r8);
        r1 = com.eclipsesource.v8.V8.createV8Runtime();	 Catch:{ all -> 0x009b }
        r8.runtime = r1;	 Catch:{ all -> 0x009b }
        r1 = r8.runtime;	 Catch:{ all -> 0x009b }
        r2 = new com.eclipsesource.v8.utils.V8Executor$ExecutorTermination;	 Catch:{ all -> 0x009b }
        r2.<init>();	 Catch:{ all -> 0x009b }
        r4 = "__j2v8__checkThreadTerminate";
        r1.registerJavaMethod(r2, r4);	 Catch:{ all -> 0x009b }
        r1 = r8.runtime;	 Catch:{ all -> 0x009b }
        r8.setup(r1);	 Catch:{ all -> 0x009b }
        monitor-exit(r8);	 Catch:{ all -> 0x009b }
        r1 = r8.forceTerminating;	 Catch:{ Exception -> 0x00d0 }
        if (r1 != 0) goto L_0x0058;
    L_0x001f:
        r1 = r8.runtime;	 Catch:{ Exception -> 0x00d0 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d0 }
        r4 = "__j2v8__checkThreadTerminate();\n";
        r2.<init>(r4);	 Catch:{ Exception -> 0x00d0 }
        r4 = r8.script;	 Catch:{ Exception -> 0x00d0 }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x00d0 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00d0 }
        r4 = r8.getName();	 Catch:{ Exception -> 0x00d0 }
        r5 = -1;
        r2 = r1.executeScript(r2, r4, r5);	 Catch:{ Exception -> 0x00d0 }
        if (r2 == 0) goto L_0x0044;
    L_0x003e:
        r1 = r2.toString();	 Catch:{ Exception -> 0x00d0 }
        r8.result = r1;	 Catch:{ Exception -> 0x00d0 }
    L_0x0044:
        r1 = r2 instanceof com.eclipsesource.v8.Releasable;	 Catch:{ Exception -> 0x00d0 }
        if (r1 == 0) goto L_0x004f;
    L_0x0048:
        r0 = r2;
        r0 = (com.eclipsesource.v8.Releasable) r0;	 Catch:{ Exception -> 0x00d0 }
        r1 = r0;
        r1.release();	 Catch:{ Exception -> 0x00d0 }
    L_0x004f:
        r1 = r2 instanceof com.eclipsesource.v8.Releasable;	 Catch:{ Exception -> 0x00d0 }
        if (r1 == 0) goto L_0x0058;
    L_0x0053:
        r2 = (com.eclipsesource.v8.Releasable) r2;	 Catch:{ Exception -> 0x00d0 }
        r2.release();	 Catch:{ Exception -> 0x00d0 }
    L_0x0058:
        r1 = r8.forceTerminating;	 Catch:{ Exception -> 0x00d0 }
        if (r1 != 0) goto L_0x0125;
    L_0x005c:
        r1 = r8.longRunning;	 Catch:{ Exception -> 0x00d0 }
        if (r1 == 0) goto L_0x0125;
    L_0x0060:
        monitor-enter(r8);	 Catch:{ Exception -> 0x00d0 }
        r1 = r8.messageQueue;	 Catch:{ all -> 0x00cd }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00cd }
        if (r1 == 0) goto L_0x0070;
    L_0x0069:
        r1 = r8.shuttingDown;	 Catch:{ all -> 0x00cd }
        if (r1 != 0) goto L_0x0070;
    L_0x006d:
        r8.wait();	 Catch:{ all -> 0x00cd }
    L_0x0070:
        r1 = r8.messageQueue;	 Catch:{ all -> 0x00cd }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00cd }
        if (r1 == 0) goto L_0x007c;
    L_0x0078:
        r1 = r8.shuttingDown;	 Catch:{ all -> 0x00cd }
        if (r1 != 0) goto L_0x0080;
    L_0x007c:
        r1 = r8.forceTerminating;	 Catch:{ all -> 0x00cd }
        if (r1 == 0) goto L_0x00a1;
    L_0x0080:
        monitor-exit(r8);	 Catch:{ all -> 0x00cd }
        monitor-enter(r8);
        r1 = r8.runtime;	 Catch:{ all -> 0x009e }
        r1 = r1.getLocker();	 Catch:{ all -> 0x009e }
        r1 = r1.hasLock();	 Catch:{ all -> 0x009e }
        if (r1 == 0) goto L_0x0096;
    L_0x008e:
        r1 = r8.runtime;	 Catch:{ all -> 0x009e }
        r1.release();	 Catch:{ all -> 0x009e }
        r1 = 0;
        r8.runtime = r1;	 Catch:{ all -> 0x009e }
    L_0x0096:
        r1 = 1;
        r8.terminated = r1;	 Catch:{ all -> 0x009e }
        monitor-exit(r8);	 Catch:{ all -> 0x009e }
    L_0x009a:
        return;
    L_0x009b:
        r1 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x009b }
        throw r1;
    L_0x009e:
        r1 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x009e }
        throw r1;
    L_0x00a1:
        monitor-exit(r8);	 Catch:{ all -> 0x00cd }
        r1 = r8.messageQueue;	 Catch:{ Exception -> 0x00d0 }
        r1 = r1.isEmpty();	 Catch:{ Exception -> 0x00d0 }
        if (r1 != 0) goto L_0x0058;
    L_0x00aa:
        r1 = r8.messageQueue;	 Catch:{ Exception -> 0x00d0 }
        r2 = 0;
        r1 = r1.remove(r2);	 Catch:{ Exception -> 0x00d0 }
        r1 = (java.lang.String[]) r1;	 Catch:{ Exception -> 0x00d0 }
        r4 = new com.eclipsesource.v8.V8Array;	 Catch:{ Exception -> 0x00d0 }
        r2 = r8.runtime;	 Catch:{ Exception -> 0x00d0 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x00d0 }
        r5 = new com.eclipsesource.v8.V8Array;	 Catch:{ Exception -> 0x00d0 }
        r2 = r8.runtime;	 Catch:{ Exception -> 0x00d0 }
        r5.<init>(r2);	 Catch:{ Exception -> 0x00d0 }
        r6 = r1.length;	 Catch:{ all -> 0x011d }
        r2 = r3;
    L_0x00c3:
        if (r2 >= r6) goto L_0x00f0;
    L_0x00c5:
        r7 = r1[r2];	 Catch:{ all -> 0x011d }
        r5.push(r7);	 Catch:{ all -> 0x011d }
        r2 = r2 + 1;
        goto L_0x00c3;
    L_0x00cd:
        r1 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00cd }
        throw r1;	 Catch:{ Exception -> 0x00d0 }
    L_0x00d0:
        r1 = move-exception;
        r8.exception = r1;	 Catch:{ all -> 0x0102 }
        monitor-enter(r8);
        r1 = r8.runtime;	 Catch:{ all -> 0x00ed }
        r1 = r1.getLocker();	 Catch:{ all -> 0x00ed }
        r1 = r1.hasLock();	 Catch:{ all -> 0x00ed }
        if (r1 == 0) goto L_0x00e8;
    L_0x00e0:
        r1 = r8.runtime;	 Catch:{ all -> 0x00ed }
        r1.release();	 Catch:{ all -> 0x00ed }
        r1 = 0;
        r8.runtime = r1;	 Catch:{ all -> 0x00ed }
    L_0x00e8:
        r1 = 1;
        r8.terminated = r1;	 Catch:{ all -> 0x00ed }
        monitor-exit(r8);	 Catch:{ all -> 0x00ed }
        goto L_0x009a;
    L_0x00ed:
        r1 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00ed }
        throw r1;
    L_0x00f0:
        r4.push(r5);	 Catch:{ all -> 0x011d }
        r1 = r8.runtime;	 Catch:{ all -> 0x011d }
        r2 = r8.messageHandler;	 Catch:{ all -> 0x011d }
        r1.executeVoidFunction(r2, r4);	 Catch:{ all -> 0x011d }
        r5.release();	 Catch:{ Exception -> 0x00d0 }
        r4.release();	 Catch:{ Exception -> 0x00d0 }
        goto L_0x0058;
    L_0x0102:
        r1 = move-exception;
        monitor-enter(r8);
        r2 = r8.runtime;	 Catch:{ all -> 0x0143 }
        r2 = r2.getLocker();	 Catch:{ all -> 0x0143 }
        r2 = r2.hasLock();	 Catch:{ all -> 0x0143 }
        if (r2 == 0) goto L_0x0118;
    L_0x0110:
        r2 = r8.runtime;	 Catch:{ all -> 0x0143 }
        r2.release();	 Catch:{ all -> 0x0143 }
        r2 = 0;
        r8.runtime = r2;	 Catch:{ all -> 0x0143 }
    L_0x0118:
        r2 = 1;
        r8.terminated = r2;	 Catch:{ all -> 0x0143 }
        monitor-exit(r8);	 Catch:{ all -> 0x0143 }
        throw r1;
    L_0x011d:
        r1 = move-exception;
        r5.release();	 Catch:{ Exception -> 0x00d0 }
        r4.release();	 Catch:{ Exception -> 0x00d0 }
        throw r1;	 Catch:{ Exception -> 0x00d0 }
    L_0x0125:
        monitor-enter(r8);
        r1 = r8.runtime;	 Catch:{ all -> 0x0140 }
        r1 = r1.getLocker();	 Catch:{ all -> 0x0140 }
        r1 = r1.hasLock();	 Catch:{ all -> 0x0140 }
        if (r1 == 0) goto L_0x013a;
    L_0x0132:
        r1 = r8.runtime;	 Catch:{ all -> 0x0140 }
        r1.release();	 Catch:{ all -> 0x0140 }
        r1 = 0;
        r8.runtime = r1;	 Catch:{ all -> 0x0140 }
    L_0x013a:
        r1 = 1;
        r8.terminated = r1;	 Catch:{ all -> 0x0140 }
        monitor-exit(r8);	 Catch:{ all -> 0x0140 }
        goto L_0x009a;
    L_0x0140:
        r1 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0140 }
        throw r1;
    L_0x0143:
        r1 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0143 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8Executor.run():void");
    }

    public boolean hasException() {
        return this.exception != null;
    }

    public Exception getException() {
        return this.exception;
    }

    public boolean hasTerminated() {
        return this.terminated;
    }

    public void forceTermination() {
        synchronized (this) {
            this.forceTerminating = true;
            this.shuttingDown = true;
            if (this.runtime != null) {
                this.runtime.terminateExecution();
            }
            notify();
        }
    }

    public void shutdown() {
        synchronized (this) {
            this.shuttingDown = true;
            notify();
        }
    }

    public boolean isShuttingDown() {
        return this.shuttingDown;
    }

    public boolean isTerminating() {
        return this.forceTerminating;
    }
}
