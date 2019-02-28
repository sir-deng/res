package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a implements f {
    private String lFY;
    String oCL;
    String oCM;
    private MediaExtractor oCN;
    private List<a> oCO = new ArrayList();
    private List<a> oCP = new ArrayList();
    long oCQ;
    long oCR;
    int oCS = -1;
    private boolean oCT = false;
    VideoTransPara oCU;
    int oCV = -1;

    class a {
        int index;
        MediaFormat oBG;

        a(MediaFormat mediaFormat, int i) {
            this.oBG = mediaFormat;
            this.index = i;
        }
    }

    public abstract int FQ(String str);

    public void a(String str, String str2, VideoTransPara videoTransPara) {
        x.d("BaseMediaCodecClipper", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long Wz = bi.Wz();
        if (bi.oN(str) || bi.oN(str2) || videoTransPara == null) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[]{str, str2, videoTransPara}));
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (FileOp.bO(str) && file.canRead() && file.length() != 0) {
            this.oCM = str;
            this.oCL = str2;
            this.oCU = videoTransPara;
            this.oCN = new MediaExtractor();
            this.oCN.setDataSource(str);
            a(this.oCN);
            if (this.oCO == null || this.oCO.size() == 0) {
                throw new o("Can not find video or audio track in this video file.");
            }
            this.oCS = bbD();
            this.oCV = FQ(str);
            this.oCT = true;
            x.e("BaseMediaCodecClipper", "init cost time %dms", Long.valueOf(bi.bB(Wz)));
            return;
        }
        throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[]{str}));
    }

    private void a(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat.containsKey("mime") && !bi.oN(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                x.i("BaseMediaCodecClipper", "mime: %s", string);
                if (string.startsWith("audio/")) {
                    this.oCP.add(new a(trackFormat, i));
                } else if (string.startsWith("video/")) {
                    this.oCO.add(new a(trackFormat, i));
                }
            }
        }
        x.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", Integer.valueOf(this.oCP.size()), Integer.valueOf(this.oCO.size()));
    }

    public int z(long j, long j2) {
        if (this.oCT) {
            if (j < 0) {
                j = 0;
            }
            this.oCQ = j;
            MediaFormat mediaFormat = ((a) this.oCO.get(0)).oBG;
            if (mediaFormat.containsKey("durationUs")) {
                if (j2 <= 0 || j2 > mediaFormat.getLong("durationUs") / 1000) {
                    j2 = mediaFormat.getLong("durationUs") / 1000;
                }
                this.oCR = j2;
                return a(this.oCN, this.oCP, this.oCO);
            }
            throw new o("Can not find duration.");
        }
        x.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
        throw new IllegalStateException("Please init this component first.");
    }

    protected int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
        return 0;
    }

    protected final String bbC() {
        if (this.lFY == null) {
            this.lFY = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4";
        }
        return this.lFY;
    }

    public final void release() {
        this.oCT = false;
        if (this.oCN != null) {
            this.oCN.release();
        }
    }

    private int bbD() {
        Iterator it;
        int i;
        a aVar;
        int i2 = -1;
        if (!(this.oCP == null || this.oCP.size() == 0)) {
            it = this.oCP.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                aVar = (a) it.next();
                if (aVar.oBG.containsKey("max-input-size")) {
                    i2 = Math.max(aVar.oBG.getInteger("max-input-size"), i);
                } else {
                    i2 = i;
                }
            }
            i2 = i;
        }
        if (this.oCO == null || this.oCO.size() == 0) {
            return i2;
        }
        it = this.oCO.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                return i;
            }
            aVar = (a) it.next();
            if (aVar.oBG.containsKey("max-input-size")) {
                i2 = Math.max(aVar.oBG.getInteger("max-input-size"), i);
            } else {
                i2 = i;
            }
        }
    }
}
