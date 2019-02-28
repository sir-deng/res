package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;

public class c extends b {
    private static final String r = c.class.getSimpleName();
    private float A = 0.0f;
    private f s;
    private a t;
    private p u = null;
    private int v = -1;
    private int w = -1;
    private float x = 0.0f;
    private float y = 0.0f;
    private float z = 0.0f;

    public static class a extends q {
        private int x = -1;
        private int y = -1;
        private int z = -1;

        public a() {
            super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        }

        public boolean a() {
            NativeLoad.getInstance();
            this.a = NativeLoad.nativeLoadGLProgram(1);
            if (this.a == 0 || !b()) {
                this.g = false;
            } else {
                this.g = true;
            }
            c();
            return this.g;
        }

        public void a(int i, int i2) {
            super.a(i, i2);
            this.x = GLES20.glGetUniformLocation(p(), "smoothDegree");
            this.y = GLES20.glGetUniformLocation(p(), "brightDegree");
            this.z = GLES20.glGetUniformLocation(p(), "ruddyDegree");
        }

        public boolean b() {
            return super.b();
        }

        public void a(float f) {
            a(this.x, c.b(f));
        }

        public void b(float f) {
            a(this.y, f / 3.0f);
        }

        public void c(float f) {
            a(this.z, (f / 10.0f) / 2.0f);
        }
    }

    public int b(int i) {
        if (this.x > 0.0f || this.y > 0.0f || this.z > 0.0f) {
            int b;
            if (this.x != 0.0f) {
                b = this.s.b(i);
            } else {
                b = i;
            }
            i = this.t.a(b, i, i);
        }
        if (this.A > 0.0f) {
            return this.u.b(i);
        }
        return i;
    }

    public void a(int i, int i2) {
        if (this.t != null) {
            this.t.a(i, i2);
        }
        if (this.s != null) {
            this.s.a(i, i2);
        }
    }

    public boolean b(int i, int i2) {
        this.v = i;
        this.w = i2;
        if (this.u == null) {
            this.u = new p();
            this.u.a(true);
            if (!this.u.a()) {
                return false;
            }
            this.u.a(this.v, this.w);
        }
        this.s = new f();
        this.s.a(true);
        this.t = new a();
        this.t.a(true);
        if (this.t.a() && this.s.a()) {
            this.t.a(this.v, this.w);
            this.s.a(this.v, this.w);
            if (GLES20.glGetError() == 0) {
                return true;
            }
            e();
            return false;
        }
        e();
        return false;
    }

    public void e() {
        if (this.t != null) {
            this.t.d();
            this.t = null;
        }
        if (this.s != null) {
            this.s.d();
            this.s = null;
        }
        if (this.u != null) {
            this.u.d();
            this.u = null;
        }
    }

    public void c(int i) {
        this.x = (float) i;
        if (this.t != null) {
            this.t.a((float) i);
        }
    }

    public void d(int i) {
        this.y = (float) i;
        if (this.t != null) {
            this.t.b((float) i);
        }
    }

    public void e(int i) {
        this.z = (float) i;
        if (this.t != null) {
            this.t.c((float) i);
        }
    }

    public void f(int i) {
        this.A = ((float) i) / 15.0f;
        if (this.u != null) {
            this.u.a(this.A);
        }
    }

    private static float b(float f) {
        if (f <= 1.0f) {
            return 0.1f;
        }
        if (((double) f) < 2.5d) {
            f = a((f - 1.0f) / 1.5f, 1.0f, 4.1f);
        } else if (f < 4.0f) {
            f = a((f - 2.5f) / 1.5f, 4.1f, 5.6f);
        } else if (((double) f) < 5.5d) {
            f = a((f - 4.0f) / 1.5f, 5.6f, 6.8f);
        } else if (((double) f) <= 7.0d) {
            f = a((f - 5.5f) / 1.5f, 6.8f, 7.0f);
        }
        return f / 10.0f;
    }

    private static float a(float f, float f2, float f3) {
        return ((f3 - f2) * f) + f2;
    }
}
