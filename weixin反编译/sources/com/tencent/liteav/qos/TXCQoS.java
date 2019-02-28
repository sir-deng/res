package com.tencent.liteav.qos;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.rtmp.TXLiveConstants;

public class TXCQoS {
    static final String TAG = "TXCQos";
    private int mBitrate = 0;
    private Handler mHandler = new Handler();
    private int mHeight = 0;
    private long mInstance;
    private long mInterval = 1000;
    private boolean mIsEnableDrop = false;
    private a mListener;
    private a mNotifyListener;
    private Runnable mRunnable = new Runnable() {
        public void run() {
            if (TXCQoS.this.mListener != null) {
                int onGetEncoderRealBitrate = TXCQoS.this.mListener.onGetEncoderRealBitrate();
                int onGetQueueInputSize = TXCQoS.this.mListener.onGetQueueInputSize();
                int onGetQueueOutputSize = TXCQoS.this.mListener.onGetQueueOutputSize();
                int onGetVideoQueueMaxCount = TXCQoS.this.mListener.onGetVideoQueueMaxCount();
                int onGetVideoQueueCurrentCount = TXCQoS.this.mListener.onGetVideoQueueCurrentCount();
                int onGetVideoDropCount = TXCQoS.this.mListener.onGetVideoDropCount();
                TXCQoS.this.nativeSetVideoRealBitrate(TXCQoS.this.mInstance, onGetEncoderRealBitrate);
                TXCQoS.this.nativeAdjustBitrate(TXCQoS.this.mInstance, onGetVideoQueueMaxCount, onGetVideoQueueCurrentCount, onGetVideoDropCount, onGetQueueOutputSize, onGetQueueInputSize);
                boolean access$400 = TXCQoS.this.nativeIsEnableDrop(TXCQoS.this.mInstance);
                if (TXCQoS.this.mIsEnableDrop != access$400) {
                    TXCQoS.this.mIsEnableDrop = access$400;
                    TXCQoS.this.mListener.onEnableDropStatusChanged(access$400);
                }
                onGetEncoderRealBitrate = TXCQoS.this.nativeGetBitrate(TXCQoS.this.mInstance);
                int access$700 = TXCQoS.this.nativeGetWidth(TXCQoS.this.mInstance);
                int access$800 = TXCQoS.this.nativeGetHeight(TXCQoS.this.mInstance);
                Bundle bundle;
                if (access$700 != TXCQoS.this.mWidth || access$800 != TXCQoS.this.mHeight) {
                    TXCQoS.this.mListener.onEncoderParamsChanged(onGetEncoderRealBitrate, access$700, access$800);
                    if (TXCQoS.this.mNotifyListener != null) {
                        bundle = new Bundle();
                        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "调整分辨率:new bitrate:" + onGetEncoderRealBitrate + " new resolution:" + access$700 + "*" + access$800);
                        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                        TXCQoS.this.mNotifyListener.onNotifyEvent(1005, bundle);
                    }
                } else if (onGetEncoderRealBitrate != TXCQoS.this.mBitrate) {
                    TXCQoS.this.mListener.onEncoderParamsChanged(onGetEncoderRealBitrate, 0, 0);
                    if (TXCQoS.this.mNotifyListener != null) {
                        bundle = new Bundle();
                        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "调整编码码率:new bitrate:" + onGetEncoderRealBitrate);
                        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                        bundle.putLong("EVT_USERID", TXCQoS.this.mUserID);
                        TXCQoS.this.mNotifyListener.onNotifyEvent(1006, bundle);
                    }
                }
                TXCQoS.this.mBitrate = onGetEncoderRealBitrate;
                TXCQoS.this.mWidth = access$700;
                TXCQoS.this.mHeight = access$800;
            }
            TXCQoS.this.mHandler.postDelayed(this, TXCQoS.this.mInterval);
        }
    };
    private long mUserID = 0;
    private int mWidth = 0;

    private native void nativeAddQueueInputSize(long j, int i);

    private native void nativeAddQueueOutputSize(long j, int i);

    private native void nativeAdjustBitrate(long j, int i, int i2, int i3, int i4, int i5);

    private native void nativeDeinit(long j);

    private native int nativeGetBitrate(long j);

    private native int nativeGetHeight(long j);

    public static native int nativeGetProperResolutionByVideoBitrate(boolean z, int i, int i2);

    private native int nativeGetWidth(long j);

    private native long nativeInit(boolean z);

    private native boolean nativeIsEnableDrop(long j);

    private native void nativeReset(long j, boolean z);

    private native void nativeSetAutoAdjustBitrate(long j, boolean z);

    private native void nativeSetAutoAdjustStrategy(long j, int i);

    private native void nativeSetHasVideo(long j, boolean z);

    private native void nativeSetVideoDefaultResolution(long j, int i);

    private native void nativeSetVideoEncBitrate(long j, int i, int i2, int i3);

    private native void nativeSetVideoExpectBitrate(long j, int i);

    private native void nativeSetVideoRealBitrate(long j, int i);

    public TXCQoS(boolean z) {
        this.mInstance = nativeInit(z);
    }

    protected void finalize() {
        try {
            nativeDeinit(this.mInstance);
        } finally {
            super.finalize();
        }
    }

    public void start(long j) {
        this.mInterval = j;
        this.mHandler.postDelayed(this.mRunnable, this.mInterval);
    }

    public void stop() {
        this.mHandler.removeCallbacks(this.mRunnable);
    }

    public long getUserID() {
        return this.mUserID;
    }

    public void setUserID(long j) {
        this.mUserID = j;
    }

    public void setNotifyListener(a aVar) {
        this.mNotifyListener = aVar;
    }

    public void setListener(a aVar) {
        this.mListener = aVar;
    }

    public void reset(boolean z) {
        nativeReset(this.mInstance, z);
    }

    public boolean isEnableDrop() {
        return nativeIsEnableDrop(this.mInstance);
    }

    public void setHasVideo(boolean z) {
        nativeSetHasVideo(this.mInstance, z);
    }

    public void setAutoAdjustBitrate(boolean z) {
        TXCLog.d(TAG, "autoAdjustBitrate is " + (z ? "yes" : "no"));
        nativeSetAutoAdjustBitrate(this.mInstance, z);
    }

    public void setAutoAdjustStrategy(int i) {
        TXCLog.d(TAG, "autoAdjustStrategy is " + i);
        nativeSetAutoAdjustStrategy(this.mInstance, i);
    }

    public void setDefaultVideoResolution(int i) {
        TXCLog.d(TAG, "DefaultVideoResolution is " + i);
        this.mWidth = 0;
        this.mHeight = 0;
        nativeSetVideoDefaultResolution(this.mInstance, i);
    }

    public void setVideoEncBitrate(int i, int i2, int i3) {
        this.mBitrate = 0;
        nativeSetVideoEncBitrate(this.mInstance, i, i2, i3);
    }

    public void setVideoExpectBitrate(int i) {
        nativeSetVideoExpectBitrate(this.mInstance, i);
    }

    static {
        com.tencent.liteav.basic.util.a.d();
    }
}
