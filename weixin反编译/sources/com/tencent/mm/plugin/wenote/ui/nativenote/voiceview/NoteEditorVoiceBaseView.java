package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.o.a;
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;

public class NoteEditorVoiceBaseView extends TextView implements a {
    private boolean bgH = false;
    private Context context;
    private int duration = -1;
    public int fws;
    private AlphaAnimation pMj;
    private AnimationDrawable pMk;
    public String path = "";

    static /* synthetic */ void c(NoteEditorVoiceBaseView noteEditorVoiceBaseView) {
        x.d("MicroMsg.NoteEditorVoiceBaseView", "start play, path[%s] voiceType[%d]", noteEditorVoiceBaseView.path, Integer.valueOf(noteEditorVoiceBaseView.fws));
        if (!a.bYD().startPlay(noteEditorVoiceBaseView.path, noteEditorVoiceBaseView.fws)) {
            Toast.makeText(noteEditorVoiceBaseView.getContext(), R.l.ehi, 1).show();
        } else if (!noteEditorVoiceBaseView.bgH) {
            noteEditorVoiceBaseView.bgH = true;
            noteEditorVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(noteEditorVoiceBaseView.pMk, null, null, null);
            noteEditorVoiceBaseView.pMk.stop();
            noteEditorVoiceBaseView.pMk.start();
        }
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bnP();
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        bnP();
    }

    private void bnP() {
        this.pMj = new AlphaAnimation(0.1f, 1.0f);
        this.pMj.setDuration(1000);
        this.pMj.setRepeatCount(-1);
        this.pMj.setRepeatMode(2);
        this.pMk = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.k.dxC);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pMk.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxD);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pMk.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxE);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pMk.addFrame(drawable, 300);
        this.pMk.setOneShot(false);
        this.pMk.setVisible(true, true);
    }

    public final void bnQ() {
        if (this.pMj != null && this.pMj.isInitialized()) {
            setAnimation(null);
        }
        this.bgH = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.dxB), null, null, null);
        this.pMk.stop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String str = "MicroMsg.NoteEditorVoiceBaseView";
                String str2 = "clicked path:%s, player isPlay:%s, path:%s";
                Object[] objArr = new Object[3];
                objArr[0] = NoteEditorVoiceBaseView.this.path;
                objArr[1] = a.bYD().aJh() ? "true" : "false";
                objArr[2] = a.bYD().path;
                x.i(str, str2, objArr);
                if (!a.aW(NoteEditorVoiceBaseView.this.context) && !a.aU(NoteEditorVoiceBaseView.this.context)) {
                    if (!f.zl() && !bi.oN(NoteEditorVoiceBaseView.this.path)) {
                        u.fJ(view.getContext());
                    } else if (!k.bWD().kKa) {
                        if (bi.aD(NoteEditorVoiceBaseView.this.path, "").equals(a.bYD().path) && a.bYD().aJh()) {
                            NoteEditorVoiceBaseView noteEditorVoiceBaseView = NoteEditorVoiceBaseView.this;
                            x.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
                            noteEditorVoiceBaseView.bnQ();
                            a.bYD().stopPlay();
                            return;
                        }
                        NoteEditorVoiceBaseView.c(NoteEditorVoiceBaseView.this);
                    }
                }
            }
        });
    }

    public final void RF(String str) {
        x.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (!bi.aD(str, "").equals(this.path)) {
            bnQ();
        }
    }

    public final void bYC() {
        bnQ();
    }
}
