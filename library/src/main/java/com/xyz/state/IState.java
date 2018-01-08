package com.xyz.state;

/**
 * 2018/1/5.
 */
public interface IState {
    void empty();
    void retry();
    void load();
    void content();
}
