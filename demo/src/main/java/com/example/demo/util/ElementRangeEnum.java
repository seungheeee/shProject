package com.example.demo.util;

import java.awt.*;
public class ElementRangeEnum {
    public enum E_IDFE_T_12 {
        R0(new Color(238, 238, 238), "-50"),
        R1(new Color(229, 172, 255), "-44"),
        R2(new Color(218, 135, 255), "-43"),
        R3(new Color(205, 97, 255), "-42"),
        R4(new Color(194, 62, 255), "-41"),
        R5(new Color(183, 31, 255), "-40"),
        R6(new Color(173, 7, 255), "-39"),
        R7(new Color(160, 0, 247), "-38"),
        R8(new Color(146, 0, 228), "-37"),
        R9(new Color(135, 0, 206), "-36"),
        R10(new Color(127, 0, 191), "-35"),
        R11(new Color(203, 204, 232), "-34"),
        R12(new Color(179, 180, 222), "-33"),
        R13(new Color(154, 155, 211), "-32"),
        R14(new Color(128, 129, 199), "-31"),
        R15(new Color(101, 103, 188), "-30"),
        R16(new Color(76, 78, 177), "-29"),
        R17(new Color(52, 54, 167), "-28"),
        R18(new Color(31, 33, 157), "-27"),
        R19(new Color(13, 16, 150), "-26"),
        R20(new Color(0, 3, 144), "-25"),
        R21(new Color(172, 229, 255), "-24"),
        R22(new Color(135, 217, 255), "-23"),
        R23(new Color(97, 205, 255), "-22"),
        R24(new Color(62, 193, 255), "-21"),
        R25(new Color(31, 181, 255), "-20"),
        R26(new Color(7, 171, 255), "-19"),
        R27(new Color(0, 157, 246), "-18"),
        R28(new Color(0, 141, 222), "-17"),
        R29(new Color(0, 128, 196), "-16"),
        R30(new Color(0, 119, 179), "-15"),
        R31(new Color(150, 254, 150), "-14"),
        R32(new Color(105, 252, 105), "-13"),
        R33(new Color(64, 249, 64), "-12"),
        R34(new Color(30, 243, 30), "-11"),
        R35(new Color(8, 233, 8), "-10"),
        R36(new Color(0, 213, 0), "-9"),
        R37(new Color(0, 189, 0), "-8"),
        R38(new Color(0, 164, 0), "-7"),
        R39(new Color(0, 142, 0), "-6"),
        R40(new Color(0, 128, 0), "-5"),
        R41(new Color(255, 240, 154), "-4"),
        R42(new Color(255, 234, 110), "-3"),
        R43(new Color(255, 227, 67), "-2"),
        R44(new Color(255, 220, 31), "-1"),
        R45(new Color(255, 214, 4), "0"),
        R46(new Color(249, 205, 0), "1"),
        R47(new Color(237, 195, 0), "2"),
        R48(new Color(224, 185, 0), "3"),
        R49(new Color(212, 176, 0), "4"),
        R50(new Color(204, 170, 0), "5"),
        R51(new Color(252, 171, 171), "6"),
        R52(new Color(250, 133, 133), "7"),
        R53(new Color(248, 96, 96), "8"),
        R54(new Color(246, 62, 62), "9"),
        R55(new Color(243, 33, 33), "10"),
        R56(new Color(238, 11, 11), "11"),
        R57(new Color(227, 0, 0), "12"),
        R58(new Color(213, 0, 0), "13"),
        R59(new Color(200, 0, 0), "14"),
        R60(new Color(191, 0, 0), "15"),
        R61(new Color(51, 51, 51), "50");


        private final Color color;
        private final String value;

        E_IDFE_T_12(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_T_3 {
        R0(new Color(238, 238, 238), "-50"),
        R1(new Color(229, 172, 255), "-30"),
        R2(new Color(218, 135, 255), "-28"),
        R3(new Color(205, 97, 255), "-27"),
        R4(new Color(194, 62, 255), "-26"),
        R5(new Color(183, 31, 255), "-25"),
        R6(new Color(173, 7, 255), "-24"),
        R7(new Color(160, 0, 247), "-23"),
        R8(new Color(146, 0, 228), "-22"),
        R9(new Color(135, 0, 206), "-21"),
        R10(new Color(127, 0, 191), "-20"),
        R11(new Color(203, 204, 232), "-19"),
        R12(new Color(179, 180, 222), "-18"),
        R13(new Color(154, 155, 211), "-17"),
        R14(new Color(128, 129, 199), "-16"),
        R15(new Color(101, 103, 188), "-15"),
        R16(new Color(76, 78, 177), "-14"),
        R17(new Color(52, 54, 167), "-13"),
        R18(new Color(31, 33, 157), "-12"),
        R19(new Color(13, 16, 150), "-11"),
        R20(new Color(0, 3, 144), "-10"),
        R21(new Color(172, 229, 255), "-9"),
        R22(new Color(135, 217, 255), "-8"),
        R23(new Color(97, 205, 255), "-7"),
        R24(new Color(62, 193, 255), "-6"),
        R25(new Color(31, 181, 255), "-5"),
        R26(new Color(7, 171, 255), "-4"),
        R27(new Color(0, 157, 246), "-3"),
        R28(new Color(0, 141, 222), "-2"),
        R29(new Color(0, 128, 196), "-1"),
        R30(new Color(0, 119, 179), "0"),
        R31(new Color(150, 254, 150), "1"),
        R32(new Color(105, 252, 105), "2"),
        R33(new Color(64, 249, 64), "3"),
        R34(new Color(30, 243, 30), "4"),
        R35(new Color(8, 233, 8), "5"),
        R36(new Color(0, 213, 0), "6"),
        R37(new Color(0, 189, 0), "7"),
        R38(new Color(0, 164, 0), "8"),
        R39(new Color(0, 142, 0), "9"),
        R40(new Color(0, 128, 0), "10"),
        R41(new Color(255, 240, 154), "11"),
        R42(new Color(255, 234, 110), "12"),
        R43(new Color(255, 227, 67), "13"),
        R44(new Color(255, 220, 31), "14"),
        R45(new Color(255, 214, 4), "15"),
        R46(new Color(249, 205, 0), "16"),
        R47(new Color(237, 195, 0), "17"),
        R48(new Color(224, 185, 0), "18"),
        R49(new Color(212, 176, 0), "19"),
        R50(new Color(204, 170, 0), "20"),
        R51(new Color(252, 171, 171), "21"),
        R52(new Color(250, 133, 133), "22"),
        R53(new Color(248, 96, 96), "23"),
        R54(new Color(246, 62, 62), "24"),
        R55(new Color(243, 33, 33), "25"),
        R56(new Color(238, 11, 11), "26"),
        R57(new Color(227, 0, 0), "27"),
        R58(new Color(213, 0, 0), "28"),
        R59(new Color(200, 0, 0), "29"),
        R60(new Color(191, 0, 0), "30"),
        R61(new Color(51, 51, 51), "50");


        private final Color color;
        private final String value;

        E_IDFE_T_3(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_T_6 {
        R0(new Color(238, 238, 238), "-50"),
        R1(new Color(229, 172, 255), "-10"),
        R2(new Color(218, 135, 255), "-9"),
        R3(new Color(205, 97, 255), "-8"),
        R4(new Color(194, 62, 255), "-7"),
        R5(new Color(183, 31, 255), "-6"),
        R6(new Color(173, 7, 255), "-5"),
        R7(new Color(160, 0, 247), "-4"),
        R8(new Color(146, 0, 228), "-3"),
        R9(new Color(135, 0, 206), "-2"),
        R10(new Color(127, 0, 191), "-1"),
        R11(new Color(203, 204, 232), "0"),
        R12(new Color(179, 180, 222), "1"),
        R13(new Color(154, 155, 211), "2"),
        R14(new Color(128, 129, 199), "3"),
        R15(new Color(101, 103, 188), "4"),
        R16(new Color(76, 78, 177), "5"),
        R17(new Color(52, 54, 167), "6"),
        R18(new Color(31, 33, 157), "7"),
        R19(new Color(13, 16, 150), "8"),
        R20(new Color(0, 3, 144), "9"),
        R21(new Color(172, 229, 255), "10"),
        R22(new Color(135, 217, 255), "11"),
        R23(new Color(97, 205, 255), "12"),
        R24(new Color(62, 193, 255), "13"),
        R25(new Color(31, 181, 255), "14"),
        R26(new Color(7, 171, 255), "15"),
        R27(new Color(0, 157, 246), "16"),
        R28(new Color(0, 141, 222), "17"),
        R29(new Color(0, 128, 196), "18"),
        R30(new Color(0, 119, 179), "19"),
        R31(new Color(150, 254, 150), "20"),
        R32(new Color(105, 252, 105), "21"),
        R33(new Color(64, 249, 64), "22"),
        R34(new Color(30, 243, 30), "23"),
        R35(new Color(8, 233, 8), "24"),
        R36(new Color(0, 213, 0), "25"),
        R37(new Color(0, 189, 0), "26"),
        R38(new Color(0, 164, 0), "27"),
        R39(new Color(0, 142, 0), "28"),
        R40(new Color(0, 128, 0), "29"),
        R41(new Color(255, 240, 154), "30"),
        R42(new Color(255, 234, 110), "31"),
        R43(new Color(255, 227, 67), "32"),
        R44(new Color(255, 220, 31), "33"),
        R45(new Color(255, 214, 4), "34"),
        R46(new Color(249, 205, 0), "35"),
        R47(new Color(237, 195, 0), "36"),
        R48(new Color(224, 185, 0), "37"),
        R49(new Color(212, 176, 0), "38"),
        R50(new Color(204, 170, 0), "39"),
        R51(new Color(252, 171, 171), "40"),
        R52(new Color(250, 133, 133), "41"),
        R53(new Color(248, 96, 96), "42"),
        R54(new Color(246, 62, 62), "43"),
        R55(new Color(243, 33, 33), "44"),
        R56(new Color(238, 11, 11), "45"),
        R57(new Color(227, 0, 0), "46"),
        R58(new Color(213, 0, 0), "47"),
        R59(new Color(200, 0, 0), "48"),
        R60(new Color(191, 0, 0), "49"),
        R61(new Color(51, 51, 51), "50");


        private final Color color;
        private final String value;

        E_IDFE_T_6(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_T_9 {
        R0(new Color(238, 238, 238), "-50"),
        R1(new Color(229, 172, 255), "-30"),
        R2(new Color(218, 135, 255), "-28"),
        R3(new Color(205, 97, 255), "-27"),
        R4(new Color(194, 62, 255), "-26"),
        R5(new Color(183, 31, 255), "-25"),
        R6(new Color(173, 7, 255), "-24"),
        R7(new Color(160, 0, 247), "-23"),
        R8(new Color(146, 0, 228), "-22"),
        R9(new Color(135, 0, 206), "-21"),
        R10(new Color(127, 0, 191), "-20"),
        R11(new Color(203, 204, 232), "-19"),
        R12(new Color(179, 180, 222), "-18"),
        R13(new Color(154, 155, 211), "-17"),
        R14(new Color(128, 129, 199), "-16"),
        R15(new Color(101, 103, 188), "-15"),
        R16(new Color(76, 78, 177), "-14"),
        R17(new Color(52, 54, 167), "-13"),
        R18(new Color(31, 33, 157), "-12"),
        R19(new Color(13, 16, 150), "-11"),
        R20(new Color(0, 3, 144), "-10"),
        R21(new Color(172, 229, 255), "-9"),
        R22(new Color(135, 217, 255), "-8"),
        R23(new Color(97, 205, 255), "-7"),
        R24(new Color(62, 193, 255), "-6"),
        R25(new Color(31, 181, 255), "-5"),
        R26(new Color(7, 171, 255), "-4"),
        R27(new Color(0, 157, 246), "-3"),
        R28(new Color(0, 141, 222), "-2"),
        R29(new Color(0, 128, 196), "-1"),
        R30(new Color(0, 119, 179), "0"),
        R31(new Color(150, 254, 150), "1"),
        R32(new Color(105, 252, 105), "2"),
        R33(new Color(64, 249, 64), "3"),
        R34(new Color(30, 243, 30), "4"),
        R35(new Color(8, 233, 8), "5"),
        R36(new Color(0, 213, 0), "6"),
        R37(new Color(0, 189, 0), "7"),
        R38(new Color(0, 164, 0), "8"),
        R39(new Color(0, 142, 0), "9"),
        R40(new Color(0, 128, 0), "10"),
        R41(new Color(255, 240, 154), "11"),
        R42(new Color(255, 234, 110), "12"),
        R43(new Color(255, 227, 67), "13"),
        R44(new Color(255, 220, 31), "14"),
        R45(new Color(255, 214, 4), "15"),
        R46(new Color(249, 205, 0), "16"),
        R47(new Color(237, 195, 0), "17"),
        R48(new Color(224, 185, 0), "18"),
        R49(new Color(212, 176, 0), "19"),
        R50(new Color(204, 170, 0), "20"),
        R51(new Color(252, 171, 171), "21"),
        R52(new Color(250, 133, 133), "22"),
        R53(new Color(248, 96, 96), "23"),
        R54(new Color(246, 62, 62), "24"),
        R55(new Color(243, 33, 33), "25"),
        R56(new Color(238, 11, 11), "26"),
        R57(new Color(227, 0, 0), "27"),
        R58(new Color(213, 0, 0), "28"),
        R59(new Color(200, 0, 0), "29"),
        R60(new Color(191, 0, 0), "30"),
        R61(new Color(51, 51, 51), "50");


        private final Color color;
        private final String value;

        E_IDFE_T_9(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_RN {
        R0(new Color(238, 238, 238), "0"),
        R1(new Color(255, 234, 110), "0.1"),
        R2(new Color(255, 220, 31), "0.2"),
        R3(new Color(249, 205, 0), "0.4"),
        R4(new Color(224, 185, 0), "0.6"),
        R5(new Color(204, 170, 0), "0.8"),
        R6(new Color(105, 252, 105), "1"),
        R7(new Color(30, 243, 30), "1.5"),
        R8(new Color(0, 213, 0), "2"),
        R9(new Color(0, 164, 0), "3"),
        R10(new Color(0, 128, 0), "4"),
        R11(new Color(135, 217, 255), "5"),
        R12(new Color(62, 193, 255), "6"),
        R13(new Color(7, 171, 255), "7"),
        R14(new Color(0, 141, 222), "8"),
        R15(new Color(0, 119, 179), "9"),
        R16(new Color(179, 180, 222), "10"),
        R17(new Color(128, 129, 199), "15"),
        R18(new Color(76, 78, 177), "20"),
        R19(new Color(31, 33, 157), "25"),
        R20(new Color(0, 3, 144), "30"),
        R21(new Color(218, 135, 255), "40"),
        R22(new Color(194, 62, 255), "50"),
        R23(new Color(173, 7, 255), "60"),
        R24(new Color(146, 0, 228), "70"),
        R25(new Color(127, 0, 191), "80"),
        R26(new Color(250, 133, 133), "90"),
        R27(new Color(246, 62, 62), "100"),
        R28(new Color(238, 11, 11), "300"),
        R29(new Color(213, 0, 0), "500"),
        R30(new Color(191, 0, 0), "700"),
        R31(new Color(51, 51, 51), "900");


        private final Color color;
        private final String value;

        E_IDFE_RN(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_POP {
        R0(new Color(255, 240, 154), "0"),
        R1(new Color(255, 234, 110), "2"),
        R2(new Color(255, 227, 67), "4"),
        R3(new Color(255, 220, 31), "6"),
        R4(new Color(255, 214, 4), "8"),
        R5(new Color(249, 205, 0), "10"),
        R6(new Color(237, 195, 0), "12"),
        R7(new Color(224, 185, 0), "14"),
        R8(new Color(212, 176, 0), "16"),
        R9(new Color(204, 170, 0), "18"),
        R10(new Color(150, 254, 150), "20"),
        R11(new Color(105, 252, 105), "22"),
        R12(new Color(64, 249, 64), "24"),
        R13(new Color(30, 243, 30), "26"),
        R14(new Color(8, 233, 8), "28"),
        R15(new Color(0, 213, 0), "30"),
        R16(new Color(0, 189, 0), "32"),
        R17(new Color(0, 164, 0), "34"),
        R18(new Color(0, 142, 0), "36"),
        R19(new Color(0, 128, 0), "38"),
        R20(new Color(172, 229, 255), "40"),
        R21(new Color(135, 217, 255), "42"),
        R22(new Color(97, 205, 255), "44"),
        R23(new Color(62, 193, 255), "46"),
        R24(new Color(31, 181, 255), "48"),
        R25(new Color(7, 171, 255), "50"),
        R26(new Color(0, 157, 246), "52"),
        R27(new Color(0, 141, 222), "54"),
        R28(new Color(0, 128, 196), "56"),
        R29(new Color(0, 119, 179), "58"),
        R30(new Color(203, 204, 232), "60"),
        R31(new Color(179, 180, 222), "62"),
        R32(new Color(154, 155, 211), "64"),
        R33(new Color(128, 129, 199), "66"),
        R34(new Color(101, 103, 188), "68"),
        R35(new Color(76, 78, 177), "70"),
        R36(new Color(52, 54, 167), "72"),
        R37(new Color(31, 33, 157), "74"),
        R38(new Color(13, 16, 150), "76"),
        R39(new Color(0, 3, 144), "78"),
        R40(new Color(229, 172, 255), "80"),
        R41(new Color(218, 135, 255), "82"),
        R42(new Color(205, 97, 255), "84"),
        R43(new Color(194, 62, 255), "86"),
        R44(new Color(183, 31, 255), "88"),
        R45(new Color(173, 7, 255), "90"),
        R46(new Color(160, 0, 247), "92"),
        R47(new Color(146, 0, 228), "94"),
        R48(new Color(135, 0, 206), "96"),
        R49(new Color(127, 0, 191), "98"),
        R50(new Color(238, 238, 238), "100");


        private final Color color;
        private final String value;

        E_IDFE_POP(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_PT {
        R0(new Color(255, 255, 255), "0"),
        R1(new Color(96, 212, 126), "1"),
        R2(new Color(61, 196, 230), "2"),
        R3(new Color(142, 142, 233), "3"),
        R4(new Color(255, 192, 0), "4");


        private final Color color;
        private final String value;

        E_IDFE_PT(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_PT_VSRT {
        R0(new Color(255, 255, 255), "0"),
        R1(new Color(96, 212, 126), "1"),
        R2(new Color(61, 196, 230), "2"),
        R3(new Color(142, 142, 233), "3");


        private final Color color;
        private final String value;

        E_IDFE_PT_VSRT(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_FSC {
        R0(new Color(238, 238, 238), "0"),
        R1(new Color(255, 234, 110), "0.1"),
        R2(new Color(255, 220, 31), "0.2"),
        R3(new Color(249, 205, 0), "0.4"),
        R4(new Color(224, 185, 0), "0.6"),
        R5(new Color(204, 170, 0), "0.8"),
        R6(new Color(105, 252, 105), "1"),
        R7(new Color(30, 243, 30), "1.5"),
        R8(new Color(0, 213, 0), "2"),
        R9(new Color(0, 164, 0), "3"),
        R10(new Color(0, 128, 0), "4"),
        R11(new Color(135, 217, 255), "5"),
        R12(new Color(62, 193, 255), "6"),
        R13(new Color(7, 171, 255), "7"),
        R14(new Color(0, 141, 222), "8"),
        R15(new Color(0, 119, 179), "9"),
        R16(new Color(179, 180, 222), "10"),
        R17(new Color(128, 129, 199), "12"),
        R18(new Color(76, 78, 177), "14"),
        R19(new Color(31, 33, 157), "16"),
        R20(new Color(0, 3, 144), "18"),
        R21(new Color(218, 135, 255), "20"),
        R22(new Color(194, 62, 255), "25"),
        R23(new Color(173, 7, 255), "30"),
        R24(new Color(146, 0, 228), "35"),
        R25(new Color(127, 0, 191), "40"),
        R26(new Color(250, 133, 133), "50"),
        R27(new Color(246, 62, 62), "60"),
        R28(new Color(238, 11, 11), "70"),
        R29(new Color(213, 0, 0), "80"),
        R30(new Color(191, 0, 0), "90"),
        R31(new Color(51, 51, 51), "100");


        private final Color color;
        private final String value;

        E_IDFE_FSC(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_SKY {
        R0(new Color(255, 255, 255), "1"),
        R1(new Color(111, 162, 189), "3"),
        R2(new Color(62, 122, 154), "4");


        private final Color color;
        private final String value;

        E_IDFE_SKY(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_RH {
        R0(new Color(252, 171, 171), "0"),
        R1(new Color(250, 133, 133), "2"),
        R2(new Color(248, 96, 96), "4"),
        R3(new Color(246, 62, 62), "6"),
        R4(new Color(243, 33, 33), "8"),
        R5(new Color(238, 11, 11), "10"),
        R6(new Color(227, 0, 0), "12"),
        R7(new Color(213, 0, 0), "14"),
        R8(new Color(200, 0, 0), "16"),
        R9(new Color(191, 0, 0), "18"),
        R10(new Color(255, 240, 154), "20"),
        R11(new Color(255, 234, 110), "22"),
        R12(new Color(255, 227, 67), "24"),
        R13(new Color(255, 220, 31), "26"),
        R14(new Color(255, 214, 4), "28"),
        R15(new Color(249, 205, 0), "30"),
        R16(new Color(237, 195, 0), "32"),
        R17(new Color(224, 185, 0), "34"),
        R18(new Color(212, 176, 0), "36"),
        R19(new Color(204, 170, 0), "38"),
        R20(new Color(150, 254, 150), "40"),
        R21(new Color(105, 252, 105), "42"),
        R22(new Color(64, 249, 64), "44"),
        R23(new Color(30, 243, 30), "46"),
        R24(new Color(8, 233, 8), "48"),
        R25(new Color(0, 213, 0), "50"),
        R26(new Color(0, 189, 0), "52"),
        R27(new Color(0, 164, 0), "54"),
        R28(new Color(0, 142, 0), "56"),
        R29(new Color(0, 128, 0), "58"),
        R30(new Color(172, 229, 255), "60"),
        R31(new Color(135, 217, 255), "62"),
        R32(new Color(97, 205, 255), "64"),
        R33(new Color(62, 193, 255), "66"),
        R34(new Color(31, 181, 255), "68"),
        R35(new Color(7, 171, 255), "70"),
        R36(new Color(0, 157, 246), "72"),
        R37(new Color(0, 141, 222), "74"),
        R38(new Color(0, 128, 196), "76"),
        R39(new Color(0, 119, 179), "78"),
        R40(new Color(203, 204, 232), "80"),
        R41(new Color(179, 180, 222), "82"),
        R42(new Color(154, 155, 211), "84"),
        R43(new Color(128, 129, 199), "86"),
        R44(new Color(101, 103, 188), "88"),
        R45(new Color(76, 78, 177), "90"),
        R46(new Color(52, 54, 167), "92"),
        R47(new Color(31, 33, 157), "94"),
        R48(new Color(13, 16, 150), "96"),
        R49(new Color(0, 3, 144), "98"),
        R50(new Color(51, 51, 51), "100");


        private final Color color;
        private final String value;

        E_IDFE_RH(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_WS {
        R0(new Color(255, 234, 110), "0.1"),
        R1(new Color(255, 220, 31), "0.2"),
        R2(new Color(249, 205, 0), "0.4"),
        R3(new Color(224, 185, 0), "0.6"),
        R4(new Color(204, 170, 0), "0.8"),
        R5(new Color(105, 252, 105), "1"),
        R6(new Color(30, 243, 30), "1.5"),
        R7(new Color(0, 213, 0), "2"),
        R8(new Color(0, 164, 0), "2.5"),
        R9(new Color(0, 128, 0), "3"),
        R10(new Color(135, 217, 255), "3.5"),
        R11(new Color(62, 193, 255), "4"),
        R12(new Color(7, 171, 255), "4.5"),
        R13(new Color(0, 141, 222), "5"),
        R14(new Color(0, 119, 179), "5.5"),
        R15(new Color(179, 180, 222), "6"),
        R16(new Color(128, 129, 199), "6.5"),
        R17(new Color(76, 78, 177), "7"),
        R18(new Color(31, 33, 157), "8"),
        R19(new Color(0, 3, 144), "9"),
        R20(new Color(218, 135, 255), "10"),
        R21(new Color(194, 62, 255), "15"),
        R22(new Color(173, 7, 255), "20"),
        R23(new Color(146, 0, 228), "25"),
        R24(new Color(127, 0, 191), "30"),
        R25(new Color(250, 133, 133), "35"),
        R26(new Color(246, 62, 62), "40"),
        R27(new Color(238, 11, 11), "45"),
        R28(new Color(213, 0, 0), "50"),
        R29(new Color(191, 0, 0), "55"),
        R30(new Color(51, 51, 51), "75");


        private final Color color;
        private final String value;

        E_IDFE_WS(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_SWH {
        R0(new Color(255, 234, 110), "0"),
        R1(new Color(251, 219, 23), "0.5"),
        R2(new Color(234, 198, 0), "1"),
        R3(new Color(207, 176, 0), "1.5"),
        R4(new Color(110, 249, 104), "2"),
        R5(new Color(30, 232, 22), "2.5"),
        R6(new Color(6, 186, 0), "3"),
        R7(new Color(4, 134, 0), "3.5"),
        R8(new Color(138, 216, 255), "4"),
        R9(new Color(54, 185, 255), "4.5"),
        R10(new Color(11, 153, 239), "5"),
        R11(new Color(5, 122, 191), "5.5"),
        R12(new Color(178, 180, 221), "6"),
        R13(new Color(117, 116, 194), "6.5"),
        R14(new Color(55, 55, 167), "7"),
        R15(new Color(9, 11, 148), "7.5"),
        R16(new Color(215, 136, 255), "8"),
        R17(new Color(184, 51, 254), "8.5"),
        R18(new Color(155, 7, 243), "9"),
        R19(new Color(128, 2, 200), "9.5"),
        R20(new Color(245, 136, 133), "10"),
        R21(new Color(237, 54, 50), "10.5"),
        R22(new Color(218, 10, 6), "11"),
        R23(new Color(182, 4, 0), "11.5"),
        R24(new Color(51, 51, 51), "12");


        private final Color color;
        private final String value;

        E_IDFE_SWH(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_LGT {
        R0(new Color(255, 255, 255), "0"),
        R1(new Color(255, 204, 0), "1"),
        R2(new Color(225, 125, 0), "2"),
        R3(new Color(200, 51, 0), "3");


        private final Color color;
        private final String value;

        E_IDFE_LGT(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_LGT_ODAM {
        R0(new Color(255, 255, 255), "0"),
        R1(new Color(255, 201, 36), "1"),
        R2(new Color(223, 204, 34), "2"),
        R3(new Color(191, 208, 32), "3"),
        R4(new Color(160, 211, 29), "4"),
        R5(new Color(97, 195, 86), "5"),
        R6(new Color(64, 202, 158), "6"),
        R7(new Color(49, 180, 191), "7"),
        R8(new Color(34, 157, 224), "8"),
        R9(new Color(75, 127, 225), "9"),
        R10(new Color(117, 98, 227), "10"),
        R11(new Color(224, 54, 54), "40"),
        R12(new Color(153, 153, 153), "70"),
        R13(new Color(51, 51, 51), "100");


        private final Color color;
        private final String value;

        E_IDFE_LGT_ODAM(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }

    public enum E_IDFE_DIFF {
        R0(new Color(0, 0, 255), "-50"),
        R1(new Color(255, 255, 255), "0"),
        R2(new Color(0, 255, 0), "50");


        private final Color color;
        private final String value;

        E_IDFE_DIFF(Color color, String value) {
            this.color = color;
            this.value = value;
        }

        public Color getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }
    }
}