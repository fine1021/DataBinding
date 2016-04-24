package com.yxkang.android.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by fine on 2016/4/24.
 */
public class User extends BaseObservable {

    private String firstName;
    private String lastName;
    private int age;
    private String describe;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(com.yxkang.android.databinding.BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(com.yxkang.android.databinding.BR.lastName);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(com.yxkang.android.databinding.BR.age);
    }

    @Bindable
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
        notifyPropertyChanged(com.yxkang.android.databinding.BR.describe);
    }
}
