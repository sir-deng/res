package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import c.t.m.g.j;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class TencentLogImpl implements TencentLog {
    private static boolean DEBUG = false;
    private static final String TAG = "TencentLogImpl";
    private final File mBackupDir;
    private Handler mHandler;
    private final Runnable mKiller;
    private boolean mPrepared;
    private HandlerThread mWorker;

    final class LogHandler extends Handler {
        private static final String TXWATCHDOG = "txwatchdog";
        private File mDest;

        /* synthetic */ LogHandler(TencentLogImpl tencentLogImpl, Looper looper, AnonymousClass1 anonymousClass1) {
            this(looper);
        }

        private LogHandler(Looper looper) {
            super(looper);
            this.mDest = makeSureDest();
        }

        public final void handleMessage(Message message) {
            IOException e;
            Throwable th;
            super.handleMessage(message);
            if (this.mDest == null || !"txwatchdog".equals(this.mDest.getName())) {
                this.mDest = makeSureDest();
            }
            try {
                byte[] bytes = message.obj.toString().getBytes("GBK");
                Closeable bufferedOutputStream;
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.mDest, true));
                    try {
                        bufferedOutputStream.write(bytes);
                        bufferedOutputStream.flush();
                        j.a(bufferedOutputStream);
                        File access$500 = TencentLogImpl.this.mBackupDir;
                        File file = this.mDest;
                        if (access$500 != null && file != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (file.length() > 409600) {
                                file.renameTo(new File(access$500, new StringBuilder(TencentLog.PREFIX).append(currentTimeMillis).toString()));
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedOutputStream = null;
                    throw e;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    j.a(bufferedOutputStream);
                    throw th;
                }
            } catch (IOException e4) {
                this.mDest = null;
            }
        }

        private File makeSureDest() {
            File access$500 = TencentLogImpl.this.mBackupDir;
            if (!access$500.exists()) {
                access$500.mkdirs();
            }
            return new File(access$500, "txwatchdog");
        }
    }

    public TencentLogImpl(Context context, @Nullable File file) {
        this.mBackupDir = file;
        boolean z = file != null && (file.exists() || file.mkdirs());
        this.mPrepared = z;
        if (this.mPrepared) {
            this.mWorker = new HandlerThread("log_worker", 10);
            this.mWorker.start();
            this.mHandler = new LogHandler(this, this.mWorker.getLooper(), null);
        }
        this.mKiller = new Runnable() {
            public void run() {
                if (TencentLogImpl.this._isPrepared()) {
                    TencentLogImpl.this.mPrepared = false;
                    TencentLogImpl.this.mHandler.removeCallbacksAndMessages(null);
                    TencentLogImpl.this.mWorker.quit();
                }
            }
        };
        if (DEBUG) {
            new StringBuilder("log dir=").append(this.mBackupDir);
            if (!this.mPrepared) {
                new StringBuilder("init failed: mPrepared=").append(this.mPrepared);
            }
        }
    }

    public final void shutdown(long j) {
        if (_isPrepared()) {
            this.mHandler.removeCallbacks(this.mKiller);
            this.mHandler.postDelayed(this.mKiller, j);
        }
    }

    public final boolean tryRestart() {
        if (!_isPrepared()) {
            return false;
        }
        this.mHandler.removeCallbacks(this.mKiller);
        return true;
    }

    private boolean _isPrepared() {
        return this.mPrepared && this.mHandler != null;
    }

    final boolean isPrepared() {
        return this.mPrepared;
    }

    public static void setDebugEnabled(boolean z) {
        DEBUG = z;
    }

    public static boolean isDebugEnabled() {
        return DEBUG;
    }

    public final void println(String str, int i, @NonNull String str2) {
        if (_isPrepared()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()));
            stringBuilder.append(":").append(str);
            stringBuilder.append(":").append(str2).append("\n");
            this.mHandler.obtainMessage(1, stringBuilder.toString()).sendToTarget();
        }
    }

    public final String getDirString() {
        if (this.mBackupDir != null) {
            return this.mBackupDir.getName();
        }
        return null;
    }
}
