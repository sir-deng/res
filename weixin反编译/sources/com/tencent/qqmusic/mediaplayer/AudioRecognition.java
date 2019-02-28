package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AudioRecognition {
    private static final int READ_FILE_HEADER_SIZE = 64;
    private static String TAG = "AudioRecognition";
    private static HashMap<String, AudioType> mGuessFormatResultCache = new HashMap();
    private static HashMap<String, AudioType> mRecognitionResultCache = new HashMap();

    public static AudioType recognitionAudioFormatByExtensions(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AudioType audioType;
        if (mRecognitionResultCache.containsKey(str)) {
            audioType = (AudioType) mRecognitionResultCache.get(str);
            Logger.w(TAG, "Get from cache " + audioType + ",checkFilePath = " + str + ",retType = " + audioType);
            return audioType;
        }
        audioType = guessFormat(str);
        if (!AudioFormat.isAudioType(audioType)) {
            Logger.i(TAG, "recognitionAudioFormatByExtensions guessAudioType = null,so recognitionAudioFormatExactly checkFilePath = " + str);
            try {
                audioType = recognitionAudioFormatExactly(str);
            } catch (Throwable e) {
                Logger.e(TAG, e);
            }
        }
        Logger.i(TAG, "recognitionAudioFormatByExtensions checkFilePath = " + str + ",guessAudioType = " + audioType);
        return audioType;
    }

    public static AudioType guessFormat(String str) {
        if (mGuessFormatResultCache != null && mGuessFormatResultCache.containsKey(str)) {
            return (AudioType) mGuessFormatResultCache.get(str);
        }
        Iterator it = MediaCodecFactory.getSupportAudioType().iterator();
        while (it.hasNext()) {
            BaseDecoder createDecoderByType = MediaCodecFactory.createDecoderByType((AudioType) it.next());
            if (createDecoderByType != null) {
                AudioType guessAudioType = createDecoderByType.guessAudioType(str);
                if (AudioFormat.isAudioType(guessAudioType)) {
                    mGuessFormatResultCache.put(str, guessAudioType);
                    return guessAudioType;
                }
            }
        }
        return AudioType.UNSUPPORT;
    }

    public static BaseDecoder getDecoderFormFile(String str) {
        BaseDecoder createDecoderByType;
        AudioType audioType = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                audioType = recognitionAudioFormatExactly(str);
            } catch (Throwable e) {
                Logger.e(TAG, e);
            }
            createDecoderByType = MediaCodecFactory.createDecoderByType(audioType);
            if (createDecoderByType != null) {
                createDecoderByType.init(str, false);
            }
        }
        return createDecoderByType;
    }

    public static int getAudioBitDept(BaseDecoder baseDecoder, AudioInformation audioInformation) {
        int i;
        int minBufferSize;
        try {
            if (baseDecoder instanceof FLACDecoder) {
                i = ((FLACDecoder) baseDecoder).getminBufferSize();
                minBufferSize = AudioTrack.getMinBufferSize((int) audioInformation.getSampleRate(), audioInformation.getChannels(), 2);
                if (!(baseDecoder instanceof FLACDecoder)) {
                    i = minBufferSize % 2048 == 0 ? ((minBufferSize / 2048) + 1) * 2048 : minBufferSize;
                }
                minBufferSize = baseDecoder.decodeData(i * 2, new short[i]);
                if (minBufferSize > 0) {
                    i *= 2;
                } else {
                    i = minBufferSize;
                }
                return calcBitDept((long) i, baseDecoder.getCurrentTime(), audioInformation.getChannels(), audioInformation.getSampleRate());
            }
        } catch (Throwable th) {
            Logger.e(TAG, th);
        }
        i = 0;
        minBufferSize = AudioTrack.getMinBufferSize((int) audioInformation.getSampleRate(), audioInformation.getChannels(), 2);
        if (baseDecoder instanceof FLACDecoder) {
            if (minBufferSize % 2048 == 0) {
            }
        }
        minBufferSize = baseDecoder.decodeData(i * 2, new short[i]);
        if (minBufferSize > 0) {
            i = minBufferSize;
        } else {
            i *= 2;
        }
        return calcBitDept((long) i, baseDecoder.getCurrentTime(), audioInformation.getChannels(), audioInformation.getSampleRate());
    }

    public static int calcBitDept(long j, long j2, int i, long j3) {
        if (0 == j2 || i == 0) {
            return 0;
        }
        double d = (double) ((1000.0f * ((float) j)) / ((float) ((((long) i) * j2) * j3)));
        int round = (int) Math.round(d);
        Logger.i(TAG, "byteNumbers = " + j + ",time = " + j2 + ",channels = " + i + ",sampleRate = " + j3 + ",bitDept = " + d);
        return round;
    }

    public static AudioType recognitionAudioFormatExactly(String str) {
        Object obj;
        Throwable e;
        Throwable e2;
        Iterator it;
        BaseDecoder createDecoderByType;
        AudioType audioType;
        byte[] bArr;
        if (str == null) {
            return null;
        }
        mGuessFormatResultCache.remove(str);
        Logger.i(TAG, "recognitionAudioFormatExactly  path = " + str);
        File file = new File(str);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found :" + str);
        } else if (file.canRead()) {
            Logger.i(TAG, "recognitionAudioFormatExactly file length = " + file.length());
            long currentTimeMillis = System.currentTimeMillis();
            AudioType guessFormat = guessFormat(str);
            ArrayList supportAudioType = MediaCodecFactory.getSupportAudioType();
            if (guessFormat != null && supportAudioType.contains(guessFormat)) {
                supportAudioType.remove(guessFormat);
                supportAudioType.add(0, guessFormat);
                if (AudioType.MP3.equals(guessFormat)) {
                    supportAudioType.remove(AudioType.FLAC);
                    supportAudioType.add(0, AudioType.FLAC);
                }
            }
            InputStream fileInputStream;
            Object obj2;
            try {
                Object obj3;
                int read;
                fileInputStream = new FileInputStream(str);
                try {
                    obj3 = CacheBytesManager.getStatic(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    read = fileInputStream.read(obj3);
                    if (read >= 64) {
                        obj2 = new byte[64];
                        try {
                            System.arraycopy(obj3, 0, obj2, 0, 64);
                            obj = obj2;
                        } catch (Throwable e3) {
                            Throwable th = e3;
                            obj = obj2;
                            e2 = th;
                            try {
                                Logger.e(TAG, e2);
                                if (fileInputStream == null) {
                                    try {
                                        fileInputStream.close();
                                        obj2 = obj;
                                    } catch (Throwable e22) {
                                        Logger.e(TAG, e22);
                                        obj2 = obj;
                                    }
                                } else {
                                    obj2 = obj;
                                }
                                it = supportAudioType.iterator();
                                while (it.hasNext()) {
                                    createDecoderByType = MediaCodecFactory.createDecoderByType((AudioType) it.next());
                                    if (createDecoderByType != null) {
                                        try {
                                            audioType = createDecoderByType.getAudioType(str, bArr);
                                        } catch (Throwable e32) {
                                            Logger.e(TAG, "so not find!", e32);
                                            audioType = AudioType.UNSUPPORT;
                                        }
                                        if (AudioFormat.isAudioType(audioType)) {
                                            Logger.w(TAG, "soft recognition  = " + audioType + ",file path = " + str + ",recognition time = " + (System.currentTimeMillis() - currentTimeMillis) + ",guess file format = " + audioType.equals(guessFormat));
                                            break;
                                        }
                                    }
                                }
                                audioType = null;
                                if (audioType == null) {
                                    Logger.i(TAG, "[recognitionAudioFormatExactly] add to cache, file path checkFilePath = [" + str + "]. retType = [" + audioType + "].");
                                    mRecognitionResultCache.put(str, audioType);
                                    mGuessFormatResultCache.put(str, audioType);
                                } else {
                                    audioType = AudioType.UNSUPPORT;
                                }
                                Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType);
                                return audioType;
                            } catch (Throwable th2) {
                                e32 = th2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable e222) {
                                        Logger.e(TAG, e222);
                                    }
                                }
                                throw e32;
                            }
                        }
                    }
                    obj = null;
                } catch (Throwable e322) {
                    e222 = e322;
                    obj = null;
                    Logger.e(TAG, e222);
                    if (fileInputStream == null) {
                        obj2 = obj;
                    } else {
                        fileInputStream.close();
                        obj2 = obj;
                    }
                    it = supportAudioType.iterator();
                    while (it.hasNext()) {
                        createDecoderByType = MediaCodecFactory.createDecoderByType((AudioType) it.next());
                        if (createDecoderByType != null) {
                            audioType = createDecoderByType.getAudioType(str, bArr);
                            if (AudioFormat.isAudioType(audioType)) {
                                Logger.w(TAG, "soft recognition  = " + audioType + ",file path = " + str + ",recognition time = " + (System.currentTimeMillis() - currentTimeMillis) + ",guess file format = " + audioType.equals(guessFormat));
                                break;
                            }
                        }
                    }
                    audioType = null;
                    if (audioType == null) {
                        audioType = AudioType.UNSUPPORT;
                    } else {
                        Logger.i(TAG, "[recognitionAudioFormatExactly] add to cache, file path checkFilePath = [" + str + "]. retType = [" + audioType + "].");
                        mRecognitionResultCache.put(str, audioType);
                        mGuessFormatResultCache.put(str, audioType);
                    }
                    Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType);
                    return audioType;
                }
                try {
                    CacheBytesManager.recycle(obj3);
                    Logger.i(TAG, "recognitionAudioFormatExactly header = " + new String(obj3, 0, read) + ",path = " + str);
                    try {
                        fileInputStream.close();
                        bArr = obj;
                    } catch (Throwable e2222) {
                        Logger.e(TAG, e2222);
                        obj2 = obj;
                    }
                } catch (Exception e4) {
                    e2222 = e4;
                    Logger.e(TAG, e2222);
                    if (fileInputStream == null) {
                        fileInputStream.close();
                        obj2 = obj;
                    } else {
                        obj2 = obj;
                    }
                    it = supportAudioType.iterator();
                    while (it.hasNext()) {
                        createDecoderByType = MediaCodecFactory.createDecoderByType((AudioType) it.next());
                        if (createDecoderByType != null) {
                            audioType = createDecoderByType.getAudioType(str, bArr);
                            if (AudioFormat.isAudioType(audioType)) {
                                Logger.w(TAG, "soft recognition  = " + audioType + ",file path = " + str + ",recognition time = " + (System.currentTimeMillis() - currentTimeMillis) + ",guess file format = " + audioType.equals(guessFormat));
                                break;
                            }
                        }
                    }
                    audioType = null;
                    if (audioType == null) {
                        Logger.i(TAG, "[recognitionAudioFormatExactly] add to cache, file path checkFilePath = [" + str + "]. retType = [" + audioType + "].");
                        mRecognitionResultCache.put(str, audioType);
                        mGuessFormatResultCache.put(str, audioType);
                    } else {
                        audioType = AudioType.UNSUPPORT;
                    }
                    Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType);
                    return audioType;
                }
            } catch (Throwable e3222) {
                e2222 = e3222;
                fileInputStream = null;
                obj = null;
                Logger.e(TAG, e2222);
                if (fileInputStream == null) {
                    obj2 = obj;
                } else {
                    fileInputStream.close();
                    obj2 = obj;
                }
                it = supportAudioType.iterator();
                while (it.hasNext()) {
                    createDecoderByType = MediaCodecFactory.createDecoderByType((AudioType) it.next());
                    if (createDecoderByType != null) {
                        audioType = createDecoderByType.getAudioType(str, bArr);
                        if (AudioFormat.isAudioType(audioType)) {
                            Logger.w(TAG, "soft recognition  = " + audioType + ",file path = " + str + ",recognition time = " + (System.currentTimeMillis() - currentTimeMillis) + ",guess file format = " + audioType.equals(guessFormat));
                            break;
                        }
                    }
                }
                audioType = null;
                if (audioType == null) {
                    audioType = AudioType.UNSUPPORT;
                } else {
                    Logger.i(TAG, "[recognitionAudioFormatExactly] add to cache, file path checkFilePath = [" + str + "]. retType = [" + audioType + "].");
                    mRecognitionResultCache.put(str, audioType);
                    mGuessFormatResultCache.put(str, audioType);
                }
                Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType);
                return audioType;
            } catch (Throwable th3) {
                e3222 = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3222;
            }
            it = supportAudioType.iterator();
            while (it.hasNext()) {
                createDecoderByType = MediaCodecFactory.createDecoderByType((AudioType) it.next());
                if (createDecoderByType != null) {
                    audioType = createDecoderByType.getAudioType(str, bArr);
                    if (AudioFormat.isAudioType(audioType)) {
                        Logger.w(TAG, "soft recognition  = " + audioType + ",file path = " + str + ",recognition time = " + (System.currentTimeMillis() - currentTimeMillis) + ",guess file format = " + audioType.equals(guessFormat));
                        break;
                    }
                }
            }
            audioType = null;
            if (audioType == null) {
                audioType = AudioType.UNSUPPORT;
            } else {
                Logger.i(TAG, "[recognitionAudioFormatExactly] add to cache, file path checkFilePath = [" + str + "]. retType = [" + audioType + "].");
                mRecognitionResultCache.put(str, audioType);
                mGuessFormatResultCache.put(str, audioType);
            }
            Logger.i(TAG, "recognitionAudioFormatExactly checkFilePath = " + str + ",retType = " + audioType);
            return audioType;
        } else {
            throw new IOException("Can not read file :" + str);
        }
    }
}
