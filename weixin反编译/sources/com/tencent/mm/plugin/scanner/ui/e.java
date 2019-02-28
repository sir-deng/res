package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    private Context context;
    private TextView ikn;
    String mTitle;
    private View mView;
    private OnTouchListener oEW;
    private TextView ppv;
    private final int qbc = 5;
    private TextView qbd;
    public boolean qbe = false;
    public boolean qbf = false;
    private Boolean qbg;
    private OnGlobalLayoutListener qbh;
    a qbi;

    public interface a {
        Boolean Ji(String str);

        void a(String str, Boolean bool);

        void bpN();
    }

    public e(Activity activity) {
        super(activity);
        setLayoutResource(R.i.dnX);
        this.context = activity;
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.ikn == null) {
            this.ikn = (TextView) view.findViewById(16908310);
        }
        if (this.ppv == null) {
            this.ppv = (TextView) view.findViewById(16908304);
        }
        if (this.qbd == null) {
            this.qbd = (TextView) view.findViewById(R.h.cxl);
        }
        if (this.oEW == null) {
            this.oEW = new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        x.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
                        e.this.qbd.setVisibility(4);
                        e.this.ppv.setMaxLines(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
                        e.this.qbe = true;
                        if (e.this.qbi != null) {
                            e.this.qbi.a(e.this.idX, Boolean.valueOf(true));
                            e.this.qbi.bpN();
                        }
                    }
                    return false;
                }
            };
            this.qbd.setOnTouchListener(this.oEW);
        }
        if (this.qbi != null) {
            this.qbg = this.qbi.Ji(this.idX);
            if (this.qbg == null) {
                this.qbd.setVisibility(8);
                this.ppv.setMaxLines(6);
            } else if (this.qbg.booleanValue()) {
                this.qbd.setVisibility(8);
                this.ppv.setMaxLines(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
            } else {
                this.qbd.setVisibility(0);
                this.ppv.setMaxLines(5);
            }
        } else {
            this.qbd.setVisibility(8);
            this.ppv.setMaxLines(6);
        }
        if (this.qbh == null) {
            this.qbh = new OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    x.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + e.this.ppv.getHeight() + ", summaryTv.getLineHeight() = " + e.this.ppv.getLineHeight());
                    if (e.this.ppv.getText() != null && e.this.ppv.getHeight() > 0 && e.this.ppv.getLineHeight() > 0 && e.this.qbg == null) {
                        if (!(e.this.ppv.getHeight() / e.this.ppv.getLineHeight() <= 5 || e.this.qbf || e.this.qbe)) {
                            e.this.qbd.setVisibility(0);
                            e.this.ppv.setMaxLines(5);
                            e.this.qbf = true;
                            if (e.this.qbi != null && e.this.qbi.Ji(e.this.idX) == null) {
                                e.this.qbi.a(e.this.idX, Boolean.valueOf(false));
                                e.this.qbi.bpN();
                            }
                        }
                        x.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + (e.this.ppv.getHeight() / e.this.ppv.getLineHeight()));
                    }
                    e.this.ppv.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            };
            this.ppv.getViewTreeObserver().addOnGlobalLayoutListener(this.qbh);
        }
        if (bi.oN(this.mTitle)) {
            this.ikn.setVisibility(8);
            return;
        }
        this.ikn.setText(this.mTitle);
        this.ikn.setVisibility(0);
    }
}
