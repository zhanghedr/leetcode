package com.zhanghedr.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author hezha_000
 *
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length <= 1)
			return new int[0];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int key = target - nums[i];
			if (map.containsKey(key))
				return new int[] { map.get(key), i };
			map.put(nums[i], i);
		}
		return new int[0];
	}
}
