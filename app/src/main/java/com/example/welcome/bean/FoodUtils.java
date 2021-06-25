package com.example.welcome.bean;

import com.example.welcome.R;

import java.util.ArrayList;
import java.util.List;

public class FoodUtils {
    private static final String[] food = {"酸奶","牛奶","白粥","蜂蜜柠檬水","豆浆",
            "苹果","鸡蛋","香蕉","米饭","番茄"};
    private static final String[] calorie = {"70","65","58","10","31",
            "53","139","93","116","15"};
    private static final int[] resId = {R.drawable.yogurt, R.drawable.milk,R.drawable.porridge,R.drawable.hydromel,R.drawable.soybean_milk,
    R.drawable.apple,R.drawable.mantou,R.drawable.banana,R.drawable.rice,R.drawable.tomato};
    private static final String[] desc = {"空腹大量饮用酸奶不利健康，饭后两小时左右，人的胃液被稀释，这时喝酸奶，对吸收其中的营养最有利。","不空腹喝牛奶，不大口喝牛奶。在饮用牛奶时如果能够小口慢饮，会使牛奶中的蛋白质和体内的胃酸充分接触，形成细小的凝块，有利于消化吸收。","白粥有清理胃肠、润泽肝腑、平肝散火的效果、如果是受得了清凉的青壮年，吃白粥的时候可以配合一些生菜，效力更好。","蜂蜜柠檬水，是以蜂蜜、柠檬为主要原料制成的饮品。口感酸甜，具有生津、减肥、止渴、祛暑、养颜、美容、美白等功效。","豆浆不能冲入鸡蛋。鸡蛋中的鸡蛋清会与豆浆里的胰蛋白酶结合，产生不易被人体吸收的物质。",
            "苹果含有较多的钾，能与人体过剩的钠盐结合，使之排出体外。而苹果籽更被誉为“生命之库”，营养成分更是果肉的10倍以上。","煮鸡蛋营养丰富，营养吸收率高，也正因此，在能给人体提供丰富、优质的营养的同时，过多食用则不利于健康，导致如营养过剩、消化不良、心脑血管病等。","香蕉延年益寿，老少皆宜，是减肥者的首选。其适宜发热、口干烦渴、喉癌、大便干燥难解、痔疮、肛裂、大便带血、癌症病人及放疗、化疗后食用；适宜上消化道溃疡、肺结核、顽固性干咳者食用。","一般人皆可食用，糖尿病患者不宜多食。","番茄红素具有很强的抗氧化能力，有保护肝脏、营养心肌、降低血压的作用。有清热解毒、利尿通便、帮助消化的功效。"};

    //数据源的生成
    public static List<FoodBean> getAllFoodList(){
        List<FoodBean>list = new ArrayList<>();

        //遍历标题
        for(int i = 0 ; i <food.length ; i++){
            FoodBean bean = new FoodBean(food[i], calorie[i], desc[i],resId[i]);
            //将数据添加到集合中
            list.add(bean);
        }
        return list;
    }
}
