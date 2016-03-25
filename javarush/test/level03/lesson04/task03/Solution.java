package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Zerg z1 = new Zerg();
        Zerg z2 = new Zerg();
        Zerg z3 = new Zerg();
        Zerg z4 = new Zerg();
        Zerg z5 = new Zerg();
        Zerg z6 = new Zerg();
        Zerg z7 = new Zerg();
        Zerg z8 = new Zerg();
        Zerg z9 = new Zerg();
        Zerg z10 = new Zerg();

        Protos p1 = new Protos();
        Protos p2 = new Protos();
        Protos p3 = new Protos();
        Protos p4 = new Protos();
        Protos p5 = new Protos();

        Terran t1 = new Terran();
        Terran t2 = new Terran();
        Terran t3 = new Terran();
        Terran t4 = new Terran();
        Terran t5 = new Terran();
        Terran t6 = new Terran();
        Terran t7 = new Terran();
        Terran t8 = new Terran();
        Terran t9 = new Terran();
        Terran t10 = new Terran();
        Terran t11 = new Terran();
        Terran t12 = new Terran();

        z1.name = "r3rtrte";
        z2.name = "r3rtr5645te";
        z3.name = "r3yjhetyjrtrte";
        z4.name = "r3rtfghrte";
        z5.name = "r3rtr4564te";
        z6.name = "r3rtfghfrte";
        z7.name = "r3rtrfnfbnte";
        z8.name = "r3rtr456t5e";
        z9.name = "r3rbnmvtrte";
        z10.name = "r3rtr4564te";

        p1.name =  "ergetgefghfhtg";
        p2.name =  "ergetge456456tg";
        p3.name =  "er356364getgetg";
        p4.name =  "ergetge4535tg";
        p5.name =  "ergetgemgmbtg";

        t1.name = "3453ggghghhf";
        t2.name = "3453g345hf";
        t3.name = "3453ghngmnf";
        t4.name = "3453g453hf";
        t5.name = "3453gfgdghf";
        t6.name = "3453jkhkghf";
        t7.name = "345asd3ghf";
        t8.name = "3453gdfsfghf";
        t9.name = "3453ghjgmhf";
        t10.name = "3453g3563hf";
        t11.name = "345csf3ghf";
        t12.name = "3453gghruhf";


    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}