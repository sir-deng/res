package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.api.b;
import com.tencent.mm.api.d;
import com.tencent.mm.api.i;
import com.tencent.mm.api.o;
import com.tencent.mm.bi.a.c;
import com.tencent.mm.bi.a.e;
import com.tencent.mm.bi.a.f;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.footer.SelectColorBar;

public abstract class a extends b implements OnGlobalLayoutListener {
    private com.tencent.mm.api.m.a fdS;
    public boolean fdW = true;
    private com.tencent.mm.view.b.a fdz;
    private com.tencent.mm.bn.b fio;
    private View jTg;
    protected d[] zMk;
    private View zMl;
    private com.tencent.mm.view.footer.a zMm;
    private View zMn;
    private View zMo;
    public ChatFooterPanel zMp;
    private EditText zMq;
    private boolean zMr = true;

    protected abstract com.tencent.mm.view.b.a cAT();

    protected abstract com.tencent.mm.view.footer.a cAU();

    public abstract d[] cdR();

    public a(Context context, com.tencent.mm.api.m.a aVar) {
        super(context);
        this.fdS = aVar;
        cBc().a(this.fdS);
        removeAllViews();
        addView(cAW(), new LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, (int) getResources().getDimension(c.vhQ));
        layoutParams.gravity = 80;
        addView(cAX(), layoutParams);
        addView(cAV(), layoutParams);
        layoutParams = new LayoutParams(-1, -1);
        cAZ().setVisibility(8);
        addView(cAZ(), layoutParams);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        cBa().setVisibility(8);
        addView(cBa(), layoutParams);
        layoutParams = new LayoutParams(-1, (int) getResources().getDimension(c.vhO));
        layoutParams.gravity = 80;
        addView(cBb(), layoutParams);
        layoutParams = new LayoutParams(-1, (int) getResources().getDimension(c.buG));
        layoutParams.gravity = 48;
        if (this.fdS.fdW) {
            addView(cAY(), layoutParams);
        }
    }

    public final <T extends com.tencent.mm.view.footer.a> T cAV() {
        if (this.zMm == null) {
            this.zMm = cAU();
        }
        return this.zMm;
    }

    public final <T extends com.tencent.mm.view.b.a> T cAW() {
        if (this.fdz == null) {
            this.fdz = cAT();
        }
        return this.fdz;
    }

    public final View cAX() {
        if (this.zMl == null) {
            this.zMl = LayoutInflater.from(getContext()).inflate(f.vim, null);
            this.zMl.setVisibility(0);
        }
        return this.zMl;
    }

    public final View cAY() {
        if (this.jTg == null) {
            this.jTg = LayoutInflater.from(getContext()).inflate(f.vin, null);
            this.jTg.findViewById(e.oKg).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (a.this.cAZ().getVisibility() == 0) {
                        a.this.cBc().a(a.this.zMq.getText(), a.this.zMq.getCurrentTextColor());
                    } else {
                        a.this.cBc().onFinish();
                    }
                }
            });
            this.jTg.findViewById(e.oKf).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (a.this.cAZ().getVisibility() == 0) {
                        a.this.cBc().cdT();
                    } else {
                        a.this.cBc().sX();
                    }
                }
            });
        }
        return this.jTg;
    }

    public final View cAZ() {
        if (this.zMn == null) {
            this.zMn = LayoutInflater.from(getContext()).inflate(f.vil, null);
            this.zMq = (EditText) this.zMn.findViewById(e.gYg);
            SelectColorBar selectColorBar = (SelectColorBar) this.zMn.findViewById(e.vik);
            this.zMq.setTextColor(-1);
            selectColorBar.HN(-1);
            selectColorBar.zOV = new com.tencent.mm.view.footer.SelectColorBar.a() {
                public final void HH(int i) {
                    a.this.zMq.setTextColor(i);
                }
            };
        }
        return this.zMn;
    }

    public final View cBa() {
        if (this.zMn == null) {
            this.zMo = LayoutInflater.from(getContext()).inflate(f.vio, null);
        }
        return this.zMo;
    }

    public final View cBb() {
        boolean z = false;
        if (this.zMp == null) {
            try {
                this.zMp = o.fed.ak(getContext());
                this.zMp.ej(ChatFooterPanel.vqo);
                this.zMp.setBackgroundResource(com.tencent.mm.bi.a.d.bzZ);
                this.zMp.tl();
                this.zMp.aH(true);
                this.zMp.g(true, true);
                this.zMp.setVisibility(8);
                this.zMp.onResume();
                com.tencent.mm.pluginsdk.ui.chat.f to = o.fed.to();
                to.fec = new com.tencent.mm.api.n.a() {
                    public final void a(i iVar) {
                        x.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", iVar);
                        a.this.cBc().c(iVar);
                        onHide();
                    }

                    public final void onHide() {
                        a.this.aE(true);
                        a.this.nP(true);
                        a.this.aD(true);
                    }
                };
                this.zMp.a(to);
            } catch (Exception e) {
                String str = "MicroMsg.BaseDrawingView";
                String str2 = "exception:%s,getContext() is null?";
                Object[] objArr = new Object[2];
                objArr[0] = e.getMessage();
                if (getContext() == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                x.e(str, str2, objArr);
                throw e;
            }
        }
        return this.zMp;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() {
            public final void run() {
                a.this.cBc().onAttachedToWindow();
            }
        });
    }

    public final com.tencent.mm.bn.b cBc() {
        if (this.fio == null) {
            this.fio = new com.tencent.mm.bn.a();
            this.fio.a(this);
        }
        return this.fio;
    }

    public final void a(com.tencent.mm.api.e eVar) {
        cBc().a(eVar);
    }

    public final void aC(boolean z) {
        cBc().aC(z);
    }

    public final void aD(boolean z) {
        if (this.zMr != z) {
            com.tencent.mm.view.footer.a cAV = cAV();
            Animation loadAnimation;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(cAV.getContext(), com.tencent.mm.bi.a.a.bpO);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        a.this.setVisibility(0);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                cAV.startAnimation(loadAnimation);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(cAV.getContext(), com.tencent.mm.bi.a.a.bpP);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        a.this.setVisibility(8);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                cAV.startAnimation(loadAnimation);
            }
            Animation loadAnimation2;
            if (z) {
                loadAnimation2 = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bi.a.a.bpO);
                loadAnimation2.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        a.this.cAX().setVisibility(0);
                        a.this.cAY().setVisibility(0);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                cAY().startAnimation(loadAnimation2);
            } else {
                loadAnimation2 = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bi.a.a.bpP);
                loadAnimation2.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        a.this.cAX().setVisibility(8);
                        a.this.cAY().setVisibility(8);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                cAY().startAnimation(loadAnimation2);
            }
            this.zMr = z;
        }
    }

    public final void aE(boolean z) {
        if (this.fdW == z) {
            x.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
            return;
        }
        this.fdW = z;
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bi.a.a.bpO);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    a.this.cAY().setVisibility(0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            cAY().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bi.a.a.bpP);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                a.this.cAY().setVisibility(8);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        cAY().startAnimation(loadAnimation);
    }

    public final void nP(boolean z) {
        x.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", Boolean.valueOf(z));
        Animation loadAnimation;
        if (this.zMp.getVisibility() == 0 && z) {
            this.zMp.setVisibility(8);
            loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bi.a.a.bqm);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    a.this.zMp.setVisibility(0);
                }

                public final void onAnimationEnd(Animation animation) {
                    a.this.zMp.setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.zMp.startAnimation(loadAnimation);
        } else if (this.zMp.getVisibility() == 8 && !z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bi.a.a.bqo);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    a.this.zMp.setVisibility(0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.zMp.startAnimation(loadAnimation);
        }
    }

    public void onGlobalLayout() {
        if (cAZ().getVisibility() == 0) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.zMq.postDelayed(new Runnable() {
                public final void run() {
                    int c;
                    Rect rect = new Rect();
                    a.this.getWindowVisibleDisplayFrame(rect);
                    boolean z = a.this.getBottom() - rect.bottom >= 300;
                    DisplayMetrics displayMetrics = a.this.getResources().getDisplayMetrics();
                    if (z) {
                        c = (displayMetrics.heightPixels - j.c(a.this.getContext(), false)) - ((int) a.this.getResources().getDimension(c.vhG));
                    } else {
                        c = displayMetrics.heightPixels - ((int) a.this.getResources().getDimension(c.vhG));
                    }
                    if (a.this.zMq.getHeight() != c) {
                        a.this.zMq.setHeight(c);
                    }
                    a.this.getViewTreeObserver().removeOnGlobalLayoutListener(a.this);
                    a.this.getViewTreeObserver().addOnGlobalLayoutListener(a.this);
                }
            }, 160);
        }
    }
}
