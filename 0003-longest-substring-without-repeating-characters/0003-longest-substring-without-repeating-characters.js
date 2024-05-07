/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
        let left = 0;
        let right = 0;
        let max = 0;

        const set = new Set();

        while (right < s.length) {
            if (!set.has(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                set.delete(s.charAt(left));
                left++;
            }
        }

        return max;
    };