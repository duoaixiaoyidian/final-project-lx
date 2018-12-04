package com.baizhi.controller;


public class TestEnum {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i*2);*/
        Season winter = Season.WINTER;
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value.name() + value.ordinal() + " " + value.getName());
        }
        System.out.println(winter.name());
        System.out.println(winter.ordinal());//下标
    }

}

enum Season {//枚举里的方法都是私有的
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");  //;代表定义枚举值结束
    String name;

    private Season(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}

