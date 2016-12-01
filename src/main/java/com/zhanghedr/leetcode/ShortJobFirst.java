package com.zhanghedr.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A processor is processing requests.
 * It can only process one request at a time.
 * It executes the shortest job first. 
 * If execute time is same then execute the first arrival one.
 * The sequences of arrival times and execute times are given.
 * Calculate the average wait time.
 * 
 * @author hezha_000
 *
 */
public class ShortJobFirst {

	private static class Process {
		public int reqTime;
		public int exeTime;

		public Process(int reqTime, int exeTime) {
			this.reqTime = reqTime;
			this.exeTime = exeTime;
		}
	}

	public static float shortJobFirst(int[] reqs, int[] exes) {
		if (reqs == null || exes == null || reqs.length != exes.length)
			return 0;
		Queue<Process> queue = new PriorityQueue<>(new Comparator<Process>() {
			@Override
			public int compare(Process p1, Process p2) {
				if (p1.exeTime == p2.exeTime)
					return p1.reqTime - p2.reqTime;
				return p1.exeTime - p2.exeTime;
			}
		});
		int i = 0, curTime = 0, waitTime = 0;
		while (i < reqs.length || !queue.isEmpty()) {
			if (!queue.isEmpty()) {
				Process p = queue.poll();
				waitTime += curTime - p.reqTime;
				curTime += p.exeTime;
				while (i < reqs.length && reqs[i] <= curTime) {
					queue.offer(new Process(reqs[i], exes[i]));
					i++;
				}
			} else {
				queue.offer(new Process(reqs[i], exes[i]));
				curTime = reqs[i++];
			}
		}
		return (float) waitTime / reqs.length;
	}
}
