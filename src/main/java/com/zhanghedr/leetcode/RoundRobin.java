package com.zhanghedr.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A processor is processing requests.
 * It can only process one request at a time.
 * Each request can be executed no more than maxExe time.
 * If one request is not finished by maxExe, then put it to queue tail.
 * The sequences of arrival times and execute times are given.
 * Calculate the average wait time.
 * 
 * @author hezha_000
 *
 */
public class RoundRobin {

    private class Process {
        public int reqTime;
        public int exeTime;

        public Process(int reqTime, int exeTime) {
            this.reqTime = reqTime;
            this.exeTime = exeTime;
        }
    }

    public float roundRobin(int[] reqs, int[] exes, int maxExe) {
        if (reqs == null || exes == null || reqs.length != exes.length)
            return 0;
        Queue<Process> queue = new LinkedList<>();
        int i = 0, curTime = 0, waitTime = 0;
        while (i < reqs.length || !queue.isEmpty()) {
            if (!queue.isEmpty()) {
                Process p = queue.poll();
                waitTime += curTime - p.reqTime;
                curTime += Math.min(p.exeTime, maxExe);
                while (i < reqs.length && reqs[i] <= curTime) {
                    queue.offer(new Process(reqs[i], exes[i]));
                    i++;
                }
                if (p.exeTime > maxExe)
                    queue.offer(new Process(curTime, p.exeTime - maxExe));
            } else {
                queue.offer(new Process(reqs[i], exes[i]));
                curTime = reqs[i++];
            }
        }
        return (float) waitTime / reqs.length;
    }
}
