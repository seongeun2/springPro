package ch06_4;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch06.board.Article;
import ch06.board.NewArticleRequest;
import ch06.board.ReadArticleService;
import ch06.board.WriteArticleService;
import ch06.member.MemberRegRequest;
import ch06.member.MemberService;
import ch06.member.UpdateInfo;

@Aspect
public class AspectAll {
	private Map<Integer, Article> cache = new HashMap<Integer, Article>();
	
	@Around("execution(public * *..ReadArticleService.*(..))")
	public Article cache(ProceedingJoinPoint joinPoint) throws Throwable{
		Integer id = (Integer) joinPoint.getArgs()[0];
		Article article = cache.get(id);
		if(article != null) {
			System.out.println("[ACA] 캐시에서 Article[" + id + "] 구함");
			return article;
		}
		Article ret = (Article) joinPoint.proceed();
		if(ret != null) {
			cache.put(id, ret);
			System.out.println("[ACA] 캐시에 Article[" + id + "] 추가함");
		}
		return ret;
	}
	
	@Pointcut("execution(public * ch06.board..*(..))")
	private void profileTarget() {
	}
	
	@Around("profileTarget()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + " 시작 ");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		}finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료 ");
			System.out.println(signatureString + "실행시간 : " + (finish - start) + "ms");
		}
	}
}
