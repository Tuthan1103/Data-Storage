package com.Presistence;

public class GetData {
    private static String name = "nguen van a";
    private static String address = "truong trinh";
    private static String id = "02323624242442";
    private static String phone_number = "001023232445";
        
    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        GetData.name = name;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        GetData.address = address;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        GetData.id = id;
    }

    public static String getPhone_number() {
        return phone_number;
    }

    public static void setPhone_number(String phone_number) {
        GetData.phone_number = phone_number;
    }

    public static String getData(){
        return (name + address+  id + phone_number);
    }
}
