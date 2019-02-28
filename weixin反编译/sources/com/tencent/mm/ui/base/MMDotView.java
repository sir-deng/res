package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.m;

public class MMDotView extends LinearLayout {
    int gDq = 9;
    public int yiD = f.gWG;
    public int yiE = f.bEy;

    @TargetApi(11)
    public MMDotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public MMDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faU);
        int resourceId = obtainStyledAttributes.getResourceId(m.haP, 0);
        obtainStyledAttributes.recycle();
        Fa(resourceId);
    }

    public final void Fa(int i) {
        x.v("MicroMsg.MMDotView", "setDotCount:%d", Integer.valueOf(i));
        if (i >= 0) {
            ImageView imageView;
            if (i > this.gDq) {
                x.i("MicroMsg.MMDotView", "large than max count");
                i = this.gDq;
            }
            removeAllViews();
            for (i = 
/*
Method generation error in method: com.tencent.mm.ui.base.MMDotView.Fa(int):void, dex: classes4.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r6_2 'i' int) = (r6_0 'i' int), (r6_1 'i' int) binds: {(r6_0 'i' int)=B:3:0x0018, (r6_1 'i' int)=B:4:0x001a} in method: com.tencent.mm.ui.base.MMDotView.Fa(int):void, dex: classes4.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:183)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:186)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 22 more

*/

            public final void Fb(int i) {
                int i2 = 0;
                x.v("MicroMsg.MMDotView", "setSelectedDot:target index is %d", Integer.valueOf(i));
                if (i >= getChildCount()) {
                    i = getChildCount() - 1;
                } else if (i < 0) {
                    i = 0;
                }
                x.v("MicroMsg.MMDotView", "setSelectedDot:after adjust index is %d", Integer.valueOf(i));
                while (true) {
                    int i3 = i2;
                    if (i3 >= getChildCount()) {
                        break;
                    }
                    ((ImageView) getChildAt(i3)).setImageResource(this.yiD);
                    i2 = i3 + 1;
                }
                ImageView imageView = (ImageView) getChildAt(i);
                if (imageView != null) {
                    imageView.setImageResource(this.yiE);
                }
            }
        }
