package com.tencent.liteav.muxer.jni;

public class TXSWMuxerJNI {

    public static class AVOptions {
        public int audioChannels = 1;
        public int audioSampleRate = 48000;
        public int videoGOP = 12;
        public int videoHeight = 540;
        public int videoWidth = 960;
    }
}
