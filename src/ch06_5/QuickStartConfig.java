package ch06_5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ch06.board.ArticleDao;
import ch06.board.MemoryArticleDao;
import ch06.board.ReadArticleServiceImpl;
import ch06.board.WriteArticleServiceImpl;
import ch06.member.MemberServiceImpl;
import ch06_1.UpdateMemberInfoTraceAspect;
import ch06_4.ArticleCacheAspect;
import ch06_4.ProfilingAspect;

@Configuration
@EnableAspectJAutoProxy
public class QuickStartConfig {
	@Bean
	public ProfilingAspect performanceTraceAspect() {
		return new ProfilingAspect();
	}
	@Bean
	public UpdateMemberInfoTraceAspect memberInfoTraceAspect() {
		return new UpdateMemberInfoTraceAspect();
	}
	@Bean
	public ArticleCacheAspect cache() {
		return new ArticleCacheAspect();
	}
	@Bean
	public ArticleDao articleDao() {
		return new MemoryArticleDao();
	}
	@Bean
	public WriteArticleServiceImpl writeArticleService() {
		return new WriteArticleServiceImpl(articleDao());
	}
	@Bean
	public MemberServiceImpl memberService() {
		return new MemberServiceImpl();
	}
	@Bean
	public ReadArticleServiceImpl readArticleService() {
		ReadArticleServiceImpl svc = new ReadArticleServiceImpl();
		svc.setArticleDao(articleDao());
		return svc;
	}
}
