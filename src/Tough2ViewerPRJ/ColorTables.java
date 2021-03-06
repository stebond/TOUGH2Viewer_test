/*
 * Copyright 2009 - Areeda Associates Ltd.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Areeda Associates designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package Tough2ViewerPRJ;

import java.awt.image.IndexColorModel;

/**
 * Generate an IndexColorModel from predfined data visualization models
 *
 * @author areeda modified by stebond
 */
public class ColorTables {

    String cTblName;
    int[][] cTbl;
    String[] knowTables = {"gray", "thermal", "nih", "onecolor"};

    /**
     *
     * @param name - name of a predefined color table so far we have "gray",
     * "thermal", "nih"
     * @return - index color model for that table
     */
    public IndexColorModel getIndexColorModel(String name) {

        if (name.equalsIgnoreCase("gray")) {
            setGray();
        } else if (name.equalsIgnoreCase("thermal")) {
            setThermal();
        } else if (name.equalsIgnoreCase("nih")) {
            this.setNih();
        } else if (name.equalsIgnoreCase("onecolor")) {
            this.setOneColor(0, 0, 255);
        } else {   // @todo throw and exception and let everybody deal with it at a higher level
            this.setNih();
        }

        byte[] r, g, b;
        r = new byte[256];
        g = new byte[256];
        b = new byte[256];

        for (int i = 0; i < 256; i++) {
            r[i] = (byte) (cTbl[i][0] & 0xff);
            g[i] = (byte) (cTbl[i][1] & 0xff);
            b[i] = (byte) (cTbl[i][2] & 0xff);
        }
        IndexColorModel icm = new IndexColorModel(8, 256, r, g, b);
        return icm;
    }

    private void setThermal() {
        String name = "Thermal";

        int[][] tbl = {
            {0, 0, 0},
            {0, 0, 0},
            {3, 0, 0},
            {6, 0, 0},
            {10, 0, 0},
            {13, 0, 0},
            {17, 0, 0},
            {20, 0, 0},
            {24, 1, 0},
            {27, 1, 0},
            {30, 1, 0},
            {33, 1, 0},
            {36, 2, 0},
            {39, 2, 0},
            {42, 2, 0},
            {45, 2, 0},
            {48, 2, 0},
            {51, 2, 0},
            {54, 2, 0},
            {57, 2, 0},
            {60, 3, 0},
            {63, 3, 0},
            {66, 3, 0},
            {69, 3, 0},
            {72, 4, 0},
            {75, 4, 0},
            {78, 4, 0},
            {81, 4, 0},
            {84, 4, 0},
            {85, 5, 0},
            {86, 6, 0},
            {87, 7, 0},
            {88, 9, 0},
            {90, 9, 0},
            {92, 10, 0},
            {94, 11, 0},
            {96, 12, 0},
            {97, 13, 0},
            {98, 14, 0},
            {99, 15, 0},
            {100, 17, 0},
            {102, 17, 0},
            {104, 18, 0},
            {106, 18, 0},
            {108, 19, 0},
            {109, 20, 0},
            {110, 21, 0},
            {111, 22, 0},
            {112, 24, 0},
            {114, 24, 0},
            {116, 25, 0},
            {118, 26, 0},
            {120, 27, 0},
            {121, 28, 0},
            {122, 29, 0},
            {123, 30, 0},
            {124, 32, 0},
            {126, 32, 0},
            {128, 33, 0},
            {130, 33, 0},
            {132, 34, 0},
            {133, 35, 0},
            {134, 36, 0},
            {135, 37, 0},
            {136, 39, 0},
            {138, 39, 1},
            {140, 40, 2},
            {142, 40, 3},
            {144, 41, 4},
            {145, 42, 4},
            {146, 43, 4},
            {147, 44, 4},
            {148, 46, 4},
            {150, 46, 4},
            {152, 47, 4},
            {154, 48, 4},
            {156, 49, 4},
            {157, 50, 4},
            {158, 51, 4},
            {159, 52, 4},
            {160, 54, 4},
            {162, 54, 5},
            {164, 54, 6},
            {166, 54, 7},
            {168, 55, 8},
            {169, 56, 8},
            {170, 57, 8},
            {171, 58, 8},
            {172, 60, 8},
            {174, 60, 8},
            {176, 61, 8},
            {178, 62, 8},
            {180, 63, 8},
            {181, 64, 8},
            {182, 65, 8},
            {183, 66, 8},
            {184, 68, 8},
            {185, 69, 8},
            {186, 70, 8},
            {187, 71, 8},
            {188, 73, 8},
            {189, 74, 8},
            {190, 75, 8},
            {191, 76, 8},
            {192, 77, 8},
            {193, 78, 8},
            {194, 79, 8},
            {195, 80, 8},
            {196, 82, 8},
            {198, 82, 9},
            {200, 83, 10},
            {202, 83, 11},
            {204, 84, 12},
            {205, 85, 12},
            {206, 86, 12},
            {207, 87, 12},
            {208, 89, 12},
            {209, 90, 12},
            {210, 91, 12},
            {211, 92, 12},
            {212, 94, 12},
            {213, 95, 12},
            {214, 96, 12},
            {215, 97, 12},
            {216, 98, 12},
            {217, 99, 12},
            {218, 100, 12},
            {219, 101, 12},
            {220, 103, 12},
            {222, 103, 12},
            {224, 104, 12},
            {226, 105, 12},
            {228, 106, 12},
            {229, 107, 13},
            {230, 108, 14},
            {231, 109, 15},
            {232, 110, 16},
            {233, 111, 16},
            {234, 112, 16},
            {235, 113, 16},
            {236, 115, 16},
            {237, 116, 16},
            {238, 117, 16},
            {239, 118, 16},
            {240, 119, 16},
            {241, 120, 16},
            {242, 121, 16},
            {243, 122, 16},
            {244, 124, 16},
            {246, 124, 17},
            {248, 125, 18},
            {250, 125, 19},
            {252, 126, 20},
            {252, 127, 20},
            {252, 129, 20},
            {252, 131, 20},
            {252, 133, 20},
            {252, 134, 20},
            {252, 136, 20},
            {252, 138, 20},
            {252, 140, 20},
            {252, 141, 21},
            {252, 143, 22},
            {252, 144, 23},
            {252, 146, 24},
            {252, 147, 24},
            {252, 149, 24},
            {252, 151, 24},
            {252, 153, 24},
            {252, 154, 25},
            {252, 156, 26},
            {252, 157, 27},
            {252, 159, 28},
            {252, 160, 30},
            {252, 161, 32},
            {252, 162, 34},
            {252, 164, 36},
            {252, 165, 38},
            {252, 166, 40},
            {252, 167, 42},
            {252, 169, 44},
            {252, 170, 46},
            {252, 172, 48},
            {252, 173, 50},
            {252, 175, 52},
            {252, 176, 54},
            {252, 177, 56},
            {252, 178, 58},
            {252, 180, 60},
            {252, 181, 61},
            {252, 183, 62},
            {252, 184, 63},
            {252, 186, 64},
            {252, 187, 66},
            {252, 188, 68},
            {252, 189, 70},
            {252, 191, 72},
            {252, 192, 74},
            {252, 193, 76},
            {252, 194, 78},
            {252, 196, 80},
            {252, 197, 82},
            {252, 199, 84},
            {252, 200, 86},
            {252, 202, 88},
            {252, 203, 90},
            {252, 204, 92},
            {252, 205, 94},
            {252, 207, 96},
            {252, 208, 98},
            {252, 209, 100},
            {252, 210, 102},
            {252, 212, 104},
            {252, 213, 107},
            {252, 214, 110},
            {252, 215, 113},
            {252, 217, 116},
            {252, 218, 119},
            {252, 219, 122},
            {252, 220, 125},
            {252, 221, 128},
            {252, 222, 131},
            {252, 223, 134},
            {252, 224, 137},
            {252, 226, 140},
            {252, 227, 143},
            {252, 228, 146},
            {252, 229, 149},
            {252, 230, 152},
            {252, 231, 155},
            {252, 232, 158},
            {252, 233, 161},
            {252, 235, 164},
            {252, 236, 167},
            {252, 237, 170},
            {252, 238, 173},
            {252, 239, 176},
            {252, 240, 180},
            {252, 241, 184},
            {252, 242, 188},
            {252, 243, 192},
            {252, 243, 197},
            {252, 244, 202},
            {252, 245, 207},
            {252, 246, 212},
            {252, 246, 217},
            {252, 247, 222},
            {252, 248, 227},
            {252, 249, 232},
            {252, 249, 237},
            {252, 250, 242},
            {252, 251, 247},
            {252, 252, 252},
            {252, 252, 252},
            {252, 252, 252},
            {252, 252, 252}
        };
        this.cTblName = name;
        this.cTbl = tbl;
    }

    private void setNih() {
        String name = "NIH";

        int[][] tbl = {
            {30, 30, 30},
            {5, 0, 11},
            {11, 0, 22},
            {17, 0, 34},
            {22, 0, 45},
            {28, 0, 56},
            {34, 0, 68},
            {39, 0, 79},
            {45, 0, 90},
            {51, 0, 102},
            {56, 0, 113},
            {62, 0, 124},
            {68, 0, 136},
            {73, 0, 147},
            {79, 0, 158},
            {85, 0, 170},
            {79, 0, 164},
            {74, 0, 159},
            {69, 0, 154},
            {63, 0, 148},
            {58, 0, 143},
            {53, 0, 138},
            {47, 0, 132},
            {42, 0, 127},
            {37, 0, 122},
            {31, 0, 116},
            {26, 0, 111},
            {21, 0, 106},
            {15, 0, 100},
            {10, 0, 95},
            {5, 0, 90},
            {0, 0, 85},
            {0, 0, 90},
            {0, 0, 95},
            {0, 0, 100},
            {0, 0, 106},
            {0, 0, 111},
            {0, 0, 116},
            {0, 0, 122},
            {0, 0, 127},
            {0, 0, 132},
            {0, 0, 138},
            {0, 0, 143},
            {0, 0, 148},
            {0, 0, 154},
            {0, 0, 159},
            {0, 0, 164},
            {0, 0, 170},
            {0, 0, 175},
            {0, 0, 180},
            {0, 0, 185},
            {0, 0, 191},
            {0, 0, 196},
            {0, 0, 201},
            {0, 0, 207},
            {0, 0, 212},
            {0, 0, 217},
            {0, 0, 223},
            {0, 0, 228},
            {0, 0, 233},
            {0, 0, 239},
            {0, 0, 244},
            {0, 0, 249},
            {0, 0, 255},
            {0, 5, 255},
            {0, 10, 255},
            {0, 15, 255},
            {0, 21, 255},
            {0, 26, 255},
            {0, 31, 255},
            {0, 37, 255},
            {0, 42, 255},
            {0, 47, 255},
            {0, 53, 255},
            {0, 58, 255},
            {0, 63, 255},
            {0, 69, 255},
            {0, 74, 255},
            {0, 79, 255},
            {0, 85, 255},
            {0, 90, 249},
            {0, 95, 244},
            {0, 100, 239},
            {0, 106, 233},
            {0, 111, 228},
            {0, 116, 223},
            {0, 122, 217},
            {0, 127, 212},
            {0, 132, 207},
            {0, 138, 201},
            {0, 143, 196},
            {0, 148, 191},
            {0, 154, 185},
            {0, 159, 180},
            {0, 164, 175},
            {0, 170, 170},
            {0, 175, 170},
            {0, 180, 170},
            {0, 185, 170},
            {0, 191, 170},
            {0, 196, 170},
            {0, 201, 170},
            {0, 207, 170},
            {0, 212, 170},
            {0, 217, 170},
            {0, 223, 170},
            {0, 228, 170},
            {0, 233, 170},
            {0, 239, 170},
            {0, 244, 170},
            {0, 249, 170},
            {0, 255, 170},
            {0, 255, 159},
            {0, 255, 148},
            {0, 255, 138},
            {0, 255, 127},
            {0, 255, 116},
            {0, 255, 106},
            {0, 255, 95},
            {0, 255, 85},
            {0, 255, 74},
            {0, 255, 63},
            {0, 255, 53},
            {0, 255, 42},
            {0, 255, 31},
            {0, 255, 21},
            {0, 255, 10},
            {0, 255, 0},
            {5, 255, 5},
            {10, 255, 10},
            {15, 255, 15},
            {21, 255, 21},
            {26, 255, 26},
            {31, 255, 31},
            {37, 255, 37},
            {42, 255, 42},
            {47, 255, 47},
            {53, 255, 53},
            {58, 255, 58},
            {63, 255, 63},
            {69, 255, 69},
            {74, 255, 74},
            {79, 255, 79},
            {85, 255, 85},
            {95, 255, 79},
            {106, 255, 74},
            {116, 255, 69},
            {127, 255, 63},
            {138, 255, 58},
            {148, 255, 53},
            {159, 255, 47},
            {170, 255, 42},
            {180, 255, 37},
            {191, 255, 31},
            {201, 255, 26},
            {212, 255, 21},
            {223, 255, 15},
            {233, 255, 10},
            {244, 255, 5},
            {255, 255, 0},
            {255, 249, 0},
            {255, 244, 0},
            {255, 239, 0},
            {255, 233, 0},
            {255, 228, 0},
            {255, 223, 0},
            {255, 217, 0},
            {255, 212, 0},
            {255, 207, 0},
            {255, 201, 0},
            {255, 196, 0},
            {255, 191, 0},
            {255, 185, 0},
            {255, 180, 0},
            {255, 175, 0},
            {255, 170, 0},
            {255, 164, 0},
            {255, 159, 0},
            {255, 154, 0},
            {255, 148, 0},
            {255, 143, 0},
            {255, 138, 0},
            {255, 132, 0},
            {255, 127, 0},
            {255, 122, 0},
            {255, 116, 0},
            {255, 111, 0},
            {255, 106, 0},
            {255, 100, 0},
            {255, 95, 0},
            {255, 90, 0},
            {255, 85, 0},
            {255, 81, 0},
            {255, 78, 0},
            {255, 75, 0},
            {255, 71, 0},
            {255, 68, 0},
            {255, 65, 0},
            {255, 62, 0},
            {255, 58, 0},
            {255, 55, 0},
            {255, 52, 0},
            {255, 49, 0},
            {255, 45, 0},
            {255, 42, 0},
            {255, 39, 0},
            {255, 35, 0},
            {255, 32, 0},
            {255, 29, 0},
            {255, 26, 0},
            {255, 22, 0},
            {255, 19, 0},
            {255, 16, 0},
            {255, 13, 0},
            {255, 9, 0},
            {255, 6, 0},
            {255, 3, 0},
            {255, 0, 0},
            {252, 0, 0},
            {250, 0, 0},
            {248, 0, 0},
            {246, 0, 0},
            {243, 0, 0},
            {241, 0, 0},
            {239, 0, 0},
            {237, 0, 0},
            {234, 0, 0},
            {232, 0, 0},
            {230, 0, 0},
            {228, 0, 0},
            {225, 0, 0},
            {223, 0, 0},
            {221, 0, 0},
            {219, 0, 0},
            {216, 0, 0},
            {214, 0, 0},
            {212, 0, 0},
            {210, 0, 0},
            {208, 0, 0},
            {205, 0, 0},
            {203, 0, 0},
            {201, 0, 0},
            {199, 0, 0},
            {196, 0, 0},
            {194, 0, 0},
            {192, 0, 0},
            {190, 0, 0},
            {187, 0, 0},
            {185, 0, 0},
            {183, 0, 0},
            {181, 0, 0},
            {178, 0, 0},
            {176, 0, 0},
            {174, 0, 0},
            {173, 0, 0},
            {255, 255, 255},};
        this.cTblName = name;
        this.cTbl = tbl;
    }

    private void setGray() {
        cTbl = new int[256][3];
        cTblName = "gray";
        int[] c = new int[3];
        for (Integer b = 0; b < 256; b++) {

            cTbl[b][0] = cTbl[b][1] = cTbl[b][2] = b;
        }
    }

    private void setOneColor(int r, int g, int b) {
        cTbl = new int[256][3];
        cTblName = "onecolor";
        int[] c = new int[3];
        for (Integer i = 0; i < 256; i++) {

            cTbl[i][0] = r;
            cTbl[i][1] = g;
            cTbl[i][2] = b;
        }
    }

}
