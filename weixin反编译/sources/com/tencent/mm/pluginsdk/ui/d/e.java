package com.tencent.mm.pluginsdk.ui.d;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.b;

public final class e extends b {
    private l vBc;

    public e(NeatTextView neatTextView, l lVar) {
        super(neatTextView.getContext(), neatTextView);
        this.vBc = lVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        view.setTag(com.tencent.mm.plugin.comm.a.e.cSM, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        if (view instanceof NeatTextView) {
            NeatTextView neatTextView = (NeatTextView) view;
            if (!neatTextView.czE() || neatTextView.zFV) {
                if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    neatTextView.zUC.setPressed(false);
                } else if (motionEvent.getAction() == 0) {
                    neatTextView.zUC.setPressed(true);
                }
                return this.vBc.onTouch(neatTextView.zUC, motionEvent);
            }
        }
        return super.onTouch(view, motionEvent);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        boolean onDown = super.onDown(motionEvent);
        if (this.zUR != null) {
            CharacterStyle characterStyle = this.zUR.zTD;
            if (characterStyle instanceof m) {
                ((m) characterStyle).oFf = true;
            }
        }
        return onDown;
    }

    protected final void cancel(int i) {
        if (this.zUR != null) {
            CharacterStyle characterStyle = this.zUR.zTD;
            if (characterStyle instanceof m) {
                ((m) characterStyle).oFf = false;
                if (i == 1) {
                    this.mView.performLongClick();
                }
            }
        }
        super.cancel(i);
    }
}
