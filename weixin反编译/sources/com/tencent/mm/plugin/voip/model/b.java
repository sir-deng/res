package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.Timer;
import java.util.TimerTask;

public final class b {
    private static float agB = 0.0f;
    AudioTrack afZ = null;
    Context context;
    private boolean flA = false;
    private Timer flz = null;
    private int gER = 3;
    int hYU = 2;
    private int hYV = 0;
    private int hYW = 0;
    private Runnable hYX;
    private int hYZ = 0;
    int hZa = 20;
    private boolean hZb = false;
    public boolean soN = false;
    boolean soO = false;
    boolean soP = true;
    e soQ = null;
    private int soR = 0;
    private byte[] soS = null;
    private byte[] soT = null;
    private byte[] soU = null;
    private byte[] soV = null;
    private byte[] soW = null;
    private int soX = 0;
    public a soY = null;
    private int soZ = 1;
    private int spa = 1;
    private int spb = 0;
    private int spc = 0;
    private int spd = 0;
    private int spe = 0;
    private int spf = 0;
    private int spg = 0;
    private int sph = 1;
    private int spi = 0;
    private long spj = 0;
    private long spk = 0;
    private int spl = 1;
    private int spm = 0;
    private int spn = -1;
    private int spo = 0;
    private long spp = 0;
    private int spq = 1;
    private int spr = 0;
    private final Object sps = new Object();
    private int spt = 0;
    private int spu = 0;
    private int spv = 0;
    private int spw = 0;
    private int spx = 0;

    class a extends TimerTask {
        a() {
        }

        public final void run() {
            System.currentTimeMillis();
            if (b.this.spb == 1 && b.this.soN) {
                System.currentTimeMillis();
                if (b.this.spe + b.this.hZa < b.this.soR && b.this.spx == 0) {
                    b.this.spw = 1;
                    int M = b.this.soY.M(b.this.soW, b.this.hZa);
                    b.this.spw = 0;
                    if (M < 0) {
                        x.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + M);
                        return;
                    }
                    synchronized (b.this.sps) {
                        System.arraycopy(b.this.soW, 0, b.this.soT, b.this.spe, b.this.hZa);
                        b.this.spe = b.this.spe + b.this.hZa;
                        b.this.spd = b.this.spd + (b.this.hZa >> 1);
                    }
                }
            }
        }
    }

    static /* synthetic */ void j(b bVar, int i) {
        if (bVar.spu != -1 && i < 0) {
            bVar.spu++;
            if (bVar.spu >= 50) {
                bVar.spt = 5;
                bVar.spu = -1;
            }
        }
    }

    public final int bGL() {
        return (this.spr / this.hZa) * this.hYW;
    }

    public final int l(Context context, boolean z) {
        x.d("MicroMsg.Voip.AudioPlayer", "enter to Init...");
        this.context = context;
        if (this.soX == 2) {
            this.hYU = 3;
        } else {
            this.hYU = 2;
        }
        this.hYZ = AudioTrack.getMinBufferSize(this.hYV, this.hYU, 2);
        if (this.hYZ == -2 || this.hYZ == -1) {
            this.spt = 1;
            return -1;
        }
        this.spg = this.hYZ;
        this.spm = this.spg * this.spl;
        this.hYZ *= this.spq;
        float f = ((float) (this.spg >> 1)) / ((float) this.hYV);
        int yw = m.yw();
        int i = q.gHG.gFk;
        if ((yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            x.i("MicroMsg.Voip.AudioPlayer", "CPU ARMv7, ablePlayTimer: " + i);
        } else {
            i = 0;
        }
        if (1000.0f * f < 60.0f || this.spv != 0) {
            i = 0;
        }
        this.soP = i != 0;
        x.d("MicroMsg.Voip.AudioPlayer", "playBufSize:" + this.hYZ + "  MinBufSizeInMs:" + f + ",bPlayTimer:" + this.soP);
        int jj = jj(z);
        try {
            if (this.afZ != null) {
                try {
                    this.afZ.release();
                } catch (Exception e) {
                }
            }
            this.afZ = new d(jj, this.hYV, this.hYU, 2, this.hYZ);
        } catch (Exception e2) {
            x.w("MicroMsg.Voip.AudioPlayer", "new AudioTrack:", e2);
            this.spt = 6;
        }
        if (this.afZ == null || this.afZ.getState() == 0) {
            this.spt = 2;
            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer audioTrack.getState() == AudioTrack.STATE_UNINITIALIZED");
            if (this.afZ != null) {
                this.afZ.release();
            }
            if (jj == 0) {
                this.afZ = new d(3, this.hYV, this.hYU, 2, this.hYZ);
            } else {
                this.afZ = new d(0, this.hYV, this.hYU, 2, this.hYZ);
            }
        }
        if (this.afZ == null) {
            this.spt = 3;
            x.e("MicroMsg.Voip.AudioPlayer", "null == audioTrack return");
            return -1;
        } else if (this.afZ.getState() == 0) {
            this.spt = 3;
            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.afZ.release();
            this.afZ = null;
            return -1;
        } else {
            this.soS = new byte[this.hYZ];
            if (this.soS == null) {
                x.e("MicroMsg.Voip.AudioPlayer", "null == playBuffer return");
                return -1;
            }
            this.soV = new byte[this.hZa];
            if (this.soV == null) {
                x.e("MicroMsg.Voip.AudioPlayer", "null == frmBuffer return");
                return -1;
            }
            if (this.soP) {
                this.soR = this.hYZ;
                this.soT = new byte[this.soR];
                if (this.soT == null) {
                    x.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBuffer return");
                    return -1;
                }
                this.soU = new byte[this.soR];
                if (this.soU == null) {
                    x.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBufferTmp return");
                    return -1;
                }
                this.soW = new byte[this.hZa];
                if (this.soW == null) {
                    x.e("MicroMsg.Voip.AudioPlayer", "null == frmTaskBuffer return");
                    return -1;
                }
            }
            this.soN = false;
            this.soO = false;
            x.i("MicroMsg.Voip.AudioPlayer", "dkbt AudioTrack init ok, mode:%d issp:%b m:%d size %d,nSamplerate:%d", Integer.valueOf(as.Hn().gDM.getMode()), Boolean.valueOf(as.Hn().gDM.isSpeakerphoneOn()), Integer.valueOf(jj), Integer.valueOf(this.hYZ), Integer.valueOf(this.hYV));
            return (this.hYZ * 1000) / (this.hYV * 2);
        }
    }

    public final boolean ji(boolean z) {
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
        int jj = jj(z);
        if (as.Hn().xS()) {
            jj = 0;
        }
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + z + ":streamtype:" + jj);
        if (this.afZ == null || jj != this.afZ.getStreamType()) {
            bGP();
            this.hZb = true;
            if (this.soX == 2) {
                this.hYU = 3;
            } else {
                this.hYU = 2;
            }
            this.hYZ = AudioTrack.getMinBufferSize(this.hYV, this.hYU, 2);
            if (this.hYZ == -2 || this.hYZ == -1) {
                this.hZb = false;
                return false;
            }
            this.spc = 0;
            this.spf = 0;
            this.sph = 1;
            this.spi = 0;
            this.spj = 0;
            this.spk = 0;
            this.spl = 1;
            this.spn = -1;
            this.spo = 0;
            this.spg = this.hYZ;
            this.spm = this.spg * this.spl;
            this.hYZ *= this.spq;
            x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.hYZ + "  MinBufSizeInMs:" + (((float) this.spg) / 16.0f));
            if (this.afZ != null) {
                try {
                    this.afZ.stop();
                } catch (Exception e) {
                    x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", e.getMessage());
                }
                this.afZ.release();
                this.afZ = null;
            }
            x.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", Integer.valueOf(as.Hn().gDM.getMode()), Boolean.valueOf(as.Hn().gDM.isSpeakerphoneOn()), Integer.valueOf(jj), Integer.valueOf(this.hYZ), Integer.valueOf(this.hYV));
            this.afZ = new d(jj, this.hYV, this.hYU, 2, this.hYZ);
            if (this.afZ == null || this.afZ.getState() != 0) {
                x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
                if (this.afZ != null) {
                    this.hZb = false;
                    bGN();
                    return true;
                }
                this.hZb = false;
                return false;
            }
            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.afZ.release();
            this.afZ = null;
            return false;
        }
        x.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
        return false;
    }

    private int jj(boolean z) {
        int i = 0;
        if (q.gHG.gEs > 0) {
            i = as.Hn().bc(z);
        } else if (q.gHG.gET >= 0) {
            i = q.gHG.gET;
        }
        if (z && q.gHG.gEU >= 0) {
            i = q.gHG.gEU;
        } else if (!z && q.gHG.gEV >= 0) {
            i = q.gHG.gEV;
        }
        if (1 != this.spv) {
            return i;
        }
        if (q.gHG.gFu >= 0) {
            i = q.gHG.gFu;
        }
        if (z && q.gHG.gFv >= 0) {
            return q.gHG.gFv;
        }
        if (z || q.gHG.gFw < 0) {
            return i;
        }
        return q.gHG.gFw;
    }

    public final int bGM() {
        if (this.afZ != null) {
            this.afZ.release();
            this.afZ = null;
        }
        this.soN = false;
        this.soO = false;
        return 1;
    }

    public final int Y(int i, int i2, int i3) {
        if (true == this.soN) {
            return 0;
        }
        this.hYV = i;
        this.soX = 1;
        this.hYW = i2;
        this.spv = i3;
        this.hZa = (((this.hYV / 1000) * 1) * this.hYW) * 2;
        this.spo = (this.hYV * 60) / 1000;
        return 1;
    }

    public final int bGN() {
        if (true == this.soN) {
            return 1;
        }
        if (this.afZ == null) {
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
            return 0;
        }
        this.soN = true;
        try {
            this.afZ.play();
        } catch (Exception e) {
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", e.getMessage());
        }
        if (this.afZ.getPlayState() != 3) {
            this.spt = 4;
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
            return 0;
        } else if (this.afZ.getState() == 0) {
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
            return 0;
        } else {
            if (this.soP) {
                int i;
                if (this.flA || this.flz != null) {
                    x.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.flA);
                    i = -1;
                } else {
                    this.flz = new Timer();
                    i = this.flz == null ? -1 : 0;
                }
                if (i != 0) {
                    x.e("MicroMsg.Voip.AudioPlayer", new StringBuilder("InitAudioRecTimer failed, error code = -1").toString());
                    return 0;
                }
                this.flz.scheduleAtFixedRate(new a(), 0, 20);
                this.flA = true;
            }
            this.hYX = new Runnable() {
                public final void run() {
                    Process.setThreadPriority(-19);
                    x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
                    int i = 0;
                    while (b.this.soN && b.this.afZ != null) {
                        int playbackHeadPosition;
                        int m;
                        try {
                            playbackHeadPosition = b.this.afZ.getPlaybackHeadPosition();
                        } catch (Exception e) {
                            x.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", e);
                            b.this.spt = 7;
                            playbackHeadPosition = 0;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        b.this.spf = b.this.spc - playbackHeadPosition;
                        if (b.this.sph == 1) {
                            b.this.spi = playbackHeadPosition;
                            b.this.spj = currentTimeMillis;
                            b.this.spk = currentTimeMillis;
                            b.this.sph = 0;
                            b.this.spp = currentTimeMillis;
                        } else {
                            m = playbackHeadPosition - b.this.spi;
                            if (m > b.this.spn) {
                                b.this.spn = m;
                            } else {
                                b.this.spn = (int) (((((float) b.this.spn) * 49999.0f) / 50000.0f) + (((float) m) / 50000.0f));
                            }
                            b.this.spp = currentTimeMillis;
                            if (b.this.spf == 0) {
                                b.this.spm = b.this.spm + b.this.spg;
                            } else if (currentTimeMillis > b.this.spk + 5000) {
                                b.this.spk = currentTimeMillis;
                                if (b.this.spn < (b.this.spm >> 1)) {
                                    b.this.spm = b.this.spm - (b.this.spg >> 2);
                                }
                                if (b.this.spn > b.this.spm) {
                                    b.this.spm = b.this.spn;
                                }
                            }
                            if (b.this.spm < b.this.spo) {
                                b.this.spm = b.this.spo;
                            }
                            if (b.this.spm < b.this.spg) {
                                b.this.spm = b.this.spg;
                            }
                            if (m > 0) {
                                b.this.spi = playbackHeadPosition;
                            }
                        }
                        if (playbackHeadPosition != 0 && b.this.soP) {
                            b.this.spb = 1;
                        }
                        if (b.this.soY != null) {
                            b.this.spr = b.this.spr + b.this.hZa;
                            if (b.this.spb == 0) {
                                playbackHeadPosition = b.this.soY.M(b.this.soV, b.this.hZa);
                            } else {
                                System.currentTimeMillis();
                                if (b.this.spe >= b.this.hZa) {
                                    synchronized (b.this.sps) {
                                        System.arraycopy(b.this.soT, 0, b.this.soV, 0, b.this.hZa);
                                        m = b.this.spe - b.this.hZa;
                                        System.arraycopy(b.this.soT, b.this.hZa, b.this.soU, 0, m);
                                        System.arraycopy(b.this.soU, 0, b.this.soT, 0, m);
                                        b.this.spe = b.this.spe - b.this.hZa;
                                    }
                                    playbackHeadPosition = 0;
                                } else if (b.this.spf >= (b.this.hYV * 5) / 1000 || b.this.spw != 0) {
                                    com.tencent.mm.plugin.voip.b.a.ze(2);
                                } else {
                                    b.this.spx = 1;
                                    playbackHeadPosition = b.this.soY.M(b.this.soV, b.this.hZa);
                                    b.this.spx = 0;
                                }
                            }
                            if (playbackHeadPosition < 0) {
                                com.tencent.mm.plugin.voip.b.a.ze(5);
                                x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + playbackHeadPosition);
                            } else if (b.this.hZb) {
                                x.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + b.this.hZb);
                                com.tencent.mm.plugin.voip.b.a.ze(10);
                            } else {
                                b.this.spj = currentTimeMillis;
                                if (b.this.hYZ < b.this.hZa) {
                                    System.arraycopy(b.this.soV, 0, b.this.soS, i, b.this.hYZ - i);
                                    playbackHeadPosition = b.this.afZ.write(b.this.soS, 0, b.this.soS.length);
                                    if (playbackHeadPosition < 0) {
                                        b.j(b.this, playbackHeadPosition);
                                        x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + playbackHeadPosition);
                                    }
                                    b.this.spc = b.this.spc + (b.this.soS.length >> 1);
                                    playbackHeadPosition = b.this.hYZ - i;
                                    i = b.this.hZa - playbackHeadPosition;
                                    while (i >= b.this.hYZ) {
                                        b.this.afZ.write(b.this.soV, playbackHeadPosition, b.this.hYZ);
                                        playbackHeadPosition += b.this.hYZ;
                                        i -= b.this.hYZ;
                                        b.this.spc = b.this.spc + (b.this.hYZ >> 1);
                                    }
                                    System.arraycopy(b.this.soV, playbackHeadPosition, b.this.soS, 0, i);
                                } else if (!b.this.hZb) {
                                    playbackHeadPosition = b.this.afZ.write(b.this.soV, 0, b.this.hZa);
                                    if (playbackHeadPosition < 0) {
                                        b.j(b.this, playbackHeadPosition);
                                        x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + playbackHeadPosition);
                                    }
                                    b.this.spc = b.this.spc + (b.this.hZa >> 1);
                                }
                            }
                        } else {
                            com.tencent.mm.plugin.voip.b.a.ze(10);
                        }
                    }
                }
            };
            e.b(this.hYX, "AudioPlayer_play", 10);
            return 1;
        }
    }

    public final int bGO() {
        if (this.afZ == null) {
            x.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.spg + ",nSamplerate:" + this.hYV);
            return (this.spg * 1000) / this.hYV;
        } else if (!this.soN || this.afZ.getState() == 0) {
            return (this.spg * 1000) / this.hYV;
        } else {
            try {
                return ((this.spc - this.afZ.getPlaybackHeadPosition()) * 1000) / this.hYV;
            } catch (Exception e) {
                x.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", e.getMessage());
                return (this.spg * 1000) / this.hYV;
            }
        }
    }

    public final int bGP() {
        if (this.flA && this.flz != null) {
            this.flz.cancel();
            this.flA = false;
        }
        if (this.soN) {
            this.soN = false;
            this.spr = 0;
            try {
                if (this.hYX != null) {
                    e.S(this.hYX);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Voip.AudioPlayer", e, "", new Object[0]);
            }
            try {
                if (this.afZ != null) {
                    this.afZ.stop();
                    this.afZ.release();
                    x.i("MicroMsg.Voip.AudioPlayer", "StopPlay stop audioTrack");
                }
            } catch (Exception e2) {
                x.e("MicroMsg.Voip.AudioPlayer", "StopPlay audioTrack.stop Exception:%s", e2.getMessage());
            }
        }
        return 1;
    }

    public final int bGQ() {
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.spt);
        return this.spt;
    }

    public final int bGR() {
        if (this.afZ != null) {
            return this.afZ.getStreamType();
        }
        return jj(true);
    }
}
