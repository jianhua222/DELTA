package com.example.allen.delta;
import java.util.List;

/**
 * Created by Allen on 9/24/2016.
 */

public class TSA_Class {
    private List<waitTime> WaitTimeResult;

    public List<waitTime> getWaitTime(){ return WaitTimeResult;}

    public class WaitTimeResult{
        private List<waitTime> waitTime;
        public List<waitTime> getWaitTime(){ return waitTime;}
    }

    public class waitTime{
        private String waitTime;
        public String getWaittime(){ return waitTime;}
    }

}
