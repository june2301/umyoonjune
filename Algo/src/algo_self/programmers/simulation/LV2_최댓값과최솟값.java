package algo_self.programmers.simulation;

class LV2_최댓값과최솟값 {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        String answer = min + " " + max + "";
        return answer;
    }
}

/**
 * 시뮬레이션
 * [문제]
 * 문자열로 주어진 숫자들의 "최솟값 최댓값" 형태로 return하시오.
 * 
 * min, max를 초기화해 둔 후
 * 주어진 문자열을 정수로 바꾸며 최솟값과 최댓값 초기화 후
 * 문자열로 만들어 return
 */

