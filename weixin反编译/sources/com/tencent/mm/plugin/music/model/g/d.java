package com.tencent.mm.plugin.music.model.g;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends b {
    MediaPlayer hZA = new j();
    a oRQ;
    boolean ozn = true;

    private class a implements Runnable {
        boolean isStop;

        private a() {
            this.isStop = true;
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        public final void run() {
            x.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (d.this.hZA != null && d.this.hZA.isPlaying()) {
                        int currentPosition = d.this.hZA.getCurrentPosition();
                        int duration = d.this.hZA.getDuration();
                        if (currentPosition > 0 && duration > 0) {
                            d.this.tX((currentPosition * 100) / duration);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "onPlayUpdate", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "sleep", new Object[0]);
                }
            }
        }
    }

    public d() {
        this.hZA.setAudioStreamType(3);
        this.hZA.setOnCompletionListener(new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                x.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
                d.this.hb(true);
            }
        });
        this.hZA.setOnSeekCompleteListener(new OnSeekCompleteListener() {
            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                if (d.this.hZA != null && d.this.hZA.isPlaying()) {
                    x.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
                    try {
                        d.this.hZA.start();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                    }
                }
            }
        });
        this.hZA.setOnPreparedListener(new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                if (d.this.hZA != null) {
                    x.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
                    try {
                        d.this.hZA.start();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                    }
                    d.this.ozn = false;
                    d.this.onStart();
                    if (d.this.oRQ != null) {
                        d.this.oRQ.isStop = true;
                    }
                    d.this.oRQ = new a(d.this, (byte) 0);
                    Runnable runnable = d.this.oRQ;
                    runnable.isStop = false;
                    e.post(runnable, "music_play_progress_runnable");
                }
            }
        });
        this.hZA.setOnErrorListener(new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                x.e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
                d.this.ha(false);
                return false;
            }
        });
    }

    public final boolean isPlaying() {
        boolean z = false;
        try {
            return this.hZA.isPlaying();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[z]);
            return z;
        }
    }

    public final boolean bfe() {
        return !this.ozn;
    }

    public final void Ha(String str) {
        x.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", str);
        try {
            this.hZA.setDataSource(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[0]);
        }
    }

    public final int bff() {
        return this.hZA.getCurrentPosition();
    }

    public final int getDuration() {
        return this.hZA.getDuration();
    }

    public final void play() {
        x.i("MicroMsg.Music.MMMediaPlayer", "play");
        if (bfe()) {
            try {
                if (!this.hZA.isPlaying()) {
                    this.hZA.start();
                    return;
                }
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                return;
            }
        }
        try {
            this.hZA.prepareAsync();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "prepareAsync", new Object[0]);
        }
    }

    public final void stop() {
        x.i("MicroMsg.Music.MMMediaPlayer", "stop");
        this.ozn = true;
        try {
            if (this.hZA != null) {
                this.hZA.stop();
                this.hZA.release();
            }
            if (this.oRQ != null) {
                this.oRQ.isStop = true;
                this.oRQ = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "stop", new Object[0]);
        }
        hb(false);
    }

    public final void pause() {
        x.i("MicroMsg.Music.MMMediaPlayer", "pause");
        if (bfe()) {
            this.hZA.pause();
        }
    }

    public final void seek(long j) {
        x.i("MicroMsg.Music.MMMediaPlayer", "seek %d", Long.valueOf(j));
        this.hZA.seekTo((int) j);
    }

    public final String bfg() {
        return null;
    }
}
