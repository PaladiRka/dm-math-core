package com.varsol.math.controllers;

import com.varsol.math.models.NNumber;
import com.varsol.math.models.ZNumber;

/**
 * Created by simon on 21.03.17.
 */
public class ZController {

    public static NNumber ABS_Z_N(ZNumber number){
        //	Абсолютная величина числа, результат - натуральноe 
        // Просто вернём натуральную составляющую числа
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
        // Умножим только знак на (-1)
        number.setSign(number.getSign()*(Integer)(-1));
        return number;
    }

    public static ZNumber TRANS_N_Z(NNumber number) {
        //Преобразование натурального в целое
        //Просто создаём новое целое с положительным знаком
        ZNumber result;
        result.setNumber(number);
        result.setSign(1);
        return result;
    }

    public static NNumber TRANS_Z_N(ZNumber number){
        //Преобразование целого неотрицательного в натуральное
        //Проверяем знак целого
        if (number.getSign() > (Integer) 0){
           return number.getNumber(); //Если положителен то возвращаем его натуральную составляющую
        }else{
        return NULL; // Если нет то возвращаем NULL
        }
    }

    public static ZNumber ADD_ZZ_Z(ZNumber first, ZNumber second){
        //Сложение целых чисел   
        ZNumber result;
        result.setSign(1);
        if ((POZ_Z_D(first) < 1) == (POZ_Z_D(second) < 1)){ // Если знаки одинаковы, то мы складываем их модули
            result.setNumber(ADD_NN_N(first,second));
            if (POZ_Z_D(first) == 2){ // Если хотя бы одно число отрицательно, то делаем отрицательным наш результат
                MUL_ZM_Z(result);
            }
        }else{
                if (COM_NN_D(ABS_Z_N(first), ABS_Z_N(second)) < 2){ //Сделаем так что бы first было больше по модолю чем second
                result = second;     // Так как result пока нам не нужно,
                second = first;     // и что бы не заводить новую переменную
                first = result;    // используем её как буфер обмена
                }
                result.setNumber(SUB_NN_N(ABS_Z_N(first), ABS_Z_N(second)));  
                result.setSign(first.getSign());
            }
        return result;
    }

    public static ZNumber SUB_ZZ_Z(ZNumber first, ZNumber second){
        //Вычитание целых чисел
        // Полностью повторяем алгоритм для сложения но предварительно умножаем second на минус 1
        ZNumber result;
        result.setSign(1);
        MUL_ZM_Z(second);
        // Тут можно было бы вызвать функцию сложения двух целых, но в задании прописанны функции которые надо использовать
        if ((POZ_Z_D(first) < 1) == (POZ_Z_D(second) < 1)){ // Если знаки одинаковы, то мы складываем их модули
            result.setNumber(ADD_NN_N(first,second));
            if (POZ_Z_D(first) == 2){ // Если хотя бы одно число отрицательно, то делаем отрицательным наш результат
                MUL_ZM_Z(result);
            }
        }else{
                if (COM_NN_D(ABS_Z_N(first), ABS_Z_N(second)) < 2){ //Сделаем так что бы first было больше по модолю чем second
                result = second;     // Так как result пока нам не нужно,
                second = first;     // и что бы не заводить новую переменную
                first = result;    // используем её как буфер обмена
                }
                result.setNumber(SUB_NN_N(ABS_Z_N(first), ABS_Z_N(second)));  
                result.setSign(first.getSign());
            }
        return result;
    }

    public static ZNumber MUL_ZZ_Z(ZNumber first, ZNumber second) {
        //Умножение целых чисел
        ZNumber result;
        result.setSign(1);
        if ((POZ_Z_D(first) < 2) ^ (POZ_Z_D(second) < 2)){ // Если знаки разные то у результата будет отрицательный знак
            MUL_ZM_Z(result);
        }
        result.getNumber(MUL_NN_N(ABS_Z_N(first),ABS_Z_N(second)));
            
        return result;
    }

    public static ZNumber DIV_ZZ_Z(ZNumber first, NNumber second) {
        // Частное от деления большего целого числа на меньшее или равное натуральное с остатком (делитель отличен от нуля)
        // И кстати, по заданию мы получаем целое и натрульное, хотя судя по названию модуля получаем два целых...
        ZNumber result;
        result.setNumber(DIV_NN_N(ABS_Z_N(first),second)); 
        if (POZ_Z_D(first) == 1){ // Если целое отрицательное то частное увеличиваем на одни (по правилам деления с остатков отрицательных)
            result.setNumber(ADD_1N_N(result.getNumber()));
        }
        if ((POZ_Z_D(first) < 2) ^ (POZ_Z_D(second) < 2)){
            result.setSign(-1); //и делаем частное отрицательным
        } else { 
            result.setSign(1); // иначе положительным
        }
        return result;
    }

    public static NNumber MOD_ZZ_Z(ZNumber first, NNumber second) {
        //Остаток от деления большего целого числа на меньшее или равное натуральное с остатком (делитель отличен от нуля)
        //Что бы приступить к этой надо разобраться с функцией DIV так как там по моему мнению не состыковки
        NNumber result;
        result.getNumber(SUB_ZZ_Z(first,MUL_ZZ_Z(second,DIV_ZZ_Z(first,second))));
        // В строке выше реализованно выражение (first-second*DIV(first,second)))
        //где здесь нужно умножение на минус один как прописанно у Позднякова, я не знаю
        return result;
    }

}
