package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public final class a {

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$1 */
    static class AnonymousClass1 implements AnimationListener {
        final /* synthetic */ a soI;

        AnonymousClass1(a aVar) {
            this.soI = aVar;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.soI != null) {
                this.soI.bGy();
            }
            x.d("MicroMsg.VoiceViewAnimationHelper", "playTipAnim end");
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$5 */
    static class AnonymousClass5 implements AnimationListener {
        final /* synthetic */ a soI;

        AnonymousClass5(a aVar) {
            this.soI = aVar;
        }

        public final void onAnimationStart(Animation animation) {
            if (this.soI != null) {
                this.soI.bGx();
            }
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.soI != null) {
                this.soI.bGy();
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$7 */
    static class AnonymousClass7 implements AnimationListener {
        final /* synthetic */ a soI;

        AnonymousClass7(a aVar) {
            this.soI = aVar;
        }

        public final void onAnimationStart(Animation animation) {
            if (this.soI != null) {
                this.soI.bGx();
            }
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.soI != null) {
                this.soI.bGy();
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$6 */
    static class AnonymousClass6 implements AnimationListener {
        final /* synthetic */ a soI;

        AnonymousClass6(a aVar) {
            this.soI = aVar;
        }

        public final void onAnimationStart(Animation animation) {
            if (this.soI != null) {
                this.soI.bGx();
            }
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.soI != null) {
                this.soI.bGy();
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public interface a {
        void bGx();

        void bGy();
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$4 */
    static class AnonymousClass4 implements AnimationListener {
        final /* synthetic */ a soI;

        AnonymousClass4(a aVar) {
            this.soI = aVar;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.soI != null) {
                this.soI.bGy();
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public static void a(final View view, final a aVar) {
        float width = (float) view.getWidth();
        x.d("MicroMsg.VoiceViewAnimationHelper", "target " + width);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        final int i = (int) (width + ((float) iArr[0]));
        x.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i));
        view.getParent();
        Animation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (float) (-i), 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset(0);
        translateAnimation.setRepeatMode(-1);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (aVar != null) {
                    aVar.bGx();
                }
                x.d("MicroMsg.VoiceViewAnimationHelper", "onAnimationEnd ");
                Animation translateAnimation = new TranslateAnimation(0, (float) i, 0, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(200);
                translateAnimation.setStartOffset(0);
                translateAnimation.setRepeatMode(-1);
                translateAnimation.setRepeatCount(0);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        x.i("MicroMsg.VoiceViewAnimationHelper", "next end");
                        if (aVar != null) {
                            aVar.bGy();
                        }
                    }
                });
                view.startAnimation(translateAnimation);
            }
        });
        view.startAnimation(translateAnimation);
    }

    public static void a(View view, Context context, final a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.a.bpY);
        loadAnimation.setDuration(300);
        loadAnimation.setFillAfter(true);
        loadAnimation.setRepeatCount(0);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (aVar != null) {
                    aVar.bGy();
                }
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(loadAnimation);
    }
}
