package com.easyhood.testapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 功能：
 * 详细描述：
 * 作者：guan_qi
 * 创建日期：2023-07-17
 */
public class ReModel {

    @SerializedName("code")
    public int status;

    @SerializedName("msg")
    public String msg;

    @SerializedName("data")
    public List data;
}
