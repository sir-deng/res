package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.a.f;

public class VoiceSearchEditText extends EditText {
    private Context context;
    public String khu = "";
    private OnClickListener ugx;
    final Drawable yql = getResources().getDrawable(f.gWQ);
    final Drawable yqm = null;
    final Drawable yqn = getResources().getDrawable(f.gWH);
    private boolean yqo = true;
    private boolean yqp = false;
    private boolean yqq = false;

    static /* synthetic */ void e(VoiceSearchEditText voiceSearchEditText) {
        x.d("MicroMsg.VoiceSearchEditText", "checkView");
        if (voiceSearchEditText.getText().toString().equals("") && voiceSearchEditText.yqp) {
            voiceSearchEditText.yqo = true;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.yqm, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.yql, voiceSearchEditText.getCompoundDrawables()[3]);
        } else if (voiceSearchEditText.getText().toString().length() > 0) {
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.yqm, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.yqn, voiceSearchEditText.getCompoundDrawables()[3]);
        } else {
            voiceSearchEditText.yqo = false;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.yqm, voiceSearchEditText.getCompoundDrawables()[1], null, voiceSearchEditText.getCompoundDrawables()[3]);
        }
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.yqp = false;
        this.yql.setBounds(0, 0, this.yql.getIntrinsicWidth(), this.yql.getIntrinsicHeight());
        this.yqn.setBounds(0, 0, this.yqn.getIntrinsicWidth(), this.yqn.getIntrinsicHeight());
        this.yqo = true;
        if (this.yqp) {
            setCompoundDrawables(this.yqm, getCompoundDrawables()[1], this.yql, getCompoundDrawables()[3]);
        } else if (getText().toString().length() > 0) {
            setCompoundDrawables(this.yqm, getCompoundDrawables()[1], this.yqn, getCompoundDrawables()[3]);
        } else {
            setCompoundDrawables(this.yqm, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        }
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                View view2 = VoiceSearchEditText.this;
                if (view2.getCompoundDrawables()[2] == null) {
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return true;
                }
                VoiceSearchEditText.this.yqq = true;
                if (VoiceSearchEditText.this.yqo && VoiceSearchEditText.this.yqp && view2.getText().toString().equals("")) {
                    if (motionEvent.getX() <= ((float) (((view2.getWidth() - view2.getPaddingRight()) - VoiceSearchEditText.this.yql.getIntrinsicWidth()) - a.fromDPToPix(view2.context, 25)))) {
                        view2.requestFocus();
                        if (VoiceSearchEditText.this.getContext() instanceof Activity) {
                            MMActivity.showVKB((Activity) VoiceSearchEditText.this.getContext());
                        }
                        if (VoiceSearchEditText.this.ugx != null) {
                            VoiceSearchEditText.this.ugx.onClick(null);
                        }
                    } else if (VoiceSearchEditText.this.ugx != null) {
                        x.i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
                        if (VoiceSearchEditText.this.getContext() instanceof MMActivity) {
                            ((MMActivity) VoiceSearchEditText.this.getContext()).df(view2);
                        }
                        VoiceSearchEditText.this.ugx.onClick(VoiceSearchEditText.this);
                        return true;
                    }
                } else if (view2.getText().toString().length() > 0) {
                    if (motionEvent.getX() > ((float) (((view2.getWidth() - view2.getPaddingRight()) - VoiceSearchEditText.this.yqn.getIntrinsicWidth()) - a.fromDPToPix(view2.context, 25)))) {
                        view2.setText("");
                        VoiceSearchEditText.e(VoiceSearchEditText.this);
                    } else if (!view2.isFocused()) {
                        view2.requestFocus();
                        if (VoiceSearchEditText.this.getContext() instanceof Activity) {
                            MMActivity.showVKB((Activity) VoiceSearchEditText.this.getContext());
                        }
                    }
                } else if (VoiceSearchEditText.this.ugx != null) {
                    VoiceSearchEditText.this.ugx.onClick(null);
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                VoiceSearchEditText.this.yqq = true;
                VoiceSearchEditText.e(VoiceSearchEditText.this);
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                x.d("MicroMsg.VoiceSearchEditText", "onFocusChange hasFocus = [%s], currentFocusState = [%s]", Boolean.valueOf(z), Boolean.valueOf(VoiceSearchEditText.this.yqq));
                if (!z && VoiceSearchEditText.this.yqq) {
                    VoiceSearchEditText.e(VoiceSearchEditText.this);
                    VoiceSearchEditText.this.yqq = false;
                }
            }
        });
        if (context instanceof Activity) {
            View currentFocus = ((Activity) context).getCurrentFocus();
            if (currentFocus == null || currentFocus != this) {
                this.yqq = false;
            } else {
                this.yqq = true;
            }
        }
        requestFocus();
    }
}
