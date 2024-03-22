package com.shinhan.day09.c12_6_reflaction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import com.shinhan.day09.c12_1_objectClass.ComputerVO;

public class ReflactionTest {

	public static void main(String[] args) {
		// 리플렉션
		Class<ComputerVO> cls = ComputerVO.class;
		Constructor<?>[] cons = cls.getDeclaredConstructors();
		for (Constructor<?> cc : cons) {
			System.out.println(cc.getName());
			System.out.println(cc.getParameterCount());

			for (Parameter param : cc.getParameters()) {
				System.out.println(param.getName());
			}

				System.out.println("--------------------------");
		}
	}
}
