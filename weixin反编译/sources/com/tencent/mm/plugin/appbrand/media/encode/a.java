package com.tencent.mm.plugin.appbrand.media.encode;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.plugin.appbrand.media.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class a extends b {
    int jFG = 2;
    private MediaCodec jFH;
    BufferInfo jFI;
    private final int jFJ = 100;
    private String mFilePath = "";

    public final boolean f(String str, int i, int i2, int i3) {
        boolean z;
        x.i("MicroMsg.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.mFilePath = str;
        try {
            x.i("MicroMsg.AACAudioEncoder", "initCodec");
            this.jFI = new BufferInfo();
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.jFK, i, i2);
            createAudioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i3);
            createAudioFormat.setInteger("aac-profile", this.jFG);
            this.jFH = MediaCodec.createEncoderByType(this.jFK);
            this.jFH.configure(createAudioFormat, null, null, 1);
            this.jFH.start();
            x.i("MicroMsg.AACAudioEncoder", "encoder start to work");
            z = false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AACAudioEncoder", e, "initCodec", new Object[0]);
            z = true;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.AACAudioEncoder", e2, "initCodec", new Object[0]);
            z = true;
        }
        if (z) {
            x.i("MicroMsg.AACAudioEncoder", "initCodec  fail,");
            j.ln(21);
            return false;
        }
        x.i("MicroMsg.AACAudioEncoder", "initCodec ok");
        if (M4aAudioFormatJni.createM4aFile(str, i2, i, this.jFG) == 0) {
            x.i("MicroMsg.AACAudioEncoder", "createM4aFile m4a jni api ok,");
            return true;
        }
        x.i("MicroMsg.AACAudioEncoder", "createM4aFile m4a jni api fail,");
        j.ln(22);
        return false;
    }

    public final boolean a(boolean z, byte[] bArr, int i) {
        if (bArr == null) {
            x.e("MicroMsg.AACAudioEncoder", "pcm is null");
            return false;
        } else if (this.jFH != null) {
            x.i("MicroMsg.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", Boolean.valueOf(z));
            ByteBuffer[] inputBuffers = this.jFH.getInputBuffers();
            ByteBuffer[] outputBuffers = this.jFH.getOutputBuffers();
            int dequeueInputBuffer = this.jFH.dequeueInputBuffer(100);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                byteBuffer.position(0);
                byteBuffer.limit(bArr.length);
                x.i("MicroMsg.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", Integer.valueOf(dequeueInputBuffer), Integer.valueOf(bArr.length));
                if (z) {
                    this.jFH.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.nanoTime(), 4);
                    inputBuffers = outputBuffers;
                } else {
                    this.jFH.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.nanoTime(), 0);
                    inputBuffers = outputBuffers;
                }
            } else {
                x.e("MicroMsg.AACAudioEncoder", "inputBufferIndex %d", Integer.valueOf(dequeueInputBuffer));
                inputBuffers = outputBuffers;
            }
            while (true) {
                dequeueInputBuffer = this.jFH.dequeueOutputBuffer(this.jFI, 100);
                if (dequeueInputBuffer == -1) {
                    x.d("MicroMsg.AACAudioEncoder", "no output available, break");
                    break;
                } else if (dequeueInputBuffer == -3) {
                    x.e("MicroMsg.AACAudioEncoder", "output buff change");
                    inputBuffers = this.jFH.getOutputBuffers();
                } else if (dequeueInputBuffer == -2) {
                    x.e("MicroMsg.AACAudioEncoder", "encoder output format changed: " + this.jFH.getOutputFormat());
                } else if (dequeueInputBuffer < 0) {
                    x.e("MicroMsg.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", Integer.valueOf(dequeueInputBuffer));
                } else {
                    x.i("MicroMsg.AACAudioEncoder", "outputBufferIndex %d", Integer.valueOf(dequeueInputBuffer));
                    ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                    if (byteBuffer2 == null) {
                        throw new RuntimeException("outputBuffer " + dequeueInputBuffer + " was null");
                    }
                    if ((this.jFI.flags & 2) != 0) {
                        x.e("MicroMsg.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
                    } else {
                        int i2 = this.jFI.size;
                        byte[] bArr2 = new byte[i2];
                        byteBuffer2.get(bArr2, 0, i2);
                        int writeAudioBuff = M4aAudioFormatJni.writeAudioBuff(bArr2, i2);
                        d(bArr2, i2, false);
                        if (writeAudioBuff == 0) {
                            x.i("MicroMsg.AACAudioEncoder", "writeAudioBuff buff ok,");
                        } else {
                            x.i("MicroMsg.AACAudioEncoder", "writeAudioBuff buff fail,");
                        }
                    }
                    this.jFH.releaseOutputBuffer(dequeueInputBuffer, false);
                    if ((this.jFI.flags & 4) != 0) {
                        if (z) {
                            x.e("MicroMsg.AACAudioEncoder", "reach the end, and end to encode the data");
                        } else {
                            x.w("MicroMsg.AACAudioEncoder", "reached end of stream unexpectedly");
                        }
                    }
                }
            }
            return true;
        } else {
            x.e("MicroMsg.AACAudioEncoder", "mEncoder is null");
            return false;
        }
    }

    public final void flush() {
        x.i("MicroMsg.AACAudioEncoder", "flush");
        d(new byte[0], 0, true);
    }

    public final void close() {
        x.i("MicroMsg.AACAudioEncoder", "close");
        if (this.jFH != null) {
            this.jFH.stop();
            this.jFH.release();
            this.jFH = null;
        }
        M4aAudioFormatJni.closeM4aFile();
    }
}
