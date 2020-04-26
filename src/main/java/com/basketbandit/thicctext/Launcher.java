package com.basketbandit.thicctext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launcher {
    protected static final Logger log = LoggerFactory.getLogger(Launcher.class);
    
    public static void main(String[] args) {
        new ThiccText(args[0]);
    }
}


