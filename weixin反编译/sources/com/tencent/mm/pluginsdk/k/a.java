package com.tencent.mm.pluginsdk.k;

@Deprecated
public final class a {
    public static int oyS = 480;
    public static int oyT = 640;
    public int fGt;
    public int fps;
    public int hXv;
    public int mqM;
    public int mqN;
    public int oyU;
    public int oyV;
    public int oyW;
    public int oyX;
    public int oyY;
    public String oyZ;
    public String oza;
    public String ozb;
    public String ozc;
    public String ozd;
    public int oze;
    public int ozf;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fps=").append(this.fps).append(10);
        stringBuilder.append("width=").append(this.mqM).append(10);
        stringBuilder.append("height=").append(this.mqN).append(10);
        stringBuilder.append("bitrate=").append(this.oyU).append(10);
        stringBuilder.append("rotate=").append(this.fGt).append(10);
        stringBuilder.append("yuvWidth=").append(this.oyW).append(10);
        stringBuilder.append("yuvHeight=").append(this.oyV).append(10);
        stringBuilder.append("x264Speed=").append(this.oyX).append(10);
        stringBuilder.append("x264Quality=").append(this.oyY).append(10);
        stringBuilder.append("yuvFile=").append(this.oyZ).append(10);
        stringBuilder.append("pcmFile=").append(this.oza).append(10);
        stringBuilder.append("thuFile=").append(this.ozb).append(10);
        stringBuilder.append("x264File=").append(this.ozc).append(10);
        stringBuilder.append("mp4File=").append(this.ozd).append(10);
        stringBuilder.append("videoFrameCnt=").append(this.oze).append(10);
        stringBuilder.append("videoLength=").append(this.hXv).append(10);
        stringBuilder.append("cameraCount=").append(this.ozf).append(10);
        return stringBuilder.toString();
    }

    public static a cav() {
        a aVar = new a();
        aVar.fps = 30;
        aVar.fGt = 0;
        aVar.oyV = 640;
        aVar.oyW = 480;
        aVar.mqN = 640;
        aVar.mqM = 480;
        aVar.oyU = 1440000;
        aVar.oyX = 1;
        aVar.oyY = 4;
        aVar.oyZ = "/sdcard/1.yuv";
        aVar.ozd = "/sdcard/1.mp4";
        aVar.oza = "/sdcard/1.pcm";
        aVar.ozc = "/sdcard/1.x264";
        aVar.oze = 0;
        aVar.hXv = 0;
        aVar.ozf = 0;
        return aVar;
    }

    public static a caw() {
        a aVar = new a();
        aVar.fps = 30;
        aVar.fGt = 0;
        aVar.oyV = oyT;
        aVar.oyW = oyS;
        aVar.mqN = oyT;
        aVar.mqM = oyS;
        aVar.oyU = 327680;
        aVar.oyX = 4;
        aVar.oyY = 1;
        aVar.oyZ = "/sdcard/2.yuv";
        aVar.ozd = "/sdcard/2.mp4";
        aVar.oza = "/sdcard/2.pcm";
        aVar.ozc = "/sdcard/2.x264";
        aVar.oze = 0;
        aVar.hXv = 0;
        aVar.ozf = 0;
        return aVar;
    }
}
