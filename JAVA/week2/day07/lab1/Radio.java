package com.shinhan.day07.lab1;

public class Radio implements Volume {
	int VolLevel;
	
	@Override
	public void volumeUp(int level) {
		VolLevel += level;
		System.out.println(getClass().getSimpleName() + "볼륨 올립니다." + VolLevel);
	}

	@Override
	public void volumeDown(int level) {
		VolLevel -= level;
		System.out.println(getClass().getSimpleName() + "볼륨 올립니다." + VolLevel);
	}

}
