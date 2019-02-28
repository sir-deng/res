package com.tencent.recovery.option;

import com.tencent.recovery.config.Express;

public class ProcessOptions {
    private Express AaV;
    public int gLT;

    public static final class Builder {
        public Express AaV;
        private int gLT;

        public final Builder cEg() {
            this.gLT = 10000;
            return this;
        }

        public final ProcessOptions cEh() {
            ProcessOptions processOptions = new ProcessOptions();
            processOptions.gLT = this.gLT;
            processOptions.AaV = this.AaV;
            return processOptions;
        }
    }
}
