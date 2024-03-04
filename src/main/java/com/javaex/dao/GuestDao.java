package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트
	public List<GuestVo> guestSelect() {

		List<GuestVo> guestList = sqlSession.selectList("guestbook.select");

		System.out.println(guestList);

		return guestList;
	}

	// 추가
	public int guestInsert(GuestVo guestVo) {

		int count = sqlSession.insert("guestbook.insert", guestVo);

		System.out.println(count);

		return count;
	}

	// 삭제
	public int guestDelete(GuestVo guestVo) {

		int count = sqlSession.delete("guestbook.delete", guestVo);
		System.out.println(guestVo);

		return count;
	}

}
