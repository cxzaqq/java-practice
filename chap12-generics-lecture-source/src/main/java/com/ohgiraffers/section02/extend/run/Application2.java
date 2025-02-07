package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.vo.Bunny;
import com.ohgiraffers.section02.extend.vo.DrunkenBunny;
import com.ohgiraffers.section02.extend.vo.Rabbit;
import com.ohgiraffers.section02.extend.vo.RabbitFarm;
import com.ohgiraffers.section02.extend.vo.WildCardFarm;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 와일드카드에 대해 이해할 수 있다. */
        WildCardFarm wildCardFarm = new WildCardFarm();
        wildCardFarm.anyType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        wildCardFarm.extendsType(new RabbitFarm<Bunny>(new Bunny()));
//        wildCardFarm.extendsType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
//        wildCardFarm.extendsType(new RabbitFarm<Rabbit>(new Rabbit()));

        wildCardFarm.superType(new RabbitFarm<Bunny>(new Bunny()));
//        wildCardFarm.superType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
        wildCardFarm.superType(new RabbitFarm<Rabbit>(new Rabbit()));
    }
}
