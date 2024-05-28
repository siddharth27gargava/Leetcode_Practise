class Solution {
    	public long minimumHealth(int[] damages, int armor) {
		long totalDamage = 0, maxDamage = Integer.MIN_VALUE;

		for (int damage : damages) {
			maxDamage = Math.max(maxDamage, damage);
			totalDamage += damage;
		}

		return totalDamage - Math.min(maxDamage, armor) + 1;
	}
}