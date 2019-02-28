package com.tencent.qqmusic.mediaplayer.codec.flac;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class FLACDecoder extends BaseDecoder {
    public static final String TAG = "FLACDecoder";
    private volatile boolean mHasRelease = false;

    private native int nCleanup();

    private native int nDecodeData(int i, short[] sArr);

    private native FLACInformation nGetAudioInformation();

    private native int nGetCurrentTime();

    private native int nGetminBufferSize();

    private native int nInitDataSource(IDataSource iDataSource);

    private native int nInitNativeDataSource(INativeDataSource iNativeDataSource);

    private native int nOpen(String str);

    private native int nSeekTo(int i);

    public int init(String str, boolean z) {
        super.init(str, z);
        return nOpen(str);
    }

    public int init(IDataSource iDataSource) {
        super.init(iDataSource);
        return nInitDataSource(iDataSource);
    }

    public int init(INativeDataSource iNativeDataSource) {
        super.init(iNativeDataSource);
        return nInitNativeDataSource(iNativeDataSource);
    }

    public AudioInformation getAudioInformation() {
        super.getAudioInformation();
        return nGetAudioInformation();
    }

    public int decodeData(int i, short[] sArr) {
        super.decodeData(i, sArr);
        return nDecodeData(i, sArr);
    }

    public long getCurrentTime() {
        super.getCurrentTime();
        return (long) nGetCurrentTime();
    }

    public int seekTo(int i) {
        super.seekTo(i);
        return nSeekTo(i);
    }

    public int release() {
        super.release();
        if (!this.mHasRelease) {
            this.mHasRelease = true;
            Logger.w(TAG, this + "release");
            nCleanup();
        }
        return 0;
    }

    public int getminBufferSize() {
        super.throwIfSoNotLoadSuccess();
        return nGetminBufferSize();
    }

    public AudioType getAudioType(String str, byte[] bArr) {
        if (bArr != null && bArr.length > 0 && new String(bArr).startsWith("flaC")) {
            return AudioType.FLAC;
        }
        if (checkFormatBySoftDecoder(str)) {
            return AudioType.FLAC;
        }
        return AudioType.UNSUPPORT;
    }

    public AudioType guessAudioType(String str) {
        Throwable e;
        if (!TextUtils.isEmpty(str)) {
            if (str.toLowerCase().contains(".flac")) {
                return AudioType.FLAC;
            }
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[64];
                    fileInputStream.read(bArr);
                    AudioType audioType = getAudioType(str, bArr);
                    try {
                        fileInputStream.close();
                        return audioType;
                    } catch (Throwable e2) {
                        Logger.e(TAG, e2);
                        return audioType;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
                try {
                    Logger.e(TAG, e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e5) {
                            Logger.e(TAG, e5);
                        }
                    }
                    return AudioType.UNSUPPORT;
                } catch (Throwable th) {
                    e5 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22) {
                            Logger.e(TAG, e22);
                        }
                    }
                    throw e5;
                }
            } catch (Throwable th2) {
                e5 = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e5;
            }
        }
        return AudioType.UNSUPPORT;
    }

    protected List<String> getSoNameList() {
        return Arrays.asList(new String[]{"audio_common", "qmflac"});
    }

    public int getErrorCodeMask() {
        return 33554431;
    }
}
