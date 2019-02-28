package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class j extends i {
    public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";

    public j(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        super(mediaExtractor, mediaFormat, i);
        x.i(TAG, "init ");
    }

    protected final int a(MediaCodecInfo mediaCodecInfo, String str) {
        x.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", str, mediaCodecInfo);
        long Wz = bi.Wz();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        x.i(TAG, "getCapabilitiesForType used %sms", Long.valueOf(bi.bB(Wz)));
        x.i(TAG, "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            x.i(TAG, "capabilities colorFormat: %s", Integer.valueOf(i2));
            if (tl(i2) && (i2 > i || i2 == 2135033992)) {
                i = i2;
            }
        }
        x.i(TAG, "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i));
        return i;
    }

    protected final boolean tl(int i) {
        switch (i) {
            case 2135033992:
                return true;
            default:
                return false;
        }
    }

    protected final boolean bbQ() {
        if (this.ovt == null) {
            x.e(TAG, "drainDecoder, decoder is null");
            return true;
        }
        int dequeueOutputBuffer = this.ovt.dequeueOutputBuffer(this.oBI, 60000);
        x.i(TAG, "outputBufferIndex-->" + dequeueOutputBuffer);
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer == -3) {
                x.i(TAG, "decoder output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                this.oDq = this.ovt.getOutputFormat();
                x.i(TAG, "decoder output format changed: " + this.oDq);
            } else if (dequeueOutputBuffer < 0) {
                x.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                x.v(TAG, "perform decoding");
                long Wz = bi.Wz();
                byte[] a = a(this.ovt.getOutputImage(dequeueOutputBuffer));
                x.v(TAG, "perform decoding costImage %s", Long.valueOf(bi.bB(Wz)));
                if (a == null) {
                    break;
                } else if (a.length != 0) {
                    BufferInfo bufferInfo = this.oBI;
                    if (a == null) {
                        x.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
                    } else {
                        x.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", a, bufferInfo, Integer.valueOf(bufferInfo.size));
                        this.oDq = this.ovt.getOutputFormat();
                        if (this.oCX != null) {
                            this.oCX.aC(a);
                        }
                    }
                    this.ovt.releaseOutputBuffer(dequeueOutputBuffer, false);
                    long j = this.oBI.presentationTimeUs;
                    if (this.oCs != 1 && j >= this.oCs * 1000) {
                        x.e(TAG, "exceed endTimeMs");
                        return true;
                    } else if ((this.oBI.flags & 4) == 0) {
                        return false;
                    } else {
                        x.i(TAG, "receive end of stream");
                        try {
                            this.ovt.stop();
                            this.ovt.release();
                            this.ovt = null;
                            return true;
                        } catch (Exception e) {
                            x.e(TAG, "stop and release decoder error: %s", e.getMessage());
                            return true;
                        }
                    }
                } else {
                    this.ovt.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
            }
            dequeueOutputBuffer = this.ovt.dequeueOutputBuffer(this.oBI, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        x.i(TAG, "no output from decoder available, break");
        return false;
    }

    public final int bbE() {
        return 2;
    }

    private static byte[] a(Image image) {
        int i;
        int format = image.getFormat();
        int width = image.getWidth();
        int height = image.getHeight();
        int i2 = 0;
        Plane[] planes = image.getPlanes();
        x.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", Integer.valueOf(planes.length), Integer.valueOf(((width * height) * ImageFormat.getBitsPerPixel(format)) / 8), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(format));
        byte[] h = com.tencent.mm.plugin.mmsight.model.a.j.oAr.h(Integer.valueOf(i));
        format = 0;
        while (true) {
            i = format;
            if (i >= planes.length) {
                return h;
            }
            ByteBuffer buffer = planes[i].getBuffer();
            int rowStride = planes[i].getRowStride();
            int pixelStride = planes[i].getPixelStride();
            int i3 = i == 0 ? width : width / 2;
            format = i == 0 ? height : height / 2;
            x.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", Integer.valueOf(rowStride), Integer.valueOf(i3), Integer.valueOf(format), Integer.valueOf(pixelStride));
            byte[] h2 = com.tencent.mm.plugin.mmsight.model.a.j.oAr.h(Integer.valueOf(rowStride));
            for (int i4 = 0; i4 < format; i4++) {
                int bitsPerPixel = ImageFormat.getBitsPerPixel(35) / 8;
                if (pixelStride == bitsPerPixel) {
                    bitsPerPixel *= i3;
                    buffer.get(h, i2, bitsPerPixel);
                    if (format - i4 != 1) {
                        buffer.position((buffer.position() + rowStride) - bitsPerPixel);
                    }
                    i2 += bitsPerPixel;
                } else {
                    if (format - i4 == 1) {
                        buffer.get(h2, 0, (width - pixelStride) + 1);
                    } else {
                        buffer.get(h2, 0, rowStride);
                    }
                    bitsPerPixel = 0;
                    while (bitsPerPixel < i3) {
                        int i5 = i2 + 1;
                        h[i2] = h2[bitsPerPixel * pixelStride];
                        bitsPerPixel++;
                        i2 = i5;
                    }
                }
            }
            com.tencent.mm.plugin.mmsight.model.a.j.oAr.D(h2);
            format = i + 1;
        }
    }
}
