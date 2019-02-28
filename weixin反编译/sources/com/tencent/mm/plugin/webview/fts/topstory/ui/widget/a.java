package com.tencent.mm.plugin.webview.fts.topstory.ui.widget;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.webview.fts.c.c;

public final class a {
    float jhy = 0.0f;
    View jwL;
    private GestureDetector jwN;
    int jwP = 0;
    public float jwQ = 0.0f;
    public int jwR = -1;
    public int jwS = 0;
    Runnable jwT = new Runnable() {
        public final void run() {
            a.this.twN.ahi();
        }
    };
    Context mContext;
    int twM = a.twR;
    b twN;
    public boolean twO;
    public boolean twP;

    private enum a {
        ;

        static {
            twR = 1;
            twS = 2;
            twT = 3;
            twU = 4;
            twV = new int[]{twR, twS, twT, twU};
        }
    }

    public a(Context context, View view, b bVar) {
        this.mContext = context;
        this.twN = bVar;
        this.jwL = view;
        this.jwN = new GestureDetector(this.mContext, new SimpleOnGestureListener() {
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                a.this.jwL.postDelayed(a.this.jwT, 200);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                a.this.jwL.removeCallbacks(a.this.jwT);
                a.this.twN.ahj();
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float f3 = 1.0f;
                if (!(motionEvent == null || motionEvent2 == null)) {
                    if (a.this.twM == a.twR) {
                        if (Math.abs(f) > Math.abs(f2)) {
                            a.this.twM = a.twU;
                        } else if (motionEvent.getX() < ((float) (a.this.jwL.getMeasuredWidth() / 2))) {
                            a.this.twM = a.twT;
                        } else {
                            a.this.twM = a.twS;
                        }
                    }
                    float x = motionEvent2.getX() - motionEvent.getX();
                    float y = motionEvent2.getY() - motionEvent.getY();
                    a aVar = a.this;
                    if (aVar.twM == a.twU) {
                        if (aVar.jwR == -1) {
                            aVar.twN.ahk();
                            aVar.jwR = aVar.twN.getCurrentPosition();
                        }
                        aVar.jwS = aVar.twN.e(aVar.jwR, x);
                    } else if (aVar.twM == a.twT && aVar.twP) {
                        x = (((y * -1.0f) / ((float) aVar.jwL.getMeasuredHeight())) * 1.2f) + aVar.jhy;
                        if (x < 0.0f) {
                            f3 = 0.0f;
                        } else if (x <= 1.0f) {
                            f3 = x;
                        }
                        c.g(aVar.mContext, f3);
                        aVar.twN.Z(f3);
                    } else if (aVar.twM == a.twS && aVar.twO) {
                        int i;
                        float f4 = y * -1.0f;
                        x = f4 / ((float) aVar.jwL.getMeasuredHeight());
                        AudioManager audioManager = (AudioManager) aVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        float f5 = (x * ((float) streamMaxVolume)) * 1.2f;
                        int i2 = (int) f5;
                        if (i2 == 0 && Math.abs(f5) > 0.2f) {
                            if (f4 > 0.0f) {
                                i = 1;
                            } else if (f4 < 0.0f) {
                                i = -1;
                            }
                            i += aVar.jwP;
                            if (i < 0) {
                                i = 0;
                            } else if (i >= streamMaxVolume) {
                                i = streamMaxVolume;
                            }
                            audioManager.setStreamVolume(3, i, 0);
                            aVar.twN.Y(((float) i) / ((float) streamMaxVolume));
                        }
                        i = i2;
                        i += aVar.jwP;
                        if (i < 0) {
                            i = 0;
                        } else if (i >= streamMaxVolume) {
                            i = streamMaxVolume;
                        }
                        audioManager.setStreamVolume(3, i, 0);
                        aVar.twN.Y(((float) i) / ((float) streamMaxVolume));
                    }
                }
                return true;
            }
        });
        this.jhy = c.bX(context);
    }

    public final void F(MotionEvent motionEvent) {
        if (this.twN.bQP()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.jwQ = motionEvent.getRawX();
                this.jwP = ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                this.jhy = c.bX(this.mContext);
            }
            this.jwN.onTouchEvent(motionEvent);
            if (actionMasked == 1 || actionMasked == 3) {
                if (this.twM == a.twU) {
                    this.twN.f(this.jwS, motionEvent.getRawX() - this.jwQ);
                    this.jwR = -1;
                    this.jwS = 0;
                    this.jwQ = 0.0f;
                } else if (this.twM == a.twS) {
                    ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                    this.twN.ahl();
                } else if (this.twM == a.twT) {
                    this.twN.ahm();
                }
                this.twM = a.twR;
                return;
            }
            return;
        }
        this.twM = a.twR;
    }
}
