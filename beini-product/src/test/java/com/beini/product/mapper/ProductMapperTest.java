package com.beini.product.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.beini.product.entity.Product;

public class ProductMapperTest {
	@Test
	public void tes1() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
			Product product = mapper.findById("22");
			System.out.println(product);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession = null;
			}
		}
	}
}
