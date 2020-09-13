package 基础算法.day01.topk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wangxi created on 2020/6/3 3:01 PM
 * @version v1.0
 *	获取 topk的元素。
 *
 * 业务：获取销量topk的产品
 */
public class TopKFrequent {
	public List<String> topK(String[] words, int k) {
		// Step 1  统计每个元素的次数
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			Integer count = map.getOrDefault(word, 0);
			count++;
			map.put(word, count);
		}

		// Step 2
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k+1, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				if(e1.getValue().equals(e2.getValue())) {
					return e2.getKey().compareTo(e1.getKey());
				}
				// 小到大进行排序. 堆顶是最小元素
				return e1.getValue().compareTo(e2.getValue());
			}
		});

		// Step 3
		List<String> res = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			minHeap.offer(entry);
			if(minHeap.size() > k) {
				// 弹出堆顶最小的元素
				minHeap.poll();
			}
		}
		while(!minHeap.isEmpty()) {
			res.add(minHeap.poll().getKey());
		}
		Collections.reverse(res);
		return res;
	}

	public static void main(String[] args) {
		String[] words = "I love leetcode I love coding I I leetcode leetcode leetcode leetcode"
				.split(" ");
		TopKFrequent topKFrequent = new TopKFrequent();
		System.out.println(topKFrequent.topK(words, 2));
	}
}
