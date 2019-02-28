package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.WindowManager;

@TargetApi(16)
public final class d {
    final a aDK;
    final boolean aDL;
    final long aDM;
    final long aDN;
    long aDO;
    long aDP;
    long aDQ;
    boolean aDR;
    long aDS;
    long aDT;
    long aDU;

    private static final class a implements Callback, FrameCallback {
        private static final a aDW = new a();
        public volatile long aDV;
        private final HandlerThread aDX = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer aDY;
        private int aDZ;
        final Handler handler;

        public static a ma() {
            return aDW;
        }

        private a() {
            this.aDX.start();
            this.handler = new Handler(this.aDX.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public final void doFrame(long j) {
            this.aDV = j;
            this.aDY.postFrameCallbackDelayed(this, 500);
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.aDY = Choreographer.getInstance();
                    return true;
                case 1:
                    this.aDZ++;
                    if (this.aDZ != 1) {
                        return true;
                    }
                    this.aDY.postFrameCallback(this);
                    return true;
                case 2:
                    this.aDZ--;
                    if (this.aDZ != 0) {
                        return true;
                    }
                    this.aDY.removeFrameCallback(this);
                    this.aDV = 0;
                    return true;
                default:
                    return false;
            }
        }
    }

    public d() {
        this(-1.0d);
    }

    public d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this(windowManager.getDefaultDisplay() != null ? (double) windowManager.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private d(double d) {
        this.aDL = d != -1.0d;
        if (this.aDL) {
            this.aDK = a.ma();
            this.aDM = (long) (1.0E9d / d);
            this.aDN = (this.aDM * 80) / 100;
            return;
        }
        this.aDK = null;
        this.aDM = -1;
        this.aDN = -1;
    }

    final boolean e(long j, long j2) {
        return Math.abs((j2 - this.aDS) - (j - this.aDT)) > 20000000;
    }
}
