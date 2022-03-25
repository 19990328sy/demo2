package com.example.demo.util;

/***
 *功能描述
 * @author shaoyu
 * @date 2022/3/23
 * @return
 * @Description :
 */

public class FileException extends RuntimeException{

    public FileException(String message){
        super(message); ;
    }

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param message
     * @param cause
     * @return
     * @Description :
     */


    public FileException(String message,Throwable cause){
        super(message,cause);
    }

}
