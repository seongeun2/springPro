package ch06.board;

public class ReadArticleServiceImpl implements ReadArticleService{
	private ArticleDao articleDao;
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	@Override
	public Article read(Integer id) {
		System.out.printf("ReadArticleServicleImpl.read(%d) »£√‚µ \n", id);
		return articleDao.selectById(id);
	}


}
