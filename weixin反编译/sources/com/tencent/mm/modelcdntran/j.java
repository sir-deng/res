package com.tencent.mm.modelcdntran;

public final class j extends i {
    public int concurrentCount = 1;
    public String fAJ;
    public int fAL;
    public String fAR = "";
    public long fGj = 0;
    public String feA = "";
    public String filename;
    public String host;
    public String[] huZ;
    public long hvA = 0;
    public a hvB;
    public long hvr;
    public String hvs;
    public int hvt;
    public int hvu;
    public String hvv;
    public int hvw;
    public int hvx = 0;
    public long hvy = 0;
    public int hvz = 0;
    public boolean isColdSnsData = false;
    public String referer;
    public String signalQuality = "";
    public String snsScene = "";
    public String url;

    public interface a {
        void K(String str, int i);

        void g(String str, int i, int i2);

        void onDataAvailable(String str, int i, int i2);

        void onMoovReady(String str, int i, int i2);
    }

    public final boolean MU() {
        return this.hvp == 3;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("isPlayMode: ").append(this.hvu);
        stringBuffer.append(" videoFormat: ").append(this.field_requestVideoFormat);
        stringBuffer.append(" initialDownloadLength : ").append(this.initialDownloadLength);
        stringBuffer.append(" initialDownloadOffset : ").append(this.initialDownloadOffset);
        stringBuffer.append(" videoXmlTotalLen : ").append(this.hvt);
        stringBuffer.append(" videoTaskType : ").append(this.hvp);
        stringBuffer.append(" filename : ").append(this.filename);
        if (MS()) {
            stringBuffer.append(" url : ").append(this.url);
            stringBuffer.append(" host : ").append(this.host);
            stringBuffer.append(" referer : ").append(this.referer);
            stringBuffer.append(" ip size : ").append(this.huZ != null ? this.huZ.length : 0);
            stringBuffer.append(" isColdSnsData : ").append(this.isColdSnsData);
            stringBuffer.append(" signalQuality : ").append(this.signalQuality);
            stringBuffer.append(" snsScene : ").append(this.snsScene);
            stringBuffer.append(" snsId : ").append(this.fAR);
        } else {
            stringBuffer.append(" field_mediaId : ").append(this.field_mediaId);
        }
        stringBuffer.append(" fileid : ").append(this.field_fileId);
        stringBuffer.append(" fileaeskey: ").append(this.field_aesKey);
        stringBuffer.append(" field_preloadRatio:").append(this.field_preloadRatio);
        stringBuffer.append(" newmd5: ").append(this.feA);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
