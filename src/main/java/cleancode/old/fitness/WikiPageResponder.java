package cleancode.old.fitness;



/**
 * WikiPageResponder
 * 注意【模块的可读性】
 * 顶部函数是如何调用其下的函数，这些函数又是如何调用更下面的函数
 * 【把常量保持在恰当的级别】
 *
 * @author Alicia
 * @description
 * @date 2020/6/10
 */
public class WikiPageResponder implements SecureResponder{
    protected WikiPage page;
    protected PageData pageData;
    protected String pageTitle;
    protected Request request;
    protected PageCrawler crawler;

    public Response makeResponse(FitNesseContext context, Request request) throws Exception{
        String pageName = getPageNameOrDefault(request, "FrontPage");
        loadPage(pageName, context);
        if (page == null) {
            return notFoundResponse(context, request);
        }else {
            return makePageResponse(context);
        }
    }

    private String getPageNameOrDefault(Request request, String defaultPageName){
        String pageName = request.getResource();
        if (StringUtil.isBlank(pageName)) {
            pageName = defaultPageName;
        }
        return pageName;
    }

    protected void loadPage(String resource, FitNesseContext context) throws Exception{
        WikiPagePath path = PathParser.parse(resource);
        crawler = context.root.getPageCrawler();
        crawler.setDeadEndStrategy(new VirtualEnabledPageCrawler());
        page = crawler.getPage(context.root, path);
        if (page != null) {
            pageData = page.getData();
        }
    }

    private Response notFoundResponse(FitNesseContext context, Request request) throws Exception{
        return new NotFoundResponder().makeResponse(context, request);
    }

    private SimpleResponse makePageResponse(FitNesseContext context) throws Exception{
        pageTitle = PathParser.render(crawler.getFullPath(page));
        String html = makeHtml(context);

        SimpleResponse response = new SimpleResponse();
        response.setMaxAge(0);
        response.setContent(html);
        return response;
    }

    private String makeHtml(FitNesseContext context) {
        return "";
    }
}
