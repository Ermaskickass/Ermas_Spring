package org.Ermas.jdbc.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

	@Autowired
	ArticleDao articleDao;

	/**
	 * 글 목록
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	public void addArticle() {
		Article article = new Article();
		article.setTitle("‘SNS 스타’ 대기업 외손녀 마약범죄 연루로 몰락");
		article.setContent("재력과 미모를 바탕으로 평범한 사람들이 보기에 화려한 삶을 누린 황하나(31)씨가 ‘마약범죄 피의자’로 전락했다.");
		article.setUserId("29");
		article.setName("황윤성");
		if (articleDao.addArticle(article) > 0)
			System.out.println("글을 추가했습니다.");
		else
			System.out.println("글을 추가하지 못했습니다.");
	}

	/**
	 * 글 수정
	 */
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("7");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("글을 수정했습니다.");
		else
			System.out.println("글을 수정하지 못했습니다.");
	}

	/**
	 * 글 삭제
	 */
	public void deleteArticle() {
		if (articleDao.deleteArticle("8") > 0)
			System.out.println("글을 삭제했습니다.");
		else
			System.out.println("글을 삭제하지 못했습니다.");
	}
}

