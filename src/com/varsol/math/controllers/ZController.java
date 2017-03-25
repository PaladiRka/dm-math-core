package com.varsol.math.controllers;

import com.varsol.math.models.NNumber;
import com.varsol.math.models.ZNumber;

/**
 * Created by simon on 21.03.17.
 */
public class ZController {

    public static NNumber ABS_Z_N(ZNumber number){
        //	Абсолютная величина числа, результат - натуральноe 
        return number.getNumber();
    }

    public static Integer POZ_Z_D(ZNumber number){
        /*Определение положительности числа (2 - положительное, 0 — равное нулю, 1 - отрицательное)*/
        if (number.getSign() == -1){ // если отрицательное
            return 1;
        }
        if ((number.getNumber().getElderPosition() == 1) && (number.getNumber().get(0) == 0)){ // если равно 0
            return 0;
        }
        else{ // если не отрицательное и не равно нулю => положительное
        return 2;
        }
    }

    public static ZNumber MUL_ZM_Z(ZNumber number){
        //Умножение целого на (-1)
        number.setSign(number.getSign()*(Integer)(-1));
        return number;
    }

    public static ZNumber TRANS_N_Z(NNumber number) {
        //Преобразование натурального в целое
        ZNumber result;
        result.setNumber(number);
        result.setSign(1);
        return result;
    }

    public static NNumber TRANS_Z_N(ZNumber number){
        //Преобразование целого неотрицательного в натуральное
        if (number.getSign() > (Integer) 0){
           return number.getNumber(); 
        }
        return NULL;
    }

    public static ZNumber ADD_ZZ_Z(ZNumber first, ZNumber second){
        //Сложение целых чисел   
        
        return null;
    }

    public static ZNumber SUB_ZZ_Z(ZNumber first, ZNumber second){
        //Вычитание целых чисел
        return null;
    }

    public static ZNumber MUL_ZZ_Z(ZNumber first, ZNumber second) {
        //Умножение целых чисел
        ZNumber result;
        if ((first.getSign() == -1)^(second.getSign() == -1)){
            result.setSign(-1);
        }
        else{
            result.setSign(1);
        }
        result.getNumber(MUL_NN_N(first.getNumber(),second.getNumber()));
            
        return result;
    }

    public static NNumber DIV_ZZ_Z(ZNumber first, ZNumber second) {
        //Частное от деления большего целого числа на меньшее или равное натуральное с остатком (делитель отличен от нуля)
        ZNumber result;
        if ((first.getSign() == -1)^(second.getSign() == -1)){
            result.setSign(-1);
        }
        else{
            result.setSign(1);
        }
        result.getNumber(DIV_NN_N(first.getNumber(),second.getNumber()));
            
        return result;
    }

    public static NNumber MOD_ZZ_Z(ZNumber first, ZNumber second) {
        //Остаток от деления большего целого числа на меньшее или равное натуральное с остатком (делитель отличен от нуля)
                ZNumber result;
        if ((first.getSign() == -1)^(second.getSign() == -1)){
            result.setSign(-1);
        }
        else{
            result.setSign(1);
        }
        result.getNumber(MOD_NN_N(first.getNumber(),second.getNumber()));
            
        return result;
    }

}
