package com.varsol.math.controllers;

import com.varsol.math.models.NNumber;
import com.varsol.math.models.ZNumber;

/**
 * Created by simon on 21.03.17.
 */
public class ZController {

    public static NNumber ABS_Z_N(ZNumber number){
        return null;
    }

    public static Integer POZ_Z_D(ZNumber number){
        if (number.getsign() == -1)
            return 1;
        if ((number.getNumber().getElderPosition() == 1) && (number.getNumber().get(0) == 0))
            return 0;
        else
        return 2;
    }

    public static ZNumber MUL_ZM_Z(ZNumber number){
        return null;
    }

    public static ZNumber TRANS_N_Z(NNumber number) {
        return null;
    }

    public static NNumber TRANS_Z_N(ZNumber number){
        return null;
    }

    public static ZNumber ADD_ZZ_Z(ZNumber first, ZNumber second){
        return null;
    }

    public static ZNumber SUB_ZZ_Z(ZNumber first, ZNumber second){
        return null;
    }

    public static ZNumber MUL_ZZ_Z(ZNumber first, ZNumber second) {
        return null;
    }

    public static NNumber DIV_ZZ_Z(ZNumber first, ZNumber second) {
        return null;
    }

    public static NNumber MOD_ZZ_Z(ZNumber first, ZNumber second) {
        return null;
    }

}
