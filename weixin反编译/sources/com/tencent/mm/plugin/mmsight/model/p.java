package com.tencent.mm.plugin.mmsight.model;

public final class p {
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

    public static p baU() {
        p pVar = new p();
        pVar.fps = 30;
        pVar.fGt = 0;
        pVar.oyV = oyT;
        pVar.oyW = oyS;
        pVar.mqN = oyT;
        pVar.mqM = oyS;
        pVar.oyU = 327680;
        pVar.oyX = 4;
        pVar.oyY = 1;
        pVar.oyZ = "/sdcard/2.yuv";
        pVar.ozd = "/sdcard/2.mp4";
        pVar.oza = "/sdcard/2.pcm";
        pVar.ozc = "/sdcard/2.x264";
        pVar.oze = 0;
        pVar.hXv = 0;
        pVar.ozf = 0;
        return pVar;
    }
}
