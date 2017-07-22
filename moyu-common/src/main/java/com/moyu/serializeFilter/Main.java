package com.moyu.serializeFilter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by XianGuo
 * Date: 2017-07-12 18:10
 */
public class Main {

    public static void main(String[] args){
        Person person = new Person();
        person.setPersonName("张三");
        person.setPersonAge("21");
        person.setPersonNameAgeMemo("哈哈");
        System.out.println(JSONObject.toJSON(person));

        String s = JSONObject.toJSONString(person,new HumpToUnderline());
        Person person2 = JSON.parseObject(s,Person.class);
        System.out.println("字符串"+s+"person2"+JSONObject.toJSONString(person));
    }

    public static class Person{
        private String personName;
        private String personAge;
        private String personNameAgeMemo;

        public String getPersonNameAgeMemo() {
            return personNameAgeMemo;
        }

        public void setPersonNameAgeMemo(String personNameAgeMemo) {
            this.personNameAgeMemo = personNameAgeMemo;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getPersonAge() {
            return personAge;
        }

        public void setPersonAge(String personAge) {
            this.personAge = personAge;
        }
    }
}
