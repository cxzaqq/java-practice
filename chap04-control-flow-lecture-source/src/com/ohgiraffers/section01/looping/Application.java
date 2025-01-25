package com.ohgiraffers.section01.looping;

public class Application {
    public static void main(String[] args) {

        A_for aClass = new A_for();
//        aClass.testSimpleForStatement();
//        aClass.testForExample();
//        aClass.testForExample2();

        B_nestedFor bClass = new B_nestedFor();
//        bClass.printGugudanFromTwoToNine();
        bClass.printStar();

        C_while cClass = new C_while();
        cClass.testSimpleWhileStatement();
    }
}
