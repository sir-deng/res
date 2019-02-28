package com.tencent.mm.plugin.s;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Pair;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class h {
    private ByteBuffer[] agD;
    private ByteBuffer[] apM;
    private int apO;
    private int apP;
    private BufferInfo apy = new BufferInfo();
    long aqA;
    private volatile Object lock = new Object();
    protected g ovj;
    protected ag ovk;
    private boolean ovl = false;
    b ovm = null;
    protected long ovn = 0;
    MediaFormat ovo;
    private String ovp;
    int ovq;
    MediaExtractor ovr;
    private f ovs;
    protected MediaCodec ovt;
    private boolean ovu = false;
    private boolean ovv = false;
    protected String path;
    protected int state;

    abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo);

    abstract boolean a(MediaCodec mediaCodec);

    abstract String bae();

    public h(g gVar, ag agVar) {
        this.ovj = gVar;
        this.ovk = agVar;
        this.state = 0;
        this.apO = -1;
        this.apP = -1;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    private void bam() {
        if (this.ovm != null) {
            this.ovn = this.ovm.baf() * 1000;
        }
    }

    public final void ban() {
        x.i("MicroMsg.TrackDataSource", "%s flush codec", atw());
        this.apP = -1;
        this.apO = -1;
        try {
            if (this.ovt != null) {
                this.ovt.flush();
            }
        } catch (Exception e) {
        }
    }

    public void release() {
        x.i("MicroMsg.TrackDataSource", "%s release", atw());
        if (this.ovr != null) {
            this.ovr.release();
            this.ovr = null;
        }
        if (this.ovt != null) {
            this.ovt.release();
            this.ovt = null;
        }
        if (this.ovs != null) {
            f fVar = this.ovs;
            if (fVar.ouS != null) {
                try {
                    fVar.ouS.close();
                } catch (IOException e) {
                }
            }
            fVar.ihw.clear();
            fVar.ihw = null;
            fVar.ihx.clear();
            fVar.ihx = null;
            fVar.ouT = null;
        }
        x.i("MicroMsg.TrackDataSource", "%s finish release", atw());
    }

    protected final void kM() {
        if (this.ovt != null) {
            x.i("MicroMsg.TrackDataSource", "%s release decoder", atw());
            ban();
            this.agD = null;
            this.apM = null;
            long Wz = bi.Wz();
            synchronized (this.lock) {
                x.i("MicroMsg.TrackDataSource", "%s wait lock cost[%d]", atw(), Long.valueOf(bi.bB(Wz)));
                try {
                    this.ovt.stop();
                    this.ovt.release();
                    this.ovt = null;
                } catch (Exception e) {
                    this.ovt.release();
                    this.ovt = null;
                } catch (Throwable th) {
                    this.ovt = null;
                }
            }
            x.i("MicroMsg.TrackDataSource", "%s finish release decoder [%d]", atw(), Long.valueOf(bi.bB(Wz)));
        }
    }

    protected final boolean bao() {
        try {
            x.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", atw(), this.ovp);
            this.ovt = MediaCodec.createDecoderByType(this.ovp);
            a(this.ovt);
            this.ovt.start();
            this.apM = this.ovt.getInputBuffers();
            this.agD = this.ovt.getOutputBuffers();
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s prepare decoder init decoder error ", atw());
            this.ovj.FK(bae());
            return false;
        }
    }

    public final void start() {
        x.i("MicroMsg.TrackDataSource", "%s start to play", atw());
        setState(3);
        onStart();
    }

    public final void pause() {
        x.i("MicroMsg.TrackDataSource", "%s start to pause", atw());
        setState(4);
        onPause();
    }

    public final long sU(int i) {
        x.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", atw(), Integer.valueOf(i), Boolean.valueOf(this.ovl));
        ban();
        this.ovl = false;
        if (this.ovs != null) {
            try {
                f fVar = this.ovs;
                long j = (long) (i * 1000);
                int i2 = 0;
                while (i2 < fVar.ihx.size()) {
                    Pair pair = (Pair) fVar.ihx.get(i2);
                    if (j < ((Long) pair.second).longValue()) {
                        break;
                    } else if (j == ((Long) pair.second).longValue()) {
                        fVar.ouU = ((Integer) pair.first).intValue();
                        fVar.ouT = (g) fVar.ihw.get(fVar.ouU);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0 || i2 == fVar.ihx.size() - 1) {
                    fVar.ouU = ((Integer) ((Pair) fVar.ihx.get(i2)).first).intValue();
                    fVar.ouT = (g) fVar.ihw.get(fVar.ouU);
                    if (this.ovs.ouT.ihz < 0) {
                        y(((long) i) * 1000, -1);
                    }
                    if (this.ovs.ouT.ihz < 0) {
                        y(0, -1);
                        this.ovj.bal();
                    }
                    x.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", atw(), Long.valueOf(this.ovs.ouT.ihz));
                    return this.ovs.ouT.ihz / 1000;
                }
                fVar.ouU = ((Integer) ((Pair) fVar.ihx.get(i2 - 1)).first).intValue();
                fVar.ouT = (g) fVar.ihw.get(fVar.ouU);
                if (this.ovs.ouT.ihz < 0) {
                    y(((long) i) * 1000, -1);
                }
                if (this.ovs.ouT.ihz < 0) {
                    y(0, -1);
                    this.ovj.bal();
                }
                x.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", atw(), Long.valueOf(this.ovs.ouT.ihz));
                return this.ovs.ouT.ihz / 1000;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s extractor seek exception %s", atw(), e.toString());
                return 0;
            }
        }
        try {
            this.ovr.seekTo((long) (i * 1000), 0);
            if (this.ovr.getSampleTime() < 0) {
                y(((long) i) * 1000, -1);
            }
            if (this.ovr.getSampleTime() < 0) {
                y(0, -1);
                this.ovj.bal();
            }
            x.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d]", atw(), Long.valueOf(this.ovr.getSampleTime()), Long.valueOf(this.ovr.getCachedDuration()));
            return this.ovr.getSampleTime() / 1000;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s extractor seek exception %s", atw(), e2.toString());
            return 0;
        }
    }

    public final boolean bap() {
        x.i("MicroMsg.TrackDataSource", "%s start to prepare path %s", atw(), this.path);
        long Wz = bi.Wz();
        long j = 0;
        try {
            x.i("MicroMsg.TrackDataSource", "%s start to init extractor", atw());
            this.ovr = new MediaExtractor();
            this.ovr.setDataSource(this.path);
            int trackCount = this.ovr.getTrackCount();
            this.ovq = -1;
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = this.ovr.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string != null && string.contains(bae())) {
                    b(trackFormat, string, i);
                    break;
                }
            }
            if (this.ovq < 0) {
                x.w("MicroMsg.TrackDataSource", "%s prepare track but can not find track index.[%d, %d]", atw(), Integer.valueOf(trackCount), Integer.valueOf(this.ovq));
                this.ovj.FJ("can not find ");
                return false;
            }
            this.ovr.selectTrack(this.ovq);
            this.ovs = null;
            long Wz2 = bi.Wz();
            try {
                x.i("MicroMsg.TrackDataSource", "%s start to init decoder mime[%s] state[%d]", atw(), this.ovp, Integer.valueOf(this.state));
                if (!d.sQ(this.state)) {
                    synchronized (this.lock) {
                        this.ovt = MediaCodec.createDecoderByType(this.ovp);
                        a(this.ovt);
                        this.ovt.start();
                        this.apM = this.ovt.getInputBuffers();
                        this.agD = this.ovt.getOutputBuffers();
                    }
                    j = bi.Wz();
                }
                setState(1);
                x.i("MicroMsg.TrackDataSource", "%s finish to prepare cost[%d %d %d]", atw(), Long.valueOf(bi.bB(Wz)), Long.valueOf(Wz2 - Wz), Long.valueOf(j - Wz));
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.TrackDataSource", "%s prepare init decoder error %s", atw(), e.toString());
                this.ovj.FK(bae());
                return false;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s prepare init extractor error", atw());
            this.ovj.FJ(e2.toString());
            return false;
        } catch (Throwable e22) {
            x.e("MicroMsg.TrackDataSource", "%s prepare init extractor error %s", atw(), e22.toString());
            this.ovj.FJ(e22.toString());
            return false;
        }
    }

    protected final int x(long j, long j2) {
        g gVar;
        String bae;
        x.d("MicroMsg.TrackDataSource", "%s start to do some work time[%d %d] state %d", atw(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.state));
        if (this.ovt != null) {
            do {
                try {
                    if (d(j, j2)) {
                    }
                } catch (Throwable e) {
                    if (this.ovu) {
                        x.e("MicroMsg.TrackDataSource", "%s do some work drain output buffer error %s", atw(), e.toString());
                    } else {
                        this.ovu = true;
                        x.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s do some work drain output buffer error", atw());
                    }
                    if (!d.sQ(this.state)) {
                        ban();
                    }
                    gVar = this.ovj;
                    bae = bae();
                    if (!gVar.ovi && gVar.ovd) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 158, 1, false);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(506), Long.valueOf(bi.Wx()), bae);
                        gVar.ovi = true;
                    }
                }
                break;
            } while (!d.sQ(this.state));
            try {
                x.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", atw(), Integer.valueOf(this.apO), Integer.valueOf(this.state), Boolean.valueOf(this.ovl));
                if (d.sQ(this.state) || this.ovl) {
                    x.i("MicroMsg.TrackDataSource", "%s feed input buffer is end.", atw());
                } else {
                    if (this.apO < 0) {
                        this.apO = this.ovt.dequeueInputBuffer(0);
                        if (this.apO < 0) {
                            x.d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer", atw());
                        }
                    }
                    ByteBuffer byteBuffer = this.apM[this.apO];
                    int w;
                    long j3;
                    int i;
                    if (this.ovs != null) {
                        w = this.ovs.w(byteBuffer);
                        j3 = this.ovs.ouT.ihz;
                        i = this.ovs.ouT.ihA;
                        x.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", atw(), Integer.valueOf(this.apO), Integer.valueOf(w), Long.valueOf(j3), Integer.valueOf(i));
                        if (w <= 0) {
                            this.ovt.queueInputBuffer(this.apO, 0, 0, 0, 4);
                            this.ovl = true;
                        } else {
                            this.ovt.queueInputBuffer(this.apO, 0, w, j3, 0);
                            this.apO = -1;
                            f fVar = this.ovs;
                            fVar.ouU++;
                            if (fVar.ouU < fVar.ouV) {
                                fVar.ouT = (g) fVar.ihw.get(fVar.ouU);
                                x.d("MicroMsg.Mp4Extractor", "curr sample [%s]", fVar.ouT);
                            }
                        }
                    } else if (this.ovj.ovg) {
                        this.ovt.queueInputBuffer(this.apO, 0, 0, this.aqA * 1000, 4);
                        this.ovl = true;
                        this.ovj.ovg = false;
                    } else {
                        w = this.ovr.readSampleData(byteBuffer, 0);
                        j3 = this.ovr.getSampleTime();
                        x.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", atw(), Integer.valueOf(this.apO), Integer.valueOf(w), Long.valueOf(j3), Integer.valueOf(this.ovr.getSampleFlags()));
                        A(i, j3);
                        if (w <= 0) {
                            this.ovt.queueInputBuffer(this.apO, 0, 0, this.aqA * 1000, 4);
                            this.ovl = true;
                        } else {
                            this.ovt.queueInputBuffer(this.apO, 0, w, j3, 0);
                            this.apO = -1;
                            this.ovr.advance();
                            long sampleTime = this.ovr.getSampleTime();
                            if (this.ovj.ovf) {
                                if (this.ovn == 0) {
                                    if (y(j3, sampleTime)) {
                                        x.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", atw(), Long.valueOf(sampleTime), Long.valueOf(this.ovn));
                                        if (Math.abs(this.ovr.getSampleTime() - j3) >= 3000000) {
                                            x.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", atw(), Long.valueOf(this.ovr.getSampleTime()), Long.valueOf(j3));
                                            this.ovk.obtainMessage(5, -2, -2).sendToTarget();
                                        }
                                        bam();
                                    }
                                } else if (sampleTime < 0 || (sampleTime / 1000) + 1200 > this.ovn) {
                                    x.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", atw(), Long.valueOf(sampleTime), Long.valueOf(this.ovn));
                                    if (y(j3, -1)) {
                                        this.ovk.obtainMessage(5, -3, -3).sendToTarget();
                                    }
                                    bam();
                                }
                            } else if (y(j3, sampleTime)) {
                                x.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", atw(), Boolean.valueOf(this.ovj.ovf), Long.valueOf(sampleTime), Long.valueOf(this.ovn));
                                if (Math.abs(this.ovr.getSampleTime() - j3) >= 1000000) {
                                    x.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", atw(), Long.valueOf(this.ovr.getSampleTime()), Long.valueOf(j3));
                                    this.ovj.ovg = true;
                                }
                            }
                            x.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", atw(), Long.valueOf(j3), Long.valueOf(sampleTime));
                        }
                    }
                }
            } catch (Throwable e2) {
                if (this.ovv) {
                    x.e("MicroMsg.TrackDataSource", "%s do some work feed input buffer error %s", atw(), e2.toString());
                } else {
                    this.ovv = true;
                    x.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s do some work feed input buffer error", atw());
                }
                if (!d.sQ(this.state)) {
                    ban();
                }
                gVar = this.ovj;
                bae = bae();
                if (!gVar.ovh && gVar.ovd) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 157, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(505), Long.valueOf(bi.Wx()), bae);
                    gVar.ovh = true;
                }
            }
        }
        x.d("MicroMsg.TrackDataSource", "%s finish to do some work. state %d", atw(), Integer.valueOf(this.state));
        return this.state;
    }

    private boolean d(long j, long j2) {
        x.d("MicroMsg.TrackDataSource", "%s drain output buffer time[%d %d] index %d", atw(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.apP));
        if (this.apP < 0) {
            synchronized (this.lock) {
                this.apP = this.ovt.dequeueOutputBuffer(this.apy, 0);
            }
            if (this.apP >= 0) {
                if ((this.apy.flags & 4) != 0) {
                    x.i("MicroMsg.TrackDataSource", "%s process end of stream", atw());
                    setState(9);
                    this.apP = -1;
                    return false;
                }
                ByteBuffer byteBuffer = this.agD[this.apP];
                if (byteBuffer != null) {
                    byteBuffer.position(this.apy.offset);
                    byteBuffer.limit(this.apy.offset + this.apy.size);
                }
            } else if (this.apP == -2) {
                this.ovo = this.ovt.getOutputFormat();
                b(this.ovt);
                return true;
            } else if (this.apP == -3) {
                this.agD = this.ovt.getOutputBuffers();
                return true;
            } else {
                x.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d]", atw(), Integer.valueOf(this.apP));
                return false;
            }
        }
        if ((this.state == 1 ? 1 : null) != null) {
            setState(2);
        }
        x.d("MicroMsg.TrackDataSource", "%s process output buffer index %d ", atw(), Integer.valueOf(this.apP));
        synchronized (this.lock) {
            if (a(j, j2, this.ovt, this.agD[this.apP], this.apP, this.apy)) {
                this.apP = -1;
                return true;
            }
            return false;
        }
    }

    protected final boolean y(long j, long j2) {
        long Wz = bi.Wz();
        try {
            if ((j / 1000) + 1000 < this.aqA && j2 == -1) {
                this.ovj.ove = true;
                this.ovl = false;
                this.ovr.release();
                this.ovr = new MediaExtractor();
                this.ovr.setDataSource(this.path);
                this.ovr.selectTrack(this.ovq);
                this.ovr.seekTo(j, 2);
                long sampleTime = this.ovr.getSampleTime();
                x.w("MicroMsg.TrackDataSource", "%s it don't play end. currTime[%d] afterSeek[%d] nextSampleTime[%d] onlineCacheMs[%d] cost[%d]", atw(), Long.valueOf(j), Long.valueOf(sampleTime), Long.valueOf(j2), Long.valueOf(this.ovn), Long.valueOf(bi.bB(Wz)));
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.TrackDataSource", "%s reset extractor error %s", atw(), e.toString());
        }
        return false;
    }

    protected boolean A(int i, long j) {
        return false;
    }

    protected void b(MediaFormat mediaFormat, String str, int i) {
        x.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d]", atw(), str, Integer.valueOf(i));
        this.ovq = i;
        this.ovp = str;
        this.aqA = mediaFormat.getLong("durationUs") / 1000;
        this.ovo = mediaFormat;
    }

    protected void b(MediaCodec mediaCodec) {
    }

    protected void onStart() {
    }

    protected void onPause() {
    }

    protected final void setState(int i) {
        x.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", atw(), Integer.valueOf(this.state), Integer.valueOf(i));
        this.state = i;
    }

    public final String atw() {
        return bae() + "_" + this.ovj.atw();
    }
}
