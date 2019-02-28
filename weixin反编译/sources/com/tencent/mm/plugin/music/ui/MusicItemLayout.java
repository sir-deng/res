package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MusicItemLayout extends LinearLayout {
    private GestureDetector mbL;

    private class a extends SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(MusicItemLayout musicItemLayout, byte b) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) > Math.abs(f)) {
                com.tencent.mm.plugin.music.ui.b.a aVar = (com.tencent.mm.plugin.music.ui.b.a) MusicItemLayout.this.getTag();
                if (f2 > 0.0f) {
                    aVar.bfp();
                } else {
                    aVar.bfo();
                }
            }
            return false;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            com.tencent.mm.plugin.music.ui.b.a aVar = (com.tencent.mm.plugin.music.ui.b.a) MusicItemLayout.this.getTag();
            if (aVar.bfn()) {
                if (motionEvent.getY() <= ((float) aVar.oTa.getMeasuredHeight()) && motionEvent.getY() > 100.0f) {
                    aVar.bfq();
                }
            } else if (motionEvent.getY() >= aVar.oTd.getY() - 100.0f && motionEvent.getY() < ((float) aVar.oTd.getMeasuredHeight()) + aVar.oTd.getY()) {
                aVar.bfq();
            }
            return false;
        }
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.mbL = new GestureDetector(getContext(), new a());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.tencent.mm.plugin.music.ui.b.a aVar = (com.tencent.mm.plugin.music.ui.b.a) getTag();
        if (!aVar.bfn()) {
            Object obj;
            if (aVar.oTb.getX() <= motionEvent.getX() && motionEvent.getX() <= aVar.oTb.getX() + ((float) aVar.oTb.getMeasuredWidth()) && aVar.oTb.getY() <= motionEvent.getY()) {
                if (motionEvent.getY() <= ((float) aVar.oTb.getMeasuredHeight()) + aVar.oTb.getY()) {
                    obj = 1;
                    if (obj == null) {
                        return true;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mbL.onTouchEvent(motionEvent);
        return true;
    }
}
